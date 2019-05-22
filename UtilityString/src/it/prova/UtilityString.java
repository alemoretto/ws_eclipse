package it.prova;

public class UtilityString {

	public static String stringaAlContrario(String input) {
		String result = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			result += input.charAt(i);
		}
		return result;
	}

	public static boolean isPalindroma(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean areEqualLunghezzeIEsime(String[] str1, String[] str2) {
		if (str1.length != str2.length) {
			return false;
		}
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].length() != str2[i].length()) {
				return false;
			}
		}
		return true;

	}

}
