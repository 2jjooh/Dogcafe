package team.mypage;

import team.DB.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CouponCheck extends JFrame{
	Image backgroundImg;
	ImageIcon backImg= new ImageIcon(".\\src\\image/backButton.png");
	ImageIcon backImg2= new ImageIcon(".\\src\\image/backButton(selected).png");
	ImageIcon c0=new ImageIcon(".\\src\\image/c0.jpg");
	ImageIcon c1=new ImageIcon(".\\src\\image/c1.jpg");
	ImageIcon c2=new ImageIcon(".\\src\\image/c2.jpg");
	ImageIcon c3=new ImageIcon(".\\src\\image/c3.jpg");
	ImageIcon c4=new ImageIcon(".\\src\\image/c4.jpg");
	ImageIcon c5=new ImageIcon(".\\src\\image/c5.jpg");
	ImageIcon c6=new ImageIcon(".\\src\\image/c6.jpg");
	ImageIcon c7=new ImageIcon(".\\src\\image/c7.jpg");
	ImageIcon c8=new ImageIcon(".\\src\\image/c8.jpg");
	ImageIcon c9=new ImageIcon(".\\src\\image/c9.jpg");
	ImageIcon c10=new ImageIcon(".\\src\\image/c10.jpg");
	ImageIcon c11=new ImageIcon(".\\src\\image/c11.jpg");
	ImageIcon c12=new ImageIcon(".\\src\\image/c12.jpg");
	public CouponCheck() {
		
		backgroundImg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg21.jpg");
		JPanel background=new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImg, 0, 0,this);
			setOpaque(false);
			}
		};
		setTitle("My쿠폰");
		setBounds(800, 0, 800,1000);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		JLabel cu0=new JLabel(c0);
		cu0.setOpaque(true);
		cu0.setBounds(45, 350, 700, 200);
		JLabel cu1=new JLabel(c1);
		cu1.setOpaque(true);
		cu1.setBounds(45, 350, 700, 200);
		JLabel cu2=new JLabel(c2);
		cu2.setOpaque(true);
		cu2.setBounds(45, 350, 700, 200);
		JLabel cu3=new JLabel(c3);
		cu3.setOpaque(true);
		cu3.setBounds(45, 350, 700, 200);
		JLabel cu4=new JLabel(c4);
		cu4.setOpaque(true);
		cu4.setBounds(45, 350, 700, 200);
		JLabel cu5=new JLabel(c5);
		cu5.setOpaque(true);
		cu5.setBounds(45, 350, 700, 200);
		JLabel cu6=new JLabel(c6);
		cu6.setOpaque(true);
		cu6.setBounds(45, 350, 700, 200);
		JLabel cu7=new JLabel(c7);
		cu7.setOpaque(true);
		cu7.setBounds(45, 350, 700, 200);
		JLabel cu8=new JLabel(c8);
		cu8.setOpaque(true);
		cu8.setBounds(45, 350, 700, 200);
		JLabel cu9=new JLabel(c9);
		cu9.setOpaque(true);
		cu9.setBounds(45, 350, 700, 200);
		JLabel cu10=new JLabel(c10);
		cu10.setOpaque(true);
		cu10.setBounds(45, 350, 700, 200);
		JLabel cu11=new JLabel(c11);
		cu11.setOpaque(true);
		cu11.setBounds(45, 350, 700, 200);
		JLabel cu12=new JLabel(c12);
		cu12.setOpaque(true);
		cu12.setBounds(45, 350, 700, 200);
		JLabel test = new JLabel();
		test.setOpaque(true);
		test.setBackground(Color.pink);
		test.setFont(new Font("D2Coding",Font.BOLD, 50));
		test.setText("마이 쿠폰 확인하기");
		add(test,BorderLayout.NORTH);
		JButton back=new JButton(backImg);
		back.setBackground(Color.WHITE);
		back.setBounds(0,6, 50,50);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		background.add(back);
		JLabel cidLabel= new JLabel();
		cidLabel.setOpaque(true);
		cidLabel.setBackground(Color.pink);
		cidLabel.setFont(new Font("D2Coding",Font.BOLD, 35));
		cidLabel.setText("＂" +TeamDAO.getDBID() +"＂"+"님의 쿠폰 입니다.");
		cidLabel.setBounds(0, 150, 600,50);
		background.add(cidLabel);
		
		JLabel cCoupon= new JLabel();
		cCoupon.setOpaque(true);
		cCoupon.setBackground(Color.pink);
		cCoupon.setFont(new Font("D2Coding",Font.BOLD, 20));
		cCoupon.setText("쿠폰 계수 : "+"【"+TeamDAO.getDBCoupon()+"】");
		cCoupon.setBounds(0, 250, 200,30);
		background.add(cCoupon);
		if (TeamDAO.getDBCoupon()==0) {
			background.add(cu0);
		}
		if (TeamDAO.getDBCoupon()==1) {
			background.add(cu1);
		}
		if (TeamDAO.getDBCoupon()==2) {
			background.add(cu2);
		}
		if (TeamDAO.getDBCoupon()==3) {
			background.add(cu3);
		}
		if (TeamDAO.getDBCoupon()==4) {
			background.add(cu4);
		}
		if (TeamDAO.getDBCoupon()==5) {
			background.add(cu5);
		}
		if (TeamDAO.getDBCoupon()==6) {
			background.add(cu6);
		}
		if (TeamDAO.getDBCoupon()==7) {
			background.add(cu7);
		}
		if (TeamDAO.getDBCoupon()==8) {
			background.add(cu8);
		}
		if (TeamDAO.getDBCoupon()==9) {
			background.add(cu9);
		}
		if (TeamDAO.getDBCoupon()==10) {
			background.add(cu10);
		}
		if (TeamDAO.getDBCoupon()==11) {
			background.add(cu11);
		}
		if (TeamDAO.getDBCoupon()==12) {
			background.add(cu12);
		}
		
		add(background,BorderLayout.CENTER);
		back.addMouseListener(new MouseAdapter() {
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
			@Override
			public void mouseClicked(MouseEvent e) {
				back.setIcon(backImg2);
				back.setSelectedIcon(backImg2);
				dispose();
				Mypage mypage=new Mypage();
			}
			
		});
		setVisible(true);
	}//생성자 끝

	public static void main(String[] args) {
		CouponCheck couponcheck =new CouponCheck();
	}//메인끝
	
}//클래스 끝
