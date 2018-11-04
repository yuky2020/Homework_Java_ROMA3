package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;

public class ComandoRegala extends abstractComando{	
  public ComandoRegala() {
		super("regala");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		if(partita.getStanzaCorrente().getPersonaggio()!=null) {
		if(super.getParametro()!=null) {
			if(partita.getGiocatore().getZaino().hasAttrezzo(super.getParametro())) {
				s.append(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita.getGiocatore().getZaino().getAttrezzo(this.getParametro()), partita));
				partita.getGiocatore().getZaino().removeAttrezzo(super.getParametro());
			}
			else s.append("Non hai un attrezzo chiamato "+ super.getParametro());
		}
		else {
			if(!partita.getGiocatore().getZaino().isEmpty()) {
				s.append("Che cosa vorresti regalare?");
				
				s.append(partita.getGiocatore().getZaino().toString());
				
			}
			else s.append("La borsa è vuota!");
		}
		
	}
		else s.append("Non c'è nessuno qui...");
		return s.toString();
}
}
