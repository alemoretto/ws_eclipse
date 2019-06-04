package it.municipioabitantejpa.dao.abitante;

import it.municipioabitantejpa.dao.IBaseDAO;
import it.municipioabitantejpa.model.Abitante;
import it.municipioabitantejpa.model.Municipio;

import java.util.List;

public interface AbitanteDAO extends IBaseDAO<Abitante> {

	public List<Abitante> findAllByMunicipio(Municipio input);
	public List<Abitante> findAllByUbicazioneMunicipioContiene(String ubicazioneToken);
	
}
