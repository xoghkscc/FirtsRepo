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
	// ������ ���۵Ǹ� �������� 4�ڸ��� ���ڰ� �����ȴ�.
	// 1. �÷��̾�� 8���� �õ��� �� �� �ִ�.
	// 2. �� �õ����� 4�ڸ��� ���ڸ� �Է��ϸ� ������ ���� �˷��ش�.
	// ���ڿ� ��ġ�� �� ������� -Strike
	// ���ڸ� ���� ��� -ball

	// ex. ������ 3456�϶� ���
	// >> 5634 ->4ball, >>3789 ->1Strike, >>3654 ->1Strike 3 ball
	// ���� ���� ���� ������ �� ������ ����
	// 3. ���� �ð��� Ƚ���� ���� 1������ 30�������� ��ŷ�� ���Ͽ� ����ȴ�
	// (Ƚ���� ���ٸ� �ð��� �� ���� �ɸ������ ���� ��ŷ)
	// 4. ���ο� ������ �����Ҷ����� ��ŷ�� ���
	// ���߰� ���� �� ������ ������� �˷��ֱ�

//		
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 4; i++) {
//			sb.append((int)(Math.random()*10));
//		}
//		String answer = sb.toString();
//		System.out.printf("�̹� ���� %s\n", answer);
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
			System.out.printf("1.���� ����  2. ��ŷ Ȯ��  3. �����ϱ�>>");
			int userNum = new Scanner(System.in).nextInt();
			switch (userNum) {
			case 1:
				System.out.printf("���ο� ������� �̸��� �Է� >>");
				name = new Scanner(System.in).next();
				gameStart(name, GAMEFILE);
				break;
			case 2:
				showData();
				break;
				
			case 3:
				System.out.println("���� ��!");
				System.exit(0);
				break;

			default:
				System.out.println("�ٽ� �Է��ϼ���.");
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
	
//					Ƚ��		�ð�
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
				System.out.printf("4�ڸ� ���ڸ� �Է��ϼ��� :");
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
						System.err.println("���ڸ� �Է��ؾ� �մϴ�");
					}
				} else {
					System.err.println("4�ڸ��� �Է��ؾ� �մϴ�.");
				}
			}

			System.out.println("�Է��� ���ڴ� " + userNum + "�Դϴ�.");
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
			} // �迭 �ʱ�ȭ
			if (strikeCnt == 4) {
				break;
			}
			System.out.println("===============================");

		}

		if (strikeCnt == 4) {
			System.out.printf("%dȸ�� �����߽��ϴ�.\n", userCnt);
			success = true;
		} else {
			System.out.println("�����Ͽ����ϴ�.");
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
		return String.format("%s���� Ƚ�� : %dȸ, %d(m/s)���� �����Ͽ����ϴ�.\n", this.name, this.userCnt, this.userTime);
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

