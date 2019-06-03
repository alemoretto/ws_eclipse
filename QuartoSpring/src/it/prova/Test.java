package it.prova;

import it.prova.spring.MyServiceFactory;

public class Test {

	public static void main(String[] args) {
//		MyServiceFactory.getImpresaRistrutturazioneService()
//				.ristrutturaAppartamento();

		MyServiceFactory.getImpresaRistrutturazioneService().getMuratoreService().costruisciPareti();
		
		MyServiceFactory.getElettricistaService().disponiCavi();
	}

}
