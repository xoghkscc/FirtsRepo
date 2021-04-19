package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C01_1_FunctionQuiz {
	public static void main(String[] args) {
		//������ �Լ��� �����ϰ� �ùٸ��� �����ϴ��� �׽�Ʈ �غ�����.
		//1. ������ ���ڰ� ���ĺ��̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		//2. ������ ���ڰ� 3�� ����̸� true�� ��ȯ, �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		//3. ���ڸ� �ϳ� �����ϸ� ���ڿ� "¦���Դϴ�" �Ǵ� "Ȧ���Դϴ�"�� ��ȯ�ϴ� �Լ�
		//4. ���ڸ� �����ϸ� �ش� ������ ��� ����� �迭 ���·� ��ȯ�ϴ� �Լ� 
		//5. ������ ������ �Ҽ���� true�� ��ȯ�ϰ� �ƴϸ� false�� ��ȯ�ϴ� �Լ�
		//6. ���ڸ� �����ϸ� �ش� ������ ���丮�� ����� ��ȯ�ϴ� �Լ�
		//factorial = 5! = 5*4*3*2*1
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("�� �� ������ �� ����? :");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			char alpha = sc.next().charAt(0);
			boolean tf = alpha(alpha);
			System.out.println(alpha + "�� " + tf+"�Դϴ�.");
			break;
		case 2:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int userNum = sc.nextInt();
			boolean tf2 = multiples(userNum);
			System.out.println(userNum + "�� 3�� ����� "+ tf2 + "�Դϴ�.");
			break;
		case 3:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int userNum2 = sc.nextInt();
			String sniffling = sniffling(userNum2);
			System.out.println(userNum2 + "�� "+ sniffling + "�Դϴ�.");
			break;
		case 4:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int userNum3 = sc.nextInt();
			ArrayList list = new ArrayList();
			list = measure(userNum3);
			System.out.println(list);
			int ArraySize=0;
			for (int i = 1; i <= userNum3; i++) {
				if(userNum3 % i == 0) {
					ArraySize++;
				}
			}
			int [] measure2 = new int[ArraySize];
			measure2=measure2(userNum3);
				System.out.print(Arrays.toString(measure2));
				
			break;
		case 5:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int userNum4 = sc.nextInt();
			boolean tf3 = prime(userNum4);
			System.out.println(userNum4 + "�� �Ҽ��� "+ tf3 + "�Դϴ�.");
			break;
		case 6:
			System.out.print("���ڸ� �Է��ϼ��� : ");
			int userNum5 = sc.nextInt();
			int userFactorila = factorial(userNum5);
			System.out.println(userNum5 + "�� ���丮���� "+ userFactorila + "�Դϴ�.");
			break;

		default:
			System.out.println("�Է��� ���ڴ� 1~6�Դϴ�.");
			break;
		}
	}
	//1�� �޼���
	public static boolean alpha(char alpha) {
		
		if((alpha>='a' && alpha<='z') || (alpha>='A' && alpha<='Z')) {
			return true;
		}else {
			return false;
		}
	}
	
	//2�� �޼���
	public static boolean multiples(int userNum) {
		if(userNum % 3 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//3�� �޼���
	public static String sniffling(int userNum2) {
		if(userNum2 % 2 == 0) {
			return "¦��";
		}else {
			return "Ȧ��";
		}
	}
	
	//4�� �޼���
	public static ArrayList measure(int userNum3) {
		ArrayList list = new ArrayList();
		for (int i = 1; i <= userNum3; i++) {
			if( userNum3 % i == 0) {
				list.add(i);
			}
		}
		return list;
		
		
		
	}
	
	//4-1�� �޼���(�迭�� �ϱ�)
	public static int[] measure2(int userNum3) {
		int ArraySize=0;
		for (int i = 1; i <= userNum3; i++) {
			if(userNum3 % i == 0) {
				ArraySize++;
			}
		}
		int[] measure = new int[ArraySize];
		int j = 0;
		for (int i = 1; i <= userNum3; i++) {
			if(userNum3 % i == 0) {
				measure[j] = i;
				j++;
			}
		}
		return measure;
	}
	
	//5�� �޼���
	public static boolean prime(int userNum4) {
		int cnt=0;
		for (int i = 1; i <= userNum4; i++) {
			if(userNum4 % i ==0) {
				cnt++;
			}
		}

		if (cnt == 2) {
			return true;
		}
		return false;

	}
	
	//6�� �޼���
	public static int factorial(int userNum5) {
		int factorial = 1;
		for (int i = 1; i <= userNum5; i++) {
			factorial *= i; 
		}
		return factorial;
	}
}
