package team.order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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
import javax.swing.JScrollPane;

public class OrderPage2 extends JPanel{

	JPanel panel = new JPanel();
	JPanel menuBGPanel = new JPanel();
	JPanel beveragePanel = new JPanel();
	JPanel MDPanel = new JPanel();
	JPanel bakeryPanel = new JPanel();
	JPanel beanistPanel = new JPanel();
	JPanel beanPanel = new JPanel();
	
	Scrollbar menuScroll = new Scrollbar();
	JScrollPane scroll;
	
	Dimension d = getSize();
	ImageIcon beveragePanelBG = new ImageIcon(".\\src\\image/beveragePanelBG.png");
	
	String[] menuName = {"봄 딸기 라떼", "봄 딸기 밀크티", "버블 흑당 콜드브루", "버블 흑당 라떼", "    카페라떼", "흑당 콜드 브루", "    흑당 라떼", "옥수수 라떼", "다크 라이트 텀블러 블랙", "다크 라이트 텀블러 핑크", 
			"다크 라이트 텀블러 화이트", "    이디야 머그", "    양송이 버섯 스프", "    초코 마카롱", "    딸기 마카롱", "    바닐라 마카롱", "에그 베이컨 샌드위치", "페퍼로니 치즈 샌드위치", "포테이토 베이컨 스프", "갈릭 치즈 브래드", 
			"마일드 아메리카노", "오리지널 아메리카노", "    스페셜 에디션", "    이디야 블루", "    이디야 로스트", "    이디야 바이올렛"};
	int[] arMenuPrice = {3500, 4500, 5500, 6500, 3500, 5500, 6000, 5000, 10000, 10000, 10000, 5000, 
			2000, 2500, 2500, 2500, 5000, 5000, 5000, 5000, 15000, 15000, 20000, 7000, 8000, 9000};
	String[] menuCode = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800", "1900", 
			"2000", "2100", "2200", "2300", "2400", "2500", "2600"};
	String bomstrawberryLatteImageButtonLink = ".\\src\\image\\beverage/bomStraberryLatte.png", bomstrawberryLatteImageButtonLinkSelected = ".\\src\\image\\beverage/bomStraberryLatte(selected).png";
	String bomstrawberryMilkTeaImageButtonLink = ".\\src\\image\\beverage/bomStrawberryMilkTea.png", bomstrawberryMilkTeaImageButtonLinkSelected = ".\\src\\image\\beverage/bomStrawberryMilkTea(selected).png";
	String bubbleHColdBrewImageButtonLink = ".\\src\\image\\beverage/bubbleHColdBrew.png", bubbleHColdBrewImageButtonLinkSelected = ".\\src\\image\\beverage/bubbleHColdBrew(selected).png";
	String bubbleHLatteImageButtonLink = ".\\src\\image\\beverage/bubbleHLatte.png", bubbleHLatteImageButtonLinkSelected = ".\\src\\image\\beverage/bubbleHLatte(selected).png";
	String cafeLatteImageButtonLink = ".\\src\\image\\beverage/cafeLatte.png", cafeLatteImageButtonLinkSelected = ".\\src\\image\\beverage/cafeLatte(selected).png"; 
	String hColdBrewImageButtonLink = ".\\src\\image\\beverage/hColdBrew.png", hColdBrewImageButtonLinkSelected = ".\\src\\image\\beverage/hColdBrew(selected).png"; 
	String hLatteImageButtonLink = ".\\src\\image\\beverage/hLatte.png", hLatteImageButtonLinkSelected = ".\\src\\image\\beverage/hLatte(selected).png"; 
	String oksusuLatteImageButtonLink = ".\\src\\image\\beverage/oksusuLatte.png", oksusuLatteImageButtonLinkSelected = ".\\src\\image\\beverage/oksusuLatte(selected).png"; 
	String DLTBlackImageButtonLink = ".\\src\\image\\MD/dailyLightTumblrBlack.png", DLTBlackImageButtonLinkSelected = ".\\src\\image\\MD/dailyLightTumblrBlack(selected).png"; 
	String DLTPinkImageButtonLink = ".\\src\\image\\MD/dailyLightTumblrPink.png", DLTPinkImageButtonLinkSelected = ".\\src\\image\\MD/dailyLightTumblrPink(selected).png"; 
	String DLTWhiteImageButtonLink = ".\\src\\image\\MD/dailyLightTumblrWhite.png", DLTWhiteImageButtonLinkSelected = ".\\src\\image\\MD/dailyLightTumblrWhite(selected).png"; 
	String ediyaMugImageButtonLink = ".\\src\\image\\MD/ediyaMug.png", ediyaMugImageButtonLinkSelected = ".\\src\\image\\MD/ediyaMug(selected).png"; 
	String buttonMushroomSoupImageButtonLink = ".\\src\\image\\bakery/buttonMushroomSoup.png", buttonMushroomSoupImageButtonLinkSelected = ".\\src\\image\\bakery/buttonMushroomSoup(selected).png"; 
	String chocoMacaronImageButtonLink = ".\\src\\image\\bakery/chocoMacaron.png", chocoMacaronImageButtonLinkSelected = ".\\src\\image\\bakery/chocoMacaron(selected).png"; 
	String strawberryMacaronImageButtonLink = ".\\src\\image\\bakery/strawberryMacaron.png", strawberryMacaronImageButtonLinkSelected = ".\\src\\image\\bakery/strawberryMacaron(selected).png"; 
	String vanillaMacaronImageButtonLink = ".\\src\\image\\bakery/vanillaMacaron.png", vanillaMacaronImageButtonLinkSelected = ".\\src\\image\\bakery/vanillaMacaron(selected).png"; 
	String eggBaconGSandwichImageButtonLink = ".\\src\\image\\bakery/eggBaconGSandwich.png", eggBaconGSandwichImageButtonLinkSelected = ".\\src\\image\\bakery/eggBaconGSandwich(selected).png"; 
	String PeperoniCheeseSandwichImageButtonLink = ".\\src\\image\\bakery/PeperoniCheeseSandwich.png", PeperoniCheeseSandwichImageButtonLinkSelected = ".\\src\\image\\bakery/PeperoniCheeseSandwich(selected).png";
	String PotatoBaconSoupImageButtonLink = ".\\src\\image\\bakery/PotatoBaconSoup.png", PotatoBaconSoupImageButtonLinkSelected = ".\\src\\image\\bakery/PotatoBaconSoup(selected).png";
	String galicCheeseBreadImageButtonLink = ".\\src\\image\\bakery/galicCheeseBread.png", galicCheeseBreadImageButtonLinkSelected = ".\\src\\image\\bakery/galicCheeseBread(selected).png";
	String mildAmericanoImageButtonLink = ".\\src\\image\\beanist/mildAmericano.png", mildAmericanoImageButtonLinkSelected = ".\\src\\image\\beanist/mildAmericano(selected).png";
	String originalAmericanoImageButtonLink = ".\\src\\image\\beanist/originalAmericano.png", originalAmericanoImageButtonLinkSelected = ".\\src\\image\\beanist/originalAmericano(selected).png";
	String specialEditionImageButtonLink = ".\\src\\image\\beanist/specialEdition.png", specialEditionImageButtonLinkSelected = ".\\src\\image\\beanist/specialEdition(selected).png";
	String ediyablueImageButtonLink = ".\\src\\image\\coffeeBeans/ediyablue.png", ediyablueImageButtonLinkSelected = ".\\src\\image\\coffeeBeans/ediyablue(selected).png";
	String ediyaRoastImageButtonLink = ".\\src\\image\\coffeeBeans/ediyaRoast.png", ediyaRoastImageButtonLinkSelected = ".\\src\\image\\coffeeBeans/ediyaRoast(selected).png";
	String ediyaVioletImageButtonLink = ".\\src\\image\\coffeeBeans/ediyaRoast.png", ediyaVioletImageButtonLinkSelected = ".\\src\\image\\coffeeBeans/ediyaRoast(selected).png";
	
	DecimalFormat df = new DecimalFormat("#,##0");
	
	public OrderPage2() {
		OrderWindow();
		
	}
	
	public void OrderWindow() {
		
		JFrame frame = new JFrame();
		
		frame.setTitle("OrderPage2");
		frame.setBounds(400, 0, 800, 1000);
		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); => 작업할 땐 켜놓기
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
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel orderLabel = new JLabel("주문하기");
		orderLabel.setBounds(330, 50, 130, 35);
		orderLabel.setFont(new Font("D2coding",	Font.BOLD, 30));
		orderLabel.setForeground(Color.WHITE);
		panel.add(orderLabel);
		
		JLabel LineLabel = new JLabel("<html>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<br>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■</html>");
		LineLabel.setBounds(0, 90, 800, 35);
		LineLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		LineLabel.setForeground(Color.WHITE);
		panel.add(LineLabel);
		
		menuBGPanel.setBounds(0, 127, 800, 835);
		menuBGPanel.setBackground(Color.CYAN);
		menuBGPanel.setLayout(null);
		panel.add(menuBGPanel);
		
		beveragePanel.setBounds(0, 60, 800, 780);
		beveragePanel.setBackground(Color.WHITE);
		beveragePanel.setLayout(null);
		menuBGPanel.add(beveragePanel);
		
		MDPanel.setBounds(0, 60, 800, 780);
		MDPanel.setBackground(Color.WHITE);
		MDPanel.setLayout(null);
		
		bakeryPanel.setBounds(0, 60, 800, 780);
		bakeryPanel.setBackground(Color.WHITE);
		bakeryPanel.setLayout(null);
		
		beanistPanel.setBounds(0, 60, 800, 780);
		beanistPanel.setBackground(Color.WHITE);
		beanistPanel.setLayout(null);
		
		beanPanel.setBounds(0, 60, 800, 780);
		beanPanel.setBackground(Color.WHITE);
		beanPanel.setLayout(null);
		
		menuScroll.setBounds(770, 0, 20, 1500);
		beveragePanel.add(menuScroll);
		
		
//		뒤로가기 버튼
		JButton backButton = new JButton();
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
//				payButton을 누르면 결제 내역 창을 띄우기
				frame.setVisible(false);
			}
			
		});
		
		
//		나의 메뉴 위치 설정(bomstrawberryLatte)
		JLabel bomstrawberryLatte1Label = new JLabel("<html>&nbsp;봄 스트로베리 라떼<br>Bom strawberry Latte<html>");
		bomstrawberryLatte1Label.setBounds(80, 220, 140, 100);
		bomstrawberryLatte1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(bomstrawberryLatte1Label);
		
		JButton bomstrawberryLatteImageButton = new JButton("");
		bomstrawberryLatteImageButton.setIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
		bomstrawberryLatteImageButton.setSelectedIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
		bomstrawberryLatteImageButton.setBounds(50, 40, 200, 200);
		bomstrawberryLatteImageButton.setContentAreaFilled(false);
		bomstrawberryLatteImageButton.setBorderPainted(false);
		bomstrawberryLatteImageButton.setFocusPainted(false);
		beveragePanel.add(bomstrawberryLatteImageButton);
		bomstrawberryLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(bomstrawberryLatteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[0]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					MenuOptionPage로 이동
					new MenuOptionPage(menuName[0], arMenuPrice[0], bomstrawberryLatteImageButtonLink, "", "", "", "", 0, menuCode[0]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bomstrawberryLatteImageButton.setIcon(new ImageIcon(bomstrawberryLatteImageButtonLinkSelected));
				bomstrawberryLatteImageButton.setSelectedIcon(new ImageIcon(bomstrawberryLatteImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bomstrawberryLatteImageButton.setIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
				bomstrawberryLatteImageButton.setSelectedIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
			}
		});
		
		menuScroll.addAdjustmentListener(new AdjustmentListener() {
//			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				System.out.println(e.getAdjustable().getValue());
				
				
				
			}
		});
		
//		나의 메뉴 위치 설정(bomstrawberryMilkTea)
		JLabel bomstrawberryMilkTeaLabel = new JLabel("<html>봄 스트로베리 밀크 티<br>Bom strawberry MilkTea<html>");
		bomstrawberryMilkTeaLabel.setBounds(300, 220, 160, 100);
		bomstrawberryMilkTeaLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(bomstrawberryMilkTeaLabel);
		
		JButton bomstrawberryMilkTeaImageButton = new JButton("");
		bomstrawberryMilkTeaImageButton.setIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
		bomstrawberryMilkTeaImageButton.setSelectedIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
		bomstrawberryMilkTeaImageButton.setBounds(280, 40, 200, 200);
		bomstrawberryMilkTeaImageButton.setContentAreaFilled(false);
		bomstrawberryMilkTeaImageButton.setBorderPainted(false);
		bomstrawberryMilkTeaImageButton.setFocusPainted(false);
		beveragePanel.add(bomstrawberryMilkTeaImageButton);
		bomstrawberryMilkTeaImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(bomstrawberryMilkTeaImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[1]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[1], arMenuPrice[1], bomstrawberryMilkTeaImageButtonLink, "", "", "", "", 0, menuCode[1]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				bomstrawberryMilkTeaImageButton.setIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLinkSelected));
				bomstrawberryMilkTeaImageButton.setSelectedIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bomstrawberryMilkTeaImageButton.setIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
				bomstrawberryMilkTeaImageButton.setSelectedIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(bubbleHColdBrew)
		JLabel bubbleHColdBrewLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;버블 흑당 콜드브루<br>Bubble Muscovado Cold Brew<html>");
		bubbleHColdBrewLabel.setBounds(520, 220, 200, 100);
		bubbleHColdBrewLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(bubbleHColdBrewLabel);
		
		JButton bubbleHColdBrewImageButton = new JButton("");
		bubbleHColdBrewImageButton.setIcon(new ImageIcon(bubbleHColdBrewImageButtonLink));
		bubbleHColdBrewImageButton.setSelectedIcon(new ImageIcon(bubbleHColdBrewImageButtonLink));
		bubbleHColdBrewImageButton.setBounds(510, 40, 200, 200);
		bubbleHColdBrewImageButton.setContentAreaFilled(false);
		bubbleHColdBrewImageButton.setBorderPainted(false);
		bubbleHColdBrewImageButton.setFocusPainted(false);
		beveragePanel.add(bubbleHColdBrewImageButton);
		bubbleHColdBrewImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(bubbleHColdBrewImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[2]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[2], arMenuPrice[2], bubbleHColdBrewImageButtonLink, "", "", "", "", 0,menuCode[2]);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bubbleHColdBrewImageButton.setIcon(new ImageIcon(bubbleHColdBrewImageButtonLinkSelected));
				bubbleHColdBrewImageButton.setSelectedIcon(new ImageIcon(bubbleHColdBrewImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bubbleHColdBrewImageButton.setIcon(new ImageIcon(bubbleHColdBrewImageButtonLink));
				bubbleHColdBrewImageButton.setSelectedIcon(new ImageIcon(bubbleHColdBrewImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(bubbleHLatte)
		JLabel bubbleHLatteLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;버블 흑당 라떼<br>Bubble Muscovado Latte<html>");
		bubbleHLatteLabel.setBounds(80, 450, 200, 100);
		bubbleHLatteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(bubbleHLatteLabel);
		
		JButton bubbleHLatteImageButton = new JButton("");
		bubbleHLatteImageButton.setIcon(new ImageIcon(bubbleHLatteImageButtonLink));
		bubbleHLatteImageButton.setSelectedIcon(new ImageIcon(bubbleHLatteImageButtonLink));
		bubbleHLatteImageButton.setBounds(50, 290, 200, 200);
		bubbleHLatteImageButton.setContentAreaFilled(false);
		bubbleHLatteImageButton.setBorderPainted(false);
		bubbleHLatteImageButton.setFocusPainted(false);
		beveragePanel.add(bubbleHLatteImageButton);
		bubbleHLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(bubbleHLatteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[3]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[3], arMenuPrice[3], bubbleHLatteImageButtonLink, "", "", "", "", 0,menuCode[3]);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				bubbleHLatteImageButton.setIcon(new ImageIcon(bubbleHLatteImageButtonLinkSelected));
				bubbleHLatteImageButton.setSelectedIcon(new ImageIcon(bubbleHLatteImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bubbleHLatteImageButton.setIcon(new ImageIcon(bubbleHLatteImageButtonLink));
				bubbleHLatteImageButton.setSelectedIcon(new ImageIcon(bubbleHLatteImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(cafeLatte)
		JLabel cafeLatteLabel = new JLabel("<html>카페 라떼<br>cafeLatte<html>");
		cafeLatteLabel.setBounds(340, 450, 160, 100);
		cafeLatteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(cafeLatteLabel);
		
		JButton cafeLatteImageButton = new JButton("");
		cafeLatteImageButton.setIcon(new ImageIcon(cafeLatteImageButtonLink));
		cafeLatteImageButton.setSelectedIcon(new ImageIcon(cafeLatteImageButtonLink));
		cafeLatteImageButton.setBounds(280, 290, 200, 200);
		cafeLatteImageButton.setContentAreaFilled(false);
		cafeLatteImageButton.setBorderPainted(false);
		cafeLatteImageButton.setFocusPainted(false);
		beveragePanel.add(cafeLatteImageButton);
		cafeLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(cafeLatteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[4]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[4], arMenuPrice[4], cafeLatteImageButtonLink, "", "", "", "", 0,menuCode[4]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cafeLatteImageButton.setIcon(new ImageIcon(cafeLatteImageButtonLinkSelected));
				cafeLatteImageButton.setSelectedIcon(new ImageIcon(cafeLatteImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cafeLatteImageButton.setIcon(new ImageIcon(".\\src\\image\\beverage/cafelatte.png"));
				cafeLatteImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\beverage/cafelatte.png"));
			}
		});
		
//		나의 메뉴 위치 설정(hColdBrew)
		JLabel hColdBrewLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;흑당 콜드브루<br>Muscovado Cold Brew<html>");
		hColdBrewLabel.setBounds(540, 450, 200, 100);
		hColdBrewLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(hColdBrewLabel);
		
		JButton hColdBrewImageButton = new JButton("");
		hColdBrewImageButton.setIcon(new ImageIcon(hColdBrewImageButtonLink));
		hColdBrewImageButton.setSelectedIcon(new ImageIcon(hColdBrewImageButtonLink));
		hColdBrewImageButton.setBounds(510, 290, 200, 200);
		hColdBrewImageButton.setContentAreaFilled(false);
		hColdBrewImageButton.setBorderPainted(false);
		hColdBrewImageButton.setFocusPainted(false);
		beveragePanel.add(hColdBrewImageButton);
		hColdBrewImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(hColdBrewImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[5]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[5], arMenuPrice[5], hColdBrewImageButtonLink, "", "", "", "", 0,menuCode[5]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				hColdBrewImageButton.setIcon(new ImageIcon(hColdBrewImageButtonLinkSelected));
				hColdBrewImageButton.setSelectedIcon(new ImageIcon(hColdBrewImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hColdBrewImageButton.setIcon(new ImageIcon(hColdBrewImageButtonLink));
				hColdBrewImageButton.setSelectedIcon(new ImageIcon(hColdBrewImageButtonLink));
			}
		});

//		나의 메뉴 위치 설정(hLatte)
		JLabel hLatteLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;흑당 라떼<br>Muscovado Latte<html>");
		hLatteLabel.setBounds(90, 680, 200, 100);
		hLatteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(hLatteLabel);
		
		JButton hLatteImageButton = new JButton("");
		hLatteImageButton.setIcon(new ImageIcon(hLatteImageButtonLink));
		hLatteImageButton.setSelectedIcon(new ImageIcon(hLatteImageButtonLink));
		hLatteImageButton.setBounds(55, 530, 200, 200);
		hLatteImageButton.setContentAreaFilled(false);
		hLatteImageButton.setBorderPainted(false);
		hLatteImageButton.setFocusPainted(false);
		beveragePanel.add(hLatteImageButton);
		hLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(hLatteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[6]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[6], arMenuPrice[6], hLatteImageButtonLink, "", "", "", "", 0,menuCode[6]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				hLatteImageButton.setIcon(new ImageIcon(hLatteImageButtonLinkSelected));
				hLatteImageButton.setSelectedIcon(new ImageIcon(hLatteImageButtonLinkSelected));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hLatteImageButton.setIcon(new ImageIcon(hLatteImageButtonLink));
				hLatteImageButton.setSelectedIcon(new ImageIcon(hLatteImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(oksusuLatte)
		JLabel oksusuLatteLabel = new JLabel("<html>&nbsp;&nbsp;옥수수 라떼<br>&nbsp;Oksusu Latte<html>");
		oksusuLatteLabel.setBounds(320, 700, 200, 100);
		oksusuLatteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beveragePanel.add(oksusuLatteLabel);
		
		JButton oksusuLatteImageButton = new JButton("");
		oksusuLatteImageButton.setIcon(new ImageIcon(oksusuLatteImageButtonLink));
		oksusuLatteImageButton.setSelectedIcon(new ImageIcon(oksusuLatteImageButtonLink));
		oksusuLatteImageButton.setBounds(270, 530, 200, 200);
		oksusuLatteImageButton.setContentAreaFilled(false);
		oksusuLatteImageButton.setBorderPainted(false);
		oksusuLatteImageButton.setFocusPainted(false);
		beveragePanel.add(oksusuLatteImageButton);
		oksusuLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(oksusuLatteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[7]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[7], arMenuPrice[7], oksusuLatteImageButtonLink, "", "", "", "", 0,menuCode[7]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				oksusuLatteImageButton.setIcon(new ImageIcon(oksusuLatteImageButtonLinkSelected));
				oksusuLatteImageButton.setSelectedIcon(new ImageIcon(oksusuLatteImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				oksusuLatteImageButton.setIcon(new ImageIcon(oksusuLatteImageButtonLink));
				oksusuLatteImageButton.setSelectedIcon(new ImageIcon(oksusuLatteImageButtonLink));
			}
		});
		
//		배너 버튼
		JButton beverageImageButton = new JButton("음료");
		JButton MDImageButton = new JButton("MD");
		JButton bakeryImageButton = new JButton("Bakery");
		JButton beanistImageButton = new JButton("Beanist");
		JButton coffeeBeansImageButton = new JButton("Beans");
		
		beverageImageButton.setBounds(0, 0, 160, 60);
		beverageImageButton.setFont(new Font("D2coding", Font.BOLD, 30));
		beverageImageButton.setBackground(Color.white);
		beverageImageButton.setBorderPainted(false);
		menuBGPanel.add(beverageImageButton);
		beverageImageButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				beverageImageButton.setBackground(Color.WHITE);
				MDImageButton.setBackground(Color.cyan);
				bakeryImageButton.setBackground(Color.cyan);
				beanistImageButton.setBackground(Color.cyan);
				coffeeBeansImageButton.setBackground(Color.cyan);
				beveragePanel.setVisible(true);
				MDPanel.setVisible(false);
			}

		});
		
		MDImageButton.setBounds(160, 0, 160, 60);
		MDImageButton.setFont(new Font("D2coding", Font.BOLD, 30));
		MDImageButton.setBackground(Color.CYAN);
		MDImageButton.setBorderPainted(false);
		menuBGPanel.add(MDImageButton);
		MDImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuBGPanel.add(MDPanel);
				MDImageButton.setBackground(Color.WHITE);
				beverageImageButton.setBackground(Color.cyan);
				bakeryImageButton.setBackground(Color.cyan);
				beanistImageButton.setBackground(Color.cyan);
				coffeeBeansImageButton.setBackground(Color.cyan);
				MDPanel.setVisible(true);
				beveragePanel.setVisible(false);
				bakeryPanel.setVisible(false);
				beanistPanel.setVisible(false);
				beanPanel.setVisible(false);
			}
		});
		
		bakeryImageButton.setBounds(320, 0, 160, 60);
		bakeryImageButton.setFont(new Font("D2coding", Font.BOLD, 30));
		bakeryImageButton.setBackground(Color.CYAN);
		bakeryImageButton.setBorderPainted(false);
		menuBGPanel.add(bakeryImageButton);
		bakeryImageButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menuBGPanel.add(bakeryPanel);
				bakeryImageButton.setBackground(Color.WHITE);
				MDImageButton.setBackground(Color.cyan);
				beverageImageButton.setBackground(Color.cyan);
				beanistImageButton.setBackground(Color.cyan);
				coffeeBeansImageButton.setBackground(Color.cyan);
				bakeryPanel.setVisible(true);
				beveragePanel.setVisible(false);
				MDPanel.setVisible(false);
				beanistPanel.setVisible(false);
				beanPanel.setVisible(false);
			}
			
		});
		
		beanistImageButton.setBounds(480, 0, 160, 60);
		beanistImageButton.setFont(new Font("D2coding", Font.BOLD, 30));
		beanistImageButton.setBackground(Color.CYAN);
		beanistImageButton.setBorderPainted(false);
		menuBGPanel.add(beanistImageButton);
		beanistImageButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menuBGPanel.add(beanistPanel);
				beanistImageButton.setBackground(Color.WHITE);
				bakeryImageButton.setBackground(Color.cyan);
				MDImageButton.setBackground(Color.cyan);
				beverageImageButton.setBackground(Color.cyan);
				coffeeBeansImageButton.setBackground(Color.cyan);
				beanistPanel.setVisible(true);
				beveragePanel.setVisible(false);
				MDPanel.setVisible(false);
				bakeryPanel.setVisible(false);
				beanPanel.setVisible(false);
			}
			
		});
		
		coffeeBeansImageButton.setBounds(632, 0, 160, 60);
		coffeeBeansImageButton.setFont(new Font("D2coding", Font.BOLD, 30));
		coffeeBeansImageButton.setBackground(Color.CYAN);
		coffeeBeansImageButton.setBorderPainted(false);
		menuBGPanel.add(coffeeBeansImageButton);
		coffeeBeansImageButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menuBGPanel.add(beanPanel);
				coffeeBeansImageButton.setBackground(Color.WHITE);
				beanistImageButton.setBackground(Color.cyan);
				bakeryImageButton.setBackground(Color.cyan);
				MDImageButton.setBackground(Color.cyan);
				beverageImageButton.setBackground(Color.cyan);
				beanPanel.setVisible(true);
				beveragePanel.setVisible(false);
				MDPanel.setVisible(false);
				bakeryPanel.setVisible(false);
				beanistPanel.setVisible(false);
			}
			
		});
		
//		MD
//		나의 메뉴 위치 설정(DLTBlack)
		JLabel DLTBlackLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 블랙<br>Dark Light Tumbler Black<html>");
		DLTBlackLabel.setBounds(80, 220, 140, 100);
		DLTBlackLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		MDPanel.add(DLTBlackLabel);
		
		JButton DLTBlackImageButton = new JButton("");
		DLTBlackImageButton.setIcon(new ImageIcon(DLTBlackImageButtonLink));
		DLTBlackImageButton.setSelectedIcon(new ImageIcon(DLTBlackImageButtonLink));
		DLTBlackImageButton.setBounds(50, 40, 200, 200);
		DLTBlackImageButton.setContentAreaFilled(false);
		DLTBlackImageButton.setBorderPainted(false);
		DLTBlackImageButton.setFocusPainted(false);
		MDPanel.add(DLTBlackImageButton);
		DLTBlackImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(DLTBlackImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[8]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[8], arMenuPrice[8], DLTBlackImageButtonLink, menuCode[8], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				DLTBlackImageButton.setIcon(new ImageIcon(DLTBlackImageButtonLinkSelected));
				DLTBlackImageButton.setSelectedIcon(new ImageIcon(DLTBlackImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				DLTBlackImageButton.setIcon(new ImageIcon(DLTBlackImageButtonLink));
				DLTBlackImageButton.setSelectedIcon(new ImageIcon(DLTBlackImageButtonLink));
			}
		});
//		나의 메뉴 위치 설정(DLTPink)
		JLabel DLTPinkLabel = new JLabel("<html>&nbsp;다크 라이트 텀블러 핑크<br>Dark Light Tumbler Pink<html>");
		DLTPinkLabel.setBounds(300, 220, 160, 100);
		DLTPinkLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		MDPanel.add(DLTPinkLabel);
		
		JButton DLTPinkImageButton = new JButton("");
		DLTPinkImageButton.setIcon(new ImageIcon(DLTPinkImageButtonLink));
		DLTPinkImageButton.setSelectedIcon(new ImageIcon(DLTPinkImageButtonLink));
		DLTPinkImageButton.setBounds(280, 40, 200, 200);
		DLTPinkImageButton.setContentAreaFilled(false);
		DLTPinkImageButton.setBorderPainted(false);
		DLTPinkImageButton.setFocusPainted(false);
		MDPanel.add(DLTPinkImageButton);
		DLTPinkImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(DLTPinkImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[9]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[9], arMenuPrice[9], DLTPinkImageButtonLink, menuCode[9], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				DLTPinkImageButton.setIcon(new ImageIcon(DLTPinkImageButtonLinkSelected));
				DLTPinkImageButton.setSelectedIcon(new ImageIcon(DLTPinkImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				DLTPinkImageButton.setIcon(new ImageIcon(DLTPinkImageButtonLink));
				DLTPinkImageButton.setSelectedIcon(new ImageIcon(DLTPinkImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(DLTWhite)
		JLabel DLTWhiteLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;다크 라이트 텀블러 화이트<br>Dark Light Tumbler White<html>");
		DLTWhiteLabel.setBounds(520, 220, 200, 100);
		DLTWhiteLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		MDPanel.add(DLTWhiteLabel);
		
		JButton DLTWhiteImageButton = new JButton("");
		DLTWhiteImageButton.setIcon(new ImageIcon(DLTWhiteImageButtonLink));
		DLTWhiteImageButton.setSelectedIcon(new ImageIcon(DLTWhiteImageButtonLink));
		DLTWhiteImageButton.setBounds(510, 40, 200, 200);
		DLTWhiteImageButton.setContentAreaFilled(false);
		DLTWhiteImageButton.setBorderPainted(false);
		DLTWhiteImageButton.setFocusPainted(false);
		MDPanel.add(DLTWhiteImageButton);
		DLTWhiteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(DLTWhiteImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[10]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[10], arMenuPrice[10], DLTWhiteImageButtonLink, menuCode[10], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				DLTWhiteImageButton.setIcon(new ImageIcon(DLTWhiteImageButtonLinkSelected));
				DLTWhiteImageButton.setSelectedIcon(new ImageIcon(DLTWhiteImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				DLTWhiteImageButton.setIcon(new ImageIcon(DLTWhiteImageButtonLink));
				DLTWhiteImageButton.setSelectedIcon(new ImageIcon(DLTWhiteImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(ediyaMug)
		JLabel ediyaMugLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;이디야 머그<br>EDIYA Mug<html>");
		ediyaMugLabel.setBounds(80, 480, 200, 100);
		ediyaMugLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		MDPanel.add(ediyaMugLabel);
		
		JButton ediyaMugImageButton = new JButton("");
		ediyaMugImageButton.setIcon(new ImageIcon(ediyaMugImageButtonLink));
		ediyaMugImageButton.setSelectedIcon(new ImageIcon(ediyaMugImageButtonLink));
		ediyaMugImageButton.setBounds(50, 320, 200, 200);
		ediyaMugImageButton.setContentAreaFilled(false);
		ediyaMugImageButton.setBorderPainted(false);
		ediyaMugImageButton.setFocusPainted(false);
		MDPanel.add(ediyaMugImageButton);
		ediyaMugImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(ediyaMugImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[11]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[11], arMenuPrice[11], ediyaMugImageButtonLink, menuCode[11], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ediyaMugImageButton.setIcon(new ImageIcon(ediyaMugImageButtonLinkSelected));
				ediyaMugImageButton.setSelectedIcon(new ImageIcon(ediyaMugImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ediyaMugImageButton.setIcon(new ImageIcon(ediyaMugImageButtonLink));
				ediyaMugImageButton.setSelectedIcon(new ImageIcon(ediyaMugImageButtonLink));
			}
		});
		
//		bakery
//		나의 메뉴 위치 설정(buttonMushroomSoup)
		JLabel buttonMushroomSoupLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;양송이 버섯 스프<br>buttonMushroomSoup<html>");
		buttonMushroomSoupLabel.setBounds(300, 660, 200, 100);
		buttonMushroomSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(buttonMushroomSoupLabel);
		
		JButton buttonMushroomSoupImageButton = new JButton("");
		buttonMushroomSoupImageButton.setIcon(new ImageIcon(buttonMushroomSoupImageButtonLink));
		buttonMushroomSoupImageButton.setSelectedIcon(new ImageIcon(buttonMushroomSoupImageButtonLink));
		buttonMushroomSoupImageButton.setBounds(280, 520, 200, 200);
		buttonMushroomSoupImageButton.setContentAreaFilled(false);
		buttonMushroomSoupImageButton.setBorderPainted(false);
		buttonMushroomSoupImageButton.setFocusPainted(false);
		bakeryPanel.add(buttonMushroomSoupImageButton);
		buttonMushroomSoupImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(buttonMushroomSoupImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[12]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[12], arMenuPrice[12], buttonMushroomSoupImageButtonLink, menuCode[12], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonMushroomSoupImageButton.setIcon(new ImageIcon(buttonMushroomSoupImageButtonLinkSelected));
				buttonMushroomSoupImageButton.setSelectedIcon(new ImageIcon(buttonMushroomSoupImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonMushroomSoupImageButton.setIcon(new ImageIcon(buttonMushroomSoupImageButtonLink));
				buttonMushroomSoupImageButton.setSelectedIcon(new ImageIcon(buttonMushroomSoupImageButtonLink));
			}
		});
		
//		초코 마카롱
		JLabel chocoMacaronLabel = new JLabel("<html>&nbsp;초코 마카롱<br>Choco Macaron</html>");
		chocoMacaronLabel.setBounds(80, 220, 140, 100);
		chocoMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(chocoMacaronLabel);
		
		JButton chocoMacaronImageButton = new JButton("");
		chocoMacaronImageButton.setIcon(new ImageIcon(chocoMacaronImageButtonLink));
		chocoMacaronImageButton.setSelectedIcon(new ImageIcon(chocoMacaronImageButtonLink));
		chocoMacaronImageButton.setBounds(50, 40, 200, 200);
		chocoMacaronImageButton.setContentAreaFilled(false);
		chocoMacaronImageButton.setBorderPainted(false);
		chocoMacaronImageButton.setFocusPainted(false);
		bakeryPanel.add(chocoMacaronImageButton);
		chocoMacaronImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(chocoMacaronImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[13]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[13], arMenuPrice[13], chocoMacaronImageButtonLink, menuCode[13], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				chocoMacaronImageButton.setIcon(new ImageIcon(chocoMacaronImageButtonLinkSelected));
				chocoMacaronImageButton.setSelectedIcon(new ImageIcon(chocoMacaronImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				chocoMacaronImageButton.setIcon(new ImageIcon(chocoMacaronImageButtonLink));
				chocoMacaronImageButton.setSelectedIcon(new ImageIcon(chocoMacaronImageButtonLink));
			}
		});
//		나의 메뉴 위치 설정(strawberryMacaron)
		JLabel strawberryMacaronLabel = new JLabel("<html>&nbsp;딸기 마카롱<br>Dark Light Tumbler Pink</html>");
		strawberryMacaronLabel.setBounds(300, 220, 160, 100);
		strawberryMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(strawberryMacaronLabel);
		
		JButton strawberryMacaronImageButton = new JButton("");
		strawberryMacaronImageButton.setIcon(new ImageIcon(strawberryMacaronImageButtonLink));
		strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(strawberryMacaronImageButtonLink));
		strawberryMacaronImageButton.setBounds(280, 40, 200, 200);
		strawberryMacaronImageButton.setContentAreaFilled(false);
		strawberryMacaronImageButton.setBorderPainted(false);
		strawberryMacaronImageButton.setFocusPainted(false);
		bakeryPanel.add(strawberryMacaronImageButton);
		strawberryMacaronImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(strawberryMacaronImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[14]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[14], arMenuPrice[14], strawberryMacaronImageButtonLink, menuCode[14], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				strawberryMacaronImageButton.setIcon(new ImageIcon(strawberryMacaronImageButtonLinkSelected));
				strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(strawberryMacaronImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				strawberryMacaronImageButton.setIcon(new ImageIcon(strawberryMacaronImageButtonLink));
				strawberryMacaronImageButton.setSelectedIcon(new ImageIcon(strawberryMacaronImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(vanillaMacaron)
		JLabel vanillaMacaronLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;바닐라 마카롱<br>vanillaMacaron<html>");
		vanillaMacaronLabel.setBounds(520, 220, 200, 100);
		vanillaMacaronLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(vanillaMacaronLabel);
		
		JButton vanillaMacaronImageButton = new JButton("");
		vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
		vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image/bakery/vanillaMacaron.png"));
		vanillaMacaronImageButton.setBounds(510, 40, 200, 200);
		vanillaMacaronImageButton.setContentAreaFilled(false);
		vanillaMacaronImageButton.setBorderPainted(false);
		vanillaMacaronImageButton.setFocusPainted(false);
		bakeryPanel.add(vanillaMacaronImageButton);
		vanillaMacaronImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(vanillaMacaronImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[15]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[15], arMenuPrice[15], vanillaMacaronImageButtonLink, menuCode[15], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron(selected).png"));
				vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron(selected).png"));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				vanillaMacaronImageButton.setIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
				vanillaMacaronImageButton.setSelectedIcon(new ImageIcon(".\\src\\image\\bakery/vanillaMacaron.png"));
			}
		});
		
//		나의 메뉴 위치 설정(eggBaconGSandwich)
		JLabel eggBaconGSandwichLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;에그 베이컨 샌드위치<br>eggBaconGSandwich<html>");
		eggBaconGSandwichLabel.setBounds(80, 480, 200, 100);
		eggBaconGSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(eggBaconGSandwichLabel);
		
		JButton eggBaconGSandwichImageButton = new JButton("");
		eggBaconGSandwichImageButton.setIcon(new ImageIcon(eggBaconGSandwichImageButtonLink));
		eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(eggBaconGSandwichImageButtonLink));
		eggBaconGSandwichImageButton.setBounds(50, 320, 200, 200);
		eggBaconGSandwichImageButton.setContentAreaFilled(false);
		eggBaconGSandwichImageButton.setBorderPainted(false);
		eggBaconGSandwichImageButton.setFocusPainted(false);
		bakeryPanel.add(eggBaconGSandwichImageButton);
		eggBaconGSandwichImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(eggBaconGSandwichImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[16]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[16], arMenuPrice[16], eggBaconGSandwichImageButtonLink, menuCode[16], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				eggBaconGSandwichImageButton.setIcon(new ImageIcon(eggBaconGSandwichImageButtonLinkSelected));
				eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(eggBaconGSandwichImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				eggBaconGSandwichImageButton.setIcon(new ImageIcon(eggBaconGSandwichImageButtonLink));
				eggBaconGSandwichImageButton.setSelectedIcon(new ImageIcon(eggBaconGSandwichImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(PeperoniCheeseSandwich)
		JLabel PeperoniCheeseSandwichLabel = new JLabel("<html>페퍼로니 치즈 샌드위치<br>PeperoniCheeseSandwich<html>");
		PeperoniCheeseSandwichLabel.setBounds(345, 490, 160, 100);
		PeperoniCheeseSandwichLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(PeperoniCheeseSandwichLabel);
		
		JButton PeperoniCheeseSandwichImageButton = new JButton("");
		PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLink));
		PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLink));
		PeperoniCheeseSandwichImageButton.setBounds(280, 320, 200, 200);
		PeperoniCheeseSandwichImageButton.setContentAreaFilled(false);
		PeperoniCheeseSandwichImageButton.setBorderPainted(false);
		PeperoniCheeseSandwichImageButton.setFocusPainted(false);
		bakeryPanel.add(PeperoniCheeseSandwichImageButton);
		PeperoniCheeseSandwichImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(PeperoniCheeseSandwichImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[17]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[17], arMenuPrice[17], PeperoniCheeseSandwichImageButtonLink, menuCode[17], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLinkSelected));
				PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				PeperoniCheeseSandwichImageButton.setIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLink));
				PeperoniCheeseSandwichImageButton.setSelectedIcon(new ImageIcon(PeperoniCheeseSandwichImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(PotatoBaconSoup)
		JLabel PotatoBaconSoupLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;포테이토 베이컨 스프<br>PotatoBaconSoup<html>");
		PotatoBaconSoupLabel.setBounds(540, 480, 200, 100);
		PotatoBaconSoupLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(PotatoBaconSoupLabel);
		
		JButton PotatoBaconSoupImageButton = new JButton("");
		PotatoBaconSoupImageButton.setIcon(new ImageIcon(PotatoBaconSoupImageButtonLink));
		PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(PotatoBaconSoupImageButtonLink));
		PotatoBaconSoupImageButton.setBounds(510, 320, 200, 200);
		PotatoBaconSoupImageButton.setContentAreaFilled(false);
		PotatoBaconSoupImageButton.setBorderPainted(false);
		PotatoBaconSoupImageButton.setFocusPainted(false);
		bakeryPanel.add(PotatoBaconSoupImageButton);
		PotatoBaconSoupImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(PotatoBaconSoupImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[18]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[18], arMenuPrice[18], PotatoBaconSoupImageButtonLink, menuCode[18], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				PotatoBaconSoupImageButton.setIcon(new ImageIcon(PotatoBaconSoupImageButtonLinkSelected));
				PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(PotatoBaconSoupImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				PotatoBaconSoupImageButton.setIcon(new ImageIcon(PotatoBaconSoupImageButtonLink));
				PotatoBaconSoupImageButton.setSelectedIcon(new ImageIcon(PotatoBaconSoupImageButtonLink));
			}
		});

//		나의 메뉴 위치 설정(galicCheeseBread)
		JLabel galicCheeseBreadLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;갈릭 치즈 브래드<br>galicCheeseBread<html>");
		galicCheeseBreadLabel.setBounds(80, 660, 200, 100);
		galicCheeseBreadLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bakeryPanel.add(galicCheeseBreadLabel);
		
		JButton galicCheeseBreadImageButton = new JButton("");
		galicCheeseBreadImageButton.setIcon(new ImageIcon(galicCheeseBreadImageButtonLink));
		galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(galicCheeseBreadImageButtonLink));
		galicCheeseBreadImageButton.setBounds(50, 520, 200, 200);
		galicCheeseBreadImageButton.setContentAreaFilled(false);
		galicCheeseBreadImageButton.setBorderPainted(false);
		galicCheeseBreadImageButton.setFocusPainted(false);
		bakeryPanel.add(galicCheeseBreadImageButton);
		galicCheeseBreadImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(galicCheeseBreadImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[19]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[19], arMenuPrice[19], galicCheeseBreadImageButtonLink, menuCode[19], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				galicCheeseBreadImageButton.setIcon(new ImageIcon(galicCheeseBreadImageButtonLinkSelected));
				galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(galicCheeseBreadImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				galicCheeseBreadImageButton.setIcon(new ImageIcon(galicCheeseBreadImageButtonLink));
				galicCheeseBreadImageButton.setSelectedIcon(new ImageIcon(galicCheeseBreadImageButtonLink));
			}
		});

		
//		Beanist
//		mildAmericano
		JLabel mildAmericanoLabel = new JLabel("<html>&nbsp;마일드 아메리카노<br>mildAmericano<html>");
		mildAmericanoLabel.setBounds(80, 220, 140, 100);
		mildAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanistPanel.add(mildAmericanoLabel);
		
		JButton mildAmericanoImageButton = new JButton("");
		mildAmericanoImageButton.setIcon(new ImageIcon(mildAmericanoImageButtonLink));
		mildAmericanoImageButton.setSelectedIcon(new ImageIcon(mildAmericanoImageButtonLink));
		mildAmericanoImageButton.setBounds(50, 40, 200, 200);
		mildAmericanoImageButton.setContentAreaFilled(false);
		mildAmericanoImageButton.setBorderPainted(false);
		mildAmericanoImageButton.setFocusPainted(false);
		beanistPanel.add(mildAmericanoImageButton);
		mildAmericanoImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(mildAmericanoImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[20]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[20], arMenuPrice[20], mildAmericanoImageButtonLink, menuCode[20], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mildAmericanoImageButton.setIcon(new ImageIcon(mildAmericanoImageButtonLinkSelected));
				mildAmericanoImageButton.setSelectedIcon(new ImageIcon(mildAmericanoImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mildAmericanoImageButton.setIcon(new ImageIcon(mildAmericanoImageButtonLink));
				mildAmericanoImageButton.setSelectedIcon(new ImageIcon(mildAmericanoImageButtonLink));
			}
		});
//		나의 메뉴 위치 설정(originalAmericano)
		JLabel originalAmericanoLabel = new JLabel("<html>&nbsp;오리지널 아메리카노<br>originalAmericano<html>");
		originalAmericanoLabel.setBounds(300, 220, 160, 100);
		originalAmericanoLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanistPanel.add(originalAmericanoLabel);
		
		JButton originalAmericanoImageButton = new JButton("");
		originalAmericanoImageButton.setIcon(new ImageIcon(originalAmericanoImageButtonLink));
		originalAmericanoImageButton.setSelectedIcon(new ImageIcon(originalAmericanoImageButtonLink));
		originalAmericanoImageButton.setBounds(280, 40, 200, 200);
		originalAmericanoImageButton.setContentAreaFilled(false);
		originalAmericanoImageButton.setBorderPainted(false);
		originalAmericanoImageButton.setFocusPainted(false);
		beanistPanel.add(originalAmericanoImageButton);
		originalAmericanoImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(originalAmericanoImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[21]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[21], arMenuPrice[21], originalAmericanoImageButtonLink, menuCode[21], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				originalAmericanoImageButton.setIcon(new ImageIcon(originalAmericanoImageButtonLinkSelected));
				originalAmericanoImageButton.setSelectedIcon(new ImageIcon(originalAmericanoImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				originalAmericanoImageButton.setIcon(new ImageIcon(originalAmericanoImageButtonLink));
				originalAmericanoImageButton.setSelectedIcon(new ImageIcon(originalAmericanoImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(specialEdition)
		JLabel specialEditionLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;스페셜 에디션<br>specialEdition<html>");
		specialEditionLabel.setBounds(520, 220, 200, 100);
		specialEditionLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanistPanel.add(specialEditionLabel);
		
		JButton specialEditionImageButton = new JButton("");
		specialEditionImageButton.setIcon(new ImageIcon(specialEditionImageButtonLink));
		specialEditionImageButton.setSelectedIcon(new ImageIcon(specialEditionImageButtonLink));
		specialEditionImageButton.setBounds(510, 40, 200, 200);
		specialEditionImageButton.setContentAreaFilled(false);
		specialEditionImageButton.setBorderPainted(false);
		specialEditionImageButton.setFocusPainted(false);
		beanistPanel.add(specialEditionImageButton);
		specialEditionImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(specialEditionImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[22]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[22], arMenuPrice[22], specialEditionImageButtonLink, menuCode[22], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				specialEditionImageButton.setIcon(new ImageIcon(specialEditionImageButtonLinkSelected));
				specialEditionImageButton.setSelectedIcon(new ImageIcon(specialEditionImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				specialEditionImageButton.setIcon(new ImageIcon(specialEditionImageButtonLink));
				specialEditionImageButton.setSelectedIcon(new ImageIcon(specialEditionImageButtonLink));
			}
		});
		
//		coffeeBeans
//		ediyablue
		JLabel ediyablueLabel = new JLabel("<html>&nbsp;이디야 블루<br>EDIYA blue<html>");
		ediyablueLabel.setBounds(80, 220, 140, 100);
		ediyablueLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanPanel.add(ediyablueLabel);
		
		JButton ediyablueImageButton = new JButton("");
		ediyablueImageButton.setIcon(new ImageIcon(ediyablueImageButtonLink));
		ediyablueImageButton.setSelectedIcon(new ImageIcon(ediyablueImageButtonLink));
		ediyablueImageButton.setBounds(50, 40, 200, 200);
		ediyablueImageButton.setContentAreaFilled(false);
		ediyablueImageButton.setBorderPainted(false);
		ediyablueImageButton.setFocusPainted(false);
		beanPanel.add(ediyablueImageButton);
		ediyablueImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(ediyablueImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[23]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[23], arMenuPrice[23], ediyablueImageButtonLink, menuCode[23], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ediyablueImageButton.setIcon(new ImageIcon(ediyablueImageButtonLinkSelected));
				ediyablueImageButton.setSelectedIcon(new ImageIcon(ediyablueImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ediyablueImageButton.setIcon(new ImageIcon(ediyablueImageButtonLink));
				ediyablueImageButton.setSelectedIcon(new ImageIcon(ediyablueImageButtonLink));
			}
		});
//		나의 메뉴 위치 설정(ediyaRoast)
		JLabel ediyaRoastLabel = new JLabel("<html>&nbsp;이디야 로스트<br>EDIYA Roast<html>");
		ediyaRoastLabel.setBounds(300, 220, 160, 100);
		ediyaRoastLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanPanel.add(ediyaRoastLabel);
		
		JButton ediyaRoastImageButton = new JButton("");
		ediyaRoastImageButton.setIcon(new ImageIcon(ediyaRoastImageButtonLink));
		ediyaRoastImageButton.setSelectedIcon(new ImageIcon(ediyaRoastImageButtonLink));
		ediyaRoastImageButton.setBounds(280, 40, 200, 200);
		ediyaRoastImageButton.setContentAreaFilled(false);
		ediyaRoastImageButton.setBorderPainted(false);
		ediyaRoastImageButton.setFocusPainted(false);
		beanPanel.add(ediyaRoastImageButton);
		ediyaRoastImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(ediyaRoastImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[24]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[24], arMenuPrice[24], ediyaRoastImageButtonLink, menuCode[24], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ediyaRoastImageButton.setIcon(new ImageIcon(ediyaRoastImageButtonLinkSelected));
				ediyaRoastImageButton.setSelectedIcon(new ImageIcon(ediyaRoastImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ediyaRoastImageButton.setIcon(new ImageIcon(ediyaRoastImageButtonLink));
				ediyaRoastImageButton.setSelectedIcon(new ImageIcon(ediyaRoastImageButtonLink));
			}
		});
		
//		나의 메뉴 위치 설정(ediyaViolet)
		JLabel ediyaVioletLabel = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;이디야 바이올렛<br>EDIYA Violet<html>");
		ediyaVioletLabel.setBounds(520, 220, 200, 100);
		ediyaVioletLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		beanPanel.add(ediyaVioletLabel);
		
		JButton ediyaVioletImageButton = new JButton("");
		ediyaVioletImageButton.setIcon(new ImageIcon(ediyaVioletImageButtonLink));
		ediyaVioletImageButton.setSelectedIcon(new ImageIcon(ediyaVioletImageButtonLink));
		ediyaVioletImageButton.setBounds(510, 40, 200, 200);
		ediyaVioletImageButton.setContentAreaFilled(false);
		ediyaVioletImageButton.setBorderPainted(false);
		ediyaVioletImageButton.setFocusPainted(false);
		beanPanel.add(ediyaVioletImageButton);
		ediyaVioletImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(ediyaVioletImageButton, String.format("%s을(를) 결제하시겠습니까?", menuName[25]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPageExceptBeverage(menuName[25], arMenuPrice[25], ediyaVioletImageButtonLink, menuCode[25], 0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ediyaVioletImageButton.setIcon(new ImageIcon(ediyaVioletImageButtonLinkSelected));
				ediyaVioletImageButton.setSelectedIcon(new ImageIcon(ediyaVioletImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ediyaVioletImageButton.setIcon(new ImageIcon(ediyaVioletImageButtonLink));
				ediyaVioletImageButton.setSelectedIcon(new ImageIcon(ediyaVioletImageButtonLink));
			}
		});
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		OrderPage2 window = new OrderPage2();
		
	}
	
}