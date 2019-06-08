package it.prova.gestionecartelleesattorialispringjpa.dao.cartellaesattoriale;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.dao.IBaseDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale;

public interface CartellaEsattorialeDAO extends IBaseDAO<CartellaEsattoriale> {
	
	public CartellaEsattoriale getEager(Long id);
	List<CartellaEsattoriale> findAllByDescrizioneILike(String term);
	
}
