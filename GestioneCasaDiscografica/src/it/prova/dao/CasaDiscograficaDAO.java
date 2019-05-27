package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.CasaDiscografica;

public class CasaDiscograficaDAO {

	public List<CasaDiscografica> list() {

		List<CasaDiscografica> result = new ArrayList<CasaDiscografica>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from casadiscografica;");

			while (rs.next()) {
				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));
				casaDiscograficaTemp.setRagioneSociale(rs.getString("ragione_sociale"));

				result.add(casaDiscograficaTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(CasaDiscografica casaDiscograficaInput) {

		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO casadiscografica (ragione_sociale, partita_iva) VALUES (?, ?);");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE autore SET ragione_sociale=?, partita_iva=? WHERE idcasadiscografica=? ;");
			ps.setString(1, casaDiscograficaInput.getRagioneSociale());
			ps.setString(2, casaDiscograficaInput.getPartitaIva());
			ps.setLong(3, casaDiscograficaInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(CasaDiscografica casaDiscograficaInput) {
		if (casaDiscograficaInput == null || casaDiscograficaInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM casadiscografica WHERE idcasadiscografica=? ;");
			ps.setLong(1, casaDiscograficaInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

}
