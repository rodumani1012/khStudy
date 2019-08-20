package test.data3;

public class TestData3 {

	public static void main(String[] args) {
		TestStatic ts;
//		ts.sI = 3; //��ü�� �������� �ʾƼ� ���Ұ�
		TestStatic.sI = 4;
		ts = new TestStatic();
		ts.i = 1; ts.sI = 2;
		System.out.println(ts.sI); // ��ü���� static member
		System.out.println(TestStatic.sI); // Ŭ�������� static member
		//API
		TestStatic.sPrint();
		ts.print();
	}

}

class TestStatic
{
	int i;
	static int sI;
	void print()
	{
		System.out.println("i = " + i + ", " + "sI = " + sI);
	}
	static void sPrint()
	{
		System.out.println("i = " + "non static" + ", " + "sI = " + sI);	
	}
}