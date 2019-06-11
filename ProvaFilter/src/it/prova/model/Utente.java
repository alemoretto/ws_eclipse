package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Utente {

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private List<Ruolo> ruoli = new ArrayList<>();

	public Utente(String username, String password, String nome, String cognome, List<Ruolo> ruoli) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.ruoli = ruoli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}
	
	public boolean isAdmin() {
		for (Ruolo ruoloItem : ruoli) {
			if(ruoloItem.getCodice().equals(Ruolo.ADMIN_ROLE))
				return true;
		}
		return false;
	}

}
