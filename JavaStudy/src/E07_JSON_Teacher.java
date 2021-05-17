import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class E07_JSON_Teacher {

        /*
                 # JSON
                 
                  - JavaScript의 Object타입과 굉장히 유사한 형태의 데이터 표현 방식
                  - 문자열만으로 다양한 데이터를 간결하게 표현할 수 있어서 인기가 많다
                  - { "Key" : Value, "Key" : Value , ... }
         
                 # JSON의 Value에 표현 가능한 타입들
                 
                  - '', "" : String
                  - 숫자, 소수 : Number
                  - null
                  - [] : Array
                  - {} : Object (JAVA의 Map)
        */
        public static void main(String[] args) {
                
                // myMap에 저장된 데이터들을 JSON형태의 문자열로 만들어 파일에 출력하는 
                // 메서드를 만들어보세요 
                // (확장자는 .json)
                HashMap<String, Object> myMap = new HashMap<>();
                
                myMap.put("name", "홍길동");
                myMap.put("age", 123);
                myMap.put("tel", "010-1234-1234");
                myMap.put("tel2", null);
                myMap.put("language", new String[] {"C", "JAVA", "Javascript", "React"});
                myMap.put("lotto", new Integer[] {1, 2, 3, 4, 5, 6, 7});
                
                // mapToJsonFile(myMap);                
                
                // 작성된 파일의 내용을 다시 JAVA 맵으로 로드하는 메서드를 만들어보세요
                readJsonFile("./data/json/json.json");
        }
        
        public static Map<String, Object> readJsonFile(String path) {                
                File jsonFile = new File(path);
                StringBuilder sb = new StringBuilder();
                
                try (FileReader in = new FileReader(jsonFile)) {
                        
                        char[] buff = new char[2048];
                        
                        int len = -1;
                        while ((len = in.read(buff)) != -1) {
                                sb.append(new String(buff, 0, len));
                        }
                } catch (IOException e) {                        
                        e.printStackTrace();
                }
                
                sb.deleteCharAt(sb.indexOf("{"));
                sb.deleteCharAt(sb.lastIndexOf("}"));
                
                System.out.println(sb);
                
                // 문자열 split을 좀더 객체지향적으로 활용할 수 있는 클래스
                StringTokenizer st = new StringTokenizer(sb.toString(), ",");
                Map<String, Object> map = new HashMap<>();
                
                boolean appendingArray = false;
                
                String key = null;
                ArrayList<Object> list = new ArrayList<>();                
                
                while (st.hasMoreTokens()) {
                        String token = st.nextToken();
                        
                        if (appendingArray) {
                                if (!token.contains("]")) {
                                        list.add(parseJsonValue(token.trim()));
                                } else {
                                        appendingArray = false;                                        
                                        list.add(parseJsonValue(token.replace("]", "")));
                                        map.put(key, list);
                                        list = new ArrayList<>();
                                }
                                continue;
                        }                        
                        
                        // "language":["C"
                        if (token.contains("[")) {
                                appendingArray = true;                                
                                String[] entry = token.trim().split(":");                                
                                key = entry[0].trim().replace("\"", "");                                
                                list.add(parseJsonValue(entry[1].replace("[", "")));                                
                                continue;
                        }
                        
                        String[] entry = token.trim().split(":");                        
                        
                        map.put(entry[0].trim().replace("\"", ""), parseJsonValue(entry[1].trim()));
                }
                
                System.out.println(map);
                
                return map;
        }
        
        private static Object parseJsonValue(String value) {
                System.out.println("parseJsonValue: " + value);
                
                if (value.contains("\"")) {
                        return value.replace("\"", "");
                } else if (!value.equals("null")) {
                        return Integer.parseInt(value.trim());
                }
                
                return null;
        }
        
        public static void mapToJsonFile(Map<String, Object> map) {
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                
                int i = 0, len = map.size();
                
                
                for (Entry<String, Object> entry : map.entrySet()) {
                        sb.append("\"" + entry.getKey() + "\":");
                        
                        Object value = entry.getValue();
                        if (value instanceof String) {
                                sb.append("\"" + entry.getValue() + "\"");
                        } else if (value instanceof Integer || value instanceof Double 
                                        || value instanceof Float) {
                                sb.append(entry.getValue());
                        } else if (value instanceof Integer[]) {
                                sb.append(Arrays.toString((Integer[])value));
                        } else if (value instanceof String[]) {
                                sb.append("[");
                                                                
                                for (int j = 0, len2 = ((String[]) value).length; j < len2; ++j) {
                                        sb.append("\"" + ((String[]) value)[j] + "\"");
                                        
                                        if (j != len2 - 1) {
                                                sb.append(",");
                                        }
                                }
                                
                                sb.append("]");
                        } else if (value == null) {
                                sb.append("null");
                        }
                        
                        if (i++ != len - 1) {
                                sb.append(",");
                        }
                }
                
                sb.append("}");
                
                File jsonFile = new File("./data/json/json.json");
                Charset utf8 = Charset.forName("UTF-8");
                
                // try auto close (Autocloseable 인터페이스가 구현되어 있어야 함)
                try (FileWriter out = new FileWriter(jsonFile)) {
                        out.append(sb);
                } catch (IOException e) {                        
                        e.printStackTrace();
                }
        }
        
}
















