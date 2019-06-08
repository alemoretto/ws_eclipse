package it.prova.gestionecartelleesattorialispringjpa.dao.contribuente;

import java.util.List;

import it.prova.gestionecartelleesattorialispringjpa.dao.IBaseDAO;
import it.prova.gestionecartelleesattorialispringjpa.model.Contribuente;

public interface ContribuenteDAO extends IBaseDAO<Contribuente> {

	public Contribuente getEager(Long id);

	public List<Contribuente> findAllByDescrizioneILike(String term);
}
