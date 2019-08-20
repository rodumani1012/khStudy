package c0719.exception;

import c0717.scanner.Coffee;

public class MainUncheckedException2 {

	public static void main(String[] args) {
		//java.lang.ArithmeticException
		int i = 10;
		int j = 0;
		int result = i/j;
		
		//java.lang.NullPointerException
		Coffee c = null;
		c.getName();
		

	}

}
