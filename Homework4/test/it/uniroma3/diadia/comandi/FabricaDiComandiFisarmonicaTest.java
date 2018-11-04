package it.uniroma3.diadia.comandi;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
public class FabricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiRiflessiva fabbrica;
	
	@Before 
	public void setUp() throws Exception {
		this.fabbrica =new FabbricaDiComandiRiflessiva();
	}
	@Test
	public void testCostruisciComandoVai() {
		Comando comando =this.fabbrica.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord",comando.getParametro());
	}
	
	public void testClasseComando() {
		Comando comando = this.fabbrica.costruisciComando("vai nord");
		ComandoVai comandoVai = new ComandoVai();
		assertEquals(comandoVai.getClass(), comando.getClass());
	}

}
