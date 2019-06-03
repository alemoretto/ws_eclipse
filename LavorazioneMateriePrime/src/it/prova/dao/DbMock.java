package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriaPrima;

public class DbMock {

	public static final List<MateriaPrima> MATERIE_PRIME = new ArrayList<MateriaPrima>();

	static {
		
//		MateriaPrima mat1 = new MateriaPrima(1, "legno", StatoMateria.IN_INSERIMENTO);
//		MateriaPrima mat2 = new MateriaPrima(2, "blocco di cemento", StatoMateria.IN_LAVORAZIONE);
		
		MateriaPrima mat1 = new MateriaPrima(1, "legno");
//		MateriaPrima mat2 = new MateriaPrima(2, "blocco di cemento");
		MATERIE_PRIME.add(mat1);
//		MATERIE_PRIME.add(mat2);
//		Esame esame1 = new Esame(1, "Esame maturità liceo");
//		Studente studente1 = new Studente("Mario", "Rossi", esame1);
//		esame1.addToStudenti(studente1);
//		Studente studente2 = new Studente("Giuseppe", "Bianchi", esame1);
//		esame1.addToStudenti(studente2);
//		Studente studente3 = new Studente("Francesco", "Verdi", esame1);
//		esame1.addToStudenti(studente3);
//		ESAMI.add(esame1);

	}

}
