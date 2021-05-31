package quiz;

import java.util.Scanner;

import myobj.etc.UserInfo;

public class C04_meQuiz {
//myobj�� ���� ������ �Է�
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserInfo[] userInfo = new UserInfo[10];
		for (int i = 0; i < userInfo.length; i++) {
			userInfo[i] = new UserInfo();
		}
		boolean tf = true;
		while(tf) {
			boolean tf1 = true;
			System.out.printf("������ ��ȣ�� �Է� : (0~9, 10�� �Է��ϸ� ����)");
			int userNum = sc.nextInt();
			if(userNum == 10) {
				System.out.println("�α��� ���α׷� ����");
				break;
			}
			while(tf1) {
				int num = 0;
				if(userInfo[userNum].getId().equals("")) {
				System.out.printf("1.���� ����, 2. �α��� 3. ���� ã�� 4. ���� : ");
				}else {
					System.out.printf("2. �α��� 3. ���� ã�� 4. ���� : ");
					
				}
				num = sc.nextInt();
				switch (num) {
				case 1:
					userInfo[userNum] = new UserInfo(userNum);
					break;
				case 2:
					if(userInfo[userNum].getId().equals("")) {
						System.out.println("��ϵ� ������ ����");
						
					}else {
						System.out.printf("���̵� �Է� :");
						String id = sc.next();
						System.out.printf("��й�ȣ �Է� :");
						String pw = sc.next();
						userInfo[userNum].UserInfo(id, pw);
					}
					
					break;
				case 3:
					if(userInfo[userNum].getId().equals("")) {
						System.out.println("��ϵ� ������ ����");
					}else {
						System.out.print("�̸���? :");
						String name = sc.next();
						System.out.println(userInfo[userNum].getPwQuiz());
						System.out.print("���� ������? :");
						int pwAnswer = sc.nextInt();
						userInfo[userNum].UserInfo(name, pwAnswer);
					}
					break;
	
				default:
					tf1 = false;
					break;
				}
			}
		}
	}

	private static UserInfo UserInfo(int userNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
