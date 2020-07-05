package we.m1.board.util;

public class StringUtil {

	public static String nullValueBlank(String input) {
		String result = "";
		
		if (input != null) {
			result = input;
		}
		
		return result;
	}
}
