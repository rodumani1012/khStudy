package com.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackjackinGameinfo {

	// dealerhand ����
	List<String> dealerhand = null;

	// ������ hand ����
	List<String> hand = new ArrayList<String>();

	// 0�̸� stay�� ���� ���� 1�� �Ǹ� stay�� ��
	private int stay = 0;

	// ������ hand�� ���� �����ϴ� ����
	private int sum;

	// ������ blackjack ���θ� Ȯ���Ͽ� ����� ��� ����
	private boolean blackjack = false;

	// 0�̸� hit�� ���� ���� 1�̸� hit�� ��.
	private int hit = 0;

	// 0�̸� ready ����, 1�̸� ready ��.
	private int ready = 0;

	// ���� �ݾ�
	private int betting = 0;

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getBetting() {
		return betting;
	}

	public void setBetting(int betting) {
		this.betting = betting;
	}

	public int getReady() {
		return ready;
	}

	public void setReady(int ready) {
		this.ready = ready;
	}

	public BlackjackinGameinfo() {
		super();
	}

	public List<String> getDealerhand() {
		return dealerhand;
	}

	public void setDealerhand(List<String> dealerhand) {
		this.dealerhand = dealerhand;
	}

	public List<String> getHand() {
		return hand;
	}

	public void addHand(String card) {
		this.hand.add(card);
	}

	public int getSum() {
		return sum;
	}

	// ������ hand�� �ش� �޼ҵ带 �̿��Ͽ� sum�� ����
	public void setSum() {
		// hand�� A�� �ִ��� ������
		boolean A = false;
		// ���� ��
		int sum = 0;

		// hand�� ����ִ� card �ϳ��ϳ��� �̾Ƽ�
		for (String card : getHand()) {

			// �� ���� ���� ���� sum�� ���Ѵ�. ���꽺Ʈ���� ������ ����� ����
			switch (card.substring(1)) {
			case "A":
				sum += 11;
				A = true;
				break;
			case "K":
			case "Q":
			case "J":
				sum += 10;
				break;
			default:
				sum += Integer.parseInt(card.substring(1));
			}

		}

		// �հ谡 21�� �Ѱ� hand�� A ī�尡 �ִٸ� 11�� 1�� ������ش�.
		if (sum > 21 && A) {
			sum -= 10;
		}

		this.sum = sum;
	}

	public int getStay() {
		return stay;
	}

	public void setStay(int stay) {
		this.stay = stay;
	}

	public boolean isBlackjack() {
		return blackjack;
	}

	public void setBlackjack(boolean blackjack) {
		this.blackjack = blackjack;
	}

}
