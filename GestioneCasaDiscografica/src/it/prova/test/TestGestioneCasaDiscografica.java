package it.prova.test;

import it.prova.dao.*;
import it.prova.model.*;

import java.util.List;
public class TestGestioneCasaDiscografica {

	public static void main(String[] args) {
		CasaDiscograficaDAO casaDAOInstance = new CasaDiscograficaDAO();
		AutoreDAO autoreDAOInstance = new AutoreDAO();
		CdDAO cdDAOInstance = new CdDAO();
		
		System.out.println("Case Discografiche sul db:");
		for (CasaDiscografica casaItem : casaDAOInstance.list()) System.out.println(casaItem);
		for (Autore autoreItem : autoreDAOInstance.list()) System.out.println(autoreItem);
		
////		//insert di casadiscografica
//		CasaDiscografica casa_nuova = new CasaDiscografica("MusicaRomana","4242"); 
////		casaDAOInstance.insert(casa_nuova);
//		for (Autore autoreItem : autoreDAOInstance.list()) System.out.println(autoreItem);
//		for (CasaDiscografica casaItem : casaDAOInstance.list()) System.out.println(casaItem);
		
		// insert di autore
//		autoreDAOInstance.insert(new Autore("Vasco", "Rossi", casaDAOInstance.selectByIdWithJoin(4L) ));
//		autoreDAOInstance.insertCompleto(new Autore("Gabriella", "Ferri", casa_nuova ));
//		for (CasaDiscografica casaItem : casaDAOInstance.list()) System.out.println(casaItem);
//		Autore aut = new Autore("Deep","Purple",null);
//		Cd cdExample = new Cd("Made in Japan",aut,"Rock",9);
		
		Cd cdExample = new Cd("Albachiara",null,"Rock",9);
		System.out.println("............");
		List<Cd> cds = cdDAOInstance.findByExample(cdExample);
		for (Cd cd : cds) {
			System.out.println(cd);
		}
//		public void  findByExample(cdExample);
		// uodate
//		autoreDAOInstance.update(new Autore("Vasco", "Rossi", casaDAOInstance.selectByIdWithJoin(4L) ));
		
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
