package quiz;

import java.util.Arrays;
import java.util.Scanner;

public class C7_2_gameMode extends C07_2_barrel {
	Scanner sc = new Scanner(System.in);
	public C7_2_gameMode(int size) {
		super(size);
	}
	
	public void gameMode1() {//��ǻ�Ϳ��� �ο�
		int turn = (int) (Math.random()*2+1);
		boolean tf =true;
		while(tf) {
			System.out.println("���� ������ ��ȣ�� "+Arrays.toString(try1)+"�Դϴ�.");
			if(turn == 1) {
				System.out.printf("������� ���Դϴ� ��ȣ�� �Է��ϼ��� : ");
				tf = doubleCheck(sc.nextInt());
				turn = 2;
				
			}else {
				int comNum = comRandom();
				System.out.printf("��ǻ���� ���Դϴ�\n");
				System.out.println("��ǻ�Ͱ� ���� ������ ��ȣ�� " + comNum+"�Դϴ�.");
				tf = judgment(comNum);
				turn = 1;
			}
		}
	}
	
	public void gameMode2() {//������ �ο�
		boolean tf =true;
		while(tf) {
			System.out.println("���� ������ ��ȣ�� "+Arrays.toString(try1)+"�Դϴ�.");
				System.out.printf("������� ���Դϴ� ��ȣ�� �Է��ϼ��� : ");
				tf = doubleCheck(sc.nextInt());
				
			
		}
		
	}
}
