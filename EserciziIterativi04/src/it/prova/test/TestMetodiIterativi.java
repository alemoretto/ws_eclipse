package it.prova.test;

import it.prova.MetodiIterativi;

public class TestMetodiIterativi {

	public static void main(String[] args) {

		// TEST creaUnione
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 6, 7, 8 };

		int[] arrUnione = MetodiIterativi.creaUnione(arr1, arr2);

		System.out.println("TEST creaUnione");
		for (int i = 0; i < arrUnione.length; i++) {
			System.out.println(arrUnione[i]);
		}

		// TEST calcolaScalare
		int[] arr = { 1, 2, 3, 4, 5 };
		int n = 3;

		int[] arrScalare = MetodiIterativi.calcolaScalare(arr, n);

		System.out.println("TEST calcolaScalare");
		for (int i = 0; i < arrScalare.length; i++) {
			System.out.println(arrScalare[i]);
		}

		// TEST calcolaScalare
		int[] arrInput = { 1, 2, 3, 4, 5 };

		System.out.println("TEST calcolaScalare");
		if (MetodiIterativi.verificaMaggioreSuccessivo(arrInput)) {
			System.out.println("Array con elementi in ordine decrescente");
		} else {
			System.out.println("Array con elementi in ordine crescente");
		}

	}

}
