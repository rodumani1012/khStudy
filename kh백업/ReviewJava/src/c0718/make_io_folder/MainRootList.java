package c0718.make_io_folder;

import java.io.File;

public class MainRootList {

	public static void main(String[] args) {
		File[] rootArray = File.listRoots(); //roots();�� ��ǻ���� ����̺긦 ��Ī�ϰ� listRoots();�� �� ����̺���� ����Ʈ�� ������ִ� ���̴�.
		for (int i = 0; i < rootArray.length; i++) {
			File root = rootArray[i];
			System.out.println(root);
		}

	}

}
