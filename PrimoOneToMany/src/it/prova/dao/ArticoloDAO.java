package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Articolo;
import it.prova.model.Negozio;

public class ArticoloDAO {

	public List<Articolo> list() {

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection()) {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from articolo a inner join negozio i on i.idnegozio=a.negozio_id;");

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp.setNome(rs.getString("NOME"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				articoloTemp.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));

				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insertCompleto(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO negozio (nome, indirizzo) VALUES (?, ?);");
			ps.setString(1, articoloInput.getNegozio().getNome());
			ps.setString(2, articoloInput.getNegozio().getIndirizzo());
			
			int resInsertNegozio = ps.executeUpdate();

			int last_id_negozio = -1;
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				last_id_negozio = rs.getInt(1);
			}
					
			if(resInsertNegozio > 0) {
			PreparedStatement ps2 = c.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?);");
			ps2.setString(1, articoloInput.getNome());
			ps2.setString(2, articoloInput.getMatricola());
			ps2.setLong(3, last_id_negozio);
			
			result = ps2.executeUpdate();
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int insert(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			return -1;

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?);");
			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// TODO

	public Articolo selectByIdWithJoin(Long idInput) {
		Articolo result = null;

		try (Connection c = MyConnection.getConnection()) {
			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM articolo a INNER JOIN negozio n ON n.idnegozio=a.negozio_id WHERE a.idarticolo = ?;");
			ps.setLong(1, idInput);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new Articolo();
				result.setNome(rs.getString("NOME"));
				result.setMatricola(rs.getString("matricola"));
				result.setId(rs.getLong("idarticolo"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));

				result.setNegozio(negozioTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int update(Articolo articoloInput) {
		if (articoloInput == null || articoloInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE articolo SET nome=?, matricola=?, negozio_id=? WHERE idarticolo=? ;");
			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			ps.setLong(4, articoloInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(Articolo articoloInput) {
		if (articoloInput == null || articoloInput.getId() < 1) {
			return 0;
		}

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM articolo WHERE idarticolo=? ;");
			ps.setLong(1, articoloInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// implementare inoltre
	public List<Articolo> findAllByNegozio(Negozio negozioInput) {

		if (negozioInput == null)
			return null;

		Articolo temp = null;
		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM articolo a INNER JOIN negozio n ON a.negozio_id=n.idnegozio WHERE a.negozio_id=?;");
			ps.setLong(1, negozioInput.getId());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Articolo();
				temp.setId(rs.getLong("idnegozio"));
				temp.setNome(rs.getString("nome"));
				temp.setMatricola(rs.getString("matricola"));
				temp.setNegozio(negozioInput);
				
				result.add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public List<Articolo> findAllByMatricola(String matricolaInput) {
		if (matricolaInput == null)
			return null;

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM articolo a INNER JOIN negozio n ON a.negozio_id=n.idnegozio WHERE a.matricola=?;");
			ps.setString(1, matricolaInput);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp = new Articolo();
				articoloTemp.setId(rs.getLong("idarticolo"));
				articoloTemp.setNome(rs.getString("nome"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				
				Negozio negozioTemp = new Negozio();
				negozioTemp.setNome(rs.getString("n.nome"));
				negozioTemp.setIndirizzo(rs.getString("n.indirizzo"));
				negozioTemp.setId(rs.getLong("n.idnegozio"));
				
				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
		if (indirizzoNegozioInput == null)
			return null;

		List<Articolo> result = new ArrayList<Articolo>();

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM articolo a INNER JOIN negozio n ON a.negozio_id=n.idnegozio WHERE n.indirizzo=?;");
			ps.setString(1, indirizzoNegozioInput);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp = new Articolo();
				articoloTemp.setId(rs.getLong("a.idarticolo"));
				articoloTemp.setNome(rs.getString("a.nome"));
				articoloTemp.setMatricola(rs.getString("a.matricola"));
				
				Negozio negozioTemp = new Negozio();
				negozioTemp.setNome(rs.getString("n.nome"));
				negozioTemp.setIndirizzo(rs.getString("n.indirizzo"));
				negozioTemp.setId(rs.getLong("n.idnegozio"));
				
				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

}
