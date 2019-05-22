package it.prova;

public class Padre {

	protected String nome;

	public Padre() {
	}

	public void metodo1() {
		System.out.println("metodo padre");
	}

	public int contaQuantiPadri(Padre[] arrPadre) {
		int result = 0;
		for (int i = 0; i < arrPadre.length; i++) {
			if (arrPadre[i] instanceof Padre) {
				result++;
			}
		}
		return result;
	}
}
