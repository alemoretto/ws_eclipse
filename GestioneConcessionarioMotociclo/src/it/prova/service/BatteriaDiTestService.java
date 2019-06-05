package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Concessionario;
import it.prova.model.Motociclo;

@Component
public class BatteriaDiTestService {

	@Autowired
	private ConcessionarioService concessionarioService;

	@Autowired
	private MotocicloService motocicloService;

	// casi di test (usare valorizzando la variabile casoDaTestare nel main)
	public static final String ELENCA_TUTTI_I_CONCESSIONARI_LAZY = "ELENCA_TUTTI_I_CONCESSIONARI_LAZY";
	public static final String ELENCA_TUTTI_I_CONCESSIONARI_EAGER = "ELENCA_TUTTI_I_CONCESSIONARI_EAGER";
	public static final String CARICA_CONCESSIONARIO_EAGER = "CARICA_CONCESSIONARIO_EAGER";
	public static final String INSERISCI_NUOVO_CONCESSIONARIO = "INSERISCI_NUOVO_CONCESSIONARIO";
	public static final String AGGIORNA_CONCESSIONARIO = "AGGIORNA_CONCESSIONARIO";
	public static final String RIMUOVI_CONCESSIONARIO = "RIMUOVI_CONCESSIONARIO";
	public static final String FINDBYEXAMPLE_CONCESSIONARIO = "FINDBYEXAMPLE_CONCESSIONARIO";
	public static final String ELENCA_CONCESSIONARI_MOTO1200 = "ELENCA_CONCESSIONARI_MOTO1200";
	public static final String ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016 = "ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016";

	public static final String ELENCA_TUTTI_I_MOTOCICLI_EAGER = "ELENCA_TUTTI_I_MOTOCICLI";
	public static final String INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO = "INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO";
	public static final String AGGIORNA_MOTOCICLO = "AGGIORNA_MOTOCICLO";
	public static final String RIMUOVI_MOTOCICLO = "RIMUOVI_MOTOCICLO";
	public static final String FINDBYEXAMPLE_MOTOCICLO = "FINDBYEXAMPLE_MOTOCICLO";
	public static final String NUMERO_MOTO_TORINO_PRECEDENTI_2010 = "NUMERO_MOTO_TORINO_PRECEDENTI_2010";

	public static final String CUSTOM = "CUSTOM";
	
	public void eseguiBatteriaDiTest(String casoDaTestare) {
		try {
			switch (casoDaTestare) {
			case ELENCA_TUTTI_I_CONCESSIONARI_LAZY:
				System.out.println("Elenco i concessionari:");
				for (Concessionario concessionarioItem : concessionarioService.listAllConcessionari()) {
					System.out.println(concessionarioItem);
				}
				break;

			case ELENCA_TUTTI_I_CONCESSIONARI_EAGER:
				System.out.println("Elenco i concessionari con i motocicli:");
				for (Concessionario concessionarioItem : concessionarioService.listAllConcessionariEager()) {
					System.out.println(concessionarioItem.toStringEager());
				}
				break;

			case CARICA_CONCESSIONARIO_EAGER:
				System.out.println("Carico il concessionario con i suoi motocicli:");
				System.out.println(concessionarioService.caricaSingoloConcessionarioEager(3L).toStringEager());
				break;

			case INSERISCI_NUOVO_CONCESSIONARIO:
				Concessionario nuovoConcessionario = new Concessionario("Moto Piemonte", "Roma", "84150710112");
				concessionarioService.inserisciNuovo(nuovoConcessionario);
				System.out.println("Concessionario appena inserito: " + nuovoConcessionario);
				break;

			case AGGIORNA_CONCESSIONARIO:
				Concessionario concAgg = concessionarioService.caricaSingoloConcessionarioLazy(8L);
				concAgg.setDenominazione("Moto & Auto");
				concessionarioService.aggiorna(concAgg);
				System.out.println("Concessionario aggiornato: " + concAgg);
				break;

			case RIMUOVI_CONCESSIONARIO:
				Concessionario concRim = concessionarioService.caricaSingoloConcessionarioLazy(2L);
				concessionarioService.rimuovi(concRim);
				break;

			case FINDBYEXAMPLE_CONCESSIONARIO:
				Concessionario concExample = new Concessionario();
				concExample.setCitta("Tor");
				System.out.println("Carico i concessionari by example:");
				for (Concessionario concItem : concessionarioService.findByExample(concExample)) {
					System.out.println(concItem);
				}
				break;

			case ELENCA_CONCESSIONARI_MOTO1200:
				System.out.println("Elenco i concessionari che hanno almeno 1 moto con cilindrata=1200:");
				for (Concessionario concessionarioItem : concessionarioService.findAllConcessionariConMotociclo1200()) {
					System.out.println(concessionarioItem);
				}
				break;

			case ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016:
				System.out.println(
						"Elenco i concessionari di Milano che hanno Honda immatricolate tra il 2012 e il 2016:");
				for (Concessionario concessionarioItem : concessionarioService
						.findAllConcessionariMilanoConHondaBetween2012And2016()) {
					System.out.println(concessionarioItem);
				}
				break;

			// ##############################################################################

			case ELENCA_TUTTI_I_MOTOCICLI_EAGER:
				System.out.println("Elenco i motocicli:");
				for (Motociclo motocicloItem : motocicloService.listAllMotocicli()) {
					System.out.println(motocicloItem.toStringEager());
				}
				break;

			case CUSTOM:
				Motociclo motoCustom = new Motociclo("MOTOCUSTOM", "veloce", 250, 2015);
				Concessionario concCustom = new Concessionario("CONCUSTOM", "NAPOLI", "429021491");
				
				
				concessionarioService.inserisciNuovo(concCustom);
				System.out.println("ID conc" + concCustom.getId());
				motoCustom.setConcessionario(concCustom);
				motocicloService.refresh(motoCustom);
				System.out.println("ID moto" + concCustom.getId());
				
				System.out.println("Motociclo appena inserito: " + motoCustom);
				break;

			case INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO:
				Motociclo nuovoMotociclo = new Motociclo("Motorello", "veloce", 250, 2015);
				nuovoMotociclo.setConcessionario(concessionarioService.caricaSingoloConcessionarioLazy(3L));
				motocicloService.inserisciNuovo(nuovoMotociclo);
				System.out.println("Motociclo appena inserito: " + nuovoMotociclo);
				break;

			case AGGIORNA_MOTOCICLO:
				Motociclo motoAgg = motocicloService.caricaSingoloMotociclo(12L);
				motoAgg.setCilindrata(650);
				motocicloService.aggiorna(motoAgg);
				System.out.println("Motociclo aggiornato: " + motoAgg);
				break;

			case RIMUOVI_MOTOCICLO:
				Motociclo motoRim = motocicloService.caricaSingoloMotociclo(13L);
				motocicloService.rimuovi(motoRim);
				break;

			case FINDBYEXAMPLE_MOTOCICLO:
				Motociclo motoExample = new Motociclo();
				motoExample.setMarca("u");
				System.out.println("Carico i motocicli by example:");
				for (Motociclo motoItem : motocicloService.findByExample(motoExample)) {
					System.out.println(motoItem);
				}
				break;

			case NUMERO_MOTO_TORINO_PRECEDENTI_2010:
				System.out.println(
						"Numero totale di motocicli dei concessionari di Torino immatricolati prima del 2010 :");
				System.out.println(motocicloService.numeroMotoTorinoPrecedenti2010());
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
