package io.data.run;

import io.data.model.dao.DataIoTest;

public class Run {

	public static void main(String[] args) {
		new DataIoTest().addDate();
		new DataIoTest().readData();
	}

}
