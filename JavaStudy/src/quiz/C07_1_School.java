package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class C07_1_School {

	// �� ���� ������ 30���̴�
	// ����ڷκ��� �л��� �� ������� �Է¹޴´�.
	// ���α׷��� �� �л��� ������ ����, ����, ����, ���α׷��� ��� ������ �ִ�.
	// ��Ʈ��ũ �� �л��� ������ ����, ����, ������, CCNA ������ �ִ�
	// �ӽŷ��� �� �л��� ������ ����, ����, ����, �����, ���̽� ������ �ִ�
	// ��� �л��� ���� ������ �̸��� �������� �����Ѵ�, �й��� �������� ���������� �ߺ��� ������Ѵ�.
	// ����ǥ �޼��带 ���� �� �л��� �̸�/����/��������� �� �� �ִ�.

	public static void main(String[] args) {
		C07_1_Network_or_MachineLearning_or_ProgrammingClass[] nc;
		Scanner sc = new Scanner(System.in);
		String subject=null;
		boolean tf = true;
		int choose=0;
		C07_1_Network_or_MachineLearning_or_ProgrammingClass[] nmGrade = new C07_1_Network_or_MachineLearning_or_ProgrammingClass[30];

		System.out.printf("��Ʈ��ũ : 1, ���α׷��� : 2, �ӽŷ��� : 3>>");
		choose = sc.nextInt();
		if (choose == 1) {
			subject = "��Ʈ��ũ";
		} else if (choose == 2) {
			subject = "���α׷���";
		} else if (choose == 3) {
			subject = "�ӽŷ���";
		}

		for (int j = 0; j < 30 && tf; j++) {
			C07_1_Student st = new C07_1_Student(choose);
			nmGrade[j] = new C07_1_Network_or_MachineLearning_or_ProgrammingClass(subject, st.getGrade(), st.getName(), st.getStudentNum());
			System.out.printf("1. '%s'�л��� ��������   2. ���� �л����� �Ѿ��   3. ���� : ", st.getName());
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


