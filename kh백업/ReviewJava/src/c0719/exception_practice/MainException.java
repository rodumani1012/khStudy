package c0719.exception_practice;

public class MainException {

	public static void main(String[] args) {
		
		System.out.println("Main.main()::Start");
		
		Service s = new Service();
		s.method();
		
		System.out.println("Main.main()::End");

	}

}
