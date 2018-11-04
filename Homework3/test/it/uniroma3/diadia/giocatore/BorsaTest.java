package it.uniroma3.diadia.giocatore;

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
	private Attrezzo test2;
	private Borsa zaino1;
	
	@Before
	public void setUp() throws Exception {
		this.zaino = new Borsa(15);
		this.pala = new Attrezzo("Pala", 5);
		this.giacca = new Attrezzo("Giacca", 5);
		this.computer = new Attrezzo("Computer", 5);
		this.testPeso = new Attrezzo("Test", 15);
		this.test1 = new Attrezzo("Test1", 1);
		this.test2 = new Attrezzo("Test2", 15);
		this.zaino1 = new Borsa(100);
		
		
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
	
	@Test
	public void testGetContenutoraggruppatoPerPeso() {
		zaino1.addAttrezzo(pala);
		zaino1.addAttrezzo(computer);
		zaino1.addAttrezzo(giacca);
		zaino1.addAttrezzo(test1);
		zaino1.addAttrezzo(test2);
		zaino1.addAttrezzo(testPeso);
		System.out.println(this.zaino1.getContenutoRaggruppatoPerPeso().values().toString());
		
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		zaino1.addAttrezzo(pala);
		zaino1.addAttrezzo(computer);
		zaino1.addAttrezzo(giacca);
		zaino1.addAttrezzo(test1);
		zaino1.addAttrezzo(test2);
		zaino1.addAttrezzo(testPeso);
		System.out.println(this.zaino1.getContenutoOrdinatoPerPeso().toString());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		zaino1.addAttrezzo(pala);
		zaino1.addAttrezzo(computer);
		zaino1.addAttrezzo(test1);
		zaino1.addAttrezzo(test2);
		zaino1.addAttrezzo(giacca);
		zaino1.addAttrezzo(testPeso);
		System.out.println(this.zaino1.getContenutoOrdinatoperNome().toString());
	}
	
	

	

}
