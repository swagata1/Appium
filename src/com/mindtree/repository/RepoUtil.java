package com.mindtree.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RepoUtil {

	
	@SuppressWarnings("finally")
	public String getObject(String name) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = null;

		try {

			input = new FileInputStream("src"+File.separator+"com"+File.separator+"mindtree"+File.separator+"repository"+File.separator+"ObjectRepo.properties");

			prop.load(input);
			value = prop.getProperty(name);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return value;
		}
	}

	@SuppressWarnings("finally")
	public String getData(String name) {
		Properties prop = new Properties();
		InputStream input = null;
		String value = null;

		try {

			input = new FileInputStream("src"+File.separator+"com"+File.separator+"mindtree"+File.separator+"repository"+File.separator+"DataRepo.properties");

			prop.load(input);
			value = prop.getProperty(name);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return value;
		}

	}
}
