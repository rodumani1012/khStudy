package c0718.make_io_folder;

import java.io.File;

public class MainRootList {

	public static void main(String[] args) {
		File[] rootArray = File.listRoots(); //roots();는 컴퓨터의 드라이브를 지칭하고 listRoots();는 이 드라이브들을 리스트로 만들어주는 것이다.
		for (int i = 0; i < rootArray.length; i++) {
			File root = rootArray[i];
			System.out.println(root);
		}

	}

}
