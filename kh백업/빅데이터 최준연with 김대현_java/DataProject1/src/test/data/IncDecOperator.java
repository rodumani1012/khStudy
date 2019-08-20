package test.data;
/**
 * 교과서 4-4
 * @author 최준연
 * 전위형과 후위형에 대하여 알아보도록 하자.
 * 정수를 대입할 변수 2개와 대입한 변수 두개를 합할 변수 1개를 만든다.
 * syso에 +를 여러번 쓰는 것보다 속도가 빠른 StringBuffer를 사용한다.
 * ++i 증가된 값을 먼저 참조하고 i++은 증가되기 전 값을 먼저 참조한다.
 * 
 */
public class IncDecOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10, j = 5, k;
		k = ++i + j--;
		System.out.println("1번 문제 => " + "i = " + i + ", j = " + j + ", k = " + k);
		//StringBuffer는 위에 "1번 문제 => " + "i = " + i + ", j = " + j + ", k = " + k 보다 객체 생성이 적어 속도가 훨씬 빠르다.
		StringBuffer sb = new StringBuffer();
		sb.append("i=").append(i).append(", j=").append(j).append(", k=").append(k);
		System.out.println(sb.toString());
//		System.out.println(new StringBuffer().append("i=").append(i).append(", j=").append(j).append(", k=").append(k).toString());
		//위 3줄을 한 줄로 줄인 것
		k = i-- + --j;
		System.out.println("2번 문제 => " +"i = " + i + ", j = " + j + ", k = " + k);
		
		System.out.println("3번 문제 => " +"i = " + ++i + ", j = " + j-- + ", i = " + --i + ", j = " + --j);
	}

}
