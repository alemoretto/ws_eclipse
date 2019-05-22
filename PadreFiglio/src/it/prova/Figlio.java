package it.prova;

public class Figlio extends Padre {

	public void metodo1() {
		System.out.println("metodo figlio");
	}

	public int contaQuantiFigli(Padre[] arrPadre) {
		int result = 0;
		for (int i = 0; i < arrPadre.length; i++) {
			if (arrPadre[i] instanceof Figlio) {
				result++;
			}
		}
		return result;
	}
}
