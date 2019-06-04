package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.ConcessionarioDAO;
import it.prova.model.Concessionario;

@Component
public class ConcessionarioServiceImpl implements ConcessionarioService {

	@Autowired
	private ConcessionarioDAO concessionarioDAO;

	@Transactional(readOnly = true)
	public List<Concessionario> listAllConcessionari() {
		return concessionarioDAO.list();
	}

	@Transactional(readOnly = true)
	public Concessionario caricaSingoloConcessionarioLazy(Long id) {
		return concessionarioDAO.get(id);
	}
	
	public void aggiorna(Concessionario concessionarioInstance){
		concessionarioDAO.update(concessionarioInstance);
	}
	
	@Transactional
	public void inserisciNuovo(Concessionario concessionarioInstance) {
		concessionarioDAO.insert(concessionarioInstance);
	}
	
	@Transactional
	public void rimuovi(Concessionario concessionarioInstance) {
		concessionarioDAO.delete(concessionarioInstance);
	}
	
	
	@Transactional //(readOnly = true) ???
	public void refresh(Concessionario concessionarioInstance) {
		concessionarioDAO.refresh(concessionarioInstance);
	}
	
	@Transactional(readOnly = true)
	public List<Concessionario> findByExample(Concessionario concessionarioInstance) {
		return concessionarioDAO.findByExample(concessionarioInstance);
	}
	
	
	public List<Concessionario> findAllConcessionariConMotociclo1200(){
		return concessionarioDAO.findAllConcessionariConMotociclo1200();
	}
	
	public List<Concessionario> findAllConcessionariMilanoConHondaBetween2012And2016(){
		return concessionarioDAO.findAllConcessionariMilanoConHondaBetween2012And2016();
	}
}
