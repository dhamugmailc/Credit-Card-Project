package validation.icicibank.service;

import validation.icicibank.entity.User_Entity;

public interface User_serv {

	User_Entity register(User_Entity ent);

	String validate(String cardnumber);

	
	

}
