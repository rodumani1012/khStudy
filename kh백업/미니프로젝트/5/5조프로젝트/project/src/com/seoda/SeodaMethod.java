package com.seoda;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import com.my.dao.ProjectDao;
import com.project.ServiceThread;

public class SeodaMethod {

	ProjectDao pj_dao = new ProjectDao();		 //	projectdao ����
	SeodaDao seodaDao = null;

	Integer[] compare_Result = { 0, 0, 0, 0, 0 };	 // �� ��� ������ �޾Ƽ� �����ϱ� ���� �迭

	int gameTotalBattingMoney = 0; // �ʱ� �⺻ �ǵ�
	
	List<ServiceThread> SeodaClients = new ArrayList<>(); // �� Ŭ���̾�Ʈ(����)�� �����带 �����Ͽ� ����

	// Ŭ���̾�Ʈ(������) ����
	public void addSeodaClients(ServiceThread st) {
		this.SeodaClients.add(st);
	}
	
	// seoda�� ������ Ŭ���̾�Ʈ���� �� ����� ����
	public int sizeUsers() {
		return SeodaClients.size();
	}

	// ���� ���� ����, ���� ���� �� ������ boolean���� ������
	public boolean removeClient(ServiceThread st) {
		return this.SeodaClients.remove(st);
	}

	// ä�ø޼ҵ�
	public void sendMessageAll(String msg) {
		try {
			System.out.println(msg);

			for (int i = 0; i < SeodaClients.size(); i++) {
				ServiceThread st = SeodaClients.get(i);
				st.sendMsg(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��� ������ ready ��ư�� ������ �� ����
	public void ready() {
		int ready = 1;
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			ready *= st.seodaInfo.getReady();		//	���� 1���̶� �ȴ����� ready = 0�̱� ������ �ؿ� if���� ������� ����
		}

		if (ready == 1) {
			this.start();		//	SeodaMethod�� start() ����

			for (int i = 0; i < SeodaClients.size(); i++) {
				ServiceThread st = SeodaClients.get(i);
				st.seodaInfo.setReady(0);
			}
		}
	}

	// ���� ����
	public void start() {
		// dao�� �����ϸ鼭 ���ο� ī�嵦�� �����
		seodaDao = new SeodaDao();

		// �÷��̾�� ���� ī�� 2���� �޴´�(i�� 2���� �ޱ� ���� , j�� �� �����忡 �����ϱ�����)
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread st = SeodaClients.get(j);
				st.SDaddHand(this.draw());
			}
		}
		
		// �ٸ��������� ī�� ����
		this.otherUser("hand");
	}

	// seodaDao���� ī�� ���� ����
	public int draw() {
		return seodaDao.draw();
	}

	// �ٸ� ������ ����(�̸� , �� , ī��) ����
	// way == hand : ī�� / way == name : �̸�
	public void otherUser(String way) {
		for (int i = 0; i < SeodaClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = SeodaClients.get(i);
			
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread target = SeodaClients.get(j);

				// head�� target�� �ٸ��ٸ�(��, �ڱ��ڽ��� �ƴ϶��)
				if (head != target) {
					switch (way) {
					case "hand":
						// �� ������ ���� ������ �� �ϳ��� head�� Ŭ���̾�Ʈ�� ����
						cnt++;
						List<Integer> card = target.seodaInfo.getHand();

						head.sendMsg("USERCARD" + cnt + " " + card.get(0) + " " + card.get(1));
						break;
					case "name":
						cnt++;
						// �� ������ �̸��� ���� head�� Ŭ���̾�Ʈ�� ����
						head.sendMsg("SEODAUSERSTATUS" + cnt + " " + target.getDto().getName() + " " + target.getDto().getMoney());
						break;
					}
				}
			}

			// ������ ������ �� �̹� �����ִ� �̸��� ����� ����
			if (way.equals("name")) {
				while (cnt < 5) {
					cnt++;
					head.sendMsg("SEODAUSER" + cnt + " ");
				}
			}
		}
	}

	// �ٸ���� ī�� ����
	public void otherUserCard() {
		for (int i = 0; i < SeodaClients.size(); i++) {
			int cnt = 0;
			ServiceThread head = SeodaClients.get(i);
			for (int j = 0; j < SeodaClients.size(); j++) {
				ServiceThread target = SeodaClients.get(j);
				
				//	�ڱ� �ڽ��� �ƴ϶��
				if (head != target) {
					cnt++;
					List<Integer> card = target.seodaInfo.getHand();
					head.sendMsg("SEODAUSERCARD" + cnt + " " + card.get(0) + " " + card.get(1));
				}
			}
		}
	}

	// ��� ������ RESULT�� ������ �� ����Ǵ� �޼ҵ�
	public void end() {
		int theEnd = 1;
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			theEnd *= st.seodaInfo.getResult_Count();
		}
		
		// ��� ������ Result�� ���������
		if (theEnd == 1) {
			// ��� ���
			System.out.println("��� Ȯ��!!!");
			this.gameResult();	//	SeodaMethod�� gameResult() ����
		}
	}

	// ��� ������ ������⸦ �Ͽ� �����ϰ� 1���� ����� ã�´�
	public void gameResult() {

		// �ٸ� ���� ī�� ���(�� ���� GUI�� �ڽ��� ������ �ٸ� ������ ī�带 �����ش�)
		this.otherUserCard();

		// ��� ������ ��� ������ �迭�� ����
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);
			compare_Result[i] = (Integer) st.getResultCard();
		}
		System.out.println("�� ���� �迭�� ���� �Ϸ�");

		// ������ ���� ������ ���������� ����
		Arrays.sort(compare_Result, Collections.reverseOrder());
		System.out.println("���� �Ϸ�");

		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);

			if (compare_Result[0].equals(st.getResultCard())) {
				// ���� ���� ������ ����� ���� ������Ʈ ���ش�
				if ((seodaDao.moneyWinUpdate(st.getDto().getName(), 
						this.gameTotalBattingMoney - st.seodaInfo.getBattingMoney())) > 0) {
					//	������Ʈ�� ���������� �� ������Ʈ �� dto�� ���� ������ ���ش�
					st.setDto(pj_dao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
					
					st.sendMsg("SEODARESULT ����� �¸��Ͽ����ϴ�!!!");	//	�¸� �޽��� ����
					st.seodaStauts();	//	������Ʈ �Ǿ����Ƿ� ���� ����â ����
				}
				
			} else {
				// �й����̸� ���� ���� ������Ʈ ���ش�
				if (seodaDao.moneyLoseUpdate(st.getDto().getName(), st.seodaInfo.getBattingMoney()) > 0) {
					st.setDto(pj_dao.login("LOGIN " + st.getDto().getName() + " " + st.getDto().getPw()));
					
					st.sendMsg("SEODARESULT ����� �й��Ͽ����ϴ�!!");		//	�й� �޽��� ����
					st.seodaStauts();	//	������Ʈ �Ǿ����Ƿ� ���� ����â ����
				}
			}
			st.SDreset();	//	���� ����
		}
		gameTotalBattingMoney = 0;	// ���� �� ���þ׵� 0���� �ʱ�ȭ

		// ����� ������ �����Ͽ� �ٽ� ���
		this.otherUser("name");

	}

	// �� ������ CALL�� ������ ��� ��ü ���þ��� ���������ش�
	public void gameTotalBattingMoney() {
		this.gameTotalBattingMoney += 1000000;
	}

	// ��ü �������� ���� �� ���þ� ����
	public void sendGameTotalBattingMoney() {
		for (int i = 0; i < SeodaClients.size(); i++) {
			ServiceThread st = SeodaClients.get(i);

			st.sendMsg("SEODATOTALMONEY �ѹ��þ�: " + gameTotalBattingMoney);
		}
	}
}
