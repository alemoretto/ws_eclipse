package it.carrello.test;

import it.carrello.model.Articolo;
import it.carrello.model.Categoria;
import it.carrello.model.Ordine;
import it.carrello.service.ArticoloService;
import it.carrello.service.CategoriaService;
import it.carrello.service.MyServiceFactory;
import it.carrello.service.OrdineService;

public class TestCarrello {

	private static void liO() throws Exception {
		try {
			System.out.println("###########  LISTA  ORDINI   ############");
			for (Ordine o : MyServiceFactory.getOrdineServiceInstance().listAll()) {
				System.out.println(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void liA() throws Exception {
		try {
			System.out.println("###########  LISTA  ARTICOLI   ############");
			for (Articolo a : MyServiceFactory.getArticoloServiceInstance().listAll()) {
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void liC() throws Exception {
		try {

			System.out.println("###########  LISTA  CATEGORIE   ############");
			for (Categoria c : MyServiceFactory.getCategoriaServiceInstance().listAll()) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			Ordine ord_carla = ordineServiceInstance.caricaSingoloElemento(1L);
			Ordine ord_mario = ordineServiceInstance.caricaSingoloElemento(7L);
//			Ordine ord_ale = ordineServiceInstance.caricaSingoloElemento(3L);
			Ordine ord_matteo = ordineServiceInstance.caricaSingoloElemento(11L);
//
//			Categoria cat_vestiti = categoriaServiceInstance.caricaSingoloElemento(1L);
//			Categoria cat_pantaloni = categoriaServiceInstance.caricaSingoloElemento(2L);
//			Categoria cat_uomo = categoriaServiceInstance.caricaSingoloElemento(3L);
			Categoria cat_donna = categoriaServiceInstance.caricaSingoloElemento(2L);
//			Categoria cat_camicie = categoriaServiceInstance.caricaSingoloElemento(5L);
//			Categoria cat_calzature = categoriaServiceInstance.caricaSingoloElemento(6L);
			Categoria cat_inverno = categoriaServiceInstance.caricaSingoloElemento(9L);
			Categoria cat_casual = categoriaServiceInstance.caricaSingoloElemento(10L);
			
//			Articolo art_jeans_ale = articoloServiceInstance.caricaSingoloElemento(1L);
			Articolo art_nike_ale = articoloServiceInstance.caricaSingoloElemento(2L);
//			Articolo art_nike_carla = articoloServiceInstance.caricaSingoloElemento(3L);
//			Articolo art_camic_carla = articoloServiceInstance.caricaSingoloElemento(4L);
			Articolo art_guanti_carla = articoloServiceInstance.caricaSingoloElemento(5L);
			Articolo art_sciarpa_carla = articoloServiceInstance.caricaSingoloElemento(6L);
//			Articolo art_gonna_carla = articoloServiceInstance.caricaSingoloElemento(5L);
			Articolo art_foulard_carla = articoloServiceInstance.caricaSingoloElemento(7L);
			Articolo art_maglione_matteo = articoloServiceInstance.caricaSingoloElemento(14L);
			Articolo art_cell_mario = articoloServiceInstance.caricaSingoloElemento(10L);
			
//			System.out.println("###########  LISTA  ORDINI   ############");
//			for (Ordine o : ordineServiceInstance.listAll()) {
//				System.out.println(o);
//			}

////			System.out.println("###########  INSERISCI  ORDINE   ############");
////			Ordine ord = new Ordine("mario","via parigi");
//			Articolo art = new Articolo("maglione",50);
//			Ordine ord = new Ordine("matteo","via parigi");
//			Categoria cat = new Categoria("natale");
//			art.addCategoria(cat);
//			ord.addArticolo(art);
////			Articolo art = new Articolo("mouse_mario", 10);
////			ord.addArticlo(art);
//////			ord.getArticoli().add(art_cell);
//////			ord.getArticoli().add(art_mouse);
//			ordineServiceInstance.inserisciNuovo(ord);

//			System.out.println("###########  CARICA  ORDINE   ############");
//			System.out.println(ordineServiceInstance.caricaSingoloElemento(2L));

//			System.out.println("###########  AGGIORNA  ORDINE   ############");			
//			ord_carla.setNomeDestinatario("carla");
//			Articolo art = new Articolo("cell_mario", 300);
//			ord_mario.addArticolo(art);
//			ordineServiceInstance.aggiorna(ord_mario);

//			System.out.println("###########  CANCELLA  ORDINE   ############");			
////			Ordine o = ordineServiceInstance.caricaSingoloElemento(4L);
//			ordineServiceInstance.rimuovi(ord_matteo);

//			System.out.println("###########  FIND ALL ORDINI BY CATEGORIA    ############");
//			for (Ordine o : ordineServiceInstance.findAllByCategoria(cat_donna)) {
//				System.out.println(o);
//			}
			// ##############################################################################

//			System.out.println("###########  LISTA  ARTICOLI   ############");
//			for (Articoli a : articoloServiceInstance.listAll()) {
//				System.out.println(a);
//			}
////
//			System.out.println("###########  INSERISCI  ARTICOLO   ############");
//			Articolo art = new Articolo("maglione",50);
////			Ordine ord = new Ordine("matteo","via parigi");
////			ord.addArticolo(art);
////			 un nuovo articolo non pu� avere l'ordine a null !!
//			art.setOrdine(ord_mario); 
////			art.getCategorie().add(cat_inverno);
////			art.getCategorie().add(cat_pantaloni);
////			art.getCategorie().add(cat_donna);
////			art.getCategorie().add(cat_calzature);
////			art.getCategorie().add(cat_camicie);
//			articoloServiceInstance.inserisciNuovo(art);

//			System.out.println("###########  AGGIORNA  ARTICOLO   ############");
//			art_foulard_carla.getCategorie().add(cat_casual);
//			articoloServiceInstance.aggiorna(art_foulard_carla);

//				System.out.println("###########  CANCELLA  ARTICOLO   ############");			
//				articoloServiceInstance.rimuovi(art_cell_mario);

//			System.out.println("###########  FIND ALL BY CATEGORIA    ############");
//			for (Articolo a : articoloServiceInstance.findAllByCategoria(cat_uomo)) {
//				System.out.println(a);
//			}

//			System.out.println("###########  SOMMA PREZZI BY CATEGORIA    ############");
//			Categoria catSomma = cat_calzature;
//			Long sommaPrezzi = articoloServiceInstance.sommaPrezziByCategoria(catSomma);
//			System.out.println(
//					"La spesa per la categoria \"" + catSomma.getDescrizione() + "\" vale " + sommaPrezzi + " euro");

//			System.out.println("###########  SOMMA PREZZI BY CATEGORIA  PER TUTTE LE CATGORIE   ############");
//			for (Categoria c : MyServiceFactory.getArticoloServiceInstance().sommaPrezziByCategoria()) {
//				System.out.println(c.getDescrizione() + ": " );
//			}
			
			// ##############################################################################

//			System.out.println("###########  LISTA  CATEGORIE   ############");
//			for (Categoria c : MyServiceFactory.getArticoloServiceInstance().listAll()) {
//				System.out.println(a);
//			}

//			System.out.println("###########  INSERISCI  CATEGORIA   ############");
//			Categoria cat = new Categoria("lana");
////			cat.getArticoli().add(art_guanti_carla);
//			Articolo art1 = new Articolo("guanti mario",14,ord_mario);
//			Articolo art2 = new Articolo("maglione mario",34,ord_mario);
//			cat.addArticolo(art1);
//			cat.addArticolo(art2);
//			categoriaServiceInstance.inserisciNuovo(cat);

			System.out.println("###########  AGGIORNA  CATEGORIA   ############");
//			cat_inverno.getArticoli().add(art_sciarpa_carla);
				cat_inverno.addArticolo(art_maglione_matteo);
//			categoriaServiceInstance.aggiorna(cat_inverno);
			articoloServiceInstance.aggiorna(art_maglione_matteo);

//			System.out.println("###########  CANCELLA  CATEGORIA   ############");			
//			categoriaServiceInstance.rimuovi(cat_inverno);

//			System.out.println("###########  FIND ALL CATEGORIE BY ORDINE    ############");
//			for (Categoria c : categoriaServiceInstance.findAllByOrdine(ord_carla)) {
//				System.out.println(c);
//			}

//			System.out.println("###########  SOMMA PREZZI BY CATEGORIA    ############");
//			Categoria catSomma = cat_calzature;
//			Long sommaPrezzi = categoriaServiceInstance.sommaPrezziByCategoria(catSomma);
//			System.out.println(
//					"La spesa per la categoria \"" + catSomma.getDescrizione() + "\" vale " + sommaPrezzi + " euro");
			
			
			liO();
			liA();
			liC();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
