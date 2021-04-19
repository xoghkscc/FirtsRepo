import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class C13_Exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반드시 숫자만 입력 :");
		try {
			System.out.println("입력한 숫자 : " +sc.nextInt());
		} catch(InputMismatchException e) {
			e.printStackTrace();//에러에 대한 정보 출력
			System.out.println("getMessage : " +e.getMessage());
			System.out.println("이상한 걸 입력함");
			return;
		} catch(IllegalStateException e) {
			System.out.println("스캐너가 닫혀있는데");
		} catch(NoSuchElementException e) {
			System.out.println("스캐너에 읽을 내용이 없는데");
		}finally {
			System.out.println("토끼 ㅎㅇ");
		}
		System.out.println("프로그램이 정상적으로 종료되었습니다.");
	}
}
