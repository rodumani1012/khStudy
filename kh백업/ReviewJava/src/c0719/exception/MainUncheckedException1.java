package c0719.exception;

public class MainUncheckedException1 {

	public static void main(String[] args) {
		String[] stringArray = {"Hello", "Java"};
		int stringArrayLength = stringArray.length;
		
		try {
			for (int i = 0; i < stringArrayLength + 1; i++) {
				System.out.print("index=[" + i + "]");
				System.out.println(" value=[" + stringArray[i] + "]");
			}
		} catch (Exception e) {
			System.out.println("-----Exception Handling !!!---------");
		} finally {
			System.out.println("finally");
		}


	}

}
