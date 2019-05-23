package it.prova;

public class Commesso extends Lavoratore {

	public Commesso() {

	}

	public Commesso(String nome, int matricola) {
		super(nome, matricola,"Commesso");
	}

	public Commesso(String nome, int matricola, Negozio negozio) {
		super(nome, matricola, negozio,"Commesso");
	}

	public boolean handleItemAdd(Item item) {
		return negozio.getItems().add(item);
	}

	public boolean handleItemRemove(Item item) {
		return negozio.getItems().remove(item);
	}

}
