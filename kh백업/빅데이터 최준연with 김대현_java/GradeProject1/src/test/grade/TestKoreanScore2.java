package test.grade;
/**
 * 
 * @author ���ؿ�
 * ���� ����
 * 1. ��������(int)�� �Է�(�� ���Խ�ų ����)
 * 2. ���ǹ��� �̿��Ͽ� ������ �´� ���� ����
 * 3. ������ ���� ���.
 * 
 * cf) 100~90 : A
 * 		90~80 : B
 * 		80~70 : C
 * 		70~60 : D
 * 		60 ���� : F
 *
 */
public class TestKoreanScore2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int length = args.length/2;
		//String[] classes = {"����", "����", "����"}; 
		String[] classes = new String[length];  //������ 1/2�� 3ĭ�� ������ 6���� ���� �� �ִ� ȿ��
		for (int i = 0; i < length; i++) {
			classes[i] = args[i+0];
		}
		
		//int[] point = {99, 95, 89}; 
		int[] point = new int[length];
		for (int i = 0; i < length; i++) {
			point[i] = Integer.parseInt(args[i+length]);
		}
		
		char[] grade = new char[length+1]; //+1�� �������� ������� ���� ���ؼ� +1�ΰ���
		
		for (int i = 0; i < length; i++) {
			grade[i] = getGrade(point[i]);
			print(classes[i], point[i], grade[i]);
		}
		
		int sum = 0;
		for(int i : point) sum += i;  // int i : point  ==> point �ȿ� ����ִ� ��Ҹ� ������ �� ������ ��� ������ ��
		
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
		print("���", avg, grade[grade.length-1]);
//		System.out.println("��� ������ [" + avg + "] : " + grade[grade.length-1] + "���� �Դϴ�.");
		
	}

	private static void print(String string, int i, char c) {
		// TODO Auto-generated method stub
		System.out.println(string + " ����[" + i + "] : " + c + "���� �Դϴ�.");
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
