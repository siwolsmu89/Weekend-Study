package fileController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileController {

	public void reverseLine(String oldf, String newf) throws Exception {

		File oldFile = new File(oldf);
		File newFile = new File(newf);

		BufferedReader reader = new BufferedReader(new FileReader(oldFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

		String[] lines = new String[4];

		String line;
		int counter = 0;
		while ((line = reader.readLine()) != null) {
			lines[counter] = line;
			counter++;
		}

		for (int i = 0; i < lines.length; i++) {
			writer.write(lines[3 - i] + "\n");
		}
		writer.flush();

		reader.close();
		writer.close();
	}

	public static void main(String[] args) throws Exception {

		FileController fileController = new FileController();
		String oldf = "C:/files/oldf.txt";
		String newf = "C:/files/newf.txt";
		fileController.reverseLine(oldf, newf);
	}

}
