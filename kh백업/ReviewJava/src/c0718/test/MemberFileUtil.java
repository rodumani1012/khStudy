package c0718.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MemberFileUtil {

	public static void writeMemberFile(ArrayList<Member> memberList, String FileInfo) {

		File ft = new File(FileInfo);

		// Stream
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {

			fos = new FileOutputStream(ft);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);

			for (int index = 0; index < memberList.size(); index++) {
				Member m = memberList.get(index);

				String id = m.getId();
				String password = m.getPassword();
				String name = m.getName();
				String email = m.getEmail();
				String regdate = m.getRegdate();

				String line = System.getProperty("line.separator"); // 줄바꿈
				String memeberData = id + "/" + password + "/" + name + "/" + email + "/" + regdate + line;
				bw.write(memeberData);

			}

			// Close
			bw.close();
			osw.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("\n---------- IO Fail ----------");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {

					bw.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (osw != null) {
					osw.close();
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

	public static void writeMemberFileAppend(ArrayList<Member> memberList, String FileInfo) {

		File ft = new File(FileInfo);

		// Stream
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {

			fos = new FileOutputStream(ft, true);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);

			for (int index = 0; index < memberList.size(); index++) {
				Member m = memberList.get(index);

				String id = m.getId();
				String password = m.getPassword();
				String name = m.getName();
				String email = m.getEmail();
				String regdate = m.getRegdate();

				String line = System.getProperty("line.separator"); // 줄바꿈
				String memeberData = id + "/" + password + "/" + name + "/" + email + "/" + regdate + line;
				bw.write(memeberData);

			}

			// Close
			bw.close();
			osw.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("\n---------- IO Fail ----------");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {

					bw.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (osw != null) {
					osw.close();
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

	public static ArrayList<Member> readMemberFile(String FileInfo) {

		// ArryaList
		ArrayList<Member> memberList = new ArrayList<Member>();

		// File
		File fs = new File(FileInfo);

		// Stream
		FileInputStream fis = null;
		InputStreamReader isr = null; // InputStream --> Reader
		BufferedReader br = null;
		try {

			fis = new FileInputStream(fs);
			isr = new InputStreamReader(fis);
			// isr = new InputStreamReader(fis, "UTF-8"); // UTF-8 인코딩으로 읽는다.
			// FileReader는 인코딩 설정이 없다. 따라서 InputStreamReader 사용
			br = new BufferedReader(isr);

			while (true) {

				String readString = br.readLine();
				if (readString == null) {
					break;
				}

				String[] stringArray = readString.split("/");
				String id = stringArray[0];
				String password = stringArray[1];
				String name = stringArray[2];
				String email = stringArray[3];
				String regdate = stringArray[4];

				Member m = new Member(id, password, name, email, regdate);

				memberList.add(m);
			}

			// Close
			br.close();
			isr.close();
			fis.close();

		} catch (IOException e) {
			System.out.println("\n---------- IO Fail ----------");
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {

					br.close();
				}

			} catch (IOException e) {
				System.out.println("\n---------- Close Fail ----------");
				e.printStackTrace();
			}
			try {
				if (isr != null) {

					isr.close();
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
		}

		return memberList;
	}
}
