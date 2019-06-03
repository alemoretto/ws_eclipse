package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	@Override
	public MateriaPrima get(int id) {
		for (MateriaPrima materiaItem : DbMock.MATERIE_PRIME) {
			if (materiaItem.getId() == id)
				return materiaItem;
		}
		return null;
	}

	public void update(MateriaPrima materiaPrima) {
		for (MateriaPrima materiaItem : DbMock.MATERIE_PRIME) {
			if (materiaItem.getId() == materiaPrima.getId())
				DbMock.MATERIE_PRIME.set(DbMock.MATERIE_PRIME.indexOf(materiaItem), materiaItem);
				return;
		}
		return;
	}
	
}
