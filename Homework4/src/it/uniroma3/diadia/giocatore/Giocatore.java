
package it.uniroma3.diadia.giocatore;
import java.util.Properties;
import java.io.*;

public class Giocatore {
	private Borsa zaino ;
	public int cfu;
	
	
  public Giocatore() {
	  
	  
	  Properties prop = new Properties();
	  prop.setProperty("cfu_iniziali",   "20");
	  prop.setProperty("peso_max_borsa", "10");
	  try {
		prop.load(new FileReader("diadia.properties"));
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	  this.cfu= Integer.parseInt(prop.getProperty("cfu_iniziali", "20"));
	  this.zaino=new Borsa(Integer.parseInt(prop.getProperty("peso_max_borsa","10")));
	   
	  }
  

public Borsa getZaino() {
	  return this.zaino;
  }
  
 }
