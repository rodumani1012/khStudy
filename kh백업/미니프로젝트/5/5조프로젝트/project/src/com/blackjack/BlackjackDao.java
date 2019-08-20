package com.blackjack;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import com.project.ServiceThread;

public class BlackjackDao {

	private List<String> deck = new ArrayList<String>();

	public BlackjackDao() {
		this.deck = deck();
	}

	public List<String> deck() {

		String[] mark = { "D", "S", "H", "C" };
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J" };

		// re for���� deck�� Ʈ���� ī�� 2���� �ֱ� ����
		for (int re = 0; re < 2; re++) {
			// i for���� mark�� ������ ����
			for (int i = 0; i < 4; i++) {
				// j for���� num�� ������ ����
				for (int j = 0; j < 13; j++) {
					deck.add(mark[i] + num[j]);
				}
			}
		}

		// �����Ѵ�.
		Collections.shuffle(deck);

		return deck;

	}

	// ī�� �̱�
	public String draw() {

		// deck�� 0���� �� ���� �̴´�
		String drawcard = this.deck.get(0);
		// ���� ī�带 ������ �����.
		this.deck.remove(0);

		return drawcard;
	}

	public int Sum(List<String> dealerhand) {
		// hand�� A�� �ִ��� ������
		boolean A = false;
		// ���� ��
		int sum = 0;

		// hand�� ����ִ� card �ϳ��ϳ��� �̾Ƽ�
		for (String card : dealerhand) {

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

		return sum;
	}

	public double result(ServiceThread st, int dealersum) {

		if (st.BJinfo.getSum() < 22 && dealersum < 22) {
			if (st.BJinfo.isBlackjack() && dealersum != 21) {
				return 1.5;
			} else if (st.BJinfo.getSum() > dealersum) {
				return 2;
			} else if (st.BJinfo.getSum() == dealersum) {
				return 1;
			} else if (st.BJinfo.getSum() < dealersum) {
				return 0;
			}
		} else if (st.BJinfo.getSum() > 21) {
			return 0;
		} else if (dealersum > 21) {
			if (st.BJinfo.isBlackjack()) {
				return 1.5;
			} else {
				return 2;
			}
		}
		System.out.println("error");
		return 1;

	}

	// blackjack ���� �Ǻ�
	public boolean blackjack(ServiceThread st) {

		int sum = 0;

		// ó�� ���� �� ī�带 �̾Ƽ� ���Ѵ�
		for (int i = 0; i < 2; i++) {
			switch (st.BJinfo.getHand().get(i).substring(1)) {
			case "A":
				sum += 11;
				break;
			case "K":
			case "Q":
			case "J":
				sum += 10;
				break;
			default:
				sum += Integer.parseInt(st.BJinfo.getHand().get(i).substring(1));
			}

		}

		// �� ���ڰ� 21�̸� true�� ����
		return sum == 21;

	}

}
