package quiz.oneCard;
//
import java.util.ArrayList;

public class Player {
	ArrayList<Card> takeCard = new ArrayList<Card>(); 
	CardDeck cd;
	public Player(CardDeck cd) {
		this.cd = cd;
		//�ѱ� ī�嵦 cd�� �޴´�
		for(int i = 0; i<7; i++) {
			takeCard.add(cd.getCard());
			//���� ī�嵦�� ���ؼ� ���� ������ take�Ѵ�.
			//cd.getCard()�� ���� cardDeck.remove(0)�̹Ƿ� ���� ī��� ���� �����ִ� ī���̸� �̴¼���
			//������ ������ �ȴ�.
		}
	}

	
	@Override
	public String toString() {
		return takeCard.toString();
	}
	
	
}
