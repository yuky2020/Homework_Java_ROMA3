package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends abstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "lascia", "guarda", "saluta", "interagisci", "regala"};
	
	public ComandoAiuto() {
		super("aiuto");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+" ");
	return s.toString();
	}
}
