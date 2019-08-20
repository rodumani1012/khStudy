package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import com.biz.BankBiz;
import com.dto.BankDto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DealWithdraw extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTextField textField;
	BankBiz biz = new BankBiz();
	static BankDto logdto;
	JButton btn01;
	OutReceipt newReceipt;
	JLabel warning;

	public DealWithdraw() {
	}

	public DealWithdraw(BankDto logindto) {
		logdto = logindto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon img = new ImageIcon("images/banner_out_money.png");
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

		JLabel msg01 = new JLabel("출금 가능 금액 : ");
		msg01.setBounds(201, 91, 170, 24);
		panel_mid.add(msg01);
		msg01.setBackground(SystemColor.window);
		msg01.setHorizontalAlignment(SwingConstants.CENTER);
		msg01.setFont(new Font("나눔고딕", Font.PLAIN, 15));

		JLabel money_label = new JLabel("New label");
		money_label.setHorizontalAlignment(SwingConstants.RIGHT);
		money_label.setBounds(353, 92, 159, 24);
		panel_mid.add(money_label);
		money_label.setBackground(SystemColor.window);
		money_label.setFont(new Font("나눔고딕", Font.PLAIN, 17));
		money_label.setText(logdto.getT_balance() + "");

		JLabel lblNewLabel_1 = new JLabel("출금할 금액");
		lblNewLabel_1.setBounds(156, 198, 138, 30);
		panel_mid.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setBounds(327, 187, 307, 50);
		panel_mid.add(textField);
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				if (!((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						|| (ke.getKeyChar() == KeyEvent.VK_ENTER))) {
					warning.setVisible(true);
					ke.consume();
				} else if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					warning.setVisible(false);
				}
				if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
					btn01.requestFocus();
				}
			}
		});

		warning = new JLabel("숫자를 입력하세요");
		warning.setBounds(540, 230, 100, 30);
		panel_mid.add(warning);
		warning.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		warning.setForeground(Color.red);
		warning.setVisible(false);

		btn01 = new JButton("출 금");
		btn01.setBackground(SystemColor.control);
		btn01.setBounds(156, 319, 200, 70);
		panel_mid.add(btn01);
		btn01.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btn01.addActionListener(this);

		JLabel label = new JLabel("원");
		label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label.setBounds(526, 96, 57, 15);
		panel_mid.add(label);

		JButton backbutton = new JButton("되돌아가기");
		backbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(contentPane, "이 페이지를 나가시겠습니까?", "되돌아 가기", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == 0) {
					MainGUI_afterLogin myView = new MainGUI_afterLogin(logdto);
					myView.setVisible(true);
					dispose();
				}
			}
		});
		backbutton.setFont(new Font("Dialog", Font.PLAIN, 18));
		backbutton.setBackground(SystemColor.menu);
		backbutton.setBounds(434, 319, 200, 70);
		panel_mid.add(backbutton);

		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			if (Integer.parseInt(textField.getText()) > logdto.getT_balance()) {
				JOptionPane.showMessageDialog(null, "출금하실 수 없습니다.", "출금 오류", JOptionPane.INFORMATION_MESSAGE);
			} else {
				CheckPW passwordChk = new CheckPW(this, "비밀번호 확인", logdto);
				passwordChk.setVisible(true);
				if (passwordChk.isPwChk()) {
					biz.Withdraw(logdto.getAccount(), Integer.parseInt(textField.getText()));
					newReceipt = new OutReceipt(biz.myaccount(logdto.getAccount()),
							Integer.parseInt(textField.getText()), "ATM출금");
					newReceipt.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "취소 요청", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealWithdraw frame = new DealWithdraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}