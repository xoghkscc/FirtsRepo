package quiz;

public class B16_1_TempPassword {
	public static void main(String[] args) {
		// �ӽú�й�ȣ 4�ڸ� �����(���� ��,�빮��, ����)

		String password = "";
		int passwordSource;
		for (int i = 0; i < 4; i++) {
			int num = (int) (Math.random() * 3 + 1);
			if (num == 1) {// �ܾ ����
				passwordSource = ((int) (Math.random() * 10));
				password += passwordSource;
			} else if (num == 2) {// �ܾ �빮��
				passwordSource = ((int) (Math.random() * 26 + 65));
				password += (char) passwordSource;
			} else if (num == 3) {// �ܾ �ҹ���
				passwordSource = ((int) (Math.random() * 26 + 97));
				password += (char) passwordSource;
			}
		}
		System.out.println(password);

	}
}
