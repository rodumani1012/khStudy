package c0719.exception;

public class MainMultiExceptionInheritance {

	public static void main(String[] args) {
		//���� Exception ó��
		String[] stringArray = {"A", "B"};
		try {
			// NullPointerException �� ó���ؾ� ������ ���� Ŭ������ Exception���� ó���ϴ� ���
			String str = null;
			str.charAt(5);
			
			// ArrayIndexOutOfBoundsException �� ��� �ڱ� ������ �ذ��� �� ������ �ڱⰡ �ذ��Ѵ�.
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
