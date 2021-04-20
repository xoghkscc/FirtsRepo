package quiz.oneCard;

import java.util.ArrayList;
import java.util.Scanner;

import myobj.MyScanner;

public class GameStart {
	Scanner sc = new Scanner(System.in);
	ArrayList<Player> player;
	CardDeck cd;
	Card laidCard;
	ArrayList<Card> attackCard = new ArrayList<Card>();
	int order;

	public GameStart(ArrayList<Player> player, CardDeck cd) {
		this.player = player;
		this.cd = cd;
		gameLogic();
		// main에서 받은 플레이어 list와 남은 덱들을 저장
	}

	public void gameLogic() {
		laidCard = cd.getCard();
		order = -1;
		// 바닥에 한장 깐다
		while (true) {
			System.out.println("-----"+order+"-----");
			order = nextTurn(order);
			turn(order);
		}
	}

	public void turn(int order) {
		boolean tf = true;
		while(tf) {
			Scanner sc = new Scanner(System.in);
			int userChoose=0;
			System.out.println("-----------------------------");
			System.out.println("현재 깔린 카드는 : " + laidCard);
			System.out.println("-----------------------------");
			System.out.printf("현재 [%d]번 턴입니다.\n", order + 1);
			System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(order) + "입니다.\n", order + 1);
			System.out.printf("1. 카드를 얻는다  2. 카드를 낸다>>");
			userChoose = sc.nextInt();
			switch (userChoose) {
			case 1:
				player.get(order).takeCard.add(cd.getCard());
				tf = false;
				break;
			case 2:
				tf = !throwCard(order);
				break;
			}
		}
	}

	public boolean throwCard(int order) {
		Card throwCard = new Card(); 
		while(true) {
			System.out.print("몇 번째 카드를 내겠습니까?>>");
			int choose = sc.nextInt() - 1;
			throwCard = player.get(order).takeCard.get(choose);
			//플레이어가 낸 카드
			System.out.printf("[%d]플레이어가 낸 카드는 :"+throwCard+"\n", order + 1);
			if(throwCard.gameShape.equals(laidCard.gameShape) || throwCard.gameNum.equals(laidCard.gameNum)) {
				player.get(order).takeCard.remove(choose);
				break;
			}else {
				System.err.println("올바르게 카드를 내야합니다.(같은 문양 혹은 같은 숫자)");
				return false;
			}
		}
		laidCard = throwCard;
		if (laidCard.gameNum.equals("A")) {
			if(laidCard.gameShape.equals("♠")) {
				attackCard = attackA();
				attackCard.addAll(attackTwo());
				//공격 카드가 A스페이드면 공격카드 총 5장
			}else {
				attackCard = attackA();
				//공격 카드가 일반 A면 공격카드는 총 3장
			}
			userAttack(order,attackCard);
		} else if (laidCard.gameNum.equals("2")) {
			attackCard = attackTwo();
			userAttack(order,attackCard);
		} else if (laidCard.gameNum.equals("7")) {
			laidCard = sevenChange();
		} else if(laidCard.gameNum.equals("J")) {
			System.out.println("던진 카드는 J이므로 한 턴 건너뜁니다.");
			order = nextTurn(order);
			System.out.println("****"+order+"*****");
		} else if(laidCard.gameNum.equals("K")) {
			System.out.println("던진 카드는 K이므로 한 번 더 합니다.");
			order --;
			System.out.println("****"+order+"*****");
//		} else if(laidCard.gameNum.equals("Q")) {
//			
		}
		return true;
	}
	
	public void userAttack(int order, ArrayList<Card> attackCard) {
		boolean tf = true;
		System.out.println("-----------------------------");
		System.out.println("공격 카드"+laidCard+"등장! 수비해야 할 카드의 수는 "+attackCard.size()+"입니다.");
		System.out.println("-----------------------------");
		order = nextTurn(order);
		while(tf) {
			System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(order) + "입니다.\n", order + 1);
			System.out.printf("1. 수비할 카드를 꺼낸다  2. 카드를 받는다 3. 수비 방법에 대해 설명을 듣는다.>>");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("-----------------------------");
				System.out.println("막아야할 카드["+laidCard+"]");
				System.out.println("-----------------------------");
				System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(order) + "입니다.\n", order + 1);
				System.out.print("몇 번째 카드를 내겠습니까?>>");
				int choose = sc.nextInt() - 1;
				Card throwCard = player.get(order).takeCard.get(choose);
				System.out.printf("[%d]플레이어가 수비하기 위해 낸 카드는 : "+throwCard+"\n", order + 1);
				if(defence(throwCard)) {
					player.get(order).takeCard.remove(choose);
					System.out.println("수비 성공!");
					System.out.println("수비해야 할 카드의 수는 "+attackCard.size()+"입니다.");
					order = nextTurn(order);
				}else {
					System.err.println("수비 실패!! 설명을 읽으세요!");
				}
				break;
			case 2:
				player.get(order).takeCard.addAll(attackCard);
				attackCard = new ArrayList<Card>();
				System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(order) + "입니다.\n", order + 1);
				tf =false;
				break;
		case 3:
			System.out.println("공격카드가 A라면 A 혹은 같은 문양 2로만 수비해야하며 공격카드가 2라면 같은 문양A 혹은 2로만 수비해야 합니다.");
			break;
			}
		}
	}
	
	public boolean defence(Card throwCard) {
		if (laidCard.gameNum.equals("A")) {
			if(throwCard.gameNum.equals("A")) {
				attackCard.addAll(attackA());
				return true;
			}else if(throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("2")) {
				attackCard.addAll(attackTwo());
				return true;
			}
		}else if(laidCard.gameNum.equals("2")) {
			if(throwCard.gameNum.equals("2")) {
				attackCard.addAll(attackTwo());
				return true;
			}else if(throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("A")) {
				attackCard.addAll(attackA());
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Card> attackA() {
		ArrayList<Card> attackCardA = new ArrayList<Card>();
		attackCardA.add(cd.getCard());
		attackCardA.add(cd.getCard());
		attackCardA.add(cd.getCard());

		return attackCardA;
	}

	public ArrayList<Card> attackTwo() {
		ArrayList<Card> attackCardTwo = new ArrayList<Card>();
		attackCardTwo.add(cd.getCard());
		attackCardTwo.add(cd.getCard());

		return attackCardTwo;
	}

	public Card sevenChange() {
		String[] shape = { "♠", "♣", "♥", "◆" };
		int userShape = MyScanner.inputInt("♠, ♣, ♥, ◆ 중 바꿀 문양을 택하세요>>(1~4)");
		Card changeCard = new Card();
		changeCard.cardGet(6, userShape - 1);
		return changeCard;
	}
	
	public int nextTurn(int order) {
		order++;
		if(order==player.size()) {
			order = 0;
		}
		return order;
	}
}
