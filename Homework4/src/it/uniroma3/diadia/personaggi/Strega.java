package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends abstractPersonaggio {

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		if(super.haSalutato()) {
			System.out.println("Ha Ha! Sarò buona dai... addio!");
			partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaPiuAttrezzi());
			return ("La Strega ti ha fatto un malocchio, ora ti trovi in: "+partita.getStanzaCorrente().getNome());
		}
		else {
			System.out.println("Sei stato davvero maleducato, via di qui!");
			partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaMenoAttrezzi());
			return ("La Strega ti ha fatto un malocchio, ora ti trovi in: "+partita.getStanzaCorrente().getNome());
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return("HA HA!!! Pensi davvero che mi possa servire un " + attrezzo.getNome() +"?! Mi dispiace, ma non lo riavrai mai!");
	}

}
