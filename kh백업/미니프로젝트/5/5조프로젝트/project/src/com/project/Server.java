package com.project;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.blackjack.BlackjackMethod;
import com.my.dao.ProjectDao;
import com.my.dto.ProjectDto;
import com.seoda.SeodaMethod;

public class Server {

	ProjectDao projectdao = new ProjectDao();
	ProjectDto projectdto = new ProjectDto();

	// �� Clients�� serviceThread�� �����Ǿ� ���� ����
	List<ServiceThread> Clients;

	// ���� �޼ҵ�
	BlackjackMethod BJMethod = new BlackjackMethod();

	// ���� �޼ҵ�
	SeodaMethod seodaMethod = new SeodaMethod();

	// �⺻ ������(Ŭ���̾�Ʈ�� ���� ����Ʈ����)
	public Server() {
		Clients = new ArrayList<>();
	}

	// Clients �߰�
	public void addClient(ServiceThread st) {
		synchronized (Clients) {
			Clients.add(st);
		}
	}

	// Clients ����
	public synchronized void removeClient(ServiceThread st) {
		Clients.remove(st);

		// ��� ������ �ְ� ������ remove ����, �׸��� �ش� ������ ���ϴ� �޼ҵ带 ������
		if (BJMethod.removeClient(st)) {
			BJMethod.otherUser("name");
			BJMethod.turn();
			BJMethod.ready();
		} else if (seodaMethod.removeClient(st)) {
			seodaMethod.otherUser("name");
			seodaMethod.ready();
		}

	}

	// ȸ������(server -> dao)
	public synchronized boolean newId(String msg) {
		// db�� �����ؼ� �����ϸ� 0 �̻� �� ��ȯ�Ͽ� true�� serviceThread�� ����
		if (projectdao.insert(msg) > 0) {
			System.out.println("ȸ������ ����");
			return true;
		} else {
			return false;
		}
	}

	// �α���(server -> dao)
	public synchronized ProjectDto login(String msg) {
		// db�� �����ؼ� dto�� dao���� �Ѱ��� dto�� ����
		projectdto = projectdao.login(msg);

		// �����Ͽ����� dto�� null�� �ƴϱ� ������ dto�� serviceThread�� ����
		if (projectdto != null) {
			return projectdto;
		} else {
			return null;
		}
	}

	// �� ���� Clients�� ���� �ѱ�
	// ������ ������ ���ϴ� ������ ���� �� ���� �ο����� ������Ŵ
	public void deliverUser(String game, String name) {
		synchronized (Clients) {
			for (int i = 0; i < Clients.size(); i++) {
				ServiceThread st = Clients.get(i);
				System.out.println(st.getDto().getName());
				if (st.getDto().getName().equals(name)) {
					switch (game) {
					case "blackjack":
						BJMethod.addBlackjackClients(st);
						break;
					case "seoda":
						seodaMethod.addSeodaClients(st);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Server server;
		ServerSocket serverSocket = null; // ���� ���� ȣ��
		int port = 6666;
		server = new Server(); // �⺻������ ����

		try {
			serverSocket = new ServerSocket(port); // ���� ������ ��Ʈ��ȣ�� �޾� ����
		} catch (IOException e) {
			System.err.println("���� ����");
			System.exit(1);
		}

		System.out.println("���� \n" + serverSocket + "\n���� ������ ��ٸ��ϴ�.");

		while (true) {
			try {
				// Client�� ������ serviceSocket�� ���
				Socket serviceSocket = serverSocket.accept();
				// ServiceThread�� BlackjackServer�� �Բ� ���� �Ѱ���
				ServiceThread thread = new ServiceThread(server, serviceSocket);

				System.out.println(server.Clients.size());
				
				// �׸��� �� ServiceThread�� Clients�� ��� ������
				server.addClient(thread);
				thread.start();

			} catch (IOException e) {
				try {
					serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
