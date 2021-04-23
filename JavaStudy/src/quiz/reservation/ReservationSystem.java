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
			System.out.print("1. 테이블 예약하기 2. 예약정보 확인하기 3. 현재 예약된 정보 전체 보기 4. 종료하기>>");
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
				System.out.println("예약프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:
				System.out.println("1~4번을 입력해야 합니다.");
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
			startDay = MyScanner.inputInt("예약하고 싶은 일자를 써주세요." + days + " >> ");
			if (startDay >= 1 && startDay <= lastDay) {
				break;
			} else {
				System.out.println("올바른 날짜를 다시 입력해 주세요.");
			}
		}
		starthour = MyScanner.inputInt("예약하고 싶은 시간을 써주세요 (0~23) >>");
		while (true) {
			userhour = MyScanner.inputInt("사용하려는 시간을 써주세요(2시간 단위) >>");
			number_of_people = MyScanner.inputInt("인원 수를 써주세요 (최소 2명 최대 4명)");
			if (userhour % 2 == 0) {
				if (number_of_people >= 2 && number_of_people <= 4) {
					break;
				}else {
					System.out.println("인원은 최소 2명 최대 4명입니다.");
				}
			} else {
				System.out.println("예약은 2시간 단위만 됩니다.");
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
				tableNum = MyScanner.inputInt("예약할 테이블 번호(1~3)>>");
				for (Integer num : overlap) {
					if (tableNum == num) {
						System.err.println("예약할 수 없는 테이블 번호입니다.");
						isTf = true;
					}
				}
			}
			System.out.print("예약자 이름>>");
			name = sc.next();

			while (true) {
				System.out.print("예약자 번호(-포함)>");
				phoneNum = sc.next();
				if (Pattern.matches("010-\\d{4}-\\d{4}", phoneNum)) {
					tableSet.add(new Table(tableNum, phoneNum, name, startDay, starthour, userhour, number_of_people));
					System.out.println("------------------------------------------------");
					System.out.printf("%d번 %d일 %d시부터 %d시간 테이블 정상 예약 되었습니다.[%d명]\n", tableNum, startDay, starthour, userhour, number_of_people);
					System.out.println("------------------------------------------------");
					break;
				} else {
					System.err.println("핸드폰 번호를 정확하게 써주세요>>");
				}
			}
		} else {
			System.out.println("예약이 꽉찼습니다.");
		}
	}

	public void checkReservationm() {
		System.out.printf("예약자 이름을 쓰세요 >>");
		String name = sc.next();
		String phoneNum;
		while (true) {
			System.out.print("예약자 번호(-포함)>");
			phoneNum = sc.next();
			if (Pattern.matches("010-\\d{4}-\\d{4}", phoneNum)) {
				for (Table table : tableSet) {
					table.showReservation(phoneNum, name);
				}
				break;
			} else {
				System.err.println("핸드폰 번호를 정확하게 써주세요>>");
			}
		}
	}
}
