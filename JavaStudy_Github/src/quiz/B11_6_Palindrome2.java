package quiz;

public class B11_6_Palindrome2 {
	public static void main(String[] args) {
		String word = "MAXICO";
		
		boolean m = true;
		for(int i = 0, j = word.length()-1; i< word.length()/2; i++, j--) {
			System.out.printf("'%c' vs '%c'\n", word.charAt(i), word.charAt(j));
			
			if(word.charAt(i) != word.charAt(j)) {
				m = false;
				break;
			}
		}
		System.out.println(m ? "회문" : "회문이 아님");
	}
}
