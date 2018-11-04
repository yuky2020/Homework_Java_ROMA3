package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {


	private StanzaBuia buia;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private static final String messaggio = "Qui c'è buio pesto";

	@Before
	public void setUp() throws Exception {
		this.buia = new StanzaBuia("stanza","lanterna");
		this.osso = new Attrezzo("osso", 3);
 	 this.lanterna = new Attrezzo("lanterna", 10);
	}

	@Test
	public void isAccesaNot() {
		assertEquals(this.buia.getDescrizione(), messaggio);
		this.buia.addAttrezzo(osso);
		assertEquals(this.buia.getDescrizione(), messaggio);
	}
	
	@Test
	public void isAccesaYes() {
		this.buia.addAttrezzo(lanterna);
		assertNotEquals(this.buia.getDescrizione(), messaggio);
		this.buia.addAttrezzo(osso);
		assertNotEquals(this.buia.getDescrizione(), messaggio);
		this.buia.removeAttrezzo(lanterna.getNome());
		assertEquals(this.buia.getDescrizione(), messaggio);
	}

}
