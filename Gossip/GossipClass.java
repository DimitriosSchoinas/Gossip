package Gossip;

import dataStructures.*;

public class GossipClass implements Gossip {

	private String description;
	private Person creator;
	private Array<Person> targetPeople, peopleWhoKnowTheGossip;
	private int amountOfTimesShared;

	public GossipClass(Person creator, Array<Person> targetPeople, String description) {

		this.creator = creator;
		this.description = description;
		this.targetPeople = targetPeople;
		this.peopleWhoKnowTheGossip = new ArrayClass<>();
		this.peopleWhoKnowTheGossip.insertLast(creator);
		this.amountOfTimesShared = 0;
	}

	@Override
	public boolean isDuplicateGossip(String creatorName, String description) {
		return this.creator.getName().equals(creatorName) && this.description.equals(description);
	}

	@Override
	public String getCreatorName() {
		return this.creator.getName();
	}

	@Override
	public boolean isPersonATarget(String name) {
		boolean found = false;
		int i = 0;
		while (i < targetPeople.size() && !found) {
			if (targetPeople.get(i).getName().equals(name)) {
				found = true;
			}
			i++;
		}
		return found;
	}

	@Override
	public String getGossipDescription() {
		return this.description;
	}
	
	public boolean didPersonAlreadyKnowTheGossip(Person person) {
		boolean found = false;
		int i = 0;
		while (i < this.peopleWhoKnowTheGossip.size() && !found) {
			if(this.peopleWhoKnowTheGossip.get(i).getName().equals(person.getName())) {
				found = true;
			}
			i++;
		}
		return found;
	}
	
	public void addPeopleWhoKnowTheGossip(Person person) {
		this.peopleWhoKnowTheGossip.insertLast(person);
	}
	
	public int getAmountOfPeopleWhoKnowTheGossip() {
		return this.peopleWhoKnowTheGossip.size();
	}

	@Override
	public int getNumberOfTimesShared() {
		return this.amountOfTimesShared;
	}

	@Override
	public void addNumberOfTimesShared() {
		this.amountOfTimesShared++;
	}

}
