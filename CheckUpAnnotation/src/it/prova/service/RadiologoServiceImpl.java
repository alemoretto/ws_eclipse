package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class RadiologoServiceImpl implements RadiologoService{

	@Override
	public void faiLeLastre() {
		System.out.println("Ho fatto le lastre");
	}
}
