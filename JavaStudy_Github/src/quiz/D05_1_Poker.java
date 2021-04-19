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
	 * 포커를 구현해보세요 1. 로얄 플러쉬(Royal Flush a.k.a 로티플) 같은 무늬의 카드로 10,J,Q,K,A를 가지고 있으면 메이드
	 * 
	 * 2. 스트레이트 플러쉬(Straight Flush a.k.a 스티플) 같은 무늬로 5장의 연속된 카드를 가지고 있으면 메이드
	 * 
	 * 3. 포카드(Four of a kind) 같은 숫자의 카드를 4장 가지고 있으면 메이드
	 * 
	 * 4. 풀하우스(Full House) 트리플과 함께 하나의 페어를 가지고 있으면 메이드 같은 랭킹일 경우 트리플의 숫자가 높은 플레이어가
	 * 승리
	 * 
	 * 5. 플러쉬(Flush) 같은 무늬의 카드를 5장 가지고 있으면 메이드 같은 랭킹일 경우 가장 높은 숫자를 보유한 플레이어가 승리
	 * 
	 * 6. 스트레이트(Straight) 연속된 5장의 카드를 가지고 있으면 메이드 A(Ace)의 경우는 10,J,Q,K,A와 A,2,3,4,5가
	 * 가능 전자의 경우 스트레이트에서 가장 높은 등급이고, 후자의 경우가 가장 낮은 등급
	 * 
	 * 7. 쓰리 오브 어 카인드(Three of a kind a.k.a 트리플) 같은 숫자의 카드를 3장 가지고 있으면 메이드
	 * 
	 * 8. 투페어(Two Pair) 같은 숫자의 카드 2장을 2개 보유하고 있으면 메이드
	 * 
	 * 9. 원페어(One Pair) 같은 숫자의 카드 2장을 1개 보유하고 있으면 메이드
	 * 
	 * 10. 하이카드(High Card) 아무런 페어가 없이 가지고 있는 숫자중 가장 높은 수치의 카드
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
		System.out.println("현재 카드 : " + player.toString());
		int choose = MyScanner.inputInt("1. 카드제출 2. 포기>>");
		switch (choose) {
		case 1:
			D05_1_PokerLogic pl = new D05_1_PokerLogic(player);
			pl.cardCheck();
			break;
		case 2:
			System.out.println("넌 쫄보구나");
			System.exit(0);
			break;

		}
	}
}

class Card {
	static String[] numberNames = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	static String[] shape = {"♥", "♣", "◆", "♠"};
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


