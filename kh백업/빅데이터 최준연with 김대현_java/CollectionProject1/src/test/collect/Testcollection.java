package test.collect;

import java.util.ArrayList;
import java.util.HashSet;

public class Testcollection {

	public static void main(String[] args) {
		int[] lastDayOfMonth 
		= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// ArrayList ��� -index
		// <E>, <T> : Generuc type -> �ش��ϴ� ���� ������Ÿ���� ��Ȯ�� �����ϴ� ��
		ArrayList <Integer> list = new ArrayList();
		for (int i : lastDayOfMonth) {
			list.add(i); //list.add(""); => Generic type�� Integer�̹Ƿ� String�� �ȵ�.
		}
//		list.add(lastDayOfMonth[0]); foreach������ 12���� �迭�� ����ȭ
//		list.add(lastDayOfMonth[1]);
//		...............
//		list.add(lastDayOfMonth[10]);
//		list.add(lastDayOfMonth[11]);
		System.out.println("list size = " + list.size());
		System.out.println("2���� ���������� " + list.get(1) + "���Դϴ�.");
		//2000���� 2���� ������ ���� 29�� �Դϴ�.
		list.remove(1);
		list.add(1, 29);
		System.out.println("2000���� 2�� ���������� " + list.get(1) +  "���Դϴ�.");
		//HashSet ��� - �ߺ��� �ɷ���, �׷��� ������ ���׹���
		HashSet<Integer> set = new HashSet(list);
		System.out.println("set size = " + set.size());
//		int[] otherArray = set.toArray(otherArray);
		//�迭 ��� - ������ ����
		Integer[] otherArray = new Integer[set.size()];
		set.toArray(otherArray); //set�� �迭�� �ٲ㼭 otherArray�� �����Ѵ�.
		for (int object : otherArray) { //otherArray�� elements��ŭ object�� �����ؼ� ���������� syso�Ѵ�.
			System.out.println(object);
		}
	}

}
