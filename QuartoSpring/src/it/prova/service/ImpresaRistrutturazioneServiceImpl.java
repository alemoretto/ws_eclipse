package it.prova.service;

public class ImpresaRistrutturazioneServiceImpl implements
		ImpresaRistrutturazioneService {

	private IdraulicoService idraulicoService;
	private MuratoreService muratoreService;
	private ElettricistaService elettricistaService;
	private ImbianchinoService imbianchinoService;
	
	@Override
	public void ristrutturaAppartamento() {
		System.out.println("Inizio ristrutturazione....");
		idraulicoService.disponiTubi();
		muratoreService.costruisciPareti();
		elettricistaService.disponiCavi();
		imbianchinoService.imbianca();
		System.out.println("Termine ristrutturazione....");
	}

	public IdraulicoService getIdraulicoService() {
		return idraulicoService;
	}

	public void setIdraulicoService(IdraulicoService idraulicoService) {
		this.idraulicoService = idraulicoService;
	}

	public MuratoreService getMuratoreService() {
		return muratoreService;
	}

	public void setMuratoreService(MuratoreService muratoreService) {
		this.muratoreService = muratoreService;
	}

	public ElettricistaService getElettricistaService() {
		return elettricistaService;
	}

	public void setElettricistaService(ElettricistaService elettricistaService) {
		this.elettricistaService = elettricistaService;
	}

	public ImbianchinoService getImbianchinoService() {
		return imbianchinoService;
	}

	public void setImbianchinoService(ImbianchinoService imbianchinoService) {
		this.imbianchinoService = imbianchinoService;
	}

	
}
