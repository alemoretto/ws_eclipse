package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Persona;

public class PersonaDao {

	public List<Persona> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		Persona temp = null;
		List<Persona> result = new ArrayList<Persona>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from persona;");

			while (rs.next()) {
				temp = new Persona();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setId(rs.getLong("id"));
				temp.setEta(rs.getInt("eta"));
				result.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Persona> selectByNomeCognome(String nome, String cognome) {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Persona temp = null;
		List<Persona> result = new ArrayList<Persona>();

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from persona u where u.nome=? and u.cognome=?;");
			ps.setString(1, nome);
			ps.setString(2, cognome);

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Persona();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setId(rs.getLong("id"));
				temp.setEta(rs.getInt("eta"));
				result.add(temp);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// =============================================== INSERT
	public int insert(Persona input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO persona (nome, cognome, eta) VALUES (?, ?, ?);");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getEta());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// =============================================== UPDATE
	public int update(Persona input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE persona SET nome=?, cognome=?, eta=? where id=?;");
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setInt(3, input.getEta());
			ps.setLong(4, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// =============================================== DELETE
	public int delete(Persona input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from persona where id=?;");
			ps.setLong(1, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// =============================================== DELETEBYCOGNOME
	public int deleteByCognome(String cognomeCriterio) {

		if (cognomeCriterio == null) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from persona where cognome=?;");
			ps.setString(1, cognomeCriterio);

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public Persona findById(long input) {

		if (input < 1) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Persona result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from persona u where u.id=?;");
			ps.setLong(1, input);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Persona();
				result.setNome(rs.getString("NOME"));
				result.setCognome(rs.getString("COGNOME"));
				result.setId(rs.getLong("id"));
				result.setEta(rs.getInt("eta"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Persona> findAllByNomeCheIniziaPer(String stringaIniziale){

		if (stringaIniziale == null || stringaIniziale.length() < 1) {
			return null;
		}

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Persona temp = null;
		List<Persona> result = new ArrayList<Persona>();


		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("select * from persona u where u.nome LIKE ?;");
			ps.setString(1, stringaIniziale + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Persona();
				temp.setNome(rs.getString("NOME"));
				temp.setCognome(rs.getString("COGNOME"));
				temp.setId(rs.getLong("id"));
				temp.setEta(rs.getInt("eta"));
				result.add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
