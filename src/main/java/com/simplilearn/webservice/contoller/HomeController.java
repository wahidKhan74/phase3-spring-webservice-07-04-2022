package com.simplilearn.webservice.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public String indexMapping() {
		return "Welcome, to spring boot developement, Server is up and running !";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public String helloMapping() {
		return "Hello, everyone ! welcome to Webservice learning !";
	}
	
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	@ResponseBody
	public String hiMapping(@RequestParam("name") String name) {
		return "Hi, "+name+" welcome to Webservice learning !";
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String usersMapping(@PathVariable("id") long id) {
		return "The use profile for "+id;
	}
}
