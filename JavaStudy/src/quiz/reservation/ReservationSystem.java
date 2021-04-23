package quiz.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

import myobj.MyScanner;

public class ReservationSystem {
	Table table;
	static Scanner sc = new Scanner(System.in);
	static TreeSet<Table> tableSet = new TreeSet<Table>();

	public static void main(String[] args) {
		ReservationSystem rs = new ReservationSystem();
		while (true) {
			System.out.print("1. ���̺� �����ϱ� 2. �������� Ȯ���ϱ� 3. ���� ����� ���� ��ü ���� 4. �����ϱ�>>");
			int chooseNum = sc.nextInt();
			switch (chooseNum) {
			case 1:
				rs.reservationSystem();
				break;
			case 2:
				rs.checkReservationm();
				break;
			case 3:
				System.out.println("------------------------------------------------");
				for (Table table : tableSet) {
					System.out.println(table);
				}
				System.out.println("------------------------------------------------");
				break;
			case 4:
				System.out.println("�������α׷��� �����մϴ�.");
				System.exit(0);
				break;

			default:
				System.out.println("1~4���� �Է��ؾ� �մϴ�.");
				break;
			}
		}
	}

	public void reservationSystem() {
		int tableNum = 0;
		int startDay, starthour, endDay;
		int userhour;
		int endhour;
		int number_of_people;
		String name;
		String phoneNum;
		LocalDate now = LocalDate.now();
		int lastDay = now.lengthOfMonth();
		String days = String.format("[1~%d]", lastDay);

		while (true) {
			startDay = MyScanner.inputInt("�����ϰ� ���� ���ڸ� ���ּ���." + days + " >> ");
			if (startDay >= 1 && startDay <= lastDay) {
				break;
			} else {
				System.out.println("�ùٸ� ��¥�� �ٽ� �Է��� �ּ���.");
			}
		}
		starthour = MyScanner.inputInt("�����ϰ� ���� �ð��� ���ּ��� (0~23) >>");
		while (true) {
			userhour = MyScanner.inputInt("����Ϸ��� �ð��� ���ּ���(2�ð� ����) >>");
			number_of_people = MyScanner.inputInt("�ο� ���� ���ּ��� (�ּ� 2�� �ִ� 4��)");
			if (userhour % 2 == 0) {
				if (number_of_people >= 2 && number_of_people <= 4) {
					break;
				}else {
					System.out.println("�ο��� �ּ� 2�� �ִ� 4���Դϴ�.");
				}
			} else {
				System.out.println("������ 2�ð� ������ �˴ϴ�.");
			}
		}
		int cnt = 0;
		ArrayList<Integer> overlap = new ArrayList<Integer>();
		for (Table table : tableSet) {
			if (table.checkTable(startDay, starthour, userhour)) {
				cnt++;
				overlap.add(table.tableNum);
			}
		}
		System.out.println();
		if (cnt != 3) {
			boolean isTf = true;
			while (isTf) {
				isTf = false;
				tableNum = MyScanner.inputInt("������ ���̺� ��ȣ(1~3)>>");
				for (Integer num : overlap) {
					if (tableNum == num) {
						System.err.println("������ �� ���� ���̺� ��ȣ�Դϴ�.");
						isTf = true;
					}
				}
			}
			System.out.print("������ �̸�>>");
			name = sc.next();

			while (true) {
				System.out.print("������ ��ȣ(-����)>");
				phoneNum = sc.next();
				if (Pattern.matches("010-\\d{4}-\\d{4}", phoneNum)) {
					tableSet.add(new Table(tableNum, phoneNum, name, startDay, starthour, userhour, number_of_people));
					System.out.println("------------------------------------------------");
					System.out.printf("%d�� %d�� %d�ú��� %d�ð� ���̺� ���� ���� �Ǿ����ϴ�.[%d��]\n", tableNum, startDay, starthour, userhour, number_of_people);
					System.out.println("------------------------------------------------");
					break;
				} else {
					System.err.println("�ڵ��� ��ȣ�� ��Ȯ�ϰ� ���ּ���>>");
				}
			}
		} else {
			System.out.println("������ ��á���ϴ�.");
		}
	}

	public void checkReservationm() {
		System.out.printf("������ �̸��� ������ >>");
		String name = sc.next();
		String phoneNum;
		while (true) {
			System.out.print("������ ��ȣ(-����)>");
			phoneNum = sc.next();
			if (Pattern.matches("010-\\d{4}-\\d{4}", phoneNum)) {
				for (Table table : tableSet) {
					table.showReservation(phoneNum, name);
				}
				break;
			} else {
				System.err.println("�ڵ��� ��ȣ�� ��Ȯ�ϰ� ���ּ���>>");
			}
		}
	}
}
