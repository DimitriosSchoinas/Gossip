package Gossip;

import dataStructures.*;

public interface Community {

	/**
	 * verifies if the landmark already exists
	 * 
	 * @param name name of the landmark
	 * @return true if the landmark exists
	 */
	boolean hasLandmark(String name);

	/**
	 * adds a new landmark to the community
	 * 
	 * @param name name of the landmark
	 * @param size capacity of the landmark
	 */
	void addLandmark(String name, int size);

	/**
	 * lists all the objects of the landmark array
	 * 
	 * @return return the iterator of the Landmark array
	 */
	Iterator<Landmark> listLandmarks();

	/**
	 * verifies if the person is already in the system
	 * 
	 * @param name name of the person that we want to verify
	 * @return true if the person already exists
	 */
	boolean hasPerson(String name);

	/**
	 * adds a forgetful person in the community
	 * 
	 * @param name            name of the person that we want to add
	 * @param numberOfGossips number of gossips the person can remember
	 */
	void addForgetfulPerson(String name, int numberOfGossips);

	/**
	 * adds a gossiper person in the community
	 * 
	 * @param name name of the person that we want to add
	 */
	public void addGossiperPerson(String name);

	/**
	 * adds a sealed lips person in the community
	 * 
	 * @param name name of the person that we want to add
	 */
	void addSealedLipsPerson(String name);

	/**
	 * lists all the objects of the person array
	 * 
	 * @return return the iterator of the Person array
	 */
	Iterator<Person> listPeople();

	/**
	 * gives the current location of the person
	 * 
	 * @param name name of the person
	 * @return the current location of the person
	 */
	String currentPersonLocation(String name);

	/**
	 * verifies if the landmark is full or not
	 * 
	 * @param place name of the landmark
	 * @return return true if the landmark is full
	 */
	boolean isLandmarkFull(String landmark);

	/**
	 * moves the person to a landmark or home
	 * 
	 * @param name     name of the person that we want to move to the landmark
	 * @param landmark place where we want to move the person to
	 */
	void movePerson(String name, String landmark);

	/**
	 * verifies if two people are in the same group
	 * 
	 * @param namePerson1 name of the first person
	 * @param namePerson2 name of the second person
	 * @param landmark    landmark where are the people
	 * @return return true if the 2 people are in the same group
	 */
	boolean areBothOnSameGroup(String namePerson1, String namePerson2, String landmark);

	/**
	 * joins a person to a group
	 * 
	 * @param namePerson1 name of the first person
	 * @param namePerson2 name of the second person
	 * @param landmark    landmark where the groups are
	 */
	void joinGroup(String namePerson1, String namePerson2, String landmark);

	/**
	 * lists the members of a group
	 * 
	 * @param namePerson1 name of a person that is in the group
	 * @param landmark    landmark where the group is inserted
	 * @return return the iterator that lists the people of the group
	 */
	Iterator<Person> listGroupMembers(String namePerson1, String landmark);

	/**
	 * verifies if the landmark is empty
	 * 
	 * @param landmark name of the landmark
	 * @return return true if the landmark is empty
	 */
	boolean isLandmarkEmpty(String landmark);

	/**
	 * lists the groups composition in a landmark
	 * 
	 * @param landmark name of the landmark where the groups are
	 * @return return the iterator that lists all the groups of the landmark
	 */
	Iterator<Group> listGroups(String landmark);

	/**
	 * shows the number of groups of the landmark
	 * 
	 * @param landmark name of the landmark where the groups are
	 * @return returns the number of groups that are in the landmark
	 */
	int numberOfGroups(String landmark);

	/**
	 * verifies if the person is alone in the group
	 * 
	 * @param name     name of the person that we want to check if is alone
	 * @param landmark landmark where the person is
	 * @return returns true if the person is alone in the group
	 */
	boolean isPersonAloneAtGroup(String name, String landmark);

	/**
	 * makes a person leave the current group, but not the landmark the person is
	 * currently on
	 * 
	 * @param name     name of the person that we want to isolate
	 * @param landmark landmark where the person is
	 */
	void isolatePerson(String name, String landmark);

	/**
	 * finds the index of the target that does not exist in the community
	 * 
	 * @param targetPeople array of the names of the people that are targets
	 * @return return the index of the target that does not exist in the community
	 */
	int findNotExistentTargetIndex(Array<String> targetPeople);

	/**
	 * finds the name of the target that does not exist
	 * 
	 * @param targetPeople array of the names of the people that are targets
	 * @return return the name of the target that does not exist
	 */
	String getNotFoundTargetName(Array<String> targetPeople);

	/**
	 * verifies if there is a duplicated gossip
	 * 
	 * @param name         name of the creator of the gossip
	 * @param targetPeople array that has the name name of the people that are
	 *                     targets of the gossip
	 * @param description  description of the gossip
	 * @return return true if the gossip is duplicated
	 */
	boolean hasSimilarGossip(String name, Array<String> targetPeople, String description);

	/**
	 * 
	 * @param name         name of the creator of the gossip
	 * @param targetPeople array that has the name of the people that are targets of
	 *                     the gossip
	 * @param description  description of the gossip
	 */
	void startGossip(String name, Array<String> targetPeople, String description);

	/**
	 * gets the number of gossips that a person knows
	 * 
	 * @param name name of the person that we want to find information
	 * @return return the number of gossips that the person knows
	 */
	int getNumberOfPersonGossips(String name);

	/**
	 * share a gossip within the current group in the current landmark
	 * 
	 * @param name     name of the person that is sharing the gossip
	 * @param landmark landmark where the person that is sharing the gossip is
	 */
	void shareGossips(String name, String landmark);

	/**
	 * verifies if the person is able to share gossips or not
	 * 
	 * @param name name of the person that we want to find information
	 * @return return true if the person can share gossips
	 */
	boolean canShareGossips(String name);

	/**
	 * lists all the gossips that a person shared
	 * 
	 * @param name name of the person that shared the gossips
	 * @return return the iterator that lists all the gossips that a person shared
	 */
	Iterator<Gossip> listSharedGossips(String name);

	void resetLastSharedGossips(String landmark);

	/**
	 * verifies if there is any gossip about the person
	 * 
	 * @param name name of the person that we want to check
	 * @return return true if there is any gossip about the person
	 */
	boolean hasAnySecrets(String name);

	/**
	 * lists the gossip about a particular person
	 * 
	 * @param name name of the person that we want to know about
	 * @return return the iterator that lists all the gossips that have been made
	 *         about this person
	 */
	Iterator<Gossip> listSecretGossips(String name);

	/**
	 * gives the type of person(forgetful or gossiper or sealed lips)
	 * 
	 * @param name name of the person that we want to know about
	 * @return return the type of person(forgetful or gossiper or sealed lips)
	 */
	String getPersonType(String name);

	/**
	 * lists the gossips a particular person is aware of
	 * 
	 * @param name name of the person that we want to list the gossips
	 * @return return the iterator that lists the gossips a particular person is
	 *         aware of
	 */
	Iterator<Gossip> listGossipsKnownToPerson(String name);

	/**
	 * verifies if there are gossips that have been shared or not
	 * 
	 * @return return true if exists any gossip that has been shared
	 */
	boolean hasAnyGossipBeenShared();

	/**
	 * checks if exist any gossips in the community
	 * 
	 * @return return true if there are gossips
	 */
	boolean areThereAnyGossips();

	/**
	 * gets the number of times that the most shared gossip has been shared
	 * 
	 * @return return the number of times that the most shared gossip has been
	 *         shared
	 */
	int maxAmountOfShares();

	/**
	 * lists the most shared gossip(s)
	 * 
	 * @return return the iterator that lists the most shared gossip(s)
	 */
	Iterator<Gossip> listMostSharedGossips();
}
