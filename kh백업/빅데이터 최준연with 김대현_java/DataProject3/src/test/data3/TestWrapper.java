package test.data3;
/**
 * 
 * @author 최준연
 * 모든 Wrapper class 변수와 값은 해당 기본형 변수의 값과 호환된다.
 * Integer, Short, Long, Double, Float, Boolean, Character, Byte, String
 *
 */
public class TestWrapper {

	public static void main(String[] args) {
		String s = new String("hello"); // 참조형 방식
		String s2 = "hello"; 			// 기본형 방식
		int i = 1;			 			// 기본형  값 대입
		Integer iI = new Integer(i);	// 참조형  값 생성
		i %= iI; 						// 연산참여
		iI = 1;							// 참조형 = 기본값
		Double dD = 0.15;
	}

}
