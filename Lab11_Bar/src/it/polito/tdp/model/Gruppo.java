package it.polito.tdp.model;

public class Gruppo {
	
	private int numPersone;
	private float tolleranza;
	private int tempoArrivo;
	private int tempoUscita;
	private Tavolo tavolo;
	
	public Gruppo(int tempoArrivo) {
		numPersone = (int) (Math.random()*9+1);
		tolleranza = (float) (Math.random());
		this.tempoArrivo = tempoArrivo;
		tempoUscita = (int) (tempoArrivo + Math.random()*60+60);
		tavolo = null;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public int getTempoArrivo() {
		return tempoArrivo;
	}

	public void setTempoArrivo(int tempoArrivo) {
		this.tempoArrivo = tempoArrivo;
	}

	public int getTempoUscita() {
		return tempoUscita;
	}

	public void setTempoUscita(int tempoUscita) {
		this.tempoUscita = tempoUscita;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	
	
}
