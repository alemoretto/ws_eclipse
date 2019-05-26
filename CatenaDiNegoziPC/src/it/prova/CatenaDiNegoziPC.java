package it.prova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatenaDiNegoziPC {

	private String nome;
	private List<Negozio> negozi = new ArrayList<>();
	private List<PC> tuttiIPC = new ArrayList<>();
	private List<Componente> tuttiIComponenti = new ArrayList<>();

	public CatenaDiNegoziPC() {
	}

	public CatenaDiNegoziPC(String nome, List<Negozio> negozi) {
		super();
		this.nome = nome;
		this.negozi = negozi;
		for (Negozio negozio : negozi) {
			tuttiIPC.addAll(negozio.getPcs());
			for (PC pc : negozio.getPcs()) {
				tuttiIComponenti.addAll(pc.getComponenti());
			}
		}
	}

	private List<Ritiro> ritiraInteroPC(PC pcDifettoso) {
		List<Ritiro> ritiri = new ArrayList<>();
		if (tuttiIPC.contains(pcDifettoso)) {
			List<PC> pcsDaRitirare = new ArrayList<>(Arrays.asList(pcDifettoso));
			for (Negozio negozio : negozi) {
				if (negozio.getPcs().contains(pcDifettoso))
					ritiri.add(new Ritiro(negozio, pcsDaRitirare));
			}
		}
		return ritiri;
	}

	private List<Ritiro> ritiraPCCausaComponente(Componente componenteDifettoso) {
		List<Ritiro> ritiri = new ArrayList<>();
		if (tuttiIComponenti.contains(componenteDifettoso)) {
			for (Negozio negozio : negozi) {
				List<PC> pcsDaRitirare = negozio.cercaPCByComponente(componenteDifettoso);
				if (pcsDaRitirare.size() > 0)
					ritiri.add(new Ritiro(negozio, pcsDaRitirare));
			}
		}
		return ritiri;
	}

	public List<Ritiro> ritiraProdottiPerDifetto(Object objDifettoso) {

		// Per ogni negozio della catena controllo:
		// se ha pc con il componenente difettoso
		if (objDifettoso != null && objDifettoso instanceof Componente) {
			return ritiraPCCausaComponente((Componente) objDifettoso);
			// ... oppure se ha il pc difettoso
		} else if (objDifettoso != null && objDifettoso instanceof PC) {
			return ritiraInteroPC((PC) objDifettoso);
		}
		return new ArrayList<>();
	}

	public List<Ritiro> ritiraProdottiPerDifetto(String matricola) {
		return ritiraProdottiPerDifetto(matricolaToObject(matricola));
	}

	public Object matricolaToObject(String matricola) {
		if (matricola == null || matricola.length() < 2)
			return null;
		String tipoProdotto = matricola.substring(0, 2);
		if (tipoProdotto.equals("PC")) {
			for (PC pc : tuttiIPC) {
				if (pc.getMatricola().equals(matricola)) {
					return pc;
				}
			}
		} else {
			for (Componente componente : tuttiIComponenti) {
				if (componente.getMatricola().equals(matricola)) {
					return componente;
				}
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Negozio> getNegozi() {
		return negozi;
	}

	public void setNegozi(List<Negozio> negozi) {
		this.negozi = negozi;
	}

}
