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

//			Ruolo ruoloNuovo = new Ruolo("Administrator","ROLE_ADMIN");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
//			Ruolo ruoloNuovo2 = new Ruolo("Classic User","ROLE_CLASSIC_USER");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);

			System.out.println("Elenca utenti: ");
			for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
			}

			Ruolo ruoloAdmin = ruoloServiceInstance.caricaSingoloElemento(1L);
			Ruolo ruoloClass = ruoloServiceInstance.caricaSingoloElemento(2L);
			
			Utente utenteNuovo = new Utente("ale.moretto", "dnfns", "alessandro", "moretto", new Date());
			utenteNuovo.getRuoli().add(ruoloClass);
			utenteNuovo.getRuoli().add(ruoloAdmin);
			utenteServiceInstance.inserisciNuovo(utenteNuovo);

//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);
//			Utente utenteDaDb = utenteServiceInstance.caricaSingoloElemento(1L);
//			if (utenteDaDb != null) {
//				utenteDaDb.getRuoli().add(ruoloDaDb);
//			}
			
//			utenteServiceInstance.aggiorna(utenteDaDb);

			for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
