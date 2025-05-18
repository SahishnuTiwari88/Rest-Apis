package com;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	List<Student> a=new ArrayList<Student>();
	public void addStudents() {
		
		a.add(new Student(1,"A","Varansi"));
		a.add(new Student(2,"B","Kanpur"));
		a.add(new Student(3,"C","Meerut"));
		a.add(new Student(4,"D","Delhi"));
		a.add(new Student(5,"E","UP"));
		a.add(new Student(6,"F","EC4"));
		a.add(new Student(7,"G","India"));
		a.add(new Student(8,"H","Mathura"));
		a.add(new Student(9,"I","Bangalore"));
		a.add(new Student(10,"J","Patna"));
	}

	public void getAllDetails() {
		System.out.println("Id\t"+"Name\t"+"Adress");
		a.stream().forEach(d->{System.out.println(d.getStudentId()+"\t\t"+
				d.getStudentName()+"\t\t"+d.getStudentAddress());
		});
		System.out.println("***********************************************");
				
	}
	public void getDetails(int id) {
		System.out.println("Id\t"+"Name\t"+"Adress\n");
		a.stream().filter(d->d.getStudentId()==id).forEach(d->System.out.println(d.getStudentId()+"\t\t"+
		d.getStudentName()+"\t\t"+d.getStudentAddress()+""));
	}
}
