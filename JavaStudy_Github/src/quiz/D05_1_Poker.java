package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import myobj.MyScanner;

public class D05_1_Poker {
	/*
	 * ��Ŀ�� �����غ����� 1. �ξ� �÷���(Royal Flush a.k.a ��Ƽ��) ���� ������ ī��� 10,J,Q,K,A�� ������ ������ ���̵�
	 * 
	 * 2. ��Ʈ����Ʈ �÷���(Straight Flush a.k.a ��Ƽ��) ���� ���̷� 5���� ���ӵ� ī�带 ������ ������ ���̵�
	 * 
	 * 3. ��ī��(Four of a kind) ���� ������ ī�带 4�� ������ ������ ���̵�
	 * 
	 * 4. Ǯ�Ͽ콺(Full House) Ʈ���ð� �Բ� �ϳ��� �� ������ ������ ���̵� ���� ��ŷ�� ��� Ʈ������ ���ڰ� ���� �÷��̾
	 * �¸�
	 * 
	 * 5. �÷���(Flush) ���� ������ ī�带 5�� ������ ������ ���̵� ���� ��ŷ�� ��� ���� ���� ���ڸ� ������ �÷��̾ �¸�
	 * 
	 * 6. ��Ʈ����Ʈ(Straight) ���ӵ� 5���� ī�带 ������ ������ ���̵� A(Ace)�� ���� 10,J,Q,K,A�� A,2,3,4,5��
	 * ���� ������ ��� ��Ʈ����Ʈ���� ���� ���� ����̰�, ������ ��찡 ���� ���� ���
	 * 
	 * 7. ���� ���� �� ī�ε�(Three of a kind a.k.a Ʈ����) ���� ������ ī�带 3�� ������ ������ ���̵�
	 * 
	 * 8. �����(Two Pair) ���� ������ ī�� 2���� 2�� �����ϰ� ������ ���̵�
	 * 
	 * 9. �����(One Pair) ���� ������ ī�� 2���� 1�� �����ϰ� ������ ���̵�
	 * 
	 * 10. ����ī��(High Card) �ƹ��� �� ���� ������ �ִ� ������ ���� ���� ��ġ�� ī��
	 */
	
	public static void main(String[] args) {
		ArrayList<Card> player = new ArrayList<>();
		player.add(new Card());
		player.add(new Card().overlap(player));
		player.add(new Card().overlap(player));
		player.add(new Card().overlap(player));
		player.add(new Card().overlap(player));
//		player.add(new Card().test());
//		player.add(new Card().test1());
//		player.add(new Card().test2());
//		player.add(new Card().test3());
//		player.add(new Card().test4());
		System.out.println("���� ī�� : " + player.toString());
		int choose = MyScanner.inputInt("1. ī������ 2. ����>>");
		switch (choose) {
		case 1:
			D05_1_PokerLogic pl = new D05_1_PokerLogic(player);
			pl.cardCheck();
			break;
		case 2:
			System.out.println("�� �̺�����");
			System.exit(0);
			break;

		}
	}
}

class Card {
	static String[] numberNames = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static String[] shape = {"��", "��", "��", "��"};
	static int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	
	String gameNum;
	String gameShape;
	int realNum;
	Random ran;
	
	public Card() {
		ran = new Random();
		int num = ran.nextInt(13);
		gameNum =numberNames[num];
		realNum = number[num];
		gameShape = (shape[ran.nextInt(4)]);
	}
	@Override
		public boolean equals(Object obj) {
			
			return (gameNum ==((Card)obj).gameNum) && (gameShape ==((Card)obj).gameShape);
		}
	
	public Card overlap(ArrayList<Card> player) {
		boolean tf = true;
		Card newCard = new Card();
		while(tf) {
			tf = false;
			newCard = new Card();
			for(Card card1 : player) {
				if(card1.equals(newCard)) {
					tf = true;
				}
			}
		}
		return newCard;
	}
	
	public String toString() {
		return "["+gameNum+"("+gameShape+")]";
	}
	
}


