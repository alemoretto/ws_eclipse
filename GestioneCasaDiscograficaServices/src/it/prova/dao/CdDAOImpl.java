package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Autore;
import it.prova.model.Cd;

public class CdDAOImpl extends AbstractMySQLDAO implements CdDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Cd> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("SELECT * FROM cd LEFT OUTER JOIN autore a ON cd.autore_id=a.idautore ");

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setNumeroTracce(rs.getInt("numero_tracce"));
				cdTemp.setId(rs.getLong("idcd"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				cdTemp.setAutore(autoreTemp);
				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public Cd get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		Cd result = null;

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM cd LEFT OUTER JOIN autore a ON cd.autore_id=a.idautore WHERE cd.idcd = ? ")) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new Cd();
				result.setTitolo(rs.getString("titolo"));
				result.setGenere(rs.getString("genere"));
				result.setNumeroTracce(rs.getInt("numero_tracce"));
				result.setId(rs.getLong("idcd"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				result.setAutore(autoreTemp);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;

	}

	@Override
	public int insert(Cd cdInput) throws Exception {

		if (isNotActive() || cdInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO cd (titolo,genere,numero_tracce,autore_id) VALUES (?, ?, ?, ?);")) {
			ps.setString(1, cdInput.getTitolo());
			ps.setString(2, cdInput.getGenere());
			ps.setLong(3, cdInput.getNumeroTracce());
			ps.setLong(4, cdInput.getAutore().getId());

			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;

	}

	@Override
	public int update(Cd cdInput) throws Exception {
		if (isNotActive() || cdInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE cd SET titolo=?, genere=?, numero_tracce=?, autore_id=? WHERE idcd=?;")) {
			ps.setString(1, cdInput.getTitolo());
			ps.setString(2, cdInput.getGenere());
			ps.setLong(3, cdInput.getNumeroTracce());
			ps.setLong(4, cdInput.getAutore().getId());
			ps.setLong(5, cdInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;

	}

	@Override
	public List<Cd> findByExample(Cd cdInput) throws Exception {
		if (isNotActive() || cdInput == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();

		String query = "SELECT * FROM cd  LEFT OUTER JOIN autore a ON cd.autore_id=a.idautore WHERE 1=1 ";
		if (cdInput.getTitolo() != null && !cdInput.getTitolo().equals("")) {
			query += " AND titolo='" + cdInput.getTitolo() + "' ";
		}
		if (cdInput.getGenere() != null && !cdInput.getGenere().equals("")) {
			query += " AND genere='" + cdInput.getGenere() + "' ";
		}

		if (cdInput.getNumeroTracce() > 0) {
			query += " AND numero_tracce='" + cdInput.getNumeroTracce() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setNumeroTracce(rs.getInt("numero_tracce"));
				cdTemp.setId(rs.getLong("idcd"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				cdTemp.setAutore(autoreTemp);
				result.add(cdTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(Cd cdInput) throws Exception {
		if (isNotActive() || cdInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement("DELETE FROM cd WHERE idcd=?;")) {
			ps.setLong(1, cdInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	public List<Cd> findByAutore(Autore autoreInput) throws Exception {

		if (isNotActive() || autoreInput == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM cd INNER JOIN autore a ON cd.autore_id=a.idautore WHERE a.idautore=?")) {
			ps.setLong(1, autoreInput.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setNumeroTracce(rs.getInt("numero_tracce"));
				cdTemp.setId(rs.getLong("idcd"));

				cdTemp.setAutore(autoreInput);
				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	public List<Cd> findAllByGenere(String genere) throws Exception {
		if (isNotActive() || genere == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM cd WHERE genere=?")) {
			ps.setString(1, genere);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setNumeroTracce(rs.getInt("numero_tracce"));
				cdTemp.setId(rs.getLong("idcd"));

				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	public List<Cd> findAllByAutoreWhereTitoloIniziaCon(Autore autoreInput, String iniziale) throws Exception{
		if (isNotActive()  || autoreInput == null || iniziale == null) {
			return null;
		}

		ArrayList<Cd> result = new ArrayList<Cd>();

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM cd INNER JOIN autore a ON cd.autore_id=a.idautore WHERE a.idautore=? AND cd.titolo LIKE ?")) {
			ps.setLong(1, autoreInput.getId());
			ps.setString(2, iniziale + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("titolo"));
				cdTemp.setGenere(rs.getString("genere"));
				cdTemp.setNumeroTracce(rs.getInt("numero_tracce"));
				cdTemp.setId(rs.getLong("idcd"));

				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}
	
}
