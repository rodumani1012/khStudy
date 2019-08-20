package test.data3;

import java.util.Random;

public class TestOper3 {

	public static void main(String[] args) {
		int i = 5;
		int j = 10;
		int[] iArray = {7, 5, 4, 9, 8, 2};
		// API에서 숫자 두개 중에 큰 값을 찾아주는 함수를 이용해
		// i vs j 중에 큰 값을 출력하도록 한다.
		System.out.println(Math.max(i, j));
		System.out.println(Math.min(i, j));
		// iArray를 큰수부터 작은 수까지 출력하라
		for (int m = 0; m < iArray.length-1; m++) {
			for (int k = m+1; k < iArray.length; k++) {
				if (Math.max(iArray[m], iArray[k]) != iArray[m]) {
					int temp = iArray[k]; iArray[k] = iArray[m]; //라인 19~20 자리바꿈 코드
					iArray[m] = temp;
				}
			}
//			System.out.println(iArray[m]);    검증용
		}
		for (int k : iArray) {
			System.out.print(k + ", ");
		}
	}

}
