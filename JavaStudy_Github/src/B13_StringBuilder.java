
public class B13_StringBuilder {
	public static void main(String[] args) {
		String text = "Spring Framework";
//		System.out.println(text);
	
		
		long start_time = System.currentTimeMillis(); //String 클래스로 시작 
		
		for(int test = 0; test < 1000000; test++) {
			String reversed_text = "";
			for(int i = 0; i < text.length(); i++) {
				reversed_text += text.charAt(text.length()-1-i);
			}
		}
//		System.out.println(reversed_text);
		
		long taken_time = System.currentTimeMillis()-start_time;
		
		
		
		start_time = System.currentTimeMillis();
		
		for(int test = 0; test < 1000000; test++) {
			StringBuilder reversed_text2 = new StringBuilder();
			for(int i = 0; i < text.length(); i++) {
				char ch = text.charAt(text.length()-1-i);
				reversed_text2.append(ch);
			}
		}
		
//		System.out.println(reversed_text2);
		
		long end_time = System.currentTimeMillis()-start_time;
		
		System.out.println(taken_time +":"+ end_time);
		
	}
}
