package com.seoda;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.my.client.*;

public class SeodaView implements ActionListener {
	/*
	 * 	�ڵ尡 ���� ��ϴ�.... �ؿ� �̹��� ���ú��ʹ� ũ�� �Ⱥ��ŵ� �˴ϴ�.
	 *  ��� ������ ������ ��� ���� �¸��� �Ͽ����ϴ�. ( ��, ��, ������, ������, �籸 ��� ����� ���� �ʹ� ���� �������� ���߽��ϴ�)
	 *  �� ī��� (1,2,3~10)�� Ư����(�� ������) , (11,22,33 ~ 110)�� �Ϲ���
	 */
	
	private client client;			//	Client Ŭ���� ���� ����
	private String name;				//	�ڽ��� �̸�
	private int money;				//	�ڽ��� ��
	private int battingMoney;		//	������ �ݾ�
	private int call_count = 0;		//	�� ī��Ʈ (5������ �� �� �ֽ��ϴ�)

	private int[] mycard = new int[2];	//	�ڽ��� ī�� ����(�迭)
	private int number = 0;				//	ī�� �̹��� ������ ���� ����
	private int userCardNumber = 0;		//	���� ī�� �̹��� ������ ���� ����
	private String[] msgArr = null;		//	�޽����迭

	private compare compare = new compare();	//	��������� ���� ���� compare Ŭ���� ���� ȣ��

	JFrame jframe = new JFrame("KH LAND - ����");
	//	�� ������ �ǳ�(�ǳ� �ȿ� �� ���� ������ �ְ� �� �ǳ��� �����ӿ� �߰��ϴ� ���)
	Panel user1, user2, user3, user4, my;

	//	�ڽ��� ȭ��
	JLabel card_1, card_2, myname, mymoney;
	
	//	�ٸ� ���� ȭ��
	JLabel user1_name, user1_money, user2_name, user2_money, user3_name, user3_money, user4_name, user4_money;
	//	����ȭ�鿡�� �ڱ� �ڽ��� ������ ������ ī�� �޸� ������ ���� ����
	ImageIcon user1_1, user1_2, user2_1, user2_2, user3_1, user3_2, user4_1, user4_2;
	JLabel user1_1_label, user1_2_label, user2_1_label, user2_2_label, user3_1_label, user3_2_label, user4_1_label,
			user4_2_label;

	//	�� ��ư ��
	Button call, die, ready, result, back;

	//	ä��â ���
	TextArea chat_area;
	TextField chat_in;
	JLabel chat_header, center_image;
	
	Panel center_panel;		//	ȭ�� ��� �̹���
	ImageIcon center_Background = new ImageIcon("src/seoda_Image/centerBackground.jpg");

	//	�� ī���� �̹�����
	ImageIcon img, img1, img11, img2, img22, img3, img33, img4, img44, img5, img55, img6, img66, img7, img77, img8,
			img88, img9, img99, img10, img110;

	//	client�� �޴� ������
	public SeodaView(client client) {
		this.client = client;

		//	�� GUI��ü ����
		jframe.setLayout(null);
		user1 = new Panel();
		user2 = new Panel();
		user3 = new Panel();
		user4 = new Panel();
		my = new Panel();

		imageSetting();	//	ī���̹��� ���� -> ���� �Ⱥ��ŵ� �˴ϴ�.

		myname = new JLabel("�ڽ�");
		mymoney = new JLabel("��");
		card_1 = new JLabel(img);
		card_2 = new JLabel(img);

		user1_name = new JLabel("����1");
		user1_money = new JLabel("��");
		user1_1_label = new JLabel(user1_1);
		user1_2_label = new JLabel(user1_2);
		user2_name = new JLabel("����2");
		user2_money = new JLabel("��");
		user2_1_label = new JLabel(user2_1);
		user2_2_label = new JLabel(user2_2);
		user3_name = new JLabel("����3");
		user3_money = new JLabel("��");
		user3_1_label = new JLabel(user3_1);
		user3_2_label = new JLabel(user3_2);
		user4_name = new JLabel("����4");
		user4_money = new JLabel("��");
		user4_1_label = new JLabel(user4_1);
		user4_2_label = new JLabel(user4_2);

		call = new Button("CALL");
		die = new Button("DIE");
		back = new Button("BACK");
		ready = new Button("READY");
		result = new Button("RESULT");

		chat_area = new TextArea();
		chat_in = new TextField();
		chat_header = new JLabel("ä��â");
		center_panel = new Panel();
		center_image = new JLabel(center_Background);

	}

	public void show() {
		// ���� Clients�� ���� �߰�
		client.out.println("SEODAIN");

		// ����ȭ���� �����Ű�� �� ����â�� ��쵵�� ����
		client.out.println("SEODASTART");

		// setting
		my.setLayout(new GridLayout(2, 2));
		user1.setLayout(new GridLayout(2, 2));
		user2.setLayout(new GridLayout(2, 2));
		user3.setLayout(new GridLayout(2, 2));
		user4.setLayout(new GridLayout(2, 2));

		my.add(myname);
		my.add(mymoney);
		my.add(card_1);
		my.add(card_2);

		user1.add(user1_name);
		user1.add(user1_money);
		user1.add(user1_1_label);
		user1.add(user1_2_label);
		user2.add(user2_name);
		user2.add(user2_money);
		user2.add(user2_1_label);
		user2.add(user2_2_label);
		user3.add(user3_name);
		user3.add(user3_money);
		user3.add(user3_1_label);
		user3.add(user3_2_label);
		user4.add(user4_name);
		user4.add(user4_money);
		user4.add(user4_1_label);
		user4.add(user4_2_label);

		my.setBounds(600, 750, 300, 150);
		user1.setBounds(30, 100, 250, 200);
		user2.setBounds(30, 400, 250, 200);
		user3.setBounds(1200, 100, 250, 200);
		user4.setBounds(1200, 400, 250, 200);

		call.setBounds(625, 720, 100, 30);
		die.setBounds(775, 720, 100, 30);
		result.setBounds(925, 720, 100, 30);
		ready.setBounds(1075, 720, 100, 30);
		back.setBounds(50, 20, 100, 30);

		chat_area.setBounds(625, 50, 250, 300);
		chat_in.setBounds(625, 370, 250, 30);
		chat_header.setBounds(625,355,100,15);
		center_panel.add(center_image);
		center_panel.setBounds(500,400,600,300);

		call.setEnabled(false);
		die.setEnabled(false);
		ready.setEnabled(true);
		result.setEnabled(false);
		back.setEnabled(true);

		chat_area.setEditable(false);

		jframe.add(my);
		jframe.add(user1);
		jframe.add(user2);
		jframe.add(user3);
		jframe.add(user4);
		jframe.add(call);
		jframe.add(die);
		jframe.add(ready);
		jframe.add(result);
		jframe.add(back);
		jframe.add(chat_area);
		jframe.add(chat_in);
		jframe.add(chat_header);
		
		jframe.add(center_panel);

		// event
		actionEvent();

		// display
		jframe.setSize(1500, 1000);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	//	�� �̺�Ʈ
	public void actionEvent() {
		//	Ŭ����
		call.addActionListener(this);
		die.addActionListener(this);
		ready.addActionListener(this);
		result.addActionListener(this);
		back.addActionListener(this);

		//	�޽��� �Է½�
		chat_in.addActionListener(new InputListener());
	}

	// ä���� ���� �̺�Ʈ Ŭ����
	class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String input = chat_in.getText();
			chat_in.setText("");
			try {
				client.out.println("SEODACHAT " + input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	//	��ư Ŭ�� ��
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();

		// READY�� ������ ���� ����
		if (btn.getLabel().equals("READY")) {
			chat_area.append("���� ���۵Ǿ����ϴ�\n");
			//	�� ��ư Ȱ��ȭ, ��Ȱ��ȭ
			call.setEnabled(true);
			die.setEnabled(true);
			result.setEnabled(true);
			ready.setEnabled(false);
			
			//	�� ���� ī�� �޸����� ����
			user1_1_label.setIcon(user1_1);
			user1_2_label.setIcon(user1_2);
			user2_1_label.setIcon(user2_1);
			user2_2_label.setIcon(user2_2);
			user3_1_label.setIcon(user3_1);
			user3_2_label.setIcon(user3_2);
			user4_1_label.setIcon(user4_1);
			user4_2_label.setIcon(user4_2);
			
			mymoney.setText((money -= 1000000) + "��");			//	����� ����(ȭ����� �� ����)
			battingMoney += 1000000;								//	����� ���� -> ���þ� ����
			chat_area.append(name + " �� ������� : " + battingMoney + " ��\n");	//	ä��â�� ���
			
			client.out.println("SEODAREADY " + name + "���� READY�� �������ϴ�");	//	ServiceThread�� �޽��� ����

			// CALL�� ������
		} else if (btn.getLabel().equals("CALL")) {
			mymoney.setText((money -= 1000000) + "��");			//	ȭ����� �� ����
			battingMoney += 1000000;								//	���þ� ����
			
			//	���� ī�� ������ ���ߴٴ� ���� ä��â�� ���
			chat_area.append("���� ���� : " + compare.compareDeck(mycard) + "��\n");
			chat_area.append(name + " �� ��! ������� : " + battingMoney + " ��\n");
			call_count++;	//	call ī��Ʈ ����(5���� ����)
			
			client.out.println("SEODACALL " + myname.getText() + " " + battingMoney);	//	ServiceThread�� �޽��� ����

			//	call ī��Ʈ�� 5�̸� �ڵ����� ������� ����
			if (call_count == 5) {
				call.setEnabled(false);
				die.setEnabled(false);
				result.setEnabled(false);
				ready.setEnabled(true);
				call_count = 0;
				
				//	ServiceThread�� �޽��� ����
				client.out.println("SEODARESULT" + " " + compare.compareDeck(mycard) + " " + mycard[0] + " " + mycard[1]
						+ battingMoney);
			}

			// DIE�� ������
		} else if (btn.getLabel().equals("DIE")) {
			call.setEnabled(false);
			die.setEnabled(false);
			result.setEnabled(false);

			//	DIE�� ������ ��������� 0������ �Ͽ� ����
			client.out.println("SEODADIE " + myname.getText() + "��DIE " + "0 " + battingMoney);	//	ServiceThread�� �޽��� ����
			chat_area.append("���������...\n");

			// RESULT�� ������
		} else if (btn.getLabel().equals("RESULT")) {
			call.setEnabled(false);
			die.setEnabled(false);
			result.setEnabled(false);
			ready.setEnabled(false);
			chat_area.append("���������...\n");
			client.out.println(
					"SEODARESULT " + myname.getText() + "�԰������� " + compare.compareDeck(mycard) + " " + battingMoney);

			// BACK�� ������ �ڷΰ���
		} else if (btn.getLabel().equals("BACK")) {
			jframe.setVisible(false);
			client.out.println("SEODABACK");
		}
	}

	// ���� �� ���þ� ���
	public void showBattingMoney(String msg) {
		chat_area.append(msg + "\n");
	}

	// �޽����� �޾Ƽ� ������ ����
	public void showMsg(String msg) {
		System.out.println(msg);

		String[] msgArr = msg.split(" ");
		String message = "";
		for (int i = 1; i < msgArr.length; i++) {
			message += (msgArr[i] + " ");
		}

		//	���� �޽����� 0������ ���� ���� if�� ����
		if (msgArr[0].equals("SEODAMY")) {
			this.name = msgArr[1];
			this.money = Integer.parseInt(msgArr[2]);
			myname.setText(name);
			mymoney.setText(String.valueOf(money));
			
			//	���� ����
		} else if (msgArr[0].equals("SEODAUSERSTATUS1")) {
			user1_name.setText(msgArr[1]);
			user1_money.setText(msgArr[2]);
		} else if (msgArr[0].equals("SEODAUSERSTATUS2")) {
			user2_name.setText(msgArr[1]);
			user2_money.setText(msgArr[2]);
		} else if (msgArr[0].equals("SEODAUSERSTATUS3")) {
			user3_name.setText(msgArr[1]);
			user3_money.setText(msgArr[2]);
		} else if (msgArr[0].equals("SEODAUSERSTATUS4")) {
			user4_name.setText(msgArr[1]);
			user4_money.setText(msgArr[2]);
			
			//	���� ī�� ����
		} else if (msgArr[0].equals("SEODAMYCARD")) {
			System.out.println("�� ī�� ������...");
			resultCard(msgArr[1], number);	//	���� ī�忡 ���� �̹����� �޾� ȭ�鿡 ��� (����������...)
			
			mycard[number] = Integer.parseInt(msgArr[1]);		//	ī�尪�� String���� �Ѿ�ӱ� ������ int ����ȯ
			number++;
			if (number == 2) {
				number = 0;
			}
			chat_area.append(message + "\n");	//	���� ī�尪 ä��â�� ���
			
			//	�ٸ� ���� ī�� ����
		} else if (msgArr[0].contains("USERCARD")) {
			System.out.println("�ٸ� ���� ī�� ������");
			resultCard_other(msg, userCardNumber);	//	���� ī�忡 ���� �̹����� �޾� ȭ�鿡 ��� (����������...)
			
			userCardNumber++; // ī�� ��ġ�� ���� ++
			if (userCardNumber == 2) {
				userCardNumber = 0;
			}
			
			//	ä�� ���
		} else if (msgArr[0].equals("SEODACHAT")) {
			chat_area.append(message + "\n");
			
			//	��ü ���þ� ���
		} else if (msgArr[0].equals("SEODATOTALMONEY")) {
			chat_area.append(message + "\n");
			
			//	�������(�¸�,�й�)
		} else if (msgArr[0].equals("SEODARESULT")) {
			chat_area.append(msgArr[1] + " " + msgArr[2] + "\n");
			
			//	CALL �޽��� ���
		} else if (msgArr[0].equals("SEODACALL")) {
			chat_area.append(msgArr[1] + "�� CALL! \n");
			
			//	DIE �޽��� ���
		} else if (msgArr[0].equals("SEODADIE")) {
			chat_area.append(msgArr[1] + "\n");
			
			//	READY �޽��� ���
		} else if (msgArr[0].equals("SEODAREADY")) {
			chat_area.append(msgArr[1] + "�� READY \n");
			
			//	RESET
		} else if (msgArr[0].equals("SEODARESET")) {
			battingMoney = 0;

			ready.setEnabled(true);
		}
	}

	// ī���̹��� ����
	public void imageSetting() {
		img1 = new ImageIcon("src/seoda_Image/1.jpg");
		img11 = new ImageIcon("src/seoda_Image/11.jpg");
		img2 = new ImageIcon("src/seoda_Image/2.jpg");
		img22 = new ImageIcon("src/seoda_Image/22.jpg");
		img3 = new ImageIcon("src/seoda_Image/3.jpg");
		img33 = new ImageIcon("src/seoda_Image/33.jpg");
		img4 = new ImageIcon("src/seoda_Image/4.jpg");
		img44 = new ImageIcon("src/seoda_Image/44.jpg");
		img5 = new ImageIcon("src/seoda_Image/5.jpg");
		img55 = new ImageIcon("src/seoda_Image/55.jpg");
		img6 = new ImageIcon("src/seoda_Image/6.jpg");
		img66 = new ImageIcon("src/seoda_Image/66.jpg");
		img7 = new ImageIcon("src/seoda_Image/7.jpg");
		img77 = new ImageIcon("src/seoda_Image/77.jpg");
		img8 = new ImageIcon("src/seoda_Image/8.jpg");
		img88 = new ImageIcon("src/seoda_Image/88.jpg");
		img9 = new ImageIcon("src/seoda_Image/9.jpg");
		img99 = new ImageIcon("src/seoda_Image/99.jpg");
		img10 = new ImageIcon("src/seoda_Image/10.jpg");
		img110 = new ImageIcon("src/seoda_Image/110.jpg");
		img = new ImageIcon("src/seoda_Image/deck.jpg");

		user1_1 = new ImageIcon("src/seoda_Image/deck.jpg");
		user1_2 = new ImageIcon("src/seoda_Image/deck.jpg");
		user2_1 = new ImageIcon("src/seoda_Image/deck.jpg");
		user2_2 = new ImageIcon("src/seoda_Image/deck.jpg");
		user3_1 = new ImageIcon("src/seoda_Image/deck.jpg");
		user3_2 = new ImageIcon("src/seoda_Image/deck.jpg");
		user4_1 = new ImageIcon("src/seoda_Image/deck.jpg");
		user4_2 = new ImageIcon("src/seoda_Image/deck.jpg");
	}
	
	// �ٸ� ��� ī�� ȭ�鿡 ���
	public void resultCard_other(String msg, int userCardNumber) {
		this.msgArr = msg.split(" ");	//	�޽����� ������ 0������ ������ȣ, 1������ ī���ȣ�� �´� �̹����� ����

		// ù��������
		if (msgArr[0].equals("SEODAUSERCARD1")) {
			if (Integer.parseInt(msgArr[1]) == 1) {
				user1_1_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[1]) == 11) {
				user1_1_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[1]) == 2) {
				user1_1_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[1]) == 22) {
				user1_1_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[1]) == 3) {
				user1_1_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[1]) == 33) {
				user1_1_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[1]) == 4) {
				user1_1_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[1]) == 44) {
				user1_1_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[1]) == 5) {
				user1_1_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[1]) == 55) {
				user1_1_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[1]) == 6) {
				user1_1_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[1]) == 66) {
				user1_1_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[1]) == 7) {
				user1_1_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[1]) == 77) {
				user1_1_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[1]) == 8) {
				user1_1_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[1]) == 88) {
				user1_1_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[1]) == 9) {
				user1_1_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[1]) == 99) {
				user1_1_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[1]) == 10) {
				user1_1_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[1]) == 110) {
				user1_1_label.setIcon(img110);
			}
		}

		if (msgArr[0].equals("SEODAUSERCARD1")) {
			if (Integer.parseInt(msgArr[2]) == 1) {
				user1_2_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[2]) == 11) {
				user1_2_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[2]) == 2) {
				user1_2_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[2]) == 22) {
				user1_2_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[2]) == 3) {
				user1_2_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[2]) == 33) {
				user1_2_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[2]) == 4) {
				user1_2_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[2]) == 44) {
				user1_2_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[2]) == 5) {
				user1_2_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[2]) == 55) {
				user1_2_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[2]) == 6) {
				user1_2_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[2]) == 66) {
				user1_2_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[2]) == 7) {
				user1_2_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[2]) == 77) {
				user1_2_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[2]) == 8) {
				user1_2_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[2]) == 88) {
				user1_2_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[2]) == 9) {
				user1_2_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[2]) == 99) {
				user1_2_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[2]) == 10) {
				user1_2_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[2]) == 110) {
				user1_2_label.setIcon(img110);
			}
		}

		// �ι�������
		if (msgArr[0].equals("SEODAUSERCARD2")) {
			if (Integer.parseInt(msgArr[1]) == 1) {
				user2_1_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[1]) == 11) {
				user2_1_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[1]) == 2) {
				user2_1_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[1]) == 22) {
				user2_1_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[1]) == 3) {
				user2_1_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[1]) == 33) {
				user2_1_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[1]) == 4) {
				user2_1_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[1]) == 44) {
				user2_1_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[1]) == 5) {
				user2_1_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[1]) == 55) {
				user2_1_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[1]) == 6) {
				user2_1_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[1]) == 66) {
				user2_1_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[1]) == 7) {
				user2_1_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[1]) == 77) {
				user2_1_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[1]) == 8) {
				user2_1_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[1]) == 88) {
				user2_1_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[1]) == 9) {
				user2_1_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[1]) == 99) {
				user2_1_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[1]) == 10) {
				user2_1_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[1]) == 110) {
				user2_1_label.setIcon(img110);
			}
		}

		if (msgArr[0].equals("SEODAUSERCARD2")) {
			if (Integer.parseInt(msgArr[2]) == 1) {
				user2_2_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[2]) == 11) {
				user2_2_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[2]) == 2) {
				user2_2_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[2]) == 22) {
				user2_2_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[2]) == 3) {
				user2_2_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[2]) == 33) {
				user2_2_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[2]) == 4) {
				user2_2_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[2]) == 44) {
				user2_2_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[2]) == 5) {
				user2_2_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[2]) == 55) {
				user2_2_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[2]) == 6) {
				user2_2_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[2]) == 66) {
				user2_2_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[2]) == 7) {
				user2_2_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[2]) == 77) {
				user2_2_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[2]) == 8) {
				user2_2_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[2]) == 88) {
				user2_2_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[2]) == 9) {
				user2_2_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[2]) == 99) {
				user2_2_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[2]) == 10) {
				user2_2_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[2]) == 110) {
				user2_2_label.setIcon(img110);
			}
		}

		// ����������
		if (msgArr[0].equals("SEODAUSERCARD3")) {
			if (Integer.parseInt(msgArr[1]) == 1) {
				user3_1_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[1]) == 11) {
				user3_1_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[1]) == 2) {
				user3_1_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[1]) == 22) {
				user3_1_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[1]) == 3) {
				user3_1_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[1]) == 33) {
				user3_1_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[1]) == 4) {
				user3_1_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[1]) == 44) {
				user3_1_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[1]) == 5) {
				user3_1_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[1]) == 55) {
				user3_1_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[1]) == 6) {
				user3_1_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[1]) == 66) {
				user3_1_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[1]) == 7) {
				user3_1_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[1]) == 77) {
				user3_1_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[1]) == 8) {
				user3_1_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[1]) == 88) {
				user3_1_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[1]) == 9) {
				user3_1_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[1]) == 99) {
				user3_1_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[1]) == 10) {
				user3_1_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[1]) == 110) {
				user3_1_label.setIcon(img110);
			}
		}

		if (msgArr[0].equals("SEODAUSERCARD3")) {
			if (Integer.parseInt(msgArr[2]) == 1) {
				user3_2_label.setIcon(img1);
			} else if (Integer.parseInt(msgArr[2]) == 11) {
				user3_2_label.setIcon(img11);
			} else if (Integer.parseInt(msgArr[2]) == 2) {
				user3_2_label.setIcon(img2);
			} else if (Integer.parseInt(msgArr[2]) == 22) {
				user3_2_label.setIcon(img22);
			} else if (Integer.parseInt(msgArr[2]) == 3) {
				user3_2_label.setIcon(img3);
			} else if (Integer.parseInt(msgArr[2]) == 33) {
				user3_2_label.setIcon(img33);
			} else if (Integer.parseInt(msgArr[2]) == 4) {
				user3_2_label.setIcon(img4);
			} else if (Integer.parseInt(msgArr[2]) == 44) {
				user3_2_label.setIcon(img44);
			} else if (Integer.parseInt(msgArr[2]) == 5) {
				user3_2_label.setIcon(img5);
			} else if (Integer.parseInt(msgArr[2]) == 55) {
				user3_2_label.setIcon(img55);
			} else if (Integer.parseInt(msgArr[2]) == 6) {
				user3_2_label.setIcon(img6);
			} else if (Integer.parseInt(msgArr[2]) == 66) {
				user3_2_label.setIcon(img66);
			} else if (Integer.parseInt(msgArr[2]) == 7) {
				user3_2_label.setIcon(img7);
			} else if (Integer.parseInt(msgArr[2]) == 77) {
				user3_2_label.setIcon(img77);
			} else if (Integer.parseInt(msgArr[2]) == 8) {
				user3_2_label.setIcon(img8);
			} else if (Integer.parseInt(msgArr[2]) == 88) {
				user3_2_label.setIcon(img88);
			} else if (Integer.parseInt(msgArr[2]) == 9) {
				user3_2_label.setIcon(img9);
			} else if (Integer.parseInt(msgArr[2]) == 99) {
				user3_2_label.setIcon(img99);
			} else if (Integer.parseInt(msgArr[2]) == 10) {
				user3_2_label.setIcon(img10);
			} else if (Integer.parseInt(msgArr[2]) == 110) {
				user3_2_label.setIcon(img110);
			}

			// �׹�°����
			if (msgArr[0].equals("SEODAUSERCARD4")) {
				if (Integer.parseInt(msgArr[1]) == 1) {
					user4_1_label.setIcon(img1);
				} else if (Integer.parseInt(msgArr[1]) == 11) {
					user4_1_label.setIcon(img11);
				} else if (Integer.parseInt(msgArr[1]) == 2) {
					user4_1_label.setIcon(img2);
				} else if (Integer.parseInt(msgArr[1]) == 22) {
					user4_1_label.setIcon(img22);
				} else if (Integer.parseInt(msgArr[1]) == 3) {
					user4_1_label.setIcon(img3);
				} else if (Integer.parseInt(msgArr[1]) == 33) {
					user4_1_label.setIcon(img33);
				} else if (Integer.parseInt(msgArr[1]) == 4) {
					user4_1_label.setIcon(img4);
				} else if (Integer.parseInt(msgArr[1]) == 44) {
					user4_1_label.setIcon(img44);
				} else if (Integer.parseInt(msgArr[1]) == 5) {
					user4_1_label.setIcon(img5);
				} else if (Integer.parseInt(msgArr[1]) == 55) {
					user4_1_label.setIcon(img55);
				} else if (Integer.parseInt(msgArr[1]) == 6) {
					user4_1_label.setIcon(img6);
				} else if (Integer.parseInt(msgArr[1]) == 66) {
					user4_1_label.setIcon(img66);
				} else if (Integer.parseInt(msgArr[1]) == 7) {
					user4_1_label.setIcon(img7);
				} else if (Integer.parseInt(msgArr[1]) == 77) {
					user4_1_label.setIcon(img77);
				} else if (Integer.parseInt(msgArr[1]) == 8) {
					user4_1_label.setIcon(img8);
				} else if (Integer.parseInt(msgArr[1]) == 88) {
					user4_1_label.setIcon(img88);
				} else if (Integer.parseInt(msgArr[1]) == 9) {
					user4_1_label.setIcon(img9);
				} else if (Integer.parseInt(msgArr[1]) == 99) {
					user4_1_label.setIcon(img99);
				} else if (Integer.parseInt(msgArr[1]) == 10) {
					user4_1_label.setIcon(img10);
				} else if (Integer.parseInt(msgArr[1]) == 110) {
					user4_1_label.setIcon(img110);
				}
			}

			if (msgArr[0].equals("SEODAUSERCARD4")) {
				if (Integer.parseInt(msgArr[2]) == 1) {
					user4_2_label.setIcon(img1);
				} else if (Integer.parseInt(msgArr[2]) == 11) {
					user4_2_label.setIcon(img11);
				} else if (Integer.parseInt(msgArr[2]) == 2) {
					user4_2_label.setIcon(img2);
				} else if (Integer.parseInt(msgArr[2]) == 22) {
					user4_2_label.setIcon(img22);
				} else if (Integer.parseInt(msgArr[2]) == 3) {
					user4_2_label.setIcon(img3);
				} else if (Integer.parseInt(msgArr[2]) == 33) {
					user4_2_label.setIcon(img33);
				} else if (Integer.parseInt(msgArr[2]) == 4) {
					user4_2_label.setIcon(img4);
				} else if (Integer.parseInt(msgArr[2]) == 44) {
					user4_2_label.setIcon(img44);
				} else if (Integer.parseInt(msgArr[2]) == 5) {
					user4_2_label.setIcon(img5);
				} else if (Integer.parseInt(msgArr[2]) == 55) {
					user4_2_label.setIcon(img55);
				} else if (Integer.parseInt(msgArr[2]) == 6) {
					user4_2_label.setIcon(img6);
				} else if (Integer.parseInt(msgArr[2]) == 66) {
					user4_2_label.setIcon(img66);
				} else if (Integer.parseInt(msgArr[2]) == 7) {
					user4_2_label.setIcon(img7);
				} else if (Integer.parseInt(msgArr[2]) == 77) {
					user4_2_label.setIcon(img77);
				} else if (Integer.parseInt(msgArr[2]) == 8) {
					user4_2_label.setIcon(img8);
				} else if (Integer.parseInt(msgArr[2]) == 88) {
					user4_2_label.setIcon(img88);
				} else if (Integer.parseInt(msgArr[2]) == 9) {
					user4_2_label.setIcon(img9);
				} else if (Integer.parseInt(msgArr[2]) == 99) {
					user4_2_label.setIcon(img99);
				} else if (Integer.parseInt(msgArr[2]) == 10) {
					user4_2_label.setIcon(img10);
				} else if (Integer.parseInt(msgArr[2]) == 110) {
					user4_2_label.setIcon(img110);
				}
			}
		}
	}

	// �ڽ� ī�忡 ���� ȭ�鿡 �ٲ���� �޼ҵ�
	public void resultCard(String card, int number) {
		if (number == 0 && card.equals("1")) {
			card_1.setIcon(img1);
		} else if (number == 0 && card.equals("11")) {
			card_1.setIcon(img11);
		} else if (number == 0 && card.equals("2")) {
			card_1.setIcon(img2);
		} else if (number == 0 && card.equals("22")) {
			card_1.setIcon(img22);
		} else if (number == 0 && card.equals("3")) {
			card_1.setIcon(img3);
		} else if (number == 0 && card.equals("33")) {
			card_1.setIcon(img33);
		} else if (number == 0 && card.equals("4")) {
			card_1.setIcon(img4);
		} else if (number == 0 && card.equals("44")) {
			card_1.setIcon(img44);
		} else if (number == 0 && card.equals("5")) {
			card_1.setIcon(img5);
		} else if (number == 0 && card.equals("55")) {
			card_1.setIcon(img55);
		} else if (number == 0 && card.equals("6")) {
			card_1.setIcon(img6);
		} else if (number == 0 && card.equals("66")) {
			card_1.setIcon(img66);
		} else if (number == 0 && card.equals("7")) {
			card_1.setIcon(img7);
		} else if (number == 0 && card.equals("77")) {
			card_1.setIcon(img77);
		} else if (number == 0 && card.equals("8")) {
			card_1.setIcon(img8);
		} else if (number == 0 && card.equals("88")) {
			card_1.setIcon(img88);
		} else if (number == 0 && card.equals("9")) {
			card_1.setIcon(img9);
		} else if (number == 0 && card.equals("99")) {
			card_1.setIcon(img99);
		} else if (number == 0 && card.equals("10")) {
			card_1.setIcon(img10);
		} else if (number == 0 && card.equals("110")) {
			card_1.setIcon(img110);
		}

		if (number == 1 && card.equals("1")) {
			card_2.setIcon(img1);
		} else if (number == 1 && card.equals("11")) {
			card_2.setIcon(img11);
		} else if (number == 1 && card.equals("2")) {
			card_2.setIcon(img2);
		} else if (number == 1 && card.equals("22")) {
			card_2.setIcon(img22);
		} else if (number == 1 && card.equals("3")) {
			card_2.setIcon(img3);
		} else if (number == 1 && card.equals("33")) {
			card_2.setIcon(img33);
		} else if (number == 1 && card.equals("4")) {
			card_2.setIcon(img4);
		} else if (number == 1 && card.equals("44")) {
			card_2.setIcon(img44);
		} else if (number == 1 && card.equals("5")) {
			card_2.setIcon(img5);
		} else if (number == 1 && card.equals("55")) {
			card_2.setIcon(img55);
		} else if (number == 1 && card.equals("6")) {
			card_2.setIcon(img6);
		} else if (number == 1 && card.equals("66")) {
			card_2.setIcon(img66);
		} else if (number == 1 && card.equals("7")) {
			card_2.setIcon(img7);
		} else if (number == 1 && card.equals("77")) {
			card_2.setIcon(img77);
		} else if (number == 1 && card.equals("8")) {
			card_2.setIcon(img8);
		} else if (number == 1 && card.equals("88")) {
			card_2.setIcon(img88);
		} else if (number == 1 && card.equals("9")) {
			card_2.setIcon(img9);
		} else if (number == 1 && card.equals("99")) {
			card_2.setIcon(img99);
		} else if (number == 1 && card.equals("10")) {
			card_2.setIcon(img10);
		} else if (number == 1 && card.equals("110")) {
			card_2.setIcon(img110);
		}
	}

}