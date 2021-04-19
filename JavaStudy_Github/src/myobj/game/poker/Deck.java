package myobj.game.poker;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	
	LinkedList<Card> deck;
	
	public Deck() {
		deck = new LinkedList<>();
		
		for (Suit suit : Card.SUITS) {
			for (Rank rank : Card.RANKS) {			
				deck.add(new Card(suit, rank));
			}			
		}	
		
		Collections.shuffle(deck); // ¼¯±â
	}
	
	public Card draw() {
		return deck.pop();
	}
	
	@Override
	public String toString() {		
		return deck.toString();
	}
	

//	public static void main(String[] args) {
//		Deck d1 = new Deck();
//		System.out.println(d1);
//		
//		// 7Àå »Ì¾Æº¸±â
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		System.out.println(d1.draw());
//		
//		System.out.println(d1);
//	}
}











