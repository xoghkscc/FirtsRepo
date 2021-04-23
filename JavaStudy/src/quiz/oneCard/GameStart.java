package quiz.oneCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import myobj.MyScanner;
//
public class GameStart {
	Scanner sc = new Scanner(System.in);
	ArrayList<Player> player;
	CardDeck cd;// ī�嵦
	Card laidCard;// �ٴڿ� �� ��
	ArrayList<Card> attackCard = new ArrayList<Card>();// ���� ī�尡 ��� List
	int order = -1;// ���� �ǹ�
	ArrayList<Card> trahDeck = new ArrayList<Card>();//
	int orderQ = 1; // Q�� ������ ������ �ݴ�� �Ǿ�� �ϹǷ� �̸� �Ǵ��ϴ� ����
	public GameStart(ArrayList<Player> player, CardDeck cd) {
		// main�޼��忡�� ī�� 7�徿 ��� �ִ� player��� ī�嵦�� �����ְ� ���� ī�嵦���� �Ѿ��
		this.player = player;
		this.cd = cd;
		laidCard = cd.getCard();// �ٴڿ� ���� ���
		trashCard(laidCard);// �ٴڿ� �� ī����� newCd�� �����ϴ� �޼���
		gameLogic();
	}

	public void gameLogic() {
		while (true) {
			//�÷��̾��� �¸��� �Ǵ��ϴ� �ڵ�
			for(Player player : player) {
				int cnt=1;
				if(player.takeCard.size()==0) {
					System.out.println("-----------------------------");
					System.out.printf("[%d] �÷��̾��� �¸�!!\n", cnt);
					System.out.println("-----------------------------");
					System.exit(0);//�ý��� ��
				}
				cnt++;
			}
			
			// �÷��̾�� ������ ī�嵦�� �� ������ ��� ī�嵦�� ä���ִ� ���
			if (cd.cardDeck == null) {
				newCardDeck();//
			}

			order = nextTurn(this.order);// ó������ order�� -1�̰� nextTurn �޼��带 ���� 1�� ����(�ڼ��Ѱ� nextTurn �޼��� Ȯ��)
			turn(this.order);// �������� ���� ����
		}
	}

	public void turn(int order) {
		boolean tf = true;
		while (tf) {
			Scanner sc = new Scanner(System.in);
			int userChoose = 0;// Ȥ�� ���� �����ϴ� ��ȣ�� �ʱ�ȭ �س��� ����
			System.out.println("-----------------------------");
			System.out.println("���� �� ī��� : " + laidCard);
			System.out.println("-----------------------------");
			System.out.printf("���� [%d]�� ���Դϴ�.\n", this.order + 1);// ������ ���� �ȵǴ� ��찡 �ֱ⿡ ��� ���� this�� ���� ������ ����
			System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(this.order) + "�Դϴ�.\n", this.order + 1);
			System.out.printf("1. ī�带 ��´�  2. ī�带 ����>>");
			// �÷��̾�� ���� ���� �ϱ� ���ؼ� ��� �κп����� order+1�� ǥ���� �� ����
			userChoose = sc.nextInt();
			switch (userChoose) {
			case 1:
				//���� cd��� ���� ����� ��� ������ ����⿡ try/catch���� ���
				try {
				player.get(this.order).takeCard.add(cd.getCard());
				} catch (IndexOutOfBoundsException e) {
					newCardDeck();
					player.get(this.order).takeCard.add(cd.getCard());
				}
				// takeCard�� �ش� �÷��̾ ������ �ִ� ��� ī����� ��Ƴ��� List�� �̸��̸� �� ����ִ� ī�� List�� ī�� �� ���� �߰��ϴ� �ڵ�
				tf = false;
				break;
			case 2:
				tf = !throwCard();// ī�带 ������ �Ǹ� throwCard()�޼��� �۵�!
				break;
			default:
				System.err.println("1, 2���� �����ּ���!");// Ȥ�� �ٸ� ��ȣ�� �Է��ϰ� �Ǹ� ��Ÿ���� �޼���
				break;
			}
		}
	}

	public boolean throwCard() {
		Card throwCard = new Card();
		int choose;
		// �÷��̾ ���� ī�带 throwCard�� ��Ƽ� �����ϰڴٴ� �ǹ�(�÷��̾ ���� ���� ī�带 �����ϰ� �ȴٸ� �ǵ�ġ �ʰ� ���۵� ��
		// �ֱ� ������)
		while (true) {
			while(true) {
				System.out.print("�� ��° ī�带 ���ڽ��ϱ�?>>");
				//�ش����� �ʴ� ��ȣ�� ī�带 ���� ��� ������ �߻��ϱ⿡ try/catch ���� ���
				choose = sc.nextInt() - 1;
				try {
					throwCard = player.get(this.order).takeCard.get(choose);
					break;
				} catch (IndexOutOfBoundsException e) {
					System.err.println("�߸� �Է��� ī�����Դϴ�.");
				}
				// �÷��̾ �� ī��
			}
			System.out.println("-----------------------------");
			System.out.printf("[%d]�÷��̾ �� ī��� :" + throwCard + "\n", this.order + 1);
			System.out.println("-----------------------------");
			if (throwCard.gameShape.equals(laidCard.gameShape) || throwCard.gameNum.equals(laidCard.gameNum)) {
				// �÷��̾ ���� ī���� ���� �� ��� Ȥ�� ���ڰ� ���� ��� �۵���
				player.get(this.order).takeCard.remove(choose);
				// �÷��̾ ���� ī�带 �������ִ� �ڵ�(�� ī��� ���� Ȥ�� ����� ��ġ�ؾ� �����ؾ���) �׸��� while�� Ż��
				break;
			} else {
				System.err.println("�ùٸ��� ī�带 �����մϴ�.(���� ���� Ȥ�� ���� ����)");
				return false;
				// �� ī��� ���� ī�尡 ���� �ʱ⿡ false�� ���Ͽ� turn()�� �ٽ� �ϵ���(�̶� order(��)�� ������)
			}
		}
		laidCard = throwCard;
		trashCard(laidCard);
		// �� �÷��̾ ���� ī�尡 �� ī�尡 �Ǿ����
		// �Ʒ����� �� ī�尡 Ư�� ȿ���� �ش��ϴ��� �Ǵ��ϴ� �ڵ��
		if (laidCard.gameNum.equals("A")) {
			if (laidCard.gameShape.equals("��")) {
				attackCard = attackA();// attackCard�� �÷��̾ ������ ī���� �� ��ŭ ī����� ��� ArrayList�� attackA�� ���� 3���� ���
				attackCard.addAll(attackTwo());// A�����̵�� ������ 5���̹Ƿ� ����ī�� 2���� �߰��� �� ����
			} else {
				attackCard = attackA();
				// ���� ī�尡 �Ϲ� A�� ����ī��� �� 3��
			}
			userAttack(attackCard);// ���� ī�带 ������ ������ ���� ��Ȳ���� �Ѿ���� �׷��⿡ userAttack �޼���� �̵�
		} else if (laidCard.gameNum.equals("2")) {
			attackCard = attackTwo();// ���� ī�尡 2�� 2��
			userAttack(attackCard);
		} else if (laidCard.gameNum.equals("7")) {
			laidCard = sevenChange();// ���� ī�尡 7�̹Ƿ� �� ī���� ����� �ٲ��� �� �ִ� �޼���� �̵�
		} else if (laidCard.gameNum.equals("J")) {
			System.out.println("-----------------------------");
			System.out.println("���� ī��� J�̹Ƿ� �� �� �ǳʶݴϴ�.");
			System.out.println("-----------------------------");
			this.order = nextTurn(this.order);
			// J�� �� �� �ǳʶٹǷ� order�� �ϳ� �����ϰ� ����(������ ���̶�� ù������ ����)
			// �� ���⼭ ���� �ϳ� �����ϰ� gameLogic()���� �� ���� �� �����ϹǷ� ����� �� ���� �پ����
		} else if (laidCard.gameNum.equals("K")) {
			System.out.println("-----------------------------");
			System.out.println("���� ī��� K�̹Ƿ� �� �� �� �մϴ�.");
			System.out.println("-----------------------------");
			if(orderQ>0) {
				this.order--;
			}else {
				this.order++;
			}//������ �������̶�� ���� �ϳ� ���̰� gameLogic()���� �� �� �����ϹǷ� �ᱹ�� ���� ������
			// ������ �������̶�� ���� �ϳ� �ø��� gameLogic()���� �� �� �����ϹǷ� �ᱹ�� ���� ������
		} else if(laidCard.gameNum.equals("Q")) {
			System.out.println("-----------------------------");
			System.out.println("���� ī��� Q�̹Ƿ� ������ �ڹٲ�ϴ�.");
			System.out.println("-----------------------------");
			orderQ *= -1;
		}
		return true;
	}

	// ���� ��Ȳ�� �� �޼���
	public void userAttack(ArrayList<Card> attackCard) {
		boolean tf = true;
		System.out.println("-----------------------------");
		System.out.println("���� ī��" + laidCard + "����! �����ؾ� �� ī���� ���� " + attackCard.size() + "�Դϴ�.");
		// throw()�޼��忡�� �Ѱܹ��� ���� ī�带 �޾� ��Ȳ ����
		System.out.println("-----------------------------");
		this.order = nextTurn(this.order);
		// ������ ���� �÷��̾�� ������ �÷��̾��� ���� ���̹Ƿ� ���� ���� ������ �Ѱܾ���
		while (tf) {
			System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(this.order) + "�Դϴ�.\n", this.order + 1);
			System.out.printf("1. ������ ī�带 ������  2. ī�带 �޴´� 3. ���� ����� ���� ������ ��´�.>>");
			switch (sc.nextInt()) {
			// ������ ī�带 �����ڴٰ� ���� ��Ȳ
			case 1:
				System.out.println("-----------------------------");
				System.out.println("���ƾ��� ī��[" + laidCard + "]");
				System.out.println("-----------------------------");
				System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(this.order) + "�Դϴ�.\n", this.order + 1);
				int choose = 0;
				Card throwCard = null;
				while(true) {
					System.out.print("�� ��° ī�带 ���ڽ��ϱ�?>>");
					choose = sc.nextInt() - 1;
					try {
						throwCard = player.get(this.order).takeCard.get(choose);
						break;
					} catch (IndexOutOfBoundsException e) {
						System.err.println("�߸� �Է��� ī�����Դϴ�.");
					}
				}
				
				// �����ϴ� �÷��̾ ���� ī�带 throwCard ������ �ްڴٴ� �ǹ�
				System.out.println("-----------------------------");
				System.out.printf("[%d]�÷��̾ �����ϱ� ���� �� ī��� : " + throwCard + "\n", this.order + 1);
				System.out.println("-----------------------------");
				// �����ϱ� ���� ���� ī�尡 ��Ģ�� �´��� �Ǵ��ϴ� �޼���
				if (defence(throwCard)) {
					player.get(this.order).takeCard.remove(choose);
					laidCard = throwCard;
					trashCard(laidCard);
					// ���� �ϱ� ���� ���� ī�尡 ��Ģ�� �±�Ƿ� �÷��̾��� �п��� �����ϱ� ���� ����� �и� ������
					System.out.println("���� ����!");
					System.out.println("�����ؾ� �� ī���� ���� " + attackCard.size() + "�Դϴ�.");
					// defence �޼��忡�� ���� �����Ͽ����Ƿ� ��Ģ�� ���� attackCard�� ���� �����Ͽ����� �̸� ������ִ� �ڵ�
					this.order = nextTurn(this.order);
					// ������ ���������Ƿ� ���� �����ϰ� ���� �÷��̾ ���� ��Ȳ�� ���� ���� ���� ī�带 ������ ���ؾ���
				} else {
					System.err.println("���� ����!! ������ ��������!");
					// ���� ��Ģ�� ���� �ʴ� ī�带 ���� ��� ������ִ� �޼��� �׸��� �ٽ� ������ �������� ���ؾ���
				}
				break;
			// ������ ī�尡 ��� ī�带 �԰ڴٰ� ���� ��Ȳ
			case 2:
				player.get(this.order).takeCard.addAll(attackCard);
				// �÷��̾�� ������ �п��� ����ī��� ��ŭ�� ī����� �߰��ϴ� �ڵ�
				attackCard = new ArrayList<Card>();
				// ���� ī��� �÷��̾����� �����Ƿ� ���� ī��� �ٽ� �ʱ�ȭ ���ִ� �ڵ�
				System.out.println("-----------------------------");
				System.out.printf("[%d]�� ������ �ִ� ī��� " + player.get(this.order) + "�Դϴ�.\n", this.order + 1);
				System.out.println("-----------------------------");
				// ������ ������ �÷��̾ ������ �ִ� �и� �����ִ� �ڵ�
				tf = false;
				// �ݺ����� Ż���ϱ� ���� �ڵ� -->�� ���� ��Ȳ�� ������ �Ǹ� gameLogic()���� �̵��ϰ� ��
				break;
			case 3:
				System.out.println("����ī�尡 A��� A Ȥ�� ���� ���� 2�θ� �����ؾ��ϸ� ����ī�尡 2��� ���� ����A Ȥ�� 2�θ� �����ؾ� �մϴ�.");
				break;

			default:
				System.err.println("1, 2, 3���� �����ּ���!");// Ȥ�� �ٸ� ��ȣ�� �Է��ϰ� �Ǹ� ��Ÿ���� �޼���
				break;
			}

		}
	}

	public boolean defence(Card throwCard) {
		// �����ϱ� ���� ���� ī�尡 ��Ģ�� ������ �� ��ŭ�� ���� ī�� ���� attackCard List�� �߰��� ��� true�� ����
		// ��Ģ�� ���� �ʴ� ī�带 ���� ��� false�� ����
		if (laidCard.gameNum.equals("A")) {// ���� �÷��̾ ������ ī�尡 A�� ���
			if (throwCard.gameNum.equals("A")) {
				if (throwCard.gameShape.equals("��")) {
					attackCard.addAll(attackTwo());// �����ϱ� ���� ���� ī�尡 A�����̵� �� ��� 5���� �߰��ؾ���
				}
				attackCard.addAll(attackA());
				return true;
			} else if (throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("2")) {
				// ������ ī�尡 A�̰� �̸� �����ϱ� ���� ������ ī�� ����� ������ 2�� ���
				attackCard.addAll(attackTwo());
				return true;
			}
		} else if (laidCard.gameNum.equals("2")) {// ���� �÷��̾ ������ ī�尡 2�� ���
			if (throwCard.gameNum.equals("2")) {
				attackCard.addAll(attackTwo());
				return true;
			} else if (throwCard.gameShape.equals(laidCard.gameShape) && throwCard.gameNum.equals("A")) {
				// ������ ī�尡 2�̰� �̸� �����ϱ� ���� ������ ī�� ����� ������ A�� ���
				if (throwCard.gameShape.equals("��")) {
					attackCard.addAll(attackTwo());// �����ϱ� ���� ���� ī�尡 A�����̵� �� ��� 5���� �߰��ؾ���
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
		// ����ī�尡 A�� ��� ���� ī�忡 3���� �߰��� �̶� ���� ī�嵦�� cd�� ���� ī�带 �������Ƿ� �ߺ��� �Ͼ�� �ʴ´�
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
		// ����ī�尡 A�� ��� ���� ī�忡 2���� �߰���
		return attackCardTwo;
	}

	// �÷��̾ 7���� �� ��� �� ī�� (laidCard)�� ���� ���ϴ� ������ 7�� ī�带 ��ȯ���ִ� �޼���
	public Card sevenChange() {
		String[] shape = { "��", "��", "��", "��" };
		Card changeCard = new Card();
		while(true) {
			int userShape = MyScanner.inputInt("��, ��, ��, �� �� �ٲ� ������ ���ϼ���>>(1~4)");
			if(userShape>=1 && userShape<=4) {
				changeCard.cardGet(6, userShape - 1);
				return changeCard;
			}else {
				System.out.println("1~4���� �Է��ϼ���");
			}
		}
	}

	// �÷��̾��� ���� �������ִ� �޼���
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
		System.err.println("ī�嵦�� �ٽ� �����մϴ�.");
		Collections.shuffle(trahDeck);
		cd.cardDeck = trahDeck;
		trahDeck = new ArrayList<Card>();//������ ī�嵦�� �ٽ� ��������
	}
}
