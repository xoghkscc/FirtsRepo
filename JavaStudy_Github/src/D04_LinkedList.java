import java.util.ArrayList;
import java.util.LinkedList;

public class D04_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<>();
		
		//LinkedList�� add��
//		animals.add("tiger");
//		animals.add("lion");
//		animals.add("horse");
//		
//		System.out.println(animals);
//		
//		animals.addFirst("turtle");
//		animals.addLast("monkey");
//		System.out.println(animals);
//		
//		//LinkedList�� get��
//		System.out.println(animals.get(3));
//		System.out.println(animals.getFirst());
//		System.out.println(animals.getLast());
//		
//		//pop() : ����Ʈ���� �����͸� �а� ������
//		while(animals.size()!=0) {
//			System.out.println("pop!(poll!) : "+animals.poll());
//		}
//		
//		System.out.println("after pop: "+ animals);
//		
//		//pollLast(): ����Ʈ�� �� �� �����͸� �а� ������.
//		ArrayList<String> cage = new ArrayList<String>();
//		cage.add("rabbit");
//		cage.add("hamster");
//		cage.add("bird");
//		cage.add("fish");
//		
//		animals.addAll(cage);
//		
//		while(animals.size()!=0) {
//			System.out.println("�ڿ������� ������ : "+animals.pollLast());
//		}
//		
//		System.out.println("after pollLast: "+ animals);
		
		//���� �׽�Ʈ
		int testSize = 1000000;
		ArrayList<Integer> arr = new ArrayList<>(testSize);
		
		for (int i = 0; i < testSize; i++) {
			arr.add(i);
		}
		
		LinkedList<Integer> linked = new LinkedList<>();
		
		for (int i = 0; i < testSize; i++) {
			linked.add(i);
		}
		
		//������ �߰� ���ɺ�
		System.out.println("1. ArrayList Insertion Test");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			arr.add(50, 10);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("�Ҹ�� �ð� : "+(endTime - startTime)+"ms");		
		
		
		System.out.println("2. LinkedList Insertion Test");
		 startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			linked.add(50, 10);
		}
		 endTime = System.currentTimeMillis();
		System.out.println("�Ҹ�� �ð� : "+(endTime - startTime)+"ms");		
		
		
		
	}
}
