package RoundButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;

public class OutReceipt extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	JPanel check_img;
	JButton brn_confirm,btn_again;
	BankBiz biz = new BankBiz();
	BankDto my = new BankDto();
	int output = 0;
	String in_message = "";
	
	public OutReceipt() {}

	public OutReceipt(BankDto dto, int output, String input_message) {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //본인(자기)만 꺼지게 하는 것
			}
		});
		
		this.my = dto;
		this.output = output;
		this.in_message = input_message;
		check_img = new JPanel();
		check_img.setBounds(0, 28, 464, 72);
	
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		ImageIcon imgIcon = new ImageIcon("images/check_mark.png");
		getContentPane().setLayout(null);
		
		JPanel empty = new JPanel();
		empty.setBounds(0, 0, 464, 21);
		getContentPane().add(empty);
		
		JPanel finish = new JPanel();
		finish.setBounds(0, 98, 464, 44);
		getContentPane().add(finish);
		
		JLabel label_1 = new JLabel("\uCD9C\uAE08\uC774 \uC644\uB8CC \uB418\uC5C8\uC2B5\uB2C8\uB2E4!");
		label_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		finish.add(label_1);
		
		getContentPane().add(check_img);
		check_img.setLayout(null);
		JLabel label = new JLabel("",imgIcon,SwingConstants.CENTER);
		label.setBounds(206, 18, 50, 44);
		check_img.add(label);
		
		JPanel out_money = new JPanel();
		out_money.setBounds(0, 163, 464, 72);
		getContentPane().add(out_money);
		out_money.setLayout(null);
		
		JLabel output_money = new JLabel("\uCD9C\uAE08\uAE08\uC561");
		output_money.setHorizontalAlignment(SwingConstants.CENTER);
		output_money.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		output_money.setBounds(47, 10, 71, 52);
		out_money.add(output_money);
		
		JLabel out_label = new JLabel("newlabel");
		out_label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		out_label.setHorizontalAlignment(SwingConstants.RIGHT);
		out_label.setBounds(210, 20, 189, 33);
		out_money.add(out_label);
		out_label.setText(output+"원");
		
		JPanel message = new JPanel();
		message.setBounds(0, 245, 464, 72);
		
		
		getContentPane().add(message);
		message.setLayout(null);
		
		JLabel msg = new JLabel("\uD1B5\uC7A5\uBA54\uBAA8");
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		msg.setBounds(48, 10, 71, 52);
		message.add(msg);
		
		JLabel msg_label = new JLabel("New label");
		msg_label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		msg_label.setHorizontalAlignment(SwingConstants.RIGHT);
		msg_label.setBounds(210, 20, 189, 33);
		message.add(msg_label);
		msg_label.setText(in_message);
		
		
		JPanel balance = new JPanel();
		balance.setBounds(0, 315, 464, 72);
		getContentPane().add(balance);
		balance.setLayout(null);

		
		JLabel bal = new JLabel("\uC794\uC561");
		bal.setHorizontalAlignment(SwingConstants.CENTER);
		bal.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		bal.setBounds(44, 10, 71, 52);
		balance.add(bal);
		
		JLabel bal_label = new JLabel("New label");
		bal_label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		bal_label.setHorizontalAlignment(SwingConstants.RIGHT);
		bal_label.setBounds(210, 20, 189, 33);
		balance.add(bal_label);
		bal_label.setText(dto.getT_balance()+"원");
		
		btn_again = new JButton("출금계속하기");//확인버튼
		btn_again.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DealWithdraw withdraw = new DealWithdraw(my);
				withdraw.setVisible(true);
			} 
		});
		btn_again.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btn_again.setBackground(new Color(255, 255, 255));
		btn_again.setBounds(0,483,217,78);
		getContentPane().add(btn_again);
		btn_again.addActionListener(this);
		
		brn_confirm = new JButton("\uD655\uC778");
		brn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI_afterLogin afterLogin = new MainGUI_afterLogin(dto);
				afterLogin.setVisible(true);
				dispose();
			}
		});
		brn_confirm.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		brn_confirm.setBackground(new Color(0, 162, 154));
		brn_confirm.setBounds(217,483,217,78);
		getContentPane().add(brn_confirm);
		brn_confirm.addActionListener(this);
		
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setSize(450,600);
		setLocationRelativeTo(null);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==brn_confirm) {
			dispose();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(50, 190, 410, 190);
		g.drawLine(50, 270, 410, 270);
		g.drawLine(50, 350, 410, 350);
	}
	
	public static void main(String[] args) {
		try {
			OutReceipt dialog = new OutReceipt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
