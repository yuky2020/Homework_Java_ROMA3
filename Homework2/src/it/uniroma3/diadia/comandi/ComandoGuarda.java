package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private String nome="guarda";
	private String parametro;

	@Override
	public void esegui(Partita partita) {
		System.out.println("Stanza corrente: "+partita.getStanzaCorrente());
		System.out.println(partita.getGiocatore().getZaino().toString());	
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}

	
	@Override
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	@Override
	public String getParametro() {return this.parametro;}
	
	@Override
	public String getNome() {return this.nome ;}

	}


