package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class StanzaBloccataTest {


	private StanzaBloccata vuota;
	private Attrezzo chiave;
	private Stanza stanza;
	private Attrezzo lanterna;
	

	@Before
	public void setUp() throws Exception {
		this.vuota = new StanzaBloccata("vuota", "chiave" ,"nord");
		this.stanza = new Stanza("stanza");
		this.chiave = new Attrezzo("chiave", 3);
		this.lanterna = new Attrezzo("lanterna", 10);
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
