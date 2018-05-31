package it.polito.tdp.model;

public class Statistiche {
	
	private int totClienti;
	private int clientiInsoddisfatti;
	private int clientiSoddisfatti;
	
	public Statistiche(int totClienti, int clientiInsoddisfatti, int clientiSoddisfatti) {
		this.totClienti = totClienti;
		this.clientiInsoddisfatti = clientiInsoddisfatti;
		this.clientiSoddisfatti = clientiSoddisfatti;
	}

	public int upClientiSoddisfatti(int plus) {
		this.clientiSoddisfatti += plus;
		return this.clientiSoddisfatti;
	}
	
	public int upClientiInsoddisfatti(int plus) {
		this.clientiInsoddisfatti += plus;
		return this.clientiInsoddisfatti;
	}

	public int upClientiTot(int plus) {
		this.totClienti += plus;
		return this.totClienti;
	}
	
	public String toString() {
		return "Tot clienti: "+this.totClienti+"\nClienti soddisfatti: "+this.clientiSoddisfatti+"\nClienti insoddisfatti: "+this.clientiInsoddisfatti+"\n";
	}
	
}
