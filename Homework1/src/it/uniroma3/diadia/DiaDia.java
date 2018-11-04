package it.uniroma3.diadia;



import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "lascia"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome() == null)
			return false;

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi();
		else if (comandoDaEseguire.getNome().equals("lascia"))
			this.lascia();
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		else {
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(cfu--);
		}
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}
	
	private void prendi() {
		if(this.partita.StanzaCorrente.hasAttrezzi()) {
		Scanner scan = new Scanner(System.in);
		System.out.println(""+this.partita.getStanzaCorrente().getListaAttrezzi());
		String oggetto = scan.nextLine();
		if(this.partita.getStanzaCorrente().hasAttrezzo(oggetto)) {
			Attrezzo add = this.partita.getStanzaCorrente().getAttrezzo(oggetto);
			this.partita.uno.zaino.addAttrezzo(add);
			this.partita.getStanzaCorrente().removeAttrezzo(add);
			System.out.println("Oggetto Raccolto!");
		}
		else System.out.println("Non c'è nessun atrezzo chiamato "+oggetto);
	}
		else System.out.println("Non ci sono oggetti nella stanza!");
	}
	
	private void lascia() {
		Scanner scan = new Scanner(System.in);
		String messaggio = this.partita.uno.zaino.toString();
		System.out.println(messaggio);
		if (!(messaggio.equals("La borsa è vuota!"))){
			String oggetto = new String();
				oggetto = scan.nextLine();
		if(this.partita.uno.zaino.hasAttrezzo(oggetto)) {
			
			Attrezzo add = this.partita.uno.zaino.getAttrezzo(oggetto);
			this.partita.uno.zaino.removeAttrezzo(oggetto);
			this.partita.getStanzaCorrente().addAttrezzo(add);
			System.out.println("Oggetto Lasciato!");
		}
	}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}