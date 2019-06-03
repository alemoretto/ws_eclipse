package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.Esame;
import it.prova.model.Studente;

@Component
public class StudenteDAOImplMock implements StudenteDAO {

	@Override
	public void insert(Studente input) {
		for (Esame esameItem : DbMock.ESAMI) {
			if(esameItem.getId() == input.getEsame().getId())
				esameItem.addToStudenti(input);
		}
	}

}
