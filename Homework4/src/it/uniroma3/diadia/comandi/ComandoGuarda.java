package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends abstractComando  {
	
	public ComandoGuarda() {
		super("guarda");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		s.append("Stanza corrente: "+partita.getStanzaCorrente().toString());
		s.append("\nCFU: ");
		for(int i= 0; i< partita.getCfu(); i++) {
		s.append("*");
		}
		s.append("\nContenuto della borsa: "+partita.getGiocatore().getZaino().toString());
		if(partita.getStanzaCorrente().getPersonaggio()!= null) s.append("\nSembra esserci qualcuno...");
		return s.toString();
	}
}


