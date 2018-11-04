package it.uniroma3.diadia;

import it.uniroma3.diadia.IO.InterfacciaUtente;
import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
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

	
	final private int Max_livelli=4;
    private boolean finita;
	
	public Labirinto aule;
	private Giocatore uno;
	private Stanza StanzaCorrente;
	public InterfacciaUtente io=new InterfacciaUtenteConsole();
	private int livello=1;
	
	
	public Partita(InterfacciaUtente io) {
		SetLivello();
		this.finita = false;
		uno=new Giocatore();
		
		this.io=io;
	}
    
	
	public void SetLivello() {
		io.mostraMessaggio("benvenuto nell'"+this.livello+"* livello");
		this.aule=null;
		this.aule=new Labirinto("Labirinto"+this.livello+".txt", io);
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
	
	public Giocatore getGiocatore() {
		return this.uno;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		if (livello==Max_livelli)
		return this.getStanzaCorrente()== this.getStanzaVincente();
		
		else {if (this.getStanzaCorrente()==this.getStanzaVincente()) {
			  livello=livello+1;
			  io.mostraMessaggio("complimenti hai vinto questo livello");
		      SetLivello();}//qui setti il livello al successivo;
		return false;        }
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		if(finita || vinta())
			return true;
		if(this.getCfu() == 0) {
			io.mostraMessaggio("Hai esaurito i CFU!");
			return true;
		}
		return false;
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
