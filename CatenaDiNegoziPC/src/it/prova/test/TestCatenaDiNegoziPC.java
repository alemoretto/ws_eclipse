package it.prova.test;

import it.prova.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class TestCatenaDiNegoziPC {

	public static void main(String[] args) {

		// ###################################################################################à
		// setup di tutti gli oggetti necessari al test

		// schede madri
		Componente sm_wtx = new SchedaMadre("SM111", "WTX");
		Componente sm_at = new SchedaMadre("SM222", "AT");
		Componente sm_epic = new SchedaMadre("SM333", "EPIC");

		// processori
		Componente proc_intel = new Processore("PR111", "Intel i5");
		Componente proc_ryzen = new Processore("PR222", "AMD Ryzen");
		Componente proc_athlon = new Processore("PR333", "AMD Athlon");
		Componente proc_intel2 = new Processore("PR444", "Intel i7");

		// assemblo i pc
		PC pc_hp = new PC("HP", "PC111", sm_at, proc_athlon);
		PC pc_toshiba = new PC("Toshiba", "PC222", sm_wtx, proc_athlon);
		PC pc_lenovo = new PC("Lenovo", "PC333", sm_epic, proc_ryzen);
		PC pc_asus = new PC("Asus", "PC444", sm_wtx, proc_intel);
		PC pc_acer = new PC("Acer", "PC555", sm_epic, proc_intel);
		PC pc_dell = new PC("Dell", "PC666", sm_epic, proc_athlon);

		// creo i punti vendita con i rispettivi cataloghi di pc
		Negozio negozio_pigneto = new Negozio("Computer Discount Pigneto", "48128401011",
				new ArrayList<>(Arrays.asList(pc_hp, pc_toshiba, pc_asus, pc_dell)));
		Negozio negozio_eur = new Negozio("Computer Discount EUR", "94879429466",
				new ArrayList<>(Arrays.asList(pc_toshiba, pc_asus, pc_acer, pc_lenovo)));

		// creo catena di negozi
		CatenaDiNegoziPC catena = new CatenaDiNegoziPC("Computer Discount",
				new ArrayList<>(Arrays.asList(negozio_pigneto, negozio_eur)));

		// ###################################################################################
		// TEST

		String matricolaOggettoDifettoso = "";
		int continua = 0;
		do {
			// stampo i cataloghi dei punti vendita
			String inputMessage = ">>>  Catena COMPUTER DISCOUNT  <<<\n\n";
			inputMessage += negozio_pigneto + "\n" + negozio_eur + "\n\n";
			inputMessage += "Inserisci il numero di matricola di Componente o PC :  ";

			matricolaOggettoDifettoso = JOptionPane.showInputDialog(inputMessage,
					"ad es:   PR111,   SM222,   PC333...");

			/*
			 * Ogni oggetto Ritiro in lista contiene: - i negozi da contattare - i prodotti
			 * da ritirare
			 */
			List<Ritiro> ritiri = catena.ritiraProdottiPerDifetto(matricolaOggettoDifettoso);

			if (matricolaOggettoDifettoso != null) {
				String outputMessage = "Hai cercato il prodotto con matricola:  " + matricolaOggettoDifettoso + "\n\n";

				if (ritiri.size() > 0) {
					outputMessage += "Prodotto:  " + catena.matricolaToObject(matricolaOggettoDifettoso) + ".\n\n";
					outputMessage += "Contattare i seguenti punti vendita:\n\n";
					for (Ritiro riparazione : ritiri) {
						outputMessage += riparazione + "\n";
					}
				} else
					outputMessage += "\nNon ci sono articoli corrispondenti ai criteri di ricerca\n";

				continua = JOptionPane.showConfirmDialog(null, outputMessage + "\nVuoi effettuare un'altra ricerca?",
						"Risultati della ricerca", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}

		} while (continua == JOptionPane.YES_OPTION && matricolaOggettoDifettoso != null);
	}
}