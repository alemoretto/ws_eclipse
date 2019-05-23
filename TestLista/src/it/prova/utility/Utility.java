package it.prova.utility;

public class Utility {

	public static Integer parseFromStringToInput(String s) {
		Integer result = null;
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			result = null;
		}		
		return result;
	}
	
}
