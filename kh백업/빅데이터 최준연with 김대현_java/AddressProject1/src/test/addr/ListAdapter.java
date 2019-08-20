package test.addr;

import java.util.ArrayList;

public class ListAdapter {
	private ArrayList data;

	public ListAdapter() {
		data = new ArrayList<>();
	}

	public void insert(String name) {
		data.add(name);
	}

	public String select(int i) {
		return (String) data.get(i);
	}

	public void delete(int i) {
		data.remove(i);
	}

	public void update(int i, String string) {
		data.remove(i);
		data.add(i, string);
	}

	public String[] all() {
		return (String[]) data.toArray(new String[data.size()]);
	}

}
