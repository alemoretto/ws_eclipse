package it.prova;

public class MetodiIterativi {
	public static int[] creaUnione(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int pos = 0;

		for (int i = 0; i < arr1.length; i++) {
			result[pos++] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			result[pos++] = arr2[i];
		}

		return result;
	}

	public static int[] calcolaScalare(int[] arrInput, int n) {
		for (int i = 0; i < arrInput.length; i++) {
			arrInput[i] *= n;
		}
		return arrInput;
	}

	public static boolean verificaMaggioreSuccessivo(int[] input) {
		for (int i = 1; i < input.length; i++) {
			if (input[i] <= input[i - 1]) {
				return false;
			}
		}
		return true;
	}

}
