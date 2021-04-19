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
		this(mode);// this(): �⺻������
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
			System.out.println("���� �������� ���� ���");
			break;
		}
	}

	public void config(int mode) {
		this.mode = mode;
	}

	void pvp() {
		while (true) {
			System.out.println(turn + 1 + "�� ");
			System.out.print("Platey" + (turn % numOfPlayer + 1) + "�� ���� > ");
			int slot = sc.nextInt();

			if (barrel.fork(slot)) {
				if (barrel.checkGameOver()) {
					System.out.println("�� �������� ���ư����ϴ�..");
					System.out.print("Platey" + (turn % numOfPlayer + 1) + "�� �й�!");
					break;
				}
				turn++;
			}
		}
	}

	void pve() {
		while (true) {
			int slot = 0;
			System.out.println(turn + 1 + "�� ");
			if (turn % numOfPlayer == 0) {
				System.out.print("������� ���� > ");
				slot = sc.nextInt();
			}else {
				System.out.printf("��ǻ���� ���� >");
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
					System.out.println("�� �������� ���ư����ϴ�..");
					System.out.print("Platey" + (turn % numOfPlayer + 1) + "�� �й�!");
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
