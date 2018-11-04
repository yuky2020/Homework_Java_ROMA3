package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;



public class ComandoPrendi extends abstractComando{

	public ComandoPrendi() {
		super("prendi");
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s=new StringBuilder();
		String oggetto = super.getParametro();
		if(partita.getStanzaCorrente().getNumeroAttrezzi() > 0) {
			if (oggetto == null) {
				
				s.append(""+partita.getStanzaCorrente().getListaAttrezzi());
				
				} 
			else {
			if(partita.getStanzaCorrente().hasAttrezzo(oggetto)) {
				if(partita.getStanzaCorrente().getAttrezzo(oggetto).getPeso() + partita.getGiocatore().getZaino().getPeso() > partita.getGiocatore().getZaino().getPesoMax())
					s.append("L'oggetto pesa troppo!");
				else {
				Attrezzo add = partita.getStanzaCorrente().getAttrezzo(oggetto);
				partita.getGiocatore().getZaino().addAttrezzo(add);
				partita.getStanzaCorrente().removeAttrezzo(add.getNome());
				s.append("Oggetto Raccolto!");
				}
			}
			else s.append("Non c'è nessun atrezzo chiamato "+oggetto);
			}
			}
		else s.append("Non ci sono oggetti nella stanza!");
	return s.toString() ;
	}		
	}

