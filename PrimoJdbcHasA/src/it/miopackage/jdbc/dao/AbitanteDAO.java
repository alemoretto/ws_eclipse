package it.miopackage.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.miopackage.jdbc.connection.MyConnection;
import it.miopackage.jdbc.model.Abitante;
import it.miopackage.jdbc.model.Indirizzo;

public class AbitanteDAO {

	public List<Abitante> list() {

		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		List<Abitante> result = new ArrayList<Abitante>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from abitante a inner join indirizzo i on i.idindirizzo=a.indirizzo_id;");

			while (rs.next()) {
				Abitante abitanteTemp = new Abitante();
				abitanteTemp.setNome(rs.getString("NOME"));
				abitanteTemp.setCognome(rs.getString("COGNOME"));
				abitanteTemp.setId(rs.getLong("idabitante"));
				abitanteTemp.setEta(rs.getInt("eta"));

				Indirizzo indirizzoTemp = new Indirizzo();
				indirizzoTemp.setId(rs.getLong("idindirizzo"));
				indirizzoTemp.setCitta(rs.getString("citta"));
				indirizzoTemp.setCivico(rs.getString("civico"));
				indirizzoTemp.setVia(rs.getString("via"));

				abitanteTemp.setIndirizzo(indirizzoTemp);
				result.add(abitanteTemp);
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

	public Abitante selectJoinById(Long idAbitanteInput) {

		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Abitante result = null;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement(
					"SELECT * FROM abitante.abitante a left outer join abitante.indirizzo i on a.indirizzo_id=i.idindirizzo where a.idabitante=?; ");
			ps.setLong(1, idAbitanteInput);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Abitante();
				// leggo abitante dal resultset
				result.setId(rs.getLong("a.idabitante"));
				result.setNome(rs.getString("a.nome"));
				result.setCognome(rs.getString("a.cognome"));
				result.setEta(rs.getInt("a.eta"));
				// leggo indirizzo
				Indirizzo row = new Indirizzo();
				row.setId(rs.getLong("i.idindirizzo"));
				row.setCitta(rs.getString("i.citta"));
				row.setVia(rs.getString("i.via"));
				row.setCivico(rs.getString("i.civico"));
				// imposto l'indirizzo trovato dentro il mio abitante di
				// partenza
				result.setIndirizzo(row);
			} else {
				result = null;
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

	public int insert(Abitante abitante) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO abitante (nome, cognome,eta) VALUES (?, ?,?);");
			ps.setString(1, abitante.getNome());
			ps.setString(2, abitante.getCognome());
			ps.setInt(3, abitante.getEta());

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

	public int insertCompleto(Abitante abitante) {

		Connection c = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();

			// prima l'indirizzo
			ps = c.prepareStatement("INSERT INTO indirizzo (citta, via,civico) VALUES (?, ?,?);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, abitante.getIndirizzo().getCitta());
			ps.setString(2, abitante.getIndirizzo().getVia());
			ps.setString(3, abitante.getIndirizzo().getCivico());

			int indirizziInseriti = ps.executeUpdate();

			// mi metto da parte l'id inserito
			int last_inserted_id = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				last_inserted_id = rs.getInt(1);
			}

			// poi l'abitante
			if (indirizziInseriti > 0) {
				ps2 = c.prepareStatement("INSERT INTO abitante (nome, cognome,eta,indirizzo_id) VALUES (?, ?,?,?);");
				ps2.setString(1, abitante.getNome());
				ps2.setString(2, abitante.getCognome());
				ps2.setInt(3, abitante.getEta());
				ps2.setInt(4, last_inserted_id);
				result = ps2.executeUpdate();
			}

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
}
