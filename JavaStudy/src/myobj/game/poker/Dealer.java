package myobj.game.poker;

import java.util.ArrayList;

public class Dealer {

	ArrayList<Card> table;
	Deck deck;
	
	public Dealer(Deck deck) {
		table = new ArrayList<>();
		this.deck = deck;
	}
	
	public void next() {
		table.add(deck.draw());
	}
	
}
