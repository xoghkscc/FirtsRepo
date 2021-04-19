package quiz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;


public class D07_1_PhoneBookTea {
	HashMap<String, HashMap<String, String>> phonebook;
	
	public D07_1_PhoneBookTea() {
		phonebook = new HashMap<String, HashMap<String, String>>();
		
		phonebook.put("미분류", new HashMap<String, String>());
		phonebook.put("가족", new HashMap<String, String>());
		phonebook.put("직장", new HashMap<String, String>());
		phonebook.put("친구", new HashMap<String, String>());
		
		
	}
	
	public boolean addGroup(String groupName) {
		if(phonebook.containsKey(groupName)) {
			System.out.println("이미 존재하는 그룹입니다.");
			return false;
		}else {
			System.out.println("성공적으로 추가하였습니다.");
			phonebook.put(groupName, new HashMap<>());
			return true;
		}
	}
	
	public void printGroupList() {
		for(String groupName : phonebook.keySet()) {
			System.out.printf("#### %s ####\n", groupName);
		}
	}
	
	public boolean addNumber(String groupName, String phoneNumber, String name) {
		for(HashMap<String, String> group : phonebook.values()) {
			if(group.containsKey(phoneNumber)) {
				System.out.println("이미 등록된 번호입니다.");
				return false;
			}
		}
		
		if(phonebook.containsKey(groupName)) {
			phonebook.get(groupName).put(phoneNumber, name);
		}else {
			phonebook.get("미분류").put(phoneNumber, name);
		}
		return true;
	}
	
	public void printPhoneBook() {
		for(String groupName : new TreeSet<>(phonebook.keySet())) {
			System.out.printf("---- %s ----\n", groupName);
			
			HashMap<String, String> group = phonebook.get(groupName);
			
			TreeSet<Entry<String, String>> sortedSet = 
				new TreeSet<>(new Comparator<Entry<String, String>>() {
					@Override
					public int compare(Entry<String, String> o1, Entry<String, String> o2) {
						// 이름 기준으로 1차 정렬 후, 전화번호 기준으로 2차 정렬
						int value_diff = o1.getValue().compareTo(o2.getValue());
						if(value_diff == 0) {
							return o1.getKey().compareTo(o2.getKey());
						}else {
							return value_diff;
						}
					}
			});
			sortedSet.addAll(group.entrySet());
			for(Entry<String, String> entry : sortedSet) {
				System.out.printf("%s : %s\n", entry.getValue(), entry.getKey());
			}
		}
	}
	
	public void serachByName(String keyword) {
		
		int count  = 0;
		System.out.println("- - 검색 결과 - -");
		for(HashMap<String, String> group : phonebook.values()) {
			for(Entry<String, String> entry : group.entrySet()) {
				if(entry.getValue().contains(keyword)) {
					System.out.printf("%s : %s\n", entry.getValue(), entry.getKey());
					count ++;
				}
			}
		}
		System.out.printf("검색 결과 %d건\n", count);
	}
	
	public void searchByPhoneNumber(String number_fragment) {
		int count=0;
		for(HashMap<String, String> group : phonebook.values()) {
			for(String phoneNumber : group.keySet()) {
				if(phoneNumber.contains(number_fragment)) {
					System.out.printf("%s : %s\n", group.get(phoneNumber), phoneNumber);
					count ++;
				}
			}
		}
		System.out.printf("검색 결과 %d건\n", count);
	}
	
	
	public static void main(String[] args) {
		D07_1_PhoneBookTea book = new D07_1_PhoneBookTea();
		
		book.addGroup("가족");
		book.addGroup("동호회");
		book.addGroup("초등학교 동창");
		book.addGroup("중학교 동창");
		book.addGroup("고등학교 동창");
		
		book.printGroupList();
		
		book.addNumber(null, "123-1234-1234", "김동현");
		book.addNumber(null, "010-1234-1234", "추성훈");
		book.addNumber(null, "010-1234-1235", "이대호");
		book.addNumber(null, "010-1234-1236", "추신수");
		book.addNumber(null, "010-1234-1237", "강호동");
		book.printPhoneBook();
		
		book.serachByName("호");
		book.searchByPhoneNumber("34");
	}
	
}

class PhoneInfo {
	String name;
	String phone_number;
	String address;
	String profile_image_path;
}