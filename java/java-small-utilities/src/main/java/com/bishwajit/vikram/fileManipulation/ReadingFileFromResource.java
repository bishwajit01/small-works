package com.bishwajit.vikram.fileManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Bishwajit
 *
 */
public class ReadingFileFromResource {

	public static void main(String[] args) throws IOException {
		InputStream is = ReadingFileFromResource.class.getResourceAsStream("/config/sample-1.json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
