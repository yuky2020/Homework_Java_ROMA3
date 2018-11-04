package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {


	private StanzaBloccata vuota;
	private Attrezzo chiave;
	private Stanza stanza;
	private InterfacciaUtenteConsole io;
	

	@Before
	public void setUp() throws Exception {
		this.io = new InterfacciaUtenteConsole();
		this.vuota = new StanzaBloccata("vuota", "chiave" ,"nord", io);
		this.stanza = new Stanza("stanza");
		this.chiave = new Attrezzo("chiave", 3);
		this.vuota.impostaStanzaAdiacente("est", stanza);
	}
	
	@Test 
	public void TestDirezioneBloccata() {
		assertEquals(this.vuota.getStanzaAdiacente("nord"), this.vuota);
		assertEquals(this.vuota.getStanzaAdiacente("est"), this.stanza);
		this.vuota.addAttrezzo(chiave);
		this.vuota.impostaStanzaAdiacente("nord", stanza);
		assertEquals(this.vuota.getStanzaAdiacente("nord"), this.stanza);
	}

}
