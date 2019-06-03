package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {
	
	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
	
	
	public void avviaProcesso(MateriaPrima materiaPrima) {
		
		
	}
	
	public MateriaPrima caricaMateriaPrima(int id) {
		return materiaPrimaDAO.get(id);
	}

}
