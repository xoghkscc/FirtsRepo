package quiz;

import java.util.Collections;
import java.util.HashSet;

public class D07_3_checkValidSocialNumberTea {
	class InvalidMonthException extends Exception {
		public InvalidMonthException() {
			super("�ֹε�Ϲ�ȣ 3, 4�� �ùٸ��� ���� �� �Էµ�");
		}
	}

	class InvalidDateException extends Exception {
		public InvalidDateException() {
			super("�ֹε�Ϲ�ȣ 5, 6�� �ùٸ��� ���� �� �Էµ�");
		}
	}

	private static HashSet<Integer> month31;
	private static HashSet<Integer> month30;
	private static HashSet<Integer> gender2000;
	// static�� �����ڿ��� �ʱ�ȭ�ϸ� �����̹Ƿ� static ��Ͽ��� �ʱ�ȭ�Ѵ�
	static {
		month31 = new HashSet<Integer>();
		month30 = new HashSet<Integer>();
		gender2000 = new HashSet<Integer>();
		//
		Collections.addAll(month31, 1, 3, 5, 7, 8, 10, 12);
		Collections.addAll(month30, 4, 6, 9, 11);
		Collections.addAll(gender2000, 3, 4, 7, 8);
	}

	public boolean isValidSocialNumber(String sn) throws InvalidMonthException, InvalidDateException {
		
		if(sn.length() != 14 || sn.charAt(6) != '-') {
			System.out.println("�߸��� �ֹε�� ��ȣ�Դϴ�.");
			return false;
		}
		
		try {
			int year = Integer.parseInt(sn.substring(0, 2));
			int month = Integer.parseInt(sn.substring(2, 4));
			int day = Integer.parseInt(sn.substring(4, 6));
			int back_number = Integer.parseInt(sn.substring(7));
			int gender = sn.charAt(7)-'0';
			if(gender2000.contains(gender)) {
				year = year + 2000;
			}else {
				year = year + 1900;
				
			}
			
			boolean day29 = (year % 400 == 0) || (year % 4 == 0 && year % 100!=0); 
			
			if (month > 12) {
				throw new InvalidMonthException();
			} else if (month31.contains(month) && day > 31) {
				throw new InvalidDateException();
			} else if (month30.contains(month) && day > 30) {
				throw new InvalidDateException();
			} else if(month == 2 && !day29 && day > 28) {
				throw new InvalidDateException();
			} else if(month == 2 && day29 && day > 29) {
				throw new InvalidDateException();
			}
		} catch (NumberFormatException e) {
			System.out.println("���ڰ� �ƴѰ��� ����");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		D07_3_checkValidSocialNumberTea nt = new D07_3_checkValidSocialNumberTea();
		try {
			if (nt.isValidSocialNumber("931231-1214567")) {
				System.out.println("�ùٸ� �ֹε�Ϲ�ȣ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};