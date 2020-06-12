package team.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {
	
	 JLabel idLabel;				//아이디
	 JTextField idField;
	
	 JLabel pwLabel;				//패스워드
	 JPasswordField pwField;
	
	 JButton loginBtn;			//로그인 버튼
	 JButton joinBtn;			//회원가입 버튼
	
	 Image logBg;
	   
	public static String userID;
	
	public Login() {
		logBg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/logBg.jpg");
		setBounds(800, 100, 452, 439);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(logBg, 0, 0,this);
				setOpaque(false);
			}
		};
		
		setTitle("로그인 해주세요.");
		idLabel = new JLabel("아이디   :");
		idLabel.setBounds(14, 34, 80, 15);
		idLabel.setFont(new Font("D2Coding",Font.BOLD,12));
		idLabel.setForeground(Color.BLACK);
		idField = new JTextField();
		idField.setBounds(95, 31, 116, 21);
		
		pwLabel = new JLabel("비밀번호 :");
		pwLabel.setBounds(13, 80, 75, 15);
		pwLabel.setFont(new Font("D2Coding",Font.BOLD,12));
		pwLabel.setForeground(Color.BLACK);
		pwField = new JPasswordField();
		pwField.setBounds(95, 77, 116, 21);
		
		loginBtn = new JButton("로그인");
		loginBtn.setForeground(Color.white);
		loginBtn.setBounds(95, 150, 97, 23);
		loginBtn.setBackground(Color.black);
		 
		joinBtn = new JButton("회원가입");
		joinBtn.setBackground(Color.black);
		joinBtn.setForeground(Color.white);
		joinBtn.setBounds(237, 150, 97, 23);
		
		JLabel loginError = new JLabel("체크공간입니다.");
		loginError.setForeground(Color.black);
		loginError.setBounds(12, 190, 199, 92);
		
		contentPane.add(idLabel);
		contentPane.add(idField);
		contentPane.add(pwField);
		contentPane.add(pwLabel);
		contentPane.add(loginBtn);
		contentPane.add(joinBtn);
		contentPane.add(loginError);
		
		add(contentPane,BorderLayout.CENTER);
		
	//=========================================
		//회원가입 버튼 클릭 
		joinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinForm joinFrame = new JoinForm();
				joinFrame.setVisible(true);
			}
		});
		
		//로그인 버튼 클릭 
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String result=""; 
				String id = idField.getText();
				String pw = pwField.getText();
				boolean flag = team.DB.LoginDAO.selectuser(id, pw);
				
				if(flag) {
					JOptionPane.showMessageDialog(null, "로그인 성공! ");
					userID = id;
					result=" 안녕하세요 DOG CAFE 입니다.";
					loginError.setForeground(Color.BLUE);
					
					dispose();
					
					Icon newOne=new Icon();
					newOne.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(null, "다시 한번 확인 후 입력 바랍니다.");
					result="아이디 또는 비번이 잘못됨";
					loginError.setForeground(Color.BLUE);
				}
				loginError.setText(result);
		
			}
		});
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
