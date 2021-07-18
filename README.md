# Java
## 0. 소개
* JAVA 수업에 배운 내용들을 매우 축약해 놓은 문서입니다.
* 제가 JAVA를 배운 모든 내용을 필기해 놓은 파일은 word 파일로 정리하였습니다.
## 1. 변수 및 연산자
1. Escape 문자
2. 변수(Variable)
3. 연산자(Operator)
4. Math 클래스
5. java.utll.Scanner 클래스 및 Scanner들의 메서드
6. 비교 연산자, 논리 연산자
    * 문자열(참조형 타입)은 equals 메서드로 비교해야 한다
7. 타입 캐스팅
## 2. 조건문과 반복문
### 2_1 조건문
1.  If문
    * ()안의 값이 true일 때 {}안의 내용을 실행, false일 때 내용을 실행하지 않음
2.  else if문
3.  else 문
4.  Switch-case문
5.  삼항 연산자
6.  대입 연산자
7.  복합 대입 연산자
8.  단항 연산자
### 2_2 반복문
1.  반복문 (Loop)
    * for, while 등이 있음
    * 똑같은 코드를 여러 번 반복하고 싶을 때 사용
2.  for
3.  while
## 3. 배열(Array)
1.  배열(Array)
    * 같은 타입 변수를 한번에 여러 개 선언
    * 같은 이름으로 변수를 여러 개 선언한 뒤 인덱스를 활용해 구분
    * 배열은 한번 크기가 정해지면 크기를 변경할 수 없다.
    * String은 char형 배열로 변환할 수 있다 (.toCharArray()
```C
String text = "hello";
char[] text_char = text.toCharArray();
```
2.  배열을 선언하는 방법
    * 타입[] 배열이름 = new 타입[배열크기];
    * 타입[] 배열이름 = {값1, 값2, 값3, ...};
    * 타입[] 배열이름 = new 타입[]{값1, 값2, ...}
3.  2차원 배열
4.  Arrays.toString(배열) : 배열을 편하게 출력하기
## 4. 객체지향 프로그래밍 (OOP : Object Oriented Programming)
1.  메서드(함수)
    * 기능을 미리 정의해두고 나중에 가져다 쓰는 것
    * 클래스 내부에 선언
    * 함수가 반환할 값의 타입을 정의(없으면 void)
2.  클래스
    * 객체를 프로그래밍 언어로 표현
    * 클래스를 통해 생성하는 실제 객체를 '인스턴스'라고 한다.
    * 클래스는 참조형 변수 타입
3.  클래스의 생성자
    *  this: 각 인스턴스에서 자기 자신을 가리킨다.
    *  기본 생성자 : 매개변수를 받지 않는 생성자
5.  상속
    * 이미 존재하는 클래스를 그대로 물려받거나 고쳐서 사용하는 것
    * 상속해주는 클래스를 부모 클래스 또는 슈퍼 클래스
    * 상송받는 클래스를 자식 클래스 또는 서브 클래스
    * 상속받은 클래스는 부모 클래스의 생성자를 호출해야 함(부모 클래스의 기본 생성자가 존재할 시 호출을 생략)
    * 자식 클래스의 생성자에서는 첫 줄에 super()를 반드시 호출
    * super() : 부모 클래스의 생성자를 실행
    * 자식 클래스는 부모의 메서드를 마음으로 고쳐서 사용할 수 있다(오버라이드, Override)
6.  객체의 다형성
    * 업캐스팅 : 자식 클래스 타입이 부모 클래스 타입이 되는 것
    * 다운캐스팅 : 업캐스팅되었던 인스턴스를 다시 원래 타입으로 되돌리는 것
    * 업캐스팅된 객체는 자식 클래스에만 존재하는 것들을 모두 잊는다(자식 클래스에만 존재하는 메서드를 사용하고 싶을 경우 다운캐스팅 후 사용)
7.  추상 클래스
8.  추상 메서드
9.  익명 클래스
10. 접근 제어자
    * private : 클래스 내부에서만 접근(getter & setter를 통해 외부 클래스에서 접근 가능하게 할 수 있음)
    * default(기본) : 같은 패키지 내부에서 접근 가능
    * protected : 같은 패키지 내부에서 접근 가능, 다른 패키지에서는 상속받은 클래스에서만 접근 가능
    * public : 다른 패키지에서도 자유롭게 접근 가능
11. InnerClass
12. 지역 내부 클래스
    * 메서드 내부에서 선언하여 사용하는 클래스
13. 익명 내부 클래스
14. 인터페이스
    * 추상 클래스는 상속을 여러 개 받을 수 없다는 단점을 보완
    * 인터페이스 내부의 메서드는 자동으로 abstract public이 된다.
    * 인터페이스 내부의 변수는 자동으로 final static이 된다.
    * 인터페이스 내부의 메서드를 정의할 때 dafault를 붙이면 기본 동작을 설정할 수 있다.(인터페이스 내부의 메서드는 모두 abstract(추상 메서드)가 되기 때문에)
## 5. 예외처리
1.  예외(Exception)
    * 빨간 글씨들은 사실 예외
    * catch(예외가 되는 경우)를 입력하면 예외가 되는 경우에 한해서만 예외처리가 됨
    * 프로그래머가 예외에 대하여 적절한 조치를 취해준다면 프로그램을 강제종료하지 않고 계속 진행할 수 있다.
2.  예외처리
    * 예외가 발생할 가능성이 있는 코드를 try문 내부에 포함
    * try문 내부에서 예외가 발생하는 경우 실행이 즉시 중단되고 catch문으로 이동
    * finally문은 예외가 발생하든 안하는 무조건 실행
3.  throws
    * Exception 클래스를 상속받은 예외는 "반드시 처리해야 하는 예외"가 된다.
    * RuntimeException 클래스를 상속받은 예외는 "꼭 처리하지 않아도 되는 예외"가 된다.
```C
public class C15_Throw{
  public static void main(String[] args){
    C15_Throw instance = new C15_Throw();
    instance.dangerous_method();//이 메서드는 Exception클래스를 상속받았기 때문에 예외처리를 반드시 해야 함
  }
  
  public void dangerous_method() throws FilenotFoundException {
    File f = new File("D://nameless.txt");
    FileReader reader = new FileReader(f);
  }
}
```
## 6. Java Collections
1.  ArrayList
    * 배열과 유사한 형태
    * 순차적으로 데이터에 접근해야할 때 가장 유용
2.  Set
    * 집합을 구현해놓은 클래스
    * 중복은 허용하지 않음
3.  Hash
    * 순서 혹은 index가 없음
    * 즉 Collections.sort(정렬)을 못씀
4.  특징
    * 컬렉션끼리는 변환이 자유롭다
    * 제네릭을 요구하는 클래스에 제네릭을 사용하지 않는 경우 모든 타입을 넣을 수 있다.
    * 컬렉션을 배열로 변환할 수 있다(toArray())
## 7. Comparator, Comparable
1.  Comparator
    * 두 객체의 크기를 비교할 때 사용하는 클래스가 되는 인터페이스
    * 비교할때 사용하는 비교 도구 클래스로 만드는 인터페이스
2.  Comparator 규칙
    * 반드시 Comparator를 상속받고 compare 메서드를 이용해야 함
    * compare 메서드의 리턴 값이 양수이면 o1, o2의 순서를 바꾼다.
    * compare 메서드의 리턴 값이 음수이면 o1, o2의 순서를 유지한다.
    * compare 메서드의 리턴 값이 0이면 같은 크기로 취급
    * comapre 메서드를 통해 클래스의 크기를 결정하고 Collections.sort()를 통해 정렬
```C
class ComparatorClass implements Comparator<Grape> {
  public int compare(Grape o1, Grape o2) {
    if(o1.fruit < o2.fruit) {
      return -1;
    } else if ( o1.fruit == o2.fruit) {
      return 0;
    } else {
      return 1;
    }
  }
}
//Grape를 제네릭으로 가지는 컬렉션들을 정렬 가능
````
3.  Comparable
    * 이 객체가 비교 가능한 클래스임을 표시하는 인터페이스
4.  TreeSet
    * 데이터를 저장할 때 Comparable를 이용해 미리 정렬
## 8. Map
1.  Map
    * key와 value가 한 쌍을 이루는 자료구조
    * key값을 통해 value에 접근 가능
## 9. 정규표현식
1.  Pattern 클래스
2.  Matcher 클래스
3.  Pattern.compile(regex)
## 10. 날짜와 시간 & 형식화
1.  Date
2.  Calender
3.  java.time.Time
    * Calender의 인스턴스를 set()을 통해 변화시킨다는 단점을 보완한 클래스
    * Java.time 패키지의 클래스들은 시간을 계산한 뒤 새로운 인스턴스를 반환
## 11. Git
1.  Git
    * .git 폴더가 위치한 폴더의 모든 내용을 관리해주는 프로그램
    * .git 폴더가 위치한 폴더를 Repository라고 부른다
    * .git 폴더 내부에는 해당 폴더의 현재 상태가 모두 기록되어 있다.
    * .git 폴더를 니용하여 언제든지 이전의 상태로 돌아갈 수 있다 (Windows의 복구 기능과 비슷)
    * 해당 폴더 내부의 무엇인가가 조금이라도 변하면 알아채고 관리한다
2.  GitHub
    * Giuhub는 원격 Repository를 업로드 해놓을 수 있는 사이트다.(클라우드 같은 것)
3.  commit
    * 레포지토리 내의 변경 사항을 저장하는 명령어
4.  branch
    * 하나의 레포지토리를 다양한 상태로 보관하기 위한 기능
    * Checkout을 통해 언제든지 원하는 branch로 전환이 가능하다
5.  checkout
6.  merge
    * 현재 HEAD(현재 보고 있는 상태)로 다른 브렌치의 작업 내용을 합치는 것
    * 합칠 때 같은 부분을 수정한 곳이 있다면 둘 중 하나를 선택하는 과정을 거친다.
7.  rebase
    * 브렌치를 나눈 시점을 바꾸는 기능
## 12. Java IO (Input/Output)
1.  Stream
    * 데이터들이 오고가는 통로
    * 입력 받을 때 데이터들이 프로그램으로 들어오는 통로를 InputStream이라고 부른다
    * 출력 할 때 데이터들이 나가는 통로를 OutputStream이라고 부른다.
    * 데이터는 Stream으로 이동하기 위해서는 해당 데이터를 byte 타입으로 변환해야 한다.(String.getBytes 메서드를 통해 가능)
2.  java.utll.File
    * 파일 시스템의 파일 정보를 담을 수 있는 클래스
3.  Reader/Writer
    * InputStream과 OutputStream은 데이터를 바이트 단위로 읽고 쓴다.
    * 바이트 단위로 데이터를 사용하기 때문에 원하는 타입으로의 재구성이 필요하다.
    * Reader와 Writer는 데이터를 문자 단위로 읽고 쓰는 클래스들이다.
    * InputStream/OuputStream을 Reader/Writer로 한번 더 감싸서 사용한다.
4.  DataInputStream/DataOutputStream
5.  Serializable interface
    * 해당 클래스로 생성된 인스턴스를 직렬화(코드화 : 0과 1로 바꾸는 것) 할 수 있다고 표시하는 인터페이스(즉 Serializable 인터페이스를 달아놓으면 직렬화 가능함)
    * serialVersionUID에 원하는 값을 넣으면 된다.
    * ObjectOutputStream으로 자바 객체를 파일에 저장할 때 해당 객체를 직렬화(코드화) 할 수 있어야 한다.
    * 직렬화 코드 serialVersionUID 일정해야함 처음에 직렬화해서 보낼 때 직렬화 값이랑 추후에 직렬화 값이 다르면 오브젝트를 불러올 때 오류가 뜸(암호 같은 느낌)
6.  ObjectOutputStream
    * 오브젝트 타입 자체를 파일에 저장하는 기능임(즉 arrayList나 hashSet, hashMap, 클래스의 인스턴스 등을 통째로 파일에 저장 및 출력이 가능)
7.  JSON
    * JavaScript의 Object타입과 굉장히 유사한 형태의 데이터 표현 방식
    * 문자열만으로 다양한 데이터를 간결하게 표현할 수 있어서 인기가 많다.
    * {“Key” : Value, “Key” : Value, …}
    * 프로그래밍 언어의 구애받지 않음
    * JSON 안에 JSON이 들어갈 수도 있음
    * 즉 내가 JSON을 만들어놓고 가져다 쓰는 거임
## 13. JDBC
1.  JDBC
    * Java Database Connectivity
    * DB에 쿼리문을 전달하여 실행하고 결과를 받아오는 Java API
2.  OJDBC
    * 오라클 데이터베이스가 JDBC API와 소통하기 위해 만든 라이브러리
## 14. DB와의 연동
1.  Class.forName(driverName)으로 해당 DB사의 jdbc드라이버를 로드한다.
```C
Class.forName("oracle.jdbc.driver.OracleDriver");
```
2.  DriverManager 클래스를 통해 DB와의 연결을 생성한다.
```C
DriverManager.getConnection(url, user, password);
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.35.52.40:1521:XE", "비밀", "비밀");
```
3.  생성된 연결을 통해 전송할 쿼리문을 생성한다
```C
PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
```
4.  생성된 쿼리문을 DB로 보낸다
```C
ResultSet rs = pstmt.executeQuery();
```
5.  받아온 결과를 마음대로 사용
```C
while(rs.next()) {
  System.out.println(rs.getString("first_name));
}
```
6.  다 썼으면 연결을 잘 끊어준다(가장 나중에 열었던 순서대로 닫는다.)
```C
rs.close();
pstmt.close();
conn.close();
```
## 15. ConnectionPool
1.  ConnectionPool
    * DB에 DML을 적용할때마다 새로운 접속을 생성하는 것은 리소스가 많이 낭비된다.
    * 연결을 이미 여러 개 생성해두고, 사용중이지 않은 커넥션을 꺼내주는 방식을 커넥션 풀이라고 한다.
2.  Hikari CP
```C
public class HikariCP {
	HikariDataSource ds;
	public HikariCP() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521:xe");
		config.setUsername("first_project");
		config.setPassword("비밀");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}
	
	public HikariDataSource getHikariDataSource() {
		return ds;
	}
}
//이렇게 클래스를 미리 만들어주면 편리하다.
```
## 16. JSwing
1.  JSwing
    * Java로 윈도우 GUI 프로그램을 만들 수 있는 API
2.  Container
    * 컴포넌트를 추가할 수 있는 판
    * Jframe, Jpanel 등
    * 컨테이너마다 원하는 레이아웃을 지정할 수 있다.
3.  Component
    * 컨테이너에 추가할 수 있는 부품
    * Jbutton, Jtable, Jslider, Jmenu …등
4.  컨포넌트에 이벤트 추가
```C
JButton btn = new JButton();
btn.addActionListener(new ButtonAction());

public class ButtonAction implements ActionListener{
  public void actionPerformed(ActionEvent e) {
	//해당 컴포넌트에 action 발생시 e로 이벤트 당시의 정보가 넘어온다.
    // 버튼을 클릭하였을 때에 프로그래머가 발동하였으면 하는 코드를 이곳에 작성하면 됨
  }
}
```
