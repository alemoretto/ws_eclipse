package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl  implements AbitanteDAO {
	
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Abitante> list() throws SQLException {

//		if (isNotActive()) {
//			return null;
//		}

		ArrayList<Abitante> arr = new ArrayList<Abitante>();
		Abitante abitanteTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from abitante");

			while (rs.next()) {
				abitanteTemp = new Abitante();
				abitanteTemp.setIdAbitante(rs.getLong("id"));
				abitanteTemp.setNome(rs.getString("nome"));
				abitanteTemp.setCognome(rs.getString("cognome"));
				abitanteTemp.setCodiceFiscale(rs.getString("codiceFiscale"));
				abitanteTemp.setEta(rs.getInt("eta"));
				abitanteTemp.setMottoDiVita(rs.getString("mottoDiVita"));
				arr.add(abitanteTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return arr;

	}

	
//	@Override
//	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
//		List<Abitante> result = new ArrayList<>();
//		
//		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
//			if(abitanteItem.getNome().equals(nome) && abitanteItem.getCognome().equals(cognome))
//				result.add(abitanteItem);
//		}
//		return result;
//	}


	@Override
	public Abitante get(Long id) throws Exception {
		Abitante abitanteTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from abitante where id=" + id);

			if (rs.next()) {
				abitanteTemp = new Abitante();
				abitanteTemp.setIdAbitante(rs.getLong("id"));
				abitanteTemp.setNome(rs.getString("nome"));
				abitanteTemp.setCognome(rs.getString("cognome"));
				abitanteTemp.setCodiceFiscale(rs.getString("codiceFiscale"));
				abitanteTemp.setEta(rs.getInt("eta"));
				abitanteTemp.setMottoDiVita(rs.getString("mottoDiVita"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return abitanteTemp;
	
	}

	@Override
	public int update(Abitante input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO abitante (nome, cognome, codiceFiscale, eta, mottoDiVita) VALUES (?, ?, ?, ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getCognome());
			ps.setString(3, input.getCodiceFiscale());
			ps.setInt(4, input.getEta());
			ps.setString(5, input.getMottoDiVita());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Abitante> findByExample(Abitante abitanteExample) throws Exception {
		ArrayList<Abitante> result = new ArrayList<Abitante>();
		Abitante abitanteTemp = null;

		String query = "select * from abitante where 1=1 ";
		
		if (abitanteExample.getNome() != null && !abitanteExample.getNome().equals("")) {
			query += " and nome LIKE '" + abitanteExample.getNome() + "%' ";
		}
		
		if (abitanteExample.getCognome() != null && !abitanteExample.getCognome().equals("")) {
			query += " and cognome LIKE'" + abitanteExample.getCognome() + "%' ";
		}

//		if (abitanteExample.getCodiceFiscale() != null && !abitanteExample.getCodiceFiscale().equals("")) {
//			query += " and codiceFiscale LIKE'" + abitanteExample.getCodiceFiscale() + "%' ";
//		}
//		
//		if (input.getLogin() != null && !input.getLogin().equals("")) {
//			query += " and login='" + input.getLogin() + "' ";
//		}
//
//		if (input.getPassword() != null && !input.getPassword().equals("")) {
//			query += " and password='" + input.getPassword() + "' ";
//		}

		// TODO: la data

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				abitanteTemp = new Abitante();
				abitanteTemp.setIdAbitante(rs.getLong("id"));
				abitanteTemp.setNome(rs.getString("nome"));
				abitanteTemp.setCognome(rs.getString("cognome"));
				abitanteTemp.setCodiceFiscale(rs.getString("codiceFiscale"));
				abitanteTemp.setEta(rs.getInt("eta"));
				abitanteTemp.setMottoDiVita(rs.getString("mottoDiVita"));
				result.add(abitanteTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	

}
