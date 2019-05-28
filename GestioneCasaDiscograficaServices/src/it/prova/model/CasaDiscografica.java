package it.prova.model;

import java.util.List;
import java.util.ArrayList;

public class CasaDiscografica {

	private Long id;
	private String ragioneSociale;
	private String partitaIva;
	private List<Autore> autori = new ArrayList<>();

	public CasaDiscografica() {
	}

	public CasaDiscografica(String ragioneSociale, String partitaIva) {
		super();
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CasaDiscografica [ragioneSociale=" + ragioneSociale + ", partitaIva=" + partitaIva + "]";
	}
}
