package it.prova.test;

import javax.swing.JOptionPane;

import it.prova.dao.*;
import it.prova.model.*;

public class NegozioTest {

	public static void main(String[] args) {
		NegozioDAO negozioDAOInstance = new NegozioDAO();
		ArticoloDAO articoloDAOInstance = new ArticoloDAO();

//		System.out.println("Lista ARTICOLI presenti sul db:"); for (Articolo articoloItem : articoloDAOInstance.list()) System.out.println(articoloItem);

//		System.out.println("Lista NEGOZI presenti sul db:"); for (Negozio negozioItem : negozioDAOInstance.list()) System.out.println(negozioItem);

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

		
//		// populate
//		Negozio negozioDaPopolare = negozioDAOInstance.selectById(1L);
//		for (Articolo articoloItem : negozioDaPopolare.getArticoli()) System.out.println(negozioDaPopolare);		
//
//		negozioDAOInstance.populateArticoli(negozioDaPopolare);
//		for (Articolo articoloItem : negozioDaPopolare.getArticoli())	System.out.println(articoloItem);
		
		
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

		// GUI insert
		insertNegozioByJOptionPane(negozioDAOInstance);
	}

	private static void insertNegozioByJOptionPane(NegozioDAO negozioDAOInstance) {
		Negozio negozioNuovoDaInput = buildNegozioFromJoptionPane();
		if(negozioNuovoDaInput.getNome() != null && negozioNuovoDaInput.getIndirizzo()!=null ) {
			negozioDAOInstance.insert(negozioNuovoDaInput);
			JOptionPane.showMessageDialog(null,"Hai inserito:\\n"+negozioNuovoDaInput);
		}
	}
	
	private static Negozio buildNegozioFromJoptionPane() {
		String nome = JOptionPane.showInputDialog("NOME negozio ?");
		String indirizzo = JOptionPane.showInputDialog("INDIRIZZO negozio ?");
		
		return new Negozio(nome, indirizzo);
	}

}
