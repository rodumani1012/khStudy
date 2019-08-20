package RoundButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;

public // 새로뜨는 로그인창
class Login extends JDialog implements ActionListener {

	BankBiz biz = new BankBiz();
	BankDto logindto = null;
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private PlaceholderTextField holder;
	private JButton button;
	private JButton button_1;
	public boolean loginTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		loginTF = false;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setSize(400, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon imgLogo = new ImageIcon("images/logo2.png");
		Image preImg = imgLogo.getImage(); // ImageIcon을 Image로 변환.
		JLabel lbLogo = new JLabel(new ImageIcon(preImg.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH)));
		lbLogo.setBounds(100, 50, 200, 63);
		contentPane.add(lbLogo);

		JLabel lblID = new JLabel("계좌번호");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("나눔스퀘어_ac Light", Font.BOLD, 16));
		lblID.setBounds(45, 160, 97, 18);
		contentPane.add(lblID);

		JLabel lblPW = new JLabel("패스워드");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("나눔스퀘어_ac Light", Font.BOLD, 16));
		lblPW.setBounds(45, 212, 97, 18);
		contentPane.add(lblPW);

		// textField 아이디입력칸
		idField = new JTextField();
		LimitFont lf = new LimitFont();
		idField.setDocument(lf);
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (idField.getText().length() == 11) {
					passwordField.requestFocus();
				}
			}
		});
		idField.setBounds(155, 150, 180, 40);
		contentPane.add(idField);
		idField.setColumns(10);

		// 비밀번호 입력칸
		passwordField = new JPasswordField();
		LimitFont lf2 = new LimitFont();
		passwordField.setDocument(lf2);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (passwordField.getText().length() == 4) {
					button.requestFocus();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				JTextField src = (JTextField) e.getSource();
				if (src.getText().length() >= 4) {
					e.consume();
				}
			}
		});
		passwordField.setBounds(155, 200, 180, 40);
		contentPane.add(passwordField);

		button = new JButton("로 그 인");
		button.setFont(new Font("나눔스퀘어_ac Light", Font.BOLD, 16));
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					String account = idField.getText();
					String password = passwordField.getText();
					logindto = biz.login(account, password);

					if (logindto.getAccount() != null) {
						openMyView();
						loginTF = true;
						if (loginTF) {
							MainGUI_beforeLogin main = new MainGUI_beforeLogin();
							main.setVisible(false);
						}
					} else {
						System.out.println("계좌번호 또는 비밀번호를 잘못 입력하셨습니다. 초기 화면으로 돌아갑니다.");
						JOptionPane.showMessageDialog(null, "계좌번호 또는 비밀번호를 잘못 입력하셨습니다.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				String account = idField.getText();
				String password = passwordField.getText();
				logindto = biz.login(account, password);

				if (logindto.getAccount() != null) {
					openMyView();
					loginTF = true;
					if (loginTF) {
						MainGUI_beforeLogin main = new MainGUI_beforeLogin();
						main.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "계좌번호 또는 비밀번호를 잘못 입력하셨습니다.", "Error",
							JOptionPane.ERROR_MESSAGE);
					System.out.println("계좌번호 또는 비밀번호를 잘못 입력하셨습니다. 초기 화면으로 돌아갑니다.");
				}
			}
		});

		button.addActionListener(this);
		button.setBounds(45, 280, 150, 60);
		contentPane.add(button);

		button_1 = new JButton("취    소");
		button_1.setFont(new Font("나눔스퀘어_ac Light", Font.BOLD, 16));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loginTF = false;
				dispose();
				MainGUI_beforeLogin main = new MainGUI_beforeLogin();
				main.setVisible(true);
			}
		});
		button_1.setBounds(205, 280, 150, 60);
		contentPane.add(button_1);
	}

	public boolean isLoginTF() {
		return loginTF;
	}

	public boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public void openMyView() {
		dispose();
		MainGUI_afterLogin afterLogin = new MainGUI_afterLogin(logindto);
		afterLogin.setVisible(true);
	}
}