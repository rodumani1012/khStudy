package test.loop;
/**
 * 
 * @author 최준연
 * 설명 : 
 * 배열 복사(System.arraycopy)를 통해 글자를 입력하여 출력해본다.
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] oldAry = {'J', 'a', 'v', 'a', '_'};
		int[] newAry = {'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'};
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);  // oldAry의 0번째 요소를 oldAry의 길이만큼 newAry의 0번째부터 집어넣는다.
		for (int i = 0; i < newAry.length; i++) {
			System.out.print((char)newAry[i]);
		}
		
	}
}
