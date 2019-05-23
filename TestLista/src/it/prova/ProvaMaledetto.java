package it.prova;

import javax.swing.JOptionPane;

import it.prova.utility.Utility;

public class ProvaMaledetto {

	public static void main(String[] args) {

//		String s = JOptionPane.showInputDialog("Dammi la stringa");
//		JOptionPane.showMessageDialog(null, "Hai inserito "  + s);

//		String nome = JOptionPane.showInputDialog("Nome?");
//		String cognome = JOptionPane.showInputDialog("Cognome?");
//		Persona persona = new Persona(nome, cognome);
//		JOptionPane.showMessageDialog(null, "Hai creato: \n " + persona.toString());
		// ___________________________________________________

		String strInput = "";
		Integer parsed = null;
//		int exitCondition = 0;
//		while (parsed == null && exitCondition != 2) {
		while (parsed == null && strInput!= null) {
			strInput = JOptionPane.showInputDialog("Inserisci l'intero ");
			parsed = Utility.parseFromStringToInput(strInput);
//			JOptionPane.
//			exitCondition = JOptionPane.CANCEL_OPTION;
		}
		if (parsed != null)
			JOptionPane.showMessageDialog(null, "Hai inserito " + parsed);

	}

}
