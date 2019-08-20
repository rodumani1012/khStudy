package c0716.array_example;

public class MainArrayInitializeInt {

	public static void main(String[] args) {
		int[] intArray1 = new int[2];
		intArray1[0] = 10;
		intArray1[1] = 20;
		for (int i = 0; i < intArray1.length; i++) {
			System.out.println("intArray1[" + i + "]");
			System.out.println(intArray1[i]);
		}
		
		System.out.println();
		
		int[] intArray2 = {10, 20};
		for (int i = 0; i < intArray2.length; i++) {
			System.out.println("intArray2[" + i + "]");
			System.out.println(intArray2[i]);
		}
		
	}

}
