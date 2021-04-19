import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class D06_TreeSet {
	public static void main(String[] args) {
		TreeSet<Grape> grape_tree2 = new TreeSet<>(new 포도분류기_포도알맹이_오름차순());
		TreeSet<Mango> mango_tree = new TreeSet<>();//-->Mango클래스가 Comparable을 상속받앗기에 가능한 일
		TreeSet<Mango> mango_tree2 = new TreeSet<>(new MangoCompareByMnoAsc());//-->정렬 기준을 바꿔주고 싶으면 이렇게하면 됨
		//-->즉 이렇게 되면 앞으로 자동정렬이 됨
		
		mango_tree2.add(new Mango("fnsdknak", 120, 10));
		mango_tree2.add(new Mango("grwerw", 110, 20));
		mango_tree2.add(new Mango("tewdfxc", 10, 30));
		mango_tree2.add(new Mango("23wefsadf", 90, 80));
		mango_tree2.add(new Mango("sadsagsdth", 80, 70));
		
//		System.out.println(mango_tree2);
		
		
		//해당 객체 자체가 비교 가능한 객체라면 Comparator를 사용하지 않을 수 있다.
		TreeSet<String> word_tree = new TreeSet<String>();
		
		word_tree.add("cat");
		word_tree.add("pet");
		word_tree.add("pat");
		word_tree.add("fat");
		word_tree.add("bat");
		
		
		mango_tree.add(new Mango("54321", 10, 10));
		mango_tree.add(new Mango("123", 10, 10));
		mango_tree.add(new Mango("9999", 10, 10));
		mango_tree.add(new Mango("13", 10, 10));
		
//		System.out.println(mango_tree);
		
		
		System.out.println(word_tree);//bat cat fat pat pet
		System.out.println(word_tree.descendingSet());// pet pat fat cat bat
		System.out.println(word_tree.headSet("pat"));// bat cat fat
		System.out.println(word_tree.tailSet("pat"));// pat pet
		System.out.println(word_tree.subSet("cat", "pet"));//cat fat pat
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(5);
		int_tree.add(15);
		int_tree.add(75);
		int_tree.add(33);
		int_tree.add(21);
		int_tree.add(9);
		int_tree.add(1);
		
		System.out.println(int_tree); //1 5 9 15 21 33 75 99
		System.out.println(int_tree.ceiling(20)); // 21
		System.out.println(int_tree.ceiling(22)); // 33
		System.out.println(int_tree.ceiling(34)); // 75
		System.out.println(int_tree.floor(21)); // 21
		System.out.println(int_tree.floor(17)); // 15
		System.out.println(int_tree.floor(78)); // 75
	}
	
}

//연습문제 :  망고트리에 망고 5개를 추가하고 mno기준 오름차순 정렬이 되도록 만들고 확인

class MangoCompareByMnoAsc implements Comparator<Mango> {
	// [3, 2, 3, 8, 99, 1, 5, 8, 9]
	//
	
	@Override
	public int compare(Mango o1, Mango o2) {
		return o1.mno.compareTo(o2.mno);
	}
	
}

class Mango implements Comparable<Mango>{
	int sweet;
	String mno;
	int size;
	//this vs 매개변수로 compaer 메서드를 구현하면 된다
	public int compareTo(Mango o) {
		
		return this.mno.compareTo(o.mno);
	}

	public Mango(String mno, int sweet, int size) {
		this.mno = mno;
		this.sweet=sweet;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "mno : "+ mno + "/ sweet : " + sweet + "/ size : " + size;
	}

}
