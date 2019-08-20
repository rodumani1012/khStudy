package c0713.coffee;

public class MainCoffee {

	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		c1.setName("아메리카노");
		c1.setPrice(4000);
		c1.printInfo();
		
		System.out.println();
		
		Coffee c2 = new Coffee("카푸치노", 5000);
		c2.printInfo();
	}
		
}
