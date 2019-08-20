package test.date;
/**
 * 
 * @author ���ؿ�
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
public class Appoint extends Date {
	private int hour = 11; //�ð�
	private String place = "�б�";//���
	private String name = "��浿"; //���� ����̸�
	public Appoint() {
		super();
		hour = 11;
		place = "��";
		name = "��Ӵ�";
	}
	public Appoint(int year, int month, int day, int hour, String place, String name) {
		super(year, month, day);
		this.hour = hour;
		this.place = place;
		this.name = name;
	}
	public int getHour() {
		return hour;
	}
	public String getPlace() {
		return place;
	}
	public String getName() {
		return name;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "�������============\n"
				+ "[����: " + super.toString()
				+ "]\n[�ð� : " + hour + "��]\n[��� : " + place + "]\n[��� : " + name + "]"
				+ "\n=================";
				
	}
//	@Override
//	public void print() {
//		System.out.println(this.toString());
//	}
	
	
}
