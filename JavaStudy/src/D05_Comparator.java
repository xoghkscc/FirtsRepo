import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;

public class D05_Comparator {
	public static void main(String[] args) {

		LinkedList<Grape> grapes = new LinkedList<Grape>();

		for (int i = 0; i < 10; i++) {
			grapes.add(new Grape().setGno(String.format("PODO%04d", (int)(Math.random()*10000)))
					.setLocation((int) (Math.random() * Grape.LOCATIONS)).setFruit((int) (Math.random() * 11 + 30)));// Grape�� �޼������ ����Ÿ���� Grape�󼭱׷�
//			System.out.println(grapes.getLast());
		}
		Grape podo1 = new Grape().setGno("PODO11588");
		Grape podo2 = new Grape().setGno("PODO11588");
//		System.out.println(podo1.equals(podo2));//toString�� �������̵��Ͽ� ��ü���� ������ ���ڴٴ� ��

		Collections.sort(grapes, new �����з���_�����˸���_��������());
		System.out.println("----------------���� ��(��������)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}

		Collections.sort(grapes, new �����з���_�����˸���_��������());
		System.out.println("----------------���� ��(��������)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}

		Collections.sort(grapes, new �����з���_����gno_��������());
		System.out.println("----------------���� ��(gno��������)------------");
		for (Grape grape : grapes) {
			System.out.println(grape);
		}
	}
}

class �����з���_����gno_�������� implements Comparator<Grape> {
	// -compare �޼����� ���� ���� 1�̸� o1�� o2�� ������ �ٲ۴�
	// -compare �޼����� ���� ���� 0�̸� ���� ũ��� ����Ѵ�.
	// -compare �޼����� ���� ���� -1�̸� o1�� o2�� ������ �״�� �����Ѵ�.
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

class �����з���_�����˸���_�������� implements Comparator<Grape> {
	// -compare �޼����� ���� ���� 1�̸� o1�� o2�� ������ �ٲ۴�
	// -compare �޼����� ���� ���� 0�̸� ���� ũ��� ����Ѵ�.
	// -compare �޼����� ���� ���� -1�̸� o1�� o2�� ������ �״�� �����Ѵ�.
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

class �����з���_�����˸���_�������� implements Comparator<Grape> {
	// -compare �޼����� ���� ���� 1�̸� o1�� o2�� ������ �ٲ۴�
	// -compare �޼����� ���� ���� 0�̸� ���� ũ��� ����Ѵ�.
	// -compare �޼����� ���� ���� -1�̸� o1�� o2�� ������ �״�� �����Ѵ�.
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
	private static String[] locationNames = { "�����̽þ�", "ĥ��", "�̰�����", "�����", "ȣ��" };
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