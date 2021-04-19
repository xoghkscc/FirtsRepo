package myobj.YachtDice;

public class YachtRule {
	int[] dice;
	int[] cnt;
	boolean tf;
	boolean[] bl = new boolean[5];
	int sum, maxScore;
	String[] name = {"풀하우스", "스몰 스트레이트", "라지스트레이트", "4다이스", "5다이스"};
	
	public YachtRule(int[] dice) {
		this.dice = dice;

	}

	public int gameStart() {
		diceSum();
		bl[0] = fullhouse();
		bl[1] = smallStraight();
		bl[2] = largeStraight();
		bl[3] = fourDice();
		bl[4] = fiveDice();
		showScore();
		return maxScore;
		
	}
	public void diceSum() {
		sum = 0;
		for (int i = 0; i < dice.length; i++) {
			sum += dice[i];
		}
		this.sum = sum;
	}
	public boolean fullhouse() {
		tf = false;
		cnt = new int[5];
		int cnt1 = 0;
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[i] == dice[j]) {
					cnt[i]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == 2 || cnt[i] == 3) {
				cnt1++;
			}
		}
		if (cnt1 == 5) {
//			System.out.println("풀하우스 성공");
			tf = true;
		}
		return tf;
	}

	public boolean smallStraight() {
		tf = false;
		cnt = new int[5];
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[i] >= dice[j] + 1) {
					cnt[i]++;
					if (dice[i] >= dice[j] + 2) {
						cnt[i]++;
						if (dice[i] == dice[j] + 3) {
							cnt[i]++;
						}
					}
				}
				if(cnt[i]==6) {
					break;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i]==6 ) {
//				System.out.println("스몰스트레이트 성공");
				tf = true;
				break;
			}
		}
		return tf;
	}
	
	public boolean largeStraight() {
		tf = false;
		cnt = new int[5];
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[i] >= dice[j] + 1) {
					cnt[i]++;
					if (dice[i] >= dice[j] + 2) {
						cnt[i]++;
						if (dice[i] >= dice[j] + 3) {
							cnt[i]++;
							if (dice[i] == dice[j] + 4) {
								cnt[i]++;
							}
						}
					}
				}
				if(dice[i] >= dice[j] + 5) {
					cnt[i]=0;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i]==10) {
//				System.out.println("라지스트레이트 성공");
				tf = true;
				break;
			}
		}
		return tf;
	}

	public boolean fourDice() {
		tf = false;
		cnt = new int[5];
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[i] == dice[j]) {
					cnt[i]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i]==4) {
//				System.out.println("4다이스 성공");
				tf = true;
				break;
			}
		}
		return tf;
	}
	
	public boolean fiveDice() {
		tf = false;
		cnt = new int[5];
		for (int i = 0; i < dice.length; i++) {
			for (int j = 0; j < dice.length; j++) {
				if (dice[i] == dice[j]) {
					cnt[i]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i]==5) {
//				System.out.println("5다이스 성공");
				tf = true;
			}
			break;
		}
		return tf;
	}
	
	public void showScore() {
		int[] score = {sum, 15, 30, sum, 50};
		maxScore=0;
		for (int i = 0; i < dice.length; i++) {
			if(bl[i]) {
				System.out.println("해당되는 족보는 " + name[i]+", 해당되는 점수는 " + score[i]);
				if(maxScore<=score[i]) {
					maxScore = score[i];
				}
			}
		}
		if(!bl[0] && !bl[1] && !bl[2] && !bl[3] && !bl[4]) {
			System.out.println("얻을 수 있는 점수는 없습니다.");
		}
	}
}
