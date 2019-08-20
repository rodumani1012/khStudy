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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;

public class TransReceipt extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	JPanel check_img;
	JButton btn_confirm;
	BankBiz biz = new BankBiz();
	BankDto my = new BankDto();
	int input = 0;
	String in_message = "";
	
	public TransReceipt() {
		
	}

	public TransReceipt(BankDto dto, int input, String input_message) {
		this.my = dto;
		this.input = input;
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
		
		JLabel label_1 = new JLabel("이체가 성공적으로 완료되었습니다!");
		label_1.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 18));
		finish.add(label_1);
		
		getContentPane().add(check_img);
		check_img.setLayout(null);
		JLabel label = new JLabel("",imgIcon,SwingConstants.CENTER);
		label.setBounds(206, 18, 50, 44);
		check_img.add(label);
		
		JPanel in_money = new JPanel();
		in_money.setBounds(0, 163, 464, 72);
		getContentPane().add(in_money);
		in_money.setLayout(null);
		
		JLabel input_money = new JLabel("이체하신 금액");
		input_money.setHorizontalAlignment(SwingConstants.LEFT);
		input_money.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		input_money.setBounds(40, 10, 100, 52);
		in_money.add(input_money);
		
		JLabel in_label = new JLabel("newlabel");
		in_label.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		in_label.setHorizontalAlignment(SwingConstants.RIGHT);
		in_label.setBounds(180, 20, 189, 33);
		in_money.add(in_label);
		in_label.setText(input+"원");
		
		JPanel message = new JPanel();
		message.setBounds(0, 245, 464, 72);
		
		
		getContentPane().add(message);
		message.setLayout(null);
		
		JLabel msg = new JLabel("이체 메모");
		msg.setHorizontalAlignment(SwingConstants.LEFT);
		msg.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		msg.setBounds(40, 10, 100, 52);
		message.add(msg);
		
		JLabel msg_label = new JLabel("New label");
		msg_label.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		msg_label.setHorizontalAlignment(SwingConstants.RIGHT);
		msg_label.setBounds(180, 20, 189, 33);
		message.add(msg_label);
		msg_label.setText(in_message);
		
		
		JPanel balance = new JPanel();
		balance.setBounds(0, 315, 464, 72);
		getContentPane().add(balance);
		balance.setLayout(null);

		
		JLabel bal = new JLabel("잔  액");
		bal.setHorizontalAlignment(SwingConstants.LEFT);
		bal.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		bal.setBounds(40, 10, 100, 52);
		balance.add(bal);
		
		JLabel bal_label = new JLabel("New label");
		bal_label.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 15));
		bal_label.setHorizontalAlignment(SwingConstants.RIGHT);
		bal_label.setBounds(180, 20, 189, 33);
		balance.add(bal_label);
		bal_label.setText(dto.getT_balance()-input+"원");
		
		btn_confirm = new JButton("확인");//확인버튼
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			} 
		});
		btn_confirm.setFont(new Font("나눔스퀘어_ac Light", Font.PLAIN, 18));
		btn_confirm.setBackground(new Color(0, 162, 154));
		btn_confirm.setBounds(220, 440, 180, 60);
		getContentPane().add(btn_confirm);
		btn_confirm.addActionListener(this);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		setSize(440,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_confirm) {
			dispose();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(30, 190, 410, 190);
		g.drawLine(30, 270, 410, 270);
		g.drawLine(30, 350, 410, 350);
	}
	
	public static void main(String[] args) {
		try {
			TransReceipt dialog = new TransReceipt();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}