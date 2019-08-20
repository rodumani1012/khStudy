package c0716.extra;

public class MainCurrentTimeMillis {

	public static void main(String[] args) {
//		currentTimeMillis()
		
		long startTime = System.currentTimeMillis();
		
		int limit = 10000;
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++) {
				for (int k = 0; k < limit; k++) {
					
				}
			}
		}
		long endTime = System.currentTimeMillis();
		
		long elapsedTime = endTime - startTime;
		System.out.println("Total elasped time=[" + elapsedTime + "](ms)");
		System.out.println("Total elasped time=[" + (elapsedTime / 1000.0) + "](sec)");
	}

}
