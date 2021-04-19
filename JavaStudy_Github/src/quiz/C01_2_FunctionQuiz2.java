package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C01_2_FunctionQuiz2 {
	public static void main(String[] args) {
		//1. �ִ밪�� �Ű������� ���� ������ 0���� �ִ밪 �̸��� ��� ���� �����ϴ� int �迭�� �����Ͽ� ��ȯ�ϴ�
		//range �Լ��� ��������.
		//2. �ּҰ��� �ִ밪�� �Ű������� ������, �� ���̿� �����ϴ� ��� ���� �����ϴ�
		//int�迭�� �����Ͽ� ��ȯ�ϴ� range �Լ��� ����� ������.(�ּҰ� �̻�, �ִ밪 �̸�)
		//3. �ּҰ��� �ִ밪�� �������� �Ű������� ������ �ּҰ����� �����Ͽ� �ִ밪���� ��������ŭ �����ϴ�
		//int �迭�� �����Ͽ� ��ȯ�ϴ� range �Լ��� ��������.(�ּҰ� �̻�, �ִ밪 �̸�)
		//ex range(50, 56, 5)�� ��� -->[50, 55]
		//ex range(50, 55, 5)�� ��� -->[50]
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���ڸ� �Է��ϼ��� :");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���ڸ� �Է��ϼ��� :");
		int num2 = sc.nextInt();
		int maxNum = Math.max(num1, num2);
		int minNum = Math.min(num1, num2);
		System.out.printf("�ִ밪 : %d, �ּҰ� : %d",maxNum, minNum);
		System.out.println();
		
		
		boolean tf = true;
		while(tf) {
			System.out.println();
			System.out.print("�� �� ������ �� ����? :(�׸��ϰ� ������ 4���� �Է�) ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				int[] numArray = range(maxNum);
				System.out.println(Arrays.toString(numArray));
				break;
			case 2:
				int[] numArray2 = range(maxNum, minNum);
				System.out.println(Arrays.toString(numArray2));
				break;
			case 3:
				System.out.print("�������� �Է� �ϼ��� : ");
				int plusValue = sc.nextInt();
				int[] numArray3 = range(maxNum, minNum, plusValue);
				System.out.println(Arrays.toString(numArray3));
				break;
	
			case 4:
				tf = false;
				System.out.println("��~");
				break;
				
			default:
				System.out.println("���� 1~4�� �Է��ϼ���.");
				break;
			}
		}
		
	}
	
	//1�� �޼���
	public static int[] range(int maxNum) {
		int[] numArray = new int[maxNum];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i]=i;
		}
		return numArray;
	}
	
	//2�� �޼���
	public static int[] range(int maxNum, int minNum) {
		int[] numArray = new int[maxNum-minNum];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = minNum+i;
		}
		return numArray;
	}
	
	//3�� �޼���
	public static int[] range(int maxNum, int minNum, int plusValue) {
		int cnt=0;
		for (int i = 0; i < maxNum; i++) {
			if(minNum+plusValue*i<maxNum) {
				cnt++;
			}
		}
		
		int[] numArray = new int[cnt];
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = minNum + i*plusValue;
		}
		return numArray;
	}
	
	
}
