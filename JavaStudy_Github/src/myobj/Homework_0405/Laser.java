package myobj.Homework_0405;

import myinterface.Print_0405;

public class Laser implements Print_0405 {

	@Override
	public void print(String contents, int num) {
		System.out.printf("������ �����ͷ� %s�� %d�� ���!\n", contents, num);

	}

}
