

package it.uniroma3.diadia.ambienti;

import java.io.*;
import java.net.URL;
import java.util.*;

import it.uniroma3.diadia.IO.InterfacciaUtente;
import it.uniroma3.diadia.IO.InterfacciaUtenteConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:"; 

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";

	private static final String PERSONAGGI_MARKER = "Personaggi:";
	
	//prefisso riga stanza Buia
	private static final String STANZE_BUIE_MARKER = "StanzeBuie:"; 
	
	//prefisso riga stanza BLoccata
	private static final String STANZE_BLOCCATE_MARKER = "StanzeBloccate:"; 

	
	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11, atrio, sala
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;
	private Map<String, Attrezzo> nome2attrezzo;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.nome2attrezzo = new HashMap<>();
		URL url = getClass().getResource(nomeFile);
		this.reader = new LineNumberReader(new FileReader(url.getPath()));
	}

	public void carica(InterfacciaUtente io) throws FormatoFileNonValidoException{
		try {
			this.leggiECreaStanze();
			this.leggiECreaStanzeBloccate(io);
			this.leggiECreaStanzeBuie();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiECreaPersonaggi();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException {
	String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_BUIE_MARKER);
	for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
		String nome = null;
		String luce = null;
		try (Scanner scannerLinea = new Scanner(nomiStanze)) {
			if(scannerLinea.hasNext());
			nome = scannerLinea.next();
			if(scannerLinea.hasNext());
			luce = scannerLinea.next();
			StanzaBuia stanza = new StanzaBuia(nome, luce);
			this.nome2stanza.put(nome, stanza);
			}
	}
	}
	
	private void leggiECreaStanzeBloccate(InterfacciaUtente io) throws FormatoFileNonValidoException {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_BLOCCATE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			String nome = null;
			String chiave = null;
			String direzione = null;
			try (Scanner scannerLinea = new Scanner(nomiStanze)) {
				if(scannerLinea.hasNext());
				nome = scannerLinea.next();
				if(scannerLinea.hasNext());
				chiave = scannerLinea.next();
				if(scannerLinea.hasNext());
				direzione = scannerLinea.next();
				StanzaBloccata stanza = new StanzaBloccata(nome, chiave, direzione, io);
				this.nome2stanza.put(nome, stanza);
			}
			
			}
		
	}
	

	private void leggiECreaPersonaggi() throws FormatoFileNonValidoException {
		String nomiPersona = this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);
		for(String nomePersona : separaStringheAlleVirgole(nomiPersona)) {
			String tipo = null;
			String stanza = null;
			String nome = null;
			String presentazione = null;
			String regalo = null;
			String cibo = null;
			try (Scanner scannerLinea = new Scanner(nomePersona)) {
				if(scannerLinea.hasNext())
				tipo = scannerLinea.next();
				if(scannerLinea.hasNext())
				stanza = scannerLinea.next();
				if(scannerLinea.hasNext())
				nome = scannerLinea.next();
				
				if(scannerLinea.hasNext()&&tipo.equals("mago"))
					regalo = scannerLinea.next();
				if(scannerLinea.hasNext()&&tipo.equals("cane"))
					cibo = scannerLinea.next();
				if(scannerLinea.hasNext())
				presentazione = scannerLinea.nextLine();
				
				
				
				if (tipo.equals("cane")) {
					Cane cane = new Cane(nome, presentazione, this.nome2attrezzo.get(regalo) , cibo);
				    this.nome2stanza.get(stanza).setPersonaggio(cane);
				}
				else if (tipo.equals("mago")) {
					Mago mago = new Mago(nome, presentazione, this.nome2attrezzo.get(regalo));
					this.nome2stanza.get(stanza).setPersonaggio(mago);
				}
				else if (tipo.equals("strega")) {
					Strega strega = new Strega(nome, presentazione);
					this.nome2stanza.get(stanza).setPersonaggio(strega);
				}	
	}
		}
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext())
			result.add(scannerDiParole.next().trim());
		}
		return result;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
		nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER).trim();
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER).trim();
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String posa = null;
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("Specifica se posarlo. "));
					posa = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
					nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
					pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
					nomeStanza = scannerLinea.next();
			}
			if(posa.equals("0"))
				posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
			this.nome2attrezzo.put(nomeAttrezzo, attrezzo);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		try (Scanner scannerDiLinea = new Scanner(specificheUscite)) {			

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
				String stanzaPartenza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
				String dir = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
				String stanzaDestinazione = scannerDiLinea.next();
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione.replace(",", ""));
			}
		} 
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
}



