package quiz;

import java.util.Scanner;

public class B06_3_ScoreToGrade {
	public static void main(String[] args) {
		//������ �Է¹����� ������ �ش��ϴ� ����� ������ִ� ���α׷��� �ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		int grade;
		System.out.printf("������ ������ �Է��ϼ���. :");
		grade=sc.nextInt();
		
		if(grade < 0 || grade > 100) {
			System.out.println("������ �߸� �Է��Ͽ����ϴ�.");
		}else {
			grade = grade / 10;
			
			if(grade >= 9) {
				System.out.println("A���");
			}else if(grade == 8) {
				System.out.println("B���");
			}else if(grade == 7) {
				System.out.println("C���");
			}else if(grade == 6) {
				System.out.println("D���");
			}else {
				System.out.println("F���");
			}
			
		}
		
	}
}
