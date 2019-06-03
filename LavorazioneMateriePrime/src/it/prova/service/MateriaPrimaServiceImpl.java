package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;
import it.prova.model.StatoLavorazione;

/**
 * @author erchina
 *
 */
@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
	@Autowired
	private LavorazioneService lavorazioneService;
	@Autowired
	private AssemblaggioService assemblaggioService;
	@Autowired
	private VerniciaturaService verniciaturaService;
	@Autowired
	private MessaInOperaService messaInOperaService;
	
	
	@Override
	public void avviaProcesso(MateriaPrima materiaPrima) {
		System.out.println("Inizio processo per " + materiaPrima + " \n");
		
		switch (materiaPrima.getStato()) {
		case IN_INSERIMENTO: 
//			System.out.println(materiaPrima);
			materiaPrima.setStato(StatoLavorazione.IN_LAVORAZIONE);
		case IN_LAVORAZIONE:
			lavorazioneService.eseguiLavorazione(materiaPrima);
		case IN_ASSEMBLAGGIO:
			assemblaggioService.eseguiAssemblaggio(materiaPrima);
		case IN_VERNICIATURA:
			verniciaturaService.eseguiVerniciatura(materiaPrima);
		case IN_MESSA_IN_OPERA:
			messaInOperaService.eseguiMessaInOpera(materiaPrima);
		case PRONTA:
			System.out.println(materiaPrima);
		default:
		}
		materiaPrimaDAO.update(materiaPrima);
		
		System.out.println("\nTermine processo  ****************************");

	}

	@Override
	public MateriaPrima caricaMateriaPrima(int id) {
		return materiaPrimaDAO.get(id);
	}

}
