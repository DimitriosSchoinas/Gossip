package Gossip;

import dataStructures.*;

public interface Landmark {
	/**
	 * gives the capacity of the landmark
	 * 
	 * @return return the capacity of the landmark
	 */
	int getSize();

	/**
	 * gives the name of the landmark
	 * 
	 * @return return the name of the landmark
	 */
	String getName();

	/**
	 * gives the current number of people that are in the landmark
	 * 
	 * @return return the current number of people that are in the landmark
	 */
	int getCurrentOccupation();

	/**
	 * adds a person to the landmark
	 * 
	 * @param person person that we want to add
	 */
	void addPersonToLocation(Person person);

	/**
	 * joins a person to a group
	 * 
	 * @param personJoining person that is joining the group
	 * @param personToJoin  person that is in the group that the first person will
	 *                      join
	 */
	void joinGroup(Person personJoining, Person personToJoin);

	/**
	 * verifies if 2 people are in the same group
	 * 
	 * @param person first person that we want to check
	 * @param other  second person that we want to check
	 * @return return true if both people are in the same group
	 */
	boolean areBothOnSameGroup(Person person, Person other);

	/**
	 * lists all the group members
	 * 
	 * @param person person that is in the group
	 * @return return the iterator that lists all the group members
	 */
	Iterator<Person> listGroupMembers(Person person);

	/**
	 * lists all the groups of the landmark
	 * 
	 * @return return the iterator that lists all the groups of the landmark
	 */
	Iterator<Group> listGroups();

	/**
	 * gets the number of groups that are in the landmark
	 * 
	 * @return return the number of groups that are in the landmark
	 */
	int numberOfGroups();

	/**
	 * removes a person from a group
	 * 
	 * @param person person that we want to remove
	 */
	void removeFromGroup(Person person);

	/**
	 * gets the number of people in the group
	 * 
	 * @param person person that is in the group
	 * @return return the number of people in the group
	 */
	int getAmountOfPeopleAtGroup(Person person);

	/**
	 * makes a person leave the current group
	 * 
	 * @param person person that we want to remove from the group
	 * 
	 */
	void isolatePerson(Person person);

	/**
	 * shares a gossip to the group
	 * 
	 * @param person person that is sharing the gossip
	 */
	void shareGossip(Person person);

	/**
	 * lists all the shared gossips in the landmark
	 * 
	 * @return return the iterator that lists all the shared gossips in the landmark
	 */
	Iterator<Gossip> listSharedGossips();

	void resetLastSharedGossips();

	/**
	 * removes a person from the landmark
	 * 
	 * @param person person that we want to remove
	 */
	void removePersonFromLandmark(Person person);
}
