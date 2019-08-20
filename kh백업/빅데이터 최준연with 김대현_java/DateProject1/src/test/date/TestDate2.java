package test.date;

import java.util.Random;

/**
 * 
 * @author ���ؿ�
 *�������� ���α׷� + �ð�,���,�̸� �߰�
 *1. ��¥�� ǥ���� ��ü �����
 *-----------------------
 *����
 *1. ������ ��¥ : ���� 2018�� 7�� 4�� ������ (���� ?�� ?��, ���ߴ޷�....) -> 2018�� 7�� 4�� ������ : �𵨸�
 *2. ��, ��, �� -> ����
 *3. ....�Լ�
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
public class TestDate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �߻�ȭ �۾��� �ȵǾ� ������ ������ ������ ������ ����� ������ �ǹ̸� ����� �� ����
		// 1. �߻�ȭ �۾� : ��¥�� Date Ŭ���� ����
	      // myBrithDay, moterBirthDay, fatherBirthDay.....
		// 2. ��ü����� : ������ ��ü�� ����� ������ ������ ����
		   Date myBirthDay = new Date();
		   myBirthDay.setYear(1994);
		   myBirthDay.setMonth(10);
		   myBirthDay.setDay(12);
		   myBirthDay.print();
		   
		   // �ܰ��� ����...
		   Date motherBirthDay = new Date(2000, 1, 31);
//		   motherBirthDay.setYear(2018);
		   motherBirthDay.setMonth(2);
//		   motherBirthDay.setDay(-15);
		   motherBirthDay.print();
		   
		   Appoint myAppoint;
		   myAppoint = new Appoint();
		   myAppoint.print();
		   
		   Date[] d = new Date[2];
		   d[0] = new Date();
		   d[1] = new Appoint();
		   for (int i = 0; i < d.length; i++) {
			   d[i].print();
		   }		   
//		   ��ӽð��� �ñ��ϴ�
//		   System.out.println(d[1].getHour());
//		   Appoint a = (Appoint) d[1];
//		   System.out.println(a.getHour());
		   Appoint a1;
		   for (Date date : d) {
			   //instanceof : Runtime type check ��������
			   if (date instanceof Appoint) {
				   a1 = (Appoint) date;
				   System.out.println(a1.getHour());
			}
		}
		   
		   Date[] appoint = new Date[5];
		   Random ran = new Random();
		   for (int i = 0; i < d.length; i++) {
			   int random = ran.nextInt();
			   // int random = (int) (Math.random()*2); //*2, +2, (+2)*100
			   // API���� random���� ã�� method�� ã�� � ���� 81�� ������
			   // � ���� 83�� ������ ������� �ϼ���.
			   // ��Ʈ : �̸��� �� ��� API���� Index�� ã�´�.
			   boolean condition = (random % 2) == 0; 
			   if (condition) {
				   d[i] = new Date();
			} else {
				   d[i] = new Appoint();
			}
		
		   }		   
		   Appoint a2;
		   for (Date date : d) {
			   //instanceof : Runtime type check ��������
			   if (date instanceof Appoint) {
				   a2 = (Appoint) date;
				   System.out.println(a2.getHour());
			}
		}
	}

}
