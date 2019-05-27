package it.miopackage.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.miopackage.jdbc.dao.AbitanteDAO;
import it.miopackage.jdbc.dao.IndirizzoDAO;
import it.miopackage.jdbc.model.Abitante;
import it.miopackage.jdbc.model.Indirizzo;

public class TestDB {

	public static void main(String[] args) {
		System.out.println("Inizio....");
		//questi servono solo per invocare
		AbitanteDAO abitanteDAOInstance = new AbitanteDAO();
		IndirizzoDAO indirizzoDAOInstance = new IndirizzoDAO();
		
					/*		
		System.out.println("Tutti gli abitanti");
		for (Abitante abitanteItem : abitanteDAOInstance.list()) {
			System.out.println(abitanteItem);
		}
		
		System.out.println("Find By INIZIALE");
		for (Abitante abitanteItem : abitanteDAOInstance.findAllNomeByIniziale("M")) {
			System.out.println(abitanteItem);
		}
		
		System.out.println("Find By CITTA");
		for (Abitante abitanteItem : abitanteDAOInstance.findByCitta("Roma")) {
			System.out.println(abitanteItem);
		}
		
		System.out.println("Find By INDIRIZZO");
		Indirizzo indirizzoInput = new Indirizzo ("Roma", "Via Cavour", "81");
		Abitante abitRomaCavour = abitanteDAOInstance.findByIndirizzo(indirizzoInput);
		System.out.println(abitRomaCavour);
		
		System.out.println("Find ALL BY VIA AND CITTA");
		for (Indirizzo indItem : indirizzoDAOInstance.findAllByViaAndCitta("Roma","via Cavour")) {
			System.out.println(indItem);
		}
		*/
		
		System.out.println("INSERT COMPLETO");
		Indirizzo indPrato = new Indirizzo("Prato","via dei Cinesi","100");
		Abitante cinese1 = new Abitante("nomeCIN1","cogn CIN 1",12,indPrato);
		Abitante cinese2 = new Abitante("nomeCIN2","cogn CIN1",23,indPrato);
		Abitante cinese3 = new Abitante("nomeCIN3","cogn CIN 1",44,indPrato);
//		abitanteDAOInstance.insertCompleto(cinese1);
//		abitanteDAOInstance.insertCompleto(cinese2);
//		abitanteDAOInstance.insertCompleto(cinese3);

		List<Abitante> abitPratoCivico100 = abitanteDAOInstance.findByCitta("Prato");
		for (Abitante abitante : abitPratoCivico100) {
			abitante.setIndirizzo(null);
			abitanteDAOInstance.update(abitante);
		}
		indirizzoDAOInstance.delete(indirizzoDAOInstance.selectById(23L));

				
//		List<Abitante> abitantiDiPrato = abitanteDAOInstance.findByCitta("Prato");
//		for (Abitante abitante : abitantiDiPrato) {
//			abitante.setIndirizzo(null);
//		}
		
//		System.out.println("DELETE INDIRIZZO");
//		Indirizzo indirizzoDaCancellare = new Indirizzo ("Roma", "Via Cavour", "81");
//		Abitante abitRomaCavour = abitanteDAOInstance.findByIndirizzo(indirizzoInput);
		
		
		
		
//		System.out.println("*****************PROVA BATCH******************");
//		List<Indirizzo> listaNuoviIndirizzi = new ArrayList<Indirizzo>();
//		listaNuoviIndirizzi.add(new Indirizzo("Ancona","Via dei sorci","45"));
//		listaNuoviIndirizzi.add(new Indirizzo("Bari","Via dei sorci","41L"));
//		indirizzoDAOInstance.insertBatch(listaNuoviIndirizzi);
//		
//		System.out.println("*****************PROVA GET LAST ID******************");
//		Long lastId = indirizzoDAOInstance.insertIndirizzoObtainingLastId(new Indirizzo("Modena","Via dei mille","l145"));
//		System.out.println(lastId);
	}
}
