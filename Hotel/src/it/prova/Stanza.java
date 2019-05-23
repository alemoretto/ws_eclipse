package it.prova;

public class Stanza {

	private int nStanza;
	private int quotaAPersona;
	private Cliente[] clienti;
	private String tipologia;

	public Stanza() {
	}

	public Stanza(int nStanza, int quotaAPersona) {
		this.nStanza = nStanza;
		this.quotaAPersona = quotaAPersona;
	}
	
	public int calcolaConto() {
		int result = 0;
		for (int i = 0; i < clienti.length; i++) {
			result += clienti[i].sommaRealeDaPagare();
		}
		return result;
	}
	
	public void addToClienti(Cliente c) {
		clienti = Cliente.addCliente(c, clienti);
	}

	public int getNStanza() {
		return nStanza;
	}

	public void setNStanza(int nStanza) {
		this.nStanza = nStanza;
	}

	public int getQuotaAPersona() {
		return quotaAPersona;
	}

	public void setQuotaAPersona(int quotaAPersona) {
		this.quotaAPersona = quotaAPersona;
	}

	public Cliente[] getClienti() {
		return clienti;
	}

	public void setClienti(Cliente[] clienti) {
		this.clienti = clienti;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
