package c0713.coffee;

public class MainCoffee {

	public static void main(String[] args) {
		Coffee c1 = new Coffee();
		c1.setName("�Ƹ޸�ī��");
		c1.setPrice(4000);
		c1.printInfo();
		
		System.out.println();
		
		Coffee c2 = new Coffee("īǪġ��", 5000);
		c2.printInfo();
	}
		
}
