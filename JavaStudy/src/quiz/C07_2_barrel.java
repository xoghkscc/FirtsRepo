package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class C07_2_barrel {
	Random ran;
	int size;
	int[] try1;
	int cnt = 0;
	boolean[] die;

	public C07_2_barrel(int size) {
		this.size = size;
		this.try1 = new int[size];
		ran = new Random();
		this.die = new boolean[size];
		int answer = ran.nextInt(size-1)+1;
		die[answer] = true;
		System.out.println("정답 구멍은 " + answer);
	}

	public boolean judgment(int num) {
		try1[cnt] = num;
		cnt++;
		if (die[num] == true) {
			System.out.println("통나무 아저씨 무야호~");
			return false;
		} else {
			System.out.println("아무 일도 일어나지 않았다.");
			return true;
		}
	}

	public int comRandom() {
		int comNum = 0;
		boolean tf = true;
		while (tf) {
			tf = false;
			comNum = ran.nextInt(size);
			for (int i = 0; i < try1.length; i++) {
				if (comNum == try1[i]) {
					tf = true;
				}
			}
		}
		return comNum;
	}

	public boolean doubleCheck(int userNum) {
		boolean tf = true;
		while(tf) {
			tf = false;
			for (int i = 0; i < try1.length; i++) {
				if (userNum == try1[i]) {
					tf = true;
					System.out.print("찌른 구멍입니다. 다시 입력해 보세요 :");
					userNum = new Scanner(System.in).nextInt();
				}
			}
		}
		tf = judgment(userNum);
		return tf;
	}
	
	public void gameMode1() {}
	public void gameMode2() {}
}
