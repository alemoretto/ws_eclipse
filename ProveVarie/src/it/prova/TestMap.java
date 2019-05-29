package it.prova;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestMap {
	
	public static void main(String[] args) {

		
		Map<String, Integer> rubrica = new HashMap<String, Integer>();
		rubrica.put("mario", 24948);
		rubrica.put("vittorio", 42342);
		rubrica.put("matteo", 19912);
		rubrica.put("francesco", 85772);
		rubrica.put("piero", 55115);
		
		System.out.println("HASH MAP:");
		System.out.println(rubrica);
//		System.out.println("KEYS:");
//		rubrica.keySet().forEach(keys -> System.out.println(keys));
//		System.out.println("VALUES:");
//		rubrica.values().forEach(keys -> System.out.println(keys));
		
		System.out.println("...............\nProva GET BY KEY");
		String nome = "francesco";
		System.out.println("il numero di " + nome + " è " + rubrica.get(nome));
		
		System.out.println("...............\nKEY to SET");
		Set<String> chiavi = rubrica.keySet();
		chiavi.forEach(k -> System.out.println(k));
		
		System.out.println("...............\nVALUES to COLLECTION");
		Collection<Integer> valori = rubrica.values();
		valori.forEach(v -> System.out.println(v));
		
		Map<String, Integer> rubricaT = new TreeMap<String, Integer>();
		rubricaT.putAll(rubrica);
		
		System.out.println("....................................");
		System.out.println("TREE MAP:");
		System.out.println(rubricaT);
		
		System.out.println("rimuovo mario");
		rubrica.remove("mario");
		System.out.println(rubrica);
		
		System.out.println("##############################################################");
		Punto p1 = new Punto(3,1);
		Punto p2 = new Punto(1,1);
		Punto p3 = new Punto(3,4);
		Punto p4 = new Punto(0,0);
		Punto p5 = new Punto(2,3);
		Punto p6 = p4;
		Punto p7 = new Punto(1,1);
		Map<Punto, String> punti = new HashMap<Punto,String>();
		punti.put(p1, "primo");
		punti.put(p2, "secondo");
		punti.put(p3, "terzo");
		punti.put(p4, "quarto");
		punti.put(p5, "quinto");
		System.out.println("HASH MAP:");
		System.out.println(punti);
		
		Map<Punto, String> puntiT = new TreeMap<Punto,String>();
		puntiT.putAll(punti);
		System.out.println("TREE MAP:");
		System.out.println(puntiT);
	}
	
}
