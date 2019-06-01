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

			Ordine ord_mario = ordineServiceInstance.caricaSingoloElemento(1L);
			Ordine ord_ale = ordineServiceInstance.caricaSingoloElemento(3L);
			
			Categoria cat_elettr = categoriaServiceInstance.caricaSingoloElemento(1L);
			Categoria cat_arred = categoriaServiceInstance.caricaSingoloElemento(4L);
			
			Articolo art_mouse = articoloServiceInstance.caricaSingoloElemento(1L);
			Articolo art_cell = articoloServiceInstance.caricaSingoloElemento(2L);
			Articolo art_monitor = articoloServiceInstance.caricaSingoloElemento(3L);
			
			Articolo art_tavolo = articoloServiceInstance.caricaSingoloElemento(4L);
			
			
//			System.out.println("###########  LISTA  ORDINI   ############");
//			for (Ordine o : ordineServiceInstance.listAll()) {
//				System.out.println(o);
//			}

//			System.out.println("###########  INSERISCI  ORDINE   ############");
//			Ordine ord = new Ordine("alex","via prenestina");
//			ordineServiceInstance.inserisciNuovo(ord);

//			System.out.println("###########  CARICA  ORDINE   ############");
//			System.out.println(ordineServiceInstance.caricaSingoloElemento(2L));

//			System.out.println("###########  AGGIORNA  ORDINE   ############");			
//			Ordine o = ordineServiceInstance.caricaSingoloElemento(2L);
//			o.setIndirizzoSpedizione("via mosca");
//			ordineServiceInstance.aggiorna(o);

//			System.out.println("###########  CANCELLA  ORDINE   ############");			
//			Ordine o = ordineServiceInstance.caricaSingoloElemento(2L);
//			ordineServiceInstance.rimuovi(o);
//			ordineServiceInstance.rimuovi(ord_ale);

			// ##############################################################################

//			System.out.println("###########  LISTA  ARTICOLI   ############");
//			for (Articoli a : articoloServiceInstance.listAll()) {
//				System.out.println(a);
//			}

//			System.out.println("###########  INSERISCI  ARTICOLO   ############");
//			Articolo art = new Articolo("tavolo2",560);
//			// un nuovo articolo non può avere l'ordine a null !!
//			art.setOrdine(ord_ale); 
//			art.getCategorie().add(cat_arred);
//			articoloServiceInstance.inserisciNuovo(art);

//			System.out.println("###########  AGGIORNA  ARTICOLO   ############");
//			art_tavolo.getCategorie().add(cat_arred);
//			articoloServiceInstance.aggiorna(art_tavolo);

//			System.out.println("###########  CANCELLA  ARTICOLO   ############");			
//			Articolo a = articoloServiceInstance.caricaSingoloElemento(2L);
//			articoloServiceInstance.rimuovi(a);
			
			// ##############################################################################

//			System.out.println("###########  LISTA  CATEGORIE   ############");
//			for (Categoria c : MyServiceFactory.getArticoloServiceInstance().listAll()) {
//				System.out.println(a);
//			}

//			System.out.println("###########  INSERISCI  CATEGORIA   ############");
//			Categoria cat = new Categoria("arredamento");
//			cat.getArticoli().add(art_tavolo);
//			categoriaServiceInstance.inserisciNuovo(cat);
			
//			System.out.println("###########  AGGIORNA  CATEGORIA   ############");
//			cat_elettr.getArticoli().add(art_cell);
//			categoriaServiceInstance.aggiorna(cat_elettr);
			
			
//			System.out.println("###########  CANCELLA  CATEGORIA   ############");			
//			Categoria c = categoriaServiceInstance.caricaSingoloElemento(3L);
//			categoriaServiceInstance.rimuovi(c);
			
			
			liO();
			liA();
			liC();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}
