package it.prova.dao.user;

import java.util.Date;
import java.util.List;

import it.prova.dao.IBaseDAO;
import it.prova.model.User;

public interface UserDAO extends IBaseDAO<User> {
	
	public List<User> findAllWhereDateCreatedGreaterThan(Date dateCreatedInput) throws Exception;
	public List<User> findAllByCognome(String cognomeInput) throws Exception;
	public List<User> findAllByLoginIniziaCon(String caratteriInizialiInput) throws Exception;
	public User findByLoginAndPassword(String loginInput, String passwordInput) throws Exception;
	public List<User> findAllByPasswordIsNull() throws Exception;

}
