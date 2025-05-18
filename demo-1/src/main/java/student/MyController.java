package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
//@RequestMapping("/")
//public String getPageLoaded() {
//	return "file1";
//}
//@RequestMapping("/person")
//public String loadPerson() {
//	return "personForm";
//}
//@RequestMapping(value="/savePerson",method=RequestMethod.POST)
//public ModelAndView sendData(@ModelAttribute Personn person) {
//	ModelAndView model = new ModelAndView();
//	model.setViewName("validate");
//	model.addObject("p",person);
//	//dao.addPerson(person);
//	return model;
//}
	@Autowired StudentService studentService;
//	@RequestMapping("/")
//	public java.util.List<Personn> getAllRecords(){
//		return personService.getAllPerson();
//	}
@RequestMapping("/")
	public ModelAndView viewAllStudent() {
		ModelAndView modelAndView= new ModelAndView();
		java.util.List<Student> student=studentService.getAllStudent();
		modelAndView.addObject("user", student);
		modelAndView.setViewName("viwe");
		return modelAndView;
		}
@RequestMapping("/addStudent")
	public String loadPerson() {
			return "studentForm";
			}
@RequestMapping(value="/addStudent",method=RequestMethod.POST)
public ModelAndView home(@ModelAttribute Student p) {
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("valid");
	studentService.addStudent(p);
	System.out.println(p.getSname());
	modelAndView.addObject("user",p);
	return modelAndView;
}

@RequestMapping(value="/getStudent")
public ModelAndView getPerson() {
	return new ModelAndView("getStudent");
	
}

@RequestMapping(value="/getByID",method=RequestMethod.POST)
public ModelAndView getPersonByID(@RequestParam("sid")int id) {
	Student student = studentService.getStudentById(id);
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("valid");
	studentService.addStudent(student);
	System.out.println(student.getSname());
	modelAndView.addObject("ps",student);
	return modelAndView;
}


@RequestMapping("/update/{id}")

public ModelAndView updatePerson(@PathVariable("id")int id) {
	Student student = studentService.getStudentById(id);
	return new ModelAndView("updateStudent").addObject("student",student);
}
@RequestMapping(value="updateMe",method = RequestMethod.POST)
public ModelAndView updated(@ModelAttribute Student p) {
	ModelAndView modelAndView = new ModelAndView();
	studentService.updateStudent(p);
	java.util.List<Student> student = studentService.getAllStudent();
	modelAndView.addObject("ps",student);
	modelAndView.setViewName("viwe");
	studentService.getAllStudent().stream().forEach(e->System.out.print(e.getSid()+" "+e.getSname()+" "+e.getScourse()));
	return modelAndView;
	
}
@RequestMapping("/delete/{id}")
public ModelAndView deleteStudent(@PathVariable("id")int id) {
	studentService.delete(id);
	ModelAndView modelAndView = new ModelAndView();
	java.util.List<Student> student = studentService.getAllStudent() ;
	modelAndView.addObject("ps",student);
	modelAndView.setViewName("viwe");
	return modelAndView;
	
}


}
