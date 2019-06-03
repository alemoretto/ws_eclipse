package it.prova.dao;

import it.prova.model.Esame;
import it.prova.model.Studente;

public interface EsameDAO {

	public Esame get(int id);
	public void addStudentToEsame(Studente studenteInput, Esame esameInput);

}
