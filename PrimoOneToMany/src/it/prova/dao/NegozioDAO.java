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

public class NegozioDAO {

	public List<Negozio> list() {

		List<Negozio> result = new ArrayList<Negozio>();
		Negozio negozioTemp = null;

		try (Connection c = MyConnection.getConnection()) {

			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from negozio ;");

			while (rs.next()) {
				negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("idnegozio"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));

				result.add(negozioTemp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public Negozio selectById(Long idNegozioInput) {

		if (idNegozioInput == null || idNegozioInput < 1)
			return null;

		Negozio result = null;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("select * from negozio i where i.idnegozio=?;");
			ps.setLong(1, idNegozioInput);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = new Negozio();
				result.setId(rs.getLong("idnegozio"));
				result.setNome(rs.getString("nome"));
				result.setIndirizzo(rs.getString("indirizzo"));
			} else {
				result = null;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	public int insert(Negozio negozioInput) {

		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("INSERT INTO negozio (nome, indirizzo) VALUES (?, ?);");
			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// TODO
	public int update(Negozio negozioInput) {

		if (negozioInput == null || negozioInput.getId() < 1) {
			return 0;
		}
		
		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("UPDATE negozio SET nome=?, indirizzo=? WHERE idnegozio=? ;");
			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());
			ps.setLong(3, negozioInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	public int delete(Negozio negozioInput) {
		
		if (negozioInput == null || negozioInput.getId() < 1) {
			return 0;
		}
		
		int result = 0;

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("DELETE FROM negozio WHERE idnegozio=? ;");
			ps.setLong(1, negozioInput.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;
	}

	// prende negozioInput e grazie al suo id va sulla tabella articoli e poi
	// ad ogni iterazione sul resultset aggiunge agli articoli di negozioInput
	public void populateArticoli(Negozio negozioInput) {
		if (negozioInput == null || negozioInput.getId() < 1)
			return;
		
		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("SELECT * FROM articolo a INNER JOIN negozio n ON a.negozio_id=n.idnegozio WHERE n.idnegozio= ?;");
			ps.setLong(1, negozioInput.getId());

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Articolo temp = new Articolo();
				temp.setId(rs.getLong("a.idarticolo"));
				temp.setNome(rs.getString("a.nome"));
				temp.setMatricola(rs.getString("a.matricola"));
				temp.setNegozio(negozioInput);
				negozioInput.getArticoli().add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	// implementare inoltre
	public List<Negozio> findAllByIniziali(String inizialeInput) {
		if (inizialeInput == null)
			return null;

		Negozio temp = null;
		List<Negozio> result = new ArrayList<Negozio>();

		try (Connection c = MyConnection.getConnection()) {

			PreparedStatement ps = c.prepareStatement("SELECT * FROM negozio n WHERE n.nome LIKE ?;");
			ps.setString(1, inizialeInput + "%");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Negozio();
				temp.setId(rs.getLong("idnegozio"));
				temp.setNome(rs.getString("nome"));
				temp.setIndirizzo(rs.getString("indirizzo"));
				
				result.add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

}
