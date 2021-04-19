package myobj.Homework_0405;

import myinterface.Print_0405;

public class Laser implements Print_0405 {

	@Override
	public void print(String contents, int num) {
		System.out.printf("레이저 프린터로 %s를 %d장 출력!\n", contents, num);

	}

}
