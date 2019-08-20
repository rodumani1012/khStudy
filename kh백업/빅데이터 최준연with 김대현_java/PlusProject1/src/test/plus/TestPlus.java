package test.plus;
/**
 * 
 * @author 최준연
 *	더하기 연산프로그램
	주제 : 두 수를 더한 결과를 화면 출력
	내용 : 두 수를 더한 결과를 화면 출력
	절차 : 
	1. 두수를 입력받는다
	1-1 a, b;
	2. 결과변수를 선언한다
	2-1 result;
	3. 두수를 + 연산하여 2번 결과변수에 넣는다(대입한다)
	3-1 result = a + b;
	4. 결과변수를 출력한다
	4-1 syso(result);
	
 */
public class TestPlus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a=1, b=2; /* 또는 int a=1;
							    int b=2;
								처럼 두줄로 작성 가능*/
			int result; // 선언문
			result = a + b;
			System.out.println(a+"+"+b+ "\b" +"="+result);
			
			float c= 1.0f, d=2.0f;
			double result1;
			result1 = c + d;
			System.out.println(result1);
		 
	}

}
