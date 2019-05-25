package it.prova;

import java.util.ArrayList;
import java.util.List;

public class Negozio {

	private String nome;
	private String partitaIVA;
	private List<Lavoratore> lavoratori = new ArrayList<>();
	private List<Item> items = new ArrayList<>();

	public Negozio() {
	}

	public Negozio(String nome, String partitaIVA) {
		this.setNome(nome);
		this.setPartitaIVA(partitaIVA);
	}

	public Negozio(String nome, String partitaIVA, List<Lavoratore> lavoratori) {
		this.setNome(nome);
		this.setPartitaIVA(partitaIVA);
		this.setLavoratori(lavoratori);
	}

	public boolean addToItems(Lavoratore lavoratore, Item item) {
		System.out.println("________________________________________________");
		boolean esito = lavoratore.handleItemAdd(item);
		if (esito)
			System.out.println(lavoratore.getNome() + "(" + lavoratore.getQualifica() + ") ha aggiunto l'articolo "
					+ item.getProdotto());
		else
			System.out
					.println(lavoratore.getNome() + "(" + lavoratore.getQualifica() + ") non può aggiungere articoli");
		return esito;
	}

	public boolean addToItems(String nomeLavoratore, Item item) {
		return addToItems(Lavoratore.nomeToLavoratore(lavoratori, nomeLavoratore), item);
	}

	public boolean removeFromItems(Lavoratore lavoratore, Item item) {
		if (lavoratore.lavoraQui(this)) {
			System.out.println("________________________________________________");
			for (Item it : items) {
				if (item.equals(it)) {
					boolean esito = lavoratore.handleItemRemove(item);
					if (esito)
						System.out.println(lavoratore.getNome() + "(" + lavoratore.getQualifica()
								+ ") ha rimosso l'articolo " + item.getProdotto());
					else
						System.out.println(lavoratore.getNome() + "(" + lavoratore.getQualifica()
								+ ") non può rimuovere articoli");
					return esito;
				}
			}
			System.out.println("L'articolo " + item.getProdotto() + " non è presente in negozio");
			return false;
		}
		System.out.println(lavoratore.getNome() + "(" + lavoratore.getQualifica() + ") non lavora da " + nome);
		return false;
	}

	public boolean removeFromItems(Lavoratore lavoratore, String prodotto) {
		return removeFromItems(lavoratore, Item.prodottoToItem(items, prodotto));
	}

	public void showItems() {
		System.out.println("\nIn " + getNome() + " si vende:");
		for (Item item : items) {
			System.out.println(item.getProdotto());
		}
	}

	public void showLavoratori() {
		System.out.println("\nIn " + getNome() + " lavorano:");
		for (Lavoratore lavoratore : lavoratori) {
			System.out.println(lavoratore.getNome() + " : " + lavoratore.getQualifica());
		}
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

	public List<Lavoratore> getLavoratori() {
		return lavoratori;
	}

	public void setLavoratori(List<Lavoratore> lavoratori) {
		this.lavoratori = lavoratori;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
