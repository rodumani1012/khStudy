package com.my.client;

import javax.swing.*;

import com.blackjack.BlackjackClient;
import com.seoda.SeodaView;
import com.slot.SlotMachine;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SelectGame implements ActionListener {
	private client client;

	private JFrame jframe;
	private JPanel title, select, exit;
	private JLabel jlabel;
	private JButton btn1, btn2, btn3, btn4, logout;

	SeodaView seoda = null;				//	���ٰ��� ȣ��
	BlackjackClient BJClient = null;		//	���� ���� ȣ��
	SlotMachine SMClient = null;			//	���Ըӽ� ���� ȣ��

	//	client�� �޴� ������
	public SelectGame(client client) {
		this.client = client;

		jframe = new JFrame("KH LAND");

		title = new JPanel();
		select = new JPanel();
		exit = new JPanel();

		jlabel = new JLabel("KH LAND");

		btn1 = new JButton("����");
		btn2 = new JButton("����");
		btn3 = new JButton("���Ըӽ�");
		btn4 = new JButton("��Ÿ");

		logout = new JButton("�α׾ƿ�");

		show();
	}

	public void show() {
		//	setting
		jframe.setLayout(new FlowLayout());

		title.add(jlabel);

		select.add(btn1);
		select.add(btn2);
		select.add(btn3);
		select.add(btn4);

		exit.add(logout);

		jframe.add(title);
		jframe.add(select);
		jframe.add(exit);

		jframe.setSize(700, 500);
		jframe.setLocation(550, 250);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.pack();

		//	event
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		logout.addActionListener(this);
	}

	// client���� �Ѿ�� message(msg)�� ���� �´� if�� ����
	// serviceThread���� ���� �� �� ���ӿ� �°� ���� �տ� �����̸��� ����־���
	public void deliveryMsg(String msg) {
		if (msg.contains("BJ")) {
			BJClient.showhand(msg);
		} else if (msg.contains("SLOT")) {
			SMClient.receiveMsg(msg);
		} else if(msg.contains("SEODA")) {
			seoda.showMsg(msg);
		} else if(msg.equals("BACK")) {
			jframe.setVisible(true);
		}
	}

	//	��ư Ŭ�� ��
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		String select = btn.getText();

		//	Ŭ���� ��ư�� �̸��� ���� ����(client�� �״�� �����ϸ鼭 ���� ����)
		switch (select) {
		case "����":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "��!��!");
			BJClient = new BlackjackClient(client);
			BJClient.go();
			break;
		case "����":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "��!��!");
			seoda = new SeodaView(client);
			seoda.show();
			break;
		case "���Ըӽ�":
			jframe.setVisible(false);
			JOptionPane.showMessageDialog(jframe, "����!�ӽ�!");
			SMClient = new SlotMachine(client);
			SMClient.slotStart();
			break;
		case "��Ÿ":
			JOptionPane.showMessageDialog(jframe, "���� ���Դϴ�.... ������ �̿��� �ּ���");
			break;
		case "�α׾ƿ�":
			JOptionPane.showMessageDialog(jframe, "���ö� ����������� ������ �ƴ϶���");
			JOptionPane.showMessageDialog(jframe, "���� ������â Xǥ�� ������ �����ּ���");
			break;
		default:
			JOptionPane.showMessageDialog(jframe, "���� �߻�!!!");
		}
	}

}
