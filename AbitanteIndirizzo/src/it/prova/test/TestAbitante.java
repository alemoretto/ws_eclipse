package it.prova.test;

import it.prova.*;

public class TestAbitante {

	public static void main(String[] args) {
		Abitante ab = new Abitante("Mario", new Indirizzo("Roma", "via Mosca", "52"));
		System.out.println(ab.getNome());

	}

}
