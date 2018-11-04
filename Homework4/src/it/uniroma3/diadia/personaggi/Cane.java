package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends abstractPersonaggio{
	
	String cibo;
	Attrezzo regalo;

	public Cane(String nome, String presentaz, Attrezzo regalo, String cibo) {
		super(nome, presentaz);
		this.cibo = cibo;
		this.regalo = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		String mg = "WOOFLES!!";
		partita.setCfu(partita.getCfu()-1);
		System.out.println("Oh no! Il cane ti ha morso ed hai perso un CFU!!\n");
		return mg;
	}
	
	@Override
	public String saluta() {
		System.out.println(super.getPresentazione());
	return ("Hai davanti un cane, non puoi salutarlo, ma al collo ha una targhetta: "+this.getNome());
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(cibo)) {
			partita.getStanzaCorrente().addAttrezzo(regalo);
			System.out.println("Woof woof, woof!!");
			return("Non capisci il canese, ma dalla sua espressione intuisci che il cane è contento. Ha lasciato anche cadere un regalo!");
		}
		else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			System.out.println("Grr...");
			return("Il cane sembra molto arrabbiato...");
		}
	}
}
