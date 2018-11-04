package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO.InterfacciaUtente;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto2 {
	public Stanza ingresso;
	public Stanza uscita;
	
	
	/**
     * Imposta il layout iniziale di tutte le stanze, compresi oggetti presenti, e le loro adiacenze.
     * Dopodichè imposta un'entrata, la stanza iniziale, ed un'uscita, la stanza finale.
     */
    public Labirinto2(InterfacciaUtente io) {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo spada = new Attrezzo ("spada", 6);
		Attrezzo laurea = new Attrezzo ("laurea", 30);
		Attrezzo bacchetta = new Attrezzo("bacchetta", 5);
		Attrezzo merendina = new Attrezzo("merendina", 1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza mensa = new StanzaBuia("Mensa", "lanterna");
		Stanza bar = new StanzaMagica("Bar");
		Stanza aulaN9 = new Stanza("Aula N9");
		Stanza campusOne = new StanzaBloccata("Campus One", "chiave", "nord",io);
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", aulaN9);
		aulaN9.impostaStanzaAdiacente("nord", aulaN10);
		aulaN9.impostaStanzaAdiacente("est", campusOne);
		campusOne.impostaStanzaAdiacente("nord", biblioteca);
		campusOne.impostaStanzaAdiacente("ovest", aulaN9);
		mensa.impostaStanzaAdiacente("nord", laboratorio);
		mensa.impostaStanzaAdiacente("ovest", bar);
		bar.impostaStanzaAdiacente("est", mensa);
		laboratorio.impostaStanzaAdiacente("sud", mensa);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		atrio.addAttrezzo(osso);
		bar.addAttrezzo(chiave);
		aulaN9.addAttrezzo(spada);
		laboratorio.addAttrezzo(laurea);
		atrio.addAttrezzo(merendina);
		
		/* creo i personaggi */
		Mago forest = new Mago("Forest", "Skidadle Skidoodle", bacchetta);
		Cane doggo = new Cane("Doggo", "Woof woof", lanterna, "osso");
		Strega varana = new Strega("Varana", "AH AH AH!");
		
		/* inserisco i personaggi nelle stanze*/
		aulaN10.setPersonaggio(forest);
		aulaN9.setPersonaggio(doggo);
		aulaN11.setPersonaggio(varana);

		// il gioco comincia nell'atrio
        ingresso = atrio;  
		uscita = biblioteca;
    }
	public void setUscita(Stanza uscita) {
		this.uscita=uscita;
		
	}
	public Stanza getUscita() {
		return uscita;
	}

	public Stanza getIngresso() {
		return this.ingresso;}
}
