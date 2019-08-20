package com.blackjack;

import java.util.ArrayList;

import java.util.List;

import com.my.dao.ProjectDao;
import com.my.dto.ProjectDto;
import com.project.ServiceThread;

public class BlackjackMethod {

	ProjectDao projectdao = new ProjectDao();
	BlackjackDao blackjackdao = null;

	// ������ �а� ����Ǹ� List
	List<String> dealerhand = new ArrayList<String>();
	// �� BlackjackClients�� serviceThread�� �����Ǿ� ���� ����
	List<ServiceThread> BlackjackClients = new ArrayList<>();

	// ------------------------------------- ���� �޼ҵ�
	public void addBlackjackClients(ServiceThread st) {
		this.BlackjackClients.add(st);
	}
	
	public int sizeUsers() {
		return BlackjackClients.size();
	}

	// ���� ���� ����, ���� ���� �� ������ boolean���� ������
	public boolean removeClient(ServiceThread st) {
		return this.BlackjackClients.remove(st);
	}

	// ä�� �޼ҵ�
	public void sendMessageAll(String msg) {
		try {
			System.out.println(msg);

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				st.sendMsg(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� ����
	public void start() {
		// dao�� �����ϸ鼭 deck�� �����
		blackjackdao = new BlackjackDao();
		// �÷��̾�� �� 2�徿 ���´�. (i for 2����)
		for (int i = 0; i < 2; i++) {
			// j for���� Ŭ���̾�Ʈ �����忡 ���� �� �徿 �ش�.
			for (int j = 0; j < BlackjackClients.size(); j++) {
				ServiceThread st = BlackjackClients.get(j);
				st.BJaddHand(this.draw());

			}
			// �� ������ ���� �и� ȭ�鿡
			this.otherUser("hand");
		}

		// ������ 2���� ���´�.
		for (int j = 0; j < 2; j++) {
			dealerhand.add(this.draw());

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);

				// �׸��� ȭ�鿡 ������ hand�� ���� �ڵ带 ����Ѵ�.
				st.setDealerhand(dealerhand);
			}
		}

	}

	// dao�� ������ ī�� ���� ���� ����
	public String draw() {
		return blackjackdao.draw();
	}

	// dealerhand ����
	public void dealerreset() {
		dealerhand.clear();
	}

	// �ٸ� ������ ���¸� ����ִ� �޼ҵ�(way == hand : �� / way == name : �̸� / way == state : hit,
	// stay, ready)
	public void otherUser(String way) {

		for (int i = 0; i < BlackjackClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = BlackjackClients.get(i);
			// j for���� head�� ���� target�� �� ������ ��� ����
			for (int j = 0; j < BlackjackClients.size(); j++) {
				ServiceThread target = BlackjackClients.get(j);
				// head�� target�� �ٸ��ٸ�
				if (head != target) {
					switch (way) {
					case "hand":
						// �� ������ ���� ������ �� �ϳ��� head�� Ŭ���̾�Ʈ�� ������, (hit�� �ش� �޼ҵ尡 ������ 0���� �ʱ�ȭ�� �Ǳ� ������ stay
						// ������ �̿���.)
						if (target.BJinfo.getStay() != 1) {
							cnt++;
							List<String> hand = target.BJinfo.getHand();

							head.sendMsg("BJUSER" + cnt + " " + hand.get(hand.size() - 1));
						} else {
							// stay �� ������ �ǳʶٱ� ���� cnt++;
							cnt++;
						}
						break;
					case "name":
						cnt++;
						// �� ������ �̸��� head�� Ŭ���̾�Ʈ�� ������
						head.sendMsg("BJUSERNAME" + cnt + " " + target.getDto().getName());
						break;
					case "state":
						cnt++;
						// �� ������ hit, stay, ready ���θ� Ŭ���̾�Ʈ�� ������
						String state = null;
						if (target.BJinfo.getHit() == 1) {
							state = "HIT";
						} else if (target.BJinfo.getStay() == 1) {
							state = "STAY";
						} else if (target.BJinfo.getReady() == 1) {
							state = "READY";
						} else {
							state = "";
						}
						head.sendMsg("BJUSERSTATE" + cnt + " " + state);
						break;
					}
				}
			}
			// ������ ������ �� �̹� ���� �ִ� �̸��� ����� ����.
			if (way.equals("name")) {
				while (cnt < 5) {
					cnt++;
					head.sendMsg("BJUSERNAME" + cnt + "  ");
				}
			}
		}

	}

	// ��� ������ HIT Ȥ�� STAY�� ���� �����̸� ���� �����ϰ� ���ο� ���� �����Ѵ�. �� ���� �ÿ� �� ������ HIT ���θ� �Ǻ��Ͽ�
	// ī�带 �����ش�.
	public void turn() {
		int turn = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			// �� ������ hit Ȥ�� stay�� 1�̶�� turn�� 1�� ���Ѵ�.
			if (st.BJinfo.getHit() == 1 || st.BJinfo.getStay() == 1) {
				turn *= 1;
			} else {
				turn *= 0;
			}
		}

		// ��� ������ hit Ȥ�� stay��� �����Ѵ�.
		if (turn == 1) {
			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				if (st.BJinfo.getHit() == 1) {
					st.BJaddHand(this.draw());
					st.sendMsg("BJTURNEND");
				}
				// �׸��� turn�� �������� Hit ������ 0���� �ʱ�ȭ �Ѵ�. (stay�� �״�� ���� �ȴ�.)
				st.BJinfo.setHit(0);
			}
			this.otherUser("hand");
		}

	}

	// ��� ������ STAY�� ������ �� ����Ǵ� �޼ҵ�
	public void end() {
		int theEnd = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			theEnd *= st.BJinfo.getStay();
		}

		// ��� �÷��̾ stay�� ������ ��
		if (theEnd == 1) {
			// ������ ī�带 �̴´�
			while (blackjackdao.Sum(dealerhand) <= 16) {
				dealerhand.add(this.draw());

				for (int i = 0; i < BlackjackClients.size(); i++) {
					ServiceThread st = BlackjackClients.get(i);
					// ���� ������ �и� �� BlackjackClients�� set ��Ŵ
					st.setDealerhand(dealerhand);
				}

			}

			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				// �� BlackjackClients�� ���� ���θ� Ȯ�� set��Ŵ
				st.BJinfo.setBlackjack(blackjackdao.blackjack(st));

				// ���������� �� BlackjackClients���� ���ڰ� ������ �ִ� �ʵ���� Ȱ���Ͽ� ����� �����
				double result = blackjackdao.result(st, blackjackdao.Sum(dealerhand));

				// ����� ������ db�� �ݿ�
				projectdao.ending(st.getDto(), st.BJinfo.getBetting(), result);

				// ��� ���(like 2 == WIN, 1.5 == BLACKJACK, 1 == DRAW, 0 == LOSE)
				if (result == 2) {
					st.sendMsg("BJmy: " + "WIN( " + result + "�� )");
				} else if (result == 1.5) {
					st.sendMsg("BJmy: " + "BLACKJACK( " + result + "�� )");
				} else if (result == 1) {
					st.sendMsg("BJmy: " + "DRAW( " + result + "�� )");
				} else if (result == 0) {
					st.sendMsg("BJmy: " + "LOSE( " + result + "�� )");
				}

				// ������ ������ ������ ����� ���� statusâ�� ���Ž�Ų��.
				st.setDto(projectdao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
				st.BJstatus();

				// �׸��� ��� ������ �����͵��� ���½�Ų��.
				st.BJreset();

			}
			this.dealerreset();

		}
	}

	// ��� ������ ready ��ư�� ������ �� ����
	public void ready() {
		int ready = 1;
		for (int i = 0; i < BlackjackClients.size(); i++) {
			ServiceThread st = BlackjackClients.get(i);
			ready *= st.BJinfo.getReady();
		}

		if (ready == 1) {
			this.start();
			// state â�� ������ ���ֱ� ���� ready ������ ���Ƿ� �ʱ�ȭ ����
			for (int i = 0; i < BlackjackClients.size(); i++) {
				ServiceThread st = BlackjackClients.get(i);
				st.BJinfo.setReady(0);
			}
		}

	}

	// ������ ����� db�� �ݿ��Ѵ�.
	public void betting(ProjectDto dto, int betting) {
		projectdao.betting(dto, betting);
	}

}
