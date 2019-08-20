package com.seoda;

import java.util.*;

public class SeodaGameInfo {
	private int myno;
	private String myname;
	private int ready = 0;			//	0�̸� ready ����, 1�̸� ready
	private int Result_Count = 0;
	private int result_name;
	private int battingMoney;		//	���� �Ӵ�	
	private int result;				//	��� ���� ����
	
	List<Integer> card = new ArrayList<Integer>();	//	������ ī�� ����

	public int[] card_num = new int[2];	//	���� ī�� ��ȣ ����
	
	private boolean seoda = false;	//	��� Ȯ���ϴ� ����
	
	//	�⺻ ������
	public SeodaGameInfo() {
		super();
	}

	//	ready(1) ����
	public int getReady() {
		return ready;
	}

	//	ready(1) ����
	public void setReady(int ready) {
		this.ready = ready;
	}

	//	result(1) ����
	public int getResult_Count() {
		return Result_Count;
	}
	
	//	result(1) ����
	public void setResult_Count(int Result_Count) {
		this.Result_Count = Result_Count;
	}

	//	ī�� ����
	public List<Integer> getHand() {
		return card;
	}

	//	ī�� ����
	public void setHand(List<Integer> card) {
		this.card = card;
	}
	
	//	��� ���� ����
	public void setResultCard(String resultMessage) {
		//	�޽����� ���� �޾� split���� ������ ������ �� ������ ������ �ݾ��� ����
		String splitMsg[] = resultMessage.split(" ");

		this.result = Integer.parseInt(splitMsg[2]);
		this.battingMoney = Integer.parseInt(splitMsg[3]);
	}
	
	//	���þ� ����
	public int getBattingMoney() {
		return battingMoney;
	}
	
	//	��� ���� ����
	public int getResult() {
		return result;
	}
	
	//	ī�� �߰�
	public void addCard(int card) {
		this.card.add(card);
	}
}
