package c0719.exception_throws;

public class Service {
								//�ؿ� Exception���� �ٲ㵵 ������� �ǰ���?
								//��. ������� MainException���� catch�� ������ Ÿ���� Exception����
								//��������� �մϴ�.
	public void method() throws ArrayIndexOutOfBoundsException {
		System.out.println("\tService.method()::Start");

		String[] stringArray = { "A", "B" };
		int stringArrayLength = stringArray.length;
		for (int i = 0; i < stringArrayLength + 1; i++) {
			System.out.print("\tService.method()::");
			System.out.println("stringArray[" + i + "]=[" + stringArray[i] + "]");
		}
		System.out.println("\tService.method()::End");

	}

}
