package test.encap;
/**
 * 
 * @author 최준연
 * 설명 : 
 * 1. 이름과 나이를 String과 int로 초기화하고 객체를 만든다.
 * 2. getter&setter를 통해 값을 출력해본다.
 * 2-1. 생성자에 초기값을 넣어서 출력해본다.
 * 2-2. 생성자 오버로딩을 통해 값을 입력하여 출력해본다.
 */
public class EncapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encap e = new Encap();
		e.setName("홍길동");
		e.setAge(10);
		System.out.println(e.getName() + " : " + e.getAge());
		
		Encap e1 = new Encap("장길산", 30);
		e1.print();
		e1.setAge(40);
		e1.print();
		
		Encap e2 = new Encap();
		e2.print();
		
	}

}
