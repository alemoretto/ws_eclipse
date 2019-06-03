package it.prova.annotation;

public class PersonaGiuridica extends Cliente {

	@Override
	void ordina() {
		System.out.println("Ordine da parte della Persona Giuridica "+ getNome());
	}

}
