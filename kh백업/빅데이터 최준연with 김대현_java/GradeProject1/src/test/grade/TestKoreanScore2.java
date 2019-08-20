package test.grade;
/**
 * 
 * @author 최준연
 * 학점 계산기
 * 1. 국어점수(int)를 입력(값 대입시킬 변수)
 * 2. 조건문을 이용하여 점수에 맞는 학점 배정
 * 3. 점수와 학점 출력.
 * 
 * cf) 100~90 : A
 * 		90~80 : B
 * 		80~70 : C
 * 		70~60 : D
 * 		60 이하 : F
 *
 */
public class TestKoreanScore2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int length = args.length/2;
		//String[] classes = {"국어", "영어", "수학"}; 
		String[] classes = new String[length];  //공간은 1/2로 3칸이 되지만 6개를 적을 수 있는 효과
		for (int i = 0; i < length; i++) {
			classes[i] = args[i+0];
		}
		
		//int[] point = {99, 95, 89}; 
		int[] point = new int[length];
		for (int i = 0; i < length; i++) {
			point[i] = Integer.parseInt(args[i+length]);
		}
		
		char[] grade = new char[length+1]; //+1은 기존과목에 평균학점 까지 더해서 +1인거임
		
		for (int i = 0; i < length; i++) {
			grade[i] = getGrade(point[i]);
			print(classes[i], point[i], grade[i]);
		}
		
		int sum = 0;
		for(int i : point) sum += i;  // int i : point  ==> point 안에 들어있는 요소를 끝까지 쓸 떄까지 계속 돌리는 것
		
		int avg = sum/length;
		grade[length] = getGrade(avg);
//		int avg = (point[0] + point[1] + point[2])/length;
//		if ((avg<=100)&&(avg>90)) {grade[length] = 'A';         // length = args.length/2
//																		// classes.length = length  (index = length - 1) ,  point.length = length (index = length - 1) , grade.length = length + 1 (index = length)
//		 else if ((point[i]<=90)&&(point[i]>80)) {grade[i] = 'B';
//			
//			} else if ((point[i]<=80)&&(point[i]>70)) {grade[i] = 'C';
//				
//			} else if ((point[i]<=70)&&(point[i]>60)) {grade[i] = 'D';
//				
//			} else {grade[i] = 'F';
//			
//			
//			}
		print("평균", avg, grade[grade.length-1]);
//		System.out.println("평균 점수는 [" + avg + "] : " + grade[grade.length-1] + "학점 입니다.");
		
	}

	private static void print(String string, int i, char c) {
		// TODO Auto-generated method stub
		System.out.println(string + " 점수[" + i + "] : " + c + "학점 입니다.");
	}

	private static char getGrade(int i) {
		char result;
		// TODO Auto-generated method stub
		if ((i<=100)&&(i>90)) {result = 'A';
		
		} else if ((i<=90)&&(i>80)) {result = 'B';
			
		} else if ((i<=80)&&(i>70)) {result = 'C';
			
		} else if ((i<=70)&&(i>60)) {result = 'D';
			
		} else {result = 'F';
		
		
		}
		return result;
	}

}
