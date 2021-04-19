package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class D05_1_PokerLogic {
	ArrayList<Card> player;

	public D05_1_PokerLogic(ArrayList<Card> player) {
		Collections.sort(player, new compaer());
		System.out.println(player);
		this.player = player;
	}

	public void cardCheck() {
		boolean[] check = {royalFlush(), straightFlush(),fourCard(),fullHouse(), flush(), straight(), triple(), twoPair(),onePair(), true/*high card*/  };
		String[] pedigree = {"royalFlush", "straightFlush", "fourCard", "fullHouse", "flush","straight", "triple", "twoPair", "onePair", "HighCard"};
		
		for (int i = 0; i < pedigree.length; i++) {
			if(check[i]) {
				System.out.println(pedigree[i]);
			}
		}
	}

	public int checkShape() {
		int cnt = 0;
		for (Card card2 : player) {
			if (player.get(0).gameShape.equals(card2.gameShape)) {
				cnt++;
			}
		}
		return cnt;
	}

	public boolean royalFlush() {
		for (Card card1 : player) {
			if (checkShape() == 5) {
				if (player.get(0).realNum == 1 && player.get(1).realNum == 10 && player.get(2).realNum == 11
						&& player.get(3).realNum == 12 && player.get(4).realNum == 13) {
					return true;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean straightFlush() {
		boolean tf = true;
		for (Card card1 : player) {
			
			if (checkShape() == 5) {
				if ((player.get(1).realNum == player.get(0).realNum + 1)
						&& (player.get(2).realNum == player.get(1).realNum + 1)
						&& (player.get(3).realNum == player.get(2).realNum + 1)
						&& (player.get(4).realNum == player.get(3).realNum + 1)) {
					return true;
				} else {
					return false;
				}
			}
			break;
		}
		return false;
	}

	public boolean fourCard() {
		for (Card card1 : player) {
			int cnt = 0;
			for (Card card2 : player) {
				if (card1.realNum==card2.realNum) {
					cnt++;
				}
				if (cnt == 4) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean fullHouse() {
		if (((player.get(0).realNum == player.get(1).realNum) && (player.get(2).realNum == player.get(4).realNum))
				|| ((player.get(0).realNum == player.get(2).realNum)
						&& (player.get(3).realNum == player.get(4).realNum))) {
			return true;
		}
		return false;
	}

	public boolean flush() {
		if (checkShape() == 5) {
			return true;
		}
		return false;
	}

	public boolean straight() {
		if ((player.get(1).realNum == player.get(0).realNum + 1)
				&& (player.get(2).realNum == player.get(1).realNum + 1)
				&& (player.get(3).realNum == player.get(2).realNum + 1)
				&& (player.get(4).realNum == player.get(3).realNum + 1)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean triple() {
		for (Card card1 : player) {
			int cnt = 0;
			for (Card card2 : player) {
				if (card1.realNum==card2.realNum) {
					cnt++;
				}
				if (cnt == 3) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean twoPair() {
		int cnt2 = 0;
		for (Card card1 : player) {
			int cnt = 0;
			for (Card card2 : player) {
				if (card1.realNum==card2.realNum) {
					cnt++;
				}
				if (cnt == 2) {
					cnt++;
				}
			}
		}
		if (cnt2 == 4) {
			return true;
		}
		return false;
	}

	public boolean onePair() {
		int cnt2 = 0;
		for (Card card1 : player) {
			int cnt = 0;
			for (Card card2 : player) {
				if (card1.realNum==card2.realNum) {
					cnt++;
				}
				if (cnt == 2) {
					cnt++;
				}
			}
		}
		if (cnt2 == 2) {
			return true;
		}
		return false;
	}
}


class compaer implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		if(o1.realNum<o2.realNum) {
			return -1;
		}else if(o1.realNum==o2.realNum) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
