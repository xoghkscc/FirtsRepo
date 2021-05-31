package myobj.etc;

import java.util.Scanner;

public class UserInfo {
	Scanner sc = new Scanner(System.in);

	private int userNum;
	private String id="";
	private String name;
	private String pw;
	private String pwQuiz;
	private int pwAnswer;
	public UserInfo() {	}

	public UserInfo(int userNum) {
		this.userNum = userNum;
		System.out.printf("���̵� �Է� :");
		id = sc.next();
		System.out.printf("�̸� �Է� :");
		name = sc.next();
		System.out.printf("��й�ȣ �Է� :");
		pw = sc.next();
		System.out.printf("��й�ȣ ���� �Է� :");
		pwQuiz = sc.next();
		System.out.printf("��й�ȣ ���� ���� �Է� :");
		pwAnswer = sc.nextInt();
		System.out.println("������ �����Ǿ����ϴ�.");
	}

	public void UserInfo(String id, String pw) {
		if (this.id.equals(id) && this.pw.equals(pw)) {
			System.out.println("�α��� ����!");
		} else {
			System.out.println("�α��� ����");		
		}
	}
	
	public void UserInfo(String name, int pwAnswer) {
		if((this.pwAnswer == pwAnswer) && (this.name.equals(name))) {
			System.out.println("��й�ȣ�� "+pw+"�Դϴ�.");
		}else {
			System.out.println("�߸��� �����Դϴ�.");
		}
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPwQuiz() {
		return pwQuiz;
	}

	public void setPwQuiz(String pwQuiz) {
		this.pwQuiz = pwQuiz;
	}

	public int getPwAnswer() {
		return pwAnswer;
	}

	public void setPwAnswer(int pwAnswer) {
		this.pwAnswer = pwAnswer;
	}

}