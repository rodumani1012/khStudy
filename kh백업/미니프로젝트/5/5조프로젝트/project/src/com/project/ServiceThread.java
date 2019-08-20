package com.project;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.blackjack.BlackjackinGameinfo;
import com.my.dto.ProjectDto;
import com.seoda.SeodaGameInfo;
import com.slot.SlotInfo;

public class ServiceThread extends Thread {

	private ProjectDto dto;
	private Server server;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public SeodaGameInfo seodaInfo = new SeodaGameInfo();
	public BlackjackinGameinfo BJinfo = new BlackjackinGameinfo();
	public SlotInfo SMinfo = new SlotInfo();

	//	DTO�� ����
	public ProjectDto getDto() {
		return dto;
	}

	//	DTO�� ����
	public void setDto(ProjectDto dto) {
		this.dto = dto;
	}

	// ������
	public ServiceThread(Server server, Socket socket) {
		super();
		this.server = server;
		this.socket = socket;
	}

	// message ����
	public void sendMsg(String msg) {
		if (out != null) {
			out.println(msg);
		}
	}

	// ---------------------------- ����

	//	���� ����
	public void BJreset() {
		BJinfo = new BlackjackinGameinfo();
		out.println("BJRESET");
	}

	//	���ӿ� ������ ���� ����(�̸�, ��)
	public void BJstatus() {
		out.println("BJSTATUS " + dto.getName() + " " + dto.getMoney());
	}

	//	ī��̱�
	public void BJaddHand(String card) {
		BJinfo.addHand(card);
		this.BJsendHand();
	}

	//	ī�� ����
	public void BJsendHand() {
		List<String> hand = BJinfo.getHand();
		out.println("BJmy: " + hand.get(hand.size() - 1));

	}

	//	����ī�弼��
	public void setDealerhand(List<String> dealerhand) {
		BJinfo.setDealerhand(dealerhand);
		this.sendDealerHand();
	}

	//	����ī�� �� �������� ����
	public void sendDealerHand() {
		List<String> dealerhand = BJinfo.getDealerhand();
		out.println("BJdealer: " + dealerhand.get(dealerhand.size() - 1));

	}

	// ----------------------------- ����
	// ���� ���� �� ����
	public void SDreset() {
		seodaInfo = new SeodaGameInfo();
		out.println("SEODARESET");
	}

	// ī�� ����(ex: 38���� 150�� / 18,13���� 140�� ���) ����
	public void setResultCard(String msg) {
		seodaInfo.setResultCard(msg);
	}

	// ī�� ���� �ҷ�����
	public int getResultCard() {
		return seodaInfo.getResult();
	}

	// �̸��� �� ���� ����
	public void seodaStauts() {
		out.println("SEODAMY " + dto.getName() + " " + dto.getMoney());
	}

	// ī�� �ޱ�
	public void SDaddHand(int card) {
		seodaInfo.addCard(card);
		this.SDsendHand();
	}

	// ī�� ����
	public void SDsendHand() {
		List<Integer> card = seodaInfo.getHand();
		out.println("SEODAMYCARD " + card.get(card.size() - 1));
	}

	// �޽��� �ְ� �ޱ�
	@Override
	public void run() {
		try {
			System.out.println("Ŭ���̾�Ʈ\n" + socket + "\n���� �����Ͽ����ϴ�.");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Clients���� �Ļ��� �� �����̳� Ŭ���̾�Ʈâ ���� ������ �޽��� ����
			String inputLine;

			while ((inputLine = in.readLine()) != null) {		//	Ŭ���̾�Ʈ�ʿ��� ������ �޽����� ���� �� ���
				// contains() : ()�ȿ� �ִ� �ܾ ������ ������ ���� , eqauls() : ()�ȿ� �ִ� �ܾ�� ������ ��� ���� 

				// ------------------------- ȸ�� ����, �α��� ------------------------------------
				if (inputLine.contains("REGISTRY")) {
					// ȸ������(server�� newId()�� �޽��� ����
					if (server.newId(inputLine)) {
						// �����ϸ� true�� ���� �Ǿ� Ŭ���̾�Ʈ�� "REGISTRY SUCESS" ����
						out.println("REGISTRY SUCESS");
					}
					
				} else if (inputLine.contains("LOGIN")) {
					// �α��� �����ϸ� dto�� �� ������ �����Ͱ� ���� �ȴ�.
					dto = server.login(inputLine);
					if (dto != null) {			//	�α����� �����ϸ� dto�� ���� ����Ǳ� ������ null�� �ƴϴ�
						out.println("SUCESS");
					} else {
						out.println("FAIL");
					}
					
					// ------------------------- ���� ------------------------------------
				} else if (inputLine.trim().equals("BJHIT")) {
					// HIT �ÿ� hit ������ 1�� ��� turn�� ����Ǵ� �� Ȯ����
					this.BJinfo.setHit(1);
					server.BJMethod.otherUser("state");
					server.BJMethod.turn();
				} else if (inputLine.trim().equals("BJSTAY")) {
					// STAY �ÿ� stay������ 1�� ��� ������ hand�� ���� sum�� set��Ų��. �׸��� turn�� ����Ǵ� �� Ȯ����
					// �� �Ŀ� server�� end�� �޼ҵ带 ������� ��� ������ stay�� ���������� Ȯ����
					BJinfo.setStay(1);
					this.BJinfo.setSum();
					server.BJMethod.otherUser("state");
					server.BJMethod.turn();
					server.BJMethod.end();
					
				} else if (inputLine.trim().equals("BJREADY")) {
					// READY�� ������ status â�� ����, ���Ҿ� server.ready()�� ����, ���� ��ΰ� READY�� �������� üũ�Ѵ�.
					this.BJstatus();
					BJinfo.setReady(1);
					server.BJMethod.otherUser("state");
					server.BJMethod.ready();
					
				} else if (inputLine.contains("BJBET")) {
					// ���� �޼ҵ�, ���� �ݾ��� �Ѱܹ޾� info�� �����Ѵ�, �׸��� db�� �ݿ��Ѵ�. (���� �ݾ׿� ���� �ݾ� ����)
					String betting = inputLine;
					this.BJinfo.setBetting(Integer.parseInt(betting.split(" ")[1]));
					server.BJMethod.betting(dto, BJinfo.getBetting());
					// db�� �ݿ��� ������ dto���� �ݿ���, LOGIN �޼ҵ� ��Ȱ����
					dto = server.login("LOGIN " + dto.getName() + " " + dto.getPw());
					
				} else if (inputLine.equals("BJSTART")) {
					// ���� ȭ���� Ŀ���� �� status â ����, �� ������ �̸� ����, �� ���� ���� �� ä�� ���
					this.BJstatus();
					server.BJMethod.otherUser("name");
					server.BJMethod.sendMessageAll("BJchat " + dto.getName() + "���� �����ϼ̽��ϴ�.");
					
				} else if (inputLine.contains("BJchat")) {
					// ���� ���� ä���� ����
					String[] msgArr = inputLine.split(" ");
					String msg = "";
					for (int i = 1; i < msgArr.length; i++) {
						msg += inputLine.split(" ")[i] + " ";
					}
					server.BJMethod.sendMessageAll("BJchat " + dto.getName() + ": " + msg);
					
				} else if (inputLine.equals("BJIN")) {
					// ���� ������ ���������� �˸��� �޼ҵ�, ������ �� ���Ӻ��� �����ϱ� ����
					server.deliverUser("blackjack", dto.getName());
					
				} else if (inputLine.equals("BJBACK")) {
					this.sendMsg("BACK");
					server.BJMethod.removeClient(this);
					server.BJMethod.otherUser("name");
					server.BJMethod.turn();
					server.BJMethod.ready();

					// ------------------���Ըӽ�----------------------------------
				} else if (inputLine.equals("SLOTSTART")) {
					//	���Ըӽſ� �ڽ��� �� ����
					out.println("SLOTSTART " + dto.getMoney());
					
				} else if (inputLine.contains("SLOTENDING")) {
					//	���Ըӽ��� ���� ������ ���� ���� ����� ��� ������Ʈ�� �ϰ� �ٽ� �ڽ��� ���� ����
					System.out.println(dto.getName());
					System.out.println(inputLine);
					server.projectdao.slotending(dto, Integer.parseInt(inputLine.split(" ")[1]));
					dto = server.projectdao.login("LOGIN " + dto.getName() + " " + dto.getPw());
					out.println("SLOTENDING " + dto.getMoney());
					
				} else if (inputLine.equals("SLOTBACK")) {
					//	BACK ��ư Ŭ���� �ڷ� ���ư���
					this.sendMsg("BACK");
					
					// ------------------------ ����----------------------
				} else if (inputLine.contains("SEODACHAT")) {
					// ���� ä��
					// ���� �޽����� �߶� 0���� ���� �����ϰ� �������� �ٿ��� �����̸��� �Բ� �ٽ� ����
					String[] msgArr = inputLine.split(" ");
					String msg = "";
					for (int i = 1; i < msgArr.length; i++) {
						msg += inputLine.split(" ")[i] + " ";
					}
					server.seodaMethod.sendMessageAll("SEODACHAT " + dto.getName() + ": " + msg);

				} else if (inputLine.contains("SEODASTART")) {
					// ���� ���ӽ� �ڽ��� ���¿� �ٸ������ ���� ����
					this.seodaStauts();
					server.seodaMethod.otherUser("name");
					server.seodaMethod.sendMessageAll("SEODACHAT " + dto.getName() + "���� �����ϼ̽��ϴ�!");

				} else if (inputLine.contains("SEODAREADY")) {
					// ���� ������ server.ready() ���� �� ��� ready�� �������� Ȯ��
					seodaInfo.setReady(1);
					server.seodaMethod.gameTotalBattingMoney(); 		// ���� �ݾ� �ѹ� �߰�(�����)
					server.seodaMethod.sendMessageAll(inputLine); 	// �� �������� ���� �����ٰ� ǥ��
					server.seodaMethod.sendGameTotalBattingMoney();	// �� �������� ���� ���þ� ��� �޼ҵ�
					server.seodaMethod.ready();						// ���� ����

				} else if (inputLine.contains("SEODACALL")) {
					// CALL�� ������ ���þ� �߰�
					server.seodaMethod.gameTotalBattingMoney(); 		// ���þ� ����
					server.seodaMethod.sendMessageAll(inputLine); 	// �� �������� �޽��� ����(ex: 00�� ��!)
					server.seodaMethod.sendGameTotalBattingMoney(); 	// �� �������� ���� ���þ� ��� �޼ҵ�

				} else if (inputLine.contains("SEODADIE")) {
					// DIE�� ������ ������ 0������ ����� RESULT �߰�
					seodaInfo.setResult_Count(1);
					setResultCard(inputLine);						// ������ 0������ ����
					server.seodaMethod.sendMessageAll(inputLine);		// �� �������� �޽��� ����(ex: 00�� DIE)
				
				} else if (inputLine.contains("SEODARESULT")) {
					// ���� ��� ����
					seodaInfo.setResult_Count(1);
					setResultCard(inputLine);						// �� �������� �޽��� ����
					server.seodaMethod.end();						// ��� ������⸦ ������ ����
					
				} else if (inputLine.equals("SEODAIN")) {
					// ���� ������ ���������� �˸��� �޼ҵ�, ������ �� ���Ӻ��� �����ϱ� ����
					server.deliverUser("seoda", dto.getName());
					
				} else if (inputLine.equals("SEODABACK")) {
					// BACK��ư Ŭ���� �ڷΰ���
					this.sendMsg("BACK");
					server.seodaMethod.removeClient(this);			// ���ٿ��� �� ������ ����
					server.seodaMethod.otherUser("name");			// �����ٴ� �޽��� ����
					server.seodaMethod.ready();
				}
			}
			out.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			server.removeClient(this);
			System.out.println("Ŭ���̾�Ʈ \n" + socket + "\n���� ������ ������ϴ�...");
		}
	}
}
