package test.data;
/**
 * ������ 4-4
 * @author ���ؿ�
 * �������� �������� ���Ͽ� �˾ƺ����� ����.
 * ������ ������ ���� 2���� ������ ���� �ΰ��� ���� ���� 1���� �����.
 * syso�� +�� ������ ���� �ͺ��� �ӵ��� ���� StringBuffer�� ����Ѵ�.
 * ++i ������ ���� ���� �����ϰ� i++�� �����Ǳ� �� ���� ���� �����Ѵ�.
 * 
 */
public class IncDecOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10, j = 5, k;
		k = ++i + j--;
		System.out.println("1�� ���� => " + "i = " + i + ", j = " + j + ", k = " + k);
		//StringBuffer�� ���� "1�� ���� => " + "i = " + i + ", j = " + j + ", k = " + k ���� ��ü ������ ���� �ӵ��� �ξ� ������.
		StringBuffer sb = new StringBuffer();
		sb.append("i=").append(i).append(", j=").append(j).append(", k=").append(k);
		System.out.println(sb.toString());
//		System.out.println(new StringBuffer().append("i=").append(i).append(", j=").append(j).append(", k=").append(k).toString());
		//�� 3���� �� �ٷ� ���� ��
		k = i-- + --j;
		System.out.println("2�� ���� => " +"i = " + i + ", j = " + j + ", k = " + k);
		
		System.out.println("3�� ���� => " +"i = " + ++i + ", j = " + j-- + ", i = " + --i + ", j = " + --j);
	}

}
