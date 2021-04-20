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
		// main���� ���� �÷��̾� list�� ���� ������ ����
	}

	public void gameLogic() {
		laidCard = cd.getCard();
		order = -1;
		// �ٴڿ� ���� ���
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
			System.out.println("���� �� ī��� : " + laidCard);
			System.out.println("-----------------------------");
			System.out.printf("���� [%d]�� ���Դϴ�.\n", order + 1);
			System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(order) + "�Դϴ�.\n", order + 1);
			System.out.printf("1. ī�带 ��´�  2. ī�带 ����>>");
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
			System.out.print("�� ��° ī�带 ���ڽ��ϱ�?>>");
			int choose = sc.nextInt() - 1;
			throwCard = player.get(order).takeCard.get(choose);
			//�÷��̾ �� ī��
			System.out.printf("[%d]�÷��̾ �� ī��� :"+throwCard+"\n", order + 1);
			if(throwCard.gameShape.equals(laidCard.gameShape) || throwCard.gameNum.equals(laidCard.gameNum)) {
				player.get(order).takeCard.remove(choose);
				break;
			}else {
				System.err.println("�ùٸ��� ī�带 �����մϴ�.(���� ���� Ȥ�� ���� ����)");
				return false;
			}
		}
		laidCard = throwCard;
		if (laidCard.gameNum.equals("A")) {
			if(laidCard.gameShape.equals("��")) {
				attackCard = attackA();
				attackCard.addAll(attackTwo());
				//���� ī�尡 A�����̵�� ����ī�� �� 5��
			}else {
				attackCard = attackA();
				//���� ī�尡 �Ϲ� A�� ����ī��� �� 3��
			}
			userAttack(order,attackCard);
		} else if (laidCard.gameNum.equals("2")) {
			attackCard = attackTwo();
			userAttack(order,attackCard);
		} else if (laidCard.gameNum.equals("7")) {
			laidCard = sevenChange();
		} else if(laidCard.gameNum.equals("J")) {
			System.out.println("���� ī��� J�̹Ƿ� �� �� �ǳʶݴϴ�.");
			order = nextTurn(order);
			System.out.println("****"+order+"*****");
		} else if(laidCard.gameNum.equals("K")) {
			System.out.println("���� ī��� K�̹Ƿ� �� �� �� �մϴ�.");
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
		System.out.println("���� ī��"+laidCard+"����! �����ؾ� �� ī���� ���� "+attackCard.size()+"�Դϴ�.");
		System.out.println("-----------------------------");
		order = nextTurn(order);
		while(tf) {
			System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(order) + "�Դϴ�.\n", order + 1);
			System.out.printf("1. ������ ī�带 ������  2. ī�带 �޴´� 3. ���� ����� ���� ������ ��´�.>>");
			switch (sc.nextInt()) {
			case 1:
				System.out.println("-----------------------------");
				System.out.println("���ƾ��� ī��["+laidCard+"]");
				System.out.println("-----------------------------");
				System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(order) + "�Դϴ�.\n", order + 1);
				System.out.print("�� ��° ī�带 ���ڽ��ϱ�?>>");
				int choose = sc.nextInt() - 1;
				Card throwCard = player.get(order).takeCard.get(choose);
				System.out.printf("[%d]�÷��̾ �����ϱ� ���� �� ī��� : "+throwCard+"\n", order + 1);
				if(defence(throwCard)) {
					player.get(order).takeCard.remove(choose);
					System.out.println("���� ����!");
					System.out.println("�����ؾ� �� ī���� ���� "+attackCard.size()+"�Դϴ�.");
					order = nextTurn(order);
				}else {
					System.err.println("���� ����!! ������ ��������!");
				}
				break;
			case 2:
				player.get(order).takeCard.addAll(attackCard);
				attackCard = new ArrayList<Card>();
				System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(order) + "�Դϴ�.\n", order + 1);
				tf =false;
				break;
		case 3:
			System.out.println("����ī�尡 A��� A Ȥ�� ���� ���� 2�θ� �����ؾ��ϸ� ����ī�尡 2��� ���� ����A Ȥ�� 2�θ� �����ؾ� �մϴ�.");
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
		String[] shape = { "��", "��", "��", "��" };
		int userShape = MyScanner.inputInt("��, ��, ��, �� �� �ٲ� ������ ���ϼ���>>(1~4)");
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
