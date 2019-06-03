package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.Esame;
import it.prova.model.Studente;

@Component
public class EsameDAOImplMock implements EsameDAO {

	@Override
	public Esame get(int id) {
		for (Esame esameItem : DbMock.ESAMI) {
			if(esameItem.getId() == id)
				return esameItem;
		}
		return null;
	}

	
	@Override
	public void addStudentToEsame(Studente studenteInput, Esame esameInput) {
		studenteInput.setEsame(esameInput);
		for (Esame esameItem : DbMock.ESAMI) {
			if(esameItem.getId() == esameInput.getId())
				esameItem.addToStudenti(studenteInput);
		}
		
	}

}
