package it.prova.annotation;

public class PersonaFisica extends Cliente {

	@Override
	void ordina() {
		System.out.println("Ordine da parte della Persona Fisica "+ getNome());
	}
	
}
