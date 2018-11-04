package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class abstractComando implements Comando {
		private String nome;
		private String parametro;
		
	public abstractComando (String nome) {
		this.nome = nome;
		this.parametro = null;
	}
		
	@Override
	public abstract String esegui(Partita partita);
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
}
