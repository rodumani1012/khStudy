package c0718.make_io_folder;

import java.io.File;

public class MainDirectory {

	public static void main(String[] args) {
		String filePath = "C:/Work/MyFolder";
		File file = new File(filePath);
		boolean isExist = file.exists();
		System.out.println("exist()=[" + isExist + "]");
		if (isExist == false) {
			file.mkdir(); //폴더생성
			System.out.println("----------Info----------");
			isExist = file.exists();
			System.out.println("exist()=[" + isExist + "]");
			boolean isDirectory = file.isDirectory();
			System.out.println("isDirectory()=[" + isDirectory + "]");
		}

	}

}
