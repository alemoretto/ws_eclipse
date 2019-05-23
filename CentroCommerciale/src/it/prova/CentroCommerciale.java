package it.prova;

import java.util.List;
import java.util.ArrayList;

public class CentroCommerciale {

	private String nome;
	private String ragioneSociale;
	private String partitaIVA;
	private List<Negozio> negozi = new ArrayList<>();

	public CentroCommerciale() {

	}

	public CentroCommerciale(String nome, String ragioneSociale, String partitaIVA, List<Negozio> negozi) {
		super();
		this.setNome(nome);
		this.setRagioneSociale(ragioneSociale);
		this.setPartitaIVA(partitaIVA);
		this.setNegozi(negozi);
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

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public List<Negozio> getNegozi() {
		return negozi;
	}

	public void setNegozi(List<Negozio> negozi) {
		this.negozi = negozi;
	}

}
