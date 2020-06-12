package team.login;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JoinForm extends JFrame implements ActionListener, ItemListener{
	 Image bg ;

	 JLabel name_la;
	 JTextField name_t;
	
	 JLabel id_la;
	 JTextField id_t;
	 JButton idCheckBtn;			//아이디 중복체크 버튼

	 JLabel pw_la;
	 JTextField pw_T;
	
	 JLabel pw_laCh;
	 JTextField pw_tCh;
	
	 JLabel phone_la;
	 Choice phone_t1;
	 JTextField phone_t2;
	 JTextField phone_t3;
	 JButton check;
	
	 ImageIcon imgicon=new ImageIcon("./src/image/yy.png");
	 ImageIcon regcheck=new ImageIcon("./src/image/regcheck.jpg");
	 ImageIcon check1=new ImageIcon(".\\src\\image/chek1.png");
	 ImageIcon check2=new ImageIcon(".\\src\\image/chek2.png");
	 ImageIcon backImg= new ImageIcon(".\\src\\image/backButton.png");
	 ImageIcon backImg2= new ImageIcon(".\\src\\image/backButton(selected).png");
	
	 boolean yesNo=false;
	 ButtonGroup group = new ButtonGroup();
	 JRadioButton yes, no;
	 
	 JButton backBtn;
	 
	boolean flag=false,pwflag=true;
	
	public JoinForm() {
		bg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg21.jpg");
		JPanel panel=new JPanel(null) {

			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(bg, 0,0, this);
				setOpaque(false);
			}
		};
		
		setBounds(800,0,800,1000);
		
	//=================================
		setTitle("회원가입");
		
		JLabel title=new JLabel("회원가입");
		title.setForeground(Color.black);
		title.setFont(new Font("D2Coding",Font.BOLD,50));
		title.setBounds(0,0,80,50);
		title.setBackground(Color.pink);
		title.setOpaque(true);

		name_la=new JLabel("이름    :");
		name_la.setFont(new Font("D2Coding",Font.BOLD,20));
		name_la.setForeground(Color.black);
		name_la.setBounds(50,50,100,50);
		name_t=new JTextField("");
		name_t.setBounds(140,67,100,20);
		
		id_la=new JLabel("아이디  :");
		id_la.setFont(new Font("D2Coding",Font.BOLD,20));
		id_la.setForeground(Color.black);
		id_la.setBounds(50,100,100,50);
		id_t=new JTextField("");
		id_t.setBounds(140,117,80,20);
		idCheckBtn=new JButton("아이디 중복 확인");
		idCheckBtn.setBackground(Color.black);
		idCheckBtn.setForeground(Color.white);
		idCheckBtn.setBounds(250,117,135,20);
		
		pw_la=new JLabel("비밀번호: ");
		pw_la.setFont(new Font("D2Coding",Font.BOLD,20));
		pw_la.setForeground(Color.black);
		pw_la.setBounds(50,220,100,50);
		pw_T=new JTextField("");
		pw_T.setBounds(140,235,130,20);
		
		pw_laCh=new JLabel("재입력  : ");
		pw_laCh.setForeground(Color.black);
		pw_laCh.setFont(new Font("D2Coding",Font.BOLD,20));
		pw_laCh.setBounds(50,260,100,50);
		pw_tCh=new JTextField("");
		pw_tCh.setBounds(140,275,130,20);
		
		phone_la=new JLabel("휴대폰 번호:");
		phone_la.setForeground(Color.black);
		phone_la.setFont(new Font("D2Coding",Font.BOLD,20));
		phone_la.setBounds(20,390,130,30);
		
		phone_t1=new Choice();
		phone_t1.setBounds(150,395,50,20);
		phone_t1.add("010");
		phone_t2=new JTextField("");
		phone_t2.setBounds(210,395,70,20);
		phone_t3=new JTextField("");
		phone_t3.setBounds(290,395,70,20);
		
		check = new JButton("완료",check1);
		check.setContentAreaFilled(false);
//		check.setBorderPainted(false);
//		check.setFocusPainted(false);
		check.setBounds(130,530,130,100);
		
		backBtn=new JButton(backImg);
		backBtn.setBounds(0,6, 50,50);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				backBtn.setIcon(backImg2);
				backBtn.setSelectedIcon(backImg2);
				dispose();
				Login log= new Login();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backBtn.setIcon(backImg2);
				backBtn.setSelectedIcon(backImg2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backBtn.setIcon(backImg);
				backBtn.setIcon(backImg);
			}
			
		});
		
		
		
		
		//개인정보 약관동의서
		JLabel jl =new JLabel(regcheck);
//		JCheckBox jc=new JCheckBox("동의");	
//		ButtonGroup bgBox=new ButtonGroup();
//		bgBox.add(jc);
//		jc.setBounds(440,570 , 300, 50);
		jl.setOpaque(true);
		jl.setBackground(Color.white);
		jl.setBounds(440, 70,300,500);
		panel.add(jl);
		yes = new JRadioButton("동의");
		yes.setBounds(440,570 , 150, 50);
		yes.addItemListener(this);
		panel.add(yes);
		no = new JRadioButton("동의 안함");
		no.setBounds(590,570 ,150, 50);
		no.addItemListener(this);
		panel.add(no);
		
		
		group.add(yes);
		group.add(no);
	//=================================	
		
		panel.add(backBtn);
		panel.add(name_la);
		panel.add(name_t);
		panel.add(id_la);
		panel.add(id_t);
		panel.add(idCheckBtn);
		panel.add(pw_la);
		panel.add(pw_T);
		panel.add(pw_laCh);
		panel.add(pw_tCh);
		
		panel.add(phone_la);
		panel.add(phone_t1);
		panel.add(phone_t2);
		panel.add(phone_t3);
	 
		panel.add(check);
		
		add(title,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		
	//===================================
		
		idCheckBtn.addActionListener(this);
		check.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	//=================================	
		setVisible(true);
	}
	public static void main(String[] args) {
		JoinForm form = new JoinForm();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		      Object object = e.getSource();
		      JRadioButton radio = (JRadioButton) object;
		      if (radio == yes) {
		         yesNo= true;
		      } else if (radio == no) {
		         yesNo = false;
		      }
		   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("아이디 중복 확인")) {
			if(!id_t.getText().equals("")) {				
				String id = id_t.getText();
				flag = team.DB.LoginDAO.idCheck(id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "사용가능한 id입니다.");
					pwflag=true;
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용중인 id입니다.");
					flag=false;
				}
			}else {
				JOptionPane.showMessageDialog(null, "아이디를 적어주세요");
			}
			
		}//end if
		
		else if(e.getActionCommand().equals("완료")) {
			
			//비밀번호 다를때 :VO에 저장했던 비번
			if (!pw_T.getText().equals(pw_tCh.getText())) {
				JOptionPane.showMessageDialog(null,"비밀번호가 일치하지 않습니다.");
				pwflag=false;
			}
			//필드 비었을때:VO에 저장했던 변수를 비교 String
			else if (id_t.getText().equals("")||name_t.getText().equals("")||pw_T.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"빈칸을 채워주세요.");
				pwflag=false;
			}
			//중복확인 안했을때:
			else if (flag==false) {
				JOptionPane.showMessageDialog(null,"아이디 중복확인 해주세요.");
				pwflag=false;
			}
			else if (!yes.isSelected() && !no.isSelected()) {
				JOptionPane.showMessageDialog(null,"약관 동의서 확인 후 체크 해주세요.");
				pwflag=false;
			} else if(no.isSelected()) {
				JOptionPane.showMessageDialog(null,"회원가입 하려면 동의 해주세요.");
				pwflag=false;
			} else if(yes.isSelected()) {
				pwflag=true;
			}
			
			String phone = phone_t2.getText() +" - " + phone_t3.getText();
			if(pwflag) {
				team.DB.LoginDAO.join(id_t.getText().trim(),name_t.getText().trim(),pw_T.getText().trim(),phone);
				setVisible(true);
				
				JOptionPane.showMessageDialog(null, "회원가입 완료");
				
				dispose();
				//Icon icon=new Icon();
			}
		}
		
	}
	}
