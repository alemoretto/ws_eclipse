package it.prova;

public class Conto {

	protected int numero;
	protected String intestatario;
	protected int saldo;

	public Conto() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void preleva(int prelievo) {
		if (saldo - prelievo > 0)
			saldo -= prelievo;
	}

	public void deposita(int deposito) {
		saldo += deposito;
	}

	public void bonifico(int somma, Conto beneficiario) {
		if (saldo - somma > 0) {
			this.preleva(somma);
			beneficiario.deposita(somma);
		}
	}
}