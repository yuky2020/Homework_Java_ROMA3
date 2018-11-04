package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {


	private Stanza vuota;
	private Stanza piena;
	private Attrezzo osso;
	private Stanza stanza;
	private Attrezzo lanterna;
	private Attrezzo bacchetta;

	@Before
	public void setUp() throws Exception {
		this.vuota = new Stanza("vuota");
		this.piena = new Stanza("piena");
		this.stanza = new Stanza("stanza");
		this.osso = new Attrezzo("osso", 3);
		this.lanterna = new Attrezzo("lanterna", 10);
		this.bacchetta = new Attrezzo("bacchetta", 5);
	}

	@Test
	public void test() {
		this.stanza.addAttrezzo(this.osso);
		assertEquals(this.osso.getPeso(),this.stanza.getAttrezzo("osso").getPeso());
	}
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(osso));
	}

	@Test
    public void testHasAttrezzo_not() {
		assertFalse(this.vuota.hasAttrezzo("introvabile"));
	}

	@Test
	public void testHasAttrezzo_yes() {
		this.stanza.addAttrezzo(osso);
		assertEquals(osso, this.stanza.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzo() {
		this.stanza.addAttrezzo(new Attrezzo("osso", 3));
		assertEquals(this.osso.getNome(), this.stanza.getAttrezzo("osso").getNome());
	}

	@Test
	public void removeAttrezzo_not() {
		assertFalse(this.vuota.removeAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void removeAttrezzo_yes_primodeidue() {
		this.stanza.addAttrezzo(this.osso);
		this.stanza.addAttrezzo(this.lanterna);
		assertTrue(this.stanza.removeAttrezzo(this.osso.getNome()));
		assertTrue(this.stanza.removeAttrezzo(this.lanterna.getNome()));
	}

	@Test
	public void removeAttrezzo_yes() {
		this.stanza.addAttrezzo(this.osso);
		assertTrue(this.stanza.removeAttrezzo(this.osso.getNome()));
	}

	@Test
	public void hasMoreAdiacenti() {
		this.stanza.impostaStanzaAdiacente("nord", vuota);
		this.stanza.impostaStanzaAdiacente("nord", piena);
    	assertNotEquals(this.stanza.getStanzaAdiacente("nord"),(vuota));
		assertEquals(this.stanza.getStanzaAdiacente("nord"), piena);
	}
	
	@Test
	public void getStanzaPiuAttrezziTest() {
		this.vuota.addAttrezzo(lanterna);
		this.vuota.addAttrezzo(osso);
		this.stanza.addAttrezzo(bacchetta);
		this.piena.impostaStanzaAdiacente("nord", vuota);
		this.piena.impostaStanzaAdiacente("sud", stanza);
		assertEquals("vuota", piena.getStanzaPiuAttrezzi().getNome());
	}
	
	@Test
	public void getStanzaMenoAttrezziTest() {
		this.vuota.addAttrezzo(lanterna);
		this.vuota.addAttrezzo(osso);
		this.stanza.addAttrezzo(bacchetta);
		this.piena.impostaStanzaAdiacente("nord", vuota);
		this.piena.impostaStanzaAdiacente("sud", stanza);
		assertEquals("stanza", piena.getStanzaMenoAttrezzi().getNome());
	}
}
