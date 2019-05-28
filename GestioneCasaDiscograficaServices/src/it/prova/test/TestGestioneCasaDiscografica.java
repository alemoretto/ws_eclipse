package it.prova.test;

import java.util.Date;

import it.prova.model.CasaDiscografica;
import it.prova.service.MyServiceFactory;
import it.prova.service.CasaDiscograficaService;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
//		CasaDiscografica newCasaInstance = new CasaDiscografica("mauro", "rossi");
//		newCasaInstance.setDateCreated(new Date());

		//parlo direttamente con il service
		CasaDiscograficaService casaService = MyServiceFactory.getCasaDiscograficaServiceImpl();

		try {

			//*************************************************************************************
			//    TEST  CASA DISCOGRAFICA

			// ora con il service posso fare tutte le invocazioni che mi servono
			
//			System.out.println("#########  LISTA TUTTE LE CASE DISCOGRAFICHE  ##########");
//			System.out.println("In tabella ci sono " + casaService.listAllCaseDiscografiche().size() + " elementi.");
//			for (CasaDiscografica casa : casaService.listAllCaseDiscografiche()) {
//				System.out.println(casa);
//			}
			
//			System.out.println("#########  FIND BY ID CASA ##########");
//			System.out.println(casaService.findCasaById(3L));
			
//			System.out.println("#########  INSERT CASA ##########");
//			CasaDiscografica nuova_casa = new CasaDiscografica("pentagramma","48247");
//			System.out.println(casaService.inserisciNuovaCasaDiscografica(nuova_casa));
//			for (CasaDiscografica casa : casaService.listAllCaseDiscografiche()) {
//				System.out.println(casa);
//			}
			
//			System.out.println("#########  UPDATE CASA ##########");
//			CasaDiscografica casa_da_aggiornare = casaService.findCasaById(7L);
//			casa_da_aggiornare.setRagioneSociale("nuova ragione");
//			casaService.aggiornaCasaDiscografica(casa_da_aggiornare);
//			for (CasaDiscografica casa : casaService.listAllCaseDiscografiche()) {
//				System.out.println(casa);
//			}
			
//			System.out.println("#########  DELETE CASA ##########");
//			CasaDiscografica casa_da_cancellare = casaService.findCasaById(5L);
//			System.out.println(casaService.rimuoviCasaDiscografica(casa_da_cancellare));
//			for (CasaDiscografica casa : casaService.listAllCaseDiscografiche()) {
//				System.out.println(casa);
//			}

//			System.out.println("#########  FIND BY EXAMPLE ##########");
//			CasaDiscografica casa_example = new CasaDiscografica("Virgin",null);
//			for (CasaDiscografica casa : casaService.findByExample(casa_example)) {
//				System.out.println(casa);
//			}

			//*************************************************************************************
			//    TEST  AUTORE

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
