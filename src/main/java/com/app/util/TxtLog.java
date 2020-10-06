package com.app.util;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TxtLog {

	public static void write(String filePath, String message) {
		try {
			FileWriter fw = new FileWriter(filePath, true);
			fw.write(message);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
