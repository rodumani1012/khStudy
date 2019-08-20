package c0719.exception_throws;

public class Service {
								//밑에 Exception으로 바꿔도 상관없는 건가요?
								//네. 상관없고 MainException에서 catch의 데이터 타입을 Exception으로
								//수정해줘야 합니다.
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
