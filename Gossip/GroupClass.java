package Gossip;

import dataStructures.*;

public class GroupClass implements Group {

	private Array<Person> groupMembers;

	public GroupClass(Person firstPerson) {
		groupMembers = new ArrayClass<>();
		groupMembers.insertLast(firstPerson);
	}

	public void addPerson(Person person) {
		groupMembers.insertLast(person);
	}

	public boolean hasPerson(Person person) {
		return this.groupMembers.searchIndexOf(person) >= 0;
	}

	@Override
	public void removePerson(Person person) {
		groupMembers.removeAt(groupMembers.searchIndexOf(person));
	}

	@Override
	public int getAmountOfPeopleAtGroup() {
		return groupMembers.size();
	}

	public Iterator<Person> listGroupMembers() {
		return groupMembers.iterator();
	}

	@Override
	public void shareGossips(Gossip gossip, Person person) {
		for (int i = 0; i < groupMembers.size(); i++) {
			if (!groupMembers.get(i).equals(person)) {
				if (!gossip.didPersonAlreadyKnowTheGossip(groupMembers.get(i))) {
					gossip.addPeopleWhoKnowTheGossip(groupMembers.get(i));
					groupMembers.get(i).addGossip(gossip);
				}
			}
		}
		gossip.addNumberOfTimesShared();
	}
}
