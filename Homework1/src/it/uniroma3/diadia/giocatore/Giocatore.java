package it.uniroma3.diadia.giocatore;

public class Giocatore {
	public Borsa zaino = new Borsa(10);
	static final private int CFU_INIZIALI = 20;
	public int cfu;
	
	
  public Giocatore() {
	  this.cfu= CFU_INIZIALI;
  }
  
 }
