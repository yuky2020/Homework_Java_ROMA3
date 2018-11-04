package it.uniroma3.diadia.giocatore;

import java.util.*;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	private List<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa(int pesoMax) {
		this.pesoMax= pesoMax;
		this.attrezzi = new ArrayList<>();
		
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso()+attrezzo.getPeso()>this.getPesoMax())
			return false;
		
		attrezzi.add(attrezzo);	
		return true;

	}
	
	public int getPesoMax() {
		return pesoMax;

	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	Attrezzo a= new Attrezzo(nomeAttrezzo,1);
	if(attrezzi.contains(a)) 
		return attrezzi.get(attrezzi.indexOf(a));	
	
	return null;
		
	}

	public int getPeso() {
		int peso=0;
		for(Attrezzo a : attrezzi)
			peso += a.getPeso();
		return peso;
		}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {

		return this.attrezzi.contains(new Attrezzo(nomeAttrezzo,0));
	}

	/**
	 * Preso il nome dell'attrezzo da rimuovere, il metodo elimina tale oggetto dalla
	 * borsa, spostando l'ultimo attrezzo dell'array nella posizione di quello
	 * desiderato, per poi eliminare l'ultima posizione dell'array diminuendone la lunghezza
	 * @param nomeAttrezzo
	 */
	public void removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, 0);
		if(this.attrezzi.contains((a)))
				attrezzi.remove(attrezzi.get(attrezzi.indexOf(a)));
	}

	/**
	 * Questo metodo serve per poter stampare facilmente la lista di oggetti nella borsa
	 * senza dover scrivere il codice ogni volta che serve
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(!this.isEmpty()) {
			s.append("Peso("+this.getPeso()+"kg): [");
			Iterator<Attrezzo> i = this.attrezzi.iterator();
			while(i.hasNext())s.append( i.next().toString()+" ");
            s.append("]");		
		}
		else
			s.append("La borsa è vuota!");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziordinatiperpeso= new ArrayList<>(this.attrezzi);
		Collections.sort(attrezziordinatiperpeso);
		return attrezziordinatiperpeso;
	}
	
	public boolean spazioPerNuoviAttrezzi() {

		return this.getPeso() < this.getPesoMax(); 
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoperNome(){
		SortedSet<Attrezzo> attrezziOrdinatiPerNome = new TreeSet<>(new Attrezzo.nameComparator());
		attrezziOrdinatiPerNome.addAll(this.attrezzi);
		return attrezziOrdinatiPerNome;
	}
	
	public SortedSet<Attrezzo> getSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> attrezziOrdinatiPerPeso = new TreeSet<>(new Attrezzo.pesoComparator());
		attrezziOrdinatiPerPeso.addAll(this.attrezzi);
		return attrezziOrdinatiPerPeso;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> map = new HashMap<>();
		
		for(Attrezzo a : attrezzi) {
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
