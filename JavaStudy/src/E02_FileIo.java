import java.io.File;

public class E02_FileIo {
	public static void main(String[] args) {
		//생성자로 경로 전달
		File a = new File("files\\21.04.20.txt");
		File b = new File("b.txt");
		File dir = new File("D:/files/");
		File dir2 = new File("D:/files2/");
		
		System.out.println("읽기 권한이 있는 파일인가요? "+a.canRead());//true
		System.out.println("실행 권한이 있는 파일인가요? "+a.canExecute());//true
		System.out.println("쓰기 권한이 있는 파일인가요? "+a.canWrite());//true
		
		
		
		System.out.println("절대 경로 알아오기 : "+a.getPath());//files\21.04.20.txt
		System.out.println("a에 담긴 경로가 절대 경로인가? : "+a.isAbsolute());//false
		System.out.println("a에 담긴 파일 인스턴스는 디렉토리인가? : "+a.isDirectory());//false
		
		System.out.println("a가 현재 존재하는가? : "+a.exists());//true
		System.out.println("dir가 현재 존재하는가? : "+dir.exists());//true
		System.out.println("dir2가 현재 존재하는가? : "+dir2.exists());//false
		
		// 존재하지 않으면 디렉토리 생성하기
		if(!dir2.exists()) {
			dir2.mkdir();
		}
	}
}
