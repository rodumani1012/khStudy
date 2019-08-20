package com.my.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewID extends client implements ActionListener {
	private String name;
	private String pw;

	private client client;

	JFrame jframe = new JFrame("ȸ������ â");

	JLabel name_label = new JLabel("�̸�");
	JLabel pw_label = new JLabel("��й�ȣ");

	JTextField name_input = new JTextField(15);
	JPasswordField pw_input = new JPasswordField(15);

	JPanel name_panel = new JPanel();
	JPanel pw_panel = new JPanel();
	JPanel button_panel = new JPanel();

	JButton insert_Btn = new JButton("ȸ������");
	JButton cancel_Btn = new JButton("���");

	//	�⺻ ������ -> setting()����
	public NewID(client client) {
		this.client = client;
		setting();
	}

	public void setting() {
		//	setting
		Container container = jframe.getContentPane();
		container.setLayout(new FlowLayout());

		container.add(new JLabel("ȸ�������� ���� ������ �Է����ּ���!"), "South");

		name_panel.add(name_label);
		name_panel.add(name_input);

		pw_panel.add(pw_label);
		pw_panel.add(pw_input);

		button_panel.add(insert_Btn);
		button_panel.add(cancel_Btn);

		// event
		buttonevent();

		container.add(name_panel, BorderLayout.CENTER);
		container.add(pw_panel, BorderLayout.CENTER);
		container.add(button_panel, BorderLayout.SOUTH);

		jframe.setBounds(550, 250, 300, 300);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void buttonevent() {
		insert_Btn.addActionListener(this);
		cancel_Btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ȸ������")) {
			// ȸ������ â���� �Է¹��� ������ client�� newid �޼ҵ忡 �Ѱ���
			name = name_input.getText();
			pw = pw_input.getText();
			client.newid(name, pw);			//	Ŭ���̾�Ʈ�� �Է¹��� name,pw ����
			
			jframe.setVisible(false);
			client.clientSetvisible();		//	ȸ�������� ������� �� â�� �Ⱥ��̰� �ϰ� clientâ�� �ٽ� ȣ��

		} else if (e.getActionCommand().equals("���")) {
			jframe.setVisible(false);
			client.clientSetvisible();		//	��Ҹ� ������� �� â�� �Ⱥ��̰� �ϰ� clientâ�� �ٽ� ȣ��
		}
	}
}
