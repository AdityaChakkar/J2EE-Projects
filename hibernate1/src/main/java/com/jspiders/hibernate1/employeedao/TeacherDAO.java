package com.jspiders.hibernate1.employeedao;


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.employeedto.TeacherDTO;

public class TeacherDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner sc = new Scanner(System.in);
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("hibernate1");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	private static void closeConnection() {
		if (factory != null ) {
			factory.close();
		}
		if (manager != null ) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			System.out.println("1.Insert: \n2.Update: \n3.Search: \n4.Delete: ");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				//To Insert the Details:-------
				for (int i = 1; i <= 3; i++) {
					TeacherDTO t1 = new TeacherDTO();
					System.out.println("Enter Teacher Name : ");
					t1.setName(sc.next());
					System.out.println("Enter Subject Name : ");
					t1.setSubject(sc.next());
					System.out.println("Enter Duration Period in months : ");
					t1.setDuration(sc.nextInt());
					manager.persist(t1);
				}
				break;
			case 2:
				//To update the details:------- 
				System.out.println("Enter teacher Id : ");
				TeacherDTO teacher = manager.find(TeacherDTO.class, sc.nextInt());
				System.out.println("1.Update Name : \n2.Update Subject : \n3.Update Duration : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Set Name: ");
					teacher.setName(sc.next());
					manager.persist(teacher);
					System.out.println("Name Updated Successfully...!!");
					break;
				case 2:
					System.out.print("Set Subject: ");
					teacher.setSubject(sc.next());
					manager.persist(teacher);
					System.out.println("Subject Updated Successfully...!!");
					break;
				case 3:
					System.out.println("Set Duration: ");
					teacher.setDuration(sc.nextInt());
					manager.persist(teacher);
					System.out.println("Duration Updated Successfully...!!");
					break;
				default:
					System.out.println("Not Updated...!!");
					break;
				}
			case 3:
				//To Search the Details:------
				System.out.println("Enter the id that you want to display : ");
				TeacherDTO teacher1 = manager.find(TeacherDTO.class, sc.nextInt());
				System.out.println(teacher1);
				break;
			case 4:
				//To delete the Details:------
				System.out.println("Enter the id that you want to Delete : ");
				TeacherDTO teacher2 = manager.find(TeacherDTO.class, sc.nextInt());
				manager.remove(teacher2);
				System.out.println("Data Deleted Successfully...!!");
				break;
			default:
				System.out.println("Thank You..!!");
				break;
			}
			
			transaction.commit();
			
		} catch (Exception e) {
		     e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
