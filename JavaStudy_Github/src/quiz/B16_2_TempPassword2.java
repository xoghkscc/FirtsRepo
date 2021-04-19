package quiz;

public class B16_2_TempPassword2 {
	public static void main(String[] args) {
		//문자셋을 만들어두고 인덱스를 랜덤으로 선택하는 방식
		
		String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		int password_size = 4;
		
		for (int i = 0; i < password_size; i++) {
			int random_index =(int)(Math.random()*charset.length());
			System.out.print(charset.charAt(random_index));
		}
		
		
	}
}	
