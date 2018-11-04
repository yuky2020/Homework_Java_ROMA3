package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComadoPrendiTest {
	
	private static final String OSSO = "osso";
	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private InterfacciaUtenteConsole io;

	@Before
	public void setUp() throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setParametro(OSSO);
		this.io = new InterfacciaUtenteConsole();
		this.partita = new Partita(io);
	}

	@Test
	public void testEseguiCasoBase() {
		Attrezzo attrezzoNellaStanza = new Attrezzo(OSSO, 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNellaStanza);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(OSSO));
		assertTrue(this.partita.getGiocatore().getZaino().hasAttrezzo(OSSO));
	}

}
