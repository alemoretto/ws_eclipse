package it.carrello.test;

import it.carrello.model.Articolo;
import it.carrello.model.Categoria;
import it.carrello.model.Ordine;
import it.carrello.service.ArticoloService;
import it.carrello.service.CategoriaService;
import it.carrello.service.MyServiceFactory;
import it.carrello.service.OrdineService;

public class Test_bis {

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
//			Ordine ord_mario = ordineServiceInstance.caricaSingoloElemento(2L);
//			Ordine ord_ale = ordineServiceInstance.caricaSingoloElemento(3L);
//			Ordine ord_matteo = ordineServiceInstance.caricaSingoloElemento(4L);
//
//			Categoria cat_vestiti = categoriaServiceInstance.caricaSingoloElemento(1L);
//			Categoria cat_pantaloni = categoriaServiceInstance.caricaSingoloElemento(2L);
//			Categoria cat_uomo = categoriaServiceInstance.caricaSingoloElemento(3L);
			Categoria cat_donna = categoriaServiceInstance.caricaSingoloElemento(2L);
			Categoria cat_camicie = categoriaServiceInstance.caricaSingoloElemento(5L);
//			Categoria cat_calzature = categoriaServiceInstance.caricaSingoloElemento(6L);
			Categoria cat_inverno = categoriaServiceInstance.caricaSingoloElemento(1L);
			Categoria cat_casual = categoriaServiceInstance.caricaSingoloElemento(3L);
			Categoria cat_elettronica = categoriaServiceInstance.caricaSingoloElemento(7L);

			
//			Articolo art_jeans_ale = articoloServiceInstance.caricaSingoloElemento(1L);
//			Articolo art_nike_ale = articoloServiceInstance.caricaSingoloElemento(2L);
//			Articolo art_nike_carla = articoloServiceInstance.caricaSingoloElemento(3L);
//			Articolo art_camic_carla = articoloServiceInstance.caricaSingoloElemento(4L);
//			Articolo art_guanti_carla = articoloServiceInstance.caricaSingoloElemento(3L);
			Articolo art_sciarpa_carla = articoloServiceInstance.caricaSingoloElemento(1L);
//			Articolo art_gonna_carla = articoloServiceInstance.caricaSingoloElemento(5L);
//			Articolo art_foulard_carla = articoloServiceInstance.caricaSingoloElemento(6L);
			Articolo art_cell_carla = articoloServiceInstance.caricaSingoloElemento(9L);
			
//			System.out.println("###########  LISTA  ORDINI   ############");
//			for (Ordine o : ordineServiceInstance.listAll()) {
//				System.out.println(o);
//			}

//			System.out.println("###########  INSERISCI  ORDINE   ############");
//			Ordine ord = new Ordine("carla","via parigi");
//			ord.getArticoli().add(art_cell);
//			ord.getArticoli().add(art_mouse);
//			ordineServiceInstance.inserisciNuovo(ord);

//			System.out.println("###########  CARICA  ORDINE   ############");
//			System.out.println(ordineServiceInstance.caricaSingoloElemento(2L));

//			System.out.println("###########  AGGIORNA  ORDINE   ############");			
//			ord_carla.setNomeDestinatario("carla");
//			ordineServiceInstance.aggiorna(ord_carla);

//			System.out.println("###########  CANCELLA  ORDINE   ############");			
//			Ordine o = ordineServiceInstance.caricaSingoloElemento(2L);
//			ordineServiceInstance.rimuovi(o);
//			ordineServiceInstance.rimuovi(ord_ale);

//			System.out.println("###########  FIND ALL ORDINI BY CATEGORIA    ############");
//			for (Ordine o : ordineServiceInstance.findAllByCategoria(cat_donna)) {
//				System.out.println(o);
//			}
			// ##############################################################################

//			System.out.println("###########  LISTA  ARTICOLI   ############");
//			for (Articoli a : articoloServiceInstance.listAll()) {
//				System.out.println(a);
//			}
//
			System.out.println("###########  INSERISCI  ARTICOLO   ############");
			Articolo art = new Articolo("mouse carla",25);
//			Categoria cat = new Categoria("elettronica");
			// un nuovo articolo non pu� avere l'ordine a null !!
			art.setOrdine(ord_carla);
			art.addCategoria(cat_elettronica);
//			art.getCategorie().add(cat_inverno);
////			art.getCategorie().add(cat_pantaloni);
//			art.getCategorie().add(cat_donna);
////			art.getCategorie().add(cat_calzature);
//			art.getCategorie().add(cat_camicie);
			articoloServiceInstance.inserisciNuovo(art);

			System.out.println("###########  AGGIORNA  ARTICOLO   ############");
			art_cell_carla.addCategoria(cat_elettronica);
			articoloServiceInstance.aggiorna(art_cell_carla);

//			System.out.println("###########  CANCELLA  ARTICOLO   ############");			
//			articoloServiceInstance.rimuovi(art_guanti_carla);

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
//			Categoria cat = new Categoria("elettronica");
////			cat.addArticolo(art_sciarpa_carla);
//			categoriaServiceInstance.inserisciNuovo(cat);

//			System.out.println("###########  AGGIORNA  CATEGORIA   ############");
//			cat_donna.getArticoli().add(art_guanti_carla);
//			categoriaServiceInstance.aggiorna(cat_donna);

//			System.out.println("###########  CANCELLA  CATEGORIA   ############");			
//			categoriaServiceInstance.rimuovi(cat_camicie);

//			System.out.println("###########  FIND ALL CATEGORIE BY ORDINE    ############");
//			for (Categoria c : categoriaServiceInstance.findAllByOrdine(ord_carla)) {
//				System.out.println(c);
//			}

//			System.out.println("###########  SOMMA PREZZI BY CATEGORIA    ############");
//			Categoria catSomma = cat_calzature;
//			Long sommaPrezzi = categoriaServiceInstance.sommaPrezziByCategoria(catSomma);
//			System.out.println(
//					"La spesa per la categoria \"" + catSomma.getDescrizione() + "\" vale " + sommaPrezzi + " euro");
			
			
//			liO();
			liA();
			liC();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
