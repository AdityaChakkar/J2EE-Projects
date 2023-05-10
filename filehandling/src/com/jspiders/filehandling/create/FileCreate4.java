package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate4 {

	public static void main(String[] args) {
		File file = new File("wejm5.txt");
		if (file.exists()) {
			System.out.println("File already exists..!!");
		}
		else {
			try {
				file.createNewFile();
				System.out.println("File created successfully..!!");
			} catch (IOException e) {
				System.out.println("File not created..!!");
			}
		}
		System.out.println("Name of the File: " + file.getName());
		System.out.println("Path of the File: " + file.getAbsolutePath());
		System.out.println("Length of the File: " + file.length());
		if(file.canRead()) {
			System.out.println("File is Readable");
		}else {
			System.out.println("File is not Readable");
		}
		if(file.canWrite()) {
			System.out.println("File is Writable");
		}else {
			System.out.println("File is not Writable");
		}
		if(file.canExecute()) {
			System.out.println("File is Executable");
		}else {
			System.out.println("File is not Executable");
		}
	}
}
