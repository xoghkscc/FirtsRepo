package quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Map.Entry;

import myobj.MyScanner;

public class D07_1_PhoneBook {
	//HashMap을 이용해 전화번호부를 구현해보세요
	//1. 그룹 / 전화번호 / 이름을 저장해야 한다.
	//2. 그룹 이름을 키값으로 넣으면 해당 그룹의 전화번호 목록이 나온다.
	//3. 전화번호 목록에 전화번호 키값으로 넣으면 이름이 나온다.
	
	//구현해야 할 메서드
	//1. 새로운 그룹을 추가하는 메서드
	//2. 존재하는 그룹에 새로운 전화번호를 등록하는 메서드 (그룹이 없다면 미분류 그룹에 저장)
	//3. 등록된 모든 전화번호를 이름기준 내림차순으로 보여주는 메서드
	//4. 이름의 일부를 입력하면 일치하는 모든 정보가 출력되는 검색 메서드
	//5. 전화번호의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 검색 메서드
	String groupName;
	String name;
	String phoneNum;
	static D07_1_PhoneBook pb;
	static HashMap<String, HashMap<String, String>> phoneBook;
	
	
	public static void main(String[] args) {
		phoneBook = new HashMap<>();
		phoneBook.put("family", new HashMap<String, String>());
		phoneBook.put("friend", new HashMap<String, String>());
		phoneBook.get("family").put("김태환", "010-5625-7327");
		phoneBook.get("family").put("김봉수", "010-8758-9212");
		phoneBook.get("family").put("이말순", "010-7518-5551");
		phoneBook.get("friend").put("김동욱", "010-8857-9212");
		phoneBook.get("friend").put("정민우", "010-2538-2546");
		Scanner sc = new Scanner(System.in);
		boolean tf = true;
		pb = new D07_1_PhoneBook();
		while(tf) {
			System.out.print("1. 그룹 추가 2. 전화번호 등록 3. 모든 전화번호 조회  4. 이름 검색 5. 번호 검색 6. 그만하기 >>");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				pb.newGroup(phoneBook);
				break;
			case 2:
				pb.newPhoneNumber(phoneBook);
				break;
			case 3:
				pb.showPhoneNumber(phoneBook);
				break;
			case 4:
				pb.searchName(phoneBook);
				break;
			case 5:
				pb.searchNum(phoneBook);
				break;
			default:
				tf = false;
				break;
			}
		}
	}
	//새로운 그룹을 추가하는 메서드
	public void newGroup(HashMap<String, HashMap<String, String>> phoneBook) {
		groupName = MyScanner.input("전화번호 그룹 이름을 설정하세요 : ");
		phoneBook.put(groupName, new HashMap<String, String>());
		System.out.println(groupName + "그룹 이름이 저장되었습니다.");
	}
	//전화번호 등록 메서드
	public void newPhoneNumber(HashMap<String, HashMap<String, String>> phoneBook) {
		boolean tf = true;
		while(tf) {
		groupName = MyScanner.input("전화번호를 등록할 그룹 이름을 쓰세요 : (현재 존재하는 그룹 : "+phoneBook.keySet()+")");
			if(!phoneBook.containsKey(groupName)) {
				System.out.println("존재하지 않는 그룹 이름입니다.");
			}else {
				name = MyScanner.input("등록할 이름을 쓰세요 : ");
				phoneNum = MyScanner.input("등록할 전화번호를 쓰세요 :");
				phoneBook.get(groupName).put(name, phoneNum);
				System.out.println("입력이 완료되었습니다.");
//				nameNumber2.add(new NameNumber(name, phoneNum));
				tf = false;
			}
		}
	}
	//전화번호 정보 출력 메서드
	public void showPhoneNumber(HashMap<String, HashMap<String, String>> phoneBook) {
		for(String groupName : phoneBook.keySet()) {
			System.out.printf("----%s----\n",groupName);
			HashMap<String, String> group = phoneBook.get(groupName);
			TreeSet<Entry<String, String>> sortSet = new TreeSet<Entry<String,String>>(new NameSort());
			sortSet.addAll(group.entrySet());
			for(Entry<String, String> entry : sortSet) {
				System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
			}
		}
//		System.out.println(nameNumber2);
	}
	//전화번호 검색 메서드
	public void searchName(HashMap<String, HashMap<String, String>> phoneBook) {
		String searchName = MyScanner.input("검색할 이름을 쓰세요 : ");
		for(String key : phoneBook.keySet()) {
			HashMap<String, String> value = phoneBook.get(key);
			for(String key2 : value.keySet()) {
				if(key2.contains(searchName)) {
					System.out.println(value.get(key2));
				}
			}
		}
	}
	//번호 검색 메서드
	public void searchNum(HashMap<String, HashMap<String, String>> phoneBook) {
		String searchNum = MyScanner.input("검색할 번호를 쓰세요 : ");
		for(String key : phoneBook.keySet()) {
			HashMap<String, String> value = phoneBook.get(key);
			for(String key2 : value.keySet()) {
				String value2 = value.get(key2);
				if(value2.contains(searchNum)) {
					System.out.println(value2);
				}
			}
		}
	}
}

//전화번호와 이름을 등록해서 정렬하게하는 클래스
class NameSort implements Comparator<Entry<String, String>>{

	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		int value_diff = o1.getValue().compareTo(o2.getValue());
		if(value_diff == 0) {
			return o1.getKey().compareTo(o2.getKey());
		}
		return value_diff;
	}
	
}

