package it.prova;

public class Raccoglitore {

	private String colore;
	private int spessore;
	private Foglio[] fogli;

	public Raccoglitore() {
	}

	public Raccoglitore(Foglio[] fogli) {
//		fogli = new Foglio[numeroFogli];
		this.fogli = fogli;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getSpessore() {
		return spessore;
	}

	public void setSpessore(int spessore) {
		this.spessore = spessore;
	}

	public Foglio[] getFogli() {
		return fogli;
	}

	public void setFogli(Foglio[] fogli) {
		this.fogli = fogli;
	}

	public void addToFogli(Foglio f) {
		if (fogli == null) {
			fogli = new Foglio[1];
			fogli[0] = f;
			return;
		}
		Foglio[] temp = new Foglio[fogli.length + 1];
		for (int i = 0; i < temp.length - 1; i++) {
			temp[i] = fogli[i];
		}
		temp[temp.length - 1] = f;
		fogli = new Foglio[temp.length];
		fogli = temp;
	}

	public void removeFromFogli(int indexToRemove) {
		if (fogli == null || indexToRemove < 0 || indexToRemove > fogli.length - 1)
			return;
		Foglio[] temp = new Foglio[fogli.length - 1];
		int j = - 1;
		for (int i = 0; i < fogli.length; i++) {
			if (i == indexToRemove)
				continue;
			j++;
			temp[j] = fogli[i];
		}
		fogli = temp;
	}
}