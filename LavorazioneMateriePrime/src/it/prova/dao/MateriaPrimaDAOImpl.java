package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {
	
//	void insert(MateriaPrima materiaPrima) {
//		
//		
//	}
	
	public MateriaPrima get(int id) {
		DbMock.MATERIE_PRIME.get(0);
//		for (MateriaPrima materiaItem : DbMock.MATERIE_PRIME) {
//			if(materiaItem.getId() == id)
//				return materiaItem;
//		}
		return null;
	}

}
