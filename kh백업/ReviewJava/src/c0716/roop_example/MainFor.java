package c0716.roop_example;

public class MainFor {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("i = [" + i + "]");
			sum += i;
		}
		System.out.println("sum = [" + sum + "]" );
	}

}
