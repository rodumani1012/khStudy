package test.icecream;
/**
 * 
 * @author 최준연
 *주제 : 심부름
	내용 : 300원짜리 XX바를 밑에 아이스크림 가게에 가서 사와서 보여주게 한다.
	1. 아이의 오른손에 300원을 쥐어준다.
	1-1. right = 300;
	2. 아이스크림 가게의 위치를 알려준다
	2-2. Supermarket cu;
	3. 아이가 아이스크림 가게 점원에게 바밤바를 달라고 요구한다.
	3-1. cu.getIceCream(right);
	4. 아이스크림 가게 점원은 아이의 왼손에 바밤바를 쥐어준다.
	4-1. left = [3-1] -> 내부 연산 : 점원은 냉동고에서 바밤바를 꺼낸 뒤 누군가에게 준다.
	5. 아이의 왼손에 있는 걸 보여달라고 한다.
	5-1. System.out.print(left);
 */
public class TestIceCream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int right = 300;
		Supermarket cu = new Supermarket();
		String left = cu.getIceCream(right);
		System.out.print(left);
	}

}
