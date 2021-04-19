
public class B08_Switch {
	public static void main(String[] args) {
		int a = 11;
		
		switch (a % 2) {
		case 0:
			System.out.println("a는 짝수");
			break;

		case 1:
			System.out.println("a는 홀수");
			break;

		default:
			break;
		}
		
		char grade = 'e';
		
		switch (grade) {
		case 'E': case 'e':
			System.out.println("전체 관람가");
			break;
		case 'K': case 'k':
			System.out.println("12세 이상 관람가");
			break;
		case 'Y':
			System.out.println("15세 이상 관람가");
			break;
		case 'A':
			System.out.println("청소년 관람불가입니다.");
			break;

		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}
	}
}
