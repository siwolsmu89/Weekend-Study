package fileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FileCompareUtil {

	public static void main(String[] args) throws Exception {
		FileCompareUtil util = new FileCompareUtil();
		String file1 = "c:/files/filecompare1.txt";
		String file2 = "c:/files/filecompare2.txt";
		System.out.println(util.compareFile(file1, file2));
		System.out.println("Successful!!!");
	}
	
	// txt파일의 라인 수는 동일하다고 간주
	// 첫 파일 내용을 기준으로 두번째 파일 내용을 비교하고 동일하면 다음 라인으로 이동
	// 다를 경우에는 해당 라인의 번호와 함께 두번째 파일의 해당 라인 내용을 결과 용도의 ArrayList에 추가함
	public ArrayList<String> compareFile(String fileString1, String fileString2) throws Exception {
		ArrayList<String> results = new CompareList<String>();
		
		File file1 = new File(fileString1);
		File file2 = new File(fileString2);
		
		FileInputStream fis1 = new FileInputStream(file1);
		InputStreamReader isr1 = new InputStreamReader(fis1);
		BufferedReader br1 = new BufferedReader(isr1);
		
		FileInputStream fis2 = new FileInputStream(file2);
		InputStreamReader isr2 = new InputStreamReader(fis2);
		BufferedReader br2 = new BufferedReader(isr2);
		
		String text1 = "";
		String text2 = "";
		
		int lineCount = 0;
		while ((text1 = br1.readLine()) != null) {
			text2 = br2.readLine();
			lineCount++;
			if (!text1.equals(text2)) {
				results.add("LINE " + lineCount + ":" + text2);
			}
		}
		
		return results;
	}
	
	public class CompareList<String> extends ArrayList {
		@Override
		public java.lang.String toString() {
			Iterator<String> itr = iterator();
			java.lang.String result = "";
			while(itr.hasNext()) {
				String next = itr.next();
				result = (java.lang.String) (result + next + "\n");
			}
			return result;
		}
	}
	
}
