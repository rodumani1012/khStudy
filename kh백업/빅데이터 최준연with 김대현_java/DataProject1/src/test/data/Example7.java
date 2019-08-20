package test.data;

/**
 * ������ 3-24
 * �ٿ� ĳ����(reference conversion) 
 * ���� :
 * 1. Vector ��� ���� �� ���� �Լ��� ��ü�� �����.
 * 2. Vector �ȿ� String ��ü�� ���� �ִ´�
 * 3. Vector �� ���� ���(element)�߿� ù��° ��Ҹ� ������ ����غ���.
 * 
 */
import java.util.Vector;

public class Example7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		java.util.Vector v = new java.util.Vector();
		Vector v = new Vector(); // Vector�� element(���)�� ���� �� �ִ� �迭���� ����
		String s1 = new String("Hello World");
		v.add(s1);
		String s2 = (String) v.elementAt(0);
		System.out.println(s2);
		//Ctrl+Shift+O = import ����Ű   =>  import�� �ϴ� ������ ������ ==> ���� �� ���̸� �츮�� ���̷� ����� ���� import(����)�ϴ� ��
		
		int a = 0;
		a = ++a;
		System.out.println(a);
	}

}
