package c0718.test;

import java.util.ArrayList;

public class MainMyReturn {

	public static void main(String[] args) {
		MyReturn mr = new MyReturn();
		mr.getVoid();
		int returnInt = mr.getInt();
		System.out.println("returnInt=[" + returnInt + "]");
		boolean returnBoolean = mr.getBoolean();
		System.out.println("returnBoolean=[" + returnBoolean + "]");
		String returnString = mr.getString();
		System.out.println("returnString=[" + returnString + "]");
		
		Coffee returnCoffee = mr.getCoffee();
		returnCoffee.printInfo();
		
		ArrayList<Coffee> returnCoffeeList = mr.getCoffeeList();
		for (int i = 0; i < returnCoffeeList.size(); i++) {
			Coffee c = returnCoffeeList.get(i);
			System.out.print((i + 1) + ". ");
			c.printInfo();
		}
	}

}
