package myobj.YachtDice;

import java.util.Arrays;
import java.util.Scanner;

public class C08_FiveDice {
	//�������� 5���� �ֻ����� ���� ������ ����� ���� ������ �����ϴ� Ŭ������ ����� ������.
	//1. Ǯ�Ͽ콺(���� ���� 2�� + 3��) (ex. 11666, 22333)-�ֻ��� ���� ���� 
	//2. ���� ��Ʈ����Ʈ(1234/2345/3456) -15��  
	//3. ���� ��Ʈ����Ʈ(12345/45623) - 30��
	//4. 4 ���̽� (���� ���� 4��) -�ֻ��� �� ����
	//5. 5 ���̽� (���� ���� 5��)-50��
	
	//��� �ֻ����� ������ �޼���
	//���ϴ� �ֻ����� �����ϰ� �������� ������ �޼���
	//�ֻ����� ���� ������ ���� ���� 1~5 �� �ش��ϴ� ���� �ִ��� üũ�ϴ� �ż���
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("�÷��̾��� ���� ���ϼ��� : ");
		DiceLogic dl = new DiceLogic(sc.nextInt());
		dl.game();
		
	}
}
