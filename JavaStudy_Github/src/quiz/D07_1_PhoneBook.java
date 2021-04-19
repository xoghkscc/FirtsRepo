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
	//HashMap�� �̿��� ��ȭ��ȣ�θ� �����غ�����
	//1. �׷� / ��ȭ��ȣ / �̸��� �����ؾ� �Ѵ�.
	//2. �׷� �̸��� Ű������ ������ �ش� �׷��� ��ȭ��ȣ ����� ���´�.
	//3. ��ȭ��ȣ ��Ͽ� ��ȭ��ȣ Ű������ ������ �̸��� ���´�.
	
	//�����ؾ� �� �޼���
	//1. ���ο� �׷��� �߰��ϴ� �޼���
	//2. �����ϴ� �׷쿡 ���ο� ��ȭ��ȣ�� ����ϴ� �޼��� (�׷��� ���ٸ� �̺з� �׷쿡 ����)
	//3. ��ϵ� ��� ��ȭ��ȣ�� �̸����� ������������ �����ִ� �޼���
	//4. �̸��� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ������ ��µǴ� �˻� �޼���
	//5. ��ȭ��ȣ�� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ��ȭ��ȣ�� ��µǴ� �˻� �޼���
	String groupName;
	String name;
	String phoneNum;
	static D07_1_PhoneBook pb;
	static HashMap<String, HashMap<String, String>> phoneBook;
	
	
	public static void main(String[] args) {
		phoneBook = new HashMap<>();
		phoneBook.put("family", new HashMap<String, String>());
		phoneBook.put("friend", new HashMap<String, String>());
		phoneBook.get("family").put("����ȯ", "010-5625-7327");
		phoneBook.get("family").put("�����", "010-8758-9212");
		phoneBook.get("family").put("�̸���", "010-7518-5551");
		phoneBook.get("friend").put("�赿��", "010-8857-9212");
		phoneBook.get("friend").put("���ο�", "010-2538-2546");
		Scanner sc = new Scanner(System.in);
		boolean tf = true;
		pb = new D07_1_PhoneBook();
		while(tf) {
			System.out.print("1. �׷� �߰� 2. ��ȭ��ȣ ��� 3. ��� ��ȭ��ȣ ��ȸ  4. �̸� �˻� 5. ��ȣ �˻� 6. �׸��ϱ� >>");
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
	//���ο� �׷��� �߰��ϴ� �޼���
	public void newGroup(HashMap<String, HashMap<String, String>> phoneBook) {
		groupName = MyScanner.input("��ȭ��ȣ �׷� �̸��� �����ϼ��� : ");
		phoneBook.put(groupName, new HashMap<String, String>());
		System.out.println(groupName + "�׷� �̸��� ����Ǿ����ϴ�.");
	}
	//��ȭ��ȣ ��� �޼���
	public void newPhoneNumber(HashMap<String, HashMap<String, String>> phoneBook) {
		boolean tf = true;
		while(tf) {
		groupName = MyScanner.input("��ȭ��ȣ�� ����� �׷� �̸��� ������ : (���� �����ϴ� �׷� : "+phoneBook.keySet()+")");
			if(!phoneBook.containsKey(groupName)) {
				System.out.println("�������� �ʴ� �׷� �̸��Դϴ�.");
			}else {
				name = MyScanner.input("����� �̸��� ������ : ");
				phoneNum = MyScanner.input("����� ��ȭ��ȣ�� ������ :");
				phoneBook.get(groupName).put(name, phoneNum);
				System.out.println("�Է��� �Ϸ�Ǿ����ϴ�.");
//				nameNumber2.add(new NameNumber(name, phoneNum));
				tf = false;
			}
		}
	}
	//��ȭ��ȣ ���� ��� �޼���
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
	//��ȭ��ȣ �˻� �޼���
	public void searchName(HashMap<String, HashMap<String, String>> phoneBook) {
		String searchName = MyScanner.input("�˻��� �̸��� ������ : ");
		for(String key : phoneBook.keySet()) {
			HashMap<String, String> value = phoneBook.get(key);
			for(String key2 : value.keySet()) {
				if(key2.contains(searchName)) {
					System.out.println(value.get(key2));
				}
			}
		}
	}
	//��ȣ �˻� �޼���
	public void searchNum(HashMap<String, HashMap<String, String>> phoneBook) {
		String searchNum = MyScanner.input("�˻��� ��ȣ�� ������ : ");
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

//��ȭ��ȣ�� �̸��� ����ؼ� �����ϰ��ϴ� Ŭ����
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

