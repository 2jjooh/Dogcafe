package team.board;

import team.DB.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;


//로그인 되어있는 특정 아이디의 작성글을 보여주는 Pane
public class TestdbShow extends JPanel implements ActionListener{



	private JButton modifyBtn;
	private JButton deleteBtn;
	private JButton backBtn;

	private TestdbWIN win;
	private TestdbModify tm;
	
	static String[] columnNames = {"IDX", "ID", "Memo", "writeDate"};
	static DefaultTableModel model = new DefaultTableModel(columnNames,0);
	JTable table = new JTable(model);
	

	static int a;



	public TestdbShow(TestdbWIN win) {
		
		//System.out.println("etet");
		this.win = win;
		setLayout(null);
		
	//==================
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(10, 10, 460, 400);
		add(jsp);
		view();
		
		

	//==================
		
		modifyBtn = new JButton("Modify");
		modifyBtn.setBounds(180, 420, 100, 30);
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(290, 420, 100, 30);
		backBtn = new JButton("Back");
		backBtn.setBounds(400, 420, 60, 30);
		
		add(modifyBtn);
		add(deleteBtn);
		add(backBtn);
		
	
		
		modifyBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		backBtn.addActionListener(this);
		
		
		//System.out.println(table.getSelectedRow());
	}


	public static void view() {
		//System.out.println("ㅎㅎㅎㅎ");
		ArrayList<BoardVO> list = BoardDAO.indivMsg();
		//System.out.println(model.getRowCount());
		for(int i = model.getRowCount()-1; i>=0; i--) {
			model.removeRow(i);
		}

		String[] rowData = new String[4];
		for(BoardVO data : list) {
			rowData[0] = data.getIdx()+"";
			rowData[1] = data.getWirteID() + "";
			rowData[2] = data.getMemo();
			rowData[3] = data.getWriteDay()+"";
		
			model.addRow(rowData);
			
		}
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Back")) {
			win.change("mainPanel");
		} else if(e.getActionCommand().equals("Modify")) {
			a=table.getSelectedRow();
			tm = new TestdbModify(win);
			removeAll();
			win.add(tm);
			revalidate();
			repaint();
			//System.out.println(a);
			//win.change("mainPanel");			
		} else if(e.getActionCommand().equals("Delete")) {
			//System.out.println("삭제버튼 "+table.getSelectedRow());
			BoardDAO.deleteMsg(table.getSelectedRow());
			view();
		}
		
	}
	
}
