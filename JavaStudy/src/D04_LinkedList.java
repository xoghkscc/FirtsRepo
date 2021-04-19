import java.util.ArrayList;
import java.util.LinkedList;

public class D04_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<>();
		
		//LinkedList의 add들
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
//		//LinkedList의 get들
//		System.out.println(animals.get(3));
//		System.out.println(animals.getFirst());
//		System.out.println(animals.getLast());
//		
//		//pop() : 리스트에서 데이터를 읽고 버린다
//		while(animals.size()!=0) {
//			System.out.println("pop!(poll!) : "+animals.poll());
//		}
//		
//		System.out.println("after pop: "+ animals);
//		
//		//pollLast(): 리스트의 맨 뒤 데이터를 읽고 버린다.
//		ArrayList<String> cage = new ArrayList<String>();
//		cage.add("rabbit");
//		cage.add("hamster");
//		cage.add("bird");
//		cage.add("fish");
//		
//		animals.addAll(cage);
//		
//		while(animals.size()!=0) {
//			System.out.println("뒤에서부터 꺼내기 : "+animals.pollLast());
//		}
//		
//		System.out.println("after pollLast: "+ animals);
		
		//성능 테스트
		int testSize = 1000000;
		ArrayList<Integer> arr = new ArrayList<>(testSize);
		
		for (int i = 0; i < testSize; i++) {
			arr.add(i);
		}
		
		LinkedList<Integer> linked = new LinkedList<>();
		
		for (int i = 0; i < testSize; i++) {
			linked.add(i);
		}
		
		//데이터 추가 성능비교
		System.out.println("1. ArrayList Insertion Test");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			arr.add(50, 10);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("소모된 시간 : "+(endTime - startTime)+"ms");		
		
		
		System.out.println("2. LinkedList Insertion Test");
		 startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			linked.add(50, 10);
		}
		 endTime = System.currentTimeMillis();
		System.out.println("소모된 시간 : "+(endTime - startTime)+"ms");		
		
		
		
	}
}
