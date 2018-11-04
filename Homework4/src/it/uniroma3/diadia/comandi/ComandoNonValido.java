package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends abstractComando {
	
	public ComandoNonValido() {
		super("comando non valido");
	}

	@Override
	public String esegui(Partita partita) {
		return"Comando non valido";

	}
}
