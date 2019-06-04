package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class MedicoGenericoServiceImpl implements MedicoGenericoService {

	@Override
	public void daiIlResponso() {
		System.out.println("La situazione clinica è buona");
	}
}
