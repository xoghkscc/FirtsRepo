package quiz;

import java.util.Random;
import java.util.Scanner;

public class B17_2_CountRandomFruit {
	public static void main(String[] args) {
		//1. 사용자로부터 배열의 크기를 입력받는다.
		//2. 해당 크기만큼의 배열에 랜덤 과일 문자열을 저장한다.
		//	(랜덤으로 등장하는 과일: apple, banana, kiwi, orange, peach, strawberry, pineapple)
		//3. 각 괴일이 몇 번 등장했는지 모두 기록하고 출력해본다
		
		Scanner sc = new Scanner(System.in);
		String[] fruit = {"apple", "banana", "kiwi", "orange", "peach", "strawberry", "pineapple"};
		int[] fruitCount = new int[fruit.length];
		Random ran = new Random();
		System.out.printf("배열의 크기를 입력 : ");
		int arr = sc.nextInt();
		String[] userFruit = new String[arr];
		
		for (int i = 0; i < userFruit.length; i++) {
			int randomIdx = ran.nextInt(fruit.length);
			userFruit[i] = fruit[randomIdx];
			fruitCount[randomIdx]++;
			System.out.printf("%s를 저장하였습니다.\n",userFruit[i]);
		}
		System.out.println();
		for (int i = 0; i < 7; i++) {
			if(fruitCount[i] !=0) {
				System.out.printf("%s의 과일은  %d번 등장했습니다\n", fruit[i], fruitCount[i] );
			}
		}
		
		
	}
}
