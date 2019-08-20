package c0716.array_example;

public class MainLotto {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		
		System.out.println("로또 번호--------------------");
		for (int i = 0; i < lotto.length; i++) {
			double random = Math.random();
			int randomInt = (int) (random*100);
			lotto[i] = randomInt;
			System.out.print("\t" + lotto[i]);
		}
	}

}
