package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C07_2_game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean tf = true;
		C07_2_barrel gm;
		while(tf) {
			System.out.print("1. ��ǻ�Ϳ��� ���, 2. ������ ���, 3. ���� >>");
			int gameMode = sc.nextInt();
			switch (gameMode) {
			case 1:
				System.out.print("���� ����� ��������. : ");
				int size = sc.nextInt();
				gm = new C7_2_gameMode(size);
				gm.gameMode1();
				break;
			case 2:
				System.out.print("���� ����� ��������. : ");
				int size2 = sc.nextInt();
				gm = new C7_2_gameMode(size2);
				gm.gameMode2();
				break;
			case 3:
				tf = false;
				
				System.err.println("���� ����");
				break;


			}
		}
		
		
		
	}
}
