package it.prova.model;

import java.util.List;
import java.util.ArrayList;

public class CasaDiscografica {

	private Long idCasaDiscografica;
	private String nome;
	private String ragioneSociale;
	private String partitaIva;
	private List<Autore> autori = new ArrayList<>();

	public CasaDiscografica() {
	}

	public CasaDiscografica(Long idCasaDiscografica, String nome, String ragioneSociale, String partitaIva,
			List<Autore> autori) {
		super();
		this.idCasaDiscografica = idCasaDiscografica;
		this.nome = nome;
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.autori = autori;
	}

	public Long getIdcasadiscografica() {
		return idCasaDiscografica;
	}

	public void setIdcasadiscografica(Long idCasaDiscografica) {
		this.idCasaDiscografica = idCasaDiscografica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Autore> getAutori() {
		return autori;
	}

	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}

}
