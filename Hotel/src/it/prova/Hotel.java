package it.prova;

public class Hotel {

	private String nome;
	private String stelle;
	private Stanza[] stanze;
	private Cliente[] clienti;

	public Hotel() {
	}

	public Hotel(Stanza[] stanze) {
		this.stanze = stanze;
	}

	public int calcolaConto(Stanza s) {
		return stanze[getIndexOfStanza(s)].calcolaConto();
	}

	public int calcolaConto(int nStanza) {
		return getStanzaFromNumber(nStanza).calcolaConto();
	}

	public void addToStanze(Stanza s) {
		if (stanze == null) {
			stanze = new Stanza[1];
			stanze[0] = s;
			return;
		}
		Stanza[] temp = new Stanza[stanze.length + 1];
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = stanze[i];
		}
		temp[temp.length - 1] = s;
		stanze = new Stanza[temp.length];
		stanze = temp;
	}

	public void removeFromStanze(int indexToRemove) {
		if (stanze == null || indexToRemove < 0 || indexToRemove > stanze.length - 1)
			return;
		Stanza[] temp = new Stanza[stanze.length - 1];
		int j = -1;
		for (int i = 0; i < stanze.length; i++) {
			if (i == indexToRemove)
				continue;
			j++;
			temp[j] = stanze[i];
		}
		stanze = temp;
	}

	public void elencoStanze() {
		for (int i = 0; i < stanze.length; i++) {
			System.out.println(stanze[i].getNStanza());
		}
	}

	private int getIndexOfStanza(Stanza s) {
		for (int i = 0; i < stanze.length; i++) {
			if (stanze[i].getNStanza() == s.getNStanza()) {
				return i;
			}
		}
		return -1;
	}

	private int getIndexOfStanza(int nStanza) {
		for (int i = 0; i < stanze.length; i++) {
			if (stanze[i].getNStanza() == nStanza) {
				return i;
			}
		}
		return -1;
	}

	private Stanza getStanzaFromNumber(int nStanza) {
		for (int i = 0; i < stanze.length; i++) {
			if (stanze[i].getNStanza() == nStanza)
				return stanze[i];
		}
		return null;
	}

	public void addToClienti(Cliente c, int nStanza) {
		c.setStanza(getStanzaFromNumber(nStanza));
		clienti = Cliente.addCliente(c, clienti);
		stanze[getIndexOfStanza(nStanza)].addToClienti(c);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStelle() {
		return stelle;
	}

	public void setStelle(String stelle) {
		this.stelle = stelle;
	}

	public Stanza[] getStanze() {
		return stanze;
	}

	public void setStanze(Stanza[] stanze) {
		this.stanze = stanze;
	}

	public Cliente[] getClienti() {
		return clienti;
	}

	public void setClienti(Cliente[] clienti) {
		this.clienti = clienti;
	}

}
