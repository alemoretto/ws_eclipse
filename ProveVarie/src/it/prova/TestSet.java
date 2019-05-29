package it.prova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSet {
	
	public static void main(String[] args) {

		Punto p1 = new Punto(3,1);
		Punto p2 = new Punto(1,1);
		Punto p3 = new Punto(3,4);
		Punto p4 = new Punto(0,0);
		Punto p5 = new Punto(2,3);
		Punto p6 = p4;
		Punto p7 = new Punto(1,1);
		List<Punto> list = new ArrayList<Punto>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		System.out.println("Ordine iniziale");
		list.forEach(p -> System.out.println(p));
	
		Set<Punto> hashSet = new HashSet<Punto>();
		hashSet.addAll(list);
		System.out.println("HashSet");
		hashSet.forEach(p -> System.out.println(p));
		
		Set<Punto> treeSet = new TreeSet<Punto>();
		treeSet.addAll(list);
		System.out.println("TreeSet");
		treeSet.forEach(p -> System.out.println(p));	
		
	
	}
	
}
