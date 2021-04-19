
public class D03_WrapperClass {

	
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt("1234ABC", 16);//-->���ڰ� �־� ������ ��
			System.out.println(a);
		}
		catch (NumberFormatException e) {
			System.out.println("int�� ��ȯ�� �� ���� ���ڿ��̾����ϴ�.");
		}
		
		//����ƽ �޼���
		System.out.println(Integer.toString(123456,2));//123456�� 2����
		System.out.println(Integer.toString(123456));//123456�� 10����
		//�ν��Ͻ� �޼���
		Integer num2 = 10;
		System.out.println(num2.toString());
		
		Integer num = 10000000;
		System.out.println(num.byteValue());//-128
		System.out.println(num.shortValue());//-27008
		System.out.println(num.doubleValue());//1.0E7
		System.out.println(num.floatValue());//1.0E7
		System.out.println(num.longValue());//10000000
	
	}
	
}
