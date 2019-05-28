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
	public CasaDiscografica get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		CasaDiscografica casaDiscograficaTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from user where id=" + id);

			if (rs.next()) {
				casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragioneSociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("partitaIva"));
				casaDiscograficaTemp.setId(rs.getLong("idcasadiscografica"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return casaDiscograficaTemp;
	}

	@Override
	public int insert(CasaDiscografica casaDiscograficaInput) throws Exception {

		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO casadiscografica (ragioneSociale, partitaIva) VALUES (?, ?);")) {
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
	public int update(CasaDiscografica casaDiscograficaInput) throws Exception {
		if (isNotActive() || casaDiscograficaInput == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("UPDATE casadiscografica SET ragioneSociale=?, partitaIva=? WHERE id=?;")) {
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
//		List<User> result = new ArrayList<>();
//		try(Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
//
//			// inietto la connection nel dao
//			userDao.setConnection(connection);
//
//			// eseguo quello che realmente devo fare
//			result = userDao.findByExample(input);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} 
		return null;
	}

}
