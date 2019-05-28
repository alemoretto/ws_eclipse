package it.prova.service;

import it.prova.dao.user.UserDAOImpl;
import it.prova.service.user.UserService;
import it.prova.service.user.UserServiceImpl;

public class MyServiceFactory {
	
	public static UserService getUserServiceImpl() {
		UserService userService = new UserServiceImpl();
		userService.setUserDao(new UserDAOImpl());
		return userService;
	}

}
