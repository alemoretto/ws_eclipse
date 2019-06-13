package it.prova.ebay.service.acquisto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebay.dao.acquisto.AcquistoDAO;
import it.prova.ebay.model.Acquisto;

@Component
public class AcquistoServiceImpl implements AcquistoService {

	@Autowired
	private AcquistoDAO acquistoDAO;

	@Transactional(readOnly = true)
	public List<Acquisto> listAll() {
		return acquistoDAO.list();
	}

	@Transactional(readOnly = true)
	public Acquisto carica(Long id) {
		return acquistoDAO.get(id);
	}

	@Transactional
	public void aggiorna(Acquisto o) {
		acquistoDAO.update(o);
	}

	@Transactional
	public void inserisci(Acquisto o) {
		acquistoDAO.insert(o);
	}

	@Transactional
	public void rimuovi(Acquisto o) {
		acquistoDAO.delete(o);
	}

	@Transactional(readOnly = true)
	public List<Acquisto> findByExample(Acquisto example) {
		return acquistoDAO.findByExample(example);
	}

}
