package test.addr;
/**
 * 
 * @author 
 *	ArrayList Ŭ���� �ۼ�
	��� �ۼ�
	����Ʈ �信 "�̸� : " ������ ������� ����.
	add, delete, update ��ư�� 
 */
public class TestAddr {

	public static void main(String[] args) {
		ListAdapter adapter = new ListAdapter();
		String name = "ȫ�浿"; String name2 = "�Ӳ���";
		adapter.insert(name); adapter.insert(name2);
		System.out.println(adapter.select(0));
		System.out.println(adapter.select(1));
		adapter.delete(0); adapter.update(0, "����");
		System.out.println(adapter.select(0));
		
		int i = 0;
		for (String str : adapter.all()) {
			System.out.println((++i) + " : " + str);
		}
	}

}
