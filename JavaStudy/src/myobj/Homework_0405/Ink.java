package myobj.Homework_0405;

import myinterface.Print_0405;

public class Ink implements Print_0405 {

	@Override
	public void print(String contents, int num) {
		System.out.println("잉크 프린터로 " + contents + "을 " + num + "장 출력!");

	}

}
