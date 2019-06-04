package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class EmatologoServiceImpl implements EmatologoService {

	@Override
	public void analizzaAnalisiDelSangue() {
		System.out.println("Ho controllato l'emocromo");
	}

}
