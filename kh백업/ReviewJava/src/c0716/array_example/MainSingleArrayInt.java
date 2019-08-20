package c0716.array_example;

public class MainSingleArrayInt {

	public static void main(String[] args) {
		// int[] intArray = new int[2]; //7~8번을 한줄로 작성한 것
		int[] intArray;
		intArray = new int[2];

		intArray[0] = 1;
		intArray[1] = 2;

		System.out.println(intArray[0]);
		System.out.println(intArray[1]);

		int arrayLength = intArray.length;
		System.out.println("arrayLength = [" + arrayLength + "]");

		for (int i = 0; i < intArray.length; i++) {
			System.out.println("intArray[" + i + "]");
			System.out.println(intArray[i]);
		}
	}

}
