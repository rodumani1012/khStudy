package c0713.void_work;

public class MainVoidWork {

	public static void main(String[] args) {
		VoidWork vw1 = new VoidWork();
		// Method Call : Argument - O
		vw1.setCoffeePrice(3000);
		vw1.setHakjum('A');
		vw1.setMarriageYn(true);
		vw1.setMessage("Welcome~~~~");
		
		// Method Call : Argument - X
		vw1.printCoffeePrice();
		vw1.printHakjum();
		vw1.printMarryageYn();
		vw1.printMessage();
		System.out.println();
		vw1.printInfo();
		

	}

}
