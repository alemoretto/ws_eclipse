package it.prova.gestionecartelleesattorialispringjpa.dao.contribuente;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.dao.IBaseDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public interface ContribuenteDAO extends IBaseDAO<Contribuente> {

	public List<Contribuente> findAllByDescrizioneILike(String term);
}
