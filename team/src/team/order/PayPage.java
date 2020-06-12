package team.order;

import java.awt.Color;
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
import team.DB.TeamDAO;
import team.DB.TeamVO;
import team.login.Login;

public class PayPage extends JPanel implements ActionListener{

	static String name;
	static String link;
	String menuCode;
	static int price;
	static int sumPrice;
	int idx;
	static int count;
	static int orderIDX;
	public static String esShot, size, ice, whip, orderStatus = "end";
	
	JPanel payPagePanel = new JPanel();
	JLabel label = new JLabel("주문 확인");
	DecimalFormat won = new DecimalFormat("#,##0");
	MenuOptionPage mop = new MenuOptionPage();
	TeamVO vo = new TeamVO();
	
	JButton payButton = new JButton("결제하기");
	JButton backButton = new JButton("");
	
	public static void main(String[] args) {
		PayPage window = new PayPage("",0,"","","","","",0,0,"");
	}
	
	public PayPage() {}
	
	public PayPage(String name, int price, String link, String esShot, String ice, String size, String whip, int sumPrice, int count, String menuCode) {
		this.name = name;
		this.price = price;
		this.link = link;
		this.esShot = esShot;
		this.ice = ice;
		this.size = size;
		this.whip = whip;
		this.sumPrice = sumPrice;
		this.count = count;
		this.menuCode = menuCode;
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("PayPage");
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
		panel.add(identifyLabel);
		
//		총 합계 금액 Label
		JLabel sumPayPriceLabel = new JLabel(String.format("총 결제 금액 ▶ %s원", (String)won.format(mop.sumPrice)));
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
		JLabel countLabel = new JLabel("개수 : " + mop.count + "개");
		countLabel.setBounds(450, 200, 250, 50);
		countLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		countLabel.setForeground(Color.WHITE);
		panel.add(countLabel);
		
//		에스프레소 샷 옵션 띄우기
		JLabel esShotLabel = new JLabel("에스프레소 : " + mop.esShot);
		esShotLabel.setBounds(450, 350, 250, 50);
		esShotLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		esShotLabel.setForeground(Color.WHITE);
		panel.add(esShotLabel);
		
//		얼음 양 옵션 띄우기
		JLabel iceLabel = new JLabel("얼음 : " + mop.ice);
		iceLabel.setBounds(450, 390, 200, 50);
		iceLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		iceLabel.setForeground(Color.WHITE);
		panel.add(iceLabel);
		
//		음료 사이즈 띄우기
		JLabel sizeLabel = new JLabel("음료 사이즈 : " + mop.size);
		sizeLabel.setBounds(450, 420, 200, 50);
		sizeLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		sizeLabel.setForeground(Color.WHITE);
		panel.add(sizeLabel);
		
//		휘핑 크림 띄우기
		JLabel whipLabel = new JLabel("휘핑 크림 : " + mop.whip);
		whipLabel.setBounds(450, 300, 200, 50);
		whipLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		whipLabel.setForeground(Color.WHITE);
		panel.add(whipLabel);
		
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
				
			
//				JOptionPane.showMessageDialog(null, "테스트"); // 데이터베이스 insert 구문 넣기
				orderIDX++;
				System.out.println(count + "개");
				System.out.println(name);
				OrderDAO.insertOrderd(count, mop.size, mop.ice, mop.esShot, mop.whip, name, mop.sumPrice); // DB에 데이터 Insert
//				OrderDAO.insertMenu(name, price);
				JOptionPane.showMessageDialog(null, "결제 완료");
				
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
		backButton.addActionListener(this);
		panel.add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				backButton.setIcon(new ImageIcon(".\\src\\image/backButton.png"));
				backButton.setSelectedIcon(new ImageIcon(".\\src\\image/backButton.png"));
				frame.setVisible(false);
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
//		결제하기 버튼 클릭 시 모든 변수 초기화
		Object obj = (JButton)e.getSource();
		if(obj.equals(payButton)) {
			count = 0;
			price = 0;
			sumPrice = 0;
			link = "";
			//name = "";
			esShot = "";
			ice = "";
			size = "";
			whip = "";
			MenuOptionPage.count= 0;
			orderIDX++;
			orderStatus = "request";
			if(OrderDAO.getDBCoupon() == 12) {
				//System.out.println(mop.name);
				mop.sumPrice = 0;
				int a = JOptionPane.showConfirmDialog(null, "쿠폰으로 결제하시겠습니까?", "쿠폰 결제", JOptionPane.YES_NO_OPTION);
				System.out.println(a);
				if(a == 0) {
					OrderDAO.insertCouponZero();
					OrderDAO.insertOrderd(count, mop.size, mop.ice, mop.esShot, mop.whip, name, mop.sumPrice); // DB에 데이터 Insert
					JOptionPane.showMessageDialog(null, "결제 완료");
					setVisible(false);
				}
//				vo.setCoupon(0);
			}
		}
		
		
		if(obj.equals(backButton)) {
			count = 0;
			price = 0;
			sumPrice = 0;
			link = "";
			name = "";
			esShot = "";
			ice = "";
			size = "";
			whip = "";
			MenuOptionPage.count= 0;
		}
		
	}
}
	
