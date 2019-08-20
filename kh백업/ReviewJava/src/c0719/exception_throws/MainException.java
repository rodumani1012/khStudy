package c0719.exception_throws;

public class MainException {

	public static void main(String[] args) {
		//Service Ŭ�������� throws�� ������ ȣ���� MainException���� ó���ϴ� ��.
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
