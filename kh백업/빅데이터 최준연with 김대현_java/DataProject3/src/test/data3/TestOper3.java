package test.data3;

import java.util.Random;

public class TestOper3 {

	public static void main(String[] args) {
		int i = 5;
		int j = 10;
		int[] iArray = {7, 5, 4, 9, 8, 2};
		// API���� ���� �ΰ� �߿� ū ���� ã���ִ� �Լ��� �̿���
		// i vs j �߿� ū ���� ����ϵ��� �Ѵ�.
		System.out.println(Math.max(i, j));
		System.out.println(Math.min(i, j));
		// iArray�� ū������ ���� ������ ����϶�
		for (int m = 0; m < iArray.length-1; m++) {
			for (int k = m+1; k < iArray.length; k++) {
				if (Math.max(iArray[m], iArray[k]) != iArray[m]) {
					int temp = iArray[k]; iArray[k] = iArray[m]; //���� 19~20 �ڸ��ٲ� �ڵ�
					iArray[m] = temp;
				}
			}
//			System.out.println(iArray[m]);    ������
		}
		for (int k : iArray) {
			System.out.print(k + ", ");
		}
	}

}
