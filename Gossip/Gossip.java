package Gossip;

import dataStructures.*;

public interface Gossip {

	/**
	 * verifies if there is a duplicated gossip
	 * 
	 * @param creatorName name of the creator of the gossip
	 * @param description description of the gossip
	 * @return return true if the gossip is duplicated
	 */
	boolean isDuplicateGossip(String creatorName, String description);

	/**
	 * gets the name of the creator of the gossip
	 * 
	 * @return return the name of the creator of the gossip
	 */
	String getCreatorName();

	/**
	 * verifies if the person is a target
	 * 
	 * @param name name of the person that we want to see if is a target
	 * @return return true if the person is a target
	 */
	boolean isPersonATarget(String name);

	/**
	 * gets the description of the gossip
	 * 
	 * @return return the description of the gossip
	 */
	String getGossipDescription();

	/**
	 * adds a person to the list of people that know about the gossip
	 * 
	 * @param person person who know the gossip
	 */
	void addPeopleWhoKnowTheGossip(Person person);

	/**
	 * gets the number of people that know about the gossip
	 * 
	 * @return return the number of people that know about the gossip
	 */
	int getAmountOfPeopleWhoKnowTheGossip();

	/**
	 * gets the number of times that the gossip has been shared
	 * 
	 * @return return the number of times that the gossip has been shared
	 */
	int getNumberOfTimesShared();

	/**
	 * increases the number of times that the gossip has been shared by 1
	 */
	void addNumberOfTimesShared();

	/**
	 * verifies if the person already knew about the gossip or not
	 * 
	 * @param person person that we want to check if already knew about the gossip
	 * @return return true if the person already knew about the gossip
	 */
	boolean didPersonAlreadyKnowTheGossip(Person person);
}
