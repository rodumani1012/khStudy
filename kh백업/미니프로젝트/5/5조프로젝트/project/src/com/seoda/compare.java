package com.seoda;

public class compare {
	
	//	ī�� 2���� �޾Ƽ� ���Ͽ� ������ ��
	public int compareDeck(int[] num) {
		if (num[0] == 3 && num[1] == 8 || num[0] == 8 && num[1] == 3) {
			// 38����
			System.out.println("38����");
			return 150;
		} else if (num[0] == 1 && num[1] == 3 || num[0] == 1 && num[1] == 8 || num[0] == 8 && num[1] == 1
				|| num[0] == 3 && num[1] == 1) {
			System.out.println("����");
			// 13&18����
			return 140;
		} else if (num[0] * 11 == num[1] || num[0] / 11 == num[1] || num[1] * 11 == num[0] || num[1] / 11 == num[0]) {
			System.out.println((num[0]+num[1])%11 + "��");
			// ��
			return 130;
		} else if (num[0] == 1 && num[1] == 2 || num[0] == 1 && num[1] == 22 || num[0] == 11 && num[1] == 2
				|| num[0] == 11 && num[1] == 22 || num[0] == 2 && num[1] == 1 || num[0] == 2 && num[1] == 11
				|| num[0] == 22 && num[1] == 1 || num[0] == 22 && num[1] == 11) {
			System.out.println("�˸�");
			// �˸�
			return 120;
		} else if (num[0] == 1 && num[1] == 4 || num[0] == 1 && num[1] == 44 || num[0] == 11 && num[1] == 4
				|| num[0] == 11 && num[1] == 44 || num[0] == 4 && num[1] == 1 || num[0] == 4 && num[1] == 11
				|| num[0] == 44 && num[1] == 1 || num[0] == 44 && num[1] == 11) {
			System.out.println("����");
			// ����
			return 110;
		} else if (num[0] == 1 && num[1] == 9 || num[0] == 1 && num[1] == 99 || num[0] == 11 && num[1] == 9
				|| num[0] == 11 && num[1] == 99 || num[0] == 9 && num[1] == 1 || num[0] == 9 && num[1] == 11
				|| num[0] == 99 && num[1] == 1 || num[0] == 99 && num[1] == 11) {
			System.out.println("����");
			// ����
			return 100;
		} else if (num[0] == 1 && num[1] == 10 || num[0] == 1 && num[1] == 110 || num[0] == 11 && num[1] == 10
				|| num[0] == 11 && num[1] == 110 || num[0] == 10 && num[1] == 1 || num[0] == 10 && num[1] == 11
				|| num[0] == 110 && num[1] == 1 || num[0] == 110 && num[1] == 11) {
			System.out.println("���");
			// ���
			return 90;
		} else if (num[0] == 4 && num[1] == 10 || num[0] == 4 && num[1] == 110 || num[0] == 44 && num[1] == 10
				|| num[0] == 44 && num[1] == 110 || num[0] == 10 && num[1] == 4 || num[0] == 10 && num[1] == 44
				|| num[0] == 110 && num[1] == 4 || num[0] == 110 && num[1] == 44) {
			System.out.println("���");
			// ���
			return 80;
		} else if (num[0] == 4 && num[1] == 6 || num[0] == 4 && num[1] == 66 || num[0] == 44 && num[1] == 6
				|| num[0] == 44 && num[1] == 66 || num[0] == 6 && num[1] == 4 || num[0] == 6 && num[1] == 44
				|| num[0] == 66 && num[1] == 4 || num[0] == 66 && num[1] == 44) {
			System.out.println("����");
			// ����
			return 70;
		} else if ((num[0] + num[1]) % 10 == 9) {
			System.out.println("����");
			// ����(���� 9)
			return 60;
		} else if ((num[0] + num[1]) % 10 == 0) {
			if (num[0] == 3 && num[1] == 7 || num[0] == 3 && num[1] == 77 || num[0] == 33 && num[1] == 7
					|| num[0] == 33 && num[1] == 77 || num[0] == 7 && num[1] == 3 || num[0] == 7 && num[1] == 33
					|| num[0] == 77 && num[1] == 3 || num[0] == 77 && num[1] == 33) {
				System.out.println("������");
				// ������(37)
				return 10;
			} else {
				// ����(���� 10)
				System.out.println("����");
				return 40;
			}
		} else {
			// ��
			if (num[0] == 4 && num[1] == 9 || num[0] == 4 && num[1] == 99 || num[0] == 44 && num[1] == 9
					|| num[0] == 44 && num[1] == 99 || num[0] == 9 && num[1] == 4 || num[0] == 9 && num[1] == 44
					|| num[0] == 99 && num[1] == 4 || num[0] == 99 && num[1] == 44) {
				System.out.println("�籸");
				return 30;
			} else if (num[0] == 4 && num[1] == 7 || num[0] == 4 && num[1] == 77 || num[0] == 44 && num[1] == 7
					|| num[0] == 44 && num[1] == 77 || num[0] == 7 && num[1] == 4 || num[0] == 7 && num[1] == 44
					|| num[0] == 77 && num[1] == 4 || num[0] == 77 && num[1] == 44) {
				System.out.println("������");
				return 25;
			} else {
				System.out.println((num[0]+num[1])%10+"��");
				return 50;
			}
		}
	}
}
