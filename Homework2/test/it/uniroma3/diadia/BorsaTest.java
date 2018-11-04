package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
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
	@Test
	public void getSortedContenutoPerPesoTest_stessoPesoNomiDiversi() {
		Attrezzo attrezzo1 = new Attrezzo("LANTERNA", 1);
		Attrezzo attrezzo2 = new Attrezzo("OSSO", 1);
		Borsa test = new Borsa(100);
		test.addAttrezzo(attrezzo2);
		test.addAttrezzo(attrezzo1);
		List<Attrezzo> contenutoPerPeso = test.getSetOrdinatoPerPeso();
		assertTrue();
		assertTrue();
	}
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo attrezzo1 = new Attrezzo("LANTERNA", 1);
		Attrezzo attrezzo2 = new Attrezzo("OSSO", 1);
		Attrezzo attrezzo3 = new Attrezzo("OSSO",1);
		Attrezzo attrezzo4 = new Attrezzo("OSSO",1);
		Borsa test = new Borsa(100);
		test.addAttrezzo(attrezzo2);
		test.addAttrezzo(attrezzo1);
		test.addAttrezzo(attrezzo4);
		test.addAttrezzo(attrezzo3);
		List<Attrezzo> contenutoOrdinatoPerPeso = test.getContenutoOrdinatoPerPeso();
		List<Attrezzo> contenutoAttesoArray = Arrays.asList(attrezzo1, attrezzo2, attrezzo3, attrezzo4);
		assertEquals(contenutoAttesoArray,contenutoOrdinatoPerPeso);
		}
		/**
		 * T POSE BRAH HELLVIS BACK FINO ALL'ULTIMO MIC CHECK ASPETTERÚ LA FINE SULLA PUNTA DELL'ICEBERG
		 * skkkkkkkkkkrrrrt papa SCENDO GI˘ DAL BAR SEMBRO TUTANKA HO SPESO DUE K SU UNA SCA PARLES VOUZ FRANCE 
		 * SPUTA SUL CACHET FRA CHE CAZZO HA DE? VAI GOOGLE TRANSLA NEI QUARTIERI CON LE MOTO FANNO LE IMPENN‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡
		 * CON DUE TIPE STRAFIGHE BRASILE POI QUENTIQUARAN ACHILLE
		 * RISCRIVIAMO IL LIBRO DELLA GIUNGLA IL MIO FRATE HA LA FEDINE BELLA LUNGA
		 * STE DUE BARRE NON ME LE RICORDO
		 * SE LE GUARDIE CHIEDONO QUALCOSA LEI DICA NO
		 * (UN NOME A CASO TIPO MARIO RENOIR) LEI TUTTA NUDA SUL SOFA QUANDO ESCO CON I FRA CI FANNO LE FOTO PERCH
		 * Ë SIAMO BELLI BELLI DA MORI SYSTEM.OUT.PRINTLN("SEMBRA DI STARE A TOHIRY");+
		 * ADACHER PUTTANA
		 * 
		 **/
		
		
	}

	


