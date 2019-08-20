package c0716.array_example;

public class MainArrayCoffee {

	public static void main(String[] args) {
//		Coffee coffee1 = new Coffee("아메리카노", 4000);
//		coffee1.printInfo();
//		System.out.println();
//		Coffee coffee2 = new Coffee("카푸치노", 5000);
//		coffee2.printInfo();
		
		Coffee[] order = new Coffee[2];
		order[0] = new Coffee("아메리카노", 4000);
		order[1] = new Coffee("카푸치노", 5000);
		
		int total = 0;
		System.out.println("************영수증************");
		for (int i = 0; i < order.length; i++) {
			order[i].printInfo();
			int price = order[i].getPrice();
			total += price;
		}
		System.out.println("-----------------------------");
		System.out.println("총 가격 : " + total + "원");
	}

}
