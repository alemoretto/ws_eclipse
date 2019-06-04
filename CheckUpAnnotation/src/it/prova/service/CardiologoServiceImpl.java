package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class CardiologoServiceImpl implements CardiologoService{

	@Override
	public void controllaElettrocardiogramma() {
		System.out.println("Ho analizzato l'elettrocardiogramma");
	}
}
