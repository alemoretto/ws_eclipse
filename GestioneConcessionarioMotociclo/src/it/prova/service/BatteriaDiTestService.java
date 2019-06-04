package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.model.Concessionario;
//import it.municipioabitantejpa.model.Municipio;
//import it.municipioabitantejpa.service.abitante.AbitanteService;
//import it.municipioabitantejpa.service.municipio.MunicipioService;

@Component
public class BatteriaDiTestService {

	@Autowired
	private ConcessionarioService concessionarioService;

//	@Autowired
//	private MotocicloService motocicloService;

	// casi di test (usare valorizzando la variabile casoDaTestare nel main)
//	public static final String INSERISCI_NUOVO_CONCESSIONARIO = "INSERISCI_NUOVO_CONCESSIONARIO";
//	public static final String INSERISCI_ABITANTI_DATO_UN_MUNICIPIO = "INSERISCI_ABITANTI_DATO_UN_MUNICIPIO";
//	public static final String CERCA_ABITANTE_DATO_ID_MUNICIPIO = "CERCA_ABITANTE_DATO_ID_MUNICIPIO";
//	public static final String RIMUOVI_MUNICIPIO_E_ABITANTI = "RIMUOVI_MUNICIPIO_E_ABITANTI";
	public static final String ELENCA_TUTTI_I_CONCESSIONARI = "ELENCA_TUTTI_I_CONCESSIONARI";
//	public static final String FIND_BY_EXAMPLE_BY_VIA = "FIND_BY_EXAMPLE_BY_VIA";
//	public static final String UPDATE_ABITANTE_SET_ETA = "UPDATE_ABITANTE_SET_ETA";
//	public static final String CARICA_MUNICIPIO_EAGER = "CARICA_MUNICIPIO_EAGER";
//	public static final String REMOVE_CON_ECCEZIONE_VA_IN_ROLLBACK = "REMOVE_CON_ECCEZIONE_VA_IN_ROLLBACK";
//	public static final String FIND_ALL_ABITANTE_UBICAZIONE_CONTIENE = "FIND_ALL_ABITANTE_UBICAZIONE_CONTIENE";
//	public static final String COUNT_MUNICIPI_BY_MINORENNI = "COUNT_MUNICIPI_BY_MINORENNI";

//	public static final String CARICA_MUNICIPIO_LAZY = "CARICA_MUNICIPIO_LAZY";

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
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	