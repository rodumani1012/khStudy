package test.icecream;
/**
 * 
 * @author ���ؿ�
 *���� : �ɺθ�
	���� : 300��¥�� XX�ٸ� �ؿ� ���̽�ũ�� ���Կ� ���� ��ͼ� �����ְ� �Ѵ�.
	1. ������ �����տ� 300���� ����ش�.
	1-1. right = 300;
	2. ���̽�ũ�� ������ ��ġ�� �˷��ش�
	2-2. Supermarket cu;
	3. ���̰� ���̽�ũ�� ���� �������� �ٹ�ٸ� �޶�� �䱸�Ѵ�.
	3-1. cu.getIceCream(right);
	4. ���̽�ũ�� ���� ������ ������ �޼տ� �ٹ�ٸ� ����ش�.
	4-1. left = [3-1] -> ���� ���� : ������ �õ����� �ٹ�ٸ� ���� �� ���������� �ش�.
	5. ������ �޼տ� �ִ� �� �����޶�� �Ѵ�.
	5-1. System.out.print(left);
 */
public class TestIceCream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int right = 300;
		Supermarket cu = new Supermarket();
		String left = cu.getIceCream(right);
		System.out.print(left);
	}

}
