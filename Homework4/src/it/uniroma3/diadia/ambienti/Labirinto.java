package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.IO.InterfacciaUtente;


public class Labirinto {
	public Stanza ingresso;
	public Stanza uscita;
	
	public Labirinto(String nomeFile, InterfacciaUtente io)  { 
		CaricatoreLabirinto c;
		try {
			c = new CaricatoreLabirinto(nomeFile);
			try {
				c.carica(io);
				this.ingresso = c.getStanzaIniziale(); 
				this.uscita = c.getStanzaVincente();
			} catch (FormatoFileNonValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 }
	
	
	public Stanza getIngresso() {
		return ingresso;
	}
	public void setIngresso(Stanza ingresso) {
		this.ingresso = ingresso;
	}
	public Stanza getUscita() {
		return uscita;
	}
	public void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}
	


}
