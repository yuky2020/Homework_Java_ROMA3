package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {


	private Stanza vuota;
	private Attrezzo osso;
	private Stanza stanza;
	private Attrezzo lanterna;

	@Before
	public void setUp() throws Exception {
		this.vuota = new Stanza("vuota");
		this.stanza = new Stanza("stanza");
		this.osso = new Attrezzo("osso", 3);
		this.lanterna = new Attrezzo("lanterna", 10);
	}

	@Test
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
		assertFalse(this.vuota.removeAttrezzo(this.osso));
	}
	
	@Test
	public void removeAttrezzo_yes_primodeidue() {
		this.stanza.addAttrezzo(this.osso);
		this.stanza.addAttrezzo(this.lanterna);
		assertTrue(this.stanza.removeAttrezzo(this.osso));
		assertTrue(this.stanza.removeAttrezzo(this.lanterna));
	}
	
	@Test
	public void removeAttrezzo_yes() {
		this.stanza.addAttrezzo(this.osso);
		assertTrue(this.stanza.removeAttrezzo(this.osso));
	}

}
