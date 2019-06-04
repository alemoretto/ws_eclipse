package it.prova.dao;

import org.springframework.stereotype.Component;

@Component
public class CheckUpDAOImpl implements CheckUpDAO {

	@Override
	public void stampa() {
		System.out.println("ciao");
	}
	
}
