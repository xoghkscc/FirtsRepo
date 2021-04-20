package quiz.oneCard;

import java.util.ArrayList;
import java.util.Scanner;

import myobj.MyScanner;

public class GameStart {
	Scanner sc = new Scanner(System.in);
	ArrayList<Player> player;
	CardDeck cd;
	public GameStart(ArrayList<Player> player, CardDeck cd) {
		this.player = player;
		this.cd = cd;
		gameLogic();
	}
	
	public void gameLogic() {
		while(true) {
			for (int order = 0; order < player.size(); order++) {
				turn(order);
			}
			
		}
	}
	
	public void turn(int order) {
		Card laidCard = cd.getCard();
		System.out.println("현재 깔린 카드는 : "+laidCard);
		System.out.printf("현재 %d번 턴입니다.", order+1);
		System.out.printf("%d가 가지고 있는 카드는 "+player.get(order)+"입니다.\n", order+1);
		System.out.printf("1. 카드를 얻는다  2. 카드를 낸다>>");
		switch (sc.nextInt()) {
		case 1:
			player.get(order).takeCard.add(cd.getCard());
			break;
		case 2:
			throwCard(order);
			break;
		}

	}	
	
	public void throwCard(int order) {
		System.out.println("첫 번째 카드를 내겠습니까?>>");
		int choose = sc.nextInt()-1;
		Card throwCard = player.get(order).takeCard.get(order);
		System.out.println(throwCard);
	}
	
	public ArrayList<Card> attackA() {
		ArrayList<Card> attackCard = new ArrayList<Card>();
		attackCard.add(cd.getCard());
		attackCard.add(cd.getCard());
		attackCard.add(cd.getCard());
		
		return attackCard;
	}
	public ArrayList<Card> attackTwo() {
		ArrayList<Card> attackCard = new ArrayList<Card>();
		attackCard.add(cd.getCard());
		attackCard.add(cd.getCard());
		
		return attackCard;
	}
	
	public Card sevenChange() {
		String[] shape = {"♠", "♣", "♥", "◆"};
		int userShape = MyScanner.inputInt("♠, ♣, ♥, ◆ 중 바꿀 문양을 택하세요>>(1~4)");
		Card changeCard = new Card();
		changeCard.cardGet(6, userShape-1);
		return changeCard;
	}
}
