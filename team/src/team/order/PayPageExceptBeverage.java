package team.order;

import java.awt.Color;
import team.DB.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import team.DB.OrderDAO;

public class PayPageExceptBeverage extends JPanel implements ActionListener{

	String name, link, menuCode;
	int price, sumPrice, orderIDX, count;
	
	JPanel payPagePanel = new JPanel();
	JLabel label = new JLabel("주문 확인");
	DecimalFormat won = new DecimalFormat("#,##0"); 
	MenuOptionPageExceptBeverage mopeb = new MenuOptionPageExceptBeverage();
	
	JButton payButton = new JButton("결제하기");
	JButton backButton = new JButton();
	
	public static void main(String[] args) {
		PayPageExceptBeverage window = new PayPageExceptBeverage("",0,"","",0,0);
	}
	
	public PayPageExceptBeverage(String name, int price, String link, String menuCode, int sumPrice, int count) {
		this.name = name;
		this.price = price;
		this.link = link;
		this.menuCode = menuCode;
		this.sumPrice = sumPrice;
		this.count = count;
		
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		frame.setTitle("PayPageExceptBeverage");
		frame.setBounds(400, 0, 800, 1000);
		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27) {
					System.exit(0);
				}
			}
			
		});
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(6371339));
		panel.setBounds(0, 0, 1500, 1000);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel identifyLabel = new JLabel("주문 확인");
		identifyLabel.setBounds(300, 50, 400, 35);
		identifyLabel.setFont(new Font("D2coding",	Font.BOLD, 40));
		identifyLabel.setForeground(Color.WHITE);
		panel.add(identifyLabel);
		
//		총 합계 금액 Label
		JLabel sumPayPriceLabel = new JLabel(String.format("총 결제 금액 ▶ %s원", (String)won.format(mopeb.sumPrice)));
		sumPayPriceLabel.setBounds(300, 700, 700, 35);
		sumPayPriceLabel.setFont(new Font("D2coding",	Font.BOLD, 35));
		sumPayPriceLabel.setForeground(Color.WHITE);
		panel.add(sumPayPriceLabel);
		
//		제품 이름 띄우기
		JLabel order2Label = new JLabel(name);
		order2Label.setBounds(80, 200, 400, 35);
		order2Label.setFont(new Font("D2coding", Font.BOLD, 30));
		order2Label.setForeground(Color.WHITE);
		panel.add(order2Label);
		
//		제품 갯수 띄우기
		JLabel countLabel = new JLabel("개수 : " + mopeb.count + "개");
		countLabel.setBounds(450, 200, 250, 50);
		countLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		countLabel.setForeground(Color.WHITE);
		panel.add(countLabel);
		
//		제품 이미지
		JButton productImageButton = new JButton("");
		productImageButton.setBounds(30, 200, 328, 328);
		productImageButton.setIcon(new ImageIcon(link));
		productImageButton.setSelectedIcon(new ImageIcon(link));
		productImageButton.setContentAreaFilled(false);
		productImageButton.setBorderPainted(false);
		productImageButton.setFocusPainted(false);
		panel.add(productImageButton);
		
//		결제하기 버튼
		payButton.setBounds(240, 850, 300, 80);
		payButton.setFont(new Font("D2coding",	Font.BOLD, 40));
		payButton.addActionListener(this);
		panel.add(payButton);
		payButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "결제 완료");
//				OrderDAO.insertOrdert(orderIDX, menuCode, name, price, count, "", "", "", "");
//				OrderDAO.insertMenu(name, price);
				frame.setVisible(false);
			}
		});
		
//		뒤로가기 버튼
		backButton.setBounds(0, 0, 50, 50);
		backButton.setIcon(new ImageIcon(".\\src\\image/backButton.png"));
		backButton.setSelectedIcon(new ImageIcon(".\\src\\image/backButton.png"));
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		panel.add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				backButton.setIcon(new ImageIcon(".\\src\\image/backButton.png"));
				backButton.setSelectedIcon(new ImageIcon(".\\src\\image/backButton.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(new ImageIcon(".\\src\\image/backButton(selected).png"));
				backButton.setSelectedIcon(new ImageIcon(".\\src\\image/backButton(selected).png"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(new ImageIcon(".\\src\\image/backButton.png"));
				backButton.setSelectedIcon(new ImageIcon(".\\src\\image/backButton.png"));
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = (JButton)e.getSource();
		if(obj.equals(payButton)) {
			name = "";
			price = 0;
			sumPrice = 0;
			link = ""; 
			menuCode = "";
			sumPrice = 0;
			count = 0;
			orderIDX++;
			MenuOptionPageExceptBeverage.count = 0;
		}
		
		if(obj.equals(backButton)) {
			name = "";
			price = 0;
			sumPrice = 0;
			link = ""; 
			menuCode = "";
			sumPrice = 0;
			count = 0;
			MenuOptionPageExceptBeverage.count = 0;
		}
	}
	
}