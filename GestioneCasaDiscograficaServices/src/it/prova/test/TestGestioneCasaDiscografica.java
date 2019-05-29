package it.prova.test;

import it.prova.model.*;
import it.prova.service.*;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
//		CasaDiscografica newCasaInstance = new CasaDiscografica("mauro", "rossi");
//		newCasaInstance.setDateCreated(new Date());

		// parlo direttamente con il service
		CasaDiscograficaService casaService = MyServiceFactory.getCasaDiscograficaServiceImpl();
		AutoreService autoreService = MyServiceFactory.getAutoreServiceImpl();
		CdService cdService = MyServiceFactory.getCdServiceImpl();
		
		try {

			// *************************************************************************************
			// TEST CASA DISCOGRAFICA

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

			
//			System.out.println("#########  FIND BY COGNOME AUTORE ##########");
//			for (CasaDiscografica casa : casaService.findAllByAutoreWhereCognomeIniziaCon("s")) {
//				System.out.println(casa);
//			}
//			
//			System.out.println("#########  FIND BY GENERE CD ##########");
//			for (CasaDiscografica casa : casaService.findAllByCdWhereGenereEqual("rock")) {
//				System.out.println(casa);
//			}
			
			// *************************************************************************************
			// TEST AUTORE
			
//			System.out.println("#########  LISTA TUTTI GLI AUTORI  ##########");
//			System.out.println("In tabella ci sono " + autoreService.listAllAutori().size() + " elementi.");
//			for (Autore autore : autoreService.listAllAutori()) {
//				System.out.println(autore);
//			}

//			System.out.println("#########  FIND BY ID AUTORE ##########");
//			System.out.println(autoreService.findAutoreById(3L));

//			System.out.println("#########  INSERT AUTORE ##########");
//			CasaDiscografica casa_ref = new CasaDiscografica("pentagramma",null);
//			Autore nuovo_autore = new Autore("Stefano","Rosso",casaService.findByExample(casa_ref).get(0));
//			System.out.println(autoreService.inserisciNuovoAutore(nuovo_autore));
//			for (Autore autore : autoreService.listAllAutori()) {
//				System.out.println(autore);
//			}

//			System.out.println("#########  UPDATE AUTORE ##########");
//			Autore autore_da_aggiornare = autoreService.findAutoreById(4L);
//			autore_da_aggiornare.setCognome("rossini");
//			System.out.println(autoreService.aggiornaAutore(autore_da_aggiornare));
//			for (Autore autore : autoreService.listAllAutori()) {
//				System.out.println(autore);
//			}

//			System.out.println("#########  DELETE AUTORE ##########");
//			Autore autore_da_cancellare = autoreService.findAutoreById(2L);
//			System.out.println(autoreService.rimuoviAutore(autore_da_cancellare));
//			for (Autore autore : autoreService.listAllAutori()) {
//				System.out.println(autore);
//			}
//			
//			System.out.println("#########  FIND BY EXAMPLE ##########");  // la select va fatta con i join???
//			Autore autore_example = new Autore(null,"Ferri",null);
//			for (Autore autore : autoreService.findByExample(autore_example)) {
//				System.out.println(autore);
//			}

//			System.out.println("#########  POPULATE CD ##########");  // la select va fatta con i join???
//			Autore autore_example = new Autore("Pink","Floyd",null);
//			Autore autore_da_popolare = autoreService.findByExample(autore_example).get(0);
//			System.out.println(autoreService.findByExample(autore_da_popolare));
//			autoreService.populateAutore(autore_da_popolare);
//			for (Cd cd : autore_da_popolare.getListaCD()) {
//				System.out.println(cd);
//			}
			
//			System.out.println("#########  DELETE BULK AUTORE ##########");  // la select va fatta con i join???
//			Autore autore_da_cancellare = new Autore("ac","dc",null);
//			autore_da_cancellare = autoreService.findByExample(autore_da_cancellare).get(0);
//			autoreService.rimuoviAutoreBulk(autore_da_cancellare);
			
//			System.out.println("#########  FIND ALL AUTORI BY CASA  ##########");
//			CasaDiscografica casaCriterio = casaService.findCasaById(4L);
//			for (Autore autore : autoreService.findAllByCasaDiscografica(casaCriterio)) {
//				System.out.println(autore);
//			}
//			
//			System.out.println("#########  FIND ALL AUTORI BY CD WHERE N TRACCE GREATER THAN  ##########");
//			for (Autore autore : autoreService.findByCdWhereNTracceGreaterThan(8)) {
//				System.out.println(autore);
//			}
			
			
			// *************************************************************************************
			// TEST CD

			System.out.println("#########  LISTA TUTTI I CD  ##########");
			System.out.println("In tabella ci sono " + cdService.listAllCd().size() + " elementi.");
			for (Cd cd : cdService.listAllCd()) {
				System.out.println(cd);
			}
//			cdService.listAllCd().forEach(cd -> System.out.println(cd));
			
//			System.out.println("#########  FIND BY ID CD ##########");
//			System.out.println(cdService.findCdById(2L));

//			System.out.println("#########  INSERT CD ##########");
//			Autore ref_autore = new Autore("Led","Zeppelin",null);
//			Cd cd_nuovo = new Cd("dsad",autoreService.findAutoreById(5L),"d",10);
//			System.out.println(cdService.inserisciNuovoCd(cd_nuovo));
//			for (Cd cd : cdService.listAllCd()) {
//				System.out.println(cd);
//			}

//			System.out.println("#########  UPDATE CD ##########");
//			Cd cd_da_aggiornare = cdService.findCdById(4L);
//			cd_da_aggiornare.setTitolo("titolo ");
//			cd_da_aggiornare.setGenere("genere prova");
//			System.out.println(cdService.aggiornaCd(cd_da_aggiornare));
//			for (Cd cd : cdService.listAllCd()) {
//				System.out.println(cd);
//			}

//			System.out.println("#########  AGGIORNA MALE CD ##########");
//			Cd input2 = cdService.findCdById(2L);
//			input2.setGenere("21020201201 ");
//			Cd input3 = cdService.findCdById(3L);
//			input3.setGenere("2102020120121020201201210202012012102020120121020201201");
//			System.out.println(cdService.aggiornaMaleCd(input2,input3));
//			for (Cd cd : cdService.listAllCd()) {
//				System.out.println(cd);
//			}
			
			
//			System.out.println("#########  DELETE CD ##########");
//			Cd cd_da_cancellare = cdService.findCdById(1L);
//			System.out.println(cdService.rimuoviCd(cd_da_cancellare));
//			for (Cd cd : cdService.listAllCd()) {
//				System.out.println(cd);
//			}
//			
//			System.out.println("#########  FIND BY EXAMPLE ##########");  // la select va fatta con i join???
//			Cd cd_example = new Cd(null,null,"Rock",8);
//			for (Cd cd : cdService.findByExample(cd_example)) {
//				System.out.println(cd);
//			}

//			System.out.println("#########  FIND ALL CD BY GENERE ##########");
//			for (Cd cd : cdService.findAllByGenere("pop")) {
//				System.out.println(cd);
//			}
//			
//			System.out.println("#########  FIND ALL CD BY AUTORE AND TITOLO INIZIA PER ##########");
//			for (Cd cd : cdService.findAllByAutoreWhereTitoloIniziaCon(autoreService.findAutoreById(5L), "l")) {
//				System.out.println(cd);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
