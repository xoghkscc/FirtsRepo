package myobj.school;

public class NetworkStudent extends Student {
	int linux= randomScore(), ccna=randomScore();
	int sno;
	String[] subject_name = {"����", "����", "������", "CCNA"};
	
	
	public NetworkStudent(int sno) {
		this.sno = sno;
	}
	
	public void showGrade() {
		
		System.out.printf("�й�\t�̸�\t%s\t%s\t%s\t%s\t����\t���\n", subject_name[0], subject_name[1], subject_name[2],
				subject_name[3]);
		
		System.out.printf("%X\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\n", sno, name, kor, eng, linux, ccna,
				kor + eng + linux + ccna, (kor + eng + linux + linux) / 4.0);
		
		System.out.println("---------------------------------------------------------------");
	}
}

