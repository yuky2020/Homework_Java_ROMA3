package it.uniroma3.diadia.comandi;




import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends abstractComando {
	public ComandoPosa() {
		super("posa");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		String oggetto = super.getParametro();
		String messaggio = "La borsa è vuota";
		if(!partita.getGiocatore().getZaino().isEmpty()) {
			if (!partita.getGiocatore().getZaino().isEmpty() && this.getParametro() != null ){
				if(partita.getGiocatore().getZaino().hasAttrezzo(oggetto)) {
						Attrezzo add = partita.getGiocatore().getZaino().getAttrezzo(oggetto);
						partita.getStanzaCorrente().addAttrezzo(add);
						partita.getGiocatore().getZaino().removeAttrezzo(oggetto);		
						s.append("Oggetto Lasciato!");				
				}
				else s.append("Non c'è questo oggetto nella borsa");
			}
			if (!partita.getGiocatore().getZaino().isEmpty() && this.getParametro() == null ) {
				String stringap = partita.getGiocatore().getZaino().toString();
				s.append(stringap);
				
					
				}
			}
		
		else s.append(messaggio);
		return s.toString();
	}
	
}


