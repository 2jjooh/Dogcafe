package team.mypage;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import team.DB.OrderVO;
import team.DB.TeamDAO;

public class History extends JFrame{
	ImageIcon backImg= new ImageIcon(".\\src\\image/backButton.png");
	ImageIcon backImg2= new ImageIcon(".\\src\\image/backButton(selected).png");
	Image backgroundImg;
	String[] columnNames= {"번호","메뉴이름","메뉴가격","주문 시간"};
	public History() {

		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		backgroundImg=Toolkit.getDefaultToolkit().getImage(".\\src\\image/bg21.jpg");
		JTable table =new JTable(model);
		JScrollPane jsp = new JScrollPane(table);
		JPanel background=new JPanel(null) {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImg, 0, 0,this);
			setOpaque(false);
			}
		};
		setTitle("주문한 목록");
		setBounds(800, 0, 800, 1000);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		ArrayList<OrderVO> list=TeamDAO.select();
		for(int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		if(list.size() == 0) {
			JOptionPane.showMessageDialog(table, "주문한 음료가 없습니다.");
		} else {
			String[] rowData = new String[4];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
			for(OrderVO data : list) {
				rowData[0] = data.getIdx()+"";
				rowData[1] = data.getMenuName();
				rowData[2] = data.getPrice();
				rowData[3] = sdf.format(data.getOrderTime());
				model.addRow(rowData);
			}
			
		}
		
		table.setCellSelectionEnabled(false);
		jsp.setBounds(90,80,600,700);
		background.add(jsp);
		JLabel test = new JLabel();
		test.setOpaque(true);
		test.setBackground(Color.pink);
		test.setFont(new Font("D2Coding",Font.BOLD, 50));
		test.setText("주문한 목록보기 ");
		add(test,BorderLayout.NORTH);
		JButton back=new JButton(backImg);
		back.setBackground(Color.WHITE);
		back.setBounds(0,6, 70,70);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		background.add(back);
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
				back.setSelectedIcon(backImg);
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
	History historyCheck=new History();
}//메인 끝
}//class 끝
