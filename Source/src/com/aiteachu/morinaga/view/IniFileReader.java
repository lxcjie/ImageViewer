package com.aiteachu.morinaga.view;

import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class IniFileReader {
	private static Wini iniFile;

	static {
		try {
			iniFile = new Wini(new File("config.ini"));
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getConfigValue(String section, String key){
		return iniFile.get(section, key);
	}
}
