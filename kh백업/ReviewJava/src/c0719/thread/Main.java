package c0719.thread;

public class Main {

	public static void main(String[] args) {
//		Work work = new Work();
//		work.run();
		ExtendsThread et = new ExtendsThread();
		et.start(); // �����带 �����ϴ� ��ɾ�
		
		for (int i = 0; i < 1000; i++) {
			System.out.print("|");
		}

	}

}
