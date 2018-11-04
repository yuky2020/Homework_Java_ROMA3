package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	private String nome="fine";
	private String parametro;

	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
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
