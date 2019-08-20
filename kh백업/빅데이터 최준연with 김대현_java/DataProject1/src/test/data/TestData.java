package test.data;
/**
 * 
 * @author 최준연
 데이터타입테스트
 주제 : 기본형 데이터타입과 String을 테스트해본다.
 내용 : 각 데이터 타입별로 변수를 만들고 기본 연산 및 화면 출력을 하는 프로그램
 절차 : 
 1. 숫자형(정수형) - int:32, long:64, short:16
 1-1 int타입 변수 i를 선언하고 5라는 값을 대입한다.
 1-2 long타입 변수 l를 선언하고 50억라는 값을 대입한다.
 1-3 short타입 변수 s를 선언하고 5이라는 값을 대입한다.
 2. 실수형 - double:64, float:32
 2-1 double타입 변수 d를 선언하고 3.141592라는 값을 대입한다.
 2-2 float타입 변수 f를 선언하고 3.141592이라는 값을 대입한다.
 3. 논리형 - boolean:1 = true/false
 3-1 boolean타입 변수 b를 선언하고 true라는 값을 대입한다.
 4. 문자형 - char:16, 문자열 - String(? : 참조형)
 4-1 char타입 변수 c를 선언하고 'A'이라는 값을 대입한다.
 4-2 String타입 변수 str을 선언하고 "Hello"라는 값을 대입한다.
 5. 데이터기본형 - byte:8
 5-1 byte타입 변수 by를 선언하고 1이라는 값을 대입한다.
 5-2 byte[]타입 변수 buffer를 선언하고 str.getBytes()라는 값을 대입한다. 
 
 0. 각 번호의 마지막에 syso로 출력한다
 *
 */
public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // int타입 변수 i를 선언하고 5라는 값을 대입한다.
		int i; i = 5;
		System.out.println("int : " + i);
		// long타입 변수 l를 선언하고 50억라는 값을 대입한다.
		long l; l = 5000000000L;
		System.out.println("long : " + l);
//		 short타입 변수 s를 선언하고 5이라는 값을 대입한다.
		short s; s=5;
		System.out.println("short : " + s);
//		 double타입 변수 d를 선언하고 3.141592라는 값을 대입한다.
		double d; d=3.141592;
		System.out.println("double : " + d);
//		 float타입 변수 f를 선언하고 3.141592이라는 값을 대입한다.
		float f; f=3.141592F;	//f=(float) 3.141592;
		System.out.println("float : "+f);
//		 boolean타입 변수 b를 선언하고 true라는 값을 대입한다.
		boolean b; b=true;
		System.out.println("boolean : " + b);
//		 char타입 변수 c를 선언하고 'A'이라는 값을 대입한다.
		char c; c = 'A';
		System.out.println("char : "+c);
//		 String타입 변수 str을 선언하고 "Hello"라는 값을 대입한다.
		String str; str="Hello";
		System.out.println("String : " + str);
//		 byte타입 변수 by를 선언하고 1이라는 값을 대입한다.
		byte by; by=1;
		System.out.println("byte : " +by);
//		 byte[]타입 변수 buffer를 선언하고 str.getBytes()라는 값을 대입한다. 
		byte[] buffer; buffer = str.getBytes();
		System.out.println("byte[] : " + buffer);
//		 0. 각 번호의 마지막에 syso로 출력한다
		
		//long l = l + 5;
		l = l + 5; //또는 l = l + i;
		i = (int) (i+l);
		System.out.println("i값은 = " + i); // -> 50억 + 5 = 50억 5를 무리하게 int i에 넣어서 결과 데이터가 손상됨.
		i = i + s; s = (short) (s + i);
				   s = (short) (s + 1);
				   s = (short) (s+s);
				   by = (byte) (by+by);
				   c = (char) (c + c); //short byte char는 연산할 때 int로 변환되기 때문에 규칙에 어긋나므로 c = c+c; 는 오류가 난다.
				   
	   // 곱셈(*, <<)
	   i = 1000000000; i = i*i;
	   System.out.println("10억 * 10억 = " +i);
	   
	   i = 1; i=i<<32; System.out.println("1<<32 -> "+i);
	   		  i=i<<31; System.out.println("1<<31 -> "+i);
	   		  i<<=1; System.out.println("1<<31<<1 -> "+i);
	   		  
	   i = 1; i<<=1; //*2의 결과
	   System.out.println("1<<1 -> "+i);
	   i = 1; i<<=10;
	   System.out.println("1<<10 -> "+i);
	   
	   i = -1; i=i>>33;
	   System.out.println("-1>> 33 -> "+i);
	   
	   i = 1; i=i<<31; System.out.println("1<<31 -> " +i);
	   		  i=i>>31; System.out.println("1<<31>>31 -> " +i);
	   
	   i = 0; int i2 = -1;
	   
	   //논리곱과 논리합
	   int a = 4; int a2 = 2;
	   if((a>a2)||((a2=a)==a));
	   System.out.print("a의 값 = " + a);
	   System.out.println("\t a2의 값 = "+ a2);
	   
	   // 삼항 연산자 : ~의 내용이 
//  	    참이면 앞의 결과값을 대입하고 
//  	   거짓이면 뒤의 결과값을 대입한다.
	   int result = (false) ? 1 : 2;
	   result = (a>a2)? a : a2;
	   System.out.println("result = " +result);
	   
	   
	   /*
	    * 더하기빼기
		주제 : 덧셈 또는 뺄셈 프로그램
		내용 : 두개의 정수와 한개의 연산기호를 입력받아(선언해서 아무 값이나 대입하라)
		       연산기호가 '+'라면 더하기 연산을 한 결과물을 화면에 출력한다.
		       연산기호가 '-'라면 빼기 연산을 한 결과물을 화면에 출력한다.
		절차 : 
		1. 두개의 정수와 한개의 문자를 입력받는다.
		2. 결과변수를 선언한다.
		3. 연산기호가 '+'와 같으면 두수를 + 연산하여 결과변수에 넣는다(대입한다)
		   그렇지 않으면 - 연산하여 결과변수에 넣는다.
		4. 결과변수를 출력한다.
	    */
	   int x, y; x=1; y=2;
	   char op1; op1 = '+';
	   int result1;
	  /* if (op1 == '+') {result1 = x + y;
		
	} else {result1 = x-y;

	}*/ //if else 구문
	   result1 = (op1=='+') ? x+y : x-y; //삼항 연산자 구문
	   System.out.println("결과값 = " + result1);

	   
	   int q, w; q=2; w=3;
	   char op2; op2 = '+';
	   int result2, result3;  result2 = q + w;   result3 = q - w;
	   if (op2=='+'||op2=='-');
	   System.out.println("더한 값 = " +result2);
	   System.out.println("뺀 값 = " + result3);
	   
		
	}
}











