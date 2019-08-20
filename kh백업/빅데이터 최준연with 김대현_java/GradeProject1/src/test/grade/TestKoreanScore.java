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
public class TestKoreanScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* else if 구문
		int kor; kor=59;		
		  if ((kor<=100)&&(kor>90)) {System.out.println("점수는 "+ kor + "점, "+ "학점은 A 입니다.");
		
		} else if ((kor<=90)&&(kor>80)) {System.out.println("점수는 "+ kor + "점, "+ "학점은 B 입니다.");
			
		} else if ((kor<=80)&&(kor>70)) {System.out.println("점수는 "+ kor + "점, "+ "학점은 C 입니다.");
			
		} else if ((kor<=70)&&(kor>60)) {System.out.println("점수는 "+ kor + "점, "+ "학점은 D 입니다.");
			
		} else {System.out.println("점수는 "+ kor + "점, "+ "학점은 F 입니다.");

		} 
		*/
		/* 내가 만든 스위치 구문
		 * int kor= 50;
		 int kor1 = (kor - 1)/10;
		String result;
		switch (kor1) {
		case 9:
			result = "점수는 " + kor + "점, "+ "학점은 A 입니다.";		
			break;
		case 8:
			result = "점수는 " + kor + "점, "+ "학점은 B 입니다.";		
			break;
		case 7:
			result = "점수는 " + kor + "점, "+ "학점은 C 입니다.";	
			break;
		case 6:
			result = "점수는 " + kor + "점, "+ "학점은 D 입니다.";	
			break;
		default :
			result = "점수는 " + kor + "점, "+ "학점은 F 입니다.";	
			break;

		}
		System.out.println(result);
		*/
		/* 교수님 switch 구문
		int kor = 80;
		String grade = "A";		
		switch ((kor-1)/10) {
		case 9:
			grade = "A";			
			break;
		case 8:
			grade = "B";			
			break;
		case 7:
			grade = "C";			
			break;
		case 6:
			grade = "D";			
			break;

		default:
			grade = "F";
			break;
		}
		System.out.println("국어 점수[" + kor + "] : " + grade + "학점 입니다.");
		*/
		
		/* else if 배열
		String[] classes = {"국어", "영어", "수학"};
		int[] point = {100, 85, 70};
		char[] grade = new char[4];

		if ((point[0]<=100)&&(point[0]>90)) {grade[0] = 'A';
			
		} else if ((point[0]<=90)&&(point[0]>80)) {grade[0] = 'B';
			
		} else if ((point[0]<=80)&&(point[0]>70)) {grade[0] = 'C';
			
		} else if ((point[0]<=70)&&(point[0]>60)) {grade[0] = 'D';
			
		} else {grade[0] = 'F';
			
		}
		if ((point[1]<=100)&&(point[1]>90)) {grade[1] = 'A';
			
		} else if ((point[1]<=90)&&(point[1]>80)) {grade[1] = 'B';
			
		} else if ((point[1]<=80)&&(point[1]>70)) {grade[1] = 'C';
			
		} else if ((point[1]<=70)&&(point[1]>60)) {grade[1] = 'D';
			
		} else {grade[1] = 'F';
			
		}
		if ((point[2]<=100)&&(point[2]>90)) {grade[2] = 'A';
			
		} else if ((point[2]<=90)&&(point[2]>80)) {grade[2] = 'B';
			
		} else if ((point[2]<=80)&&(point[2]>70)) {grade[2] = 'C';
			
		} else if ((point[2]<=70)&&(point[2]>60)) {grade[2] = 'D';
			
		} else {grade[2] = 'F';
			
		}
		
		int avg = (point[0] + point[1] + point[2])/3;
		if ((avg<=100)&&(avg>90)) {grade[3] = 'A';
			
		} else if ((avg<=90)&&(avg>80)) {grade[3] = 'B';
			
		} else if ((avg<=80)&&(avg>70)) {grade[3] = 'C';
			
		} else if ((avg<=70)&&(avg>60)) {grade[3] = 'D';
			
		} else {grade[3] = 'F';
			
		}
		System.out.println(classes[0] + " 점수[" + point[0] + "] : " + grade[0]+ "학점 입니다.");
		System.out.println(classes[1] + " 점수[" + point[1] + "] : " + grade[1]+ "학점 입니다.");
		System.out.println(classes[2] + " 점수[" + point[2] + "] : " + grade[2]+ "학점 입니다.");
		System.out.println("평균 점수는 [" + avg + "] : " + grade[3] + "학점 입니다.");
		*/
		
		/*
		String[] classes = {"국어", "영어", "수학"};
		int[] point = {100, 85, 70};
		char[] grade = new char[4];
		int index = 0;
		while (index < 3) {
			if ((point[index]<=100)&&(point[index]>90)) {grade[index] = 'A';
			
			} else if ((point[index]<=90)&&(point[index]>80)) {grade[index] = 'B';
				
			} else if ((point[index]<=80)&&(point[index]>70)) {grade[index] = 'C';
				
			} else if ((point[index]<=70)&&(point[index]>60)) {grade[index] = 'D';
				
			} else {grade[index] = 'F';
			
			
			}
			System.out.println(classes[index] + " 점수[" + point[index] + "] : " + grade[index]+ "학점 입니다.");
			index += 1;
		}
		for (int i = 0; i < classes.length; i++) {
			if ((point[i]<=100)&&(point[i]>90)) {grade[i] = 'A';
			
			} else if ((point[i]<=90)&&(point[i]>80)) {grade[i] = 'B';
				
			} else if ((point[i]<=80)&&(point[i]>70)) {grade[i] = 'C';
				
			} else if ((point[i]<=70)&&(point[i]>60)) {grade[i] = 'D';
				
			} else {grade[i] = 'F';
			
			
			}
			System.out.println(classes[i] + " 점수[" + point[i] + "] : " + grade[i]+ "학점 입니다.");
		}
		
		int avg = (point[0] + point[1] + point[2])/3;
		if ((avg<=100)&&(avg>90)) {grade[3] = 'A';
			
		} else if ((avg<=90)&&(avg>80)) {grade[3] = 'B';
			
		} else if ((avg<=80)&&(avg>70)) {grade[3] = 'C';
			
		} else if ((avg<=70)&&(avg>60)) {grade[3] = 'D';
			
		} else {grade[3] = 'F';
		
		}
		System.out.println("평균 점수는 [" + avg + "] : " + grade[3] + "학점 입니다.");
		*/
		
		int length = args.length/2;
		//String[] classes = {"국어", "영어", "수학"}; 
		String[] classes = new String[length];  //공간은 1/2로 3칸이 되지만 6개를 적을 수 있는 효과
		for (int i = 0; i < length; i++) {
			classes[i] = args[i+0];
		}
//		classes[0] = args[0];
//		classes[1] = args[1];
//		classes[2] = args[2];
		
		//int[] point = {99, 95, 89}; 
		int[] point = new int[length];
//		Integer in = new Integer(args[0]);
//		point[0] = in.intValue();       point[0] = Integer.parseInt(args[3]); 둘중 하나의 방식으로 사용 가능(static이 있는 클래스를 사용하거나 말거나에 따라)
		for (int i = 0; i < length; i++) {
			point[i] = Integer.parseInt(args[i+length]);
		}
//		point[0] = Integer.parseInt(args[3]);
//		point[1] = Integer.parseInt(args[4]);
//		point[2] = Integer.parseInt(args[5]);
		
		char[] grade = new char[length+1]; //+1은 기존과목에 평균학점 까지 더해서 +1인거임
		
		for (int i = 0; i < length; i++) {
			if ((point[i]<=100)&&(point[i]>90)) {grade[i] = 'A';
			
			} else if ((point[i]<=90)&&(point[i]>80)) {grade[i] = 'B';
				
			} else if ((point[i]<=80)&&(point[i]>70)) {grade[i] = 'C';
				
			} else if ((point[i]<=70)&&(point[i]>60)) {grade[i] = 'D';
				
			} else {grade[i] = 'F';
			
			
			}
			System.out.println(classes[i] + " 점수[" + point[i] + "] : " + grade[i]+ "학점 입니다.");
		}
		
		int sum = 0;
		for(int i : point) sum += i;  // int i : point  ==> point 안에 들어있는 요소를 끝까지 쓸 떄까지 계속 돌리는 것
		
		int avg = sum/length;
//		int avg = (point[0] + point[1] + point[2])/length;
		if ((avg<=100)&&(avg>90)) {grade[length] = 'A';         // length = args.length/2
																		// classes.length = length  (index = length - 1) ,  point.length = length (index = length - 1) , grade.length = length + 1 (index = length)
					
		} else if ((avg<=90)&&(avg>80)) {grade[length] = 'B';
			
		} else if ((avg<=80)&&(avg>70)) {grade[length] = 'C';
			
		} else if ((avg<=70)&&(avg>60)) {grade[length] = 'D';
			
		} else {grade[grade.length-1] = 'F';
		
		}
		System.out.println("평균 점수는 [" + avg + "] : " + grade[grade.length-1] + "학점 입니다.");
		
	}

}
