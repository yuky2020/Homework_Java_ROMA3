package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String acceso;
	
	public StanzaBuia(String nome, String attrezzo) {
	    super(nome);
	    this.acceso = attrezzo;
	}

	@Override
	public String toString() {
		if (super.hasAttrezzo(acceso)) return super.toString();
		else return("Qui c'è buio pesto");
	}
}
