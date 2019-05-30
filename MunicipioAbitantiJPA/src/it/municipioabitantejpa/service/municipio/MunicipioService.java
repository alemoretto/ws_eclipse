package it.municipioabitantejpa.service.municipio;

import java.util.List;

import it.municipioabitantejpa.dao.municipio.MunicipioDAO;
import it.municipioabitantejpa.model.Municipio;

public interface MunicipioService {
	
	public List<Municipio> listAllMunicipi() throws Exception;

	public Municipio caricaSingoloMunicipio(Long id) throws Exception;

	public void aggiorna(Municipio municipioInstance) throws Exception;

	public void inserisciNuovo(Municipio municipioInstance) throws Exception;

	public void rimuovi(Municipio municipioInstance) throws Exception;

	public List<Municipio> findByExample(Municipio example) throws Exception;

	public List<Municipio> findAllByDescrizioneIniziaCon(String inizialeDescrizione) throws Exception;
	
	public List<Municipio> findAllByAbitantiMinorenni() throws Exception;

	//per injection
	public void setMunicipioDAO(MunicipioDAO municipioDAO);
}
