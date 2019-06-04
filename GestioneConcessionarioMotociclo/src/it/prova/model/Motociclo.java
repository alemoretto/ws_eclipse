package it.prova.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "motociclo")
public class Motociclo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String marca;
	private String modello;
	private int cilindrata;
	private int immatricolazione;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "concessionario_id", nullable = false)
	private Concessionario concessionario;
	
	public Motociclo() {
		
	}

	public Motociclo(Long id, String marca, String modello, int cilindrata, int immatricolazione,
			Concessionario concessionario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.immatricolazione = immatricolazione;
		this.concessionario = concessionario;
	}

	public Motociclo(String marca, String modello, int cilindrata, int immatricolazione,
			Concessionario concessionario) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.immatricolazione = immatricolazione;
		this.concessionario = concessionario;
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

	public int getImmatricolazione() {
		return immatricolazione;
	}

	public void setImmatricolazione(int immatricolazione) {
		this.immatricolazione = immatricolazione;
	}

	public Concessionario getConcessionario() {
		return concessionario;
	}

	public void setConcessionario(Concessionario concessionario) {
		this.concessionario = concessionario;
	}
	
	
	
	
	
}
