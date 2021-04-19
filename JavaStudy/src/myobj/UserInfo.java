package myobj;

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
		System.out.printf("아이디 입력 :");
		id = sc.next();
		System.out.printf("이름 입력 :");
		name = sc.next();
		System.out.printf("비밀번호 입력 :");
		pw = sc.next();
		System.out.printf("비밀번호 퀴즈 입력 :");
		pwQuiz = sc.next();
		System.out.printf("비밀번호 퀴즈 정답 입력 :");
		pwAnswer = sc.nextInt();
		System.out.println("계정이 생성되었습니다.");
	}

	public void UserInfo(String id, String pw) {
		if (this.id.equals(id) && this.pw.equals(pw)) {
			System.out.println("로그인 성공!");
		} else {
			System.out.println("로그인 실패");		
		}
	}
	
	public void UserInfo(String name, int pwAnswer) {
		if((this.pwAnswer == pwAnswer) && (this.name.equals(name))) {
			System.out.println("비밀번호는 "+pw+"입니다.");
		}else {
			System.out.println("잘못된 정보입니다.");
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