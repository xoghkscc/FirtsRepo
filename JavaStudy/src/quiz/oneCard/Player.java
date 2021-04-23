package quiz.oneCard;
//
import java.util.ArrayList;

public class Player {
	ArrayList<Card> takeCard = new ArrayList<Card>(); 
	CardDeck cd;
	public Player(CardDeck cd) {
		this.cd = cd;
		//넘긴 카드덱 cd를 받는다
		for(int i = 0; i<7; i++) {
			takeCard.add(cd.getCard());
			//받은 카드덱에 대해서 가장 윗장을 take한다.
			//cd.getCard()를 보면 cardDeck.remove(0)이므로 뽑은 카드는 가장 위에있는 카드이며 뽑는순간
			//덱에서 삭제가 된다.
		}
	}

	
	@Override
	public String toString() {
		return takeCard.toString();
	}
	
	
}
