import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class D07_HashMap {

	public static void main(String[] args) {
		HashMap<String, Integer> record = new HashMap<String, Integer>();

		record.put("홍길동", 50000);
		record.put("고길동", 35000);
		record.put("박길동", 90000);

		// 이미 존재하는 키값에 put하면 값을 수정
//		System.out.println("이전에 들어있는 값 : " +record.put("홍길동", 3500));
		record.put("홍길동", record.get("홍길동") + 3000);
//		System.out.println("지금 들어있는 값 : " +record.get("홍길동"));

//		System.out.println(record.get("박길동"));

		HashMap<String, Object> person = new HashMap<String, Object>();

		person.put("이름", "홍길동");
		person.put("나이", 35);
		person.put("좋아하는 것", new String[] { "놀기", "잠자기", "먹기" });
		person.put("싫어하는 것", new HashSet<>());

		((HashSet) person.get("싫어하는 것")).add("공부");
		HashSet dislike = ((HashSet) person.get("싫어하는 것"));

		dislike.add("일하기");
		dislike.add("돈벌기");
		// 23열의 new HashSet에 대한 주소를 26열의 dislike에 전달하였기 때문에
		// 28, 29열의 dislike에 데이터를 추가하여도 35열에는 일하기, 돈벌기가 추가됨

//		System.out.println(person.get("나이"));
//		System.out.println(((String[]) person.get("좋아하는 것"))[0]);
//		System.out.println(person.get("싫어하는 것"));

		
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
		}//41열처럼 키셋을 돌려서 get(key)를 통해 value 값을 얻어도 되고 60열처럼 entry를 이용해도 됨
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
