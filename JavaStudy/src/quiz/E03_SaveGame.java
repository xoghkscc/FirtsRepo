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
	// 1. 컴퓨터와 진행하는 간단한 가위 바위보 게임을 만들어 보세요.
	// -처음 시작하면 이름을 입력함
	// -프로그램 종료시 플레이어의 전적을 파일에 저장함

	// 2. 프로그램 실행시 이름을 입력했을 때 해당 전적이 있다면 전적을 불러온 후 진행되도록 만들어 보세요.

	Random ran;
	HashMap<String, Integer> gameValue;

	String[] victoryJudgment = {"컴퓨터의 승리 횟수", "유저의 승리 횟수", "비긴 횟수"};
	String name;

	public static void main(String[] args) {
		E03_SaveGame sg = new E03_SaveGame();
		sg.gameStart();

	}
	
	public void gameStart() {
		while(true) {
			System.out.printf("1. 새로운 게임 시작  2. 게임 불러오기  3. 사용자 목록 확인하기 4. 종료하기>>");
			int userNum = new Scanner(System.in).nextInt();
			switch (userNum) {
			case 1:
				System.out.printf("새로운 사용자의 이름을 입력 >>");
				name = new Scanner(System.in).next();
				newGame(name);
				break;
			case 2:
				System.out.printf("불러올 사용자의 이름을 입력 >>");
				name = new Scanner(System.in).next();
				loadGame(name);
				break;
			case 3:
				userList();
				break;
			case 4:
				System.out.println("게임 끝!");
				System.exit(0);
				break;
	
			default:
				System.out.println("다시 입력하세요.");
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
		System.out.println("유저 목록 : "+Arrays.toString(files));
		
		
	}
	
	public void newGame(String name) {
		gameValue = new HashMap<>();

		File gameFile = new File(String.format("./note/user/%s.txt", name));
		if(gameFile.exists()) {
			System.out.println("이미 존재하는 계정입니다.");
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
				System.out.printf("현재 컴퓨터[%d]승 : %s[%d]승, 무승부[%d]회\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
				gameValue = gameLogic(gameValue, name);
				saveDate(gameValue, gameFile);
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("그런 이름은 존재하지 않음");
		}
	}

	public HashMap<String, Integer> gameLogic(HashMap<String, Integer> gameValue, String name) {
		
		Random ran = new Random();
		
		while(true) {
			try {
				int choose = MyScanner.inputInt("1. 게임 하기  2. 종료하기 >>");
				switch (choose) {
				case 1:
					int comChoose = ran.nextInt(3)+1;
					int userChoose = MyScanner.inputInt("1. 가위, 2. 바위, 3. 보 >>");
					String[] rock_paper_scissors = {"가위", "바위", "보"};
					
					System.out.printf("컴퓨터는[%s], %s는 [%s]를 냈습니다.\n", rock_paper_scissors[comChoose-1], name, rock_paper_scissors[userChoose-1]);
					
					if(comChoose == userChoose) {
						System.out.println("비겼습니다.");
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
					System.out.println("로비로 돌아갑니다.");
					return gameValue;
				default:
					System.err.println("1 혹은 2만 입력해 주세요");
				}
			} catch (Exception e) {
				System.err.println("올바른 숫자를 입력해 주세요.");
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
		System.out.printf("컴퓨터의 승리 !! 컴퓨터[%d]승 : %s[%d]승, 무승부[%d]회\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

	public void userWin(HashMap<String, Integer> gameValue, String name) {
		int score = gameValue.get(victoryJudgment[1]);
		score++;
		gameValue.put(victoryJudgment[1], score);
		System.out.println("============================================");
		System.out.printf("유저의 승리 !! 컴퓨터[%d]승 : %s[%d]승, 무승부[%d]회\n", gameValue.get(victoryJudgment[0]), name,gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

	public void draw(HashMap<String, Integer> gameValue, String name) {
		int score = gameValue.get(victoryJudgment[2]);
		score++;
		gameValue.put(victoryJudgment[2], score);
		System.out.println("============================================");
		System.out.printf("비김 !! 컴퓨터[%d]승 : %s[%d]승, 무승부[%d]회\n", gameValue.get(victoryJudgment[0]), name, gameValue.get(victoryJudgment[1]),gameValue.get(victoryJudgment[2]));
		System.out.println("============================================");
	}

}
