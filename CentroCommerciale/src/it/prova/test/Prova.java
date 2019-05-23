package it.prova.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//String[] arr = {"a","b","c"};

//		List<String> lista = Arrays.asList("a","b","c");
		List<String> lista = new ArrayList<>(Arrays.asList("a","b","c"));
//		lista.addAll(Arrays.asList("a","b","c"));
		lista.add("d");
		for(String s:lista)
		System.out.println(s);
		
		
	}

}
