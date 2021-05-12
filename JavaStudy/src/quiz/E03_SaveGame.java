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
	// 1. 컴퓨터와 진행하는 간단한 가위 바위보 게임을 만들어 보세요.
	// -처음 시작하면 이름을 입력함
	// -프로그램 종료시 플레이어의 전적을 파일에 저장함

	// 2. 프로그램 실행시 이름을 입력했을 때 해당 전적이 있다면 전적을 불러온 후 진행되도록 만들어 보세요.

	Random ran;
	HashMap<String, Integer> gameValue;

	String computerWin = "컴퓨터의 승리 횟수";
	String userWin = "유저의 승리 횟수";
	String draw = "비긴 횟수";

	public static void main(String[] args) {
		String name;
		E03_SaveGame sg = new E03_SaveGame();

		System.out.printf("1. 새로운 게임 시작  2. 게임 불러오기  3. 종료하기>>");
		int userNum = new Scanner(System.in).nextInt();
		switch (userNum) {
		case 1:
			name = MyScanner.input("새로운 사용자의 이름을 입력 >>");
			sg.newGame(name);
			break;
		case 2:
			name = MyScanner.input("불러올 사용자의 이름을 입력 >>");
			sg.loadGame(name);
			break;
		case 3:

			break;

		default:
			System.out.println("다시 입력하세요.");
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
			System.out.println("그런 이름은 존재하지 않음");
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
			switch (MyScanner.inputInt("1. 게임 하기  2. 종료하기 >>")) {
			case 1:
				int comChoose = ran.nextInt(3)+1;
				int userChoose = MyScanner.inputInt("1. 가위, 2. 바위, 3. 보 >>");
				String[] rock_paper_scissors = {"가위", "바위", "보"};
				
				System.out.printf("컴퓨터는[%s], 유저는 [%s]를 냈습니다.\n", rock_paper_scissors[comChoose-1], rock_paper_scissors[userChoose-1]);
				
				if(comChoose == userChoose) {
					System.out.println("비겼습니다.");
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
				System.out.println("로비로 돌아갑니다.");
				return gameValue;
			}
		}
	}

	public void comWin(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(computerWin);
		score++;
		gameValue.put(computerWin, score);
		System.out.println("============================================");
		System.out.printf("컴퓨터의 승리 !! 컴퓨터[%d] : 유저[%d], 무승부[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

	public void userWin(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(userWin);
		score++;
		gameValue.put(userWin, score);
		System.out.println("============================================");
		System.out.printf("유저의 승리 !! 컴퓨터[%d] : 유저[%d], 무승부[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

	public void draw(HashMap<String, Integer> gameValue) {
		int score = gameValue.get(draw);
		score++;
		gameValue.put(draw, score);
		System.out.println("============================================");
		System.out.printf("비김 !! 컴퓨터[%d] : 유저[%d], 무승부[%d]\n", gameValue.get(computerWin), gameValue.get(userWin),gameValue.get(draw));
		System.out.println("============================================");
	}

}
