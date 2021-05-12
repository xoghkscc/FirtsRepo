package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import myobj.MyScanner;

public class E03_SaveGame {
	// 1. ��ǻ�Ϳ� �����ϴ� ������ ���� ������ ������ ����� ������.
	// -ó�� �����ϸ� �̸��� �Է���
	// -���α׷� ����� �÷��̾��� ������ ���Ͽ� ������

	// 2. ���α׷� ����� �̸��� �Է����� �� �ش� ������ �ִٸ� ������ �ҷ��� �� ����ǵ��� ����� ������.

	Random ran;
	HashMap<String, Integer> gameValue;

	String computerWin = "��ǻ���� �¸� Ƚ��";
	String userWin = "������ �¸� Ƚ��";
	String draw = "��� Ƚ��";

	public static void main(String[] args) {
		String name;
		E03_SaveGame sg = new E03_SaveGame();

		System.out.printf("1. ���ο� ���� ����  2. ���� �ҷ�����  3. �����ϱ�>>");
		int userNum = new Scanner(System.in).nextInt();
		switch (userNum) {
		case 1:
			name = MyScanner.input("���ο� ������� �̸��� �Է� >>");
			sg.newGame(name);
			break;
		case 2:
			name = MyScanner.input("�ҷ��� ������� �̸��� �Է� >>");
			sg.loadGame(name);
			break;
		case 3:

			break;

		default:
			System.out.println("�ٽ� �Է��ϼ���.");
			break;
		}

	}

	public void newGame(String name) {
		gameValue = new HashMap<>();

		File gameFile = new File(String.format("./note/%s.txt", name));

		gameValue.put(computerWin, 0);
		gameValue.put(userWin, 0);
		gameValue.put(draw, 0);

		gameValue = gameLogic(gameValue);
		
		try {
			FileOutputStream fout = new FileOutputStream(gameFile);
			try {
				fout.write(Integer.toString(gameValue.get(computerWin)).getBytes());
				fout.write(Integer.toString(gameValue.get(userWin)).getBytes());
				fout.write(Integer.toString(gameValue.get(userWin)).getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File loadGame(String name) {
		gameValue = new HashMap<>();
		
		File gameFile = new File(String.format("./note/%s", name));
		
		try {
			FileInputStream fin = new FileInputStream(gameFile);
		} catch (FileNotFoundException e) {
			System.out.println("�׷� �̸��� �������� ����");
			e.printStackTrace();
		}
		
		gameValue.put(computerWin, 0);
		gameValue.put(userWin, 0);
		gameValue.put(draw, 0);
		
		return gameFile;
	}

	public HashMap<String, Integer> gameLogic(HashMap<String, Integer> gameValue) {
		
		Random ran = new Random();
		
		while(true) {
			switch (MyScanner.inputInt("1. ���� �ϱ�  2. �����ϱ� >>")) {
			case 1:
				int comChoose = ran.nextInt(3)+1;
				int userChoose = MyScanner.inputInt("1. ����, 2. ����, 3. �� >>");
				String[] rock_paper_scissors = {"����", "����", "��"};
				
				System.out.printf("��ǻ�ʹ�[%s], ������ [%s]�� �½��ϴ�.\n", rock_paper_scissors[comChoose-1], rock_paper_scissors[userChoose-1]);
				
				if(comChoose == userChoose) {
					System.out.println("�����ϴ�.");
					draw(gameValue);
				} else if(comChoose > userChoose) {
					if(comChoose==3 && userChoose == 1) {
						userWin(gameValue);
					}else {
						comWin(gameValue);
					}
				} else if(comChoose < userChoose) {
					if(comChoose==1 && userChoose == 3) {
						comWin(gameValue);
					}else {
						userWin(gameValue);
					}
				}
				
				break;

			default:
				System.out.println("�κ�� ���ư��ϴ�.");
				return gameValue;
			}
		}
	}

	public void comWin(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(computerWin);
		score++;
		gameValue.put(computerWin, score);
		System.out.println("============================================");
		System.out.printf("��ǻ���� �¸� !! ��ǻ��[%d] : ����[%d], ���º�[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

	public void userWin(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(userWin);
		score++;
		gameValue.put(userWin, score);
		System.out.println("============================================");
		System.out.printf("������ �¸� !! ��ǻ��[%d] : ����[%d], ���º�[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

	public void draw(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(draw);
		score++;
		gameValue.put(draw, score);
		System.out.println("============================================");
		System.out.printf("��� !! ��ǻ��[%d] : ����[%d], ���º�[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

}
