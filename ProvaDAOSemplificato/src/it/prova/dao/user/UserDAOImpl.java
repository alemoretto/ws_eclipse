package it.prova.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.prova.dao.AbstractMySQLDAO;
import it.prova.model.User;

public class UserDAOImpl extends AbstractMySQLDAO implements UserDAO {

	public UserDAOImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int delete(User utenteInput) throws Exception {

		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM user WHERE ID=" + utenteInput.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}


	@Override
	public User get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		User userTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from user where id=" + id);

			if (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return userTemp;
	}

	@Override
	public int insert(User utenteInput) throws Exception {

		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("INSERT INTO user (nome, cognome, login, password, dateCreated) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getLogin());
			ps.setString(4, utenteInput.getPassword());
			//quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(5, new java.sql.Date(utenteInput.getDateCreated().getTime()));
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<User> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<User> arr = new ArrayList<User>();
		User userTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("SELECT * FROM user");

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
				arr.add(userTemp);

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;
	}

	@Override
	public int update(User utenteInput) throws Exception {
		if (isNotActive() || utenteInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("UPDATE user SET nome=?, cognome=?, login=?, password=?, dateCreated=? where id=?;")) {
			ps.setString(1, utenteInput.getNome());
			ps.setString(2, utenteInput.getCognome());
			ps.setString(3, utenteInput.getLogin());
			ps.setString(4, utenteInput.getPassword());
			//quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(5, new java.sql.Date(utenteInput.getDateCreated().getTime()));
			ps.setLong(6, utenteInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public List<User> findAllWhereDateCreatedGreaterThan(Date dateCreatedInput) throws Exception{
		if (isNotActive() || dateCreatedInput == null) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;

		try (PreparedStatement ps = connection.prepareStatement("select * from user where dateCreated > ? ;")) {
			//quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(1, new java.sql.Date(dateCreatedInput.getTime()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	//DA FARE PER ESERCIZIO
	
	@Override
	public List<User> findByExample(User input) throws Exception {
		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;

		String query = "select * from user where 1=1 ";
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}
		
		if (input.getLogin() != null && !input.getLogin().equals("")) {
			query += " and login='" + input.getLogin() + "' ";
		}
		
		if (input.getPassword() != null && !input.getPassword().equals("")) {
			query += " and password='" + input.getPassword() + "' ";
		}
		
		if (input.getDateCreated() != null ) {
			query += " and DATECREATED='" + new java.sql.Date(input.getDateCreated().getTime()) + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				input.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}
	
	@Override
	public List<User> findAllByCognome(String cognomeInput) throws Exception {
		if (isNotActive() || cognomeInput == null) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;
		
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE cognome = ? ")) {
			ps.setString(1, cognomeInput);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	@Override
	public List<User> findAllByLoginIniziaCon(String caratteriInizialiInput) throws Exception {
		if (isNotActive() || caratteriInizialiInput == null) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;
		
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE login LIKE ? ")) {
			ps.setString(1, caratteriInizialiInput + "%");
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	@Override
	public User findByLoginAndPassword(String loginInput, String passwordInput) throws Exception {
		if (isNotActive() || loginInput == null || passwordInput == null) {
			return null;
		}

		User result = null;
		
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ? ")) {
			ps.setString(1, loginInput);
			ps.setString(2, passwordInput);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new User();
				result.setNome(rs.getString("NOME"));
				result.setCognome(rs.getString("COGNOME"));
				result.setLogin(rs.getString("LOGIN"));
				result.setPassword(rs.getString("PASSWORD"));
				result.setDateCreated(rs.getDate("DATECREATED"));
				result.setId(rs.getLong("ID"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	@Override
	public List<User> findAllByPasswordIsNull() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;
		
		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("SELECT * FROM user WHERE password IS NULL");			

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				userTemp.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		
		return result;
	}

	
	//############################################################
	//############ SOLUZIONE FINDBYEXAMPLE #######################
	//############################################################
	/*
	public List<User> findByExample(User input) throws Exception {

		if (isNotActive() || input == null) {
			return null;
		}

		ArrayList<User> result = new ArrayList<User>();
		User userTemp = null;

		String query = "select * from user where 1=1 ";
		if (input.getCognome() != null && !input.getCognome().equals("")) {
			query += " and cognome='" + input.getCognome() + "' ";
		}
		if (input.getNome() != null && !input.getNome().equals("")) {
			query += " and nome='" + input.getNome() + "' ";
		}
		
		if (input.getLogin() != null && !input.getLogin().equals("")) {
			query += " and login='" + input.getLogin() + "' ";
		}
		
		if (input.getPassword() != null && !input.getPassword().equals("")) {
			query += " and password='" + input.getPassword() + "' ";
		}
		
		if (input.getDateCreated() != null ) {
			query += " and DATECREATED='" + new java.sql.Date(input.getDateCreated().getTime()) + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				userTemp = new User();
				userTemp.setNome(rs.getString("NOME"));
				userTemp.setCognome(rs.getString("COGNOME"));
				userTemp.setLogin(rs.getString("LOGIN"));
				userTemp.setPassword(rs.getString("PASSWORD"));
				userTemp.setDateCreated(rs.getDate("DATECREATED"));
				input.setId(rs.getLong("ID"));
				result.add(userTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}
*/
}
