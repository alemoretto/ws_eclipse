package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
//	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) ;
	public List<Abitante> listaTuttiGliAbitanti() throws Exception ;
	public int inserisciAbitante(Abitante nuovoAbitante) throws Exception ;
	public List<Abitante> findByExample(Abitante input) throws Exception;
	public Abitante findAbitanteById(Long id) throws Exception;
}
