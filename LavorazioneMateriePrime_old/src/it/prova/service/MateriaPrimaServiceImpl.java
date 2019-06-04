package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;

/**
 * @author erchina
 *
 */
@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
	@Override
	public void avviaProcesso(MateriaPrima materiaPrima) {
		System.out.println("Inizio processo per " + materiaPrima + " \n");
		
		
		System.out.println("\nTermine processo  ****************************");

	}

	@Override
	public MateriaPrima caricaMateriaPrima(int id) {
		return materiaPrimaDAO.get(id);
	}

}
