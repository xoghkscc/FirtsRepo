package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import myobj.MyScanner;

public class E03_SaveGame {
	// 1. ��ǻ�Ϳ� �����ϴ� ������ ���� ������ ������ ����� ������.
	// -ó�� �����ϸ� �̸��� �Է���
	// -���α׷� ����� �÷��̾��� ������ ���Ͽ� ������

	// 2. ���α׷� ����� �̸��� �Է����� �� �ش� ������ �ִٸ� ������ �ҷ��� �� ����ǵ��� ����� ������.

	Random ran;
	HashMap<String, Integer> gameValue;

	String[] victoryJudgment = {"��ǻ���� �¸� Ƚ��", "������ �¸� Ƚ��", "��� Ƚ��"};
	String name;

	public static void main(String[] args) {
		E03_SaveGame sg = new E03_SaveGame();
		sg.gameStart();

	}
	
	public void gameStart() {
		while(true) {
			System.out.printf("1. ���ο� ���� ����  2. ���� �ҷ�����  3. ����� ��� Ȯ���ϱ� 4. �����ϱ�>>");
			int userNum = new Scanner(System.in).nextInt();
			switch (userNum) {
			case 1:
				System.out.printf("���ο� ������� �̸��� �Է� >>");
				name = new Scanner(System.in).next();
				newGame(name);
				break;
			case 2:
				System.out.printf("�ҷ��� ������� �̸��� �Է� >>");
				name = new Scanner(System.in).next();
				loadGame(name);
				break;
			case 3:
				userList();
				break;
			case 4:
				System.out.println("���� ��!");
				System.exit(0);
				break;
	
			default:
				System.out.println("�ٽ� �Է��ϼ���.");
				break;
			}
		}
	}

	public void userList() {
		String dirName = "./note/user/";
		File dir = new File(dirName);
		String[] files = dir.list();
		
		Pattern regex = Pattern.compile("[.]");
		
		for (int i = 0; i < files.length; i++) {
			String[] name_separation = regex.split(files[i]);
			files[i] = name_separation[0];
		}
		System.out.println("���� ��� : "+Arrays.toString(files));
		
		
	}
	
	public void newGame(String name) {
		gameValue = new HashMap<>();

		File gameFile = new File(String.format("./note/user/%s.txt", name));
		if(gameFile.exists()) {
			System.out.println("�̹� �����ϴ� �����Դϴ�.");
		} else {
			for (int i = 0; i < victoryJudgment.length; i++) {
				gameValue.put(victoryJudgment[i], 0);
			}
	
			gameValue = gameLogic(gameValue, name);
			saveDate(gameValue, gameFile);
		}
	}

	public void loadGame(String name) {
		gameValue = new HashMap<>();
		
		File gameFile = new File(String.format("./note/user/%s.txt", name));
		
		try {
			FileInputStream fin = new FileInputStream(gameFile);
			int _byte;
			try {
				String data = "";
				int index = 0;
				while((_byte = fin.read()) != -1) {
					if(_byte != '\n') {
						data += (char)_byte;
					}else {
						gameValue.put(victoryJudgment[index],Integer.parseInt(data));
						data = "";
						index++;
					}
				}
				System.out.printf("���� ��ǻ��[%d]�� : %s[%d]��, ���º�[%d]ȸ\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
				gameValue = gameLogic(gameValue, name);
				saveDate(gameValue, gameFile);
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("�׷� �̸��� �������� ����");
		}
	}

	public HashMap<String, Integer> gameLogic(HashMap<String, Integer> gameValue, String name) {
		
		Random ran = new Random();
		
		while(true) {
			try {
				int choose = MyScanner.inputInt("1. ���� �ϱ�  2. �����ϱ� >>");
				switch (choose) {
				case 1:
					int comChoose = ran.nextInt(3)+1;
					int userChoose = MyScanner.inputInt("1. ����, 2. ����, 3. �� >>");
					String[] rock_paper_scissors = {"����", "����", "��"};
					
					System.out.printf("��ǻ�ʹ�[%s], %s�� [%s]�� �½��ϴ�.\n", rock_paper_scissors[comChoose-1], name, rock_paper_scissors[userChoose-1]);
					
					if(comChoose == userChoose) {
						System.out.println("�����ϴ�.");
						draw(gameValue, name);
					} else if(comChoose > userChoose) {
						if(comChoose==3 && userChoose == 1) {
							userWin(gameValue, name);
						}else {
							comWin(gameValue, name);
						}
					} else if(comChoose < userChoose) {
						if(comChoose==1 && userChoose == 3) {
							comWin(gameValue, name);
						}else {
							userWin(gameValue, name);
						}
					}
					
					break;
				case 2:
					System.out.println("�κ�� ���ư��ϴ�.");
					return gameValue;
				default:
					System.err.println("1 Ȥ�� 2�� �Է��� �ּ���");
				}
			} catch (Exception e) {
				System.err.println("�ùٸ� ���ڸ� �Է��� �ּ���.");
			}
		}
	}
	
	public void saveDate(HashMap<String, Integer> gameValue, File gameFile) {
		try {
			FileOutputStream fout = new FileOutputStream(gameFile);
			try {
				for (int i = 0; i < victoryJudgment.length; i++) {
					fout.write(Integer.toString(gameValue.get(victoryJudgment[i])).getBytes());
					fout.write('\n');
				}
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void comWin(HashMap<String, Integer> gameValue, String name) {
		int score = gameValue.get(victoryJudgment[0]);
		score++;
		gameValue.put(victoryJudgment[0], score);
		System.out.println("============================================");
		System.out.printf("��ǻ���� �¸� !! ��ǻ��[%d]�� : %s[%d]��, ���º�[%d]ȸ\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

	public void userWin(HashMap<String, Integer> gameValue, String name) {
		int score = gameValue.get(victoryJudgment[1]);
		score++;
		gameValue.put(victoryJudgment[1], score);
		System.out.println("============================================");
		System.out.printf("������ �¸� !! ��ǻ��[%d]�� : %s[%d]��, ���º�[%d]ȸ\n", gameValue.get(victoryJudgment[0]), name,gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

	public void draw(HashMap<String, Integer> gameValue, String name) {
		int score = gameValue.get(victoryJudgment[2]);
		score++;
		gameValue.put(victoryJudgment[2], score);
		System.out.println("============================================");
		System.out.printf("��� !! ��ǻ��[%d]�� : %s[%d]��, ���º�[%d]ȸ\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

}
