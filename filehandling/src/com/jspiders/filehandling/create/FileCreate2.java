package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate2 {

	public static void main(String[] args) {
		// Absolute Path--->
		File file = new File("D:\\WEJM5\\WORKSPACE\\filehandling\\wejm5.txt");
		try {
			file.createNewFile();
			System.out.println("File created successfully..!!");
		} catch (IOException e) {
			System.out.println("File not created..!!");
		}
	}
}
