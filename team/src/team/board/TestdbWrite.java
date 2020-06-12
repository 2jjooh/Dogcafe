package team.board;


import team.DB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestdbWrite extends JPanel implements ActionListener {

	private JButton updateBtn;
	private JButton cancleBtn;
	
	private JScrollPane jscrollPane;
	private JTextArea jtextArea;
	
	private TestdbWIN win;
	
	
	public TestdbWrite() {}
	public TestdbWrite(TestdbWIN win) {
		this.win = win;
		setLayout(null);
		
		jtextArea = new JTextArea();
		jtextArea.setLineWrap(true);
		
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
			BoardVO vo = new BoardVO();
			//vo.setWirteID("ID01");
			vo.setMemo(jtextArea.getText());
			BoardDAO.insert(vo);
			jtextArea.setText("");
			TestdbShow.view();
		}
		
		win.change("mainPanel");
	}
}
