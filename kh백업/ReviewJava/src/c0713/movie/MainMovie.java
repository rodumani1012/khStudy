package c0713.movie;

public class MainMovie {

	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setTitle("Star Wars : The Force Awakens");
		m1.setCategory("SF");
		m1.setDirector("J.J ���̺귳��");
		m1.setRunningTime(135);
		m1.printInfo();
		
		System.out.println();
		
		Movie m2 = new Movie("SF", "�ƹ�Ÿ");
		m2.setDirector("���ӽ� ī�޷�");
		m2.setRunningTime(162);
		m2.printInfo();
				
		System.out.println();
		
		Movie m3 = new Movie("�� �Ҽ�", "�׼�", "���̾� ��۷�", 135);
		m3.printInfo();
		
	}

}
