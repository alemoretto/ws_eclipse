package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class OrtopedicoServiceImpl implements OrtopedicoService{
	
	private RadiologoService radiologoService;
//	private String nome;
	
	@Override
	public void osservaLeLastre() {
		radiologoService.faiLeLastre();
		System.out.println("Ho osservato le lastre");
	}

	public RadiologoService getRadiologoService() {
		return radiologoService;
	}

	public void setRadiologoService(RadiologoService radiologoService) {
		this.radiologoService = radiologoService;
	}

//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

	
}
