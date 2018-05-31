package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Simulazione {
	
	//parametri
	private int numEventi = 2000;
	private int tavoli10 = 2;
	private int tavoli8 = 4;
	private int tavoli6 = 4;
	private int tavoli4 = 5;
	
	
	//Modello del mondo
	List<Tavolo> tavoli = new ArrayList<>();
	
	//Valori in output
	private Statistiche stat = new Statistiche(0,0,0);
	
	//queue
	PriorityQueue<Event> queue = new PriorityQueue<>();
	
	public void init() {
		
		for(int i=0; i<tavoli10; i++)
			tavoli.add(new Tavolo(10, false, null));
		for(int i=0; i<tavoli8; i++)
			tavoli.add(new Tavolo(8, false, null));
		for(int i=0; i<tavoli6; i++)
			tavoli.add(new Tavolo(6, false, null));
		for(int i=0; i<tavoli4; i++)
			tavoli.add(new Tavolo(4, false, null));
		
		Collections.sort(tavoli);
		
		int time = 0;
		for(int i=1; i<numEventi; i++) {
			int intervallo = (int) (Math.random()*9 + 1);
			time += intervallo;
			Gruppo g = new Gruppo(time);
			Event e = new Event(time, EventType.ARRIVO_GRUPPO_CLIENTI, g);
			queue.add(e);
		}
		
	}

	public Statistiche run() {
		Event e;
		while ((e = queue.poll()) != null) {
			processEvent(e);
		}
		return stat;
	}

	private void processEvent(Event e) {
		switch(e.getTipo()) {
		case ARRIVO_GRUPPO_CLIENTI:
			stat.upClientiTot(e.getGroup().getNumPersone());
			for(Tavolo t : tavoli) {
				if(!t.isOccupato() && e.getGroup().getNumPersone()<=t.getNumPosti() && e.getGroup().getNumPersone()>=0.5*t.getNumPosti()) {
					Event e1 = new Event(e.getGroup().getTempoUscita(), EventType.SIT, e.getGroup());
					queue.add(e1);
					t.setGroup(e.getGroup());
					t.setOccupato(true);
					e.getGroup().setTavolo(t);
					break;
				}
			}
			
			if(e.getGroup().getTolleranza()>=0.5 && e.getGroup().getTavolo()==null) {
				stat.upClientiSoddisfatti(e.getGroup().getNumPersone());
			}else if(e.getGroup().getTolleranza()<0.5 && e.getGroup().getTavolo()==null) {
				stat.upClientiInsoddisfatti(e.getGroup().getNumPersone());			
				}
			
			break;
		case SIT:
			e.getGroup().getTavolo().setOccupato(false);
			stat.upClientiSoddisfatti(e.getGroup().getNumPersone());
			e.getGroup().getTavolo().setGroup(null);
			e.getGroup().setTavolo(null);
			break;
		}
		
	}

}
