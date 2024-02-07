package validation.icicibank.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import validation.icicibank.entity.User_Entity;
import validation.icicibank.service.User_serv;

@RestController
@RequestMapping("/c")
public class User_cont {
User_serv serv;

public User_cont(User_serv serv) {
	
	this.serv = serv;
}
@PostMapping("/r")
public String register(@RequestBody User_Entity ent) {
	serv.register(ent);
	return "added to database";
}
@PostMapping("/vc")
public String validate(@RequestBody String cardnumber) {
	return serv.validate(cardnumber);
	 
	
}
}
