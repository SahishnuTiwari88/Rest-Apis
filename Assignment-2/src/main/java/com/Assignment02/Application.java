package com.Assignment02;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext con = new ClassPathXmlApplicationContext("Config.xml");
		StudentDAO dao = con.getBean("dao", StudentDAO.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice from 1 to 3");

		int n = 0;

		do {

			System.out.println("\nEnter 1 to Save new Record");

			System.out.println("Enter 2 to fetch All records");
			System.out.println("Enter 3 to fetch single record");

			System.out.println("Enter 0 to Exit\n");
			n = sc.nextInt();

			switch (n) {

			case 1:

				Student s = new Student();
				System.out.println("Enter name");

				String name = sc.next();
				System.out.println("Enter Address");

				String add = sc.next();
				s.setStudentName(name);

				s.setStudentAddress(add);
				dao.save(s);

				System.out.println("Record Inserted ");

				break;

			case 2:

				List<Student> st = dao.getAll();
				System.out.println("Student Details are:--");

				for (Student s1 : st) {

					System.out.println(
							"\n" + s1.getStudentId() + " " + s1.getStudentName() + " " + s1.getStudentAddress());

				}
				break;

			case 3:

				System.out.println("Enter Student Id:- ");

				int id = sc.nextInt();

				Student student = dao.single(id);
				System.out.println("Student details are:--");

				System.out.println("\n" +

						student.getStudentId() + " " + student.getStudentName() + " " + student.getStudentAddress());

				break;

			default:

				System.out.println("Please Select the correct Option");
			}
		}

		while (n > 0);

		System.out.println("Thankyou");

	}
}
