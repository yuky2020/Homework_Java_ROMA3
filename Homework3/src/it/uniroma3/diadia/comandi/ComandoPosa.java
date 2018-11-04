package it.uniroma3.diadia.comandi;


import java.util.Scanner;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nome=" Posa";
	private String oggetto;

	@Override
	public void esegui(Partita partita) {
		String messaggio = "La borsa è vuota";
		if(!partita.getGiocatore().getZaino().isEmpty()) {
			if (!partita.getGiocatore().getZaino().isEmpty() && this.getParametro() != null ){
				if(partita.getGiocatore().getZaino().hasAttrezzo(oggetto)) {
						Attrezzo add = partita.getGiocatore().getZaino().getAttrezzo(oggetto);
						partita.getStanzaCorrente().addAttrezzo(add);
						partita.getGiocatore().getZaino().removeAttrezzo(oggetto);		
						System.out.println("Oggetto Lasciato!");				
				}
				else System.out.println("Non c'è questo oggetto nella borsa");
			}
			if (!partita.getGiocatore().getZaino().isEmpty() && this.getParametro() == null ) {
				String stringap = partita.getGiocatore().getZaino().toString();
				System.out.println(stringap);
				if(!partita.getGiocatore().getZaino().toString().equals("La borsa è vuota!")) {
					Scanner scanner = new Scanner(System.in); 
					String string = scanner.nextLine();
					this.setParametro(string);
					this.esegui(partita);
					
				}
			}
		}
		else System.out.println(messaggio);
	}

	@Override
	public void setParametro(String parametro) {
		this.oggetto=parametro;
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


