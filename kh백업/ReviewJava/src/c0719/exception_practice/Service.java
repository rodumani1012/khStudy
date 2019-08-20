package c0719.exception_practice;

public class Service {

	public void method() {
		System.out.println("\tService.method()::Start");
		
		try {
			String[] stringArray = {"A", "B"};
			int stringArrayLength = stringArray.length;
			for (int i = 0; i < stringArrayLength + 1; i++) {
				System.out.print("\tService.method()::");
				System.out.println("stringArray[" + i + "]=[" + stringArray[i] + "]");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\n\t---Exception Handling in Service");
		}
		
		System.out.println("\tService.method()::End");

	}

}
