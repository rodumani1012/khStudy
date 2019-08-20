package RoundButton;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class MainGUI_beforeLogin extends JFrame{

	private JPanel contentPane;
	JPanel panel_banner,panel_content;
	JButton btn_Insert,btn_Withdraw,btn_Transfer,btn_LookUp,btn_NoPass,btn_SignUp;
	private JButton btn_login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
    IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI_beforeLogin frame = new MainGUI_beforeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}

	public MainGUI_beforeLogin() {
		setTitle(":: Q1 Bank :: 한 큐에 해결되는 뱅킹시스템 ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		contentPane.setLayout(null);
		
		ImageIcon img_banner = new ImageIcon("images/banner_main.png");
		Image preImg01 = img_banner.getImage();
		JLabel label_banner = new JLabel(new ImageIcon(preImg01.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH)));
		panel_banner = new JPanel();
		panel_banner.add(label_banner);
		panel_banner.setBounds(0, -5, 800, 100);
		contentPane.add(panel_banner);

		
		ImageIcon img_slogan = new ImageIcon("images/main_slogan.png");
		Image preImg02 = img_slogan.getImage(); 
		JLabel label_slogan = new JLabel(new ImageIcon(preImg02.getScaledInstance(300, 90, java.awt.Image.SCALE_SMOOTH)));
		label_slogan.setBounds(220, 5, -1, -1);
		panel_content = new JPanel();
		panel_content.add(label_slogan);
		panel_content.setBounds(200, 110, 420, 120);
		contentPane.add(panel_content);
		
		JPanel panel_btn = new JPanel();
		panel_btn.setBounds(137, 234, 530, 325);
		contentPane.add(panel_btn);
		panel_btn.setLayout(null);
		
		//입금 버튼
		btn_Insert = new JButton(new ImageIcon(((new ImageIcon("images/button_Insert.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_Insert.setContentAreaFilled(false);
		btn_Insert.setBounds(0, 0, 150, 150);
		btn_Insert.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	loginFirst();
	         }
	      });
		btn_Insert.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	         }
	      });
		panel_btn.add(btn_Insert);
		

		//출금 버튼
		btn_Withdraw = new JButton(new ImageIcon(((new ImageIcon("images/button_Withdraw.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_Withdraw.setContentAreaFilled(false);
		btn_Withdraw.setBounds(190, 0, 150, 150);
		btn_Withdraw.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	loginFirst();
	         }
	      });
		btn_Withdraw.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	         }
	      });
		panel_btn.add(btn_Withdraw);
		
		
		//이체 버튼
		btn_Transfer = new JButton(new ImageIcon(((new ImageIcon("images/button_Transfer.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_Transfer.setContentAreaFilled(false);
		btn_Transfer.setBounds(380, 0, 150, 150);
		btn_Transfer.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	loginFirst();
	         }
	      });
		btn_Transfer.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	         }
	      });
		panel_btn.add(btn_Transfer);
		
		//거래 조회 버튼
		btn_LookUp = new JButton(new ImageIcon(((new ImageIcon("images/button_LookUp.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_LookUp.setContentAreaFilled(false);
		btn_LookUp.setBounds(0, 170, 150, 150);
		btn_LookUp.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	        	loginFirst();
	         }
	      });
		btn_LookUp.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	         }
	      });
		panel_btn.add(btn_LookUp);
		
		//무통장입금 버튼
		btn_NoPass = new JButton(new ImageIcon(((new ImageIcon("images/button_NoPass.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_NoPass.setContentAreaFilled(false);
		btn_NoPass.setBounds(190, 170, 150, 150);
		btn_NoPass.addMouseListener(new MouseAdapter() {
			Nopassbook nopassbook = new Nopassbook();
	         @Override
	         public void mouseClicked(MouseEvent arg0) {
	            nopassbook.setVisible(true);
	            dispose();
	         }
	      });
		panel_btn.add(btn_NoPass);
		
		//회원 가입 버튼
		btn_SignUp = new JButton(new ImageIcon(((new ImageIcon("images/button_SignUp.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_SignUp.setContentAreaFilled(false);
		btn_SignUp.setBounds(380, 170, 150, 150);
		btn_SignUp.addMouseListener(new MouseAdapter() {
			Register register = new Register();
			@Override
			public void mouseClicked(MouseEvent arg0) {
				register.setVisible(true);
				dispose();
			}
		});
		panel_btn.add(btn_SignUp);
		
		//로그인 버튼
		btn_login = new JButton("로 그 인");
		btn_login.setBounds(690, 100, 90, 45);
		contentPane.add(btn_login);
		btn_login.setBackground(SystemColor.control);
		btn_login.setOpaque(false);
	    btn_login.addMouseListener(new MouseAdapter() {
	    	Login login = new Login();
	          @Override
	          public void mouseClicked(MouseEvent e) {
	             login.setVisible(true);
	             setVisible(false);
	          }
	   });
	}

	public void loginFirst() {
		JOptionPane.showMessageDialog(null, "로그인이 필요한 기능입니다.");
        Login login = new Login();
        login.setVisible(true);
        setVisible(false);
	}
}