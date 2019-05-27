package it.prova.test;

import it.prova.dao.ArticoloDAO;
import it.prova.dao.NegozioDAO;
import it.prova.model.Articolo;
import it.prova.model.Negozio;

public class NegozioTest {

	public static void main(String[] args) {
		NegozioDAO negozioDAOInstance = new NegozioDAO();
		ArticoloDAO articoloDAOInstance = new ArticoloDAO();

//		System.out.println("Articoli presenti sul db:");
//		for (Articolo articoloItem : articoloDAOInstance.list()) System.out.println(articoloItem);

//		System.out.println("Negozi presenti sul db:");
//		for (Negozio negozioItem : negozioDAOInstance.list()) System.out.println(negozioItem);
//		listaNegozi(negozioDAOInstance);

		// *************************************************************************

//		//provo una insert di negozio
//		negozioDAOInstance.insert(new Negozio("Negozio1","via dei mille 14"));

//		// ricerca per id
//		System.out.println(negozioDAOInstance.selectById(1L));
//		
//		//inserisco un articolo
//		articoloDAOInstance.insert(new Articolo("articolo23", "matricola23", negozioConIdCheDicoIo));		
//		
//		// delete negozio
//		negozioDAOInstance.delete(negozioDAOInstance.selectById(3L));
//		
		// update articolo
//		Articolo artDaCambiare = articoloDAOInstance.selectByIdWithJoin(3L);
//		Negozio neg = negozioDAOInstance.selectById(4L);
//		artDaCambiare.setNegozio(neg);
//		articoloDAOInstance.update(artDaCambiare);

		// find articoli by indirizzo negozio
//		for (Articolo articoloItem : articoloDAOInstance.findAllByIndirizzoNegozio("via taranto")) System.out.println(articoloItem);

		
		// populate
		Negozio negozioDaPopolare = negozioDAOInstance.selectById(1L);
		for (Articolo articoloItem : negozioDaPopolare.getArticoli())
			System.out.println(negozioDaPopolare);		
		System.out.println("...............");
		negozioDAOInstance.populateArticoli(negozioDaPopolare);
		for (Articolo articoloItem : negozioDaPopolare.getArticoli())
			System.out.println(articoloItem);		
		/*
		 * se io voglio caricare un negozio e contestualmente anche i suoi articoli
		 * dovrò sfruttare il populateArticoli presente dentro negoziodao. Per esempio
		 * Negozio negozioCaricatoDalDb = negozioDAOInstance.selectById...
		 * 
		 * negozioDAOInstance.populateArticoli(negozioCaricatoDalDb);
		 * 
		 * e da qui in poi il negozioCaricatoDalDb.getArticoli() non deve essere più a
		 * size=0 LAZY FETCHING (poi ve lo spiego)
		 */

	}

	private static void listaArticoli(ArticoloDAO articoloDAOInstance) {
		System.out.println("ARTICOLI presenti sul db:");
		for (Articolo articoloItem : articoloDAOInstance.list())
			System.out.println(articoloItem);
	}

	private static void listaNegozi(NegozioDAO negozioDAOInstance) {
		System.out.println("NEGOZI presenti sul db:");
		for (Negozio negozioItem : negozioDAOInstance.list())
			System.out.println(negozioItem);
	}
}
