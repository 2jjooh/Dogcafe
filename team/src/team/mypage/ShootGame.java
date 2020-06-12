package team.mypage;

import team.DB.*;
import team.login.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShootGame extends JFrame implements Runnable, KeyListener {
	BufferedImage bi = null;
	ArrayList msList = null;
	ArrayList enList = null;
	boolean runFlag =true;
	boolean left = false, right = false, up = false, down = false, fire = false;
	boolean start = false, end = false,bufferCheck=false , flag=true;
	int w = 300, h = 500, x = 130, y = 450, xw = 20, xh = 20;
	int score=0,aa=1;
	TeamVO vo=new TeamVO();
	//coupon,coupon2 DB에서 값 바로 받아오기
	int coupon,coupon2;
	JLabel fl = new JLabel();
	Image bg,flimg,enimg;
	
	public ShootGame() {
		coupon = TeamDAO.getDBCoupon();
		coupon2 = TeamDAO.getDBCoupon();
		
		flimg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/fl22.png");
		enimg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/en22.png");
		bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		bg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg22.jpg");
  
  
		msList = new ArrayList();			//미사일 저장시켜주는 리스트 
		enList = new ArrayList();
		
		this.addKeyListener(this);
		this.setResizable(false);
		Thread th = new Thread(this);
		th.start();
		
		this.setTitle("Shooting Game");
		this.setBounds(500, 0, 800, 800);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);  
	}
 
	public void run() {
		try {
			int msCnt = 0;
			int enCnt = 0;
			while(true) {
				while(runFlag) {
				Thread.sleep(10);
				if(start) {
					if(enCnt > 2000) {
						enCreate();
						enCnt = 0;
					}
					if(msCnt >= 100) {
						fireMs();
						msCnt = 0;
					}
					msCnt += 10;
					enCnt += 10;
					keyControl();
					crashChk();
				}
				draw();
				}
			}
		} catch(Exception e) {
		e.printStackTrace();
		}
	}// 런끝


	public void fireMs() {
		if(fire) {
			if(msList.size() < 100) {
				Ms m = new Ms(this.x, this.y);
				msList.add(m);
			}
		}
	}// 미사일발사 끝
 
 
	public void enCreate() {
		for(int i = 0; i < 15; i++) {
			double rx = Math.random() * (w - xw);
			double ry = Math.random() * 190;
			Enemy en = new Enemy((int)rx, (int)ry);
			enList.add(en);
		}
	}// 적 생성
 
	public void crashChk() {
		Graphics g = this.getGraphics();
		Polygon p = null;
		for(int i = 0; i < msList.size(); i++) {
			Ms m = (Ms)msList.get(i);
			for(int j = 0; j < enList.size(); j++) {
				Enemy e = (Enemy)enList.get(j);
				int[] xpoints = {m.x+10, (m.x + m.w), (m.x + m.w), m.x};
				int[] ypoints = {m.y, m.y, (m.y + m.h), (m.y + m.h)};
				p = new Polygon(xpoints, ypoints, 4);
				if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) {
					score++;
					msList.remove(i);
					enList.remove(j);
				}
			}
		}
		for(int i = 0; i < enList.size(); i++) {
			Enemy e = (Enemy)enList.get(i);
			int[] xpoints = {x+10, (x + xw), (x + xw), x};
			int[] ypoints = {y, y, (y + xh), (y + xh)};
			p = new Polygon(xpoints, ypoints, 4);
			if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) {
				enList.remove(i);
				start = false;
				end = true;
			}
		}
	}//충돌 끝
 
	public void draw() {
			 
		Graphics gs = bi.getGraphics();
		if (bufferCheck) {
			gs.dispose();
		}
		gs.drawImage(bg, 0, 0, this);
		gs.setColor(Color.black);
		gs.setFont(new Font("D2Coding",Font.BOLD, 15));
		gs.drawString("현재 쿠폰수 : " +coupon , 180, 50);
		gs.drawString("현재 스코어 : " +score, 180, 70);
		gs.drawString("게임시작 : Enter", 180, 90);
		gs.drawString("게임종료 : ESC", 180, 110);
		gs.drawString("미사일 발사 : A", 180, 130);
		  
		
		if ((score%10==0) && (score != 0)) {
			coupon = coupon2 + (score / 10);	 
		}if (coupon>12) {
			coupon=12;
		}
		 
		  
		if(end) {
			gs.drawString("G A M E     O V E R", 100, 250);
			//DB에 쿠폰 저장하기	
			TeamDAO.saveCoupon(coupon);
			score=0;
		}
		  
		//@@ 비행기 크기
		gs.drawImage(flimg, x, y,xw+10,xh+10, this);
		   
		//미사일 생성
		for(int i = 0; i < msList.size(); i++) {
			Ms m = (Ms)msList.get(i);
			gs.setColor(Color.white);
			gs.drawOval(m.x+10, m.y, m.w, m.h);
			if(m.y < 0) msList.remove(i);
			m.moveMs();
		}
		//적 생성
		gs.setColor(Color.black);
		for(int i = 0; i < enList.size(); i++) {
			Enemy e = (Enemy)enList.get(i);
			gs.drawImage(enimg, e.x, e.y, e.w, e.h, this);
			if(e.y > h) enList.remove(i);
			e.moveEn();
		}
		  
		Graphics ge = this.getGraphics();
		//  if (bufferCheck) {
		//	  ge.dispose();
		//  }
		try {
			ge.drawImage(bi, 0, 0,800, 800,this);
		} catch (Exception e) {
			gs.dispose();
		}
	}//화면 끝
 
	
 public void keyControl() {
  if(0 < x) {
   if(left) x -= 3;
  }
  if(w > x + xw) {
   if(right) x += 3;
  }
  if(25 < y) {
   if(up) y -= 3;
  }
  if(h > y + xh) {
   if(down) y += 3;
  }
 }//키 이동
 
 public void keyPressed(KeyEvent ke) {
  switch(ke.getKeyCode()) {
  case KeyEvent.VK_LEFT:
   left = true;
   break;
  case KeyEvent.VK_RIGHT:
   right = true;
   break;
  case KeyEvent.VK_UP:
   up = true;
   break;
  case KeyEvent.VK_DOWN:
   down = true;
   break;
  case KeyEvent.VK_A:
   fire = true;
   break;
  case KeyEvent.VK_ENTER:
	  coupon=TeamDAO.getDBCoupon();
	  coupon2=TeamDAO.getDBCoupon();
   start = true;
   end = false;
   break;
  case KeyEvent.VK_ESCAPE:
	  bufferCheck=true;
	  runFlag=false;
	  dispose();
	  Mypage mypage=new Mypage();
	  break;
	  
  }
 }
 
 public void keyReleased(KeyEvent ke) {
  switch(ke.getKeyCode()) {
  case KeyEvent.VK_LEFT:
   left = false;
   break;
  case KeyEvent.VK_RIGHT:
   right = false;
   break;
  case KeyEvent.VK_UP:
   up = false;
   break;
  case KeyEvent.VK_DOWN:
   down = false;
   break;
  case KeyEvent.VK_A:
   fire = false;
   break;
  }
 }
 
 public void keyTyped(KeyEvent ke) {}
 
 public static void main(String[] args) {
	 ShootGame shoot=new ShootGame();
	 
//  Thread t = new Thread(shoot);
//  t.start();
 }
}//메인끝

class Ms {
 int x;
 int y;
 int w = 4;
 int h = 4;
 public Ms(int x, int y) {
  this.x = x;
  this.y = y;
 }
 public void moveMs() {
  y-=3;
 }
}//미사일 이동

class Enemy {
 int x;
 int y;
 int w = 50;
 int h = 50;
 public Enemy(int x, int y) {
  this.x = x;
  this.y = y;
 }
 public void moveEn() {
	 Random rd=new Random();
	 if (rd.nextInt()>0) {
		x--;
	}
	 if (rd.nextInt()<0) {
		x++;
	}
  y++;
 } 
}//적 이동
