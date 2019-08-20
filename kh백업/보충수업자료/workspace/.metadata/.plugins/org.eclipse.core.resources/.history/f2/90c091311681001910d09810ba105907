package exception.ex.controller;

import exception.ex.model.vo.Customer;
import exception.ex.model.vo.KHBar;

public class Controller {

	private Customer[] cus = { 
			new Customer("홍길동", 19, 'M', "실버"), 
			new Customer("신사임당", 22, 'F', "브론즈"),
			new Customer("안중근", 15, 'M', "골드"), 
			new Customer("장영실", 21, 'M', "VIP"), 
			new Customer("정우성", 30, 'M', "골드"),
			new Customer("김혜수", 29, 'F', "VVIP") };

	// 탑승자를 넣을 객체배열
	private Customer[] on = new Customer[KHBar.PERMITNUMBER];

	public Controller() {
	}

	public void entrance() {
		int count = 0;

		try {
			for (int i = 0; i < cus.length; i++) {
				if (cus[i].getAge() >= KHBar.CUTAGE) {
					on[count] = cus[i];
					count++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// 익셉션 코드 ctr눌러서 확인해보면 index가 매개변수로 넘어가서 등록이 되는거 확인된다.
			// 어레이인덱스오브바운즈 -> 인덱스오브바운즈 -> 런타임익셉션 -> 익셉션 -> throwable 까지 올라간다.
			System.out.println("문제가 발생한 해당 배열의 인덱스 번호 : " + e.getMessage());
		} finally {
			System.out.println("---이번 입장 손님 명단---");
			for (Customer g : on) {
				System.out.println(g);
			}
		}

	}

}
