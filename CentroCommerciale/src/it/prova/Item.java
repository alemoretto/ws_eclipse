package it.prova;

import java.util.List;

public class Item {

	private String prodotto;
	private String barCode;
	private Negozio negozio;
	
	public Item() {
		
	}

	public Item(String prodotto, String barCode, Negozio negozio) {
		this.setProdotto(prodotto);
		this.setBarCode(barCode);
		this.setNegozio(negozio);
	}
	
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Item))
			return false;
		Item item = (Item) o;
		if(!item.getBarCode().equals(barCode))
			return false;
		return true;
	}
	
	public static Item prodottoToItem(List<Item> items, String prodottoItem) {
		for (Item item : items) {
			if (item.getProdotto().equals(prodottoItem))
				return item;
		}
		return null;
	}
	
	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Negozio getNegozio() {
		return negozio;
	}

	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}
	
	
	
}
