package test.loop;
/**
 * 
 * @author ���ؿ�
 * ���� : 
 * �迭 ����(System.arraycopy)�� ���� ���ڸ� �Է��Ͽ� ����غ���.
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] oldAry = {'J', 'a', 'v', 'a', '_'};
		int[] newAry = {'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'};
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);  // oldAry�� 0��° ��Ҹ� oldAry�� ���̸�ŭ newAry�� 0��°���� ����ִ´�.
		for (int i = 0; i < newAry.length; i++) {
			System.out.print((char)newAry[i]);
		}
		
	}
}
