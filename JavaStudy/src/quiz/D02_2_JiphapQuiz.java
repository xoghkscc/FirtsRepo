package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//제네릭을 설정해둔 클래스는 인스턴스 생성시 원하는 타입을 고를 수 있게 된다.
//고르지 않으면 object로 설정된다
public class D02_2_JiphapQuiz<T> {
	//1. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 합집합을 Set타입으로 반환하는 메서드
	//2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set타입으로 반환하는 메서드
	//3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set타입으로 반환하는 메서드
	
	
	public Set<T> union(Collection<T> collection1, Collection<T> collection2) {
		ArrayList<T> list1 = new ArrayList<>(collection1);
		list1.addAll(collection2);
		return new HashSet(list1); 
	}//합집합
	
	public Set<T> intersection(Collection<T> collection1, Collection<T> collection2) {
		ArrayList<T> list1 = new ArrayList<>(collection1);
		list1.retainAll(collection2);
		return new HashSet(list1); 
		
	}//교집합
	
	public Set<T> difference_of_sets(Collection<T> collection1, Collection<T> collection2) {
		collection1	.removeAll(collection2);
		return new HashSet(collection1); 
	}//차집합-->단 앞에 있는 콜렉션을 기준으로 차집합
	
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> al = new ArrayList<>();
		D02_2_JiphapQuiz<Integer> jq = new D02_2_JiphapQuiz<Integer>();
		hs.add(1);
		al.add(1);
		hs.add(2);
		al.add(2);
		
		hs.add(3);
		al.add(4);
		hs.add(5);
		al.add(6);
		
		hs.add(100);
		al.add(50);
		
		System.out.println("hs : " +hs);
		System.out.println("al : " +al);
		
		System.out.println(jq.union(hs, al));//1 2 3 4 5 6 50 100
		System.out.println(jq.intersection(hs, al));//1 2
		System.out.println(jq.difference_of_sets(hs, al));//3 5 100
	}
}
