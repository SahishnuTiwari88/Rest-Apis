package com.Assignment02;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAO {

	private HibernateTemplate temp;

	public HibernateTemplate getTemp() {
		return temp;

	}

	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;

	}

// for adding new record
	@Transactional
	public int save(Student student) {

		Integer save = (Integer) temp.save(student);
		return save;

	}

	public Student single(int id){

		Student st = temp.get(Student.class, 1);
		return st;

	}

	public List<Student> getAll(){

		List<Student> st = temp.loadAll(Student.class);
		return st;

	}
}
