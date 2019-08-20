package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.biz.BankBiz;
import com.dto.BankDto;

public class LookAccount extends JFrame {

	private JPanel contentPane;
	private JTextField fName;
	private JTextField fAccount;
	private JTextField fBalance;
	private JTable lookTable;
	private DefaultTableModel model;
	private BankBiz biz = new BankBiz();
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LookAccount frame = new LookAccount();
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
	// 기본 생성자
	public LookAccount() {
	}

	// dto 생성자
	public LookAccount(BankDto dto) {

		setTitle("::계좌조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pan00 = new JPanel();
		pan00.setBounds(0, -10, 800, 100);
		contentPane.add(pan00);
		contentPane.setLayout(null);
		ImageIcon logo00 = new ImageIcon("images/banner_showmeMoney.png");
		Image img00 = logo00.getImage();
		Image after00 = img00.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon00 = new ImageIcon(after00);
		JLabel BanLa00 = new JLabel("");
		BanLa00.setIcon(icon00);
		BanLa00.setBounds(0, 0, 800, 100);
		pan00.add(BanLa00);
		this.getContentPane().add(pan00);
		pan00.setVisible(true);

		JPanel pan10 = new JPanel();
		pan10.setBounds(0, -10, 800, 100);
		contentPane.add(pan10);
		contentPane.setLayout(null);
		ImageIcon logo10 = new ImageIcon("images/banner_showmeAll.png");
		Image img10 = logo10.getImage();
		Image after10 = img10.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon10 = new ImageIcon(after10);
		JLabel BanLa10 = new JLabel("");
		BanLa10.setIcon(icon10);
		BanLa10.setBounds(0, 0, 800, 100);
		pan10.add(BanLa10);
		this.getContentPane().add(pan10);
		pan10.setVisible(false);

		JPanel pan01 = new JPanel();
		pan01.setBounds(0, 100, 800, 170);
		contentPane.add(pan01);
		pan01.setLayout(null);

		fName = new JTextField();
		fName.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		fName.setHorizontalAlignment(SwingConstants.CENTER);
		fName.setText(dto.getName());
		fName.setEditable(false);
		fName.setBounds(83, 46, 169, 30);
		pan01.add(fName);
		fName.setColumns(10);

		fAccount = new JTextField();
		fAccount.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		fAccount.setHorizontalAlignment(SwingConstants.CENTER);
		fAccount.setText(dto.getAccount());
		fAccount.setEditable(false);
		fAccount.setColumns(10);
		fAccount.setBounds(338, 46, 169, 30);
		pan01.add(fAccount);

		fBalance = new JTextField();
		fBalance.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		fBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		fBalance.setText(" ");
		//fBalance.setText(String.format("%,d", dto.getT_balance()) + "  ");
		fBalance.setEditable(false);
		fBalance.setColumns(10);
		fBalance.setBounds(196, 109, 239, 46);
		pan01.add(fBalance);

		JLabel lblNewLabel = new JLabel("님의");
		lblNewLabel.setBounds(276, 46, 58, 30);
		pan01.add(lblNewLabel);

		JLabel label = new JLabel("계좌");
		label.setBounds(533, 46, 58, 30);
		pan01.add(label);

		JLabel label_1 = new JLabel("잔액 : ");
		label_1.setBounds(124, 118, 58, 30);
		pan01.add(label_1);

		JLabel label_2 = new JLabel("원");
		label_2.setBounds(449, 118, 58, 30);
		pan01.add(label_2);

		JButton bBack = new JButton("돌아가기");
		bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(contentPane, "이 페이지를 나가시겠습니까?", "되돌아 가기", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == 0) {
					MainGUI_afterLogin afterLogin = new MainGUI_afterLogin(dto);
					afterLogin.setVisible(true);
					dispose();
				}
			}
		});
		bBack.setBounds(590, 40, 140, 40);
		bBack.setBackground(new Color(11, 162, 154));
		bBack.setForeground(new Color(255, 255, 255));
		bBack.setFocusPainted(false);
		pan01.add(bBack);

		JPanel pan02 = new JPanel();
		pan02.setBounds(0, 270, 800, 250);
		contentPane.add(pan02);
		pan02.setLayout(null);

		JButton bWeek = new JButton("1주일");
		bWeek.setBounds(18, 110, 80, 30);
		bWeek.setBackground(Color.gray.brighter());
		bWeek.setForeground(Color.gray.darker());
		bWeek.setFocusPainted(false);
		bWeek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String com = (String) comboBox.getSelectedItem();
				List<BankDto> lookList = biz.tradeListBTW(dto.getAccount(), 7, com);
				if (lookList.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "해당 계좌내역이 존재하지않습니다.");
				} else {
					model.setRowCount(0);
					JOptionPane.showMessageDialog(contentPane, lookList.size() + "건의 내역이 존재합니다.");
					for (int i = 0; i < lookList.size(); i++) {
						BankDto dto = (BankDto) lookList.get(i);
						Date trade_date = dto.getTrade_date();
						String sender = dto.getSender();
						String message = dto.getMessage();
						int input = dto.getInput();
						int output = dto.getOutput();
						int balance = dto.getBalance();
						model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
					}
					lookTable.setModel(model);
				}

			}

		});
		pan02.add(bWeek);

		JButton bMon = new JButton("1개월");
		bMon.setBounds(18, 160, 80, 30);
		bMon.setBackground(Color.gray.brighter());
		bMon.setForeground(Color.gray.darker());
		bMon.setFocusPainted(false);
		bMon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String com = (String) comboBox.getSelectedItem();
				List<BankDto> lookList = biz.tradeListBTW(dto.getAccount(), 1, com);
				if (lookList.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "해당 계좌내역이 존재하지않습니다.");
				} else {
					model.setRowCount(0);
					JOptionPane.showMessageDialog(contentPane, lookList.size() + "건의 내역이 존재합니다.");
					for (int i = 0; i < lookList.size(); i++) {
						BankDto dto = (BankDto) lookList.get(i);
						Date trade_date = dto.getTrade_date();
						String sender = dto.getSender();
						String message = dto.getMessage();
						int input = dto.getInput();
						int output = dto.getOutput();
						int balance = dto.getBalance();
						model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
					}
					lookTable.setModel(model);
				}

			}

		});
		pan02.add(bMon);

		JButton bSix = new JButton("6개월");
		bSix.setBounds(18, 210, 80, 30);
		bSix.setBackground(Color.gray.brighter());
		bSix.setForeground(Color.gray.darker());
		bSix.setFocusPainted(false);
		bSix.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String com = (String) comboBox.getSelectedItem();
				List<BankDto> lookList = biz.tradeListBTW(dto.getAccount(), 6, com);
				if (lookList.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "해당 계좌내역이 존재하지않습니다.");
				} else {
					model.setRowCount(0);
					JOptionPane.showMessageDialog(contentPane, lookList.size() + "건의 내역이 존재합니다.");
					for (int i = 0; i < lookList.size(); i++) {
						BankDto dto = (BankDto) lookList.get(i);
						Date trade_date = dto.getTrade_date();
						String sender = dto.getSender();
						String message = dto.getMessage();
						int input = dto.getInput();
						int output = dto.getOutput();
						int balance = dto.getBalance();
						model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
					}
					lookTable.setModel(model);
				}

			}

		});
		pan02.add(bSix);

		JButton bLook = new JButton("조회하기");
		bLook.setBackground(new Color(11, 162, 154));
		bLook.setForeground(new Color(255, 255, 255));
		bLook.setFocusPainted(false);
		bLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pan02.setVisible(true);
				pan00.setVisible(false);
				pan10.setVisible(true);
				Lookup();
			}

			private void Lookup() {
				List<BankDto> lookList = biz.tradeList(dto.getAccount(), 1);
				if (lookList.size() == 0) {
					JOptionPane.showMessageDialog(contentPane, "해당 계좌내역이 존재하지않습니다.");
				} else {
					model.setRowCount(0);
					JOptionPane.showMessageDialog(contentPane, lookList.size() + "건의 내역이 존재합니다.");
					for (int i = 0; i < lookList.size(); i++) {
						BankDto dto = (BankDto) lookList.get(i);
						Date trade_date = dto.getTrade_date();
						String sender = dto.getSender();
						String message = dto.getMessage();
						int input = dto.getInput();
						int output = dto.getOutput();
						int balance = dto.getBalance();
						model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
					}
					lookTable.setModel(model);
				}
			}
		});
		bLook.setBounds(590, 95, 142, 61);
		pan01.add(bLook);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(14, 50, 99, 34);
		pan02.add(comboBox);
		comboBox.addItem("입금 + 출금");
		comboBox.addItem("입금");
		comboBox.addItem("출금");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					switch (e.getItem() + "") {
					case "입금 + 출금":
						List<BankDto> tradeListAll = biz.tradeList(dto.getAccount(), 1);
						if (tradeListAll.size() == 0) {
							JOptionPane.showMessageDialog(contentPane, "거래 내역이 존재하지않습니다.");
						} else {
							model.setRowCount(0);
							for (int i = 0; i < tradeListAll.size(); i++) {
								BankDto dto = (BankDto) tradeListAll.get(i);
								Date trade_date = dto.getTrade_date();
								String sender = dto.getSender();
								String message = dto.getMessage();
								int input = dto.getInput();
								int output = dto.getOutput();
								int balance = dto.getBalance();
								model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
							}
							lookTable.setModel(model);
						}
						break;
					case "입금":
						List<BankDto> tradeListIn = biz.tradeList(dto.getAccount(), 2);
						if (tradeListIn.size() == 0) {
							model.setRowCount(0);
							JOptionPane.showMessageDialog(contentPane, "입금내역이 존재하지않습니다.");
						} else {
							model.setRowCount(0);
							JOptionPane.showMessageDialog(contentPane, tradeListIn.size() + "건의 입금 내역이 존재합니다.");
							for (int i = 0; i < tradeListIn.size(); i++) {
								BankDto dto = (BankDto) tradeListIn.get(i);
								Date trade_date = dto.getTrade_date();
								String sender = dto.getSender();
								String message = dto.getMessage();
								int input = dto.getInput();
								int output = dto.getOutput();
								int balance = dto.getBalance();
								model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
							}
							lookTable.setModel(model);
						}
						break;
					case "출금":
						List<BankDto> tradeListOut = biz.tradeList(dto.getAccount(), 3);
						if (tradeListOut.size() == 0) {
							model.setRowCount(0);
							JOptionPane.showMessageDialog(contentPane, "출금내역이 존재하지 않습니다.");
						} else {
							model.setRowCount(0);
							JOptionPane.showMessageDialog(contentPane, tradeListOut.size() + "건의 출금 내역이 존재합니다.");
							for (int i = 0; i < tradeListOut.size(); i++) {
								BankDto dto = (BankDto) tradeListOut.get(i);
								Date trade_date = dto.getTrade_date();
								String sender = dto.getSender();
								String message = dto.getMessage();
								int input = dto.getInput();
								int output = dto.getOutput();
								int balance = dto.getBalance();
								model.addRow(new Object[] { trade_date, sender, message, input, output, balance });
							}
							lookTable.setModel(model);
						}
						break;
					}
				}
			}
		});

		lookTable = new JTable();
		lookTable.setBackground(SystemColor.inactiveCaption);
		lookTable.setForeground(SystemColor.windowBorder);
		model = new DefaultTableModel();
		model.addColumn("거래날짜");
		model.addColumn("보낸분/받는분");
		model.addColumn("송금메모");
		model.addColumn("입금액");
		model.addColumn("출금액");
		model.addColumn("잔액");
		lookTable.setModel(model);
		lookTable.setSize(600, 200);
		lookTable.setLocation(50, 50);
		lookTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(lookTable);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(122, 50, 630, 199);
		pan02.add(scrollPane);
		pan02.setVisible(false);
		this.getContentPane().add(pan02);
		this.setVisible(true);

	}

}