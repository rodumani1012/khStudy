package c0719.exception;

public class MainMultiExceptionInheritance {

	public static void main(String[] args) {
		//다중 Exception 처리
		String[] stringArray = {"A", "B"};
		try {
			// NullPointerException 로 처리해야 하지만 상위 클래스인 Exception으로 처리하는 경우
			String str = null;
			str.charAt(5);
			
			// ArrayIndexOutOfBoundsException 인 경우 자기 선에서 해결할 수 있으면 자기가 해결한다.
			for (int i = 0; i < stringArray.length + 1; i++) {
				System.out.println("stringArray[" + i + "]");
				System.out.println("=" + stringArray[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("------- ArrayIndexOutOfBoundsException------");
			
		} catch (Exception e) {
			System.out.println("--------Exception Handling--------");
			
		} finally {
			System.out.println("finally");
		}

	}

}
