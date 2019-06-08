package it.prova.dao;

import java.util.List;

import it.prova.model.Motociclo;

public interface MotocicloDAO extends IBaseDAO<Motociclo> {

	public List<Motociclo> listEager();
	public Motociclo getEager(Long id); 
	public Long numeroMotoTorinoPrecedenti2010();
}
