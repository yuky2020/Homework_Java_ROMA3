package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends abstractComando {
	
	public ComandoSaluta() {
		super("saluta");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		if(partita.getStanzaCorrente().getPersonaggio() != null)
			s.append(partita.getStanzaCorrente().getPersonaggio().saluta());
		else s.append("Non c'è nessuno da salutare");
		return s.toString();
	}

}
