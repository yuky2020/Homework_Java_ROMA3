package it.uniroma3.diadia.giocatore;

import java.util.*;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa(int pesoMax) {
		this.pesoMax= pesoMax;
		this.attrezzi = new HashMap<>();
		
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso()>this.getPesoMax())
			return false;
		
		attrezzi.put(attrezzo.getNome(), attrezzo);	
		return true;

	}
	
	public int getPesoMax() {
		return pesoMax;

	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		int peso=0;
		for(Attrezzo a : attrezzi.values())
			peso += a.getPeso();
		return peso;
		}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {

		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Preso il nome dell'attrezzo da rimuovere, il metodo elimina tale oggetto dalla
	 * borsa, spostando l'ultimo attrezzo dell'array nella posizione di quello
	 * desiderato, per poi eliminare l'ultima posizione dell'array diminuendone la lunghezza
	 * @param nomeAttrezzo
	 */
	public void removeAttrezzo(String nomeAttrezzo) {
		this.attrezzi.remove(nomeAttrezzo);
	}

	/**
	 * Questo metodo serve per poter stampare facilmente la lista di oggetti nella borsa
	 * senza dover scrivere il codice ogni volta che serve
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Peso Totale("+this.getPeso()+"kg): [");
			for(Attrezzo a : attrezzi.values())
				s.append( a.toString()+" ");
            s.append("]");		
		}
		else
			s.append("La borsa è vuota!");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		if (this.isEmpty()) 
			return null;
		else {
		List<Attrezzo> listaordinataperpeso = new ArrayList<>();
		listaordinataperpeso.addAll(this.attrezzi.values());
		listaordinataperpeso.sort(new Attrezzo.pesoComparator());
		return listaordinataperpeso;
		}
	}
	
	public boolean spazioPerNuoviAttrezzi() {
		return this.getPeso() < this.getPesoMax(); 
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoperNome(){
		if (this.isEmpty())
			return null;
		else {
		SortedSet<Attrezzo> attrezziOrdinatiPerNome = new TreeSet<>(new Attrezzo.nameComparator());
		attrezziOrdinatiPerNome.addAll(this.attrezzi.values());
		return attrezziOrdinatiPerNome;
		}
	}
	
	public SortedSet<Attrezzo> getSetOrdinatoPerPeso(){
		if (this.isEmpty())
			return null;
		else {
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso = new TreeSet<>(new Attrezzo.pesoComparator());
		attrezziOrdinatiPerPeso.addAll(this.attrezzi.values());
		return attrezziOrdinatiPerPeso;
		}
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		if (this.isEmpty())
		return null;
		else {
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		
		for(Attrezzo a : attrezzi.values()) {
			if (map.containsKey(a.getPeso()))
				map.get(a.getPeso()).add(a);
			else {
				Set<Attrezzo> set = new TreeSet<>(new Attrezzo.nameComparator());
				set.add(a);
				map.put( a.getPeso(), set );
			}
		}
		return map;
	}
	}	
}
