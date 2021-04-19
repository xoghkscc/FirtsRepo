import java.util.ArrayList;
import java.util.Collections;

public class D01_ArrayList {
	
	public static void main(String[] args) {
		
		
		ArrayList<String> fruits = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		
		fruits.add("apple");
		fruits.add("kiwi");
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("kiwi");
		
		fruits.add(2, "banana");
		fruits.add(2, "peach");
		numbers.add(10);
		numbers.add(40);
		numbers.add(20);
		numbers.add(30);
//		System.out.println(numbers);
//		System.out.println(fruits.size());
		
		System.out.println(fruits);
		System.out.println(fruits.get(0));
		
		
		String deleted_fruit = fruits.remove(3);
		
		System.out.println(fruits);
		System.out.println(deleted_fruit);
		if(fruits.remove("strawberry")) {
			System.out.println("strawberry를 성공적으로 삭제");
		}else {
			System.out.println("strawberry가 없어서 삭제 몬함");
		}
		
		Collections.sort(fruits);
		System.out.println(fruits);
		Collections.sort(numbers);
		System.out.println(numbers);
	}
	
}
