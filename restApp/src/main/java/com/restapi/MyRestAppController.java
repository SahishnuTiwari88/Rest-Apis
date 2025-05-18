package com.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyRestAppController {
	@GetMapping("/welcome")
public  String sendMessage() {
		return "Welcome to All";
	}
@GetMapping("/welcome/{username}")
public String addnumber(@PathVariable("username")String user) {
	return "Welcome to <b>"+user+"</b>";
}
@GetMapping("/adding/{x}/{y}")
public String invite(@PathVariable("x")int a,@PathVariable("y")int b) {
	return String.valueOf(a+b);
}
@RequestMapping("/myfile")
public ModelAndView loadMe() {
	return new ModelAndView("MyFile");
}

}
