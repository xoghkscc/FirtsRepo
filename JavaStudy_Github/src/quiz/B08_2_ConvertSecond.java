package quiz;

import java.util.Scanner;

public class B08_2_ConvertSecond {
	public static void main(String[] args) {
		//�ʸ� �Է¹����� ��/��/�ð�/��/�ʷ� ��ȯ�Ͽ� ����غ�����
		//�ʿ���� ������ ������� ���� ex : 0�� 0�� 5�ð� 0�� 20���� ��� 0�� 0���� ������ �ʾƾ� ��
		
		int year=0, day=0, hour=0, min=0, sec;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("���� �ʸ� �Է� �ϼ��� : ");
		sec = sc.nextInt();
			
		B08_3_ConvertSecond2 cs = new B08_3_ConvertSecond2();
		cs.convert(sec);
		
		if(sec>=60) {
			min = sec / 60;
			sec = sec % 60;
		}
		
		if(min>=60) {
			hour = min / 60;
			min = min % 60;
		}
		if(hour>=24) {
			day = hour / 24;
			hour = hour % 24;
		}
		if(day>=365) {
			year = day / 365;
			day = day % 365;
		}
		if(sec>=0) {
			if(year == 0) {
				if(day == 0) {
					if(hour == 0) {
						if(min == 0) {
							System.out.printf("%d��",sec);
						}else {
							System.out.printf("%d�� %d��",min ,sec);
						}
					}else {
						System.out.printf("%d�ð� %d�� %d��",hour ,min ,sec);
					}
				}else {
					System.out.printf("%d�� %d�ð� %d�� %d��",day, hour ,min ,sec);
				}
			}else {
				System.out.printf("%d�� %d�� %d�ð� %d�� %d��",year, day, hour ,min ,sec);
			}
		}else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
		}
		System.out.println("\n");

	}
}
