package it.municipioabitantejpa.service.municipio;

import it.municipioabitantejpa.model.Municipio;

import java.util.List;

public interface MunicipioService {

	public List<Municipio> listAllMunicipi();

	public Municipio caricaSingoloMunicipio(Long id);

	public Municipio caricaSingoloMunicipioEagerAbitanti(Long idMunicipio);

	public void aggiorna(Municipio municipioInstance);

	public void inserisciNuovo(Municipio municipioInstance);

	public void rimuovi(Municipio municipioInstance);

	public List<Municipio> findByExample(Municipio example);

	public void refresh(Municipio municipioInstance);

	public void removeConEccezione(Municipio municipioInstance);
	
	public Long countByAbitantiMinorenni();
}
