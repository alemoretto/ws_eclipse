package it.prova;

public class Boss extends Lavoratore {

	public Boss() {
		
	}
	
	public Boss(String nome,int matricola) {
		super(nome,matricola,"Boss");
	}
	public Boss(String nome,int matricola,Negozio negozio) {
		super(nome,matricola,negozio,"Boss");
	}
	
	public boolean handleItemAdd(Item item) {
		return false;
	}

	public boolean handleItemRemove(Item item) {
		return false;
	}

}
