package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.*;

public class CdDAO {

	public List<Cd> list() {

		List<Cd> result = new ArrayList<Cd>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from cd c inner join autore a on c.autore_id=a.idautore;");

			while (rs.next()) {
				Cd cdTemp = new Cd();
				cdTemp.setTitolo(rs.getString("c.titolo"));
				cdTemp.setGenere(rs.getString("c.genere"));
				cdTemp.setNumeroTracce(rs.getInt("c.numero_tracce"));

				Autore autoreTemp = new Autore();
				autoreTemp.setNome(rs.getString("a.nome"));
				autoreTemp.setCognome(rs.getString("a.cognome"));
				
				// bisogna mettere anche la casa discografica?
				
				cdTemp.setAutore(autoreTemp);
				result.add(cdTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Cd cDInput) {

		if (cDInput.getAutore() == null || cDInput.getAutore().getId() < 1)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO cd (titolo, genere, numero_tracce, autore_id) VALUES (?, ?, ?, ?);");
			ps.setString(1, cDInput.getTitolo());
			ps.setString(2, cDInput.getGenere());
			ps.setInt(3, cDInput.getNumeroTracce());
			ps.setLong(4, cDInput.getAutore().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int update(Cd cDInput) {
		if (cDInput == null || cDInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE cd SET titolo=?, genere=?, numero_tracce=?, autore_id=? WHERE idcd=? ;");
			ps.setString(1, cDInput.getTitolo());
			ps.setString(2, cDInput.getGenere());
			ps.setInt(3, cDInput.getNumeroTracce());
			ps.setLong(4, cDInput.getAutore().getId());
			ps.setLong(5, cDInput.getId());
			
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(Cd cDInput) {
		if (cDInput == null || cDInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM cd WHERE idcd=? ;");
			ps.setLong(1, cDInput.getId());
			
			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

}
