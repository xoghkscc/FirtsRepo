package quiz;

import java.util.Scanner;

public class B06_3_ScoreToGrade {
	public static void main(String[] args) {
		//점수를 입력받으면 점수에 해당하는 등급을 출력해주는 프로그램을 작성
		
		Scanner sc = new Scanner(System.in);
		
		int grade;
		System.out.printf("본인의 점수를 입력하세요. :");
		grade=sc.nextInt();
		
		if(grade < 0 || grade > 100) {
			System.out.println("점수를 잘못 입력하였습니다.");
		}else {
			grade = grade / 10;
			
			if(grade >= 9) {
				System.out.println("A등급");
			}else if(grade == 8) {
				System.out.println("B등급");
			}else if(grade == 7) {
				System.out.println("C등급");
			}else if(grade == 6) {
				System.out.println("D등급");
			}else {
				System.out.println("F등급");
			}
			
		}
		
	}
}
