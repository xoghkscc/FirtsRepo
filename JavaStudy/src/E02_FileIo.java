import java.io.File;

public class E02_FileIo {
	public static void main(String[] args) {
		//�����ڷ� ��� ����
		File a = new File("files\\21.04.20.txt");
		File b = new File("b.txt");
		File dir = new File("D:/files/");
		File dir2 = new File("D:/files2/");
		
		System.out.println("�б� ������ �ִ� �����ΰ���? "+a.canRead());//true
		System.out.println("���� ������ �ִ� �����ΰ���? "+a.canExecute());//true
		System.out.println("���� ������ �ִ� �����ΰ���? "+a.canWrite());//true
		
		
		
		System.out.println("���� ��� �˾ƿ��� : "+a.getPath());//files\21.04.20.txt
		System.out.println("a�� ��� ��ΰ� ���� ����ΰ�? : "+a.isAbsolute());//false
		System.out.println("a�� ��� ���� �ν��Ͻ��� ���丮�ΰ�? : "+a.isDirectory());//false
		
		System.out.println("a�� ���� �����ϴ°�? : "+a.exists());//true
		System.out.println("dir�� ���� �����ϴ°�? : "+dir.exists());//true
		System.out.println("dir2�� ���� �����ϴ°�? : "+dir2.exists());//false
		
		// �������� ������ ���丮 �����ϱ�
		if(!dir2.exists()) {
			dir2.mkdir();
		}
	}
}
