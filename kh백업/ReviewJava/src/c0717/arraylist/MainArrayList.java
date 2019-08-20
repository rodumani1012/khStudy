package c0717.arraylist;

import java.util.ArrayList;

public class MainArrayList {

	public static void main(String[] args) {
		// ���� �� ����
		ArrayList<String> list = new ArrayList<String>();
		
		// isEmpty() : �����Ͱ� �ִ��� �����ĸ� �Ǵ� => ��������� true, �������� false
		// size() : lengthó�� ������ ����, list���� length�� ���� size�� ����.
		System.out.println("empty=[" + list.isEmpty() + "]");
		System.out.println("size=[" + list.size() + "]");
		
		// Add
		list.add("��");
		list.add("ȭ");
		list.add("��");
		list.add("��");
		list.add("��");
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println("list[" + i + "] = [" + s + "]");
		}
		
	}

}
