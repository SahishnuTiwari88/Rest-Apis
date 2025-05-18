package com.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.contactmanager.dao.UserRepository;
import com.contactmanager.entities.User;
import com.contactmanager.helper.Message;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
//@RestController
public class HomeController {
	@Autowired
	private UserRepository userep;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("about", "about - Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signup", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());//done in order to send empty user or error and it's referance in signup page as th:object
		return "signup";
	}
	
	//handler for user registering
	@PostMapping("do-register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult bindresult,@RequestParam(value="agreement",defaultValue = "false")
		boolean agreement,Model model, 
			HttpSession session)
	
	{
		try {
			
			if(!agreement) {
				System.out.println("You have not accepted T&C");
				throw new Exception("You have not accepted T&C");
				
			}
			if(bindresult.hasErrors()) {
				System.out.println("Error "+bindresult.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.jpg");
			//use becrypt password encoder
			
			System.out.println("Agreement "+agreement);
			System.out.println("User "+user);
			
			//if work successfully without any error then this will work
			User result = userep.save(user);
			model.addAttribute("user", new User());

			
			session.setAttribute("message", new Message("Successfully Register !!","alert-success"));
			return "signup";
			
			//System.out.println("result "+result);
			
		}
		catch(Exception e) {
			e.printStackTrace();

			model.addAttribute("user", user);//because returning same page with msg on it
			session.setAttribute("message", new Message("something went wrong !!"+e.getMessage(),"alert-danger"));
			return "signup";
		}
		
		
		
	}
	

}



//th:classappend="${#fields.hasError('name')? 'is-invalid':''} dynamicaaly checks if any error occur on the given field
