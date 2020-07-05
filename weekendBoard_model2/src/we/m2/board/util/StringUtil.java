package we.m2.board.util;

public class StringUtil {
	
	public static String nullValueBlank(Object input) {
		String result = "";
		
		if (input != null) {
			try { 
				result = (String) input;
			} catch (Exception e) {
				result = "";
			}
		}
		
		return result;
	}

	public static String nullValueBlank(String input) {
		String result = "";
		
		if (input != null) {
			result = input;
		}
		
		return result;
	}
}
