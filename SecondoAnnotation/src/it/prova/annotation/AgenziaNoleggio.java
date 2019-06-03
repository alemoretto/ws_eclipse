package it.prova.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AgenziaNoleggio {
	@Autowired
	@Qualifier("PersonaGiuridica")
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	
	
	
}
