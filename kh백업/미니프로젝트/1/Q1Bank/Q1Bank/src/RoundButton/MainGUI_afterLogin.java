package RoundButton;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.dto.BankDto;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainGUI_afterLogin extends JFrame {

	private JPanel contentPane;
	JPanel panel_banner,panel_content;
	JButton btn_Insert,btn_Withdraw,btn_Transfer,btn_LookUp,btn_MyPage,btn_LogOut;
	private JLabel welcomeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					MainGUI_afterLogin frame = new MainGUI_afterLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			} 
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI_afterLogin() {}
	public MainGUI_afterLogin(BankDto logindto) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //본인(자기)만 꺼지게 하는 것
			}
		});
		
		setTitle(":: Q1 Bank :: 한 큐에 해결되는 뱅킹시스템 ");
		setResizable(false);
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
		label_banner.setBounds(342, 20, -1, -1);
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
		btn_Insert.setBorderPainted(false);
		btn_Insert.setFocusPainted(false);
		btn_Insert.setContentAreaFilled(false);
		btn_Insert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DealDeposit dealdeposit = new DealDeposit(logindto);
	            dealdeposit.setVisible(true);
	            setVisible(false);
			}
		});
		btn_Insert.setBounds(0, 0, 150, 150);
		panel_btn.add(btn_Insert);
		
		//출금 버튼
		btn_Withdraw = new JButton(new ImageIcon(((new ImageIcon("images/button_Withdraw.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_Withdraw.setBorderPainted(false);
		btn_Withdraw.setFocusPainted(false);
		btn_Withdraw.setContentAreaFilled(false);
		btn_Withdraw.setBounds(190, 0, 150, 150);
		btn_Withdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealWithdraw dealwithdraw = new DealWithdraw(logindto);
				dealwithdraw.setVisible(true);
				setVisible(false);
			}
		});
		panel_btn.add(btn_Withdraw);
		
		//이체 버튼
		btn_Transfer = new JButton(new ImageIcon(((new ImageIcon("images/button_Transfer.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_Transfer.setBorderPainted(false);
		btn_Transfer.setFocusPainted(false);
		btn_Transfer.setContentAreaFilled(false);
		btn_Transfer.addMouseListener(new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            TransferGUI transfergui = new TransferGUI(logindto);
	            transfergui.setVisible(true);
	            setVisible(false);
	         }
	      });
		btn_Transfer.setBounds(380, 0, 150, 150);
		panel_btn.add(btn_Transfer);
		
		//조회 버튼
		btn_LookUp = new JButton(new ImageIcon(((new ImageIcon("images/button_LookUp.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_LookUp.setBorderPainted(false);
		btn_LookUp.setFocusPainted(false);
		btn_LookUp.setContentAreaFilled(false);
		btn_LookUp.setBounds(0, 170, 150, 150);
		btn_LookUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LookAccount	lookAccount = new LookAccount(logindto);
				lookAccount.setVisible(true);
				setVisible(false);
			}
		});
		panel_btn.add(btn_LookUp);
		
		//회원정보 조회 버튼
		btn_MyPage = new JButton(new ImageIcon(((new ImageIcon("images/button_MyPage.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_MyPage.setBorderPainted(false);
		btn_MyPage.setFocusPainted(false);
		btn_MyPage.setContentAreaFilled(false);
		btn_MyPage.setBounds(190, 170, 150, 150);
		btn_MyPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MyInformation myInformation = new MyInformation(logindto);
				myInformation.setVisible(true);
				dispose();
			}
		});
		panel_btn.add(btn_MyPage);
		
		//로그아웃 버튼
		btn_LogOut = new JButton(new ImageIcon(((new ImageIcon("images/button_LogOut.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
		btn_LogOut.setBorderPainted(false);
		btn_LogOut.setFocusPainted(false);
		btn_LogOut.setContentAreaFilled(false);
		btn_LogOut.setBounds(380, 170, 150, 150);
		btn_LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainGUI_beforeLogin main = new MainGUI_beforeLogin();
				main.setVisible(true);
				dispose();
			}
		});
		panel_btn.add(btn_LogOut);
		
		welcomeLabel = new JLabel();
		welcomeLabel.setVerticalAlignment(SwingConstants.TOP);
		welcomeLabel.setText(logindto.getName() + " 님\n 환영합니다.");
		welcomeLabel.setBounds(580, 110, 200, 100);
		contentPane.add(welcomeLabel);
		welcomeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	}
}
