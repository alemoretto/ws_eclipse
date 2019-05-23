package it.prova.test;

import it.prova.*;

public class TestHotel {

	public static void main(String[] args) {

		// creo le stanze
		Stanza s1 = new Stanza(101, 80);
		Stanza s2 = new Stanza(201, 90);
		Stanza s3 = new Stanza(301, 100);
		Stanza[] stanze = { s1, s2, s3 };

		// creo i clienti
		Cliente c1 = new Turista("Tt", s1);
		Cliente c2 = new Turista("Tt", s1);
		Cliente c3 = new Rappresentante("Rr", s1);
		Cliente c4 = new Premio("Pp", s1);
		Cliente[] clienti = { c1, c2, c3, c4 };

		Hotel hotel = new Hotel(stanze);
		//hotel.elencoStanze();

		s1.setClienti(clienti);
		
		System.out.println("Conto Stanza " + s1.getNStanza() + " :  " + hotel.calcolaConto(s1) + " €");
		
//		System.out.println("Conto Stanza " + s1.getNStanza() + " :  " + hotel.calcolaConto(101) + " €");
	}

}
