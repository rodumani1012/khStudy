package test.inner;
/**
 * ���� : Inner(����) class �����
 * ���� Ŭ������ ����� ����: 
	1. memory�� file�� size�� ���̱� ����
	2. �ڵ��� ���ϴ�
	3. �ٸ� �������� �������� ���� ��ü�̴�.
 * @author ���ؿ�
 * 1. Inner class
 * Ư¡ 1-1 ���� Ŭ���� �տ� private/protected �� �����ϴ�. �ܺ�Ŭ���� member�� method�� ���ο��� �� �� �ִ�.
 * 2. Static Inner
 * Ư¡ 2-1 ����Ŭ�������� ��ü ����/����� ��� ���� ����̴�. 
 * 3. Local Inner
 * Ư¡ 3-1 �ش� method �ȿ����� ����� ���
 * 4. Anonymous class
 * Ư¡ 4-1 In-line class��� ��
 * 	  4-2 �������̽� �Ǵ� �߻�Ŭ������ ��ü�� �ʿ��� ���
 */
public class TestInner {

	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner inner = out.new Inner();
		Outer.StaticInner sInner = new Outer.StaticInner();
		
	}

}

class Outer
{	private int oI = 0; static int sOI = 0;
	static void print(){System.out.println(sOI);}
	public Outer() 
	{	Inner inner = new Inner();
		// Local class ������ ����ǵ��� print(Inner) ȣ��
		print(inner);
	}	
	// Inner class : �ܺ�Ŭ���� member�� method ���ٰ���
	class Inner //private/protected �� �����ϴ�. 
	{	private int iI = 1;
		void print(){System.out.println(iI);}
		Inner(){oI = 10; Outer.this.print();} //this.print();�� ����� Innner�� Outer�� �浹�ϱ� ������
											  //Outer�� �����ϱ� ���� Outer.this.print();�� ���
											  //��, �ܺ�Ŭ������.this ���
	}
	
	// Static Inner : ����Ŭ�������� ��ü ����/����� ��� ��(�ܺ�Ŭ������ �Ȱ��� ��밡��)
	static class StaticInner
	{	private int iI = 1;
		void print(){System.out.println(iI);}
		StaticInner(){Outer.print(); //oI = 10; non-static�̶� �ȵȴ�.}
		}
	}
	// Local Inner : API���� interface/abstract class�� ��ü�� �ʿ�� �ش� method �������� ����� ���
	// Ư¡ 3-1 �ش� method �ȿ����� ����� ���
	void print(Inner in)
	{
		
		class Target extends Thread
		{	public void run() {
				System.out.println("Target class.");
			}
			
		}
		// Thread
		Target target = new Target();
		target.start();
		System.out.println(in);
		
		// Anonimous class
		System.out.println(
					new Object()
					{	public String toString()
						{	return "Anonymous class";
						}
					}.toString()						
				);
	}
}
