package it.prova;

import java.util.ArrayList;
import java.util.List;

public class Negozio {

	private String nome;
	private String partitaIVA;
	private List<PC> pcs = new ArrayList<>();
	private List<Cliente> clienti = new ArrayList<>();

	public Negozio() {
	}

	public Negozio(String nome, String partitaIVA) {
		this.nome = nome;
		this.partitaIVA = partitaIVA;
	}

	public Negozio(String nome, String partitaIVA, List<PC> pcs) {
		this.nome = nome;
		this.partitaIVA = partitaIVA;
		this.pcs = pcs;
	}

	public List<PC> cercaPCByComponente(Componente componente) {
		List<PC> pcTrovati = new ArrayList<>();
		for (PC pc : pcs) {
			if (pc.haComponente(componente))
				pcTrovati.add(pc);
		}
		return pcTrovati;
	}

	public String mostraCatalogo() {
		String result = "";
		for (PC pc : pcs) {
			result += pc.mostraDettagli();
			result += "\n";
		}
		return result;
	}

	public String mostraElencoClienti() {
		String result = "";
		for (Cliente cliente : clienti) {
			result += cliente.toString();
			result += "\n";
		}
		return result;
	}

	public String toString() {
		String result = nome + "\n";
		for (int i = 0; i <= nome.length(); i++) {
			result += "=";
		}
		result += "\n" + mostraCatalogo() + "\n";
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public List<PC> getPcs() {
		return pcs;
	}

	public void setPcs(List<PC> pcs) {
		this.pcs = pcs;
	}

	public List<Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(List<Cliente> clienti) {
		this.clienti = clienti;
	}

}
