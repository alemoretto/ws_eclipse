package it.municipioabitantejpa.dao.municipio;

import it.municipioabitantejpa.dao.IBaseDAO;
import it.municipioabitantejpa.model.Municipio;

public interface MunicipioDAO extends IBaseDAO<Municipio> {
	public Municipio findEagerFetch(long idMunicipio);
	public Long countByAbitantiMinorenni();
}
