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
	public static final String ELENCA_TUTTI_I_CONCESSIONARI = "ELENCA_TUTTI_I_CONCESSIONARI";
	public static final String INSERISCI_NUOVO_CONCESSIONARIO = "INSERISCI_NUOVO_CONCESSIONARIO";
	public static final String ELENCA_CONCESSIONARI_MOTO1200 = "ELENCA_CONCESSIONARI_MOTO1200";
	public static final String ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016 = "ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016";
	
	public static final String ELENCA_TUTTI_I_MOTOCICLI = "ELENCA_TUTTI_I_MOTOCICLI";
	public static final String INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO = "INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO";
	public static final String NUMERO_MOTO_TORINO_PRECEDENTI_2010 = "NUMERO_MOTO_TORINO_PRECEDENTI_2010";
	
	public void eseguiBatteriaDiTest(String casoDaTestare) {
		try {
			switch (casoDaTestare) {
			case ELENCA_TUTTI_I_CONCESSIONARI:
				// elencare i municipi
				System.out.println("Elenco i concessionari:");
				for (Concessionario concessionarioItem : concessionarioService.listAllConcessionari()) {
					System.out.println(concessionarioItem);
				}
				break;

			case INSERISCI_NUOVO_CONCESSIONARIO:
				// elencare i municipi
				Concessionario nuovoConcessionario = new Concessionario("Moto Piemonte", "Roma", "84150710112");
				// salvo
				concessionarioService.inserisciNuovo(nuovoConcessionario);
				System.out.println("Concessionario appena inserito: " + nuovoConcessionario);
				break;

			case ELENCA_CONCESSIONARI_MOTO1200:
				// elencare i municipi
				System.out.println("Elenco i concessionari che hanno almeno 1 moto con cilindrata=1200:");
				for (Concessionario concessionarioItem : concessionarioService.findAllConcessionariConMotociclo1200()) {
					System.out.println(concessionarioItem);
				}
				break;
				
			case ELENCA_CONCESSIONARI_MILANO_HONDA_2012_2016:
				// elencare i municipi
				System.out.println("Elenco i concessionari di Milano che hanno Honda immatricolate tra il 2012 e il 2016:");
				for (Concessionario concessionarioItem : concessionarioService.findAllConcessionariMilanoConHondaBetween2012And2016()) {
					System.out.println(concessionarioItem);
				}
				break;	
				
				
				
			case ELENCA_TUTTI_I_MOTOCICLI:
				// elencare i municipi
				System.out.println("Elenco i motocicli:");
				for (Motociclo motocicloItem : motocicloService.listAllMotocicli()) {
					System.out.println(motocicloItem);
				}
				break;

			
//			case INSERISCI_NUOVO_MOTOCICLO_DATO_CONCESSIONARIO:
//				// elencare i municipi
//				Motociclo nuovoMotociclo = new Motociclo("Honda", "SH", 125, 2010);
//				nuovoMotociclo.setConcessionario(concessionarioService.);
//				// salvo
//				motocicloService.inserisciNuovo(nuovoMotociclo);
//				System.out.println("Motociclo appena inserito: " + nuovoMotociclo);
//				break;
			
			case NUMERO_MOTO_TORINO_PRECEDENTI_2010:
			System.out.println("Numero totale di motocicli dei concessionari di Torino immatricolati prima del 2010 :");
				System.out.println( motocicloService.numeroMotoTorinoPrecedenti2010());
			break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
