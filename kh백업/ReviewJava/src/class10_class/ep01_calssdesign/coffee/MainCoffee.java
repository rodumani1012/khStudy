package class10_class.ep01_calssdesign.coffee;

public class MainCoffee {

	public static void main(String[] args) {

		// Object 1
		Coffee c1 = new Coffee();
		c1.setName("아메리카노"); // 이름
		c1.setPrice(4000); // 가격
		c1.printInfo();

		// Object 2
		Coffee c2 = new Coffee();
		c2.setName("카푸치노");
		c2.setPrice(5000);
		System.out.println();
		c2.printInfo();
	}

}
