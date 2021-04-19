package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class D02_1_LottoSet {
	static // 1~45사이의 중복없는 랜덤숫자 7개로 이루어진 hashSet을 생성하는 반환하는 메서드를 작성후 테스트
	// 1~45사이의 중복없는 랜덤숫자 7개로 이루어진 Arraylist을 생성하는 반환하는 메서드를 작성후 테스트
	HashSet<Integer> lotto;
	Random ran;
	static ArrayList<Integer> arrLotto;
	
	public static void main(String[] args) {
		D02_1_LottoSet ls = new D02_1_LottoSet();
		
		System.out.println(ls.lotto());//1번
		
		arrLotto = arrLotto(ls.lotto());
		System.out.println(arrLotto);//2번
		
		Integer[] intLotto = ls.intLotto(ls.lotto());
		System.out.println(Arrays.toString(intLotto));//3번
	}

	public HashSet<Integer> lotto() {
		lotto = new HashSet<>();
		ran = new Random();
		while (lotto.size() < 7) {
			lotto.add(ran.nextInt(45) + 1);
		}
		return lotto;
	}
	
	public static ArrayList<Integer> arrLotto(HashSet<Integer> lotto) {
		arrLotto = new ArrayList<Integer>(lotto);
		return arrLotto;
	}
	
	
	public Integer[] intLotto(HashSet<Integer> lotto) {
		Integer[] arr2 = new Integer[lotto.size()];
		lotto.toArray(arr2);
		return arr2;
	}
}
