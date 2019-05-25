package it.prova.test;

import java.util.List;

import javax.swing.JOptionPane;

import it.prova.dao.PersonaDao;
import it.prova.model.Persona;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao di persona
		PersonaDao personaDaoInstance = new PersonaDao();

		for (Persona personaItem : personaDaoInstance.list()) {
			System.out.println(personaItem);
		}

		// =========== qualche insert
		Persona personaDaInserire = new Persona("peppe", "rossi", 45);
		personaDaoInstance.insert(personaDaInserire);
		Persona altraPersonaDaInserire = new Persona("marco", "mazzoli", 51);
		personaDaoInstance.insert(altraPersonaDaInserire);

		// tutti quelli che si chiamano peppe rossi
		List<Persona> listaPeppeRossi = personaDaoInstance.selectByNomeCognome("peppe", "rossi");
		for (Persona personaItem : listaPeppeRossi) {
			System.out.println(personaItem);
		}
		
		//se ne esiste almeno uno
		if(!listaPeppeRossi.isEmpty()) {
			Persona personaCheTrovoSullaBaseDati = listaPeppeRossi.get(0);
			System.out.println("main before setNome:" + personaCheTrovoSullaBaseDati);
			personaCheTrovoSullaBaseDati.setNome("maurizio");
			personaDaoInstance.update(personaCheTrovoSullaBaseDati);
			
			//lo ricarico
			System.out.println("carico persona con id: "+personaCheTrovoSullaBaseDati.getId());
			System.out.println(personaDaoInstance.findById(personaCheTrovoSullaBaseDati.getId()));
		}
		
		personaDaoInstance.deleteByCognome("RoSsI");
		System.out.println("STOP");
		for (Persona persona : personaDaoInstance.findAllByNomeCheIniziaPer("mar")) {
			System.out.println(persona);
		}
		//inseriamo una persona presa da input
		//insertPersonaByJOptionPane(personaDaoInstance);
	}
	
	private static void insertPersonaByJOptionPane(PersonaDao personaDaoInstance) {
		Persona personaNuovaDaInput = buildPersonaFromJoptionPane();
		if(personaNuovaDaInput.getNome() != null && personaNuovaDaInput.getCognome()!=null 
				&& personaNuovaDaInput.getEta() > 0) {
			personaDaoInstance.insert(personaNuovaDaInput);
			JOptionPane.showMessageDialog(null,"Hai inserito:\\n"+personaNuovaDaInput);
		}
	}
	
	private static Persona buildPersonaFromJoptionPane() {
		String nome = JOptionPane.showInputDialog("dammi il nome");
		String cognome = JOptionPane.showInputDialog("dammi il cognome");
		String eta = JOptionPane.showInputDialog("dammi l'età");
		
		return new Persona(nome, cognome, Integer.parseInt(eta));
	}
}
