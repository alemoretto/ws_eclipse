package it.prova.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.prova.*;

public class TestCentroCommerciale {

	public static void main(String[] args) {

		// creo NEGOZI
		List<Negozio> negozi = new ArrayList<>(Arrays.asList(new Negozio("Trony","11110005678"),
											 new Negozio("Sapori","22220005678"))); 
		Negozio trony = negozi.get(0);
		
		// creo CENTROCOMMERCIALE
		CentroCommerciale centro = new CentroCommerciale("Roma70 Shopping Center","Roma70 S.p.A.","01234567890",negozi);
		
		// creo LAVORATORI
		Lavoratore boss = new Boss("Mario", 001,trony);
		Lavoratore amministrativo = new PersonaleAmministrativo("Carlo", 002,trony);
		Lavoratore commesso_1 = new Commesso("Paolo", 003,trony);
		Lavoratore commesso_2 = new Commesso("Matteo", 004,trony);
		List<Lavoratore> lavoratori = new ArrayList<>(Arrays.asList(boss,amministrativo,commesso_1,commesso_2));		
//		List<Lavoratore> lavoratori = Arrays.asList(new Boss("Mario", 001,trony), 
//													new PersonaleAmministrativo("Carlo", 002,trony),
//													new Commesso("Paolo", 003,trony),
//													new Commesso("Matteo", 004,trony));
		
		// creo ITEMS
		Item televisore = new Item("Televisore","TT 1111000789",trony);
		Item smartphone = new Item("Smartphone","SS 1111000789",trony);
		Item lavatrice = new Item("Lavatrice","LL 1111000789",trony);
		Item frigorifero = new Item("Frigorifero","FF 1111000789",trony);
		List<Item> items = new ArrayList<>(Arrays.asList(televisore,smartphone,lavatrice,frigorifero));
		
		trony.setLavoratori(lavoratori);
		trony.setItems(items);
		
		centro.getNegozi().get(0).showItems();
		centro.getNegozi().get(0).showLavoratori();
		
		Item smartphone_2 = new Item("Smartphone_2","SS 2222000789",trony);
		trony.addToItems(commesso_1, smartphone_2);
		centro.getNegozi().get(0).showItems();
		
		trony.removeFromItems(commesso_2, lavatrice);
		centro.getNegozi().get(0).showItems();
		
		trony.removeFromItems(amministrativo, lavatrice);
		centro.getNegozi().get(0).showItems();
		
		Item notebook = new Item("Notebook", "NN 1111000789",trony);
		trony.addToItems("Matteo", notebook);
		centro.getNegozi().get(0).showItems();
		
		trony.removeFromItems(boss, "Frigorifero");
		centro.getNegozi().get(0).showItems();
		
		trony.removeFromItems(amministrativo, "Frigorifero");
		centro.getNegozi().get(0).showItems();
	}

}
