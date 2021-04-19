package myobj.tong;

import java.util.Scanner;

public class PirateGame {
	Scanner sc;
	Barrel barrel;
	int mode;
	int turn;
	int numOfPlayer;

	public PirateGame(int mode) {
		barrel = new Barrel(20);
		this.mode = mode;
		this.turn = 0;
		this.numOfPlayer = 2;
		this.sc = new Scanner(System.in);
	}

	public PirateGame(int mode, int numOfPlayer) {
		this(mode);// this(): 기본생성자
		this.numOfPlayer = numOfPlayer;
	}

	public void start() {
		switch (this.mode) {
		case 0:
			pvp();
			break;
		case 1:
			pve();
			break;

		default:
			System.out.println("아직 구현되지 않은 모드");
			break;
		}
	}

	public void config(int mode) {
		this.mode = mode;
	}

	void pvp() {
		while (true) {
			System.out.println(turn + 1 + "턴 ");
			System.out.print("Platey" + (turn % numOfPlayer + 1) + "의 차례 > ");
			int slot = sc.nextInt();

			if (barrel.fork(slot)) {
				if (barrel.checkGameOver()) {
					System.out.println("통 아저씨가 날아갔습니다..");
					System.out.print("Platey" + (turn % numOfPlayer + 1) + "의 패배!");
					break;
				}
				turn++;
			}
		}
	}

	void pve() {
		while (true) {
			int slot = 0;
			System.out.println(turn + 1 + "턴 ");
			if (turn % numOfPlayer == 0) {
				System.out.print("사용자의 차례 > ");
				slot = sc.nextInt();
			}else {
				System.out.printf("컴퓨터의 차례 >");
				while(true) {
					slot = (int) (Math.random() * barrel.size);
					if(!barrel.forked[slot]) {
						break;
					}
				}
				System.out.println(slot);
			}

			if (barrel.fork(slot)) {
				if (barrel.checkGameOver()) {
					System.out.println("통 아저씨가 날아갔습니다..");
					System.out.print("Platey" + (turn % numOfPlayer + 1) + "의 패배!");
					break;
				}
				turn++;
			}
		}
	}

	public static void main(String[] args) {
		PirateGame testGame = new PirateGame(1, 2);

		testGame.start();

	}
}
