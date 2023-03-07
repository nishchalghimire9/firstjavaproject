package com.springboot.myfirstwebapp.Controller;
//this is a controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("sayHello") 
	@ResponseBody 
	public String sayHello() {
		return "hello! what are you learning today?";
	}
	@RequestMapping("/saylogin") 
	public String sayHellohtml() {
		return "login";
	}
	
	@RequestMapping("/saylogin") 
	public String sayHellohtml() {
		return "login";
	}
}
