package it.polito.tdp.model;

public class Model {

	public Statistiche simula() {
		Simulazione sim = new Simulazione();
		sim.init();
		return sim.run();
	}

}
