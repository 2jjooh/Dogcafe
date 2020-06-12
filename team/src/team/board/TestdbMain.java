package team.board;

import team.DB.*;
import team.login.Icon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//처음 창 뜰때 보여지는 페이지, 수정안됨, 백버튼 먹힘     @@@@@@@@@@@@@@
public class TestdbMain extends JPanel implements ActionListener, Runnable{
	
	private JTextArea textArea;
	
	private JButton writeBtn;
	private JButton showBtn;
	JButton backBtn;
	
	private TestdbWIN win;
	Image logBg;
	ImageIcon backImg= new ImageIcon(".\\src\\image/backButton.png");
	ImageIcon backImg2= new ImageIcon(".\\src\\image/backButton(selected).png");
	
	public TestdbMain() {}
	public TestdbMain(TestdbWIN win) {
		logBg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bodbg.jpg");
		
		this.win = win;
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 55, 460,  355);
		textArea.setEditable(false);
		add(textArea);
		
		
		writeBtn = new JButton("Wirte");
		writeBtn.setBounds(200, 420, 100, 30);
		showBtn = new JButton("Show");
		showBtn.setBounds(310, 420, 100, 30);
		
		
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
				Icon icon=new Icon();
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
		
		add(backBtn);
		add(writeBtn);
		add(showBtn);
		
		writeBtn.addActionListener(this);
		showBtn.addActionListener(this);
				

		

	}
@Override
protected void paintComponent(Graphics g) {
	g.drawImage(logBg, 0,0,this);
}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Wirte")) {
			win.change("writePane");
		} else if(e.getActionCommand().equals("Show")) {
			win.change("showPane");
		}
		
	}
	
//일정시간이 지날때마다 DB에서 데이터를 긁어와 JTextArea에 보여준다. 
	@Override
	public void run() {
		
		while(true) {
			
			ArrayList<BoardVO> list = BoardDAO.msgShow();
			for(BoardVO vo : list) {
				//System.out.println(vo);
				textArea.append(vo.getMemo());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				textArea.setText("");
			}				
		}
		
	}
	

}
