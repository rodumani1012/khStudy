package com.my.client;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import java.net.*;
import java.io.*;

public class client implements ActionListener, Runnable {
	//	GUI ����
	JFrame jframe = new JFrame("5�� Project");

	Label id_label = new Label("���̵�(�̸�)");
	Label pw_label = new Label("��й�ȣ");

	Panel login_panel_1 = new Panel();
	Panel login_panel_2 = new Panel();
	Panel newid_panel = new Panel();

	TextField id_input = new TextField(20);
	JPasswordField pw_input = new JPasswordField(20);

	Button newid_btn = new Button("ȸ������");
	Button login_btn = new Button("�α���");

	SelectGame selGame = null;

	public Socket clientSocket = null;
	public PrintWriter out = null;
	public BufferedReader in = null;
	
	public client() { // �⺻������

	}

	public void show() {
		// setting
		Container container = jframe.getContentPane();
		container.setLayout(new FlowLayout());

		login_panel_1.add(id_label);
		login_panel_1.add(id_input);

		login_panel_2.add(pw_label);
		login_panel_2.add(pw_input);

		newid_panel.add(newid_btn);
		newid_panel.add(login_btn);

		container.add(new Label("���̵�� ��й�ȣ�� �Է��ϼ���!"), BorderLayout.NORTH);
		container.add(login_panel_1, BorderLayout.CENTER);
		container.add(login_panel_2, BorderLayout.CENTER);
		container.add(newid_panel, BorderLayout.SOUTH);

		// event
		buttonevent();

		jframe.setBounds(550, 250, 300, 200);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void buttonevent() {
		// �� ��ư Ŭ���� Ŭ�� �̺�Ʈ �߻�
		newid_btn.addActionListener(this);
		login_btn.addActionListener(this);
	}

	// ���� ip�� port��ȣ �ο� out�� in�� ���� �ʱ�ȭ
	public void connect(String host, int port) {
		System.out.println("���� ���� ��....");
		try {
			clientSocket = new Socket(host, port);	//	������ �������ּҿ� ��Ʈ��ȣ�� �ѱ�鼭 ����
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ �����߻�!!!");
			System.exit(1);
			e.printStackTrace();
		}
	}

	// ���� ���� ����
	public void disconnect() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ȸ������ name�� pw�� �޾Ƽ� msg�� ���·� ������ ����
	public void newid(String name, String pw) {
		System.out.println("ȸ������ " + name + " " + pw);
		String msg = "REGISTRY " + name + " " + pw;
		this.out.println(msg);	//	ServiceThread�� ����
	}
	
	// BACK��ư , ��� ��ư �� �� â�� �ݰ� Ŭ���̾�Ʈ�� Ű�� ���� �޼���
	public void clientSetvisible() {
		jframe.setVisible(true);
	}

	// ��ư Ŭ���� ����
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ȸ������")) {
			new NewID(this);				// NewID Ŭ���� ���� ȣ��(Client����)
			jframe.setVisible(false);	// Ŭ���̾�Ʈâ �Ⱥ��̰� ��
										// dispose() �� �� ������ dispose�� �ϰ� �Ǹ� �츮�� ȣ���� ������ �� ��ü�� ��� �����
		} else if (e.getActionCommand().equals("�α���")) {
			String login = "LOGIN " + id_input.getText() + " " + pw_input.getText();
			this.out.println(login);		// serviceThread�� �α��θ޽��� ���� �����ϸ� �����忡�� ���� ���� �޽����� ���� selectgame����
			jframe.setVisible(false);	// Ŭ���̾�Ʈâ �Ⱥ��̰� ��
		}
	}

	// �޽����� ��� �ޱ�
	@Override
	public void run() {
		try {
			String inputLine;
			while (true) {
				if ((inputLine = in.readLine()) != null) {
					if (inputLine.equals("SUCESS")) {
						// serviceThread���� �α��ο� �����ߴٸ� "SUCESS"�޽��� ���޷� selectgame�� ���
						jframe.setVisible(false);		//	Ŭ���̾�Ʈ â�� �Ⱥ��̰���
						selGame = new SelectGame(this);	//	selectgame ȣ��(client����)
						
					} else if (inputLine.equals("FAIL")) {
						// �α��ο� �����ߴٸ�
						JOptionPane.showMessageDialog(jframe, "�α��� ����!");	//	"�α��� ����!"��� �޽���â ȣ��
						jframe.setVisible(true);								//	�ٽ� Ŭ���̾�Ʈâ ������
						
					} else if (inputLine.equals("REGISTRY SUCESS")) {
						// ȸ�����Կ� �����ߴٸ�
						jframe.setVisible(true);
						
					} else {
						// �������� �޽����� ���� selGame�� deliveryMsg �޼ҵ忡 �Ѱ���
						selGame.deliveryMsg(inputLine);
					}
				}
			}
		} catch (IOException e) {
			disconnect();
		}
	}

	public static void main(String[] args) {
		client client = new client();
		client.connect("192.168.10.3", 6666);
		client.show();

		Thread thread = new Thread(client);
		thread.start();
	}
}
