package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.EsameDAO;
import it.prova.model.Esame;
import it.prova.model.Studente;
/**
 * @author erchina
 *
 */
@Component
public class EsameServiceImpl implements EsameService {
	
	@Autowired
	private ProfessoreItalianoService professoreItalianoService;
	@Autowired
	private ProfessoreMatematicaService professoreMatematicaService;
	@Autowired
	private ProfessoreScienzeService professoreScienzeService;
	@Autowired
	private AltriProfessoriService altriProfessoriService;
	@Autowired
	private EsameDAO esameDAO;
	

	@Override
	public void avviaEsame(Esame esame) {
		System.out.println("Inizio esame........................");
		System.out.println("************************************");
		for (Studente studente : esame.getStudenti()) {
			System.out.println("Inizio esame del candidato: "+studente);
			professoreItalianoService.esaminaInLetteratura(studente);
			professoreMatematicaService.esaminaInMatematica(studente);
			professoreScienzeService.esaminaInScienze(studente);
			altriProfessoriService.esaminaInAltreDiscipline(studente);
			System.out.println("Termine esame del candidato: "+studente);
			System.out.println("************************************");
		}
		System.out.println("************************************");
		System.out.println("Termine esame........................");
		
	}
	
	@Override
	public void avviaEsameByStudente(Esame esame, Studente studente) {
			System.out.println("Inizio esame del candidato: "+studente);
			professoreItalianoService.esaminaInLetteratura(studente);
			professoreMatematicaService.esaminaInMatematica(studente);
			professoreScienzeService.esaminaInScienze(studente);
			altriProfessoriService.esaminaInAltreDiscipline(studente);
			System.out.println("Termine esame del candidato: "+studente);
			System.out.println("************************************");
		
	}
	
	@Override
	public Esame caricaEsame(int id) {
		return esameDAO.get(id);
	}

	@Override
	public void aggiungiStudenteAdEsame(Studente studenteInput, Esame esameInput) {
		esameDAO.addStudentToEsame(studenteInput, esameInput);
	}


	public ProfessoreItalianoService getProfessoreItalianoService() {
		return professoreItalianoService;
	}


	public void setProfessoreItalianoService(
			ProfessoreItalianoService professoreItalianoService) {
		this.professoreItalianoService = professoreItalianoService;
	}


	public ProfessoreMatematicaService getProfessoreMatematicaService() {
		return professoreMatematicaService;
	}


	public void setProfessoreMatematicaService(
			ProfessoreMatematicaService professoreMatematicaService) {
		this.professoreMatematicaService = professoreMatematicaService;
	}


	public AltriProfessoriService getAltriProfessoriService() {
		return altriProfessoriService;
	}


	public void setAltriProfessoriService(
			AltriProfessoriService altriProfessoriService) {
		this.altriProfessoriService = altriProfessoriService;
	}

	
}
