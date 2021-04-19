package quiz;

import java.util.ArrayList;
import java.util.Arrays;

public class D07_2_checkValidPhoneNumber {
	// 사용자로부터 핸드폰 번호를 입력받으면 올바른 전화번호인지 구분하는 프로그램을 만들어보세요
	// 앞의 3자리가 숫자, 4번째, 8, 9번째 -
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
			System.out.println("올바른 번호입니다.");
		}else {
			System.out.println("잘못된 번호입니다.");
		}
	}

	public static void main(String[] args) {
		D07_2_checkValidPhoneNumber pn = new D07_2_checkValidPhoneNumber();
		pn.checkPhoneNumber("010-8474-2301");
	}

}
