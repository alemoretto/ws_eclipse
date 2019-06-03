package it.prova.service;

import it.prova.model.MateriaPrima;

public interface MateriaPrimaService {

	MateriaPrima caricaMateriaPrima(int id);
	
	void avviaProcesso(MateriaPrima materiaPrima);
}
