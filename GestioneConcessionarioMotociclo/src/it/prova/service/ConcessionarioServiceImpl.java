package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.ConcessionarioDAO;
import it.prova.model.Concessionario;

@Component
public class ConcessionarioServiceImpl implements ConcessionarioService{

	@Autowired
	private ConcessionarioDAO concessionarioDAO;
	
	@Override
	public List<Concessionario> listAllConcessionari(){
		return concessionarioDAO.list();
	}
}
