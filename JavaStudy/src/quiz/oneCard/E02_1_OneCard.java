package quiz.oneCard;

import java.util.ArrayList;
import java.util.HashSet;

import myobj.MyScanner;
//
public class E02_1_OneCard {
	//ó���� ī�嵦�� ���س��� ���� 
	static CardDeck cd = new CardDeck();
	public static void main(String[] args) {
		E02_1_OneCard oc = new E02_1_OneCard();
		ArrayList<Player> player;
		
		int playerNum = MyScanner.inputInt("�÷��̾� ���?>>");
		//�Է��� �÷��̾� �� ��ŭ player list�� ī�� 7���� �� player���� �߰�
		player = oc.addPlayer(playerNum);
		GameStart gs = new GameStart(player, cd);//���� �����ȿ� �÷��̾��� ���� ���� �ѱ��
		
	}
	
	public ArrayList<Player> addPlayer(int playerNum) {
		ArrayList<Player> player = new ArrayList<Player>();
		for(int i=0; i<playerNum; i++) {
			player.add(new Player(cd));
			//Player Ŭ������ list�� �߰� (�̶� ī�嵦 cd�� �ѱ��)
		}
		
		return player;
	}
}

