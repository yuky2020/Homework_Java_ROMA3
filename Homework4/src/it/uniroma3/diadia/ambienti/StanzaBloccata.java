
package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO.InterfacciaUtente;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBloccata extends Stanza{
	
	private String direzioneLock;
	private String attrezzoUnlock;
	public InterfacciaUtente io;

	public StanzaBloccata(String nome, String chiave, String direzione,InterfacciaUtente io) {
		super(nome);
		this.attrezzoUnlock = chiave;
		this.direzioneLock = direzione;
		this.io=io;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(direzioneLock)) {
			if(super.getAttrezzo(attrezzoUnlock) == null) {
				io.mostraMessaggio("la direzione è bloccata, hai bisogno di : "+this.attrezzoUnlock);
				return this;
			}
		}
			return (super.getStanzaAdiacente(direzione));		
		}

	@Override 
	public String toString() {
		if(super.getAttrezzo(attrezzoUnlock) == null) {
			
			StringBuilder risultato = new StringBuilder();
			risultato.append(super.getNome());
			risultato.append("\n");
			risultato.append("La stanza ha una direzione bloccata: " +direzioneLock+" serve: "+attrezzoUnlock+" per sbloccare " );
			risultato.append("\n");
			risultato.append("Direzioni consentite: ");
			risultato.append(super.getDirezioni().toString().replace(direzioneLock, ""));
			
			risultato.append("\nAttrezzi nella stanza: ");
			for (Attrezzo a : super.getAttrezzi() ) {
				risultato.append(a.toString()+" ");
			}
			return risultato.toString();
			}
			else
				return super.toString();
	}
}
