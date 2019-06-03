package it.prova.annotation;

import org.springframework.stereotype.Component;

@Component
public class PersonaFisica extends Cliente {

	@Override
	void ordina() {
		System.out.println("Ordine da parte della Persona Fisica "+ getNome());
	}
	
}
