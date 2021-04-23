package quiz.oneCard;

import java.util.ArrayList;
import java.util.HashSet;

import myobj.MyScanner;
//
public class E02_1_OneCard {
	//처음에 카드덱을 정해놓고 시작 
	static CardDeck cd = new CardDeck();
	public static void main(String[] args) {
		E02_1_OneCard oc = new E02_1_OneCard();
		ArrayList<Player> player;
		
		int playerNum = MyScanner.inputInt("플레이어 몇명?>>");
		//입력한 플레이어 수 만큼 player list에 카드 7장을 쥔 player들을 추가
		player = oc.addPlayer(playerNum);
		GameStart gs = new GameStart(player, cd);//게임 로직안에 플레이어들과 남은 덱을 넘긴다
		
	}
	
	public ArrayList<Player> addPlayer(int playerNum) {
		ArrayList<Player> player = new ArrayList<Player>();
		for(int i=0; i<playerNum; i++) {
			player.add(new Player(cd));
			//Player 클래스를 list에 추가 (이때 카드덱 cd를 넘긴다)
		}
		
		return player;
	}
}

