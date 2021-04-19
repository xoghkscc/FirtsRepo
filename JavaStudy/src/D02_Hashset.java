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
		numbers3.add("ȫ�浿");
		numbers3.add('A');
		
//		String str = (String)numbers3.get(0);//���׸��� ���ϸ� ObjectŸ���̹Ƿ� �ٿ�ĳ���� �ؾ���
		
		//toArray()�� �迭�� �ٲ��ִ� ����
		Object[] arr1 = english.toArray();//1�� ���, Object[] ����
		
		String[] arr2 = new String[english.size()]; //2�� ���, �̸� ������ �迭�� ����
		english.toArray(arr2);
		
//		System.out.println("Object[]�� ��ȯ�� english : " + Arrays.toString(arr1));
//		System.out.println("�迭�� ��ȯ�� english : " + Arrays.toString(arr2));
		
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
		
		System.out.println("english���� subset�� ��� ������ ����ֳ���? " +english.containsAll(subset));//false
		System.out.println("english���� sublist�� ��� ������ ����ֳ���? " +english.containsAll(sublist));//true
		
		english.addAll(subset);
		System.out.println(english);
		
		english_list.removeAll(subset);
		System.out.println(english_list);
		
		english.retainAll(subset);
		System.out.println(english);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
