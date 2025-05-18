package student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired StudentRepository repository;
public List<Student> getAllStudent(){
java.util.List<Student> records =new java.util.ArrayList<Student>();
repository.findAll().forEach(records::add);
return records;
	}
public Student getStudentById(Integer id) {
		return repository.findById(id).get();
	}
	public void addStudent(Student studentRecord) {
		repository.save(studentRecord);
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	public Student updateStudent(Student student) {
		int sid=student.getSid();
		Student p=repository.findById(sid).get();
		p.setSid(sid);
        p.setSname(student.getSname());
		p.setScourse(student.getScourse());
		repository.save(p);
		return p;
		}
	
}