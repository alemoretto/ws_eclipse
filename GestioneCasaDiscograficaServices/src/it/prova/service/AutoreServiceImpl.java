package it.prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.AutoreDAO;
import it.prova.dao.Constants;
import it.prova.model.Autore;

public class AutoreServiceImpl implements AutoreService {

	private AutoreDAO autoreDao;

	public void setAutoreDAO(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;
	}

	@Override
	public List<Autore> listAllAutori() throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Autore findAutoreById(Long idInput) throws Exception {
		Autore result = null;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
//
//	@Override
//	public int inserisciNuovoAutore(Autore autoreInput) throws Exception {
//		return 0;
//	}
//	
//	@Override
//	public int aggiornaCasaDiscografica(Autore autoreInput) throws Exception {
//		return 0;
//	}
//	
//	@Override
//	public int rimuoviCasaDiscografica(Autore autoreInput) throws Exception {
//		return 0;
//	}
//	
//	@Override
//	public List<Autore> findByExample(Autore autoreInput) throws Exception {
//		return null;
//	}
	
	
	
}
