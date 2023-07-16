package com.jspiders.serializationdeserialization.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.object.User;

public class UserSerialization {
	
	public static void main(String[] args) {
		
		try {
			File file = new File("User.txt");
			if (file.exists()) {
				System.out.println("File already exists..!!");
			}
			else {
				file.createNewFile();
				System.out.println("File created successfully..!!");	
			}
			User user = new User();
			user.setId(1);
			user.setName("Aditya");
			user.setUsername("Aditya1432");
			user.setPassword("aditya1233");
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(user);;
			System.out.println("Object written to file..!!");
			
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}
}
