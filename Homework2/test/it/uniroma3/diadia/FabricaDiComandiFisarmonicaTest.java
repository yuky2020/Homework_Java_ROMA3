package it.uniroma3.diadia;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
public class FabricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbrica;
	
	@Before 
	public void setUp() throws Exception {
		this.fabbrica =new FabbricaDiComandiFisarmonica();
	}
	@Test
	public void testCostruisciComandoVai() {
		Comando comando =this.fabbrica.costruisciComando("vai nord");
		assertEquals("Vai", comando.getNome());
		assertEquals("nord",comando.getParametro());
		//come puoi notare qui fa riferimento a due metodi non presenti in quella che era la nostra interface ho sistemato;
	}

}
