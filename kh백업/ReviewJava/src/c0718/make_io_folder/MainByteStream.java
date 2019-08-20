package c0718.make_io_folder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainByteStream {

	public static void main(String[] args) {

		// File
		File fs = new File("C:/Work/Data_S.zip"); // 타겟
		// File fs = new File("C:/Work/tree_leaf.jpg");
		File ft = new File("C:/Work/Data_S-복사본1.zip"); // 타겟의 이름만 바꾼 복제품
		// Stream
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {

			fis = new FileInputStream(fs);
			fos = new FileOutputStream(ft);

			long startTime = System.nanoTime();
			while (true) {

				int readInt = fis.read();
				if (readInt == -1) {
					break;
				}

				fos.write(readInt);
			}
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			double elapsedTimeMSec = elapsedTime / 1000000.0;
			System.out.println("작업시간=[" + elapsedTimeMSec + "(ms)]");
			double elapsedTimeSec = elapsedTime / 1000.0;
			System.out.println("작업시간=[" + elapsedTimeSec + "(sec)]");
			// Close
			fis.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("\n---------- IO Fail ----------");
			e.printStackTrace();
		} finally {

			try {
				if (fis != null) {

					fis.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
		}

	}

}