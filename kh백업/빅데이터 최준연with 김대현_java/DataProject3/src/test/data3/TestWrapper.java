package test.data3;
/**
 * 
 * @author ���ؿ�
 * ��� Wrapper class ������ ���� �ش� �⺻�� ������ ���� ȣȯ�ȴ�.
 * Integer, Short, Long, Double, Float, Boolean, Character, Byte, String
 *
 */
public class TestWrapper {

	public static void main(String[] args) {
		String s = new String("hello"); // ������ ���
		String s2 = "hello"; 			// �⺻�� ���
		int i = 1;			 			// �⺻��  �� ����
		Integer iI = new Integer(i);	// ������  �� ����
		i %= iI; 						// ��������
		iI = 1;							// ������ = �⺻��
		Double dD = 0.15;
	}

}
