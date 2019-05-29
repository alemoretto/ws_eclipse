package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.CasaDiscografica;

public class CasaDiscograficaDAOImpl extends AbstractMySQLDAO implements CasaDiscograficaDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<CasaDiscografica> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery("select * from casadiscografica");

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public CasaDiscografica get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		CasaDiscografica result = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from casadiscografica where idcasadiscografica=" + id);

			if (rs.next()) {
				result = new CasaDiscografica();
				result.setRagioneSociale(rs.getString("ragione_sociale"));
				result.setPartitaIva(rs.getString("partita_iva"));
				result.setId(rs.getLong("idcasadiscografica"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int insert(CasaDiscografica casaDiscograficaInput) throws Exception {

		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO casadiscografica (ragione_sociale, partita_iva) VALUES (?, ?);")) {
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());

			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}
	
	@Override
	public int update(CasaDiscografica casaDiscograficaInput) throws Exception {
		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"UPDATE casadiscografica SET ragione_sociale=?, partita_iva=? WHERE idcasadiscografica=?;")) {
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());
			ps.setLong(3, casaDiscograficaInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public int delete(CasaDiscografica casaDiscograficaInput) throws Exception {

		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection.prepareStatement(
				"DELETE FROM casadiscografica WHERE idcasadiscografica=" + casaDiscograficaInput.getId())) {
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<CasaDiscografica> findByExample(CasaDiscografica casaDiscograficaInput) throws Exception {

		if (isNotActive() || casaDiscograficaInput == null) {
			return null;
		}

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		String query = "select * from casadiscografica where 1=1 ";
		if (casaDiscograficaInput.getRagioneSociale() != null && !casaDiscograficaInput.getRagioneSociale().equals("")) {
			query += " and ragione_sociale='" + casaDiscograficaInput.getRagioneSociale() + "' ";
		}
		if (casaDiscograficaInput.getPartitaIva() != null && !casaDiscograficaInput.getPartitaIva().equals("")) {
			query += " and partita_iva='" + casaDiscograficaInput.getPartitaIva() + "' ";
		}

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery(query);

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}

	public List<CasaDiscografica> findAllByAutoreWhereCognomeIniziaCon(String iniziale) throws Exception{
		if (isNotActive() || iniziale == null) {
			return null;
		}
		
		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;
		
		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM casadiscografica ca INNER JOIN autore a ON ca.idcasadiscografica = a.casadiscografica_id  WHERE a.nome LIKE ?;")) {
			ps.setString(1, iniziale + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}
	
	public List<CasaDiscografica> findAllByCdWhereGenereEqual(String genere)  throws Exception {
		if (isNotActive() || genere == null) {
			return null;
		}
		
		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;
		
		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM casadiscografica ca INNER JOIN autore a ON ca.idcasadiscografica = a.casadiscografica_id "
				+ "INNER JOIN cd ON a.idautore=cd.autore_id WHERE cd.genere = ? GROUP BY ca.ragione_sociale;")) {
			ps.setString(1, genere);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;
	}
}
