package it.miopackage.jdbc;

import java.util.ArrayList;
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
		
		
		Abitante abitante = abitanteDAOInstance.selectJoinById(1L);
		
		System.out.println(abitante);
		
		
		indirizzoDAOInstance.insert(new Indirizzo("Roma","Via dei venti","87"));
		
		abitante = new Abitante("giorgio","bianchi",77);
		abitante.setIndirizzo(new Indirizzo("Cuneo","Via dei sorci","10"));
		abitanteDAOInstance.insertCompleto(abitante);
		
		System.out.println("Situazione sul db....");
		for (Abitante abitanteItem : abitanteDAOInstance.list()) {
			System.out.println(abitanteItem);
		}
		
		System.out.println("*****************PROVA BATCH******************");
		List<Indirizzo> listaNuoviIndirizzi = new ArrayList<Indirizzo>();
		listaNuoviIndirizzi.add(new Indirizzo("Ancona","Via dei sorci","45"));
		listaNuoviIndirizzi.add(new Indirizzo("Bari","Via dei sorci","41L"));
		indirizzoDAOInstance.insertBatch(listaNuoviIndirizzi);
		
		System.out.println("*****************PROVA GET LAST ID******************");
		Long lastId = indirizzoDAOInstance.insertIndirizzoObtainingLastId(new Indirizzo("Modena","Via dei mille","l145"));
		System.out.println(lastId);
	}
}
