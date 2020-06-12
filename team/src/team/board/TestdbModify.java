package team.board;

import team.DB.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


// 수정 버튼을 누르면 수정화면으로 넘어와서 수정을 진행꺼임  -> 내일 제작 시작ㄷ!! 
public class TestdbModify extends JPanel implements ActionListener{
	private JButton updateBtn;
	private JButton cancleBtn;
	
	private JScrollPane jscrollPane;
	public JTextArea jtextArea;
	
	private TestdbWIN win;
	
	public TestdbModify() {}
	public TestdbModify(TestdbWIN win) {
		this.win = win;
		setLayout(null);
		
		jtextArea = new JTextArea();
		jtextArea.setLineWrap(true); 
	// ================
	
		//System.out.println("modi" + TestdbShow.a);
		jtextArea.setText(BoardDAO.modifyMsg(TestdbShow.a));
		
	// =================
		
		jscrollPane = new JScrollPane(jtextArea);
		jscrollPane.setBounds(10, 10, 460, 400);
		add(jscrollPane);
		
		
		
		updateBtn = new JButton("OK");
		updateBtn.setBounds(200, 420, 100, 30);
		cancleBtn = new JButton("Cancle");
		cancleBtn.setBounds(310, 420, 100, 30);
		
		add(updateBtn);
		add(cancleBtn);
		
		
		updateBtn.addActionListener(this);
		cancleBtn.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("OK")) {
			String str = jtextArea.getText();
			BoardDAO.updateMsg(str, TestdbShow.a);
		}
		win.change("showPane");
		//TestdbShow.view();
	}
}