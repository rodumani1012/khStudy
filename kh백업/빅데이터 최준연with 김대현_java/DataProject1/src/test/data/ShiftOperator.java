package test.data;
/**
 * 
 * @author ���ؿ�
 * ���� : int ȣȯ Ÿ���� byte�� �̿��Ͽ� �ڵ尪�� ���� ����� �˾ƺ��� ����.
 * 
 *
 */
public class ShiftOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 01, 011 -> 8����, 0x10, 0xFF -> 16����     // �տ� 0�� �پ������� 8����, 0x�� �پ������� 16����
		byte x = (byte) 0x0a, y = (byte) 0x48, z = (byte) 0xcc; // x = 10, y = 4x16+8 = 72, z = 12x16+12 = 204
		
		System.out.println(0x0a+" �� 2�� �ڵ� = " + Integer.toBinaryString(0x0a));
		System.out.println(0x48+" �� 2�� �ڵ� = " + Integer.toBinaryString(0x48));
		System.out.println(0xcc+" �� 2�� �ڵ� = " + Integer.toBinaryString(0xcc));
		
			System.out.println("x|y&z=" + (byte)(x|y&z));  //���� �� �켱������ �ڿ��� �����̴�.
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
