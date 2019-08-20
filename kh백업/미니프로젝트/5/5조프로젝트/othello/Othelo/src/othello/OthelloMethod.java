package othello;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class OthelloMethod extends JFrame {
	public PlayerSetting player;
	public JLayeredPane base;
	public static final long serialVersionUID = 1L;

	public OthelloMethod() {
		// ** ��ü â�� ����
		JFrame window = new JFrame();
		window.setTitle("�����ΰ���");
		window.setSize(480, 360);

		// ** ���� ���̽� ����
		base = new JLayeredPane();

		// ** ���� ���̽��� â�� ����
		window.setContentPane(base);
		window.setVisible(true);

		// ** �÷���
		player = new PlayerSetting();
	}

	class PlayerSetting extends Panel implements MouseListener, MouseMotionListener {
		public static final long serialVersionUID = 1L;
		public ImageIcon play1_st, play1_shadow_st, play1win; // play1 �� �� �� ������, �ΰ�
		public ImageIcon play2_st, play2_shadow_st, play2win; // play2 �� �� �� ������, �ΰ�
		public int play_x, play_y, turn = 0; // ���� �뿩�� ��ǥ, �Ķ������� ����, �¸������� ���� �� ����
		public JLabel labelshadow = new JLabel(); // �������̹��� ��
		public Pan pan; // ������ ��
		public JLabel imageLabel = new JLabel(); // ���������̹��� ��
		

		public PlayerSetting() {
			// ** play1 �� �� �� ������, �ΰ� ���� ����
			play1_st = new ImageIcon("OthelloImage/play1.jpg");
			play1_shadow_st = new ImageIcon("OthelloImage/play1_shadow.gif");
			play1win = new ImageIcon("OthelloImage/play1win.gif");

			// ** play2 �� �� �� ������, �ΰ� ���� ����
			play2_st = new ImageIcon("OthelloImage/play2.jpg");
			play2_shadow_st = new ImageIcon("OthelloImage/play2_shadow.gif");
			play2win = new ImageIcon("OthelloImage/play2win.gif");

			pan = new Pan(); // �������� ����

			base.addMouseListener(this); // Ŭ�� ����� ���� ����
			base.addMouseMotionListener(this); // �������� ���� ����
		}

		public void xysetting() // ��ǥ�� �迭 ũ�⿡ �°� �ڸ��� �Լ�
		{
			if (play_x < 40) // ��ǥ�� �迭ũ��(40)�� �����ϰ� �ڸ���
				play_x = 0;
			else if (play_x > 320)
				play_x = 7;
			else
				play_x = (int) play_x / 40; // �Ҽ��� ���ֱ�

			if (play_y < 40)
				play_y = 0;
			else if (play_y > 320)
				play_y = 7;
			else
				play_y = (int) play_y / 40;
		}

		public void mouseMoved(MouseEvent me) // MouseMotionListener �޼ҵ�
		{
			play_x = me.getX(); // ���콺�� �ִ� ���� x��ǥ ������
			play_y = me.getY(); // ���콺�� �ִ� ���� x��ǥ ������

			xysetting();
			shadow_Find(play_x, play_y); // shadow_Find �Լ� ȣ��
		}

		public void mouseClicked(MouseEvent me) // MouseListener �޼ҵ�
		{
			play_x = me.getX();
			play_y = me.getY();

			xysetting();
			click_Find(play_x, play_y); // click_Find �Լ� ȣ��
		}

		// ** �ܿ� MouseMotionListener �޼ҵ�
		public void mouseDragged(MouseEvent me) {
		}

		// ** �ܿ� MouseListener �޼ҵ�
		public void mouseExited(MouseEvent me) {
		}

		public void mouseEntered(MouseEvent me) {
		}

		public void mousePressed(MouseEvent me) {
		}

		public void mouseReleased(MouseEvent me) {
		}

		public void shadow_Find(int x, int y) // �ش� ��ǥ�� �������̹����� �ü� �ִ��� �Ǻ��ϴ� �Լ�.
		{
			if (pan.indata(x, y) < 2) {
			} // �̹� ���� �ִ� ���
			else // ���� ���� ���
			{
				if ((turn == 0 && pan.indata(x - 1, y) == 1) || (turn == 1 && pan.indata(x - 1, y) == 0)) // �߰� ���� ����
				{
					for (int ix = x - 1; ix >= 0; ix--) // ���� �������� �� ����
					{
						if (pan.indata(ix, y) == 2)
							break; // ���� �߰� ���� ������ ����
						if ((pan.indata(x - 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x - 1, y) == 0 && pan.indata(ix, y) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), y, turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y - 1) == 1) || (turn == 1 && pan.indata(x - 1, y - 1) == 0)) // ��
																													// ����
																													// ����
				{
					for (int ix = x - 1, iy = y - 1; ix >= 0 || iy >= 0; ix--, iy--) // �� ���� �������� �� ����
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn); // shadow_Stone �Լ� ȣ��
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y - 1) == 1) || (turn == 1 && pan.indata(x, y - 1) == 0)) // �� ����� ����
				{
					for (int iy = y - 1; iy >= 0; iy--) // �� ����� �������� �� ����
					{
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y - 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y - 1) == 0 && pan.indata(x, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(x, iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y - 1) == 1) || (turn == 1 && pan.indata(x + 1, y - 1) == 0)) // ��
																													// ������
																													// ����
				{
					for (int ix = x + 1, iy = y - 1; ix <= 7 || iy >= 0; ix++, iy--) // �� ������ �������� �� ����
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y) == 1) || (turn == 1 && pan.indata(x + 1, y) == 0)) // �߰� ������ ����
				{
					for (int ix = x + 1; ix <= 7; ix++) // ������ �������� �� ����
					{
						if (pan.indata(ix, y) == 2)
							break;
						if ((pan.indata(x + 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x + 1, y) == 0 && pan.indata(ix, y) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), y, turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y + 1) == 1) || (turn == 1 && pan.indata(x + 1, y + 1) == 0)) // ��
																													// ������
																													// ����
				{
					for (int ix = x + 1, iy = y + 1; ix <= 7 || iy <= 7; ix++, iy++) // �� ������ �������� �� ����
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y + 1) == 1) || (turn == 1 && pan.indata(x, y + 1) == 0)) // �� ��� ����
				{
					for (int iy = y + 1; iy <= 7; iy++) // �� ��� �������� �� ����
					{
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y + 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y + 1) == 0 && pan.indata(x, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(x, iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y + 1) == 1) || (turn == 1 && pan.indata(x - 1, y + 1) == 0)) // ��
																													// ����
																													// ����
				{
					for (int ix = x - 1, iy = y + 1; ix >= 0 || iy <= 7; ix--, iy++) // �� ���� �������� �� ����
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}
			}
		}

		public void click_Find(int x, int y) // �ش� ��ǥ�� ���� �����ϴ� �Լ� �Լ�.
		{
			if (pan.indata(x, y) < 2) {
			} // �̹� ���� �ִ� ���
			else // ���� �дٸ�
			{
				if ((turn == 0 && pan.indata(x - 1, y) == 1) || (turn == 1 && pan.indata(x - 1, y) == 0)) // �߰� ���� ����
				{
					for (int ix = x - 1; ix >= 0; ix--) // ���� �������� �� ����
					{
						if (pan.indata(ix, y) == 2)
							break; // ���� �߰� ���� ������ ����
						if ((pan.indata(x - 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x - 1, y) == 0 && pan.indata(ix, y) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							for (int jx = ix; jx <= x; jx++) // �߻����� -> �ش� ��ǥ���� x���� �ݴ�Ӽ��� ���� �ش絹�� ����
							{
								pan.outdata(jx, y, turn); // �����ǿ� ���ο� ���� ������ �Է�
								draw_Stone(jx, y, turn); // ���ο� �� ǥ��
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y - 1) == 1) || (turn == 1 && pan.indata(x - 1, y - 1) == 0)) // ��
																													// ����
																													// ����
				{
					for (int ix = x - 1, iy = y - 1; ix >= 0 || iy >= 0; ix--, iy--) // �� ���� �������� �� ����
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // �ݴ�Ӽ��� ���� ������
						{
							for (int jx = ix, jy = iy; jx <= x; jx++, jy++) {
								pan.outdata(jx, jy, turn);
								draw_Stone(jx, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y - 1) == 1) || (turn == 1 && pan.indata(x, y - 1) == 0)) // �� ����� ����
				{
					for (int iy = y - 1; iy >= 0; iy--) // �� ����� �������� �� ����
					{
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y - 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y - 1) == 0 && pan.indata(x, iy) == 1)) {
							for (int jy = iy; jy <= y; jy++) {
								pan.outdata(x, jy, turn);
								draw_Stone(x, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y - 1) == 1) || (turn == 1 && pan.indata(x + 1, y - 1) == 0)) // ��
																													// ������
																													// ����
				{
					for (int ix = x + 1, iy = y - 1; ix <= 7 || iy >= 0; ix++, iy--) {
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) {
							for (int jx = ix, jy = iy; jx >= x; jx--, jy++) {
								pan.outdata(jx, jy, turn);
								draw_Stone(jx, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y) == 1) || (turn == 1 && pan.indata(x + 1, y) == 0)) // �߰� ������ ����
				{
					for (int ix = x + 1; ix <= 7; ix++) {
						if (pan.indata(ix, y) == 2)
							break;
						if ((pan.indata(x + 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x + 1, y) == 0 && pan.indata(ix, y) == 1)) {
							for (int jx = ix; jx >= x; jx--) {
								pan.outdata(jx, y, turn);
								draw_Stone(jx, y, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y + 1) == 1) || (turn == 1 && pan.indata(x + 1, y + 1) == 0)) // ��
																													// ������
																													// ����
				{
					for (int ix = x + 1, iy = y + 1; ix <= 7 || iy <= 7; ix++, iy++) {
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) {
							for (int jx = ix, jy = iy; jx >= x; jx--, jy--) {
								pan.outdata(jx, jy, turn);
								draw_Stone(jx, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y + 1) == 1) || (turn == 1 && pan.indata(x, y + 1) == 0)) // �� ��� ����
				{
					for (int iy = y + 1; iy <= 7; iy++) {
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y + 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y + 1) == 0 && pan.indata(x, iy) == 1)) {
							for (int jy = iy; jy >= y; jy--) {
								pan.outdata(x, jy, turn);
								draw_Stone(x, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y + 1) == 1) || (turn == 1 && pan.indata(x - 1, y + 1) == 0)) // ��
																													// ����
																													// ����
				{
					for (int ix = x - 1, iy = y + 1; ix >= 0 || iy <= 7; ix--, iy++) {
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) {
							for (int jx = ix, jy = iy; jx <= x; jx++, jy--) {
								pan.outdata(jx, jy, turn);
								draw_Stone(jx, jy, turn);
							}
							break;
						}
					}
				}
				if (turn == 0)
					turn = 1;
				else if (turn == 1)
					turn = 0;
			}

			Victory(); // Victory �Լ� ����
		}

		public void shadow_Stone(int x, int y, int turn) // �ش� ��ǥ�� �������̹����� ���� �ϴ� �Լ�.
		{
			if (turn == 0) // player1(�浹)�̸�,
			{
				labelshadow.setIcon(play1_shadow_st); // �Ķ��������̹��� ���
				labelshadow.setBounds(x * 40, y * 40, 40, 40);
				base.add(labelshadow, 0);

			} else if (turn == 1) { // player2(�鵹)�϶�
				labelshadow.setIcon(play2_shadow_st);
				labelshadow.setBounds(x * 40, y * 40, 40, 40);
				base.add(labelshadow, 0);

			}
		}

		public void draw_Stone(int x, int y, int turn) // �ش� ��ǥ�� ���� ���� �ϴ� �Լ�.
		{
			if (turn == 0) // player1(�浹)�̸�,
			{
				JLabel label = new JLabel();
				label.setIcon(play1_st); // �浹 ����
				label.setBounds(x * 40, y * 40, 40, 40);
				base.add(label, 0);
			} else {
				JLabel label = new JLabel();
				label.setIcon(play2_st);
				label.setBounds(x * 40, y * 40, 40, 40);
				base.add(label, 0);
			}
		}

		public void Victory() // �¸� ���� �Լ�
		{
			int play1_count = 0, play2_count = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (pan.othello_pan[i][j] == 0)
						play1_count++; // player1(�浹)�� ���� ����
					if (pan.othello_pan[i][j] == 1)
						play2_count++; // player2(�鵹)�� ���� ����
				}
			}

			if (play1_count + play2_count == 64) {
				if (play1_count > play2_count) // player1 �� ������
				{
					JLabel label = new JLabel();
					label.setIcon(play1win); // player1 �¸�
					label.setBounds(320, 0, 160, 180);
					base.add(label, 0);
				} else if (play1_count < play2_count) {
					JLabel label = new JLabel();
					label.setIcon(play2win);
					label.setBounds(320, 0, 160, 180);
					base.add(label, 0);
				}
			}
		}

		class Pan // ��������
		{
			ImageIcon backImageIcon; // ��� �̹��� ������
			public int[][] othello_pan; // �������� �迭 ����

			public Pan() {
				othello_pan = new int[8][8]; // �迭�� 8*8���� �������� ����
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++)
						othello_pan[i][j] = 2; // 0=play1, 1=play, 2=���ڸ� -> �ʱ�ȭ�� ���� ���ڸ� ����
				}

				othello_pan[3][3] = 1; // ���ӽ��۽� ó�� �����ִ� �� 4�� ����
				draw_Stone(3, 3, 1);
				othello_pan[4][4] = 1;
				draw_Stone(4, 4, 1);
				othello_pan[3][4] = 0;
				draw_Stone(4, 3, 0);
				othello_pan[4][3] = 0;
				draw_Stone(3, 4, 0);

				backImageIcon = new ImageIcon("OthelloImage/pan.jpg"); // �������� ����̹���
				imageLabel.setIcon(backImageIcon);
				imageLabel.setBounds(0, 0, 320, 320);
				base.add(imageLabel);
			}

			public int indata(int x, int y) // �ش� ��ǥ�� ��Ī�Ǵ� �迭���� ������ �Լ�.
			{
				if (x < 0 || x > 7)
					return -1;
				if (y < 0 || y > 7)
					return -1;

				return othello_pan[y][x];
			}

			public void outdata(int x, int y, int data) // �ش� ��ǥ�� �迭�� ����.
			{
				if (x < 0 || x > 7)
					return;
				if (y < 0 || y > 7)
					return;

				othello_pan[y][x] = data;
			}
		}
	}

	public static void main(String[] args) // main
	{
		new OthelloMethod(); // othello ����
	}
}