package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo> {
	
	public static class  nameComparator implements Comparator<Attrezzo>{

		@Override
		public int compare(Attrezzo uno, Attrezzo due) {
			return uno.getNome().compareTo(due.getNome());
		}
		
	}
	
	public static class pesoComparator implements Comparator<Attrezzo>{
		
		@Override
		public int compare(Attrezzo uno, Attrezzo due) {
			if (uno.getPeso() == due.getPeso())
				return (uno.getNome().compareTo(due.getNome()));
			else
			return uno.getPeso() - due.getPeso();
		}
	}
	
	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" : "+this.getPeso()+" kg ";
	}
	
	@Override
	public boolean equals(Object o) {
		Attrezzo that = (Attrezzo)o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public int compareTo(Attrezzo that) {
		return this.hashCode() - that.hashCode();
	}

	
}