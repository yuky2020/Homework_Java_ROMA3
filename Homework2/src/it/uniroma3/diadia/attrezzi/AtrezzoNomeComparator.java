package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class AtrezzoNomeComparator implements Comparator<Attrezzo>{
	@Override
	public int compare(Attrezzo A ,Attrezzo B) {
		return A.getNome().compareTo(B.getNome());
		
 }

}
