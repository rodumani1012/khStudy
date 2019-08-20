package c0716.array_example;

public class MainSingleArrayString {

	public static void main(String[] args) {
		String[] stringArray = new String[3];
		
		stringArray[0] = "Hello";
		stringArray[1] = "Java";
		stringArray[2] = "Brain";
		
		System.out.println(stringArray[0]);
		System.out.println(stringArray[1]);
		System.out.println(stringArray[2]);
		
		int arrayLength = stringArray.length;
		System.out.println("arrayLength=[" + arrayLength + "]");
		for (int i = 0; i < stringArray.length; i++) {
			System.out.println("stringArray[" + i + "] = " + stringArray[i]);
		}

	}

}
