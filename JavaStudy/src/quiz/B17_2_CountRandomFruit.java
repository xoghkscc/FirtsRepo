package quiz;

import java.util.Random;
import java.util.Scanner;

public class B17_2_CountRandomFruit {
	public static void main(String[] args) {
		//1. ����ڷκ��� �迭�� ũ�⸦ �Է¹޴´�.
		//2. �ش� ũ�⸸ŭ�� �迭�� ���� ���� ���ڿ��� �����Ѵ�.
		//	(�������� �����ϴ� ����: apple, banana, kiwi, orange, peach, strawberry, pineapple)
		//3. �� ������ �� �� �����ߴ��� ��� ����ϰ� ����غ���
		
		Scanner sc = new Scanner(System.in);
		String[] fruit = {"apple", "banana", "kiwi", "orange", "peach", "strawberry", "pineapple"};
		int[] fruitCount = new int[fruit.length];
		Random ran = new Random();
		System.out.printf("�迭�� ũ�⸦ �Է� : ");
		int arr = sc.nextInt();
		String[] userFruit = new String[arr];
		
		for (int i = 0; i < userFruit.length; i++) {
			int randomIdx = ran.nextInt(fruit.length);
			userFruit[i] = fruit[randomIdx];
			fruitCount[randomIdx]++;
			System.out.printf("%s�� �����Ͽ����ϴ�.\n",userFruit[i]);
		}
		System.out.println();
		for (int i = 0; i < 7; i++) {
			if(fruitCount[i] !=0) {
				System.out.printf("%s�� ������  %d�� �����߽��ϴ�\n", fruit[i], fruitCount[i] );
			}
		}
		
		
	}
}
