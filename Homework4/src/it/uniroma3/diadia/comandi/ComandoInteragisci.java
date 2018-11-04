package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.abstractPersonaggio;

public class ComandoInteragisci extends abstractComando {

	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	private String messaggio;
	
	public ComandoInteragisci() {
		super("interagisci");
	}

	@Override
	public String esegui(Partita partita) {
		abstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			return this.messaggio;

		} return MESSAGGIO_CON_CHI;
	}

}
