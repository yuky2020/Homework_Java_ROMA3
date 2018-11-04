package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.attrezzi.AtrezzoNomeComparator;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	private Set<Attrezzo> Attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa(int pesoMax) {
		this.pesoMax= pesoMax;
		this.Attrezzi = new HashSet<>();
		
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso()>this.getPesoMax())
			return false;
		Attrezzi.add(attrezzo);
		
		return true;

	}
	
	public int getPesoMax() {
		return pesoMax;

	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	Attrezzo a= new Attrezzo(nomeAttrezzo,1);
	if(Attrezzi.contains(a)) return a;
		
		return null;
		
		}

	public int getPeso() {
		int peso=0;
		Iterator<Attrezzo> i = this.Attrezzi.iterator();
		while(i.hasNext())peso=peso+i.next().getPeso();
		return peso;}

	public boolean isEmpty() {
		return this.numeroAttrezzi==0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {

		return this.Attrezzi.contains(new Attrezzo(nomeAttrezzo,0));
	}

	/**
	 * Preso il nome dell'attrezzo da rimuovere, il metodo elimina tale oggetto dalla
	 * borsa, spostando l'ultimo attrezzo dell'array nella posizione di quello
	 * desiderato, per poi eliminare l'ultima posizione dell'array diminuendone la lunghezza
	 * @param nomeAttrezzo
	 */
	public void removeAttrezzo(String nomeAttrezzo) {	
		Iterator<Attrezzo> i = this.Attrezzi.iterator();
		while(i.hasNext())
			if(i.next().getNome().equals(nomeAttrezzo)) i.remove(); 			
			}
	

	/**
	 * Questo metodo serve per poter stampare facilmente la lista di oggetti nella borsa
	 * senza dover scrivere il codice ogni volta che serve
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Contenuto borsa("+this.getPeso()+"kg): ");
			Iterator<Attrezzo> i = this.Attrezzi.iterator();
			while(i.hasNext())s.append( i.next().toString()+" ");
		}
		else
			s.append("La borsa è vuota!");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziordinatiperpeso= new ArrayList<>(this.Attrezzi);
		Collections.sort(attrezziordinatiperpeso);
		return attrezziordinatiperpeso;
	}
	public boolean spazioPerNuoviAttrezzi() {

		return this.getPeso() < this.getPesoMax(); 
	}

	public SortedSet<Attrezzo> getContenutoordinatopernome(){
		SortedSet<Attrezzo> attrezziOrdinatiPerNome = new TreeSet<>(new AtrezzoNomeComparator());
		attrezziOrdinatiPerNome.addAll(this.Attrezzi);
		return attrezziOrdinatiPerNome;
	}
	public SortedSet<Attrezzo> getSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso = new TreeSet<>();
		attrezziOrdinatiPerPeso.addAll(this.Attrezzi);
		return attrezziOrdinatiPerPeso;
	}
	
	
}
