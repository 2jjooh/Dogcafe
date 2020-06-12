package team.board;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TestdbWIN extends JFrame{
	
//	public TestdbShow showPane=null;
//	public TestdbModify modifyPane = null;
//	public TestdbWrite writePane = null;
	public static TestdbMain mainPane = null; 
	
	
	public TestdbWIN() {
		
		this.setTitle("게시판입니다.");
		
		
		this.mainPane = new TestdbMain(this);
//		this.showPane = new TestdbShow(this);
//		this.modifyPane = new TestdbModify(this);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
//		this.writePane = new TestdbWrite(this);

		this.add(this.mainPane);

		
		Thread thread = new Thread(this.mainPane);
		thread.start();
		
		this.setBounds(800,0,500,500);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		mainPane.backBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
		});
		this.setVisible(true);
	}

	
	public static void main(String[] args) {
		TestdbWIN bd= new TestdbWIN();
		
		bd.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				bd.dispose();
			}
		});
//		mainPane.backBtn.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				bd.dispose();
//			}
//			
//		});
	}
	public void change(String panelName) {
		if(panelName.equals("mainPanel")) {
			getContentPane().removeAll();
			getContentPane().add(mainPane);
			revalidate();
			repaint();
		} else if(panelName.equals("writePane")) {
			getContentPane().removeAll();
			TestdbWrite writePane = new TestdbWrite(this);
			getContentPane().add(writePane);
			revalidate();
			repaint();
		} else if(panelName.equals("showPane")) {
			getContentPane().removeAll();
			TestdbShow showPane = new TestdbShow(this);
			getContentPane().add(showPane);
			revalidate();
			repaint();
		} else if(panelName.equals("modifyPane")) {
			getContentPane().removeAll();
			TestdbModify modifyPane = new TestdbModify(this); 
			getContentPane().add(modifyPane);
			revalidate();
			repaint();
		}
		
	}
	
	
}
