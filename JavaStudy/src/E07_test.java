import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07_test {
	public static void main(String[] args) {
		Pattern regexName = Pattern.compile("[a-zA-Z]");
		String name = "ndfison";
		String key = null;
		Matcher matcher = regexName.matcher(name);
		int cnt=1;
		while (matcher.find()) {
			System.out.println(cnt);
			key += matcher.group();
			cnt++;
		}
		System.out.println(key);
	}
}
