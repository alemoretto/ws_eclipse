package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;

public class AutoreDAOImpl extends AbstractMySQLDAO implements AutoreDAO {

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Autore> list() throws Exception {

		if (isNotActive()) {
			return null;
		}

		ArrayList<Autore> result = new ArrayList<Autore>();

		try (Statement ps = connection.createStatement()) {

			ResultSet rs = ps.executeQuery(
					"select * from autore a LEFT OUTER JOIN casadiscografica c ON a.casadiscografica_id=c.idcasadiscografica");

			while (rs.next()) {
				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("nome"));
				autoreTemp.setCognome(rs.getString("cognome"));
				autoreTemp.setId(rs.getLong("idautore"));

				CasaDiscografica casaTemp = new CasaDiscografica();
				casaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaTemp.setId(rs.getLong("idcasadiscografica"));

				autoreTemp.setCasaDiscografica(casaTemp);
				result.add(autoreTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		}
		return result;
	}

	@Override
	public Autore get(Long id) throws Exception {
		if (isNotActive() || id < 1) {
			return null;
		}

		Autore result = null;

		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM autore a LEFT OUTER JOIN casadiscografica c ON a.casadiscografica_id=c.idcasadiscografica WHERE a.idautore = ? ")) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new Autore();
				result.setNome(rs.getString("nome"));
				result.setCognome(rs.getString("cognome"));
				result.setId(rs.getLong("idautore"));

				CasaDiscografica casaTemp = new CasaDiscografica();
				casaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaTemp.setPartitaIva(rs.getString("partita_iva"));
				casaTemp.setId(rs.getLong("idcasadiscografica"));

				result.setCasaDiscografica(casaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
		return result;

	}

	@Override
	public int insert(Autore autoreInput) throws Exception {
		return 0;
	}

	@Override
	public int update(Autore autoreInput) throws Exception {
		return 0;
	}

	@Override
	public List<Autore> findByExample(Autore autoreInput) throws Exception {
		return null;
	}

	@Override
	public int delete(Autore autoreInput) throws Exception {
		return 0;
	}
}
