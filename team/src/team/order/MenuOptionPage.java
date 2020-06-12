package team.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class MenuOptionPage extends JFrame implements ItemListener, ActionListener{
	String name;
	public static int price;
	public static String link, esShot, ice, size, whip, menuCode;
	static int mouseCount;
	static int count = 0;
	static int sumPrice = mouseCount * price;
	
	ButtonGroup group = new ButtonGroup();
	ButtonGroup group1 = new ButtonGroup();
	ButtonGroup group2 = new ButtonGroup();
	ButtonGroup group3 = new ButtonGroup();
	JRadioButton shot1, shot2, shot3, small, tall, grande, little, much, whipYes, whipNo;
	
	JPanel panel = new JPanel();
	JPanel optionPanel = new JPanel();
	String[] menuName = {};
	JButton PlusButton = new JButton();
	JButton minusButton = new JButton();
	JButton backButton = new JButton();
	JButton finalButton = new JButton("확인");
	JLabel productNumberLabel;
	
	DecimalFormat won = new DecimalFormat("#,##0");
	
	public static void main(String[] args) {
		MenuOptionPage window = new MenuOptionPage();
	}
	
	public MenuOptionPage() {}
	
	public MenuOptionPage(String name, int price, String link, String esShot, String ice, String size, String whip, int sumPrice, String menuCode) {
		this.name = name;
		this.price = price;
		this.link = link;
		this.esShot = esShot;
		this.ice = ice;
		this.size = size;
		this.whip = whip;
		this.sumPrice = sumPrice;
		this.menuCode = menuCode;
		productNumberLabel = new JLabel(String.format("%02d", count));
		
		setTitle("MenuOptionPage");
		setBounds(400, 0, 800, 1000);
		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27) {
					System.exit(0);
				}
			}
			
		});
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(6371339));
		panel.setBounds(0, 0, 1500, 1000);
		add(panel);
		panel.setLayout(null);
//		getContentPane().
		optionPanel.setBackground(Color.CYAN);
		optionPanel.setBounds(50, 430, 700, 450);
		optionPanel.setLayout(null);
		panel.add(optionPanel);
		
//		제품 이름 띄우기
		JLabel order2Label = new JLabel(name);
		order2Label.setBounds(50, 50, 400, 35);
		order2Label.setFont(new Font("D2coding", Font.BOLD, 40));
		order2Label.setForeground(Color.WHITE);
		panel.add(order2Label);
		
//		가격 띄우기
		JLabel priceLabel = new JLabel(String.format("￦ %d원", sumPrice));
		priceLabel.setBounds(520, 50, 300, 35);
		priceLabel.setFont(new Font("D2coding",	Font.BOLD, 37));
		priceLabel.setForeground(Color.WHITE);
		panel.add(priceLabel);
		productNumberLabel.setBounds(610, 220, 300, 45);
		productNumberLabel.setFont(new Font("D2coding",	Font.BOLD, 45));
		productNumberLabel.setForeground(Color.WHITE);
		panel.add(productNumberLabel);
		
//		제품 이미지
		JButton productImageButton = new JButton("");
		productImageButton.setBounds(110, 140, 200, 200);
		productImageButton.setIcon(new ImageIcon(link));
		productImageButton.setSelectedIcon(new ImageIcon(link));
		productImageButton.setContentAreaFilled(false);
		productImageButton.setBorderPainted(false);
		productImageButton.setFocusPainted(false);
		panel.add(productImageButton);
		
		JLabel productNumLabel = new JLabel("제품 갯수");
		productNumLabel.setBounds(360, 215, 300, 50);
		productNumLabel.setFont(new Font("D2coding", Font.BOLD, 25));
		productNumLabel.setForeground(Color.WHITE);
		panel.add(productNumLabel);
		
//		플러스 버튼
		PlusButton.setBounds(670, 200, 70, 70);
		PlusButton.setIcon(new ImageIcon(".\\src\\image/plus.png"));
		PlusButton.setSelectedIcon(new ImageIcon(".\\src\\image/plus.png"));
		PlusButton.addActionListener(this);
		panel.add(PlusButton);
		PlusButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				PlusButton.setIcon(new ImageIcon(".\\src\\image/plus.png"));
				PlusButton.setSelectedIcon(new ImageIcon(".\\src\\image/plus.png"));
				
//				mouseCount가 0이상일 때
				if(mouseCount >= 0) { mouseCount++; }else { mouseCount = 0; }
				int sumPrice = mouseCount * price;
				
				priceLabel.setText(String.format("￦ %d원", sumPrice));
				productNumberLabel.setText(String.format("%02d", mouseCount));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				PlusButton.setIcon(new ImageIcon(".\\src\\image/plus(selected).png"));
				PlusButton.setSelectedIcon(new ImageIcon(".\\src\\image/plus(selected).png"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				PlusButton.setIcon(new ImageIcon(".\\src\\image/plus.png"));
				PlusButton.setSelectedIcon(new ImageIcon(".\\src\\image/plus.png"));
			}
			
		});
		
		JLabel optionLabel1 = new JLabel("음료 사이즈");
		optionLabel1.setBounds(100, 50, 300, 50);
		optionLabel1.setFont(new Font("D2coding", Font.BOLD, 25));
		optionPanel.add(optionLabel1);
		
		JLabel optionLabel2 = new JLabel("얼음 양");
		optionLabel2.setBounds(100, 140, 300, 50);
		optionLabel2.setFont(new Font("D2coding", Font.BOLD, 25));
		optionPanel.add(optionLabel2);
		
		JLabel optionLabel3 = new JLabel("에스프레소 샷 추가");
		optionLabel3.setBounds(100, 220, 300, 50);
		optionLabel3.setFont(new Font("D2coding", Font.BOLD, 25));
		optionPanel.add(optionLabel3);
		
		JLabel optionLabel4 = new JLabel("휘핑 크림 추가");
		optionLabel4.setBounds(100, 330, 300, 50);
		optionLabel4.setFont(new Font("D2coding", Font.BOLD, 25));
		optionPanel.add(optionLabel4);
		
		
//		에스프레소 샷 라디오 버튼
		shot1 = new JRadioButton();
		shot1.setBounds(380, 230, 20, 15);
		shot1.setBackground(Color.CYAN);
		shot1.addItemListener(this);
		optionPanel.add(shot1);
		
		shot2 = new JRadioButton();
		shot2.setBounds(480, 230, 20, 15);
		shot2.addItemListener(this);
		shot2.setBackground(Color.CYAN);
		shot2.addItemListener(this);
		optionPanel.add(shot2);
		
		shot3 = new JRadioButton();
		shot3.setBounds(580, 230, 20, 15);
		shot3.addItemListener(this);
		shot3.setBackground(Color.CYAN);
		shot3.addItemListener(this);
		optionPanel.add(shot3);
		
//		group에 에스프레소 샷 라디오 버튼 추가
		group.add(shot1);
		group.add(shot2);
		group.add(shot3);
		
//		음료 사이즈 라디오 버튼
		small = new JRadioButton();
		small.setBounds(380, 40, 20, 20);
		small.setBackground(Color.CYAN);
		small.addItemListener(this);
		optionPanel.add(small);
		
		tall = new JRadioButton();
		tall.setBounds(480, 40, 20, 15);
		tall.setBackground(Color.CYAN);
		tall.addItemListener(this);
		optionPanel.add(tall);
		
		grande = new JRadioButton();
		grande.setBounds(580, 40, 20, 15);
		grande.setBackground(Color.CYAN);
		grande.addItemListener(this);
		optionPanel.add(grande);
		
//		group1에 음료 사이즈 라디오 버튼 추가
		group1.add(small);
		group1.add(tall);
		group1.add(grande);
		
//		얼음 양 라디오 버튼
		little = new JRadioButton();
		little.setBounds(380, 140, 20, 15);
		little.setBackground(Color.CYAN);
		little.addItemListener(this);
		optionPanel.add(little);
		
		much = new JRadioButton();
		much.setBounds(480, 140, 20, 15);
		much.addItemListener(this);
		much.setBackground(Color.CYAN);
		much.addItemListener(this);
		optionPanel.add(much);
		
//		group2에 얼음 양 라디오 버튼 추가
		group2.add(little);
		group2.add(much);
		
//		휘핑크림 라디오 버튼
		whipYes = new JRadioButton();
		whipYes.setBounds(380, 340, 20, 15);
		whipYes.setBackground(Color.CYAN);
		whipYes.addItemListener(this);
		optionPanel.add(whipYes);
		
		whipNo = new JRadioButton();
		whipNo.setBounds(480, 340, 20, 15);
		whipNo.setBackground(Color.CYAN);
		whipNo.addItemListener(this);
		optionPanel.add(whipNo);
		
//		group3에 휘핑 크림 라디오 버튼 추가
		group3.add(whipYes);
		group3.add(whipNo);
		
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
//				payButton을 누르면 결제 내역 창을 띄우기
				setVisible(false);
			}
			
		});
		
//		마이너스 버튼
		minusButton.setBounds(520, 200, 70, 70);
		minusButton.setIcon(new ImageIcon(".\\src\\image/minus.png"));
		minusButton.setSelectedIcon(new ImageIcon(".\\src\\image/minus.png"));
		minusButton.addActionListener(this);
		panel.add(minusButton);
		minusButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				payButton을 누르면 결제 내역 창을 띄우기
				minusButton.setIcon(new ImageIcon(".\\src\\image/minus.png"));
				minusButton.setSelectedIcon(new ImageIcon(".\\src\\image/minus.png"));
				
				int sumPrice = mouseCount * price;
				
				if(sumPrice > 0) { 
					mouseCount--;
					sumPrice = mouseCount * price;
					productNumberLabel.setText(String.format("%02d", mouseCount));
					priceLabel.setText(String.format("￦ %d원", sumPrice));
					if(mouseCount == 0) {
						sumPrice = 0;
						productNumberLabel.setText(String.format("%02d", mouseCount));
						priceLabel.setText(String.format("￦ %d원", sumPrice));
					}
				}
				if(sumPrice == 0) { 
					mouseCount = 0;
					productNumberLabel.setText(String.format("%02d", mouseCount));
					priceLabel.setText(String.format("￦ %d원", sumPrice));
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				minusButton.setIcon(new ImageIcon(".\\src\\image/minus(selected).png"));
				minusButton.setSelectedIcon(new ImageIcon(".\\src\\image/minus(selected).png"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				minusButton.setIcon(new ImageIcon(".\\src\\image/minus.png"));
				minusButton.setSelectedIcon(new ImageIcon(".\\src\\image/minus.png"));
			}
			
		});
		
//		JButton bomstrawberryLatteImageButton = new JButton("");
//		bomstrawberryLatteImageButton.setIcon(new ImageIcon(".\\src\\image\\beverage\\optionPage/bomStrawberryLatte.png"));
//		bomstrawberryLatteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beverage\\optionPage/bomStrawberryLatte.png"));
//		bomstrawberryLatteImageButton.setBounds(50, 100, 328, 328);
//		bomstrawberryLatteImageButton.setContentAreaFilled(false);
//		bomstrawberryLatteImageButton.setBorderPainted(false);
//		bomstrawberryLatteImageButton.setFocusPainted(false);
//		panel.add(bomstrawberryLatteImageButton);
		
//		에스프레소 샷 추가 아이콘
		JButton shotButton = new JButton();
		shotButton.setBounds(35, 200, 64, 64);
		shotButton.setIcon(new ImageIcon(".\\src\\image/optionIcon/shot.png"));
		shotButton.setSelectedIcon(new ImageIcon(".\\src\\image/optionIcon/shot.png"));
		shotButton.setContentAreaFilled(false);
		shotButton.setBorderPainted(false);
		shotButton.setFocusPainted(false);
		optionPanel.add(shotButton);
		shotButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		
//		음료 아이콘
		JButton beverImageButton = new JButton();
		beverImageButton.setBounds(35, 40, 64, 64);
		beverImageButton.setIcon(new ImageIcon(".\\src\\image/optionIcon/beverImage.png"));
		beverImageButton.setSelectedIcon(new ImageIcon(".\\src\\image/optionIcon/beverImage.png"));
		beverImageButton.setContentAreaFilled(false);
		beverImageButton.setBorderPainted(false);
		beverImageButton.setFocusPainted(false);
		optionPanel.add(beverImageButton);
		
//		얼음 아이콘
		JButton iceButton = new JButton();
		iceButton.setBounds(35, 130, 64, 64);
		iceButton.setIcon(new ImageIcon(".\\src\\image/optionIcon/ice.png"));
		iceButton.setSelectedIcon(new ImageIcon(".\\src\\image/optionIcon/ice.png"));
		iceButton.setContentAreaFilled(false);
		iceButton.setBorderPainted(false);
		iceButton.setFocusPainted(false);
		optionPanel.add(iceButton);
		
//		휘핑 크림 아이콘
		JButton whippingCreamButton = new JButton();
		whippingCreamButton.setBounds(35, 320, 64, 64);
		whippingCreamButton.setIcon(new ImageIcon(".\\src\\image/optionIcon/whippingCream.png"));
		whippingCreamButton.setSelectedIcon(new ImageIcon(".\\src\\image/optionIcon/whippingCream.png"));
		whippingCreamButton.setContentAreaFilled(false);
		whippingCreamButton.setBorderPainted(false);
		whippingCreamButton.setFocusPainted(false);
		optionPanel.add(whippingCreamButton);
		
//		다른 메뉴 선택 버튼
		JButton otherMenuSelectButton = new JButton("다른 메뉴 선택");
		otherMenuSelectButton.setBounds(70, 900, 200, 50);
		otherMenuSelectButton.setFont(new Font("D2coding", Font.BOLD, 20));
		panel.add(otherMenuSelectButton);
		otherMenuSelectButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new OrderPage2();
			}
			
		});
		
//		메인 메뉴 페이지
		JButton othreMenuSelectButton = new JButton("메인 메뉴 페이지");
		othreMenuSelectButton.setBounds(290, 900, 200, 50);
		othreMenuSelectButton.setFont(new Font("D2coding", Font.BOLD, 20));
		panel.add(othreMenuSelectButton);
		othreMenuSelectButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new OrderPage();
			}
			
		});
		
		espressoSelectOption();
		beverageSelectOption();
		iceSelectOption();
		whippingCreamSelectOption();
		
//		확인 버튼
		finalButton.setBounds(520, 900, 200, 50);
		finalButton.setFont(new Font("D2coding", Font.BOLD, 20));
		finalButton.addActionListener(this);
		panel.add(finalButton);
		finalButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(count);
				new PayPage(name, price, link, esShot, ice, size, whip, sumPrice, count, menuCode); // "",0,""는 아무것도 없는 PayPage의 인자값으로 PayPage의 디폴트 생성자를 실행시킬 수 있다.
				System.out.println(name +","+ sumPrice+"," + price);
			}
			
		});
		
		
		setVisible(true);
	} 
	
	private void whippingCreamSelectOption() {
		
		JLabel insertLabel = new JLabel("추가");
		insertLabel.setBounds(380, 350, 80, 50);
		insertLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(insertLabel);
		
		JLabel deleteLabel = new JLabel("없음");
		deleteLabel.setBounds(480, 350, 80, 50);
		deleteLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(deleteLabel);
		
	}
	
	private void iceSelectOption() {
		JLabel littleLabel = new JLabel("적게");
		littleLabel.setBounds(370, 160, 80, 50);
		littleLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(littleLabel);
		
		JLabel muchLabel = new JLabel("많이");
		muchLabel.setBounds(470, 160, 80, 50);
		muchLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(muchLabel);
	}
	
	private void beverageSelectOption() {
		
		//		음료 사이즈(Small)
		JLabel beverSmallLabel = new JLabel("Small");
		beverSmallLabel.setBounds(370, 60, 50, 50);
		beverSmallLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(beverSmallLabel);
		
		//		음료 사이즈(Tall)
		JLabel shotTallLabel = new JLabel("Tall");
		shotTallLabel.setBounds(473, 60, 50, 50);
		shotTallLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(shotTallLabel);
		
		//		음료 사이즈(Grande)
		JLabel shotGrandeLabel = new JLabel("Grande");
		shotGrandeLabel.setBounds(573, 60, 60, 60);
		shotGrandeLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(shotGrandeLabel);
	}
	
	private void espressoSelectOption() {
		
		//		에스프레소 샷 추가(1shot)
		JLabel shotSmallLabel = new JLabel("1shot");
		shotSmallLabel.setBounds(370, 250, 50, 50);
		shotSmallLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(shotSmallLabel);
		
		//		에스프레소 샷 추가(2shot)
		JLabel shotTallLabel = new JLabel("2shot");
		shotTallLabel.setBounds(473, 250, 50, 50);
		shotTallLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(shotTallLabel);
		
		//		에스프레소 샷 추가(3shot)
		JLabel shotGrandeLabel = new JLabel("3shot");
		shotGrandeLabel.setBounds(573, 245, 60, 60);
		shotGrandeLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		optionPanel.add(shotGrandeLabel);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		샷 추가
		if(shot1.isSelected() == true) { esShot = "One Shot"; }
		else if(shot2.isSelected() == true) { esShot = "Two Shot"; }
		else if(shot3.isSelected() == true) { esShot = "Three Shot"; }
		
//		얼음 양 옵션
		if(little.isSelected() == true) { ice = "less"; }
		else if(much.isSelected() == true) { ice = "much"; }
		
//		음료 사이즈
		if(small.isSelected() == true) {size = "Small"; } 
		else if(tall.isSelected() == true) {size = "Tall"; }
		else if(grande.isSelected() == true) {size = "Grande"; } 
		
//		휘핑 크림 옵션
		if(whipYes.isSelected() == true) { whip = "YES"; }
		else if(whipNo.isSelected() == true) { whip = "NO"; }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		플러스 버튼 클릭 시 가격과 갯수 변수 변화시키기
		Object obj = (JButton)e.getSource();
		if(obj.equals(PlusButton)) {
			count++;
			sumPrice = count * price;
//			System.out.printf("%d, %d\n", count, sumPrice);
		}
		if(obj.equals(minusButton)) {
			if(count > 0) { count--; sumPrice = mouseCount * price; if(count == 0) { sumPrice = 0;} }
			sumPrice = count * price;
//			System.out.printf("%d, %d\n", count, sumPrice);
		}
		if(obj.equals(backButton)) {
			mouseCount = 0;
			price = 0;
			sumPrice = 0;
			link = "";
			name = "";
			esShot = "";
			ice = "";
			size = "";
			whip = "";
			MenuOptionPage.count = 0;
		}
		
	}

}
