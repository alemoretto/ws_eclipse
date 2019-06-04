package it.prova.service;

import org.springframework.stereotype.Component;

@Component
public class CheckUpServiceImpl implements CheckUpService {

//	@Autowired
//	private EmatologoService ematologoService;
//	@Autowired
//	private CardiologoService cardiologoService;
//	@Autowired
//	private OrtopedicoService ortopedicoService;
//	@Autowired
//	private MedicoGenericoService medicoGenericoService;
	
	@Override
	public void iniziaCheckUpCompleto() {
		System.out.println("Inizia il controllo medico...");
//		ematologoService.analizzaAnalisiDelSangue();
//		cardiologoService.controllaElettrocardiogramma();
//		ortopedicoService.osservaLeLastre();
//		medicoGenericoService.daiIlResponso();
		System.out.println("Il controllo medico è finito");
		
	}
	
//	public EmatologoService getEmatologoService() {
//		return ematologoService;
//	}
//	public void setEmatologoService(EmatologoService ematologoService) {
//		this.ematologoService = ematologoService;
//	}
//	public CardiologoService getCardiologoService() {
//		return cardiologoService;
//	}
//	public void setCardiologoService(CardiologoService cardiologoService) {
//		this.cardiologoService = cardiologoService;
//	}
//	public OrtopedicoService getOrtopedicoService() {
//		return ortopedicoService;
//	}
//	public void setOrtopedicoService(OrtopedicoService ortopedicoService) {
//		this.ortopedicoService = ortopedicoService;
//	}
//	public MedicoGenericoService getMedicoGenericoService() {
//		return medicoGenericoService;
//	}
//	public void setMedicoGenericoService(MedicoGenericoService medicoGenericoService) {
//		this.medicoGenericoService = medicoGenericoService;
//	}
	
	
	
}
