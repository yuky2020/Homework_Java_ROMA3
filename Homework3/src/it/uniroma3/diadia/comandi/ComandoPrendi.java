package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nome="prendi";
	private String oggetto;

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getNumeroAttrezzi() > 0) {
			if (oggetto == null) {
				Scanner scan = new Scanner(System.in);
				System.out.println(""+partita.getStanzaCorrente().getListaAttrezzi());
				String stringa = scan.nextLine();
				if(partita.getStanzaCorrente().hasAttrezzo(stringa)) {
					Attrezzo add = partita.getStanzaCorrente().getAttrezzo(stringa);
					partita.getGiocatore().getZaino().addAttrezzo(add);
					partita.getStanzaCorrente().removeAttrezzo(add.getNome());
					System.out.println("Oggetto Raccolto!");
				} 
			}
			else {
			if(partita.getStanzaCorrente().hasAttrezzo(oggetto)) {
				Attrezzo add = partita.getStanzaCorrente().getAttrezzo(oggetto);
				partita.getGiocatore().getZaino().addAttrezzo(add);
				partita.getStanzaCorrente().removeAttrezzo(add.getNome());
				System.out.println("Oggetto Raccolto!");
			}
			else System.out.println("Non c'è nessun atrezzo chiamato "+oggetto);
			}
			}
			else System.out.println("Non ci sono oggetti nella stanza!");
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto = parametro;
		
	}

		
		@Override
		public void setNome(String nome) {
			this.nome=nome;
		}
		
		@Override
		public String getParametro() {return this.oggetto;}
		
		@Override
		public String getNome() {return this.nome ;}

	}

