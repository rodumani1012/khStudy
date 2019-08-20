package class10_class.ep01_calssdesign.message;

public class MainMessage {

	public static void main(String[] args) {

		Message m1 = new Message(); // 객체(Object) 생성. m1은 참조변수(Reference Variable)
		m1.sayHello();// 참조변수를 이용하여 객체의 메소드 호출
		m1.sayWorld();
		m1.sayMesssage("Welcome");	//입력 값 전달

	}

}
