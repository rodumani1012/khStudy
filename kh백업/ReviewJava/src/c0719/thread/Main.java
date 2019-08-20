package c0719.thread;

public class Main {

	public static void main(String[] args) {
//		Work work = new Work();
//		work.run();
		ExtendsThread et = new ExtendsThread();
		et.start(); // 쓰레드를 실행하는 명령어
		
		for (int i = 0; i < 1000; i++) {
			System.out.print("|");
		}

	}

}
