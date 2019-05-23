package it.prova;

public abstract class Cliente {

	protected String nome;
	protected String cognome;
	protected Stanza stanza;
	
	public Cliente() {
	}

	public Cliente(String nome, Stanza stanza) {
		this.nome = nome;
		this.stanza = stanza;
	}

	public abstract int sommaRealeDaPagare();

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

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}

	public static Cliente[] addCliente(Cliente c, Cliente[] clienti) {
		if (clienti == null) {
			clienti = new Cliente[1];
			clienti[0] = c;
		} else {
		Cliente[] temp = new Cliente[clienti.length + 1];
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = clienti[i];
		}
		temp[temp.length - 1] = c;
		clienti = new Cliente[temp.length];
		clienti = temp;
		}
		return clienti;
	}
	
}
