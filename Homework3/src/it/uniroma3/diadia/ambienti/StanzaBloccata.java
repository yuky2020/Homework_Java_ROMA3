
package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzioneLock;
	private String attrezzoUnlock;

	public StanzaBloccata(String nome, String chiave, String direzione) {
		super(nome);
		this.attrezzoUnlock = chiave;
		this.direzioneLock = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(direzioneLock)) {
			if(super.getAttrezzo(attrezzoUnlock) == null) {
				System.out.println("la direzione è bloccata, hai bisogno di "+this.attrezzoUnlock);
				return this;
			}
		}
			return (super.getStanzaAdiacente(direzione));		
		}

	@Override 
	public String toString() {
		return ("La stanza ha una direzione bloccata: " +direzioneLock+" serve: "+attrezzoUnlock+" per sbloccare " + super.getDescrizione());
	}
}
