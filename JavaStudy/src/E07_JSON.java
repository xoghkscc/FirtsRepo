import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.*;
import java.util.regex.Pattern;


public class E07_JSON {
	File file = new File("./note/myMap.json");

	public static void main(String[] args) {

		// map¿¡ ÀúÀåµÈ µ¥ÀÌÅÍµéÀ» JSONÇüÅÂÀÇ ¹®ÀÚ¿­·Î ¸¸µé¾î ÆÄÀÏ¿¡ Ãâ·ÂÇÏ´Â ¸Þ¼­µå¸¦
		// È®ÀåÀÚ´Â .json
		HashMap<String, Object> map = new HashMap<String, Object>();

		ArrayList al = new ArrayList();
		al.add(1);
		al.add("¸®½ºÆ®");
		al.add(null);
		al.add("010-4444-5555");
		map.put("name", "È«±æµ¿");
		map.put("age", 123);
		map.put("tel", "010-1234-1234");
		map.put("tel2", null);
		map.put("language", new String[] { "C", "JAVA", "Javascript", "React" });
		map.put("lotto", new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		map.put("ArrayList", al);
		
		E07_JSON js = new E07_JSON();
		js.mapToJsonFile(map);
		String str = js.mapToJsonStr(map);
		System.out.println(str);
		map = js.javaMapLoad(str);
		System.out.println(map);
		
	}

	public void mapToJsonFile(HashMap<String, Object> map) {
		try {
			OutputStreamWriter dataOut = new OutputStreamWriter(new FileOutputStream(file));
			dataOut.write("{\n");
			for (Entry<String, Object> entrySet : map.entrySet()) {
				dataOut.write("\"" + entrySet.getKey() + "\" : ");
				if (entrySet.getValue() instanceof Integer) {
					Integer new_name = (Integer) entrySet.getValue();
					dataOut.write("" + Integer.toString(new_name) + "");
				} else if (entrySet.getValue() instanceof String[]) {
					String[] new_name = (String[]) entrySet.getValue();
					String data = "";
					for (int i = 0; i < new_name.length; i++) {
						data += "\"" + new_name[i] + "\"" + ", ";
					}
					dataOut.write("[" + data + "]");
				} else if (entrySet.getValue() instanceof Integer[]) {
					Integer[] new_name = (Integer[]) entrySet.getValue();
					String data = "";
					for (int i = 0; i < new_name.length; i++) {
						data += new_name[i] + ", ";
					}
					dataOut.write("[" + data + "]");
				} else if (entrySet.getValue() instanceof String) {
					String data = (String) entrySet.getValue();
					dataOut.write("\"" + data + "\"");
				} else if (entrySet.getValue() instanceof ArrayList) {
					String data = "";
					ArrayList new_name = (ArrayList) entrySet.getValue();
					for (int i = 0; i < new_name.size(); i++) {
						if(new_name.get(i) instanceof Integer) {
							Integer num = (Integer) new_name.get(i);
							data += Integer.toString(num) + ", ";
						}else if(new_name.get(i) instanceof String){
							data += "\""+(String)new_name.get(i) + "\", ";
						}else {
							data += (String)new_name.get(i) +", ";
							
						}
					}
					dataOut.write("[" + data + "]");
				} else {
					dataOut.write("null");
				}
				dataOut.write(",\n");
			}
			dataOut.write("}");
			dataOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String mapToJsonStr(HashMap<String, Object> map) {
		String str = "";
		try {
			InputStreamReader dataIn = new InputStreamReader(new FileInputStream(file));
			int ch;
			while ((ch = dataIn.read()) != -1) {
				str += (char) ch;
			}
			dataIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	public HashMap<String, Object> javaMapLoad(String str) {
		HashMap<String, Object> map2 = new HashMap<String, Object>();

		Pattern regex = Pattern.compile(":");
		Pattern regex2 = Pattern.compile(",");
		Pattern regex3 = Pattern.compile("]");
		ArrayList list =new ArrayList<>();
		String value;

		String[] strArr = regex.split(str);
//		System.out.println(Arrays.toString(strArr));

		Pattern regexName = Pattern.compile("[0-9A-Za-z°¡-ÆR-,]");

		for (int i = 0; i < strArr.length-1; i++) {
			list =new ArrayList<>();
			value = "";
			String key="";
			
			Matcher matcher = regexName.matcher(strArr[i]);
			while(matcher.find()) {
				key += matcher.group();
			}
//			System.out.println("key : " + key);
			i++;
			if(strArr[i].charAt(1)!='[') {
				String[] strArr2 = regex2.split(strArr[i]);
				Matcher matcher2 = regexName.matcher(strArr2[0]);
				
				while(matcher2.find()) {
					value += matcher2.group();
				}
				strArr[i] = strArr2[1];
//				System.out.println("value : "+ value);
				
				map2.put(key, value);
				
			}else {
				String str2 = "";
				String str3 = "";
				String[] strArr2 = regex3.split(strArr[i]);
				Matcher matcher2 = regexName.matcher(strArr2[0]);
				while(matcher2.find()) {
					String ch = matcher2.group();
					if(ch.equals(",")) {
						list.add(str3);
						str3 = "";
					}else {
						str2 += ch;
						str3 += ch;
						
					}
				}
				strArr[i] = strArr2[1];
//				System.out.println("value : "+ list);
				map2.put(key, list);
			}
			i--;
//			System.out.println("---------------------");
		}
		return map2;
	}

}	
