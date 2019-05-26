package it.prova.model;

public class Motocicletta {
	private Long id;
	private String marca;
	private String modello;
	private int cilindrata;

	public Motocicletta() {
	}

	public Motocicletta(String marca, String modello, int cilindrata) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	@Override
	public String toString() {
		return "Motocicletta [id=" + id + ", marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

}
