package test.encap;
/**
 * 
 * @author ���ؿ�
 * ���� : 
 * 1. �̸��� ���̸� String�� int�� �ʱ�ȭ�ϰ� ��ü�� �����.
 * 2. getter&setter�� ���� ���� ����غ���.
 * 2-1. �����ڿ� �ʱⰪ�� �־ ����غ���.
 * 2-2. ������ �����ε��� ���� ���� �Է��Ͽ� ����غ���.
 */
public class EncapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Encap e = new Encap();
		e.setName("ȫ�浿");
		e.setAge(10);
		System.out.println(e.getName() + " : " + e.getAge());
		
		Encap e1 = new Encap("����", 30);
		e1.print();
		e1.setAge(40);
		e1.print();
		
		Encap e2 = new Encap();
		e2.print();
		
	}

}
