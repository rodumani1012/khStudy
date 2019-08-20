package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DealDeposit extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	BankBiz biz = new BankBiz();
	BankDto logdto; 
	JButton btn01;
	JLabel warning;

	public DealDeposit() {}
	public DealDeposit(BankDto logindto) {
		logdto=logindto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon("images/banner_in_money.png");
		Image preImg = img.getImage();
		Image afterImg = preImg.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon afterIcon = new ImageIcon(afterImg);
		JLabel bannerTop = new JLabel(afterIcon);
		
		JPanel panel_top = new JPanel();
		panel_top.add(bannerTop);
		panel_top.setBounds(0, -10, 800, 110);
		getContentPane().add(panel_top);
		getContentPane().add(panel_top);
		getContentPane().setLayout(null);
		
		JPanel panel_mid = new JPanel();
		panel_mid.setBounds(0, 104, 800, 457);
		getContentPane().add(panel_mid);
		panel_mid.setLayout(null);
		
		JLabel balanceLabel = new JLabel("현재 잔액  : ");
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		balanceLabel.setBounds(180, 45, 150, 40);
		panel_mid.add(balanceLabel);
		
		JLabel balanceLabel2 = new JLabel("");
		balanceLabel2.setText(logindto.getT_balance()+"");
		balanceLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		balanceLabel2.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		balanceLabel2.setBounds(310, 45, 243, 40);
		panel_mid.add(balanceLabel2);
		
		JLabel label = new JLabel("원");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.PLAIN, 22));
		label.setBounds(553, 45, 56, 40);
		panel_mid.add(label);
		getContentPane().add(panel_mid);
		
		JLabel lblNewLabel_1 = new JLabel("입금할 금액");
		lblNewLabel_1.setBounds(156, 157, 138, 30);
		panel_mid.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(327, 146, 307, 50);
		panel_mid.add(textField);
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyTyped(KeyEvent ke) {
	        	if(!((ke.getKeyChar()>='0' && ke.getKeyChar()<='9') || (ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) || (ke.getKeyChar()==KeyEvent.VK_ENTER))){
	        		warning.setVisible(true);
	        		ke.consume();
	        	}else if(ke.getKeyChar()>='0' && ke.getKeyChar()<='9') {
	        		warning.setVisible(false);
	        	}
	        	if(ke.getKeyChar()==KeyEvent.VK_ENTER) {
	        		btn01.requestFocus();
	        	}
	         }
	    });
		
		warning = new JLabel("숫자를 입력하세요");
		warning.setBounds(540, 190, 100, 30);
		panel_mid.add(warning);
		warning.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		warning.setForeground(Color.red);
		warning.setVisible(false);
		
		btn01 = new JButton("입 금");
		btn01.setBackground(SystemColor.control);
		btn01.setBounds(156, 291, 200, 70);
		panel_mid.add(btn01);
		btn01.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		
		JButton backBtn = new JButton("되돌아가기");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            if(JOptionPane.showConfirmDialog(contentPane, "이 페이지를 나가시겠습니까?", "되돌아 가기", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==0) {
	            	MainGUI_afterLogin myView = new MainGUI_afterLogin(logdto);
	            	myView.setVisible(true);
	                dispose();
	             }
			}
		});
		backBtn.setFont(new Font("Dialog", Font.PLAIN, 18));
		backBtn.setBackground(SystemColor.menu);
		backBtn.setBounds(434, 291, 200, 70);
		panel_mid.add(backBtn);
		btn01.addActionListener(this);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn01) {
			int res = biz.Deposit(logdto.getAccount(),Integer.parseInt(textField.getText()));
			System.out.println(res);
			if(res==2) {
				 InReceipt newReceipt = new InReceipt(biz.myaccount(logdto.getAccount()), Integer.parseInt(textField.getText()), "ATM입금");
				 newReceipt.setVisible(true);
				 dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealDeposit frame = new DealDeposit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
