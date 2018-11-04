package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	private String nome="Vai";
	private String direzione;

	@Override
	public void esegui(Partita partita) {
		if(this.direzione==null)
			System.out.println("Dove vuoi andare ?");
		else {
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getCfu();
			partita.setCfu(cfu--);
		}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}
	
	
	
	@Override
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	@Override
	public String getParametro() {return this.direzione;}
	
	@Override
	public String getNome() {return this.nome ;}

}
