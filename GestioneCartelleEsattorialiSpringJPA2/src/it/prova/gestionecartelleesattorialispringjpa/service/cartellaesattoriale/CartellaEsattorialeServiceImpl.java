package it.prova.gestionecartelleesattorialispringjpa.service.cartellaesattoriale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionecartelleesattorialispringjpa.dao.cartellaesattoriale.CartellaEsattorialeDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;;

@Component
public class CartellaEsattorialeServiceImpl implements CartellaEsattorialeService {

	@Autowired
	private CartellaEsattorialeDAO cartellaEsattorialeDAO;

	@Transactional(readOnly = true)
	public List<CartellaEsattoriale> listAll() {

		return cartellaEsattorialeDAO.list();
	}

	@Transactional(readOnly = true)
	public CartellaEsattoriale carica(Long id) {
		return cartellaEsattorialeDAO.get(id);
	}

	@Transactional(readOnly = true)
	public CartellaEsattoriale caricaEager(Long id) {
		return cartellaEsattorialeDAO.getEager(id);
	}

	@Transactional
	public void aggiorna(CartellaEsattoriale abitanteInstance) {
		cartellaEsattorialeDAO.update(abitanteInstance);
	}

	@Transactional
	public void inserisci(CartellaEsattoriale abitanteInstance) {
		cartellaEsattorialeDAO.insert(abitanteInstance);
	}

	@Transactional
	public void rimuovi(CartellaEsattoriale abitanteInstance) {
		cartellaEsattorialeDAO.delete(abitanteInstance);
	}

	@Transactional(readOnly = true)
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example) {
		return cartellaEsattorialeDAO.findByExample(example);
	}

}
