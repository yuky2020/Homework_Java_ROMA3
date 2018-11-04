package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class abstractPersonaggio {
	private String nome;
	private String presentazione;
	private boolean haSalutato;

	public abstractPersonaggio(String nome, String presentaz) {
		this.nome = nome;
		this.presentazione = presentaz;
		this.haSalutato = false;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean haSalutato() {
		return this.haSalutato;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".\n");

		if (!haSalutato)	risposta.append(this.presentazione);	
		else				risposta.append("Ci siamo gia' presentati!");

		this.haSalutato = true;

		return risposta.toString();
	}

	abstract public String agisci(Partita partita);
	
	public String getPresentazione() {
		return this.presentazione;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	}


