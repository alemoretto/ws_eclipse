package it.manytomanyjpa.test;

import java.util.Date;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;
import it.manytomanyjpa.service.MyServiceFactory;
import it.manytomanyjpa.service.RuoloService;
import it.manytomanyjpa.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);
//			Utente utenteDaDb = utenteServiceInstance.caricaSingoloElemento(1L);
//			if (utenteDaDb != null) {
//				utenteDaDb.getRuoli().add(ruoloDaDb);
//			}
//			utenteServiceInstance.aggiorna(utenteDaDb);

			
			//############################################################################
			//############################################################################
//			System.out.println("\n############    LISTA UTENTI    #############");
//			for (Utente utenteItem : utenteServiceInstance.listAll()) {
//				System.out.println(utenteItem);
//			}
			
			
//			System.out.println("\n############    INSERISCI RUOLO   #############");
//			Ruolo ruoloNuovo = new Ruolo("Administrator","ROLE_ADMIN");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
//			Ruolo ruoloNuovo2 = new Ruolo("Classic User","ROLE_CLASSIC_USER");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);
			
			
//			System.out.println("\n############    CARICA RUOLO   #############");
//			Ruolo ruoloAdmin = ruoloServiceInstance.caricaSingoloElemento(1L);
//			Ruolo ruoloClass = ruoloServiceInstance.caricaSingoloElemento(2L);

			
//			System.out.println("\n############    INSERISCI UTENTE   #############");
//			Utente utenteNuovo = new Utente("alessio", "dnfns", "alessio", "neri", new Date());
//			utenteNuovo.getRuoli().add(ruoloClass);
//			utenteNuovo.getRuoli().add(ruoloAdmin);
//			utenteServiceInstance.inserisciNuovo(utenteNuovo);
//			utenteServiceInstance.inserisciNuovo(new Utente("pincopallo", "dadada", "pinco", "pallo", new Date()));
//			utenteServiceInstance.inserisciNuovo(new Utente("marione", "rqrjo", "mario", "rossi", new Date()));
//			utenteServiceInstance.inserisciNuovo(new Utente("steve", "u490r", "stefano", "bianchi", new Date()));

			
//			System.out.println("\n############    RIMUOVI UTENTE   #############");
//			utenteServiceInstance.rimuovi(utenteServiceInstance.caricaSingoloElemento(3L));
			
			
//			System.out.println("\n############    AGGIORNA UTENTE   #############");
//			Utente uTemp = utenteServiceInstance.caricaSingoloElemento(6L);
//			Utente uTemp2 = utenteServiceInstance.caricaSingoloElemento(7L);
//			Ruolo ruoloClass = ruoloServiceInstance.caricaSingoloElemento(2L);
//			uTemp.getRuoli().add(ruoloClass);
//			utenteServiceInstance.aggiorna(uTemp);
//			uTemp2.getRuoli().add(ruoloClass);
//			utenteServiceInstance.aggiorna(uTemp2);
			
//			System.out.println("\n############    FIND ALL BY RUOLO    #############");
//			Ruolo ruoloClass = ruoloServiceInstance.caricaSingoloElemento(2L);
//			for (Utente u : utenteServiceInstance.findAllByRuolo(ruoloClass)) {
//				System.out.println(u);
//			}
			
			System.out.println("\n############    FIND BY EXAMPLE UTENTE    #############");
			Utente utenteExample = new Utente();
//			utenteExample.setNome(null);
			for (Utente u : utenteServiceInstance.findByExample(utenteExample)) {
				System.out.println(u);
			}
			
			
//			System.out.println("\n############    LISTA UTENTI    #############");
//			for (Utente utenteItem : utenteServiceInstance.listAll()) {
//				System.out.println(utenteItem);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
