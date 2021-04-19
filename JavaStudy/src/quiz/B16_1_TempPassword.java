package quiz;

public class B16_1_TempPassword {
	public static void main(String[] args) {
		// 임시비밀번호 4자리 만들기(영어 소,대문자, 숫자)

		String password = "";
		int passwordSource;
		for (int i = 0; i < 4; i++) {
			int num = (int) (Math.random() * 3 + 1);
			if (num == 1) {// 단어가 숫자
				passwordSource = ((int) (Math.random() * 10));
				password += passwordSource;
			} else if (num == 2) {// 단어가 대문자
				passwordSource = ((int) (Math.random() * 26 + 65));
				password += (char) passwordSource;
			} else if (num == 3) {// 단어가 소문자
				passwordSource = ((int) (Math.random() * 26 + 97));
				password += (char) passwordSource;
			}
		}
		System.out.println(password);

	}
}
