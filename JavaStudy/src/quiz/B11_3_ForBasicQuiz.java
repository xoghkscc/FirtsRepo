package quiz;

import java.util.Scanner;

public class B11_3_ForBasicQuiz {
	public static void main(String[] args) {
		//����ڰ� ���ڸ� �Է����� �� 
		//1. 10���� �Է��� ���ڱ����� �� ��
		//2. 1���� �Է��� ���� ������ 5�� ����� ��� ����� ������.
		
		Scanner sc = new Scanner(System.in);
		int num, sum = 0;
		System.out.printf("���ڸ� �Է��� ������ : ");
		num = sc.nextInt();
		for(int i=10; i<=num; i++ ) {
			sum += i;
		}
		System.out.println("1�� ���� :" +sum);
		
		System.out.printf("2�� ���� :");
		for(int j=1; j<=num; j++) {
			if(j%5==0) {
				System.out.print(j+", " );
			}
		}
	}
}


//-->���� �Ѱ�
//
//public class B11_ForBasicQuiz {
//
//        /*          
//                  ����ڰ� ���ڸ� �Է����� ��
//                  
//                  1. 10���� �Է��� ���ڱ����� �� ���� ���غ����� 
//         
//                  2. 1���� �Է��� ���� ������ 5�� ����� ��� ����غ����� 
//        */
//        public static void main(String[] args) {
//                
//                // 1�� ������ ���� ���ڴ� 10, 2�� ������ ���� ���ڴ� 1
//                int start1 = 10, start2 = 1;
//                
//                int end1 = -50, end2 = -50;
//                int sum = 0;
//                
//                // ���� start���� end������ ũ�ٸ�, �� ���� ��ȯ�Ѵ�
//                if (start1 > end1) {
//                        int temp = start1;
//                        start1 = end1;
//                        end1 = temp;
//                }
//                
//                if (start2 > end2) {
//                        int temp = start2;
//                        start2 = end2;
//                        end2 = temp;
//                }
//                
//                for (int i = start1; i <= end1; ++i) {
//                        sum += i;                
//                }                
//                
//                System.out.println("10���� user�� �Է��� ���ڱ����� ����: " + sum);
//                
//                System.out.println();
//                System.out.printf("#### 1 ~ %d ������ 5�� ����� ��� ####\n", 
//                                start2 > end2 ? end2 : start2);
//                for (int i = start2; i <= end2; ++i) {
//                        
//                        if (i % 5 == 0) {
//                                System.out.println(i);
//                        }                        
//                }
//        }
//        
//}
