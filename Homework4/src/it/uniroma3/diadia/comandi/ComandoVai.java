package it.uniroma3.diadia.comandi;



import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends abstractComando {
	
	public ComandoVai() {
		super("vai");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		String direzione = super.getParametro();
		if(direzione==null) {
			s.append("Dove vuoi andare ?");
			return s.toString();
		}	
		else {
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			s.append("Direzione inesistente");
		    return s.toString();}
		else {
			partita.setStanzaCorrente(prossimaStanza);		
			partita.setCfu(partita.getCfu()-1);
			s.append(partita.getStanzaCorrente().getDescrizione());
			return s.toString();
		}
		}
	}
}
