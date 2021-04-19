import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes.Name;

public class C15_Throw {
	public static void main(String[] args) {
		C15_Throw instance = new C15_Throw();
		try {
			instance.dangerous_method();
			instance.dangerous_method2();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 터짐: " + e.getMessage());
		}

		try {
			instance.checkEven(20);// checkEven에 if를 판단하고 홀수이면 throw new NotEvenExcption()을 실행해서 예외처리하게 됨
			instance.checkOdd(14);// checkOdd에 if를 판단하고 홀수이면 throw new NotOddException()을 실행해서 예외처리하게 됨(강제아님)
		} catch (NotEvenExcption e) {
			System.out.println("짝수 아님 익셉션 발생! " + e.getMessage());
		} catch (NotOddException e) {
			System.out.println("홀수 아님 익셉션 발생!" + e.getMessage());
		}
	}
	public void checkEven(int num) throws NotEvenExcption {//예외처리를 메서드를 불러온 곳에 처리를 넘긴다
		if (num % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			throw new NotEvenExcption();// 예외처리하지 않으면 빨간줄이 뜸(Exception을 상속받았기 때문)
		}
		System.out.println("checkEven 메서드가 정상 종료");
	}
	public void checkOdd(int num) {
		if (num % 2 == 1) {
			System.out.println("홀수입니다");
		} else {
			throw new NotOddException();// RuntimeExceptiond을 상속받았기게 예외처리하지 않아도 빨간줄이 안뜸
		}
		System.out.println("checkOdd 메서드가 정상 종료");
	}
	
//짝수가 아닐 때 발생시킬 예외(예외처리 하지 않으면 컴파일 불가)
	class NotEvenExcption extends Exception {
		public NotEvenExcption() {
			super("짝수가 아니어서 발생하는 예외");
		}
	}
//홀수가 아닐 때 발생시킬 예외(예외처리 하지 않아도 빨간줄이 뜨지 않는 예외)
	class NotOddException extends RuntimeException {
		public NotOddException() {
			super("홀수가 아니어서 발생하는 예외");
		}
	}
	
	public void dangerous_method() {
		// 파일의 내용을 읽어오기 위한 준비 과정
		File f = new File("D:\\nameless.txt");
		try {
			FileReader reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dangerous_method2() {
		throw new ArrayIndexOutOfBoundsException("그냥 만들었음");
	}

}
