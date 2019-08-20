package test.data;
/**
 * 
 * @author 최준연
 * 설명 : 
 * 1. 정수의 기본형은 int 타입으로 byte를 연산할 때 캐스팅해주지 않으면 오류가 생긴다.
 * 2. 기본형인 double로 변환하여 연산하고 다시 float형으로 변환되므로 오류가 발생하지 않는다.
 * 3. 그냥 String과 new String의 차이는 객체를 생성하느냐 안하느냐의 차이로 데이터값을 단순히 연산자(==)로 비교하게 되면
 * 	    주소값과 데이터를 인식하여 이를 다르게 보고 .equals를 사용하면 주소값이 아닌 순수한 데이터만을 비교하게 되므로 같다는 결과가 나온다.
 * 4. ~ 는 0을 1로, 1을 0으로 바꾸는 비트연산자.
 * 5. 인트로 캐스팅 후 더한 결과와 더블을 더한 후 인트로 캐스팅한 결과를 비교하면 각각 8과 9가 나온다.
 */
public class TypeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 21; //선언할 때 값을 대입하면 byte값으로 들어간다.
		byte b2 = 2;
		byte b3 = (byte) (b + b2);
//		short s = 21478364;
		int i = 21478364;
		long l = 21478364;
		float f = 0.12345F;
		float f2 = 0.9876F;
		float result = f + f2; //기본형인 double로 변환하여 연산하고 다시 float형으로 변환된다.
		System.out.println(result);
		
		String s = "acbd";
		String s1 = new String("efg");
		String s2 = s + s1;
		String s3 = new String(s2);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		
		if (s2 == s3) { // 순수한 데이터 값을 비교하는 것이 아닌 박스의 여부까지 따지는 것으로 다르다고 나오는 것이다.
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		if (s2.equals(s3)) { // 순수하게 박스 안에 들어있는 데이터값을 비교하는 것이기 때문에 같다고 나오는 것이다.
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		byte by1 = 3;
		by1 = (byte) -by1;
		int ii = -by1;
		byte by2 = 4;
		byte by3 = (byte) (by1 + by2);
		by3 = (byte) (by3 + 1);
		by3++; //by3 = by3 + 1;
		
		l = -1;
		l = ~l;
		System.out.println(l);
		
		double d1 = 3.5;
		double d2 = 5.5;
		int iResult = (int) d1 + (int)d2;
		System.out.println(iResult);
		iResult = (int) (d1 + d2);
		System.out.println(iResult);
		
//		int[] iArray = {3}; //값이 3이 있는 것
		int[] iArray = new int[3]; //3자리가 있는 것
		Object o = iArray; //배열형에서 Object형으로 형 변환
		
		
	}

}
