package test.data;

/**
 * 교과서 3-24
 * 다운 캐스팅(reference conversion) 
 * 설명 :
 * 1. Vector 라는 남에 집 아이 함수의 객체를 만든다.
 * 2. Vector 안에 String 객체를 집어 넣는다
 * 3. Vector 에 넣은 요소(element)중에 첫번째 요소를 꺼내서 출력해본다.
 * 
 */
import java.util.Vector;

public class Example7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.Vector v = new java.util.Vector();
		Vector v = new Vector(); // Vector는 element(요소)를 가질 수 있는 배열같은 존재
		String s1 = new String("Hello World");
		v.add(s1);
		String s2 = (String) v.elementAt(0);
		System.out.println(s2);
		//Ctrl+Shift+O = import 단축키   =>  import가 하는 역할이 뭔가요 ==> 남에 집 아이를 우리집 아이로 만들기 위해 import(수입)하는 것
		
		int a = 0;
		a = ++a;
		System.out.println(a);
	}

}
