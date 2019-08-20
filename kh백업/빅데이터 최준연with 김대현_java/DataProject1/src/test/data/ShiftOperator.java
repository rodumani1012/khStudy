package test.data;
/**
 * 
 * @author 최준연
 * 설명 : int 호환 타입인 byte를 이용하여 코드값과 연산 결과를 알아보는 과정.
 * 
 *
 */
public class ShiftOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 01, 011 -> 8진수, 0x10, 0xFF -> 16진수     // 앞에 0이 붙어있으면 8진수, 0x가 붙어있으면 16진수
		byte x = (byte) 0x0a, y = (byte) 0x48, z = (byte) 0xcc; // x = 10, y = 4x16+8 = 72, z = 12x16+12 = 204
		
		System.out.println(0x0a+" 의 2진 코드 = " + Integer.toBinaryString(0x0a));
		System.out.println(0x48+" 의 2진 코드 = " + Integer.toBinaryString(0x48));
		System.out.println(0xcc+" 의 2진 코드 = " + Integer.toBinaryString(0xcc));
		
			System.out.println("x|y&z=" + (byte)(x|y&z));  //각각 논리 우선순위는 뒤에서 부터이다.
			System.out.println("x|y&~z=" + (byte)(x|y&~z));
			System.out.println("x^y&~z=" + (byte)(x^y&~z));
			x = (byte) 1; y = (byte) -1;
			System.out.println("~x|x=" + (byte)(~x|x));
			System.out.println("x^x=" + (byte)(x^x));
			System.out.println("x<<3=" + (byte)(x<<3));  // 00000001  =>  00001000
			System.out.println("x>>3=" + (byte)(x>>3));  // 00000001  =>  00000000
			System.out.println("x>>>3=" + (byte)(x>>>3));// 00000001  =>  00000000
			System.out.println("y<<3=" + (byte)(y<<3));	 // 11111111  =>  11111000 
			System.out.println("y>>x=" + (byte)(y>>3));  // 11111111  =>  11111111
			System.out.println("y>>>x=" + (byte)(y>>>3));// 11111111  =>  (000111111111111111111111)11111111			
			
	}

}
