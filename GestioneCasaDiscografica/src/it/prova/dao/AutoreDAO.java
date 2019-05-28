package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.CasaDiscografica;
import it.prova.model.Autore;

public class AutoreDAO {

	public List<Autore> list() {

		List<Autore> result = new ArrayList<Autore>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(
					"select * from autore a LEFT OUTER join casadiscografica c on a.casadiscografica_id=c.idcasadiscografica;");

			while (rs.next()) {
				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("a.nome"));
				autoreTemp.setCognome(rs.getString("a.cognome"));
				autoreTemp.setId(rs.getLong("a.idautore"));

				CasaDiscografica casaDiscograficaTemp = new CasaDiscografica();
				casaDiscograficaTemp.setRagioneSociale(rs.getString("c.ragione_sociale"));
				casaDiscograficaTemp.setPartitaIva(rs.getString("c.partita_iva"));
				
				autoreTemp.setCasaDiscografica(casaDiscograficaTemp);
				result.add(autoreTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Autore autoreInput) {

		if (autoreInput.getCasaDiscografica() == null)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO autore (nome, cognome, casadiscografica_id) VALUES (?, ?, ?);");
			ps.setString(1, autoreInput.getNome());
			ps.setString(2, autoreInput.getCognome());
			ps.setLong(3, autoreInput.getCasaDiscografica().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int insertCompleto(Autore autoreInput) {

		if (autoreInput == null || autoreInput.getCasaDiscografica() == null)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO casadiscografica (ragione_sociale, partita_iva) VALUES (?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, autoreInput.getCasaDiscografica().getRagioneSociale());
			ps.setString(2, autoreInput.getCasaDiscografica().getPartitaIva());
			
			int resInsertCasaDiscografica = ps.executeUpdate();

			int last_id_casadiscografica = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				last_id_casadiscografica = rs.getInt(1);
			}
					
			if(resInsertCasaDiscografica > 0) {
			PreparedStatement ps2 = c.prepareStatement("INSERT INTO autore (nome, cognome, casadiscografica_id) VALUES (?, ?, ?);");
			ps2.setString(1, autoreInput.getNome());
			ps2.setString(2, autoreInput.getCognome());
			ps2.setLong(3, last_id_casadiscografica);
			
			result = ps2.executeUpdate();
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}
	
	public int update(Autore autoreInput) {
		if (autoreInput == null || autoreInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE autore SET nome=?, cognome=?, casadiscografica_id=? WHERE idautore=? ;");
			ps.setString(1, autoreInput.getNome());
			ps.setString(2, autoreInput.getCognome());
			if (autoreInput.getCasaDiscografica() != null)
				ps.setLong(3,  autoreInput.getCasaDiscografica().getId());
			else
				ps.setNull(3,java.sql.Types.BIGINT);
			ps.setLong(4, autoreInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(Autore autoreInput) {
		if (autoreInput == null || autoreInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM autore WHERE idautore=? ;");
			ps.setLong(1, autoreInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

}
