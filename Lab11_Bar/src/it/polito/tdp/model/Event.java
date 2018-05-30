package it.polito.tdp.model;

public class Event implements Comparable<Event>{
	private int time ;
	private EventType tipo ;
	
	private Gruppo group;

	public Event(int time, EventType tipo, Gruppo group) {
		this.time = time;
		this.tipo = tipo;
		this.setGroup(group);
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


	public EventType getTipo() {
		return tipo;
	}


	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}

	public Gruppo getGroup() {
		return group;
	}

	public void setGroup(Gruppo group) {
		this.group = group;
	}

	@Override
	public int compareTo(Event o) {
		return this.time-o.time;
	}


}
