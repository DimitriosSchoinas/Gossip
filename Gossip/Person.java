package Gossip;

import dataStructures.*;

public interface Person {

	/**
	 * gets the name of the person
	 * 
	 * @return return the name of the person
	 */
	String getName();

	/**
	 * gets the type of the person
	 * 
	 * @return return the type of the person
	 */
	String getType();

	/**
	 * shows the number of gossips that the person knows
	 * 
	 * @return return the number of gossips that the person knows
	 */
	int getNumberOfGossips();

	/**
	 * shows the current location of the person
	 * 
	 * @return return the current location of the person
	 */
	String getCurrentLocation();

	/**
	 * moves the person to a landmark or home
	 * 
	 * @param landmark place where we want to move the person to
	 */
	void move(String landmark);

	/**
	 * adds a gossip to the list of gossips that the person knows
	 * 
	 * @param gossip gossip that we want to add
	 */
	void addGossip(Gossip gossip);

	/**
	 * verifies if the person is a target of the gossip
	 * 
	 * @return return true if the person is a target of the gossip
	 */
	public boolean isPersonATarget();

	/**
	 * this command shares a gossip(s)
	 * 
	 * @return return the gossips that the person shared
	 */
	Gossip shareGossips();

	/**
	 * resets the index of the current gossip that we are sharing to 0
	 */
	void resetIndexOfGossipToShare();

	/**
	 * lists the gossips a particular person is aware of
	 * 
	 * @return return the iterator that lists the gossips a particular person is
	 *         aware of
	 */
	Iterator<Gossip> listKnownGossips();
}
