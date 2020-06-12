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
import javax.swing.JPanel;

public class MenuOptionPageExceptBeverage extends JFrame implements ActionListener{
	String name;
	public static int price;
	public static String link, menuCode;
	static int mouseCount;
	static int count = 0;
	static int sumPrice = mouseCount * price;
	
	String[] menuName = {"봄 딸기 라떼", "봄 딸기 밀크티", "버블 흑당 콜드브루", "버블 흑당 라떼", "    카페라떼", "흑당 콜드 브루", "    흑당 라떼", "옥수수 라떼", "다크 라이트 텀블러 블랙", "다크 라이트 텀블러 핑크", 
			"다크 라이트 텀블러 화이트", "    이디야 머그", "    양송이 버섯 스프", "    초코 마카롱", "    딸기 마카롱", "    바닐라 마카롱", "에그 베이컨 샌드위치", "페퍼로니 치즈 샌드위치", "포테이토 베이컨 스프", "갈릭 치즈 브래드", 
			"마일드 아메리카노", "오리지널 아메리카노", "    스페셜 에디션", "    이디야 블루", "    이디야 로스트", "    이디야 바이올렛"};
	
	JPanel panel = new JPanel();
	JPanel optionPanel = new JPanel();
	JButton PlusButton = new JButton();
	JButton minusButton = new JButton();
	JButton backButton = new JButton();
	JLabel productNumberLabel;
	
	DecimalFormat won = new DecimalFormat("#,##0");
	
	public MenuOptionPageExceptBeverage(String name, int price, String link, String menuCode, int sumPrice) {
		this.name = name;
		this.price = price;
		this.link = link;
		this.menuCode = menuCode;
		this.sumPrice = sumPrice;
		productNumberLabel = new JLabel(String.format("%02d", count));
		JFrame frame = new JFrame();
		frame.setTitle("MenuOptionPageExceptBeverage");
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
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(6371339));
		panel.setBounds(0, 0, 1500, 1000);
		frame.add(panel);
		panel.setLayout(null);
//		getContentPane().
		optionPanel.setBackground(Color.CYAN);
		optionPanel.setBounds(50, 430, 700, 450);
		optionPanel.setLayout(null);
		panel.add(optionPanel);
		
//		제품 이름 띄우기
		JLabel order2Label = new JLabel(name);
		order2Label.setBounds(50, 50, 500, 35);
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
		
//		제품 갯수 띄우기
		JLabel productNumLabel = new JLabel("제품 갯수");
		productNumLabel.setBounds(360, 215, 300, 50);
		productNumLabel.setFont(new Font("D2coding", Font.BOLD, 25));
		productNumLabel.setForeground(Color.WHITE);
		panel.add(productNumLabel);
		
		JLabel recoLabel = new JLabel("추천 메뉴");
		recoLabel.setBounds(50, 50, 300, 50);
		recoLabel.setFont(new Font("D2coding", Font.BOLD, 25));
		recoLabel.setForeground(Color.WHITE);
		optionPanel.add(recoLabel);
		
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
				frame.setVisible(false);
			}
			
		});
		
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
		
//		다른 메뉴 선택 버튼
		JButton otherMenuSelectButton = new JButton("다른 메뉴 선택");
		otherMenuSelectButton.setBounds(70, 900, 200, 50);
		otherMenuSelectButton.setFont(new Font("D2coding", Font.BOLD, 20));
		panel.add(otherMenuSelectButton);
		otherMenuSelectButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new OrderPage2();
			}
			
		});
		
//		추천 메뉴에서 선택 버튼
		JButton othreMenuSelectButton = new JButton("추천 메뉴");
		othreMenuSelectButton.setBounds(290, 900, 200, 50);
		othreMenuSelectButton.setFont(new Font("D2coding", Font.BOLD, 20));
		panel.add(othreMenuSelectButton);
		othreMenuSelectButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new OrderPage();
			}
			
		});
		
//		다크 라이트 텀블러 블랙 선택 시 실행
		if(name.equals(menuName[8])) {
			JLabel DLTPinkLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 핑크<br>Dark Light Tumbler Pink<html>");
			DLTPinkLabel.setBounds(50, 330, 160, 100);
			DLTPinkLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTPinkLabel);
			
			JButton DLTPinkImageButton = new JButton("");
			DLTPinkImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setBounds(50, 130, 200, 200);
			DLTPinkImageButton.setContentAreaFilled(false);
			DLTPinkImageButton.setBorderPainted(false);
			DLTPinkImageButton.setFocusPainted(false);
			optionPanel.add(DLTPinkImageButton);
			
			JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
			DLTWhiteLabel.setBounds(280, 330, 160, 100);
			DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTWhiteLabel);
			
			JButton DLTWhiteImageButton = new JButton("");
			DLTWhiteImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setBounds(260, 130, 200, 200);
			DLTWhiteImageButton.setContentAreaFilled(false);
			DLTWhiteImageButton.setBorderPainted(false);
			DLTWhiteImageButton.setFocusPainted(false);
			optionPanel.add(DLTWhiteImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
		
//		다크 라이트 텀블러 핑크 선택 시 실행
		if(name.equals(menuName[9])) {
			JLabel DLTBlackLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 블랙<br>Dark Light Tumbler Black<html>");
			DLTBlackLabel.setBounds(50, 330, 160, 100);
			DLTBlackLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTBlackLabel);
			
			JButton DLTBlackImageButton = new JButton("");
			DLTBlackImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setBounds(50, 130, 200, 200);
			DLTBlackImageButton.setContentAreaFilled(false);
			DLTBlackImageButton.setBorderPainted(false);
			DLTBlackImageButton.setFocusPainted(false);
			optionPanel.add(DLTBlackImageButton);
			
			JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
			DLTWhiteLabel.setBounds(280, 330, 160, 100);
			DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTWhiteLabel);
			
			JButton DLTWhiteImageButton = new JButton("");
			DLTWhiteImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setBounds(260, 130, 200, 200);
			DLTWhiteImageButton.setContentAreaFilled(false);
			DLTWhiteImageButton.setBorderPainted(false);
			DLTWhiteImageButton.setFocusPainted(false);
			optionPanel.add(DLTWhiteImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
//		다크 라이트 텀블러 화이트 선택 시 실행
		if(name.equals(menuName[10])) {
			JLabel DLTBlackLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 블랙<br>Dark Light Tumbler Black<html>");
			DLTBlackLabel.setBounds(50, 330, 160, 100);
			DLTBlackLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTBlackLabel);
			
			JButton DLTBlackImageButton = new JButton("");
			DLTBlackImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setBounds(30, 130, 200, 200);
			DLTBlackImageButton.setContentAreaFilled(false);
			DLTBlackImageButton.setBorderPainted(false);
			DLTBlackImageButton.setFocusPainted(false);
			optionPanel.add(DLTBlackImageButton);
			
			JLabel DLTPinkLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 핑크<br>Dark Light Tumbler Pink<html>");
			DLTPinkLabel.setBounds(280, 330, 160, 100);
			DLTPinkLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTPinkLabel);
			
			JButton DLTPinkImageButton = new JButton("");
			DLTPinkImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setBounds(260, 130, 200, 200);
			DLTPinkImageButton.setContentAreaFilled(false);
			DLTPinkImageButton.setBorderPainted(false);
			DLTPinkImageButton.setFocusPainted(false);
			optionPanel.add(DLTPinkImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
//		이디야 머그 선택 시 실행
		if(name.equals(menuName[11])) {
			JLabel chocoMacaronLabel = new JLabel("<html>&nbsp;초코 마카롱<br>Choco Macaron<html>");
			chocoMacaronLabel.setBounds(50, 330, 160, 100);
			chocoMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(chocoMacaronLabel);
			
			JButton chocoMacaronImageButton = new JButton("");
			chocoMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/chocoMacaron.png"));
			chocoMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/chocoMacaron.png"));
			chocoMacaronImageButton.setBounds(30, 130, 200, 200);
			chocoMacaronImageButton.setContentAreaFilled(false);
			chocoMacaronImageButton.setBorderPainted(false);
			chocoMacaronImageButton.setFocusPainted(false);
			optionPanel.add(chocoMacaronImageButton);
			
			JLabel strawberryMacaronLabel = new JLabel("<html>&nbsp;딸기 마카롱<br>strawberryMacaron<html>");
			strawberryMacaronLabel.setBounds(280, 330, 160, 100);
			strawberryMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(strawberryMacaronLabel);
			
			JButton strawberryMacaronImageButton = new JButton("");
			strawberryMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setBounds(260, 130, 200, 200);
			strawberryMacaronImageButton.setContentAreaFilled(false);
			strawberryMacaronImageButton.setBorderPainted(false);
			strawberryMacaronImageButton.setFocusPainted(false);
			optionPanel.add(strawberryMacaronImageButton);
			
			JLabel vanillaMacaronLabel = new JLabel("<html>&nbsp;바닐라 마카롱<br>vanillaMacaron<html>");
			vanillaMacaronLabel.setBounds(510, 330, 160, 100);
			vanillaMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(vanillaMacaronLabel);
			
			JButton vanillaMacaronImageButton = new JButton("");
			vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setBounds(450, 130, 200, 200);
			vanillaMacaronImageButton.setContentAreaFilled(false);
			vanillaMacaronImageButton.setBorderPainted(false);
			vanillaMacaronImageButton.setFocusPainted(false);
			optionPanel.add(vanillaMacaronImageButton);
		}
//		양송이 버섯 스프 선택 시 실행
		if(name.equals(menuName[12])) {
			JLabel strawberryMacaronLabel = new JLabel("<html>&nbsp;딸기 마카롱<br>strawberryMacaron<html>");
			strawberryMacaronLabel.setBounds(50, 330, 160, 100);
			strawberryMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(strawberryMacaronLabel);
			
			JButton strawberryMacaronImageButton = new JButton("");
			strawberryMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setBounds(30, 130, 200, 200);
			strawberryMacaronImageButton.setContentAreaFilled(false);
			strawberryMacaronImageButton.setBorderPainted(false);
			strawberryMacaronImageButton.setFocusPainted(false);
			optionPanel.add(strawberryMacaronImageButton);
			
			JLabel vanillaMacaronLabel = new JLabel("<html>&nbsp;바닐라 마카롱<br>vanillaMacaron<html>");
			vanillaMacaronLabel.setBounds(280, 330, 160, 100);
			vanillaMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(vanillaMacaronLabel);
			
			JButton vanillaMacaronImageButton = new JButton("");
			vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setBounds(260, 130, 200, 200);
			vanillaMacaronImageButton.setContentAreaFilled(false);
			vanillaMacaronImageButton.setBorderPainted(false);
			vanillaMacaronImageButton.setFocusPainted(false);
			optionPanel.add(vanillaMacaronImageButton);
			
			JLabel eggBaconGSandwichLabel = new JLabel("<html>&nbsp;에그 베이컨 샌드위치<br>eggBaconGSandwich<html>");
			eggBaconGSandwichLabel.setBounds(510, 330, 160, 100);
			eggBaconGSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(eggBaconGSandwichLabel);
			
			JButton eggBaconGSandwichImageButton = new JButton("");
			eggBaconGSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setBounds(450, 130, 200, 200);
			eggBaconGSandwichImageButton.setContentAreaFilled(false);
			eggBaconGSandwichImageButton.setBorderPainted(false);
			eggBaconGSandwichImageButton.setFocusPainted(false);
			optionPanel.add(eggBaconGSandwichImageButton);
		}
//		초코 마카롱 선택 시 실행
		if(name.equals(menuName[13])) {
			JLabel vanillaMacaronLabel = new JLabel("<html>&nbsp;바닐라 마카롱<br>vanillaMacaron<html>");
			vanillaMacaronLabel.setBounds(50, 330, 160, 100);
			vanillaMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(vanillaMacaronLabel);
			
			JButton vanillaMacaronImageButton = new JButton("");
			vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setBounds(30, 130, 200, 200);
			vanillaMacaronImageButton.setContentAreaFilled(false);
			vanillaMacaronImageButton.setBorderPainted(false);
			vanillaMacaronImageButton.setFocusPainted(false);
			optionPanel.add(vanillaMacaronImageButton);
			
			JLabel eggBaconGSandwichLabel = new JLabel("<html>&nbsp;에그 베이컨 샌드위치<br>eggBaconGSandwich<html>");
			eggBaconGSandwichLabel.setBounds(280, 330, 160, 100);
			eggBaconGSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(eggBaconGSandwichLabel);
			
			JButton eggBaconGSandwichImageButton = new JButton("");
			eggBaconGSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setBounds(260, 130, 200, 200);
			eggBaconGSandwichImageButton.setContentAreaFilled(false);
			eggBaconGSandwichImageButton.setBorderPainted(false);
			eggBaconGSandwichImageButton.setFocusPainted(false);
			optionPanel.add(eggBaconGSandwichImageButton);
			
			JLabel PeperoniCheeseSandwichLabel = new JLabel("<html>&nbsp;페퍼로니 치즈 샌드위치<br>PeperoniCheeseSandwich<html>");
			PeperoniCheeseSandwichLabel.setBounds(510, 330, 160, 100);
			PeperoniCheeseSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PeperoniCheeseSandwichLabel);
			
			JButton PeperoniCheeseSandwichImageButton = new JButton("");
			PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setBounds(450, 130, 200, 200);
			PeperoniCheeseSandwichImageButton.setContentAreaFilled(false);
			PeperoniCheeseSandwichImageButton.setBorderPainted(false);
			PeperoniCheeseSandwichImageButton.setFocusPainted(false);
			optionPanel.add(PeperoniCheeseSandwichImageButton);
		}
//		딸기 마카롱 선택 시 실행
		if(name.equals(menuName[14])) {
			JLabel eggBaconGSandwichLabel = new JLabel("<html>&nbsp;에그 베이컨 샌드위치<br>eggBaconGSandwich<html>");
			eggBaconGSandwichLabel.setBounds(50, 330, 160, 100);
			eggBaconGSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(eggBaconGSandwichLabel);
			
			JButton eggBaconGSandwichImageButton = new JButton("");
			eggBaconGSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/eggBaconGSandwich.png"));
			eggBaconGSandwichImageButton.setBounds(30, 130, 200, 200);
			eggBaconGSandwichImageButton.setContentAreaFilled(false);
			eggBaconGSandwichImageButton.setBorderPainted(false);
			eggBaconGSandwichImageButton.setFocusPainted(false);
			optionPanel.add(eggBaconGSandwichImageButton);
			
			JLabel PeperoniCheeseSandwichLabel = new JLabel("<html>&nbsp;페퍼로니 치즈 샌드위치<br>PeperoniCheeseSandwich<html>");
			PeperoniCheeseSandwichLabel.setBounds(280, 330, 160, 100);
			PeperoniCheeseSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PeperoniCheeseSandwichLabel);
			
			JButton PeperoniCheeseSandwichImageButton = new JButton("");
			PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setBounds(260, 130, 200, 200);
			PeperoniCheeseSandwichImageButton.setContentAreaFilled(false);
			PeperoniCheeseSandwichImageButton.setBorderPainted(false);
			PeperoniCheeseSandwichImageButton.setFocusPainted(false);
			optionPanel.add(PeperoniCheeseSandwichImageButton);
			
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(510, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(450, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
		}
//		바닐라 마카롱 선택 시 실행
		if(name.equals(menuName[15])) {
			JLabel PeperoniCheeseSandwichLabel = new JLabel("<html>&nbsp;페퍼로니 치즈 샌드위치<br>PeperoniCheeseSandwich<html>");
			PeperoniCheeseSandwichLabel.setBounds(50, 330, 160, 100);
			PeperoniCheeseSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PeperoniCheeseSandwichLabel);
			
			JButton PeperoniCheeseSandwichImageButton = new JButton("");
			PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setBounds(30, 130, 200, 200);
			PeperoniCheeseSandwichImageButton.setContentAreaFilled(false);
			PeperoniCheeseSandwichImageButton.setBorderPainted(false);
			PeperoniCheeseSandwichImageButton.setFocusPainted(false);
			optionPanel.add(PeperoniCheeseSandwichImageButton);
			
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(280, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(260, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
			
			JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
			galicCheeseBreadLabel.setBounds(510, 330, 160, 100);
			galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(galicCheeseBreadLabel);
			
			JButton galicCheeseBreadImageButton = new JButton("");
			galicCheeseBreadImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setBounds(450, 130, 200, 200);
			galicCheeseBreadImageButton.setContentAreaFilled(false);
			galicCheeseBreadImageButton.setBorderPainted(false);
			galicCheeseBreadImageButton.setFocusPainted(false);
			optionPanel.add(galicCheeseBreadImageButton);
		}
//		에그 베이컨 샌드위치 선택 시 실행
		if(name.equals(menuName[16])) {
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(50, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(30, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
			
			JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
			galicCheeseBreadLabel.setBounds(280, 330, 160, 100);
			galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(galicCheeseBreadLabel);
			
			JButton galicCheeseBreadImageButton = new JButton("");
			galicCheeseBreadImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setBounds(260, 130, 200, 200);
			galicCheeseBreadImageButton.setContentAreaFilled(false);
			galicCheeseBreadImageButton.setBorderPainted(false);
			galicCheeseBreadImageButton.setFocusPainted(false);
			optionPanel.add(galicCheeseBreadImageButton);
			
			JLabel mildAmericanoLabel = new JLabel("<html>&nbsp;마일드 아메리카노<br>mildAmericano<html>");
			mildAmericanoLabel.setBounds(510, 330, 160, 100);
			mildAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(mildAmericanoLabel);
			
			JButton mildAmericanoImageButton = new JButton("");
			mildAmericanoImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setBounds(450, 130, 200, 200);
			mildAmericanoImageButton.setContentAreaFilled(false);
			mildAmericanoImageButton.setBorderPainted(false);
			mildAmericanoImageButton.setFocusPainted(false);
			optionPanel.add(mildAmericanoImageButton);
		}
//		페퍼로니 치즈 샌드위치 선택 시 실행
		if(name.equals(menuName[17])) {
			JLabel originalAmericanoLabel = new JLabel("<html>&nbsp;오리지널 아메리카노<br>Original Americano<html>");
			originalAmericanoLabel.setBounds(50, 330, 160, 100);
			originalAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(originalAmericanoLabel);
			
			JButton originalAmericanoImageButton = new JButton("");
			originalAmericanoImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/originalAmericano.png"));
			originalAmericanoImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/originalAmericano.png"));
			originalAmericanoImageButton.setBounds(30, 130, 200, 200);
			originalAmericanoImageButton.setContentAreaFilled(false);
			originalAmericanoImageButton.setBorderPainted(false);
			originalAmericanoImageButton.setFocusPainted(false);
			optionPanel.add(originalAmericanoImageButton);
			
			JLabel specialEditionLabel = new JLabel("<html>&nbsp;스페셜 에디션<br>specialEdition<html>");
			specialEditionLabel.setBounds(280, 330, 160, 100);
			specialEditionLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(specialEditionLabel);
			
			JButton specialEditionImageButton = new JButton("");
			specialEditionImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/specialEdition.png"));
			specialEditionImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/specialEdition.png"));
			specialEditionImageButton.setBounds(260, 130, 200, 200);
			specialEditionImageButton.setContentAreaFilled(false);
			specialEditionImageButton.setBorderPainted(false);
			specialEditionImageButton.setFocusPainted(false);
			optionPanel.add(specialEditionImageButton);
			
			JLabel ediyaBlueLabel = new JLabel("<html>&nbsp;이디야 블루<br>ediyaBlue<html>");
			ediyaBlueLabel.setBounds(510, 330, 160, 100);
			ediyaBlueLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaBlueLabel);
			
			JButton ediyaBlueImageButton = new JButton("");
			ediyaBlueImageButton.setIcon(new ImageIcon(".\\src\\image\\coffeeBeans/ediyaBlue.png"));
			ediyaBlueImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\coffeeBeans/ediyaBlue.png"));
			ediyaBlueImageButton.setBounds(450, 130, 200, 200);
			ediyaBlueImageButton.setContentAreaFilled(false);
			ediyaBlueImageButton.setBorderPainted(false);
			ediyaBlueImageButton.setFocusPainted(false);
			optionPanel.add(ediyaBlueImageButton);
		}
//		마일드 아메리카노 선택 시 실행
		if(name.equals(menuName[18])) {
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(50, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(30, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
			
			JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
			galicCheeseBreadLabel.setBounds(280, 330, 160, 100);
			galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(galicCheeseBreadLabel);
			
			JButton galicCheeseBreadImageButton = new JButton("");
			galicCheeseBreadImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setBounds(260, 130, 200, 200);
			galicCheeseBreadImageButton.setContentAreaFilled(false);
			galicCheeseBreadImageButton.setBorderPainted(false);
			galicCheeseBreadImageButton.setFocusPainted(false);
			optionPanel.add(galicCheeseBreadImageButton);
			
			JLabel mildAmericanoLabel = new JLabel("<html>&nbsp;마일드 아메리카노<br>mildAmericano<html>");
			mildAmericanoLabel.setBounds(510, 330, 160, 100);
			mildAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(mildAmericanoLabel);
			
			JButton mildAmericanoImageButton = new JButton("");
			mildAmericanoImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setBounds(450, 130, 200, 200);
			mildAmericanoImageButton.setContentAreaFilled(false);
			mildAmericanoImageButton.setBorderPainted(false);
			mildAmericanoImageButton.setFocusPainted(false);
			optionPanel.add(mildAmericanoImageButton);
		}
		
		if(name.equals(menuName[19])) {
			JLabel DLTPinkLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 핑크<br>Dark Light Tumbler Pink<html>");
			DLTPinkLabel.setBounds(50, 330, 160, 100);
			DLTPinkLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTPinkLabel);
			
			JButton DLTPinkImageButton = new JButton("");
			DLTPinkImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrPink.png"));
			DLTPinkImageButton.setBounds(50, 130, 200, 200);
			DLTPinkImageButton.setContentAreaFilled(false);
			DLTPinkImageButton.setBorderPainted(false);
			DLTPinkImageButton.setFocusPainted(false);
			optionPanel.add(DLTPinkImageButton);
			
			JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
			DLTWhiteLabel.setBounds(280, 330, 160, 100);
			DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTWhiteLabel);
			
			JButton DLTWhiteImageButton = new JButton("");
			DLTWhiteImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setBounds(260, 130, 200, 200);
			DLTWhiteImageButton.setContentAreaFilled(false);
			DLTWhiteImageButton.setBorderPainted(false);
			DLTWhiteImageButton.setFocusPainted(false);
			optionPanel.add(DLTWhiteImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
		if(name.equals(menuName[20])) {
			JLabel DLTBlackLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 블랙<br>Dark Light Tumbler Black<html>");
			DLTBlackLabel.setBounds(50, 330, 160, 100);
			DLTBlackLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTBlackLabel);
			
			JButton DLTBlackImageButton = new JButton("");
			DLTBlackImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setBounds(50, 130, 200, 200);
			DLTBlackImageButton.setContentAreaFilled(false);
			DLTBlackImageButton.setBorderPainted(false);
			DLTBlackImageButton.setFocusPainted(false);
			optionPanel.add(DLTBlackImageButton);
			
			JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
			DLTWhiteLabel.setBounds(280, 330, 160, 100);
			DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTWhiteLabel);
			
			JButton DLTWhiteImageButton = new JButton("");
			DLTWhiteImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setBounds(260, 130, 200, 200);
			DLTWhiteImageButton.setContentAreaFilled(false);
			DLTWhiteImageButton.setBorderPainted(false);
			DLTWhiteImageButton.setFocusPainted(false);
			optionPanel.add(DLTWhiteImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
		if(name.equals(menuName[21])) {
			JLabel DLTBlackLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 블랙<br>Dark Light Tumbler Black<html>");
			DLTBlackLabel.setBounds(50, 330, 160, 100);
			DLTBlackLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTBlackLabel);
			
			JButton DLTBlackImageButton = new JButton("");
			DLTBlackImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrBlack.png"));
			DLTBlackImageButton.setBounds(50, 130, 200, 200);
			DLTBlackImageButton.setContentAreaFilled(false);
			DLTBlackImageButton.setBorderPainted(false);
			DLTBlackImageButton.setFocusPainted(false);
			optionPanel.add(DLTBlackImageButton);
			
			JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
			DLTWhiteLabel.setBounds(280, 330, 160, 100);
			DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(DLTWhiteLabel);
			
			JButton DLTWhiteImageButton = new JButton("");
			DLTWhiteImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/dailyLightTumblrWhite.png"));
			DLTWhiteImageButton.setBounds(260, 130, 200, 200);
			DLTWhiteImageButton.setContentAreaFilled(false);
			DLTWhiteImageButton.setBorderPainted(false);
			DLTWhiteImageButton.setFocusPainted(false);
			optionPanel.add(DLTWhiteImageButton);
			
			JLabel ediyaMugLabel = new JLabel("<html>&nbsp;이디야 머그<br>EDIYA Mug<html>");
			ediyaMugLabel.setBounds(510, 330, 160, 100);
			ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaMugLabel);
			
			JButton ediyaMugImageButton = new JButton("");
			ediyaMugImageButton.setIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\MD/ediyaMug.png"));
			ediyaMugImageButton.setBounds(450, 130, 200, 200);
			ediyaMugImageButton.setContentAreaFilled(false);
			ediyaMugImageButton.setBorderPainted(false);
			ediyaMugImageButton.setFocusPainted(false);
			optionPanel.add(ediyaMugImageButton);
		}
		if(name.equals(menuName[22])) {
			JLabel chocoMacaronLabel = new JLabel("<html>&nbsp;초코 마카롱<br>Choco Macaron<html>");
			chocoMacaronLabel.setBounds(50, 330, 160, 100);
			chocoMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(chocoMacaronLabel);
			
			JButton chocoMacaronImageButton = new JButton("");
			chocoMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/chocoMacaron.png"));
			chocoMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/chocoMacaron.png"));
			chocoMacaronImageButton.setBounds(30, 130, 200, 200);
			chocoMacaronImageButton.setContentAreaFilled(false);
			chocoMacaronImageButton.setBorderPainted(false);
			chocoMacaronImageButton.setFocusPainted(false);
			optionPanel.add(chocoMacaronImageButton);
			
			JLabel strawberryMacaronLabel = new JLabel("<html>&nbsp;딸기 마카롱<br>strawberryMacaron<html>");
			strawberryMacaronLabel.setBounds(280, 330, 160, 100);
			strawberryMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(strawberryMacaronLabel);
			
			JButton strawberryMacaronImageButton = new JButton("");
			strawberryMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/strawberryMacaron.png"));
			strawberryMacaronImageButton.setBounds(260, 130, 200, 200);
			strawberryMacaronImageButton.setContentAreaFilled(false);
			strawberryMacaronImageButton.setBorderPainted(false);
			strawberryMacaronImageButton.setFocusPainted(false);
			optionPanel.add(strawberryMacaronImageButton);
			
			JLabel vanillaMacaronLabel = new JLabel("<html>&nbsp;바닐라 마카롱<br>vanillaMacaron<html>");
			vanillaMacaronLabel.setBounds(510, 330, 160, 100);
			vanillaMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(vanillaMacaronLabel);
			
			JButton vanillaMacaronImageButton = new JButton("");
			vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			vanillaMacaronImageButton.setBounds(450, 130, 200, 200);
			vanillaMacaronImageButton.setContentAreaFilled(false);
			vanillaMacaronImageButton.setBorderPainted(false);
			vanillaMacaronImageButton.setFocusPainted(false);
			optionPanel.add(vanillaMacaronImageButton);
		}
		if(name.equals(menuName[23])) {
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(50, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(30, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
			
			JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
			galicCheeseBreadLabel.setBounds(280, 330, 160, 100);
			galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(galicCheeseBreadLabel);
			
			JButton galicCheeseBreadImageButton = new JButton("");
			galicCheeseBreadImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setBounds(260, 130, 200, 200);
			galicCheeseBreadImageButton.setContentAreaFilled(false);
			galicCheeseBreadImageButton.setBorderPainted(false);
			galicCheeseBreadImageButton.setFocusPainted(false);
			optionPanel.add(galicCheeseBreadImageButton);
			
			JLabel mildAmericanoLabel = new JLabel("<html>&nbsp;마일드 아메리카노<br>mildAmericano<html>");
			mildAmericanoLabel.setBounds(510, 330, 160, 100);
			mildAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(mildAmericanoLabel);
			
			JButton mildAmericanoImageButton = new JButton("");
			mildAmericanoImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/mildAmericano.png"));
			mildAmericanoImageButton.setBounds(450, 130, 200, 200);
			mildAmericanoImageButton.setContentAreaFilled(false);
			mildAmericanoImageButton.setBorderPainted(false);
			mildAmericanoImageButton.setFocusPainted(false);
			optionPanel.add(mildAmericanoImageButton);
		}
		if(name.equals(menuName[24])) {
			JLabel PeperoniCheeseSandwichLabel = new JLabel("<html>&nbsp;페퍼로니 치즈 샌드위치<br>PeperoniCheeseSandwich<html>");
			PeperoniCheeseSandwichLabel.setBounds(50, 330, 160, 100);
			PeperoniCheeseSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PeperoniCheeseSandwichLabel);
			
			JButton PeperoniCheeseSandwichImageButton = new JButton("");
			PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PeperoniCheeseSandwich.png"));
			PeperoniCheeseSandwichImageButton.setBounds(30, 130, 200, 200);
			PeperoniCheeseSandwichImageButton.setContentAreaFilled(false);
			PeperoniCheeseSandwichImageButton.setBorderPainted(false);
			PeperoniCheeseSandwichImageButton.setFocusPainted(false);
			optionPanel.add(PeperoniCheeseSandwichImageButton);
			
			JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
			PotatoBaconSoupLabel.setBounds(280, 330, 160, 100);
			PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(PotatoBaconSoupLabel);
			
			JButton PotatoBaconSoupImageButton = new JButton("");
			PotatoBaconSoupImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/PotatoBaconSoup.png"));
			PotatoBaconSoupImageButton.setBounds(260, 130, 200, 200);
			PotatoBaconSoupImageButton.setContentAreaFilled(false);
			PotatoBaconSoupImageButton.setBorderPainted(false);
			PotatoBaconSoupImageButton.setFocusPainted(false);
			optionPanel.add(PotatoBaconSoupImageButton);
			
			JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
			galicCheeseBreadLabel.setBounds(510, 330, 160, 100);
			galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(galicCheeseBreadLabel);
			
			JButton galicCheeseBreadImageButton = new JButton("");
			galicCheeseBreadImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/galicCheeseBread.png"));
			galicCheeseBreadImageButton.setBounds(450, 130, 200, 200);
			galicCheeseBreadImageButton.setContentAreaFilled(false);
			galicCheeseBreadImageButton.setBorderPainted(false);
			galicCheeseBreadImageButton.setFocusPainted(false);
			optionPanel.add(galicCheeseBreadImageButton);
		}
		if(name.equals(menuName[25])) {
			JLabel originalAmericanoLabel = new JLabel("<html>&nbsp;오리지널 아메리카노<br>Original Americano<html>");
			originalAmericanoLabel.setBounds(50, 330, 160, 100);
			originalAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(originalAmericanoLabel);
			
			JButton originalAmericanoImageButton = new JButton("");
			originalAmericanoImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/originalAmericano.png"));
			originalAmericanoImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/originalAmericano.png"));
			originalAmericanoImageButton.setBounds(30, 130, 200, 200);
			originalAmericanoImageButton.setContentAreaFilled(false);
			originalAmericanoImageButton.setBorderPainted(false);
			originalAmericanoImageButton.setFocusPainted(false);
			optionPanel.add(originalAmericanoImageButton);
			
			JLabel specialEditionLabel = new JLabel("<html>&nbsp;스페셜 에디션<br>specialEdition<html>");
			specialEditionLabel.setBounds(280, 330, 160, 100);
			specialEditionLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(specialEditionLabel);
			
			JButton specialEditionImageButton = new JButton("");
			specialEditionImageButton.setIcon(new ImageIcon(".\\src\\image\\beanist/specialEdition.png"));
			specialEditionImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beanist/specialEdition.png"));
			specialEditionImageButton.setBounds(260, 130, 200, 200);
			specialEditionImageButton.setContentAreaFilled(false);
			specialEditionImageButton.setBorderPainted(false);
			specialEditionImageButton.setFocusPainted(false);
			optionPanel.add(specialEditionImageButton);
			
			JLabel ediyaBlueLabel = new JLabel("<html>&nbsp;이디야 블루<br>ediyaBlue<html>");
			ediyaBlueLabel.setBounds(510, 330, 160, 100);
			ediyaBlueLabel.setFont(new Font("D2coding", Font.BOLD, 13));
			optionPanel.add(ediyaBlueLabel);
			
			JButton ediyaBlueImageButton = new JButton("");
			ediyaBlueImageButton.setIcon(new ImageIcon(".\\src\\image\\coffeeBeans/ediyaBlue.png"));
			ediyaBlueImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\coffeeBeans/ediyaBlue.png"));
			ediyaBlueImageButton.setBounds(450, 130, 200, 200);
			ediyaBlueImageButton.setContentAreaFilled(false);
			ediyaBlueImageButton.setBorderPainted(false);
			ediyaBlueImageButton.setFocusPainted(false);
			optionPanel.add(ediyaBlueImageButton);
		}
		
//		확인 버튼
		JButton finalButton = new JButton("확인");
		finalButton.setBounds(520, 900, 200, 50);
		finalButton.setFont(new Font("D2coding", Font.BOLD, 20));
		panel.add(finalButton);
		finalButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new PayPageExceptBeverage(name, price, link, menuCode, sumPrice, count);
			}
			
		});
		
		frame.setVisible(true);
	}
	
	public MenuOptionPageExceptBeverage() {}

	public static void main(String[] args) {
		MenuOptionPageExceptBeverage window = new MenuOptionPageExceptBeverage();
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
			menuCode = "";
			MenuOptionPageExceptBeverage.count = 0;
		}
	}

}
