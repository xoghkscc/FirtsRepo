import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;

public class D05_Comparator {
	public static void main(String[] args) {

		LinkedList<Grape> grapes = new LinkedList<Grape>();

		for (int i = 0; i < 10; i++) {
			grapes.add(new Grape().setGno(String.format("PODO%04d", (int)(Math.random()*10000)))
					.setLocation((int) (Math.random() * Grape.LOCATIONS)).setFruit((int) (Math.random() * 11 + 30)));// Grape의 메서드들의 리턴타입이 Grape라서그럼
//			System.out.println(grapes.getLast());
		}
		Grape podo1 = new Grape().setGno("PODO11588");
		Grape podo2 = new Grape().setGno("PODO11588");
//		System.out.println(podo1.equals(podo2));//toString을 오버라이드하여 객체끼리 같은지 보겠다는 것

		Collections.sort(grapes, new 포도분류기_포도알맹이_오름차순());
		System.out.println("----------------정렬 후(오름차순)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}

		Collections.sort(grapes, new 포도분류기_포도알맹이_내림차순());
		System.out.println("----------------정렬 후(내림차순)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}

		Collections.sort(grapes, new 포도분류기_포도gno_내림차순());
		System.out.println("----------------정렬 후(gno내림차순)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}
	}
}

class 포도분류기_포도gno_내림차순 implements Comparator<Grape> {
	// -compare 메서드의 리턴 값이 1이면 o1과 o2의 순서를 바꾼다
	// -compare 메서드의 리턴 값이 0이면 같은 크기로 취급한다.
	// -compare 메서드의 리턴 값이 -1이면 o1과 o2의 순서를 그대로 유지한다.
	@Override
	public int compare(Grape o1, Grape o2) {
		return o1.gno.compareTo(o2.gno);
		
//		char[] ch3 = o1.gno.toCharArray();
//		char[] ch4 = o2.gno.toCharArray();
//		
//		int i = 0;
//		while (true) {
//			if (ch3[i] < ch4[i]) {
//				return 1;
//			} else if (ch3[i] > ch4[i]) {
//				return -1;
//			} 
//			i++;
//		}
//		String s1 = "";
//		String s2 = "";
//		for (int j = 0; j < 4; j++) {
//			s1 += ch1[4 + j];
//			s2 += ch2[4 + j];
//		}
//		if (Integer.parseInt(s1) < Integer.parseInt(s2)) {
//			return 1;
//		} else if (Integer.parseInt(s1) == Integer.parseInt(s2)) {
//			return 0;
//		} else {
//			return -1;
//		}

	}
}

class 포도분류기_포도알맹이_내림차순 implements Comparator<Grape> {
	// -compare 메서드의 리턴 값이 1이면 o1과 o2의 순서를 바꾼다
	// -compare 메서드의 리턴 값이 0이면 같은 크기로 취급한다.
	// -compare 메서드의 리턴 값이 -1이면 o1과 o2의 순서를 그대로 유지한다.
	@Override
	public int compare(Grape o1, Grape o2) {
		if (o1.fruit < o2.fruit) {
			return 1;
		} else if (o1.fruit == o2.fruit) {
			return 0;
		} else {
			return -1;
		}
	}
}

class 포도분류기_포도알맹이_오름차순 implements Comparator<Grape> {
	// -compare 메서드의 리턴 값이 1이면 o1과 o2의 순서를 바꾼다
	// -compare 메서드의 리턴 값이 0이면 같은 크기로 취급한다.
	// -compare 메서드의 리턴 값이 -1이면 o1과 o2의 순서를 그대로 유지한다.
	@Override
	public int compare(Grape o1, Grape o2) {
		if (o1.fruit < o2.fruit) {
			return -1;
		} else if (o1.fruit == o2.fruit) {
			return 0;
		} else {
			return 1;
		}
	}
}

class Grape {
	private static String[] locationNames = { "말레이시아", "칠레", "싱가포르", "브라질", "호주" };
	public static int LOCATIONS = locationNames.length;

	String gno;
	int location;
	int fruit;

	Grape setGno(String gno) {
		this.gno = gno;
		return this;
	}

	Grape setLocation(int location_id) {
		this.location = location_id;
		return this;
	}

	Grape setFruit(int fruit) {
		this.fruit = fruit;
		return this;
	}

	@Override
	public String toString() {
		return gno + "/" + fruit + "/" + locationNames[location] + "/";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.gno == ((Grape) obj).gno;
	}
}