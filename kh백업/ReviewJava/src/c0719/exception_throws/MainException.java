package c0719.exception_throws;

public class MainException {

	public static void main(String[] args) {
		//Service 클래스에서 throws한 문제를 호출한 MainException에서 처리하는 것.
		System.out.println("Main.main()::Start");
		try {
			Service s = new Service();
			s.method();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\n\t---Exception Handling in Service");
		}
		
		System.out.println("Main.main()::End");

	}

}
