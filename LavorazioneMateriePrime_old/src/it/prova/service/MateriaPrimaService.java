package it.prova.service;

import it.prova.model.MateriaPrima;

public interface MateriaPrimaService {

	public MateriaPrima caricaMateriaPrima(int id);

	public void avviaProcesso(MateriaPrima materiaPrima);

}
