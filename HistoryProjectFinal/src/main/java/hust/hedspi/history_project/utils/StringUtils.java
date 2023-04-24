package hust.hedspi.history_project.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {

	public static String unAccent(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
	}

	public static boolean isMatch(String parent, String search) {
		if (search.matches("^[a-z A-Z]{1,50}$")) { 		// search có không dấu sẽ convert parent sang không dấu
			return unAccent(parent).toLowerCase().contains(search.toLowerCase().trim());
		} else { // ngược lại search có dấu sẽ không convert parent
			return parent.toLowerCase().contains(search.toLowerCase().trim());
		}
	}
}
