package c0716.extra;

public class MainStringEquals {

	public static void main(String[] args) {
		String str1 = "Hello World !!!";
		System.out.println("str1=[" + str1 + "]");
		
		System.out.println("str1.length()=[" + str1.length() + "]");
		
		System.out.println("str1.charAt(1)=[" + str1.charAt(1) + "]");
		
		System.out.println("str1.substring(0, 2) = [" + str1.substring(0, 2) + "]" );
		
		String str2 = " Good Morning ";
		System.out.println("\nstr2=[" + str2 + "]");
		//trim()
		//String ��, �� space�� ����
		System.out.println("str2.trim()=[" + str2.trim() + "]");
		
		// ��ҹ��� �����ϸ鼭 ��
		String str3 = "Water";
		String str4 = "WATER";
		if (str3.equals(str4)) {
			System.out.println("str3.equlas(str4)=[true]");
		} else {
			System.out.println("str3.equlas(str4)=[false]");
		}
		
		//equalsIgnoreCase() : ��ҹ��� �������� �ʰ� ��
		if (str3.equalsIgnoreCase(str4)) {
			System.out.println("str3.equlasIgnoreCase(str4)=[true]");
		} else {
			System.out.println("str3.equlasIgnoreCase(str4)=[false]");
		}
		
		/*  ==�� .equlas()�� ��
		int intVal1 = 10;
		int intVal2 = 10;
		System.out.println("========int=========");
		System.out.println(intVal1 == intVal2); //true, false
		
		String s1 = "hello";
		String s2 = new String("hello");
		
		System.out.println("--------- String -------------");
		System.out.println(s1 == s2);
		System.out.println("--------- String : equals() -------------");
		System.out.println(s1.equals(s2));
		*/
	}

}
