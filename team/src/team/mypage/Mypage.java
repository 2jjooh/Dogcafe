package team.mypage;

import team.DB.TeamDAO;
import team.login.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mypage extends JFrame {
	
	JLabel mypage=new JLabel();
	JButton coupon=new JButton();
	JButton history=new JButton();
	JButton minigame=new JButton();
	JButton back=new JButton();

	ImageIcon coupongImg= new ImageIcon(".\\src\\image/cu11.png");
	ImageIcon historyImg= new ImageIcon(".\\src\\image/hi11.png");
	ImageIcon gameImg= new ImageIcon(".\\src\\image/game33.png");
	ImageIcon backImg= new ImageIcon(".\\src\\image/backButton.png");
	ImageIcon backImg2= new ImageIcon(".\\src\\image/backButton(selected).png");
	ImageIcon hImg= new ImageIcon(".\\src\\image/hisimg22.jpg");
	ImageIcon cImg= new ImageIcon(".\\src\\image/cuimg11.jpg");
	ImageIcon mImg= new ImageIcon(".\\src\\image/mimg11.jpg");
	Image backgroundImg;
	
	public Mypage() {
		setTitle("My Page");
		setBounds(800, 0, 800, 1000);

	
		backgroundImg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg21.jpg");
		JPanel background=new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImg, 0, 0,this);
				setOpaque(false);
			}
		};
		
		
	//==============================
		mypage.setOpaque(true);
		mypage.setBackground(Color.pink);
		mypage.setFont(new Font("D2Coding", Font.BOLD, 50));
		mypage.setText("★"+ TeamDAO.getDBID()+"님의 MY PAGE★");//유저 닉네임 불러오기 
		add(mypage,BorderLayout.NORTH);
		
		//================================

		JLabel himg=new JLabel(hImg);
		himg.setBounds(20, 180, 300, 60);

		JButton history=new JButton("주문한 목록",historyImg);
		history.setFont(new Font("D2Coding",Font.BOLD, 20));
		history.setBackground(new Color(255,144,144));
		history.setBounds(380,170, 350, 80);
		history.setFocusPainted(false);

		JLabel cimg = new JLabel(cImg);
		cimg.setBounds(20, 330, 300, 60);
		JButton coupon=new JButton("쿠폰 확인",coupongImg);//쿠폰이미지 크기 확인해서 넣기
		coupon.setFont(new Font("D2Coding",Font.BOLD, 20));
		coupon.setBackground(new Color(255,177,177));
		coupon.setBounds(380,320, 350, 80);//디맨션으로 비율정하기
		coupon.setForeground(Color.black);

		JLabel mimg = new JLabel(mImg);
		mimg.setBounds(20, 480, 300, 60);
		JButton minigame=new JButton("미니게임",gameImg);
		minigame.setFont(new Font("D2Coding",Font.BOLD, 20));
		minigame.setBackground(new Color(255,200,200));
		minigame.setBounds(380,470, 350, 80);
		
		background.add(history);
		background.add(coupon);
		background.add(minigame);
		background.add(cimg);
		background.add(himg);
		background.add(mimg);
		
		JButton back=new JButton(backImg);
		back.setBounds(0,6, 50,50);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		
		background.add(back);
		add(background,BorderLayout.CENTER);
		
	//===============================
		
		history.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				History historyView=new History();
			}
		});
		
		coupon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CouponCheck check = new CouponCheck();
			}
		});
		
		minigame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ShootGame shoot = new ShootGame();
			}
		});;
		
		back.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				back.setIcon(backImg2);
				back.setSelectedIcon(backImg2);
				dispose();
				Icon icon=new Icon();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(backImg2);
				back.setSelectedIcon(backImg2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				back.setIcon(backImg);
				back.setIcon(backImg);
			}
		});
	//================================	
		addWindowListener(new WindowAdapter() {
			@Override                  
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}//생성자 끝
	
	
	
	public static void main(String[] args) {
		Mypage mypage =new Mypage();	
	}//메인 끝	
	
}//클래스 끝
