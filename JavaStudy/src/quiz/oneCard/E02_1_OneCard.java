package quiz.oneCard;

import java.util.ArrayList;
import java.util.HashSet;

import myobj.MyScanner;

public class E02_1_OneCard {
	static CardDeck cd = new CardDeck();
	//원카드 만들기
	public static void main(String[] args) {
		E02_1_OneCard oc = new E02_1_OneCard();
		ArrayList<Player> player;
		
		int playerNum = MyScanner.inputInt("플레이어 몇명?>>");
		player = oc.addPlayer(playerNum);
		GameStart gs = new GameStart(player, cd);//게임 로직안에 플레이어들과 남은 덱을 넘긴다
		
	}
	
	public ArrayList<Player> addPlayer(int playerNum) {
		ArrayList<Player> player = new ArrayList<Player>();
		for(int i=0; i<playerNum; i++) {
			player.add(new Player(cd));
		}
		
		return player;
	}
}

