package c0718.test;

import java.util.ArrayList;

public class MyReturn {
	
	public void getVoid() {
		
	}

	public int getInt() {
		int result = 10;
		return result;
	}

	public boolean getBoolean() {
		boolean result = true;
		return result;
	}

	public String getString() {
		String result = "Hello";
		return result;
	}

	public Coffee getCoffee() {
		String name = "아메리카노";
		int price = 2000;
		Coffee result = new Coffee(name, price);
		return result;
	}
	public ArrayList<Coffee> getCoffeeList() {
		
		Coffee c1 = new Coffee("아메리카노", 2000);
		Coffee c2 = new Coffee("라떼", 3000);
		Coffee c3 = new Coffee("카푸치노", 1000);
		
		ArrayList<Coffee> result = new ArrayList<Coffee>();
		result.add(c1);
		result.add(c2);
		result.add(c3);
		
		return result;
	}
}
