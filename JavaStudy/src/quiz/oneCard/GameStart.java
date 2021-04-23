package quiz.oneCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import myobj.MyScanner;
//
public class GameStart {
	Scanner sc = new Scanner(System.in);
	ArrayList<Player> player;
	CardDeck cd;// 카드덱
	Card laidCard;// 바닥에 깔린 덱
	ArrayList<Card> attackCard = new ArrayList<Card>();// 공격 카드가 담길 List
	int order = -1;// 턴을 의미
	ArrayList<Card> trahDeck = new ArrayList<Card>();//
	int orderQ = 1; // Q가 나오면 순서가 반대로 되어야 하므로 이를 판단하는 변수
	public GameStart(ArrayList<Player> player, CardDeck cd) {
		// main메서드에서 카드 7장씩 들고 있는 player들과 카드덱들 돌려주고 남은 카드덱들이 넘어옴
		this.player = player;
		this.cd = cd;
		laidCard = cd.getCard();// 바닥에 한장 깐다
		trashCard(laidCard);// 바닥에 깔린 카드들은 newCd에 저장하는 메서드
		gameLogic();
	}

	public void gameLogic() {
		while (true) {
			//플레이어의 승리를 판단하는 코드
			for(Player player : player) {
				int cnt=1;
				if(player.takeCard.size()==0) {
					System.out.println("-----------------------------");
					System.out.printf("[%d] 플레이어의 승리!!\n", cnt);
					System.out.println("-----------------------------");
					System.exit(0);//시스템 종
				}
				cnt++;
			}
			
			// 플레이어에게 나눠줄 카드덱이 다 떨어질 경우 카드덱을 채워주는 기능
			if (cd.cardDeck == null) {
				newCardDeck();//
			}

			order = nextTurn(this.order);// 처음에는 order가 -1이고 nextTurn 메서드를 통해 1씩 증가(자세한건 nextTurn 메서드 확인)
			turn(this.order);// 본격적인 게임 시작
		}
	}

	public void turn(int order) {
		boolean tf = true;
		while (tf) {
			Scanner sc = new Scanner(System.in);
			int userChoose = 0;// 혹시 몰라서 선택하는 번호를 초기화 해놓은 거임
			System.out.println("-----------------------------");
			System.out.println("현재 깔린 카드는 : " + laidCard);
			System.out.println("-----------------------------");
			System.out.printf("현재 [%d]번 턴입니다.\n", this.order + 1);// 순서가 적용 안되는 경우가 있기에 모든 턴은 this를 통해 움직일 예정
			System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(this.order) + "입니다.\n", this.order + 1);
			System.out.printf("1. 카드를 얻는다  2. 카드를 낸다>>");
			// 플레이어에게 보기 쉽게 하기 위해서 출력 부분에서는 order+1로 표현이 될 거임
			userChoose = sc.nextInt();
			switch (userChoose) {
			case 1:
				//만약 cd라는 덱이 비었을 경우 오류가 생기기에 try/catch문을 사용
				try {
				player.get(this.order).takeCard.add(cd.getCard());
				} catch (IndexOutOfBoundsException e) {
					newCardDeck();
					player.get(this.order).takeCard.add(cd.getCard());
				}
				// takeCard란 해당 플레이어가 가지고 있는 모든 카드들을 모아놓은 List의 이름이며 즉 들고있는 카드 List에 카드 한 장을 추가하는 코드
				tf = false;
				break;
			case 2:
				tf = !throwCard();// 카드를 던지게 되면 throwCard()메서드 작동!
				break;
			default:
				System.err.println("1, 2번만 택해주세요!");// 혹시 다른 번호를 입력하게 되면 나타나는 메세지
				break;
			}
		}
	}

	public boolean throwCard() {
		Card throwCard = new Card();
		int choose;
		// 플레이어가 던진 카드를 throwCard에 담아서 동작하겠다는 의미(플레이어가 직접 던진 카드를 조작하게 된다면 의도치 않게 조작될 수
		// 있기 때문임)
		while (true) {
			while(true) {
				System.out.print("몇 번째 카드를 내겠습니까?>>");
				//해당하지 않는 번호의 카드를 냈을 경우 오류가 발생하기에 try/catch 문을 사용
				choose = sc.nextInt() - 1;
				try {
					throwCard = player.get(this.order).takeCard.get(choose);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.err.println("잘못 입력한 카드패입니다.");
				}
				// 플레이어가 낸 카드
			}
			System.out.println("-----------------------------");
			System.out.printf("[%d]플레이어가 낸 카드는 :" + throwCard + "\n", this.order + 1);
			System.out.println("-----------------------------");
			if (throwCard.gameShape.equals(laidCard.gameShape) || throwCard.gameNum.equals(laidCard.gameNum)) {
				// 플레이어가 던진 카드의 모양과 깔린 모양 혹은 숫자가 같을 경우 작동함
				player.get(this.order).takeCard.remove(choose);
				// 플레이어가 던진 카드를 삭제해주는 코드(깔린 카드와 숫자 혹은 모양이 일치해야 삭제해야함) 그리고 while을 탈출
				break;
			} else {
				System.err.println("올바르게 카드를 내야합니다.(같은 문양 혹은 같은 숫자)");
				return false;
				// 깔린 카드와 던진 카드가 맞지 않기에 false를 리턴에 turn()을 다시 하도록(이때 order(턴)은 유지됨)
			}
		}
		laidCard = throwCard;
		trashCard(laidCard);
		// 즉 플레이어가 던진 카드가 깔린 카드가 되어버림
		// 아래에는 깔린 카드가 특수 효과에 해당하는지 판단하는 코드들
		if (laidCard.gameNum.equals("A")) {
			if (laidCard.gameShape.equals("♠")) {
				attackCard = attackA();// attackCard란 플레이어가 공격한 카드의 수 만큼 카드들이 담길 ArrayList임 attackA를 보면 3장이 담김
				attackCard.addAll(attackTwo());// A스페이드는 공격이 5장이므로 공격카드 2장을 추가로 더 담음
			} else {
				attackCard = attackA();
				// 공격 카드가 일반 A면 공격카드는 총 3장
			}
			userAttack(attackCard);// 공격 카드를 던졌기 때문에 공격 상황으로 넘어가야함 그러기에 userAttack 메서드로 이동
		} else if (laidCard.gameNum.equals("2")) {
			attackCard = attackTwo();// 공격 카드가 2면 2장
			userAttack(attackCard);
		} else if (laidCard.gameNum.equals("7")) {
			laidCard = sevenChange();// 던진 카드가 7이므로 깔린 카드의 모양을 바꿔줄 수 있는 메서드로 이동
		} else if (laidCard.gameNum.equals("J")) {
			System.out.println("-----------------------------");
			System.out.println("던진 카드는 J이므로 한 턴 건너뜁니다.");
			System.out.println("-----------------------------");
			this.order = nextTurn(this.order);
			// J는 한 턴 건너뛰므로 order가 하나 증가하게 만듬(마지막 턴이라면 첫턴으로 증가)
			// 즉 여기서 턴을 하나 증가하고 gameLogic()에서 한 턴이 더 증가하므로 결과는 한 턴을 뛰어넘음
		} else if (laidCard.gameNum.equals("K")) {
			System.out.println("-----------------------------");
			System.out.println("던진 카드는 K이므로 한 번 더 합니다.");
			System.out.println("-----------------------------");
			if(orderQ>0) {
				this.order--;
			}else {
				this.order++;
			}//방향이 정방향이라면 턴을 하나 줄이고 gameLogic()에서 한 턴 증가하므로 결국은 턴은 유지됨
			// 방향이 역방향이라면 턴을 하나 늘리고 gameLogic()에서 한 턴 감소하므로 결국은 턴은 유지됨
		} else if(laidCard.gameNum.equals("Q")) {
			System.out.println("-----------------------------");
			System.out.println("던진 카드는 Q이므로 순서가 뒤바뀝니다.");
			System.out.println("-----------------------------");
			orderQ *= -1;
		}
		return true;
	}

	// 공격 상황에 들어갈 메서드
	public void userAttack(ArrayList<Card> attackCard) {
		boolean tf = true;
		System.out.println("-----------------------------");
		System.out.println("공격 카드" + laidCard + "등장! 수비해야 할 카드의 수는 " + attackCard.size() + "입니다.");
		// throw()메서드에서 넘겨받은 공격 카드를 받아 상황 시작
		System.out.println("-----------------------------");
		this.order = nextTurn(this.order);
		// 공격을 받은 플레이어는 공격한 플레이어의 다음 턴이므로 턴을 다음 턴으로 넘겨야함
		while (tf) {
			System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(this.order) + "입니다.\n", this.order + 1);
			System.out.printf("1. 수비할 카드를 꺼낸다  2. 카드를 받는다 3. 수비 방법에 대해 설명을 듣는다.>>");
			switch (sc.nextInt()) {
			// 수비할 카드를 꺼내겠다고 택한 상황
			case 1:
				System.out.println("-----------------------------");
				System.out.println("막아야할 카드[" + laidCard + "]");
				System.out.println("-----------------------------");
				System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(this.order) + "입니다.\n", this.order + 1);
				int choose = 0;
				Card throwCard = null;
				while(true) {
					System.out.print("몇 번째 카드를 내겠습니까?>>");
					choose = sc.nextInt() - 1;
					try {
						throwCard = player.get(this.order).takeCard.get(choose);
						break;
					} catch (IndexOutOfBoundsException e) {
						System.err.println("잘못 입력한 카드패입니다.");
					}
				}
				
				// 수비하는 플레이어가 던진 카드를 throwCard 변수로 받겠다는 의미
				System.out.println("-----------------------------");
				System.out.printf("[%d]플레이어가 수비하기 위해 낸 카드는 : " + throwCard + "\n", this.order + 1);
				System.out.println("-----------------------------");
				// 수비하기 위해 던진 카드가 규칙에 맞는지 판단하는 메서드
				if (defence(throwCard)) {
					player.get(this.order).takeCard.remove(choose);
					laidCard = throwCard;
					trashCard(laidCard);
					// 수비를 하기 위해 던진 카드가 규칙에 맞기므로 플레이어의 패에서 수비하기 위해 사용한 패를 삭제함
					System.out.println("수비 성공!");
					System.out.println("수비해야 할 카드의 수는 " + attackCard.size() + "입니다.");
					// defence 메서드에서 수비를 성공하였으므로 규칙에 따라 attackCard의 수가 증가하였으며 이를 출력해주는 코드
					this.order = nextTurn(this.order);
					// 수비해 성공했으므로 턴이 증가하고 다음 플레이어가 공격 상황에 대해 수비를 할지 카드를 먹을지 정해야함
				} else {
					System.err.println("수비 실패!! 설명을 읽으세요!");
					// 공격 규칙에 맞지 않는 카드를 던질 경우 출력해주는 메세지 그리고 다시 막을지 수비할지 택해야함
				}
				break;
			// 수비할 카드가 없어서 카드를 먹겠다고 택한 상황
			case 2:
				player.get(this.order).takeCard.addAll(attackCard);
				// 플레이어는 본인의 패에서 공격카드수 만큼의 카드들을 추가하는 코드
				attackCard = new ArrayList<Card>();
				// 공격 카드는 플레이어한테 들어갔으므로 공격 카드는 다시 초기화 해주는 코드
				System.out.println("-----------------------------");
				System.out.printf("[%d]가 가지고 있는 카드는 " + player.get(this.order) + "입니다.\n", this.order + 1);
				System.out.println("-----------------------------");
				// 수비의 실패한 플레이어가 가지고 있는 패를 보여주는 코드
				tf = false;
				// 반복문을 탈출하기 위한 코드 -->즉 공격 상황이 끝나게 되며 gameLogic()으로 이동하게 됨
				break;
			case 3:
				System.out.println("공격카드가 A라면 A 혹은 같은 문양 2로만 수비해야하며 공격카드가 2라면 같은 문양A 혹은 2로만 수비해야 합니다.");
				break;

			default:
				System.err.println("1, 2, 3번만 택해주세요!");// 혹시 다른 번호를 입력하게 되면 나타나는 메세지
				break;
			}

		}
	}

	public boolean defence(Card throwCard) {
		// 수비하기 위해 던진 카드가 규칙에 맞으면 그 만큼의 수비 카드 수를 attackCard List에 추가로 담고 true를 리턴
		// 규칙에 맞지 않는 카드를 던질 경우 false를 리턴
		if (laidCard.gameNum.equals("A")) {// 공격 플레이어가 공격한 카드가 A일 경우
			if (throwCard.gameNum.equals("A")) {
				if (throwCard.gameShape.equals("♠")) {
					attackCard.addAll(attackTwo());// 수비하기 위해 던진 카드가 A스페이드 일 경우 5장을 추가해야함
				}
				attackCard.addAll(attackA());
				return true;
			} else if (throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("2")) {
				// 공격한 카드가 A이고 이를 수비하기 위해 공격한 카드 문양과 같으며 2일 경우
				attackCard.addAll(attackTwo());
				return true;
			}
		} else if (laidCard.gameNum.equals("2")) {// 공격 플레이어가 공격한 카드가 2일 경우
			if (throwCard.gameNum.equals("2")) {
				attackCard.addAll(attackTwo());
				return true;
			} else if (throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("A")) {
				// 공격한 카드가 2이고 이를 수비하기 위해 공격한 카드 문양과 같으며 A일 경우
				if (throwCard.gameShape.equals("♠")) {
					attackCard.addAll(attackTwo());// 수비하기 위해 던진 카드가 A스페이드 일 경우 5장을 추가해야함
				}
				attackCard.addAll(attackA());
				return true;
			}
		}
		return false;
	}

	public ArrayList<Card> attackA() {
		ArrayList<Card> attackCardA = new ArrayList<Card>();
		for (int i = 0; i < 3; i++) {
			try {
				attackCardA.add(cd.getCard());
			} catch (IndexOutOfBoundsException e) {
				newCardDeck();
				attackCardA.add(cd.getCard());
			}
		}
		// 공격카드가 A일 경우 공격 카드에 3장을 추가함 이때 기존 카드덱인 cd를 통해 카드를 가져오므로 중복은 일어나지 않는다
		return attackCardA;
	}

	public ArrayList<Card> attackTwo() {
		ArrayList<Card> attackCardTwo = new ArrayList<Card>();
		for (int i = 0; i < 2; i++) {
			try {
				attackCardTwo.add(cd.getCard());
			} catch (IndexOutOfBoundsException e) {
				newCardDeck();
				attackCardTwo.add(cd.getCard());
			}
		}
		// 공격카드가 A일 경우 공격 카드에 2장을 추가함
		return attackCardTwo;
	}

	// 플레이어가 7번을 낼 경우 깔린 카드 (laidCard)에 대해 원하는 문양의 7번 카드를 반환해주는 메서드
	public Card sevenChange() {
		String[] shape = { "♠", "♣", "♥", "◆" };
		Card changeCard = new Card();
		while(true) {
			int userShape = MyScanner.inputInt("♠, ♣, ♥, ◆ 중 바꿀 문양을 택하세요>>(1~4)");
			if(userShape>=1 && userShape<=4) {
				changeCard.cardGet(6, userShape - 1);
				return changeCard;
			}else {
				System.out.println("1~4번만 입력하세요");
			}
		}
	}

	// 플레이어의 턴을 조정해주는 메서드
	public int nextTurn(int order) {
		if(orderQ>0) {
			order++;
			if (order == player.size()) {
				order = 0;
			}
		}else {
			order--;
			if (order == -1) {
				order = player.size()-1;
			}
			
		}
		return order;
	}

	public void trashCard(Card laidCard) {
		trahDeck.add(laidCard);
	}
	
	public void newCardDeck() {
		System.err.println("카드덱을 다시 설정합니다.");
		Collections.shuffle(trahDeck);
		cd.cardDeck = trahDeck;
		trahDeck = new ArrayList<Card>();//쓰레기 카드덱은 다시 비워줘야함
	}
}
