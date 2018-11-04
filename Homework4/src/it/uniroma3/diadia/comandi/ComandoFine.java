package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends abstractComando {
	
	public ComandoFine() {
		super("fine");
	}

	@Override
	public String esegui(Partita partita) {
		  // si desidera smettere
		partita.setFinita();
		return "Grazie di aver giocato!";
	}
}

