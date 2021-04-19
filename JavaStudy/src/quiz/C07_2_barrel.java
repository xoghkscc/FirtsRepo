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
		System.out.println("���� ������ " + answer);
	}

	public boolean judgment(int num) {
		try1[cnt] = num;
		cnt++;
		if (die[num] == true) {
			System.out.println("�볪�� ������ ����ȣ~");
			return false;
		} else {
			System.out.println("�ƹ� �ϵ� �Ͼ�� �ʾҴ�.");
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
					System.out.print("� �����Դϴ�. �ٽ� �Է��� ������ :");
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
