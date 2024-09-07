package Gossip;

import dataStructures.*;

public interface Group {
	/**
	 * adds a person to the group
	 * 
	 * @param person person that we want to add
	 */
	void addPerson(Person person);

	/**
	 * verifies if the person already exists in the group
	 * 
	 * @param person person that we want to check if already exists in the group
	 * @return return true if the person already exists in the group
	 */
	boolean hasPerson(Person person);

	/**
	 * removes a person from the group
	 * 
	 * @param person person that we want to remove
	 */
	void removePerson(Person person);

	/**
	 * gets the amount of people in the group
	 * 
	 * @return return the amount of people in the group
	 */
	int getAmountOfPeopleAtGroup();

	/**
	 * lists all the group members
	 * 
	 * @return return the iterator that lists the group members
	 */
	Iterator<Person> listGroupMembers();

	/**
	 * shares the gossip(s) to the group
	 * 
	 * @param gossip gossip that we want to share
	 * @param person person that is sharing the gossip
	 */
	void shareGossips(Gossip gossip, Person person);
}
