package quiz;

public class B15_1_WhileBasicQuiz {
	public static void main(String[] args) {
		//while���� �̿��Ͽ�
		//1. 1���� 100������ 3�� ����� ����
		//2. 200���� 1���� ���
		//3. continue�� �̿��Ͽ� 300���� 500������ 7�� ����� ���
		//4. 1���� 200������ ���� �� 2�� ����� �ƴϰ� 3�� ����� �ƴ� ���ڵ��� ���� 
		
		int sum=0;
		int i = 1;
		
		while(i<=100) {
			if(i % 3 == 0) {
				sum+= i;
			}
			i++;
		}
		System.out.printf("1 : 1���� 100������ 3�� ����� ���� : %d", sum);
		System.out.println();
		
		i = 200;
		System.out.print("2 : 200���� 1���� ��� : ");
		while(i>=1) {
			System.out.print(i+" ");
			i--;
		}
		System.out.println();
		
		i = 300;
		
		System.out.print("3 : 300���� 500���� 7�� ����� ��� : ");
		while(i<=500) {
			if(i++ % 7 != 0) {
				continue;
			}else {
			System.out.print(i-1+" ");
			}
		}
		System.out.println();
		
		i = 1;
		sum = 0;
		System.out.print("4 : 1���� 200������ ���� �� 2�� ����� �ƴϰ� 3�� ����� �ƴ� ���ڵ��� ���� ��� : ");
		while(i<=200) {
			if(i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}
			i++;
		}
		
		System.out.print(sum);
	}
}
