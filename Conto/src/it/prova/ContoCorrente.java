package it.prova;

public class ContoCorrente extends Conto {

	private int commissionePrelievo;

	public ContoCorrente() {
	}

	public int getCommissionePrelievo() {
		return commissionePrelievo;
	}

	public void setCommissionePrelievo(int commissionePrelievo) {
		this.commissionePrelievo = commissionePrelievo;
	}

	public void preleva(int prelievo) {
		if (saldo - (prelievo + commissionePrelievo) > 0)
			saldo -= (prelievo + commissionePrelievo);
	}

}
