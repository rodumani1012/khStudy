package test.date;
/**
 * 
 * @author ���ؿ�
 *�������� ���α׷� �Ϻ�
 *1. ��¥�� ǥ���� ��ü �����
 *-----------------------
 *����
 *1. ������ ��¥ : ���� 2018�� 7�� 4�� ������ (���� ?�� ?��, ���ߴ޷�....) -> 2018�� 7�� 4�� ������ : �𵨸�
 *2. ��, ��, �� -> ����
 *3. ....�Լ� (������ �Լ� ����)
 *4. syso ("2018�� 7�� 4��");
 *5. syso (���� + "��" + �� + "��" + �� + "��");
 *6. ������ -> ����� : year, month, day
 *7. ������ Ÿ�� :      int , int , int
 *8. coding .....
 *8-1 year, month, day�� �����ϰ� �ʱ�ȭ�Ѵ�.
 *8-2 ���� ��¥�� �ش� �� -> �� ������ �����Ѵ�.
 *8-2-1 2018/7/4 => year = 2018; month = 7; day = 4;
 *8-3 �ش� ������ ����Ѵ�.
 *8-3-1 syso(year + "��" + month + "��" + day + "��");
 */
public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 year, month, day�� �����ϰ� �ʱ�ȭ�Ѵ�.
//		 ���� ��¥�� �ش� �� -> �� ������ �����Ѵ�.
//		 2018/7/4 => year = 2018; month = 7; day = 4;
//		  �ش� ������ ����Ѵ�.
//		 syso(year + "��" + month + "��" + day + "��");
		int year = 2018, month = 1, day = 1;
		year = 2018;  month = 7; day = 4;
		System.out.println(year + "�� " + month + "�� " + day + "��");
		

		int [] date = new int[args.length];
		date[0] = Integer.parseInt(args[0]);
		date[1] = Integer.parseInt(args[1]);
		date[2] = Integer.parseInt(args[2]);
		System.out.println(date[0] + "�� " + date[1] + "�� " + date[2] + "��");
		// �߻�ȭ �۾��� �ȵǾ� ������ ������ ������ ������ ����� ������ �ǹ̸� ����� �� ����
		// 1. �߻�ȭ �۾� : ��¥�� Date Ŭ���� ����
	      // myBrithDay, moterBirthDay, fatherBirthDay.....
		// 2. ��ü����� : ������ ��ü�� ����� ������ ������ ����
		   Date myBirthDay = new Date();
		   myBirthDay.print();
		   Date motherBirthDay = new Date();
		   motherBirthDay.print();
		   
		   
	}

}
