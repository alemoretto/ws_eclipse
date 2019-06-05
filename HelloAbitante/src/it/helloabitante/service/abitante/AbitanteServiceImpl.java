package it.helloabitante.service.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.MyConnection;
import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {
	
	private AbitanteDAO abitanteDAO;
	
	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> listaTuttiGliAbitanti() throws Exception  {
		
		List<Abitante> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}

	public int inserisciAbitante(Abitante nuovoAbitante) throws Exception {
		int result = 0;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.insert(nuovoAbitante);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
	
	@Override
	public List<Abitante> findByExample(Abitante input) throws Exception {
		List<Abitante> result = new ArrayList<>();
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
	
	public Abitante findAbitanteById(Long id) throws Exception{
		Abitante result = null;
		try(Connection connection = MyConnection.getConnection()) {

			// inietto la connection nel dao
			abitanteDAO.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = abitanteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return result;
	}
}
