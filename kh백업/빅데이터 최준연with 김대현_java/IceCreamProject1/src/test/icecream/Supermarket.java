package test.icecream;
/**
 * 
 * @author 최준연
 * 설명 : 
 * TestIceCream에서 생성한 Supermarket cu를 통해 아이의 돈에따라 바밤바를 지급하거나 돌려보낸다.
 */
public class Supermarket {

	public String getIceCream(int right) {
		// TODO Auto-generated method stub
		// 오른손의 돈이 바밤바 가격보다 크면 바밤바를 준다 그렇지 않으면 안준다.
//		int priceOfBabamba = 300;
		if (right>=300) {
			//"바밤바" 준다.
			return "바밤바";
		} //else 는 있어도 좋고 없어도 좋으므로 없는게 낫다.
		return "아이스크림값이 부족하다.";
	}

}
