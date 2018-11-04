package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

    private boolean finita;
	
	public Labirinto aule;
	public Giocatore uno;
	public Stanza StanzaCorrente;
	
	
	public Partita(){
		aule=new Labirinto();
		this.finita = false;
		uno=new Giocatore();
		this.StanzaCorrente=aule.getIngresso();
	}

	public Stanza getStanzaVincente() {
		return this.aule.uscita;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.StanzaCorrente=stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.StanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (uno.cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.uno.cfu;
	}

	public void setCfu(int cfu) {
		this.uno.cfu = cfu;		
	}	
}
