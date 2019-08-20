package othello;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class OthelloMethod extends JFrame {
	public PlayerSetting player;
	public JLayeredPane base;
	public static final long serialVersionUID = 1L;

	public OthelloMethod() {
		// ** 전체 창을 생성
		JFrame window = new JFrame();
		window.setTitle("오델로게임");
		window.setSize(480, 360);

		// ** 게임 베이스 생성
		base = new JLayeredPane();

		// ** 게임 베이스를 창에 띄운다
		window.setContentPane(base);
		window.setVisible(true);

		// ** 플레이
		player = new PlayerSetting();
	}

	class PlayerSetting extends Panel implements MouseListener, MouseMotionListener {
		public static final long serialVersionUID = 1L;
		public ImageIcon play1_st, play1_shadow_st, play1win; // play1 의 말 과 쉐도우, 로고
		public ImageIcon play2_st, play2_shadow_st, play2win; // play2 의 말 과 쉐도우, 로고
		public int play_x, play_y, turn = 0; // 돌이 노여질 좌표, 파란돌부터 시작, 승리선언을 위한 돌 개수
		public JLabel labelshadow = new JLabel(); // 쉐도우이미지 라벨
		public Pan pan; // 오델로 판
		public JLabel imageLabel = new JLabel(); // 오델로판이미지 라벨
		

		public PlayerSetting() {
			// ** play1 의 말 과 쉐도우, 로고 파일 설정
			play1_st = new ImageIcon("OthelloImage/play1.jpg");
			play1_shadow_st = new ImageIcon("OthelloImage/play1_shadow.gif");
			play1win = new ImageIcon("OthelloImage/play1win.gif");

			// ** play2 의 말 과 쉐도우, 로고 파일 설정
			play2_st = new ImageIcon("OthelloImage/play2.jpg");
			play2_shadow_st = new ImageIcon("OthelloImage/play2_shadow.gif");
			play2win = new ImageIcon("OthelloImage/play2win.gif");

			pan = new Pan(); // 오델로판 생성

			base.addMouseListener(this); // 클릭 모션을 위한 설정
			base.addMouseMotionListener(this); // 무브모션을 위한 설정
		}

		public void xysetting() // 좌표를 배열 크기에 맞게 자르는 함수
		{
			if (play_x < 40) // 좌표를 배열크기(40)와 동일하게 자르기
				play_x = 0;
			else if (play_x > 320)
				play_x = 7;
			else
				play_x = (int) play_x / 40; // 소숫점 없애기

			if (play_y < 40)
				play_y = 0;
			else if (play_y > 320)
				play_y = 7;
			else
				play_y = (int) play_y / 40;
		}

		public void mouseMoved(MouseEvent me) // MouseMotionListener 메소드
		{
			play_x = me.getX(); // 마우스가 있는 곳의 x좌표 얻어오기
			play_y = me.getY(); // 마우스가 있는 곳의 x좌표 얻어오기

			xysetting();
			shadow_Find(play_x, play_y); // shadow_Find 함수 호출
		}

		public void mouseClicked(MouseEvent me) // MouseListener 메소드
		{
			play_x = me.getX();
			play_y = me.getY();

			xysetting();
			click_Find(play_x, play_y); // click_Find 함수 호출
		}

		// ** 잔여 MouseMotionListener 메소드
		public void mouseDragged(MouseEvent me) {
		}

		// ** 잔여 MouseListener 메소드
		public void mouseExited(MouseEvent me) {
		}

		public void mouseEntered(MouseEvent me) {
		}

		public void mousePressed(MouseEvent me) {
		}

		public void mouseReleased(MouseEvent me) {
		}

		public void shadow_Find(int x, int y) // 해당 좌표에 쉐도우이미지가 올수 있는지 판별하는 함수.
		{
			if (pan.indata(x, y) < 2) {
			} // 이미 돌이 있는 경우
			else // 돌이 없는 경우
			{
				if ((turn == 0 && pan.indata(x - 1, y) == 1) || (turn == 1 && pan.indata(x - 1, y) == 0)) // 중간 왼쪽 방향
				{
					for (int ix = x - 1; ix >= 0; ix--) // 왼쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, y) == 2)
							break; // 돌이 발견 되지 않으면 스톱
						if ((pan.indata(x - 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x - 1, y) == 0 && pan.indata(ix, y) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), y, turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y - 1) == 1) || (turn == 1 && pan.indata(x - 1, y - 1) == 0)) // 상
																													// 왼쪽
																													// 방향
				{
					for (int ix = x - 1, iy = y - 1; ix >= 0 || iy >= 0; ix--, iy--) // 상 왼쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn); // shadow_Stone 함수 호출
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y - 1) == 1) || (turn == 1 && pan.indata(x, y - 1) == 0)) // 상 가운대 방향
				{
					for (int iy = y - 1; iy >= 0; iy--) // 상 가운대 방향으로 돌 조사
					{
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y - 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y - 1) == 0 && pan.indata(x, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(x, iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y - 1) == 1) || (turn == 1 && pan.indata(x + 1, y - 1) == 0)) // 상
																													// 오른쪽
																													// 방향
				{
					for (int ix = x + 1, iy = y - 1; ix <= 7 || iy >= 0; ix++, iy--) // 상 오른쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y) == 1) || (turn == 1 && pan.indata(x + 1, y) == 0)) // 중간 오른쪽 방향
				{
					for (int ix = x + 1; ix <= 7; ix++) // 오른쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, y) == 2)
							break;
						if ((pan.indata(x + 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x + 1, y) == 0 && pan.indata(ix, y) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), y, turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x + 1, y + 1) == 1) || (turn == 1 && pan.indata(x + 1, y + 1) == 0)) // 하
																													// 오른쪽
																													// 방향
				{
					for (int ix = x + 1, iy = y + 1; ix <= 7 || iy <= 7; ix++, iy++) // 하 오른쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x + 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x + 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y + 1) == 1) || (turn == 1 && pan.indata(x, y + 1) == 0)) // 하 가운데 방향
				{
					for (int iy = y + 1; iy <= 7; iy++) // 하 가운데 방향으로 돌 조사
					{
						if (pan.indata(x, iy) == 2)
							break;
						if ((pan.indata(x, y + 1) == 1 && pan.indata(x, iy) == 0)
								|| (pan.indata(x, y + 1) == 0 && pan.indata(x, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(x, iy + (y - iy), turn);
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y + 1) == 1) || (turn == 1 && pan.indata(x - 1, y + 1) == 0)) // 하
																													// 왼쪽
																													// 방향
				{
					for (int ix = x - 1, iy = y + 1; ix >= 0 || iy <= 7; ix--, iy++) // 하 왼쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y + 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y + 1) == 0 && pan.indata(ix, iy) == 1)) // 반대속성의 돌이 나오면
						{
							shadow_Stone(ix + (x - ix), iy + (y - iy), turn);
						}
					}
				}
			}
		}

		public void click_Find(int x, int y) // 해당 좌표에 돌을 생성하는 함수 함수.
		{
			if (pan.indata(x, y) < 2) {
			} // 이미 돌이 있는 경우
			else // 돌을 둔다면
			{
				if ((turn == 0 && pan.indata(x - 1, y) == 1) || (turn == 1 && pan.indata(x - 1, y) == 0)) // 중간 왼쪽 방향
				{
					for (int ix = x - 1; ix >= 0; ix--) // 왼쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, y) == 2)
							break; // 돌이 발견 되지 않으면 스톱
						if ((pan.indata(x - 1, y) == 1 && pan.indata(ix, y) == 0)
								|| (pan.indata(x - 1, y) == 0 && pan.indata(ix, y) == 1)) // 반대속성의 돌이 나오면
						{
							for (int jx = ix; jx <= x; jx++) // 발생지점 -> 해당 좌표까지 x축의 반대속성의 돌을 해당돌로 변경
							{
								pan.outdata(jx, y, turn); // 게임판에 새로운 돌의 데이터 입력
								draw_Stone(jx, y, turn); // 새로운 돌 표시
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x - 1, y - 1) == 1) || (turn == 1 && pan.indata(x - 1, y - 1) == 0)) // 상
																													// 왼쪽
																													// 방향
				{
					for (int ix = x - 1, iy = y - 1; ix >= 0 || iy >= 0; ix--, iy--) // 상 왼쪽 방향으로 돌 조사
					{
						if (pan.indata(ix, iy) == 2)
							break;
						if ((pan.indata(x - 1, y - 1) == 1 && pan.indata(ix, iy) == 0)
								|| (pan.indata(x - 1, y - 1) == 0 && pan.indata(ix, iy) == 1)) // 반대속성의 돌이 나오면
						{
							for (int jx = ix, jy = iy; jx <= x; jx++, jy++) {
								pan.outdata(jx, jy, turn);
								draw_Stone(jx, jy, turn);
							}
							break;
						}
					}
				}

				if ((turn == 0 && pan.indata(x, y - 1) == 1) || (turn == 1 && pan.indata(x, y - 1) == 0)) // 상 가운대 방향
				{
					for (int iy = y - 1; iy >= 0; iy--) // 상 가운대 방향으로 돌 조사
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

				if ((turn == 0 && pan.indata(x + 1, y - 1) == 1) || (turn == 1 && pan.indata(x + 1, y - 1) == 0)) // 상
																													// 오른쪽
																													// 방향
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

				if ((turn == 0 && pan.indata(x + 1, y) == 1) || (turn == 1 && pan.indata(x + 1, y) == 0)) // 중간 오른쪽 방향
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

				if ((turn == 0 && pan.indata(x + 1, y + 1) == 1) || (turn == 1 && pan.indata(x + 1, y + 1) == 0)) // 하
																													// 오른쪽
																													// 방향
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

				if ((turn == 0 && pan.indata(x, y + 1) == 1) || (turn == 1 && pan.indata(x, y + 1) == 0)) // 하 가운데 방향
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

				if ((turn == 0 && pan.indata(x - 1, y + 1) == 1) || (turn == 1 && pan.indata(x - 1, y + 1) == 0)) // 하
																													// 왼쪽
																													// 방향
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

			Victory(); // Victory 함수 선언
		}

		public void shadow_Stone(int x, int y, int turn) // 해당 좌표에 쉐도우이미지를 생성 하는 함수.
		{
			if (turn == 0) // player1(흑돌)이면,
			{
				labelshadow.setIcon(play1_shadow_st); // 파란쉐도우이미지 출력
				labelshadow.setBounds(x * 40, y * 40, 40, 40);
				base.add(labelshadow, 0);

			} else if (turn == 1) { // player2(백돌)일때
				labelshadow.setIcon(play2_shadow_st);
				labelshadow.setBounds(x * 40, y * 40, 40, 40);
				base.add(labelshadow, 0);

			}
		}

		public void draw_Stone(int x, int y, int turn) // 해당 좌표에 돌을 생성 하는 함수.
		{
			if (turn == 0) // player1(흑돌)이면,
			{
				JLabel label = new JLabel();
				label.setIcon(play1_st); // 흑돌 생성
				label.setBounds(x * 40, y * 40, 40, 40);
				base.add(label, 0);
			} else {
				JLabel label = new JLabel();
				label.setIcon(play2_st);
				label.setBounds(x * 40, y * 40, 40, 40);
				base.add(label, 0);
			}
		}

		public void Victory() // 승리 선언 함수
		{
			int play1_count = 0, play2_count = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (pan.othello_pan[i][j] == 0)
						play1_count++; // player1(흑돌)의 개수 세기
					if (pan.othello_pan[i][j] == 1)
						play2_count++; // player2(백돌)의 개수 세기
				}
			}

			if (play1_count + play2_count == 64) {
				if (play1_count > play2_count) // player1 이 많으면
				{
					JLabel label = new JLabel();
					label.setIcon(play1win); // player1 승리
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

		class Pan // 오델로판
		{
			ImageIcon backImageIcon; // 배경 이미지 아이콘
			public int[][] othello_pan; // 오델로판 배열 선언

			public Pan() {
				othello_pan = new int[8][8]; // 배열을 8*8으로 오델로판 생성
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++)
						othello_pan[i][j] = 2; // 0=play1, 1=play, 2=빈자리 -> 초기화를 위한 빈자리 선언
				}

				othello_pan[3][3] = 1; // 게임시작시 처음 갖고있는 돌 4개 생성
				draw_Stone(3, 3, 1);
				othello_pan[4][4] = 1;
				draw_Stone(4, 4, 1);
				othello_pan[3][4] = 0;
				draw_Stone(4, 3, 0);
				othello_pan[4][3] = 0;
				draw_Stone(3, 4, 0);

				backImageIcon = new ImageIcon("OthelloImage/pan.jpg"); // 오델로판 배경이미지
				imageLabel.setIcon(backImageIcon);
				imageLabel.setBounds(0, 0, 320, 320);
				base.add(imageLabel);
			}

			public int indata(int x, int y) // 해당 좌표에 매칭되는 배열값을 얻어오는 함수.
			{
				if (x < 0 || x > 7)
					return -1;
				if (y < 0 || y > 7)
					return -1;

				return othello_pan[y][x];
			}

			public void outdata(int x, int y, int data) // 해당 좌표에 배열값 대입.
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
		new OthelloMethod(); // othello 생성
	}
}