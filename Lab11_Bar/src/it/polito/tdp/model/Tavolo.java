package it.polito.tdp.model;

public class Tavolo implements Comparable<Tavolo>{
	
	private int numPosti;
	private boolean occupato;
	private Gruppo group;
	
	public Tavolo(int numPosti, boolean occupato, Gruppo group) {
		this.numPosti = numPosti;
		this.occupato = occupato;
		this.group = group;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	public Gruppo getGroup() {
		return group;
	}

	public void setGroup(Gruppo group) {
		this.group = group;
	}

	@Override
	public int compareTo(Tavolo o) {
		return this.numPosti-o.numPosti;
	}

	
	
}
