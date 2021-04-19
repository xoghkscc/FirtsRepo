import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class D07_HashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> record = new HashMap<String, Integer>();

		record.put("ȫ�浿", 50000);
		record.put("��浿", 35000);
		record.put("�ڱ浿", 90000);

		// �̹� �����ϴ� Ű���� put�ϸ� ���� ����
//		System.out.println("������ ����ִ� �� : " +record.put("ȫ�浿", 3500));
		record.put("ȫ�浿", record.get("ȫ�浿") + 3000);
//		System.out.println("���� ����ִ� �� : " +record.get("ȫ�浿"));

//		System.out.println(record.get("�ڱ浿"));

		HashMap<String, Object> person = new HashMap<String, Object>();

		person.put("�̸�", "ȫ�浿");
		person.put("����", 35);
		person.put("�����ϴ� ��", new String[] { "���", "���ڱ�", "�Ա�" });
		person.put("�Ⱦ��ϴ� ��", new HashSet<>());

		((HashSet) person.get("�Ⱦ��ϴ� ��")).add("����");
		HashSet dislike = ((HashSet) person.get("�Ⱦ��ϴ� ��"));

		dislike.add("���ϱ�");
		dislike.add("������");
		// 23���� new HashSet�� ���� �ּҸ� 26���� dislike�� �����Ͽ��� ������
		// 28, 29���� dislike�� �����͸� �߰��Ͽ��� 35������ ���ϱ�, �����Ⱑ �߰���

//		System.out.println(person.get("����"));
//		System.out.println(((String[]) person.get("�����ϴ� ��"))[0]);
//		System.out.println(person.get("�Ⱦ��ϴ� ��"));

		
		for (String key : person.keySet()) {
			Object value = person.get(key);

			if (value instanceof String[]) {
				System.out.print(key + ": [");
				String[] arr = (String[])value;
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ",");
				}
				System.out.println("]");
			} else {
				System.out.println(key + ":" +value);
			}
		}
		
		//values
		System.out.println("values : " + person.values());
		
		//entrySet()
		for (Entry<String, Object> entry : person.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			System.out.println(key + "=" + value);
		}//41��ó�� Ű���� ������ get(key)�� ���� value ���� �� �ǰ� 60��ó�� entry�� �̿��ص� ��
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
