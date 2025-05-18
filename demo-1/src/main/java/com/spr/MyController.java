package com.spr;

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
	@Autowired PersonService personService;
//	@RequestMapping("/")
//	public java.util.List<Personn> getAllRecords(){
//		return personService.getAllPerson();
//	}
@RequestMapping("/")
	public ModelAndView viewAllPersons() {
		ModelAndView modelAndView= new ModelAndView();
		java.util.List<Personn> personns=personService.getAllPerson();
		modelAndView.addObject("user", personns);
		modelAndView.setViewName("viewAll");
		return modelAndView;
		}
@RequestMapping("/addPerson")
	public String loadPerson() {
			return "personForm";
			}
@RequestMapping(value="/addPerson",method=RequestMethod.POST)
public ModelAndView home(@ModelAttribute Personn p) {
	
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("validate");
	personService.addPerson(p);
	System.out.println(p.getPname());
	modelAndView.addObject("user",p);
	return modelAndView;
}

@RequestMapping(value="/getPerson")
public ModelAndView getPerson() {
	return new ModelAndView("getPerson");
	
}

@RequestMapping(value="/getByID",method=RequestMethod.POST)
public ModelAndView getPersonByID(@RequestParam("id")int id) {
	Personn person = personService.getPersonById(id);
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("validate");
	personService.addPerson(person);
	System.out.println(person.getPname());
	modelAndView.addObject("ps",person);
	return modelAndView;
}


@RequestMapping("/update/{id}")

public ModelAndView updatePerson(@PathVariable("id")int id) {
	Personn person = personService.getPersonById(id);
	return new ModelAndView("updatePerson").addObject("person",person);
}
@RequestMapping(value="updateMe",method = RequestMethod.POST)
public ModelAndView updated(@ModelAttribute Personn p) {
	ModelAndView modelAndView = new ModelAndView();
	personService.updatePerson(p);
	java.util.List<Personn> persons = personService.getAllPerson();
	modelAndView.addObject("ps",persons);
	modelAndView.setViewName("viewAll");
	personService.getAllPerson().stream().forEach(e->System.out.print(e.getPid()+" "+e.getPname()+" "+e.getPjob()));
	return modelAndView;
	
}
@RequestMapping("/delete/{id}")
public ModelAndView deletePerson(@PathVariable("id")int id) {
	personService.delete(id);
	ModelAndView modelAndView = new ModelAndView();
	java.util.List<Personn> persons = personService.getAllPerson() ;
	modelAndView.addObject("ps",persons);
	modelAndView.setViewName("viewAll");
	return modelAndView;
	
}


}
