package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Esame {

	private int id;
	private String denominazione;

	private List<Studente> studenti = new ArrayList<Studente>();

	public Esame() {
	}

	public Esame(int id, String denominazione) {
		super();
		this.id = id;
		this.denominazione = denominazione;
	}

	public Esame(List<Studente> studenti) {
		this.studenti = studenti;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void addToStudenti(Studente studente) {
		this.studenti.add(studente);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

}
