package quiz;

import java.util.ArrayList;
import java.util.Arrays;

public class D07_2_checkValidPhoneNumber {
	// ����ڷκ��� �ڵ��� ��ȣ�� �Է¹����� �ùٸ� ��ȭ��ȣ���� �����ϴ� ���α׷��� ��������
	// ���� 3�ڸ��� ����, 4��°, 8, 9��° -
	// 011-874-2301 : 12, 010-5625-7327 : 13
	String number;
	char[] arrNum;
	int length;



	public boolean checkLenth() {
		if (length == 12 || length == 13) {
			return true;
		}
		return false;
	}

	public boolean checkNum() {
		boolean tf = false;
		if (length == 12) {
			if (arrNum[3] == '-' && arrNum[7] == '-') {
				Arrays.sort(arrNum);
				System.out.println(arrNum);
				for (int i = 2; i < arrNum.length; i++) {
					if (arrNum[i] >= '0' && arrNum[i] <= '9') {
						tf = true;
					}
				}
			}
		} else if (length == 13) {
			if (arrNum[3] == '-' && arrNum[8] == '-') {
				Arrays.sort(arrNum);
				for (int i = 2; i < arrNum.length; i++) {
					if (arrNum[i] >= '0' && arrNum[i] <= '9') {
						tf = true;
					}
				}
			}
		}
		return tf;
	}

	public void checkPhoneNumber(String number) {
		this.arrNum = number.toCharArray();
		this.number = number;
		this.length = arrNum.length;
		
		if(checkLenth() && checkNum()) {
			System.out.println("�ùٸ� ��ȣ�Դϴ�.");
		}else {
			System.out.println("�߸��� ��ȣ�Դϴ�.");
		}
	}

	public static void main(String[] args) {
		D07_2_checkValidPhoneNumber pn = new D07_2_checkValidPhoneNumber();
		pn.checkPhoneNumber("010-8474-2301");
	}

}
