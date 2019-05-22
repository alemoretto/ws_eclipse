package it.prova.test;

import it.prova.UtilityString;

public class TestUtilityString {

	public static void main(String[] args) {

		String stringProva = "Stringa di prova in Eclipse";
		
		System.out.println("__________________________________________");
		System.out.println("test stringaAlContrario");
		System.out.println(UtilityString.stringaAlContrario(stringProva));
		
		String palindromo = "itopinonavevanonipoti";
		
		System.out.println("__________________________________________");
		System.out.println("test isPalindroma");
		System.out.println(UtilityString.isPalindroma(palindromo));
		
	}

}
