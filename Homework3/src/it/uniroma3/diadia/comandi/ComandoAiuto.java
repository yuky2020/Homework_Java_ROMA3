package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private String[] elencoComandi;
	private String nome= "aiuto" ;
	private String parametro;
	
	
	
	public ComandoAiuto (String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
	}

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();

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
