package test.addr;
/**
 * 
 * @author 
 *	ArrayList 클래스 작성
	명단 작성
	리스트 뷰에 "이름 : " 공간을 만들어줄 것임.
	add, delete, update 버튼을 
 */
public class TestAddr {

	public static void main(String[] args) {
		ListAdapter adapter = new ListAdapter();
		String name = "홍길동"; String name2 = "임꺽정";
		adapter.insert(name); adapter.insert(name2);
		System.out.println(adapter.select(0));
		System.out.println(adapter.select(1));
		adapter.delete(0); adapter.update(0, "장길산");
		System.out.println(adapter.select(0));
		
		int i = 0;
		for (String str : adapter.all()) {
			System.out.println((++i) + " : " + str);
		}
	}

}
