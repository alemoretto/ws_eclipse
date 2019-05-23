package it.prova.test;

import it.prova.*;

public class TestHotel_2 {

	public static void main(String[] args) {

		// creo le stanze
		Stanza s1 = new Stanza(101, 80);
		Stanza s2 = new Stanza(201, 90);
		Stanza s3 = new Stanza(301, 100);
		Stanza[] stanze = { s1, s2, s3 };

		Hotel hotel = new Hotel(stanze);
		//hotel.elencoStanze();
		
		// creo i clienti
		Cliente c1 = new Turista();
		Cliente c2 = new Turista();
		Cliente c3 = new Rappresentante();
		Cliente c4 = new Premio();
//		Cliente[] clienti = { c1, c2, c3, c4 };

		hotel.addToClienti(c1, 101);
		hotel.addToClienti(c2, 101);
		hotel.addToClienti(c3, 102);
		hotel.addToClienti(c4, 101);
		
		int nStanza = 101;
		System.out.println("Conto Stanza " + nStanza + " :  " + hotel.calcolaConto(nStanza) + " €");
	}

}
