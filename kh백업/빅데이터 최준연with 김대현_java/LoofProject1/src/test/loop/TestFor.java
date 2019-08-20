package test.loop;
/**
 * 
 * @author 최준연
 * 별 출력 프로그램
 * 내용 : 반복문을 사용하여 한줄에 별 5개를 출력하고
 *      또 다른 (중첩)반복문을 사용하여 5줄을 출력한다.
 * 절차 :
 * 1. 반복문을 만들어 5번의 '*'을 출력한다.
 * 1-1. print() 사용
 * 2. (중첩) 반복문을 만들고 1번 반복문을 그 안에 넣는다.
 * 3. 외곽 반복문을 5번 반복하도록 한다.
 * 3-1 println() 사용
 * 결과 :
 * *****
 * *****
 * *****
 * *****
 * *****
 * 4. 내부의 반복문을 외부 반복 조건 변수 a만큼 (미만으로) 수행하도록 한다.
 * 결과 : 
 * *
 * **
 * ***
 * ****
 * *****
 * 5. 0부터 10까지의 정수 중에 짝수만 더한 값을 모두 출력하는 문제.
 * 5-1 홀수는 빼버린 결과값까지 출력해버리는 문제가 발생.
 * 5-2 문제를 해결하기 위해 홀수값이 있을땐 다음 문구를 실행하지않고 증감식으로 넘어가는 continue를 사용.
 *
 */
public class TestFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				System.out.print('*');
				
			}
				System.out.println();
		}
		
		//4. 내부의 반복문을 외부 반복 조건 변수 a만큼 (미만으로) 수행하도록 한다.
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b <= a; b++) {     // 0<=0
				System.out.print('*');		   // 0,1<=1
											   // 0,1,2<=2  ......  0,1,2,3,4<=4
			}	
				System.out.println();
		}
		
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			if (i%2 ==0) {
				sum += i;
			} else {
				continue;		// continue는 나머지 내용은 실행에 포함시키지 않는다.
			}
			System.out.println(sum);
		}
	}

}
