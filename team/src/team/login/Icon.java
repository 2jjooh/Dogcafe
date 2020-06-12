package team.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import team.board.TestdbWIN;
import team.mypage.Mypage;
import team.order.OrderPage;

public class Icon extends JFrame implements ActionListener{
	 Image bg ;
	 JButton orderBtn = new JButton("Order");
     JButton boardBtn = new JButton("Board");
     JButton myPageBtn = new JButton("MyPage");
 	 ImageIcon backImg= new ImageIcon("./src/image/exit.png");
 	 ImageIcon backImg2= new ImageIcon("./src/image/exit2.png");
     ImageIcon imgicon=new ImageIcon(".\\src\\image/22.png");
     ImageIcon imgicon2=new ImageIcon(".\\src\\image/dd.png");
     ImageIcon imgicon3=new ImageIcon(".\\src\\image/ee.png");
    
    
    public Icon() {
  
    	setBounds(800, 0, 800, 1000);
    	setTitle("메인페이지 입니다.");
    	bg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg21.jpg");
		
		JPanel panel=new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(bg, 0,0, this);
				setOpaque(false);
			}
		};
		
		
		// orderBtn앞의 아이콘  
		JLabel ice = new JLabel(imgicon);
		ice.setBounds(50,180,550,100);
		
		orderBtn.setForeground(Color.white);
		orderBtn.setBounds(400, 200, 200, 50);
		orderBtn.setFont(new Font("D2Coding",Font.BOLD,30));
		orderBtn.setBackground(Color.BLACK);

		//게시판아이콘
		JLabel qq = new JLabel(imgicon3);
		qq.setBounds(50,480,550,100);

		boardBtn.setForeground(Color.white);
		boardBtn.setBounds(400, 500, 200, 50);
		boardBtn.setFont(new Font("D2Coding",Font.BOLD,30));
		boardBtn.setBackground(Color.BLACK);
	     
		//마이페이지 아이콘
		JLabel qwe = new JLabel(imgicon2);
		qwe.setBounds(50,320,550,100);

		myPageBtn.setForeground(Color.white);
		myPageBtn.setBounds(400, 350, 200, 50);
		myPageBtn.setFont(new Font("D2Coding",Font.BOLD,30));
		myPageBtn.setBackground(Color.BLACK);

		JButton backButton=new JButton(backImg);
		backButton.setBounds(0,10,100,100);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backImg2);
				backButton.setSelectedIcon(backImg2);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backImg);
				backButton.setSelectedIcon(backImg);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				backButton.setIcon(backImg2);
				backButton.setSelectedIcon(backImg2);
				dispose();
				Login d=new Login();
			}
		});
		
	//==========================
		panel.add(qq);
		panel.add(qwe);
		panel.add(ice);

	    panel.add(orderBtn);
        panel.add(boardBtn);
		panel.add(myPageBtn);
		panel.add(backButton);
		
		
		add(panel,BorderLayout.CENTER);
	//===============================	
		
		orderBtn.addActionListener(this);
		boardBtn.addActionListener(this);
		myPageBtn.addActionListener(this);
		
		
		
		
		
	//=======================================
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	


	public static void main(String[] args) {
		Icon icon=new Icon();	
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("MyPage")) {
			dispose();
			Mypage m = new Mypage();
		} else if(e.getActionCommand().equals("Board")){
			dispose();
			TestdbWIN t= new TestdbWIN();
		} else if(e.getActionCommand().equals("Order")) {
			dispose();
			OrderPage o = new OrderPage();
		}
	}

}