package it.prova.test;

import it.prova.dao.*;
import it.prova.model.*;

public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
		CasaDiscograficaDAO casaDAOInstance = new CasaDiscograficaDAO();
		AutoreDAO autoreDAOInstance = new AutoreDAO();
		CdDAO cdDAOInstance = new CdDAO();
		
		System.out.println("Case Discografiche sul db:");
		for (CasaDiscografica casaItem : casaDAOInstance.list()) {
			System.out.println(casaItem);
		}
		
//		//provo una insert di negozio
//		negozioDAOInstance.insert(new Negozio("Negozio1","via dei mille 14"));
		
//		System.out.println("cerco un negozio con id 1");
//		Negozio negozioConIdCheDicoIo = negozioDAOInstance.selectById(1L);
//		System.out.println(negozioConIdCheDicoIo);
//		
//		//inserisco un articolo
//		articoloDAOInstance.insert(new Articolo("articolo23", "matricola23", negozioConIdCheDicoIo));
//		
//		System.out.println("Articoli presenti sul db:");
//		for (Articolo articoloItem : articoloDAOInstance.list()) {
//			System.out.println(articoloItem);
//		}
//		
//		System.out.println("Negozi presenti sul db:");
//		for (Negozio negozioItem : negozioDAOInstance.list()) {
//			System.out.println(negozioItem);
//		}
////		Negozio nuovoNegozio = new Negozio("Profumi", "via Taranto");
////		negozioDAOInstance.insert(nuovoNegozio);
//		for (Negozio negozioItem : negozioDAOInstance.list()) {
//			System.out.println(negozioItem);
//		}
//		negozioDAOInstance.delete(negozioDAOInstance.selectById(3L));
//		for (Negozio negozioItem : negozioDAOInstance.list()) {
//			System.out.println(negozioItem);
//		}
		
	}
}
