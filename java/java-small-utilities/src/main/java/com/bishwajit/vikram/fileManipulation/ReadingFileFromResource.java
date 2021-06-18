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

	private static final String CONFIG_FILE = "/config/sample-1.json";

	public static void main(String[] args) {
		readingFileFromResource();
	}

	private static void readingFileFromResource() {
		try (InputStream is = ReadingFileFromResource.class.getResourceAsStream(CONFIG_FILE);
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
