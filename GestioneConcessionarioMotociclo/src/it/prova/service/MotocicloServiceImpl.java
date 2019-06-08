package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.MotocicloDAO;
import it.prova.model.Motociclo;

@Component
public class MotocicloServiceImpl implements MotocicloService {

	@Autowired
	private MotocicloDAO motocicloDAO;

	@Transactional(readOnly = true)
	public List<Motociclo> listAllMotocicli() {
		return motocicloDAO.list();
	}
	
	@Transactional(readOnly = true)
	public List<Motociclo> listAllMotocicliEager() {
		return motocicloDAO.listEager();
	}
	
	@Transactional(readOnly = true)
	public Motociclo caricaSingoloMotociclo(Long id) {
		return motocicloDAO.get(id);
	}
	
	@Transactional(readOnly = true)
	public Motociclo caricaSingoloMotocicloEager(Long id) {
		return motocicloDAO.getEager(id);
	}
	
//	@Transactional(readOnly = true)
//	public Motociclo caricaSingoloMotocicloEager(Motociclo moto) {
//		return motocicloDAO.getE(moto);
//	}
	
	@Transactional
	public void aggiorna(Motociclo motocicloInstance){
		motocicloDAO.update(motocicloInstance);
	}
	
	@Transactional
	public void inserisciNuovo(Motociclo motocicloInstance) {
		motocicloDAO.insert(motocicloInstance);
	}
	
	@Transactional
	public void rimuovi(Motociclo motocicloInstance) {
		motocicloDAO.delete(motocicloInstance);
	}
	
	@Transactional//(readOnly = true) ??? PERCHE' readonly??
	public void refresh(Motociclo motocicloInstance) {
		motocicloDAO.refresh(motocicloInstance);
	}
	
	@Transactional(readOnly = true)
	public List<Motociclo> findByExample(Motociclo motocicloInstance) {
		return motocicloDAO.findByExample(motocicloInstance);
	}
	
	@Transactional(readOnly = true)
	public Long numeroMotoTorinoPrecedenti2010() {
		return motocicloDAO.numeroMotoTorinoPrecedenti2010();
	}
}
