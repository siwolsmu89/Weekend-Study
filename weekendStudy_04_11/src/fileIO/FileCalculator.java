package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCalculator {

	public static void main(String[] args) throws Exception {
		FileCalculator fc = new FileCalculator();
		fc.addCalculateResult("c:/files/filecalculate.txt");
	}
	
	public void addCalculateResult(String inputFileName) throws Exception {
		File file = new File(inputFileName);
		
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String numText = "";
		int sum = 0;
		int multy = 1;
		
		while((numText = br.readLine()) != null) {
			int num = Integer.parseInt(numText);
			sum += num;
			multy *= num;
		}

		// 주의 : FileInputStream, InputStreamReader, BufferedReader등을 모두사용하고 나서
		// FileOutputStream, OutputStreamWriter, BufferedWriter 등을 사용해야 함
		// 이유는 모르지만 안 그러면 BufferedReader 객체의 메소드가 정상적으로 작동하지 않음
		FileOutputStream fos = new FileOutputStream(file, true);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		// .newLine() 메소드는 파일에 공백을 한 줄 입력하는(개행) 메소드
		bw.newLine();
		bw.write("" + sum);
		bw.newLine();
		bw.write("" + multy);
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
