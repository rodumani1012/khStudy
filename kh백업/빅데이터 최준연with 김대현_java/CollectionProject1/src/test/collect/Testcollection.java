package test.collect;

import java.util.ArrayList;
import java.util.HashSet;

public class Testcollection {

	public static void main(String[] args) {
		int[] lastDayOfMonth 
		= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// ArrayList 사용 -index
		// <E>, <T> : Generuc type -> 해당하는 값의 데이터타입을 명확히 지정하는 것
		ArrayList <Integer> list = new ArrayList();
		for (int i : lastDayOfMonth) {
			list.add(i); //list.add(""); => Generic type이 Integer이므로 String은 안됨.
		}
//		list.add(lastDayOfMonth[0]); foreach문으로 12개의 배열을 간략화
//		list.add(lastDayOfMonth[1]);
//		...............
//		list.add(lastDayOfMonth[10]);
//		list.add(lastDayOfMonth[11]);
		System.out.println("list size = " + list.size());
		System.out.println("2월의 마지막날은 " + list.get(1) + "일입니다.");
		//2000년의 2월의 마지막 날은 29일 입니다.
		list.remove(1);
		list.add(1, 29);
		System.out.println("2000년의 2월 마지막날은 " + list.get(1) +  "일입니다.");
		//HashSet 사용 - 중복을 걸려줌, 그러나 순서는 뒤죽박죽
		HashSet<Integer> set = new HashSet(list);
		System.out.println("set size = " + set.size());
//		int[] otherArray = set.toArray(otherArray);
		//배열 사용 - 저장이 목적
		Integer[] otherArray = new Integer[set.size()];
		set.toArray(otherArray); //set을 배열로 바꿔서 otherArray에 저장한다.
		for (int object : otherArray) { //otherArray의 elements만큼 object에 대입해서 순차적으로 syso한다.
			System.out.println(object);
		}
	}

}
