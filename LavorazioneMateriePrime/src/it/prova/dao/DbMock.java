package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

public class DbMock {

	public static final List<MateriaPrima> MATERIE_PRIME = new ArrayList<MateriaPrima>();

	static {
		MateriaPrima mat_1 = new MateriaPrima(1, "legno");
		MateriaPrima mat_2 = new MateriaPrima(2, "alluminio",StatoLavorazione.IN_VERNICIATURA);
		MateriaPrima mat_3 = new MateriaPrima(3, "calcestruzzo",StatoLavorazione.IN_LAVORAZIONE);
		MATERIE_PRIME.add(mat_1);
		MATERIE_PRIME.add(mat_2);
		MATERIE_PRIME.add(mat_3);

	}

}
