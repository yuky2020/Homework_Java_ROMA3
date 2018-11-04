package it.uniroma3.diadia.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfacciaUtenteConsole implements InterfacciaUtente{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
	public void mostraMessaggio(String messaggio) {
	System.out.println(messaggio);
	}

  public String prendiIstruzione() {
	  
	  try {
		return  br.readLine();
	} catch (IOException e) {
		e.printStackTrace();
		return this.prendiIstruzione();
	
	}
   }


}
