package myobj.game.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class HandRanking {
	ArrayList<Card> player;
	public HandRanking(HashSet<Card> card) {
		player = new ArrayList<Card>(card);
		Collections.sort(player, new cardSorting());
		this.player = player;
		
	}

	public boolean checkShape() {
		boolean cnt = false;
		int[] cnt2 = new int[4];
		for (Card card2 : player) {
			cnt2[player.get(0).suit.getValue()]++;
			for (int i = 0; i < cnt2.length; i++) {
				if(cnt2[i] == 5) {
					cnt = true;
				}
			}
		}
		return cnt;
	}
	
//	public boolean straightFlush() {
//		boolean tf = true;
//		for (Card card : player) {
//			
//		}
//	}

	
	
}







class cardSorting implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.rank.getValue()<o2.rank.getValue()) {
			return -1;
		}else if(o1.rank.getValue()==o2.rank.getValue()) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
