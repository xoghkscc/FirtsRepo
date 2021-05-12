package quiz.oneCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;


class CardDeck{
	ArrayList<Card> cardDeck = new ArrayList<Card>();
	public CardDeck() {
		for (int i=0; i<13; i++) {
			for(int j=0; j<4; j++) {
				Card card2 = new Card();
				card2.cardGet(i, j);
				cardDeck.add(card2);
			}
		}
		Collections.shuffle(cardDeck);//카드덱에 순서대로 쌓여있으므로 무작위로 섞어야함
	}
	
	public Card getCard() {
		return cardDeck.remove(0);
	}
}


class Card{
	String[] showNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	String[] shape = {"♠", "♣", "♥", "◆"};
	String gameNum=null, gameShape=null;
	int gameRealNum;
	public void cardGet(int i, int j) {
		this.gameNum = showNum[i];
		this.gameShape = shape[j];
	}
	
	@Override
	public String toString() {
		
		return gameNum+"("+gameShape+")";
	}
}

