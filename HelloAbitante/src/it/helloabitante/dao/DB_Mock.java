package it.helloabitante.dao;

import java.util.ArrayList;
import java.util.List;

import it.helloabitante.model.Abitante;

public class DB_Mock {
	public static final List<Abitante> LISTA_ABITANTI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_ABITANTI.add(new Abitante(1l, "mario", "rossi", "mrs111", 60, "ciao a tutti"));
		LISTA_ABITANTI.add(new Abitante(2l, "mario2", "rossi2", "mrs222", 40, "mi piace"));
		LISTA_ABITANTI.add(new Abitante(3l, "mario3", "rossi3", "mrs333", 23, "lascia stare"));
	}
}
