package it.prova;

public class PersonaleAmministrativo extends Lavoratore {

	public PersonaleAmministrativo() {
		
	}
	
	public PersonaleAmministrativo(String nome,int matricola) {
		super(nome,matricola,"Personale Amministrativo");	
	}
	
	public PersonaleAmministrativo(String nome,int matricola, Negozio negozio) {
		super(nome,matricola,negozio,"Personale Amministrativo");
	}
	
	public boolean handleItemAdd(Item item) {
		return false;
	}

	public boolean handleItemRemove(Item item) {
		return negozio.getItems().remove(item);
	}

	
}
