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
		System.out.println("���� �� ī��� : "+laidCard);
		System.out.printf("���� %d�� ���Դϴ�.", order+1);
		System.out.printf("%d�� ������ �ִ� ī��� "+player.get(order)+"�Դϴ�.\n", order+1);
		System.out.printf("1. ī�带 ��´�  2. ī�带 ����>>");
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
		System.out.println("ù ��° ī�带 ���ڽ��ϱ�?>>");
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
		String[] shape = {"��", "��", "��", "��"};
		int userShape = MyScanner.inputInt("��, ��, ��, �� �� �ٲ� ������ ���ϼ���>>(1~4)");
		Card changeCard = new Card();
		changeCard.cardGet(6, userShape-1);
		return changeCard;
	}
}
