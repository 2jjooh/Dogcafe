package team.order;

import java.awt.Color;
import java.awt.Font;
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

import team.login.Icon;

public class OrderPage extends JPanel{
	
	JPanel orderPagePanel = new JPanel();
	public static String[] menuName = {"봄 딸기 라떼", "봄 딸기 밀크티", "    카페라떼", "  흑당 콜드브루", "    흑당 라떼", "    옥수수 라떼"};
	int[] arMenuPrice = {3500, 4500, 3500, 5500, 6000, 5000};
	String[] menuCode = {"100", "200", "500", "600", "700", "800"};
	int productNumber;
	String backButtonLink = ".\\src\\image/backButton.png", backButtonLinkSelected = ".\\src\\image/backButton(selected).png";
	String bomstrawberryLatteImageButtonLink = ".\\src\\image\\beverage/bomStraberryLatte.png", bomstrawberryLatteImageButtonLinkSelected = ".\\src\\image\\beverage/bomStraberryLatte(selected).png";
	String bomstrawberryMilkTeaImageButtonLink = ".\\src\\image\\beverage/bomStrawberryMilkTea.png", bomstrawberryMilkTeaImageButtonLinkSelected = ".\\src\\image\\beverage/bomStrawberryMilkTea(selected).png";
	String cafeLatteImageButtonLink = ".\\src\\image\\beverage/cafelatte.png", cafeLatteImageButtonLinkSelected = ".\\src\\image\\beverage/cafelatte(selected).png";
	String hColdBrewImageButton1Link = ".\\src\\image\\beverage/hColdBrew.png", hColdBrewImageButton1LinkSelected = ".\\src\\image\\beverage/hColdBrew(selected).png";
	String hLatteImageButtonLink = ".\\src\\image\\beverage/hLatte.png", hLatteImageButtonLinkSelected = ".\\src\\image\\beverage/hLatte(selected).png";
	String oksusuLatteImageButtonLink = ".\\src\\image\\beverage/oksusuLatte.png", oksusuLatteImageButtonLinkSelected = ".\\src\\image\\beverage/oksusuLatte(selected).png";
	
//	String path = "./src/image/beverage/beverage%d";
//	String path1 = "./src/image/MD/MD%d";
//	String path2 = "./src/image/bakery/bakery%d";
//	String path3 = "./src/image/bakery/bakery%d";
//	String path4 = "./src/image/beanist/beanist%d";
//	String path5 = "./src/image/coffeeBeans/coffeeBeans%d";
//	for(int i = 0; i < btns.length; i++) {
//		btns[i] = new JButton(String.format(path,i));
//	}
	
	public int result;
	
	JLabel bomstrawberryLatte1Label = new JLabel("봄 딸기 라떼");	
	JButton bomstrawberryLatteImageButton = new JButton("");
	JLabel bomstrawberryMilkTea1Label = new JLabel("봄 딸기 밀크티");
	JButton bomstrawberryMilkTeaImageButton = new JButton("");
	
	DecimalFormat df = new DecimalFormat("#,##0");
	public OrderPage() {
		JFrame frame = new JFrame();
		
		frame.setTitle("OrderPage");
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
	//frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(6371339));
		panel.setBounds(0, 0, 1500, 1000);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel orderLabel = new JLabel("주문하기");
		orderLabel.setBounds(320, 20, 200, 35);
		orderLabel.setFont(new Font("D2coding",	Font.BOLD, 40));
		orderLabel.setForeground(Color.WHITE);
		panel.add(orderLabel);
		
		JLabel myOrderLabel = new JLabel("나의 메뉴"); // TODO : Random으로 나오게 하기
		myOrderLabel.setBounds(330, 140, 150, 35);
		myOrderLabel.setFont(new Font("D2coding",	Font.BOLD, 30));
		myOrderLabel.setForeground(Color.WHITE);
		panel.add(myOrderLabel);
		
		JLabel LineLabel = new JLabel("<html>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■<br>■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■</html>");
		LineLabel.setBounds(0, 90, 800, 35);
		LineLabel.setFont(new Font("D2coding", Font.BOLD, 20));
		LineLabel.setForeground(Color.WHITE);
		panel.add(LineLabel);
		
//		뒤로가기 버튼
		JButton backButton = new JButton();
		backButton.setBounds(0, 0, 50, 50);
		backButton.setIcon(new ImageIcon(backButtonLink));
		backButton.setSelectedIcon(new ImageIcon(backButtonLink));
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		panel.add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(new ImageIcon(backButtonLinkSelected));
				backButton.setSelectedIcon(new ImageIcon(backButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(new ImageIcon(backButtonLink));
				backButton.setSelectedIcon(new ImageIcon(backButtonLink));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				new Icon();
			}
			
			
		});
		
//		나의 메뉴 위치 설정(bomstrawberryLatte)
		JLabel bomstrawberryLatte1Label = new JLabel("봄 딸기 라떼");
		bomstrawberryLatte1Label.setBounds(130, 340, 140, 100);
		bomstrawberryLatte1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryLatte1Label.setForeground(Color.WHITE);
		panel.add(bomstrawberryLatte1Label);
		JLabel bomstrawberryLatte2Label = new JLabel("Bom strawberry Latte");
		bomstrawberryLatte2Label.setBounds(120, 360, 140, 100);
		bomstrawberryLatte2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryLatte2Label.setForeground(Color.WHITE);
		panel.add(bomstrawberryLatte2Label);
		JLabel bomstrawberryLattePriceLabel = new JLabel("2500");
		bomstrawberryLattePriceLabel.setBounds(170, 380, 140, 100);
		bomstrawberryLattePriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryLattePriceLabel.setForeground(Color.WHITE);
		panel.add(bomstrawberryLattePriceLabel);
		
		bomstrawberryLatteImageButton.setIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
		bomstrawberryLatteImageButton.setSelectedIcon(new ImageIcon(bomstrawberryLatteImageButtonLink));
		bomstrawberryLatteImageButton.setBounds(90, 180, 200, 200);
		bomstrawberryLatteImageButton.setContentAreaFilled(false);
		bomstrawberryLatteImageButton.setBorderPainted(false);
		bomstrawberryLatteImageButton.setFocusPainted(false);
		panel.add(bomstrawberryLatteImageButton);
		
		bomstrawberryLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				result = JOptionPane.showConfirmDialog(bomstrawberryLatteImageButton, String.format("%s(을)를 결제하시겠습니까?", menuName[0]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					if(menuName[0].equals("봄 딸기 라떼")) {
						
						new MenuOptionPage(menuName[0], arMenuPrice[0], bomstrawberryLatteImageButtonLink, "", "", "", "", 0, menuCode[0]);
					}
					
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
		
//		나의 메뉴 위치 설정(bomstrawberryMilkTea)
		bomstrawberryMilkTea1Label.setBounds(350, 340, 140, 100);
		bomstrawberryMilkTea1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryMilkTea1Label.setForeground(Color.WHITE);
		panel.add(bomstrawberryMilkTea1Label);
		JLabel bomstrawberryMilkTea2Label = new JLabel("Bom strawberry Milk Tea");
		bomstrawberryMilkTea2Label.setBounds(320, 360, 170, 100);
		bomstrawberryMilkTea2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryMilkTea2Label.setForeground(Color.WHITE);
		panel.add(bomstrawberryMilkTea2Label);
		JLabel bomstrawberryMilkTeaPriceLabel = new JLabel("3500");
		bomstrawberryMilkTeaPriceLabel.setBounds(380, 380, 140, 100);
		bomstrawberryMilkTeaPriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		bomstrawberryMilkTeaPriceLabel.setForeground(Color.WHITE);
		panel.add(bomstrawberryMilkTeaPriceLabel);
		
		bomstrawberryMilkTeaImageButton.setIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
		bomstrawberryMilkTeaImageButton.setSelectedIcon(new ImageIcon(bomstrawberryMilkTeaImageButtonLink));
		bomstrawberryMilkTeaImageButton.setBounds(300, 180, 200, 200);
		bomstrawberryMilkTeaImageButton.setContentAreaFilled(false);
		bomstrawberryMilkTeaImageButton.setBorderPainted(false);
		bomstrawberryMilkTeaImageButton.setFocusPainted(false);
		panel.add(bomstrawberryMilkTeaImageButton);
		bomstrawberryMilkTeaImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(bomstrawberryMilkTeaImageButton, String.format("%s(을)를 결제하시겠습니까?", menuName[1]), "결제", JOptionPane.YES_NO_OPTION);
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
		
//		나의 메뉴 위치 설정(cafeLatte)
		JLabel cafeLatte1Label = new JLabel("카페라떼");
		cafeLatte1Label.setBounds(570, 340, 140, 100);
		cafeLatte1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		cafeLatte1Label.setForeground(Color.WHITE);
		panel.add(cafeLatte1Label);
		JLabel cafeLatte2Label = new JLabel("cafeLatte");
		cafeLatte2Label.setBounds(565, 360, 170, 100);
		cafeLatte2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		cafeLatte2Label.setForeground(Color.WHITE);
		panel.add(cafeLatte2Label);
		JLabel cafeLattePriceLabel = new JLabel("2500");
		cafeLattePriceLabel.setBounds(580, 380, 140, 100);
		cafeLattePriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		cafeLattePriceLabel.setForeground(Color.WHITE);
		panel.add(cafeLattePriceLabel);
		
		JButton cafeLatteImageButton = new JButton("");
		cafeLatteImageButton.setIcon(new ImageIcon(cafeLatteImageButtonLink));
		cafeLatteImageButton.setSelectedIcon(new ImageIcon(cafeLatteImageButtonLink));
		cafeLatteImageButton.setBounds(500, 180, 200, 200);
		cafeLatteImageButton.setContentAreaFilled(false);
		cafeLatteImageButton.setBorderPainted(false);
		cafeLatteImageButton.setFocusPainted(false);
		panel.add(cafeLatteImageButton);
		cafeLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(cafeLatteImageButton, String.format("%s(을)를 결제하시겠습니까?", menuName[2]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[2], arMenuPrice[2], cafeLatteImageButtonLink, "", "", "", "", 0,menuCode[2]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cafeLatteImageButton.setIcon(new ImageIcon(cafeLatteImageButtonLinkSelected));
				cafeLatteImageButton.setSelectedIcon(new ImageIcon(cafeLatteImageButtonLinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				cafeLatteImageButton.setIcon(new ImageIcon(cafeLatteImageButtonLink));
				cafeLatteImageButton.setSelectedIcon(new ImageIcon(cafeLatteImageButtonLink));
			}
			
		});
		
//		
		JLabel hColdBrew1Label = new JLabel("흑당 콜드브루");
		hColdBrew1Label.setBounds(130, 640, 140, 100);
		hColdBrew1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		hColdBrew1Label.setForeground(Color.WHITE);
		panel.add(hColdBrew1Label);
		JLabel hColdBrew2Label = new JLabel("hColdBrew");
		hColdBrew2Label.setBounds(120, 660, 140, 100);
		hColdBrew2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		hColdBrew2Label.setForeground(Color.WHITE);
		panel.add(hColdBrew2Label);
		JLabel hColdBrewPriceLabel = new JLabel("2500");
		hColdBrewPriceLabel.setBounds(170, 680, 140, 100);
		hColdBrewPriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		hColdBrewPriceLabel.setForeground(Color.WHITE);
		panel.add(hColdBrewPriceLabel);
		
		JButton hColdBrewImageButton1 = new JButton("");
		hColdBrewImageButton1.setIcon(new ImageIcon(hColdBrewImageButton1Link));
		hColdBrewImageButton1.setSelectedIcon(new ImageIcon(hColdBrewImageButton1Link));
		hColdBrewImageButton1.setBounds(90, 480, 200, 200);
		hColdBrewImageButton1.setContentAreaFilled(false);
		hColdBrewImageButton1.setBorderPainted(false);
		hColdBrewImageButton1.setFocusPainted(false);
		panel.add(hColdBrewImageButton1);
		hColdBrewImageButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(hColdBrewImageButton1, String.format("%s(을)를 결제하시겠습니까?", menuName[3]), "결제", JOptionPane.YES_NO_OPTION);
				System.out.println(result);
				if (result != 1) {
					new OrderPage();
				}else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[3], arMenuPrice[3], hColdBrewImageButton1Link, "", "", "", "", 0,menuCode[3]);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				hColdBrewImageButton1.setIcon(new ImageIcon(hColdBrewImageButton1LinkSelected));
				hColdBrewImageButton1.setSelectedIcon(new ImageIcon(hColdBrewImageButton1LinkSelected));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				hColdBrewImageButton1.setIcon(new ImageIcon(hColdBrewImageButton1Link));
				hColdBrewImageButton1.setSelectedIcon(new ImageIcon(hColdBrewImageButton1Link));
			}
			
		});
		
//		나의 메뉴 위치 설정(hLatte)
		JLabel hLatte1Label = new JLabel("흑당 라떼");
		hLatte1Label.setBounds(350, 640, 140, 100);
		hLatte1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		hLatte1Label.setForeground(Color.WHITE);
		panel.add(hLatte1Label);
		JLabel hLatte2Label = new JLabel("hLatte");
		hLatte2Label.setBounds(320, 660, 170, 100);
		hLatte2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		hLatte2Label.setForeground(Color.WHITE);
		panel.add(hLatte2Label);
		JLabel hLattePriceLabel = new JLabel("3500");
		hLattePriceLabel.setBounds(380, 680, 140, 100);
		hLattePriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		hLattePriceLabel.setForeground(Color.WHITE);
		panel.add(hLattePriceLabel);
		
		JButton hLatteImageButton = new JButton("");
		hLatteImageButton.setIcon(new ImageIcon(hLatteImageButtonLink));
		hLatteImageButton.setSelectedIcon(new ImageIcon(hLatteImageButtonLink));
		hLatteImageButton.setBounds(300, 480, 200, 200);
		hLatteImageButton.setContentAreaFilled(false);
		hLatteImageButton.setBorderPainted(false);
		hLatteImageButton.setFocusPainted(false);
		panel.add(hLatteImageButton);
		hLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(hLatteImageButton, String.format("%s(을)를 결제하시겠습니까?", menuName[4]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[4], arMenuPrice[4], hLatteImageButtonLink, "", "", "", "", 0,menuCode[4]);
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
		JLabel oksusuLatte1Label = new JLabel("옥수수 라떼");
		oksusuLatte1Label.setBounds(570, 640, 140, 100);
		oksusuLatte1Label.setFont(new Font("D2coding", Font.BOLD, 13));
		oksusuLatte1Label.setForeground(Color.WHITE);
		panel.add(oksusuLatte1Label);
		JLabel oksusuLatte2Label = new JLabel("oksusu Latte");
		oksusuLatte2Label.setBounds(565, 660, 170, 100);
		oksusuLatte2Label.setFont(new Font("D2coding", Font.BOLD, 13));
		oksusuLatte2Label.setForeground(Color.WHITE);
		panel.add(oksusuLatte2Label);
		JLabel oksusuLattePriceLabel = new JLabel("2500");
		oksusuLattePriceLabel.setBounds(580, 680, 140, 100);
		oksusuLattePriceLabel.setFont(new Font("D2coding", Font.BOLD, 13));
		oksusuLattePriceLabel.setForeground(Color.WHITE);
		panel.add(oksusuLattePriceLabel);
		
		JButton oksusuLatteImageButton = new JButton("");
		oksusuLatteImageButton.setIcon(new ImageIcon(oksusuLatteImageButtonLink));
		oksusuLatteImageButton.setSelectedIcon(new ImageIcon(oksusuLatteImageButtonLink));
		oksusuLatteImageButton.setBounds(500, 480, 200, 200);
		oksusuLatteImageButton.setContentAreaFilled(false);
		oksusuLatteImageButton.setBorderPainted(false);
		oksusuLatteImageButton.setFocusPainted(false);
		panel.add(oksusuLatteImageButton);
		oksusuLatteImageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(oksusuLatteImageButton, String.format("%s(을)를 결제하시겠습니까?", menuName[5]), "결제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					System.exit(0);
				} else if(result == JOptionPane.YES_OPTION) {
//					결제 페이지로 이동
					new MenuOptionPage(menuName[5], arMenuPrice[5], oksusuLatteImageButtonLink, "", "", "", "", 0,menuCode[5]);
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
		
		JButton btnNewButton_2 = new JButton("새 메뉴 선택");
		btnNewButton_2.setBounds(320, 790, 150, 50);
		btnNewButton_2.setFont(new Font("D2coding", Font.BOLD, 19));
		panel.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new OrderPage2();
			}
			
		});
		
		frame.setVisible(true);
	}                                                                                                                                                
	
	public void OrderWindow() {
		
	}
	
	public static void main(String[] args) {
		
		OrderPage window = new OrderPage();
		
	}

}