package test.data;
/**
 * 
 * @author ���ؿ�
 * ���� : ��Ʈ�����ڸ� ���� �� ������ ������� �˾ƺ���
 *
 */
public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(118+" �� 2�� �ڵ� = " + Integer.toBinaryString(118));
		System.out.println(15+" �� 2�� �ڵ� = " + Integer.toBinaryString(15));
		System.out.println("118&15�� ��� ���� " + Integer.toBinaryString(118&15));   // 1&1 �̸� 1, �ϳ��� �ٸ��� 0
		System.out.println("118|15�� ��� ���� " + Integer.toBinaryString(118|15));   // �ϳ��� 1�̸� 1
		System.out.println("118^15�� ��� ���� " + Integer.toBinaryString(118^15));   // �ΰ��� ���� �޶�� 1
		System.out.println("!118�� ��� ���� " + Integer.toBinaryString(~118));		  // 1�� 0���� 0�� 1��
		System.out.println("!15�� ��� ���� " + Integer.toBinaryString(~15));		  // 1�� 0���� 0�� 1��
	}

}
