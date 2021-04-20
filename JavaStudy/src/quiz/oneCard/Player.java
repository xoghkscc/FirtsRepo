package quiz.oneCard;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> takeCard = new ArrayList<Card>(); 
	CardDeck cd;
	public Player(CardDeck cd) {
		this.cd = cd;
		for(int i = 0; i<7; i++) {
			takeCard.add(cd.getCard());
		}
	}

	
	@Override
	public String toString() {
		return takeCard.toString();
	}
	
	
}
