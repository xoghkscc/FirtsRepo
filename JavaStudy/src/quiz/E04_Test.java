package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class E04_Test {
	// 게임이 시작되면 랜덤으로 4자리의 숫자가 선정된다.
	// 1. 플레이어는 8번의 시도를 할 수 있다.
	// 2. 각 시도마다 4자리의 숫자를 입력하면 다음과 같이 알려준다.
	// 숫자와 위치가 다 맞을경우 -Strike
	// 숫자만 맞을 경우 -ball

	// ex. 정답이 3456일때 당신
	// >> 5634 ->4ball, >>3789 ->1Strike, >>3654 ->1Strike 3 ball
	// 빨리 맞출 수록 점수가 더 높도록 설정
	// 3. 맞춘 시간과 횟수를 통해 1위부터 30위까지의 랭킹을 파일에 저장된다
	// (횟수가 같다면 시간이 더 적게 걸린사람이 상위 랭킹)
	// 4. 새로운 게임을 시작할때마다 랭킹을 출력
	// 맞추고 나면 몇 번만에 맞췄는지 알려주기
	Random ran;
	Scanner sc;
	int userCnt;

	static String path = "./note/gameUser/%s.data";
	static boolean success;
	final File GAMEFILE = new File(String.format(path, "scoreList"));

	public static void main(String[] args) {
		E04_Test et = new E04_Test();
		ArrayList<UserData> userList = et.loadData();
		et.gameStart(userList);

	}

	public void gameStart(ArrayList<UserData> userList) {
		while (true) {
			System.out.printf("1.게임 시작  2. 랭킹 확인  3. 종료하기>>");
			int userNum = new Scanner(System.in).nextInt();
			switch (userNum) {
			case 1:
				userList = gameStart(GAMEFILE, userList);
				break;
			case 2:
				showData(userList);
				break;

			case 3:
				System.out.println("게임 끝!");
				System.exit(0);
				break;

			default:
				System.out.println("다시 입력하세요.");
				break;
			}
		}
	}

	public ArrayList<UserData> loadData() {
		ArrayList<UserData> ud = new ArrayList<UserData>();
		boolean tf = true;
		FileInputStream in;
		try {
			in = new FileInputStream(GAMEFILE);
			DataInputStream din = new DataInputStream(in);
			while (tf) {
				try {
					try {
						UserData db = new UserData(din.readUTF(), din.readInt(), din.readInt());
						ud.add(db);
					} catch (Exception e) {
						tf = false;
						din.close();
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ud;
	}

	public ArrayList<UserData> gameStart(File GAMEFILE, ArrayList<UserData> userList) {
		UserData db;
		db = gameLogic(userList);
		if(db != null) {
		saveDate(db);
		userList.add(db);
		}
		return userList;
	}

	public void saveDate(UserData db) {
		try {
			FileOutputStream fout = new FileOutputStream(GAMEFILE, true);
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeUTF(db.name);
			dout.writeInt(db.userCnt);
			dout.writeInt(db.userTime);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserData gameLogic(ArrayList<UserData> userList) {
		
		System.out.printf("새로운 사용자의 이름을 입력 >>");
		String name = new Scanner(System.in).next();
		for(UserData ud : userList) {
			if(name.equals(ud.name)) {
				System.err.println("이미 존재하는 계정입니다.");
				return null;
			}
		}
		
		sc = new Scanner(System.in);
		ran = new Random();
		boolean tf;
		int gameCnt, strikeCnt = 0, ballCnt = 0;
		int userCnt = 0;
		String userNum = "";
		String gameNum = "";
		String exNum = "0123456789";
		int[] num = new int[4];

		for (int i = 0; i < 4; i++) {
			gameNum += exNum.charAt(ran.nextInt(10));
		}
		System.out.println(gameNum);
		int num2 = 0;

		long startTime = System.currentTimeMillis();

		for (int k = 0; k < 8; k++) {
			tf = true;
			strikeCnt = 0;
			ballCnt = 0;

			while (tf) {
				gameCnt = 0;
				System.out.printf("4자리 숫자를 입력하세요 :");
				userNum = sc.next();

				if (userNum.length() == 4) {
					for (int j = 0; j < 4; j++) {
						if (userNum.charAt(j) >= '0' && userNum.charAt(j) <= '9') {
							gameCnt++;
						}
					}
					if (gameCnt == 4) {
						tf = false;
					} else {
						System.err.println("숫자만 입력해야 합니다");
					}
				} else {
					System.err.println("4자리만 입력해야 합니다.");
				}
			}

			System.out.println("입력한 숫자는 " + userNum + "입니다.");
			userCnt++;

			for (int i = 0; i < 4; i++) {
				if (userNum.charAt(i) == gameNum.charAt(i)) {
					num[i] = i;
				}
			}

			for (int j = 0; j < 4; j++) {
				if (userNum.charAt(j) == gameNum.charAt(j)) {
					strikeCnt++;
				} else {
					for (int i = 0; i < 4; i++) {
						if (userNum.charAt(j) == gameNum.charAt(i)) {
							for (int l = 0; l < 4; l++) {
								if (num[l] == i) {
									ballCnt--;
									break;
								}
							}
							ballCnt++;
							break;
						}
					}
				}
			}

			System.out.printf(" %d Strike %d ball\n", strikeCnt, ballCnt);
			for (int i = 0; i < 3; i++) {
				num[i] = -1;
			} // 배열 초기화
			if (strikeCnt == 4) {
				break;
			}
			System.out.println("===============================");

		}

		if (strikeCnt == 4) {
			System.out.printf("%d회에 성공했습니다.\n", userCnt);
			success = true;
		} else {
			System.out.println("실패하였습니다.");
			success = false;
		}
		long endTime = System.currentTimeMillis();
		if (success) {
			long timeTaken = endTime - startTime;
			UserData db = new UserData(name, userCnt, (int) timeTaken);
			return db;
		} else {
			return null;
		}
	}

	public void showData(ArrayList<UserData> userList) {

		Collections.sort(userList, new UserRank());
		int cnt = 1;
		for(UserData userData : userList) {
			System.out.print(cnt+"위 : "+userData);
			cnt++;
			if(cnt > 30) {
				return;
			}
		}
		System.out.println();
	}

}

class UserData {
	String name;
	int userCnt;
	int userTime;

	public UserData(String name, int userCnt, int userTime) {
		this.name = name;
		this.userCnt = userCnt;
		this.userTime = userTime;
	}

	@Override
	public String toString() {
		return String.format("%s님은 횟수 : %d회, %d(m/s)만에 성공하였습니다.\n", this.name, this.userCnt, this.userTime);
	}
}

class UserRank implements Comparator<UserData> {

	@Override
	public int compare(UserData o1, UserData o2) {
		if (o1.userCnt < o2.userCnt) {
			return -1;
		} else if (o1.userCnt == o2.userCnt) {
			if (o1.userTime < o2.userTime) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}

}
