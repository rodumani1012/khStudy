package test.date;

import java.util.ArrayList;

/**
 * 
 * @author ���ؿ�
 * ���� :  
 * �߻�ȭ
 * 1. � data�� �ʿ���? => ��, ��, ��
 * 2. �̷� �����͵��� ����� �η��? => ��¥(Date) ��� ����
 * 2-1 class Date {
 * 		int	 year = 2018;
 * 		int	 month= 7;
 * 		int	 day  = 6;
 *	   }
 *
 * ����ȭ
 * 1. data�� ����� ���� => private
 * 2. getter/setter
 * 3. ������ <- ��ü �ʱ�ȭ
 * 3-1 ��ӵ� data��  => inheritance method �Ǵ� super()
 * 4. toString() 
 */
public class Date {
//member variable ���� : �ڵ����� �ʱ�ȭ �ǹǷ� �ʱⰪ�� ������ص� �ȴ�.
	private int year; //�ʱ�ȭ�� �����൵ �ǰ� �Ƚ����൵ �ȴ�.  ex) int year = 2018;
	private int month;
	private int day;
//	private int[] lastDayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private ArrayList<Integer> lastDayOfMonth = new ArrayList<>();
	// overloading Constructor : ������ - ��ü �ʱ�ȭ
	public Date() {	this(2002, 2, 14);	} //this ������ ���
	
	public Date(int year, int month, int day) {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
		lastDayOfMonth.add(31);		lastDayOfMonth.add(28);
		lastDayOfMonth.add(31);		lastDayOfMonth.add(30);
		lastDayOfMonth.add(31);		lastDayOfMonth.add(30);
		lastDayOfMonth.add(31);		lastDayOfMonth.add(31);
		lastDayOfMonth.add(30);		lastDayOfMonth.add(31);
		lastDayOfMonth.add(30);		lastDayOfMonth.add(31);		
	}
	@Override
	public String toString() {
		return year + "�� " + month + "�� " + day + "��";
	}
	//method ����
	public void print() {
		System.out.println(this);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
		setDay(day);
	}
	/**
	 * ���� : ��¥ �� ���� �ش��ϸ� 1 ~ 12 ������ ���� ������.
	 * 		1�̸��̳� 12 �ʰ��� ���� ���� ��� 1 �Ǵ� 12�� ������ �����Ѵ�.
	 * @param month : 1 <= month <= 12������ ���� ����
	 * 				   �������� ���� ��� 1��, Ŭ ���� 12�� ����
	 */
	public void setMonth(int month) {
		if (month < 1) {
			month = 1;
		} else if (month > 12) {
			month = 12;
		}
		this.month = month;
		setDay(day);
//		this.month = (this.month<=1)? month=1:((this.month>=12)? month=12: month);
			
		
	}

	public void setDay(int day) {
		checkLunar();
		if (day < 1) {
			day = 1;
		} else if (day > lastDayOfMonth.get(month-1)) {
			day = lastDayOfMonth.get(month-1);  // -1�� �ϴ� ������ ����� 1�� 2�� 3��... ������ ��ǻ�ʹ� 0�� 1�� 2�� .. ���̱� �����̴�
											// �� ������� 1���� ��ǻ�Ϳ��� 2���� �����ְ� �ִ� ���̴�.
		}
		this.day = day;
	}
	private void checkLunar() {
		//��� 1. if else
//		if (year % 4 == 0) {
//			if (year % 100 == 0) {
//				if (year % 400 == 0) { //400���� ������
//					lastDayOfMonth[1] = 29;
//				}else //������ 100���� ���������� 400���δ� �������� ����
//					lastDayOfMonth[1] = 28;
//			}else // ������ 4�� ���������� 100���� �������� ����
//				lastDayOfMonth[1] = 29;
//		}else // ������ 4�� �������� ����
//			lastDayOfMonth[1] = 28;
		
		//��� 2. if else�� ������
//		if ((year%4 == 0)&&(year%100 != 0)||(year%400 ==0))
//			lastDayOfMonth[1] = 29;
//		else //else if ((year%4 != 0) || (year%100 == 0)&&(year%400 != 0))
//			lastDayOfMonth[1] = 28;
		
		//���� ���� ��� 3. ���׿�����
		lastDayOfMonth.remove(1);
		lastDayOfMonth.add(1, (((year%4 == 0 )&&(year%100 != 0)||(year%400 == 0)) ? 29 : 28));
		
		
	}
}
