package c0718.make_io_folder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainByteStreamBuffer {

	public static void main(String[] args) {

		// File
		File fs = new File("C:/Work/Data_S.zip");
		File ft = new File("C:/Work/Target_Data_T.zip");

		// Stream
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {

			fis = new FileInputStream(fs);
			bis = new BufferedInputStream(fis);

			fos = new FileOutputStream(ft);
			bos = new BufferedOutputStream(fos);
			
			long startTime = System.nanoTime();
			while (true) {

				// read
				int readInt = bis.read();
				if (readInt == -1) {
					break;
				}
				// write
				bos.write(readInt);

			}
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			double elapsedTimeMSec = elapsedTime / 1000000.0;
			System.out.println("작업시간=[" + elapsedTimeMSec + "(ms)]");
			double elapsedTimeSec = elapsedTime / 1000.0;
			System.out.println("작업시간=[" + elapsedTimeSec + "(sec)]");

			// Close
			bis.close();
			fis.close();

			bos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("\n---------- IO Fail ----------");
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {

					bis.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (fis != null) {

					fis.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (bos != null) {

					bos.close();
				}

			} catch (IOException e) {
				System.out.println("Close Fail.");
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}

			} catch (IOException e) {
				System.out.println("Close Fail.");
				e.printStackTrace();
			}
		}
	}

}
