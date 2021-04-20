import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIo {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			// *�ҽ����� ���� ��ġ�� ������Ʈ�� root�̴�
			fout = new FileOutputStream("files\\21.04.20.txt", true);// ./�� �����Ǿ� �ִ°���
			//FileOutputStram(File file, boolean append)Ÿ���̸� append�� true�� ��쿡�� ������ �����͸� ��� �װ� false�ų� ��������� ���� ����
			
			for(int i = 0; i<10; i++) {
				fout.write(String.format("������ ������ �� ���׿�...%d\n", i).getBytes());//getBytes : String�� byte�� �ٲ��ִ� �޼���
			}
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("������ ��ã��");
		} catch (IOException e) {
			System.out.println("�����͸� ���ٰ� ������ ������");
		} finally {
			if(fout != null) {
				try {
					//I/O Stream�� �������� close()�� ȣ������� �Ѵ� (�޸� ȸ��)
					fout.close();
					//close�ϸ鼭 ������ ���� ���� ���⿡ catch�� ���� ���� �ƴϸ� extend�� ��������
				} catch (IOException e) {}
			}
		}
	}
}
