package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class C07_1_School {

	// 각 반의 정원은 30명이다
	// 사용자로부터 학생이 총 몇명인지 입력받는다.
	// 프로그래밍 반 학생은 각자의 국어, 영어, 수학, 프로그래밍 언어 점수가 있다.
	// 네트워크 반 학생은 각자의 국어, 영어, 리눅스, CCNA 점수가 있다
	// 머신러닝 반 학생은 각자의 국어, 영어, 수학, 통계학, 파이썬 점수가 있다
	// 모든 학생의 성적 점수와 이름을 랜덤으로 생성한다, 학번은 랜덤으로 생성되지만 중복은 없어야한다.
	// 성적표 메서드를 통해 각 학생의 이름/총점/평균점수를 볼 수 있다.

	public static void main(String[] args) {
		C07_1_Network_or_MachineLearning_or_ProgrammingClass[] nc;
		Scanner sc = new Scanner(System.in);
		String subject=null;
		boolean tf = true;
		int choose=0;
		C07_1_Network_or_MachineLearning_or_ProgrammingClass[] nmGrade = new C07_1_Network_or_MachineLearning_or_ProgrammingClass[30];

		System.out.printf("네트워크 : 1, 프로그래밍 : 2, 머신러닝 : 3>>");
		choose = sc.nextInt();
		if (choose == 1) {
			subject = "네트워크";
		} else if (choose == 2) {
			subject = "프로그래밍";
		} else if (choose == 3) {
			subject = "머신러닝";
		}

		for (int j = 0; j < 30 && tf; j++) {
			C07_1_Student st = new C07_1_Student(choose);
			nmGrade[j] = new C07_1_Network_or_MachineLearning_or_ProgrammingClass(subject, st.getGrade(), st.getName(), st.getStudentNum());
			System.out.printf("1. '%s'학생의 성적보기   2. 다음 학생으로 넘어가기   3. 종료 : ", st.getName());
			int userNum = sc.nextInt();
			switch (userNum) {
			case 1:
				nmGrade[j].showInfo();
				nmGrade[j].showGrade();
				break;

			case 3:
				tf=false;
				break;

			
			}
		}

	}
}


