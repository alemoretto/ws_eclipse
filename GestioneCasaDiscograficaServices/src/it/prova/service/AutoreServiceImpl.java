package it.prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.AutoreDAO;
import it.prova.dao.CdDAO;
import it.prova.dao.Constants;
import it.prova.model.Autore;
import it.prova.model.CasaDiscografica;
import it.prova.model.Cd;

public class AutoreServiceImpl implements AutoreService {

	private AutoreDAO autoreDao;
	private CdDAO cdDao;

	public void setAutoreDAO(AutoreDAO autoreDao) {
		this.autoreDao = autoreDao;
	}

	public void setCdDAO(CdDAO cdDao) {
		this.cdDao = cdDao;
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

	@Override
	public int inserisciNuovoAutore(Autore autoreInput) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.insert(autoreInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiornaAutore(Autore autoreInput) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.update(autoreInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public int rimuoviAutore(Autore autoreInput) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.delete(autoreInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public void populateAutore(Autore autoreInput) throws Exception {
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nei dao
			autoreDao.setConnection(connection);
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			autoreInput.setListaCD(cdDao.findByAutore(autoreInput));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public int rimuoviAutoreBulk(Autore autoreInput) throws Exception {
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);
			cdDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			autoreInput.setListaCD(cdDao.findByAutore(autoreInput));
			for (Cd cd : autoreInput.getListaCD()) {
				cdDao.delete(cd);
			}
			autoreDao.delete(autoreInput);

			result = autoreDao.delete(autoreInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	@Override
	public List<Autore> findByExample(Autore autoreInput) throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findByExample(autoreInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	public List<Autore> findAllByCasaDiscografica(CasaDiscografica casaInput) throws Exception {
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findAllByCasaDiscografica(casaInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	public List <Autore> findByCdWhereNTracceGreaterThan(int nTracceInput) throws Exception{
		List<Autore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			autoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = autoreDao.findByCdWhereNTracceGreaterThan(nTracceInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
