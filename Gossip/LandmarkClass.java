package Gossip;

import dataStructures.*;

public class LandmarkClass implements Landmark {

	private static final String FORGETFUL_TYPE = "forgetful";
	private static final String GOSSIPER_TYPE = "gossiper";
	private static final String SEALED_LIPS_TYPE = "sealed";

	private int size;
	private String name;
	private int currentOccupation;
	private Array<Person> peopleAtLandmark;
	private Array<Group> groups;
	private Array<Gossip> lastSharedGossips;

	public LandmarkClass(String name, int size) {
		this.size = size;
		this.name = name;
		this.currentOccupation = 0;
		this.peopleAtLandmark = new ArrayClass<>();
		groups = new ArrayClass<>();
		lastSharedGossips = new ArrayClass<>();
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCurrentOccupation() {
		return currentOccupation;
	}

	public void addPersonToLocation(Person person) {
		this.peopleAtLandmark.insertLast(person);
		groups.insertLast(new GroupClass(person));
		currentOccupation++;
	}

	public boolean areBothOnSameGroup(Person person, Person other) {
		return this.searchIndexOfPersonGroup(person) == this.searchIndexOfPersonGroup(other);
	}

	public void joinGroup(Person personJoining, Person personToJoin) {
		this.removePersonThatIsJoiningOtherGroup(personJoining);
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).hasPerson(personToJoin)) {
				groups.get(i).addPerson(personJoining);
			}
		}
	}

	private void removePersonThatIsJoiningOtherGroup(Person person) {
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).hasPerson(person)) {
				groups.get(i).removePerson(person);
				if (person.getType().equals(FORGETFUL_TYPE)) {
					person.resetIndexOfGossipToShare();
				}
				if (groups.get(i).getAmountOfPeopleAtGroup() == 0) {
					groups.removeAt(i);
				}
			}
		}
	}

	@Override
	public Iterator<Person> listGroupMembers(Person person) {
		return groups.get(this.searchIndexOfPersonGroup(person)).listGroupMembers();
	}

	@Override
	public Iterator<Group> listGroups() {
		return groups.iterator();
	}

	@Override
	public int numberOfGroups() {
		return groups.size();
	}

	@Override
	public void removeFromGroup(Person person) {
		groups.get(this.searchIndexOfPersonGroup(person)).removePerson(person);
	}

	private int searchIndexOfPersonGroup(Person person) {
		int index = -1;
		int i = 0;
		while (i < groups.size() && index == -1) {
			if (groups.get(i).hasPerson(person)) {
				index = i;
			}
			i++;
		}
		return index;
	}

	@Override
	public int getAmountOfPeopleAtGroup(Person person) {
		return groups.get(this.searchIndexOfPersonGroup(person)).getAmountOfPeopleAtGroup();
	}

	@Override
	public void isolatePerson(Person person) {
		groups.get(this.searchIndexOfPersonGroup(person)).removePerson(person);
		groups.insertLast(new GroupClass(person));
	}

	@Override
	public void shareGossip(Person person) {
		String type = person.getType();
		Group g = groups.get(this.searchIndexOfPersonGroup(person));
		switch (type) {
		case GOSSIPER_TYPE -> {
			int i = 0;
			while (i < person.getNumberOfGossips() && i < 3) {
				Gossip gossip = person.shareGossips();
				g.shareGossips(gossip, person);
				this.lastSharedGossips.insertLast(gossip);
				i++;
			}
		}
		case FORGETFUL_TYPE -> {
			Gossip gossip = person.shareGossips();
			g.shareGossips(gossip, person);
			this.lastSharedGossips.insertLast(gossip);
		}
		case SEALED_LIPS_TYPE -> {
			Gossip gossip = person.shareGossips();
			g.shareGossips(gossip, person);
			this.lastSharedGossips.insertLast(gossip);
		}
		}
	}

	public void resetLastSharedGossips() {
		for (int i = lastSharedGossips.size() - 1; i >= 0; i--)
			this.lastSharedGossips.removeAt(i);
	}

	public Iterator<Gossip> listSharedGossips() {
		Array<Gossip> tmp = this.lastSharedGossips;
		return tmp.iterator();
	}

	@Override
	public void removePersonFromLandmark(Person person) {
		this.removePersonThatIsJoiningOtherGroup(person);
		this.peopleAtLandmark.removeAt(this.peopleAtLandmark.searchIndexOf(person));
		this.currentOccupation--;
	}
}
