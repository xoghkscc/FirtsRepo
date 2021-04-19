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
		
		//1. numArr의 모든 값을 0 ~ 100 사이의 랜덤 정수로 바꿔보세요.
		//2. numArr의 총합과 평균(소수점 둘째자리)을 구해서 출력해보세요.
		//3. numArr의 각 행의 합을 모두 구해서 출력해 보세요.
		//4. numArr의 각 열의 합을 모두 구해서 출력해 보세요.
		
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
		
		System.out.printf("합은 : %d, 평균은 %.2f\n\n",sum, avg );
		
		for (int i = 0; i < numArr.length; i++) {
			sumLine = 0;
			for (int j = 0; j < numArr[i].length; j++) {
				sumLine+=numArr[i][j];
				
			}
			System.out.println(i+"행의 합은 "+ sumLine);
		}
		System.out.println();
		
		for (int i = 0; i < numArr.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
			numArr2[j] += numArr[i][j];
			}
		}
		for (int i = 0; i < numArr2.length; i++) {
			System.out.println(i+"열의 합은 "+ numArr2[i]);
			
		}
		
		
	}
	
}
