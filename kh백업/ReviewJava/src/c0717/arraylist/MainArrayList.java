package c0717.arraylist;

import java.util.ArrayList;

public class MainArrayList {

	public static void main(String[] args) {
		// 선언 및 생성
		ArrayList<String> list = new ArrayList<String>();
		
		// isEmpty() : 데이터가 있느냐 없느냐를 판단 => 비어있으면 true, 차있으면 false
		// size() : length처럼 사이즈 측정, list에선 length가 없고 size가 있음.
		System.out.println("empty=[" + list.isEmpty() + "]");
		System.out.println("size=[" + list.size() + "]");
		
		// Add
		list.add("월");
		list.add("화");
		list.add("수");
		list.add("목");
		list.add("금");
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println("list[" + i + "] = [" + s + "]");
		}
		
	}

}
