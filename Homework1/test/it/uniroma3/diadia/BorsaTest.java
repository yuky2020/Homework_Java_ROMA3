package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	private Borsa zaino;
	private Attrezzo pala;
	private Attrezzo giacca;
	private Attrezzo computer;
	private Attrezzo testPeso;
	private Attrezzo test1;
	
	
	@Before
	public void setUp() throws Exception {
		this.zaino = new Borsa(15);
		this.pala = new Attrezzo("Pala", 5);
		this.giacca = new Attrezzo("Giacca", 5);
		this.computer = new Attrezzo("Computer", 5);
		this.testPeso = new Attrezzo("Test", 15);
		this.test1 = new Attrezzo("Test1", 1);
		
		
	}
	
	@Test
	public void TestAddAttrezzo_TroppoPeso() {
		assertTrue(this.zaino.addAttrezzo(pala));
		assertTrue(this.zaino.addAttrezzo(giacca));
		assertTrue(this.zaino.addAttrezzo(computer));
		assertFalse(this.zaino.addAttrezzo(test1));
		assertFalse(this.zaino.addAttrezzo(testPeso));
	}
	
	@Test
	public void testAddAttrezzo_PesoPreciso() {
		assertTrue(this.zaino.addAttrezzo(testPeso));
	}
	
	@Test
	public void testAddAttrezzo_Troppi() {
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		this.zaino.addAttrezzo(test1);
		assertFalse(this.zaino.addAttrezzo(computer));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertTrue(zaino.isEmpty());
		zaino.addAttrezzo(pala);
		zaino.addAttrezzo(computer);
		zaino.addAttrezzo(giacca);
		assertFalse(zaino.isEmpty());
		
		
		zaino.removeAttrezzo("Computer");
		assertTrue(zaino.hasAttrezzo("Pala"));
		assertTrue(zaino.hasAttrezzo("Giacca"));
		assertFalse(zaino.hasAttrezzo("Computer"));
		
		zaino.removeAttrezzo("Pala");
		zaino.removeAttrezzo("Giacca");
		assertTrue(zaino.isEmpty());
	}
	
	@Test
	public void testHas_N_GetAttrezzo() {
		assertNull(this.zaino.getAttrezzo("Pala"));
		assertFalse(this.zaino.hasAttrezzo("Pala"));
		
		assertTrue(this.zaino.addAttrezzo(pala));
		assertEquals(pala, this.zaino.getAttrezzo("Pala"));
		assertTrue(this.zaino.hasAttrezzo("Pala"));
		
		this.zaino.addAttrezzo(computer);
		assertEquals(computer, this.zaino.getAttrezzo("Computer"));
		assertTrue(this.zaino.hasAttrezzo("Computer"));
		assertTrue(this.zaino.hasAttrezzo("Pala"));
		
		this.zaino.removeAttrezzo("Pala");
		assertNull(this.zaino.getAttrezzo("Pala"));
		assertTrue(this.zaino.hasAttrezzo("Computer"));
		assertFalse(this.zaino.hasAttrezzo("Pala"));
	}
	
	

	

}
