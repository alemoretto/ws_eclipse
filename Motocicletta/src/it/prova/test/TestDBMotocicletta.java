package it.prova.test;

import java.util.List;

import javax.swing.JOptionPane;

import it.prova.dao.MotociclettaDao;
import it.prova.model.Motocicletta;

public class TestDBMotocicletta {

	public static void main(String[] args) {

		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao di motocicletta
		MotociclettaDao motociclettaDaoInstance = new MotociclettaDao();

		// prova SELECT *
		for (Motocicletta motociclettaItem : motociclettaDaoInstance.list()) {
			System.out.println(motociclettaItem);
		}

		// prova INSERT
//		Motocicletta motoNuova_1 = new Motocicletta("Aprilia","Dorsoduro 900",896);
//		motociclettaDaoInstance.insert(motoNuova_1);
//		insertMotociclettaByJOptionPane(motociclettaDaoInstance);

		// prova findAllByCilindrataMaggioreDi
		String cilindrataMinima = "1000";
		List<Motocicletta> motoMaggioridiX = motociclettaDaoInstance.findAllByCilindrataMaggioreDi(cilindrataMinima);
		System.out.println(motoMaggioridiX.size() + " record trovati");
		for (Motocicletta motocicletta : motoMaggioridiX) {
			System.out.println(motocicletta);
		}
		
		// cerca per Marca
		String marca = "";
		List<Motocicletta> motoDiUnaCertaMarca = motociclettaDaoInstance.findByMarcaCheContiene(marca);
		System.out.println(motoDiUnaCertaMarca.size() + " record trovati");
		for (Motocicletta motocicletta : motoDiUnaCertaMarca) {
			System.out.println(motocicletta);
		}
		
		
		// prova INSERT con GUI
//		insertMotociclettaByJOptionPane(motociclettaDaoInstance);
	}

	private static void insertMotociclettaByJOptionPane(MotociclettaDao motociclettaDaoInstance) {
		Motocicletta motociclettaNuovaDaInput = buildMotociclettaFromJoptionPane();
		if (motociclettaNuovaDaInput.getMarca() != null && motociclettaNuovaDaInput.getModello() != null
				&& motociclettaNuovaDaInput.getCilindrata() > 0) {
			motociclettaDaoInstance.insert(motociclettaNuovaDaInput);
			JOptionPane.showMessageDialog(null, "Hai inserito:\\n" + motociclettaNuovaDaInput);
		}
	}

	private static Motocicletta buildMotociclettaFromJoptionPane() {
		String marca = JOptionPane.showInputDialog("Marca ?");
		String modello = JOptionPane.showInputDialog("Modello ?");
		String cilindrata = JOptionPane.showInputDialog("Cilindrata ?");

		return new Motocicletta(marca, modello, Integer.parseInt(cilindrata));
	}
}
