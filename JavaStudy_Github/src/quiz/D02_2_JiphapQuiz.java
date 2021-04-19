package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//���׸��� �����ص� Ŭ������ �ν��Ͻ� ������ ���ϴ� Ÿ���� �� �� �ְ� �ȴ�.
//���� ������ object�� �����ȴ�
public class D02_2_JiphapQuiz<T> {
	//1. �� �÷����� �Ű������� ���� ������ �� �÷����� �������� SetŸ������ ��ȯ�ϴ� �޼���
	//2. �� �÷����� �Ű������� ���� ������ �� �÷����� �������� SetŸ������ ��ȯ�ϴ� �޼���
	//3. �� �÷����� �Ű������� ���� ������ �� �÷����� �������� SetŸ������ ��ȯ�ϴ� �޼���
	
	
	public Set<T> union(Collection<T> collection1, Collection<T> collection2) {
		ArrayList<T> list1 = new ArrayList<>(collection1);
		list1.addAll(collection2);
		return new HashSet(list1); 
	}//������
	
	public Set<T> intersection(Collection<T> collection1, Collection<T> collection2) {
		ArrayList<T> list1 = new ArrayList<>(collection1);
		list1.retainAll(collection2);
		return new HashSet(list1); 
		
	}//������
	
	public Set<T> difference_of_sets(Collection<T> collection1, Collection<T> collection2) {
		collection1	.removeAll(collection2);
		return new HashSet(collection1); 
	}//������-->�� �տ� �ִ� �ݷ����� �������� ������
	
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
