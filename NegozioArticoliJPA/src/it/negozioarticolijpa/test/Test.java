package it.negozioarticolijpa.test;

import java.util.List;

import it.negozioarticolijpa.model.Articolo;
import it.negozioarticolijpa.model.Negozio;
import it.negozioarticolijpa.service.ArticoloService;
import it.negozioarticolijpa.service.MyServiceFactory;
import it.negozioarticolijpa.service.NegozioService;

public class Test {

	public static void main(String[] args) {

		NegozioService negozioService = MyServiceFactory.getNegozioServiceInstance();
		ArticoloService articoloService = MyServiceFactory.getArticoloServiceInstance();

		try {
//			System.out.println("############    LISTA  NEGOZI    #############");
//			for (Negozio n : negozioService.listAllNegozi()) System.out.println(n);
			System.out.println("---------11111111------------");
			Negozio negozio = negozioService.listAllNegozi().get(0);
			System.out.println("---------22222222------------");
			List<Articolo> art = negozio.getArticoli();
			System.out.println("---------33333333------------");
			for (Articolo a : art) System.out.println(a);
			System.out.println("---------44444444------------");
			
//			System.out.println("############    CARICA  NEGOZIO    #############");
//			System.out.println(negozioService.caricaSingoloNegozio(4L));	
			
//			System.out.println("############ INSERISCI NEGOZIO #############");
//			Negozio negEuronics = new Negozio("euronics","viale ippocrate");
//			negozioService.inserisciNuovo(negEuronics);
//			Negozio negAbbigliamento = new Negozio("Abbigliamento","via Mosca");
//			negozioService.inserisciNuovo(negAbbigliamento);
			
//			System.out.println("############    AGGIORNA  NEGOZIO    #############");
//			Negozio negDaAggiornare =  negozioService.caricaSingoloNegozio(1L);
//			negDaAggiornare.setIndirizzo("piazza di spagna");
//			negozioService.aggiorna(negDaAggiornare);
			
//			System.out.println("############    RIMUOVI  NEGOZIO    #############");
//			Negozio negDaRimuovere =  negozioService.caricaSingoloNegozio(1L);
//			negozioService.rimuovi(negDaRimuovere);
			
//			System.out.println("############    FIND BY EXAMPLE  NEGOZIO    #############");
//			Negozio negExample = new Negozio();
//			negExample.setNome("");
//			for (Negozio n : negozioService.findByExample(negExample)) System.out.println(n);

			// ##############################################################################

//			System.out.println("############    LISTA    ARTICOLI    #############");
//			System.out.println(articoloService.listAllArticoli());
			
//			System.out.println("############    CARICA  NEGOZIO    #############");
//			System.out.println(articoloService.caricaSingoloArticolo(3L));	

//			System.out.println("############    INSERISCI ARTICOLO    #############");
//			Articolo artTelefono = new Articolo("telefono","9511",negozioService.caricaSingoloNegozio(1L));
//			articoloService.inserisciNuovo(artTelefono);
			
//			System.out.println("############    AGGIORNA  ARTICOLO    #############");
//			Articolo artDaAggiornare = articoloService.caricaSingoloArticolo(6L);
//			artDaAggiornare.setNome("camicie");
//			articoloService.aggiorna(artDaAggiornare);
			
//			System.out.println("############    RIMUOVI  ARTICOLO    #############");
//			Articolo artDaRimuovere = articoloService.caricaSingoloArticolo(6L);
//			articoloService.rimuovi(artDaRimuovere);
//			System.out.println(articoloService.listAllArticoli());
//			
			System.out.println("############    FIND BY EXAMPLE ARTICOLO    #############");
			Articolo artExample = new Articolo();
			artExample.setMatricola("");
			Negozio neg = new Negozio();
			neg.setIndirizzo("");
			artExample.setNegozio(neg);
//			artExample.setNegozio(negozioService.caricaSingoloNegozio(6L));
			for (Articolo a : articoloService.findByExample(artExample)) System.out.println(a);

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}