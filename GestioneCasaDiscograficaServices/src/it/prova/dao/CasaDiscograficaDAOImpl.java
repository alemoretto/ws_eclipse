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
	public List<CasaDiscografica> findByExample(CasaDiscografica casaDiscografica) throws Exception {

		if (isNotActive() || casaDiscografica == null) {
			return null;
		}

		ArrayList<CasaDiscografica> result = new ArrayList<CasaDiscografica>();
		CasaDiscografica casaDiscograficaTemp = null;

		String query = "select * from casadiscografica where 1=1 ";
		if (casaDiscografica.getRagioneSociale() != null && !casaDiscografica.getRagioneSociale().equals("")) {
			query += " and ragione_sociale='" + casaDiscografica.getRagioneSociale() + "' ";
		}
		if (casaDiscografica.getPartitaIva() != null && !casaDiscografica.getPartitaIva().equals("")) {
			query += " and partita_iva='" + casaDiscografica.getPartitaIva() + "' ";
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

}
