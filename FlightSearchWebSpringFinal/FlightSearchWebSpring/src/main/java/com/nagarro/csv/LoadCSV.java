package com.nagarro.csv;

import java.io.File;
import java.io.FileFilter;

import com.nagarro.constants.FinalValues;

public class LoadCSV {
	public File[] load() {
		FileFilter filter = (File pathname) -> pathname.getName().endsWith(".csv");
		File dir = new File(FinalValues.PATH);
		File[] files = dir.listFiles(filter);
		return files;
	}
}
