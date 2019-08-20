package test.data;
/**
 * 
 * @author 최준연
 * 설명 : 비트연산자를 통해 각 숫자의 결과값을 알아보자
 *
 */
public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(118+" 의 2진 코드 = " + Integer.toBinaryString(118));
		System.out.println(15+" 의 2진 코드 = " + Integer.toBinaryString(15));
		System.out.println("118&15의 결과 값은 " + Integer.toBinaryString(118&15));   // 1&1 이면 1, 하나라도 다르면 0
		System.out.println("118|15의 결과 값은 " + Integer.toBinaryString(118|15));   // 하나라도 1이면 1
		System.out.println("118^15의 결과 값은 " + Integer.toBinaryString(118^15));   // 두개가 서로 달라야 1
		System.out.println("!118의 결과 값은 " + Integer.toBinaryString(~118));		  // 1은 0으로 0은 1로
		System.out.println("!15의 결과 값은 " + Integer.toBinaryString(~15));		  // 1은 0으로 0은 1로
	}

}
