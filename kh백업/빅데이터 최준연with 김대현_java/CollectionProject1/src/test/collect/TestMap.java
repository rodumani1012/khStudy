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
		map.put("1월", 31);		map.put("2월", 28);
		map.put("3월", 31);		map.put("4월", 30);
		map.put("5월", 31);		map.put("6월", 30);
		map.put("7월", 31);		map.put("8월", 31);
		map.put("9월", 30);		map.put("10월", 31);
		map.put("11월", 30);		map.put("12월", 31);
		
		System.out.println("map size = " + map.size());
		System.out.println("2월의 마지막날은 " + map.get("2월") + "일입니다.");
		//2000년의 2월의 마지막 날은 29일 입니다.
		map.remove("2월");
		map.put("2월", 29);
		System.out.println("2000년의 2월 마지막날은 " + map.get("2월") +  "일입니다.");
		//HashSet 사용 - 중복을 걸려줌
		Set<String> keys = (Set<String>) map.keySet();
		for (String month : keys) {
			System.out.println(month + "의 마지막날은 " + map.get(month));
		}
	}

}
