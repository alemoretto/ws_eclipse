package it.prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.model.Motocicletta;

public class MotociclettaDao {

	public List<Motocicletta> list() {

		// =============================================== SELECT
		Connection c = null;
		ResultSet rs = null;
		Statement s = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {

			c = MyConnection.getConnection();
			s = c.createStatement();

			rs = s.executeQuery("select * from motocicletta;");

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setId(rs.getLong("id"));
				temp.setMarca(rs.getString("marca"));
				temp.setModello(rs.getString("modello"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				result.add(temp);

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

	// =============================================== INSERT
	public int insert(Motocicletta input) {

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("INSERT INTO motocicletta (marca, modello, cilindrata) VALUES (?, ?, ?);");
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());

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

	// =============================================== UPDATE BY ID
	public int update(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("UPDATE motocicletta SET marca=?, modello=?, cilindrata=? where id=?;");
			ps.setString(1, input.getMarca());
			ps.setString(2, input.getModello());
			ps.setInt(3, input.getCilindrata());
			ps.setLong(4, input.getId());

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

	// =============================================== DELETE BY ID
	public int delete(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection c = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			c = MyConnection.getConnection();
			ps = c.prepareStatement("DELETE from persona where id=?;");
			ps.setLong(1, input.getId());

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

	public List<Motocicletta> findAllByCilindrataMaggioreDi(String cilindrataMinima) {

		if (cilindrataMinima == null) {
			return null;
		}
			
		// =============================================== SELECT
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {

			c = MyConnection.getConnection();

			ps = c.prepareStatement("select * from motocicletta where cilindrata > ?;");
			ps.setString(1, cilindrataMinima);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				temp = new Motocicletta();
				temp.setId(rs.getLong("id"));
				temp.setMarca(rs.getString("marca"));
				temp.setModello(rs.getString("modello"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				result.add(temp);

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

	public List<Motocicletta> findByMarcaCheContiene(String marca) {

		if (marca == null) {
			return null;
		}
			
		// =============================================== SELECT
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<Motocicletta>();

		try {

			c = MyConnection.getConnection();

			ps = c.prepareStatement("select * from motocicletta where marca LIKE ?;");
			ps.setString(1, "%" + marca + "%");

			rs = ps.executeQuery();
			
			while (rs.next()) {
				temp = new Motocicletta();
				temp.setId(rs.getLong("id"));
				temp.setMarca(rs.getString("marca"));
				temp.setModello(rs.getString("modello"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				result.add(temp);

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
}
