package it.prova;

import java.util.*;
import it.prova.utility.*;

public class TestLista {

	public static void main(String[] args) {

		switch(1) {
		
		case 1:
			// *********************************************************
			// test esiste

			List<String> listaColori = Arrays.asList("verde", "giallo", "rosso", "blu");
			String coloreDaCercare = "rosso";
listaColori.add("bianco");
			if (esiste(listaColori, coloreDaCercare))
				System.out.println("trovato");

			break;

		case 2:
			// *********************************************************
			// test contaPersoneConIniziale

			List<Persona> listaPersone = Arrays.asList(new Persona("Mario"), new Persona("Francesco"),
					new Persona("Matteo"));
			char inizialeDaCercare = 'M';
			System.out.println("Ci sono " + contaPersoneConIniziale(listaPersone, inizialeDaCercare)
					+ " persone il cui nome inizia per " + inizialeDaCercare);

			Persona persona = new Persona("Franco");
			System.out.println(persona);
			break;
			

		} // switch
	}

	public static boolean esiste(List<String> listaInput, String daCercare) {
		for (String string : listaInput) {
			if (string.equals(daCercare)) {
				return true;
			}
		}
		return false;
	}

	public static int contaPersoneConIniziale(List<Persona> listaInput, char iniziale) {
		int result = 0;
		for (Persona persona : listaInput) {
			if (persona.getNome().charAt(0) == iniziale) {
				result++;
			}
		}
		return result;
	}
}
