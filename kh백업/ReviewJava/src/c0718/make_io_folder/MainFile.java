package c0718.make_io_folder;

import java.io.File;
import java.io.IOException;

public class MainFile {

	public static void main(String[] args) {
		String filePath = "C:/Work/MyFile.txt";
		File file = new File(filePath);
		boolean isExist = file.exists();
		System.out.println("exist()=[" + isExist + "]");
		if (isExist == false) {
			try {
				file.createNewFile();
				System.out.println("--------Info--------");
				isExist = file.exists();
				System.out.println("exist()=[" + isExist + "]");
				boolean isFile = file.isFile();
				System.out.println("isFile()=[" + isFile + "]");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
