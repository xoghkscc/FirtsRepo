import java.util.Scanner;

public class B18_Array2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num1 = {1, 2, 3, 4, 5, 6}; 
		int[] num2 = new int[10]; 
		int[] num3 = new int[] {100, 200, 300, 400};
		
		int[][] arr2 = {num1, num2, num3};
		
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println("####" + i + "번째 배열의 길이 : "+arr2[i].length + "####");
//			for (int j = 0; j < arr2[i].length; j++) {
//				System.out.printf("arr2[%d][%d] : %d\n", i, j, arr2[i][j]);
//			}
//			
//		}
		
//		System.out.println(arr2[0]);//-->[I@15db9742)
//		System.out.println("{1, 2, 3, 4, 5, 6}이 저장되어있는 메모리의 시작 주소");
//		System.out.println("num1[0] (실제위치: [I@15db9742): "+num1[0]);//-->1
//		System.out.println("num1[0] (실제위치: [I@15db9742): "+num1[1]);//-->2
//		
//		System.out.println("arr[0][5] :" + arr2[0][5]);//--> 6
//		System.out.println("arr[1][8] :" + arr2[1][8]);//--> 0
//		System.out.println("arr[2][4] :" + arr2[2][3]);//-->400
		
		//활용 예
//		char[][] block1 = {
//				{'□', '□', '■', '■'},
//				{'□', '□', '□', '■'},
//				{'□', '□', '□', '■'},
//				{'□', '□', '□', '■'},
//		};
//		
//		for (int i = 0; i < block1.length; i++) {
//			for (int j = 0; j < block1[i].length; j++) {
//				System.out.print(block1[i][j]);
//			}
//			System.out.println();
//		}
//		
		
//		omok[1][5] = 1;
//		omok[2][5] = 1;
//		omok[3][5] = 1;
//		omok[4][5] = 1;
//		omok[5][5] = 1;
//		
//		omok[1][6] = 2;
//		omok[2][6] = 2;
//		omok[3][6] = 2;
//		omok[4][6] = 2;
//		omok[5][6] = 2;
		
		int[][] omok= new int[15][15];
		
		while(true) {
			System.out.print("x 좌표를 입력해 보세요. :");
			int x1 = sc.nextInt();
			System.out.print("y 좌표를 입력해 보세요. :");
			int y1 = sc.nextInt();
			
			omok[x1][14 - y1] = 1;
			
			for (int y = 0; y < omok.length; y++) {
				for (int x = 0; x < omok[y].length; x++) {
					switch (omok[x][y]) {
					case 0:
						System.out.print('□');
						break;
					case 1:
						System.out.print('●');
						break;
					case 2:
						System.out.print('○');
						break;
	
					default:
						break;
					}
					System.out.print(' ');
				}
				System.out.println();
			}
		}	
		
				
	
	}
}
