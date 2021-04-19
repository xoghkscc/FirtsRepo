package quiz;

import java.util.Arrays;
import java.util.Random;

public class B18_1_Array2Quiz {
	public static void main(String[] args) {
		int[][] numArr = new int[][] {
			{1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1},
			{1, 1},
			{1, 1, 1, 1, 1},
		};
		
		//1. numArr�� ��� ���� 0 ~ 100 ������ ���� ������ �ٲ㺸����.
		//2. numArr�� ���հ� ���(�Ҽ��� ��°�ڸ�)�� ���ؼ� ����غ�����.
		//3. numArr�� �� ���� ���� ��� ���ؼ� ����� ������.
		//4. numArr�� �� ���� ���� ��� ���ؼ� ����� ������.
		
		int maxIdx=0;
		
		for (int i = 0; i < numArr.length; i++) {
			if(maxIdx<=numArr[i].length) {
				maxIdx=numArr[i].length;
			}
		}
		
		int[] numArr2 = new int[maxIdx];
		Random ran = new Random();	
		int sum=0, sumLine=0, sumHeat = 0;
		float cnt = 0, avg;
		
		for (int i = 0; i < numArr.length; i++) {
			sumLine = 0;
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j]=ran.nextInt(100);
				System.out.print("'"+numArr[i][j]+"' ");
				sum +=numArr[i][j];
				cnt++;
			}
			System.out.println();
		}
		avg = sum / cnt;
		
		System.out.printf("���� : %d, ����� %.2f\n\n",sum, avg );
		
		for (int i = 0; i < numArr.length; i++) {
			sumLine = 0;
			for (int j = 0; j < numArr[i].length; j++) {
				sumLine+=numArr[i][j];
				
			}
			System.out.println(i+"���� ���� "+ sumLine);
		}
		System.out.println();
		
		for (int i = 0; i < numArr.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
			numArr2[j] += numArr[i][j];
			}
		}
		for (int i = 0; i < numArr2.length; i++) {
			System.out.println(i+"���� ���� "+ numArr2[i]);
			
		}
		
		
	}
	
}
