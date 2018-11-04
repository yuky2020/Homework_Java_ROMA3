package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import org.junit.Test;

import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;

import it.uniroma3.diadia.ambienti.Stanza;


public class PartitaTest {
	
	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Partita partita;
	private InterfacciaUtenteConsole io;
	

	@Before
	public void setUp() throws Exception {
		this.stanzaVincente = new Stanza("Biblioteca");
		this.stanzaCorrente = new Stanza("Atrio");
		this.io = new InterfacciaUtenteConsole();
		this.partita = new Partita(io);
		this.partita.aule.uscita = stanzaVincente;
	}

	@Test
	public void testSet_N_GetStanzaCorrente () {
		this.partita.setStanzaCorrente(stanzaCorrente);
		assertEquals(this.stanzaCorrente, this.partita.getStanzaCorrente());
		assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());
		assertFalse(this.partita.getStanzaCorrente() == stanzaVincente);
		
		this.partita.setStanzaCorrente(stanzaVincente);
		assertEquals(this.stanzaVincente, this.partita.getStanzaCorrente());
		assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
		assertFalse(this.partita.getStanzaCorrente() == stanzaCorrente);
	}
	
	@Test
	public void testGetStanzaVincente (){
		assertEquals(stanzaVincente, this.partita.getStanzaVincente());
		assertEquals(this.partita.getStanzaVincente().getNome(), "Biblioteca");
		assertFalse(this.partita.getStanzaVincente() == stanzaCorrente);
		stanzaCorrente = stanzaVincente;
		assertTrue(this.partita.getStanzaVincente() == stanzaCorrente);
	}
	
	@Test
	public void testVinta (){
		partita.setStanzaCorrente(stanzaCorrente);
		assertFalse(partita.vinta());
		partita.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.vinta());
		assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGet_N_SetCfu() {
		assertFalse(partita.getCfu() == 0);
		assertTrue(partita.getCfu() == 20);
		partita.setCfu(10);
		assertEquals(10, partita.getCfu());
		assertFalse(partita.getCfu() == 0);
		partita.setCfu(20);
		assertEquals(20, partita.getCfu());
		assertFalse(partita.getCfu() == 10);
	}
	
	@Test
	public void testIsFinita_stanzaVincente() {
		partita.setStanzaCorrente(stanzaCorrente);
		assertFalse(partita.isFinita());
		partita.setStanzaCorrente(stanzaVincente);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_CfuePersi() {
		assertFalse(partita.isFinita());
		partita.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	

}
