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

//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 4; i++) {
//			sb.append((int)(Math.random()*10));
//		}
//		String answer = sb.toString();
//		System.out.printf("이번 정답 %s\n", answer);
	String name;
	Random ran;
	Scanner sc;
	int userCnt;
	static String path = "./note/gameUser/%s.data";
	static HashMap<String, String[]> gameValue;
	static boolean success;
	final File GAMEFILE = new File(String.format(path, "scoreList"));

	public static void main(String[] args) {
		E04_Test et = new E04_Test();
		et.loadData();
		et.gameStart();

	}
	
	public void loadData() {
		
		boolean tf = true;
		String name;
		while(tf) {
		try {
			FileInputStream in = new FileInputStream(GAMEFILE);
			DataInputStream	din = new DataInputStream(in);
			try {
				name =  din.readUTF();
				String[] value = {Integer.toString(din.readInt()) , Integer.toString(din.readInt())};
				gameValue.put(name, value);
			}catch (Exception e) {
				tf = false;
				din.close();
			}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
			}
		}
		
	}
	
	
	public void gameStart() {
		while (true) {
			System.out.printf("1.게임 시작  2. 랭킹 확인  3. 종료하기>>");
			int userNum = new Scanner(System.in).nextInt();
			switch (userNum) {
			case 1:
				System.out.printf("새로운 사용자의 이름을 입력 >>");
				name = new Scanner(System.in).next();
				gameStart(name, GAMEFILE);
				break;
			case 2:
				showData();
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

public void showData() {
		
		boolean tf = true;
		FileInputStream in;
		ArrayList<UserDate> userList = new ArrayList();
		try {
			in = new FileInputStream(GAMEFILE);
			DataInputStream	din = new DataInputStream(in);
			while(tf) {
				try {
					try {
						userList.add(new UserDate( din.readUTF(), din.readInt(), din.readInt()));
						
					}catch (Exception e) {
						tf = false;
						din.close();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (Exception e) {
				}
				
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Collections.sort(userList, new UserRank());
		System.out.println(userList);
	}
	
	
	public void gameStart(String name, File GAMEFILE) {
		gameValue = new HashMap<>();
		String[] value;
		
		value = gameLoic();
		saveDate(name, value);
		gameValue.put(name, value);
	}

	public void saveDate(String name,String[] value ) {
		try {
			FileOutputStream fout = new FileOutputStream(GAMEFILE, true);
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeUTF(name);
			dout.writeInt(Integer.parseInt(value[0]));
			dout.writeInt(Integer.parseInt(value[1]));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//					횟수		시간
	public String[] gameLoic() {
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
		long timeTaken = endTime - startTime;
		String[] value = {Integer.toString(userCnt), Integer.toString((int)timeTaken)};
		return value;
	}


}

class UserDate {
	String name;
	int userCnt;
	int userTime;
	public UserDate(String name,int userCnt, int userTime) {
		this.name = name;
		this.userCnt = userCnt;
		this.userTime = userTime;
	}
	
	@Override
	public String toString() {
		return String.format("%s님은 횟수 : %d회, %d(m/s)만에 성공하였습니다.\n", this.name, this.userCnt, this.userTime);
	}
}

class UserRank implements Comparator<UserDate>{

	@Override
	public int compare(UserDate o1, UserDate o2) {
		if (o1.userCnt < o2.userCnt) {
			return -1;
		} else if (o1.userCnt == o2.userCnt) {
			if(o1.userTime < o2.userTime) {
				return -1;
			}else {
				return 1;
			}
		} else {
			return 1;
		}
	}
	

}

