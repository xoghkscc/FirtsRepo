package quiz;

import java.util.Scanner;

import myobj.UserInfo;

public class C04_meQuiz {
//myobj에 유저 정보를 입력
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserInfo[] userInfo = new UserInfo[10];
		for (int i = 0; i < userInfo.length; i++) {
			userInfo[i] = new UserInfo();
		}
		boolean tf = true;
		while(tf) {
			boolean tf1 = true;
			System.out.printf("유저의 번호를 입력 : (0~9, 10을 입력하면 종료)");
			int userNum = sc.nextInt();
			if(userNum == 10) {
				System.out.println("로그인 프로그램 종료");
				break;
			}
			while(tf1) {
				int num = 0;
				if(userInfo[userNum].getId().equals("")) {
				System.out.printf("1.계정 생성, 2. 로그인 3. 계정 찾기 4. 종료 : ");
				}else {
					System.out.printf("2. 로그인 3. 계정 찾기 4. 종료 : ");
					
				}
				num = sc.nextInt();
				switch (num) {
				case 1:
					userInfo[userNum] = new UserInfo(userNum);
					break;
				case 2:
					if(userInfo[userNum].getId().equals("")) {
						System.out.println("등록된 계정이 없음");
						
					}else {
						System.out.printf("아이디 입력 :");
						String id = sc.next();
						System.out.printf("비밀번호 입력 :");
						String pw = sc.next();
						userInfo[userNum].UserInfo(id, pw);
					}
					
					break;
				case 3:
					if(userInfo[userNum].getId().equals("")) {
						System.out.println("등록된 계정이 없음");
					}else {
						System.out.print("이름은? :");
						String name = sc.next();
						System.out.println(userInfo[userNum].getPwQuiz());
						System.out.print("퀴즈 정답은? :");
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
