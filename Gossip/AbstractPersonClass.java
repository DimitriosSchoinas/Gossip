package Gossip;

import dataStructures.*;

abstract class AbstractPersonClass implements Person {

	private static final String HOME = "home";

	protected String name;
	protected Array<Gossip> gossips;
	private String personType;
	private String currentLocation;
	protected int indexOfGossipToShare;

	protected AbstractPersonClass(String name, String personType) {
		this.name = name;
		this.gossips = new ArrayClass<>();
		this.personType = personType;
		this.currentLocation = HOME;
		this.indexOfGossipToShare = 0;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.personType;
	}

	public int getNumberOfGossips() {
		return gossips.size();
	}

	public String getCurrentLocation() {

		return this.currentLocation;
	}

	public void move(String landmark) {
		this.currentLocation = landmark;
	}

	public abstract void addGossip(Gossip gossip);

	public boolean isPersonATarget() {
		boolean found = false;
		int i = 0;
		while(i < gossips.size() && !found) {
			if (gossips.get(i).isPersonATarget(name)) {
				found = true;
			}
			i++;
		}
		return found;
	}

	public abstract Gossip shareGossips();

	public void resetIndexOfGossipToShare() {
		this.indexOfGossipToShare = 0;
	}

	public Iterator<Gossip> listKnownGossips() {
		return gossips.iterator();
	}
}
