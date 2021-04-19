import java.util.Scanner;

public class B15_while {
	public static void main(String[] args) {
		
		int i = 0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		
		i = 0;
		
		while(++i<10) {
			System.out.println("¹Ý¸ñ¹® 2 : "+ i);
			
		}
		Scanner sc1 = new Scanner("apple banana orange");
		Scanner sc2 = new Scanner("1234 1588 1241");
		
		while(sc1.hasNext()) {
			System.out.println(sc1.next());
		}
		
		while(sc2.hasNextInt()) {
			System.out.println(sc2.nextInt());
		}
	}
}
