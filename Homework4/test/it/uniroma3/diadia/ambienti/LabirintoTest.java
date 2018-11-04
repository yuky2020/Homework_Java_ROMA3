
package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	private Stanza uscita;
	private Stanza ingresso;
	private Labirinto labi;
	private InterfacciaUtenteConsole io;
	
	

	@Before
	public void setUp() throws Exception {
		this.uscita = new Stanza("Biblioteca");
		this.ingresso = new Stanza("Atrio");
		this.io = new InterfacciaUtenteConsole();
		this.labi=new Labirinto("LabirintoTest.txt", io);
	    this.labi.ingresso = ingresso;
	    this.labi.uscita =uscita;
		
	}

	@Test
	public void testSet_N_GetIngresso () {
		this.labi.ingresso=ingresso;
		assertEquals(this.ingresso, this.labi.getIngresso());
		assertEquals("Atrio", this.labi.getIngresso().getNome());
		assertFalse(this.labi.getIngresso() == uscita);
	}
	public void testSet_N_SetUscita() {
		this.labi.setUscita(uscita);
		assertEquals(this.uscita, this.labi.getUscita());
		assertEquals("Biblioteca", this.labi.getUscita().getNome());
		assertFalse(this.labi.getUscita() == ingresso);
	}
	
	@Test
	public void testSet_N_GetUscita() {
		assertEquals(this.uscita, this.labi.uscita);
		assertEquals("Biblioteca", this.labi.uscita.getNome());
		assertFalse(this.labi.getUscita() == ingresso);
	
	}
		
	}
 


