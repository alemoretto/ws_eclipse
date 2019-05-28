package it.prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.CasaDiscograficaDAO;
import it.prova.dao.Constants;
import it.prova.model.CasaDiscografica;

public class CasaDiscograficaServiceImpl implements CasaDiscograficaService {

	private CasaDiscograficaDAO casaDiscograficaDao;

	public void setCasaDiscograficaDAO(CasaDiscograficaDAO casaDiscograficaDao) {
		this.casaDiscograficaDao = casaDiscograficaDao;
	}

	@Override
	public List<CasaDiscografica> listAllCaseDiscografiche() throws Exception {
		List<CasaDiscografica> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public CasaDiscografica findCasaById(Long idInput) throws Exception {
		CasaDiscografica result = null;
		
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			casaDiscograficaDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = casaDiscograficaDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
