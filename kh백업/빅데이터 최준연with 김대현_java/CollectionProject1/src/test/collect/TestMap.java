package test.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		int[] lastDayOfMonth 
		= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		HashMap map = new HashMap();
		map.put("1��", 31);		map.put("2��", 28);
		map.put("3��", 31);		map.put("4��", 30);
		map.put("5��", 31);		map.put("6��", 30);
		map.put("7��", 31);		map.put("8��", 31);
		map.put("9��", 30);		map.put("10��", 31);
		map.put("11��", 30);		map.put("12��", 31);
		
		System.out.println("map size = " + map.size());
		System.out.println("2���� ���������� " + map.get("2��") + "���Դϴ�.");
		//2000���� 2���� ������ ���� 29�� �Դϴ�.
		map.remove("2��");
		map.put("2��", 29);
		System.out.println("2000���� 2�� ���������� " + map.get("2��") +  "���Դϴ�.");
		//HashSet ��� - �ߺ��� �ɷ���
		Set<String> keys = (Set<String>) map.keySet();
		for (String month : keys) {
			System.out.println(month + "�� ���������� " + map.get(month));
		}
	}

}
