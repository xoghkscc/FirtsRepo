import java.awt.List;
import java.lang.Character.Subset;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class D02_Hashset {
	public static void main(String[] args) {
		HashSet<Integer> numbers = new HashSet<>();
		
		numbers.add(100);
		numbers.add(1000);
		numbers.add(10000);
		numbers.add(100000);
		numbers.add(1000);
		
		
//		System.out.println(numbers);
//		System.out.println(numbers.remove(100));
//		
//		System.out.println(numbers);
		
		HashSet<String> english = new HashSet<>();
		
		english.add("apple");
		english.add("ariplane");
		english.add("bio");
		english.add("cat");
		english.add("drama");
		english.add("zebra");
		
//		System.out.println(english);
		
//		for(String word : english) {
//			System.out.println(word);
//		}
//		
		
		ArrayList<String> english_list = new ArrayList<>(english);
//		Collections.sort(english_list);
//		System.out.println(english_list);
		
		ArrayList<Integer> numbers2 = new ArrayList<>();
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(1);
		numbers2.add(3);
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(13);
//		System.out.println(numbers2);
//		System.out.println(new HashSet<>(numbers2));
		
		ArrayList numbers3 = new ArrayList();
		numbers3.add(123.123);
		numbers3.add(333);
		numbers3.add("홍길동");
		numbers3.add('A');
		
//		String str = (String)numbers3.get(0);//제네릭을 안하면 Object타입이므로 다운캐스팅 해야함
		
		//toArray()는 배열로 바꿔주는 거임
		Object[] arr1 = english.toArray();//1번 방법, Object[] 생성
		
		String[] arr2 = new String[english.size()]; //2번 방법, 미리 만들어둔 배열을 전달
		english.toArray(arr2);
		
//		System.out.println("Object[]로 변환된 english : " + Arrays.toString(arr1));
//		System.out.println("배열로 변환된 english : " + Arrays.toString(arr2));
		
		Set<String> subset = new HashSet<String>();
		ArrayList<String> sublist = new ArrayList<>();
		
		System.out.println(english.contains("apple"));//true
		System.out.println(english.contains("banana"));//flase
		System.out.println(english_list.contains("apple"));//true
		System.out.println(english_list.contains("banana"));//flase
		
		subset.add("zebra");
		subset.add("drama");
		subset.add("tiger");
		
		sublist.add("apple");
		sublist.add("apple");
		sublist.add("apple");
		
		System.out.println("english에는 subset의 모든 내용이 들어있나요? " +english.containsAll(subset));//false
		System.out.println("english에는 sublist의 모든 내용이 들어있나요? " +english.containsAll(sublist));//true
		
		english.addAll(subset);
		System.out.println(english);
		
		english_list.removeAll(subset);
		System.out.println(english_list);
		
		english.retainAll(subset);
		System.out.println(english);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
