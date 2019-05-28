package it.prova.service.user;

import java.util.List;

import it.prova.dao.user.UserDAO;
import it.prova.model.User;

public interface UserService {

	// questo mi serve per injection
	public void setUserDao(UserDAO userDao);

	public List<User> listAllUsers() throws Exception;

	public User findUserById(Long idInput) throws Exception;

	public int aggiornaUser(User input) throws Exception;

	public int inserisciNuovoUser(User input) throws Exception;

	public int rimuoviUser(User input) throws Exception;

	public List<User> findByExample(User input) throws Exception;

}
