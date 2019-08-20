package c0713.message2;

public class MainMessage {

	public static void main(String[] args) {
		Message m1 = new Message("Welcome");
//		m1.setMessage("Hello");
		m1.printInfo();
		System.out.println();
		Message m2 = new Message();
		m2.setMessage("Good");
		m2.printInfo();
	}

}
