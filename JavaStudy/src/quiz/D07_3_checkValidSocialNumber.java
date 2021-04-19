package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class D07_3_checkValidSocialNumber {
	// ����ڰ� �ֹε�Ϲ�ȣ�� �Է��ϸ� �� �ֹε�Ϲ�ȣ�� ��ȿ���� �˻��ϴ� ���α׷��� ����� �ּ���
	String socialNumber;
	char[] arrNumber;
	int length;
	public boolean checkLength() {
		if (length == 14) {
			return true;
		}
		return false;
	}

	// 930518-11
	public boolean checkMonthDay() {
		HashSet<Integer> month31 = new HashSet<Integer>();
		HashSet<Integer> month30 = new HashSet<Integer>();
		Collections.addAll(month31, 1, 3, 5, 7, 8, 10, 12);
		Collections.addAll(month30, 4, 6, 9, 11);
		int day28 = 2;
		String month = "" + arrNumber[2] + arrNumber[3];
		String day = "" + arrNumber[4] + arrNumber[5];
		int intMonth = Integer.parseInt(month);
		int intDay = Integer.parseInt(day);

		if (intMonth >= 1 && intMonth <= 12) {
			if (month31.contains(intMonth) && intDay <= 31) {
				return true;
			}
			if (month30.contains(intMonth) && intDay <= 30) {
				return true;
			}
			if (intMonth == day28 && intDay <= 28) {
				return true;
			}
		}
		return false;

	}

	public boolean checkHipen() {
		if (arrNumber[6] == '-') {
			return true;
		}
		return false;
	}

	public boolean checkSex() {
		if (arrNumber[7] >= '1' && arrNumber[7] <= '4') {
			return true;
		}
		return false;
	}
	
	public boolean checkNum() {
		Arrays.sort(arrNumber);
		boolean tf = true;
		for (int i = 1; i < arrNumber.length; i++) {
			if(arrNumber[i]<'0' || arrNumber[i]>'9') {
				tf = false;
			}
		}
		return tf;
	}
	public void check(String socialNumber) {
		this.socialNumber = socialNumber;
		this.arrNumber = socialNumber.toCharArray();
		this.length = arrNumber.length;

		boolean[] tf = { checkLength(), checkMonthDay(), checkHipen(), checkSex()};
		String[] show = { "�ֹι�ȣ�� ���̴�", "�ֹι�ȣ�� ���������", "�ֹι�ȣ�� '-'��", "�ֹι�ȣ�� ����"};
		if(checkNum()) {
			for (int i = 0; i < tf.length; i++) {
				if (tf[i]) {
					System.out.printf("%s �ùٸ��ϴ�.\n", show[i]);
				} else {
					System.out.printf("%s �ùٸ��� �ʽ��ϴ�.\n", show[i]);
				}
			}
		}else {
			System.out.println("�ֹι�ȣ�� ���ڰ� �ùٸ��� �ʽ��ϴ�.");
		}
		System.out.println("--------------------------------");
	}

	public static void main(String[] args) {
		D07_3_checkValidSocialNumber sn = new D07_3_checkValidSocialNumber();
		sn.check("930229-1526321");
		sn.check("93022911526321");
		sn.check("930332-1526321");
		sn.check("930431-1526321");
		sn.check("d30229-1526321");
		sn.check("930229-d526321");
	}

}
