package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComadoPosaTest {
	
	private static final String OSSO = "osso";
	private ComandoPosa comandoPosa;
	private Partita partita;
	private InterfacciaUtenteConsole io;

	@Before
	public void setUp() throws Exception {
		this.comandoPosa = new ComandoPosa();
		this.io = new InterfacciaUtenteConsole();
		this.comandoPosa.setParametro(OSSO);
		this.partita = new Partita(io);
	}

	@Test
	public void testEseguiCasoBase() {
		Attrezzo attrezzoNellaBorsa = new Attrezzo(OSSO, 1);
		this.partita.getGiocatore().getZaino().addAttrezzo(attrezzoNellaBorsa);
		this.comandoPosa.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(OSSO));
		assertFalse(this.partita.getGiocatore().getZaino().hasAttrezzo(OSSO));
	}
	
    @Test
    public void testEseguiAtrezzoNonPresente() {
    	int numeroAtrezzi = this.partita.getStanzaCorrente().getAttrezzi().size();
    	this.comandoPosa.esegui(partita);
    	assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(OSSO));
    	assertFalse(this.partita.getGiocatore().getZaino().hasAttrezzo(OSSO));
    	assertEquals(numeroAtrezzi,this.partita.getStanzaCorrente().getAttrezzi().size());
    }
    @Test 
    public void testEseguiStanzaPiena() {
    	for(int i =0;i<10;i++) {
    	Attrezzo attrezzoNellaBorsa = new Attrezzo(OSSO,1)	;
    	this.partita.getStanzaCorrente().addAttrezzo(attrezzoNellaBorsa);
    	}
    }
    
    @Test
    public void testPesoInvariato() {
    	Attrezzo a = new Attrezzo("cazzo", 3);
    	Comando posa = new ComandoPosa();
    	posa.setParametro("cazzo");
    	posa.esegui(partita);
    	assertEquals(3, a.getPeso());
    	
    }
    
}