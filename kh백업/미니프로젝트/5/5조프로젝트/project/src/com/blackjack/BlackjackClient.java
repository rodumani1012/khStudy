package com.blackjack;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.my.client.client;

public class BlackjackClient {
	private Image blackjackchip1;// Ĩ�̹���
	private client client;

	private int betCount = 0;// Ĩ �ʱ�ȭ
	private String bettingMoney = "";// �����Ҷ����� ��
	int betres = 0;// ���þ�
	private boolean gameEnd;// ����ī�� ���������� �Ҹ���

	// ī���̹����� �ʿ� ����
	private Map<String, Image> cardimg = new HashMap<String, Image>();

	// ī�忬������ϱ����� HAND�� LIST��
	List<String> listhandMy = new ArrayList<String>();
	List<String> listhandDealer = new ArrayList<String>();
	List<String> listhandUser1 = new ArrayList<String>();
	List<String> listhandUser2 = new ArrayList<String>();
	List<String> listhandUser3 = new ArrayList<String>();
	List<String> listhandUser4 = new ArrayList<String>();

	// gui����
	JFrame frame;
	DrawFrame drawPanel;
	JButton ready;
	JButton hit;
	JButton stay;
	JButton bet;
	JButton back;
	TextArea chatout;
	JTextField chatin;
	JTextField status;

	JTextField user1name;
	JTextField user2name;
	JTextField user3name;
	JTextField user4name;

	JTextField user1nameDO;
	JTextField user2nameDO;
	JTextField user3nameDO;
	JTextField user4nameDO;

	//
	public void init() {
		gameEnd = false;
		// FRAME�� DRAWPANEL
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����

		drawPanel = new DrawFrame();
		drawPanel.setBounds(0, 0, 1500, 1500);
		drawPanel.setLayout(null);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(drawPanel);
		frame.setSize(1500, 1500);
		frame.setVisible(true);
		frame.setTitle("BlackJack��");

		// ready��ư
		ready = new JButton("READY");
		ready.setBounds(500, 700, 100, 35);
		drawPanel.add(ready);
		// hit��ư
		hit = new JButton("HIT");
		hit.setBounds(622, 700, 60, 35);
		drawPanel.add(hit);
		// stay��ư
		stay = new JButton("STAY");
		stay.setBounds(800, 700, 75, 35);
		drawPanel.add(stay);
		// bet��ư
		bet = new JButton("BET");
		bet.setBounds(700, 700, 75, 35);
		drawPanel.add(bet);
		// back��ư
		back = new JButton("BACK");
		back.setBounds(50, 20, 100, 30);
		drawPanel.add(back);
		// �ʱ� ��ư����
		hit.setEnabled(false);
		stay.setEnabled(false);
		bet.setEnabled(true);
		ready.setEnabled(false);
		back.setEnabled(true);
		// ä��â
		chatout = new TextArea();
		chatout.setEditable(false);
		chatout.setBounds(1200, 600, 400, 300);
		drawPanel.add(chatout);
		// ä���Է�â
		chatin = new JTextField();
		chatin.setBounds(1200, 900, 400, 100);
		drawPanel.add(chatin);
		// ����â
		status = new JTextField();
		status.setEditable(false);
		status.setBounds(50, 700, 300, 50);
		drawPanel.add(status);
		// �����̸� ���� �ʵ�
		user1name = new JTextField();
		user1name.setEditable(false);
		user1name.setBounds(150, 100, 100, 30);
		drawPanel.add(user1name);

		user2name = new JTextField();
		user2name.setEditable(false);
		user2name.setBounds(150, 550, 100, 30);
		drawPanel.add(user2name);

		user3name = new JTextField();
		user3name.setEditable(false);
		user3name.setBounds(900, 100, 100, 30);
		drawPanel.add(user3name);

		user4name = new JTextField();
		user4name.setEditable(false);
		user4name.setBounds(900, 550, 100, 30);
		drawPanel.add(user4name);

		// ������ stay hit �������¸� ������ִ��ʵ�
		user1nameDO = new JTextField();
		user1nameDO.setEditable(false);
		user1nameDO.setBounds(300, 100, 100, 30);
		drawPanel.add(user1nameDO);

		user2nameDO = new JTextField();
		user2nameDO.setEditable(false);
		user2nameDO.setBounds(300, 550, 100, 30);
		drawPanel.add(user2nameDO);

		user3nameDO = new JTextField();
		user3nameDO.setEditable(false);
		user3nameDO.setBounds(1050, 100, 100, 30);
		drawPanel.add(user3nameDO);

		user4nameDO = new JTextField();
		user4nameDO.setEditable(false);
		user4nameDO.setBounds(1050, 550, 100, 30);
		drawPanel.add(user4nameDO);

		// event
		Events event = new Events();
		hit.addActionListener(event);
		stay.addActionListener(event);
		bet.addActionListener(event);
		ready.addActionListener(event);
		back.addActionListener(event);
		// ä�� event
		chatin.addActionListener(new InputListener());

		// map�� ī���̹�������
		String[] mark = { "D", "S", "H", "C" };
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 13; j++) {
				cardimg.put(mark[i] + num[j], new ImageIcon("src/cardimages/" + mark[i] + num[j] + ".png").getImage());

			}
		}

	}

	public BlackjackClient(client client) {

		init();
		this.client = client;
	}

	// selectGame���� �Ѱܹ��� �޼��� ��, �������� ���� �޽����� split���� ������
	public void showhand(String msg) {

		String[] msgArr = msg.split(" ");
		String hand = "";
		for (int i = 1; i < msgArr.length; i++) {
			hand += (msgArr[i] + " ");
		}
		// �¸�/�й�/���/ù������� �̹������
		if (msg.equals("BJmy: LOSE( 0.0�� )")) {
			Image loseimage = new ImageIcon("src/cardimages/blackjacklose.png").getImage();
			drawPanel.setWinLose(loseimage);
			frame.repaint();
		} else if (msg.equals("BJmy: WIN( 2.0�� )")) {
			Image winimage = new ImageIcon("src/cardimages/blackjackwin.png").getImage();
			drawPanel.setWinLose(winimage);
			frame.repaint();
		} else if (msg.equals("BJmy: DRAW( 1.0�� )")) {
			Image drawimage = new ImageIcon("src/cardimages/blackjackdraw.png").getImage();
			drawPanel.setWinLose(drawimage);
			frame.repaint();
		} else if (msg.equals("BJmy: BLACKJACK( 1.5�� )")) {
			Image drawimage = new ImageIcon("src/cardimages/blackjack21.png").getImage();
			drawPanel.setWinLose(drawimage);
			frame.repaint();
		}

		switch (msgArr[0]) {
		case "BJmy:":
			// ���� ��
			if (!hand.equals("")) {
				listhandMy.add(hand);// hand�� list�� ����
				drawPanel.setListhandMy(listhandMy);// hand�� ���� lsithandmy ��drawpanel��
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();// paintcomponent�� ȣ���ϱ�����
			}
			break;
		case "BJdealer:":
			// ���� ��
			if (!hand.equals("")) {
				listhandDealer.add(hand);
				drawPanel.setListhandDealer(listhandDealer);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJRESET":
			// BJRESET �̶� �޼����� �����ϸ� betres�� 0���� �ʱ�ȭ, �� ��ư�� ��Ȱ��ȭ Ȥ�� Ȱ��ȭ
			betres = 0;
			this.gameEnd = true;
			hit.setEnabled(false);
			stay.setEnabled(false);
			bet.setEnabled(true);
			ready.setEnabled(false);
			drawPanel.setgameEnd(true);
			frame.repaint();
			break;
		case "BJSTATUS":
			// BJSTATUS �� �޼����� �����ϸ� status â ���� ��Ŵ
			status.setText("�̸�: " + msgArr[1] + "\n�����ݾ�: " + msgArr[2]);
			break;
		case "BJTURNEND":
			// ���� ������ hit�� stay ��ư�� Ȱ��ȭ
			hit.setEnabled(true);
			stay.setEnabled(true);
			break;

		// �� ������ �и� ���
		case "BJUSER1":
			if (!hand.equals("")) {
				listhandUser1.add(hand);
				drawPanel.setListhandUser1(listhandUser1);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER2":
			if (!hand.equals("")) {
				listhandUser2.add(hand);
				drawPanel.setListhandUser2(listhandUser2);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER3":
			if (!hand.equals("")) {
				listhandUser3.add(hand);
				drawPanel.setListhandUser3(listhandUser3);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		case "BJUSER4":
			if (!hand.equals("")) {
				listhandUser4.add(hand);
				drawPanel.setListhandUser4(listhandUser4);
				drawPanel.setHand(hand);
				drawPanel.setCardImg(cardimg);
				frame.repaint();
			}
			break;
		// �� ������ �̸��� ���
		case "BJUSERNAME1":
			user1name.setText(hand);
			break;
		case "BJUSERNAME2":
			user2name.setText(hand);
			break;
		case "BJUSERNAME3":
			user3name.setText(hand);
			break;
		case "BJUSERNAME4":
			user4name.setText(hand);
			break;
		// �� ������ state�� ���
		case "BJUSERSTATE1":
			user1nameDO.setText(hand);
			break;
		case "BJUSERSTATE2":
			user2nameDO.setText(hand);
			break;
		case "BJUSERSTATE3":
			user3nameDO.setText(hand);
			break;
		case "BJUSERSTATE4":
			user4nameDO.setText(hand);
			break;
		// ä��
		case "BJchat":
			chatout.append(hand + "\n");
			break;
		}
	}

	public void go() {

		// BlackjackClient â�� ���� status â�� ���
		client.out.println("BJIN");

		client.out.println("BJSTART");
	}

	// hit ��ư �������� HIT ���� , stay ��ư �������� STAY ����
	class Events implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();

			if (b.getLabel().trim().equals("HIT")) {
				// HIT�� ������ ��, BJHIT �޼��� ���������� ����, turn�� ������ ������ hit�� stay ��ư�� ��Ȱ��ȭ ��Ų��.
				hit.setEnabled(false);
				stay.setEnabled(false);
				client.out.println("BJHIT");
				frame.repaint();
			} else if (b.getLabel().trim().equals("STAY")) {
				// STAY ��ư�� ������ �� ���� ������ BJSTAY �޽��� out ���ְ� �ٸ� ��ư ��� ��Ȱ��ȭ��Ŵ
				hit.setEnabled(false);
				stay.setEnabled(false);
				bet.setEnabled(false);
				ready.setEnabled(false);
				client.out.println("BJSTAY");
				frame.repaint();
				betCount = 0;// ����Ĩ �ʱ�ȭ�ϱ�����

			} else if (b.getLabel().trim().equals("READY")) {
				// READY�� ������ ��, area ���θ� ���� ���ְ� ��ư Ȱ��ȭ �� ��Ȱ��ȭ �����ش�. �׸��� bet �ݾ� ������ �Ѱ��ش�.

				hit.setEnabled(true);
				stay.setEnabled(true);
				bet.setEnabled(false);
				ready.setEnabled(false);
				client.out.println("BJBET " + betres);
				client.out.println("BJREADY");
				drawPanel.reset();
				drawPanel.setgameEnd(false);
				drawPanel.setWinLose(null);// �¸�,�й�,���,ù21,�̹��� �ʱ�ȭ
				frame.repaint();
			} else if (b.getLabel().trim().equals("BET")) {
				// BET ������ ��, BET �� betres�� setText ���ش�
				ready.setEnabled(true);
				betres += 50000;
				betCount++;
				bettingMoney = "betting money: " + Integer.toString(betres);// ���þ��� string�ι޾����
				drawPanel.setBettingMoney(bettingMoney);
				drawPanel.setBetCount(betCount);
				blackjackchip1 = new ImageIcon("src/cardimages/blackjackchip2.png").getImage();
				drawPanel.setChipImg(blackjackchip1);
				drawPanel.setWinLose(null);
				frame.repaint();

				// BACK ��������
			} else if (b.getLabel().trim().equals("BACK")) {
				frame.setVisible(false);
				client.out.println("BJBACK");
			}

		}

	}

	// ä���� ���� �̺�Ʈ Ŭ����
	class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String input = chatin.getText();
			chatin.setText("");
			try {
				client.out.println("BJchat " + input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}

class DrawFrame extends JPanel {
	String displaydealername = "DEALER";// �������� �̸�
	String chattingname = "CHATTING";// ä��â���� �̸�
	String myMoney = "MyMoney";// ����â ���� �̸�
	Image winLose;// ��,��,���,21(blackjack�̹���)
	String hand = "";// �ī�尡�������� �а� ����ex)D7=���̾�7
	String bettingMoney = "";// ���ñݾ� DRAWSTRING���
	Image blackjackchip1;// ����Ĩ�̹���
	int betCount;
	boolean gameEnd;

	List<String> listhandMy = new ArrayList<String>();// ��ӵ����� hand�� �������
	List<String> listhandDealer = new ArrayList<String>(); //
	List<String> listhandUser1 = new ArrayList<String>();
	List<String> listhandUser2 = new ArrayList<String>(); // ���� �� �̾ƿ�������
	List<String> listhandUser3 = new ArrayList<String>();
	List<String> listhandUser4 = new ArrayList<String>(); //

	Map<String, Image> cardimg = new HashMap<String, Image>();// ī���̹������� ���� map

	private static final long serialVersionUID = 1L;

	public void setWinLose(Image winLose) {
		this.winLose = winLose;
	}

	public void setBettingMoney(String bettingMoney) {
		this.bettingMoney = bettingMoney;
	}

	public void setgameEnd(boolean gameEnd) {
		this.gameEnd = gameEnd;
	}

	public void setChipImg(Image blackjackchip1) {
		this.blackjackchip1 = blackjackchip1;
	}

	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	// �Ž����Ҷ����� ī�� �ٽ� �ֱ����� ȭ�鿡���̴� ī�� �ʱ�ȭ
	public void reset() {
		this.listhandMy.removeAll(listhandMy);
		this.listhandDealer.removeAll(listhandDealer);
		this.listhandUser1.removeAll(listhandUser1);
		this.listhandUser2.removeAll(listhandUser2);
		this.listhandUser3.removeAll(listhandUser3);
		this.listhandUser4.removeAll(listhandUser4);

	}

	public void setCardImg(Map<String, Image> cardimg) {// �̹��� �ޱ�����
		this.cardimg = cardimg;
	}

	public void setListhandMy(List<String> listhandMy) {
		this.listhandMy = listhandMy;
	}

	public void setListhandDealer(List<String> listhandDealer) {
		this.listhandDealer = listhandDealer;
	}

	public void setListhandUser1(List<String> listhandUser1) {
		this.listhandUser1 = listhandUser1;
	}

	public void setListhandUser2(List<String> listhandUser2) {
		this.listhandUser2 = listhandUser2;
	}

	public void setListhandUser3(List<String> listhandUser3) {
		this.listhandUser3 = listhandUser3;
	}

	public void setListhandUser4(List<String> listhandUser4) {
		this.listhandUser4 = listhandUser4;
	}

	// �ڵ�ȣ���Լ� ���������� ��� image�׷���
	@Override
	public void paintComponent(Graphics g) {

		Dimension d = getSize();// ȭ����ü ����� �޾ƿ������� d
		// ���ȭ��
		Image blackjacktable = new ImageIcon("src/cardimages/blackjack_table.png").getImage();
		g.drawImage(blackjacktable, 0, 0, d.width, d.height, this);

		// �׷���string font,color
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(new Color(1.0f, 0.0f, 0.0f));
		g.drawString(displaydealername, 650, 70);
		g.drawString(chattingname, 1200, 585);
		g.drawString(myMoney, 50, 685);

		// ����Ĩ ����
		for (int i = 0; i < betCount; i++) {
			g.drawImage(blackjackchip1, 650, 500 - i * 20, this);
			g.drawString(bettingMoney, 600, 650);
			bettingMoney = "";
		}
		// ���к����� �̹���
		g.drawImage(winLose, 500, 350, this);

		// ���� ī�� ����
		for (int i = 0; i < listhandMy.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandMy.get(i).trim());
			g.drawImage(imagewhat, (650 + i * 20), 800, this);

		}
		// ���� ī��
		for (int i = 0; i < listhandDealer.size(); i++) {
			Image imagewhat;
			// ó���� ù���� ī�带 ������ reset������ ó��ī�带 �ٽ� �����ش�
			if (!gameEnd) {
				if (i == 0) {
					imagewhat = new ImageIcon("src/cardimages/b1fv.png").getImage();
				} else {
					imagewhat = cardimg.get(listhandDealer.get(i).trim());
				}
			}

			else {
				imagewhat = cardimg.get(listhandDealer.get(i).trim());
			}
			g.drawImage(imagewhat, (650 + i * 20), 80, this);

		}
		// user1 card
		for (int i = 0; i < listhandUser1.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser1.get(i).trim());
			g.drawImage(imagewhat, (150 + i * 20), 200, this);

		}
		// user2 card
		for (int i = 0; i < listhandUser2.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser2.get(i).trim());
			g.drawImage(imagewhat, (150 + i * 20), 400, this);

		}
		// user3 card
		for (int i = 0; i < listhandUser3.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser3.get(i).trim());
			g.drawImage(imagewhat, (1050 + i * 20), 200, this);

		}
		// user4 card
		for (int i = 0; i < listhandUser4.size(); i++) {
			Image imagewhat;
			imagewhat = cardimg.get(listhandUser4.get(i).trim());
			g.drawImage(imagewhat, (1050 + i * 20), 400, this);

		}

	}
}
