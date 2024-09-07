import dataStructures.*;
import java.util.Scanner;
import Gossip.*;

public class Main {

	/**
	 * user commands
	 */
	private static final String EXIT = "EXIT";
	private static final String HELP = "HELP";
	private static final String LANDMARK = "LANDMARK";
	private static final String LANDMARKS = "LANDMARKS";
	private static final String FORGETFUL = "FORGETFUL";
	private static final String GOSSIPER = "GOSSIPER";
	private static final String SEALED = "SEALED";
	private static final String PEOPLE = "PEOPLE";
	private static final String GO = "GO";
	private static final String JOIN = "JOIN";
	private static final String GROUPS = "GROUPS";
	private static final String ISOLATE = "ISOLATE";
	private static final String START = "START";
	private static final String GOSSIP = "GOSSIP";
	private static final String SECRETS = "SECRETS";
	private static final String INFOTAINMENT = "INFOTAINMENT";
	private static final String HOTTEST = "HOTTEST";

	/**
	 * help command lines
	 */
	private static final String EXIT_H = "exit - terminates the execution of the program\n";
	private static final String LANDMARK_H = "landmark - adds a new landmark to the community\n";
	private static final String LANDMARKS_H = "landmarks - displays the list of landmarks in the community\n";
	private static final String FORGETFUL_H = "forgetful - adds a forgetful person to the community\n";
	private static final String GOSSIPER_H = "gossiper - adds a gossiper person to the community\n";
	private static final String SEALED_H = "sealed - adds a sealed lips person to the community\n";
	private static final String PEOPLE_H = "people - lists all the persons in the community\n";
	private static final String GO_H = "go - moves a person to a landmark, or home\n";
	private static final String JOIN_H = "join - joins a person to a group\n";
	private static final String GROUPS_H = "groups - lists the groups composition in a landmark\n";
	private static final String ISOLATE_H = "isolate - makes a person leave the current group, but not the landmark the person is currently on\n";
	private static final String START_H = "start - starts a new gossip\n";
	private static final String GOSSIP_H = "gossip - share a gossip within the current group in the current landmark\n";
	private static final String SECRETS_H = "secrets - lists the gossip about a particular person\n";
	private static final String INFOTAINMENT_H = "infotainment - lists the gossips a particular person is aware of\n";
	private static final String HOTTEST_H = "hottest - lists the most shared gossip\n";
	private static final String HELP_H = "help - shows the available commands\n";
	/**
	 * types constant and home constant
	 */
	private static final String HOME = "home";
	private static final String FORGETFUL_TYPE = "forgetful";
	private static final String GOSSIPER_TYPE = "gossiper";
	private static final String SEALED_LIPS_TYPE = "sealed";
	/**
	 * program feedback
	 */
	private static final String EXITING = "Bye!\n";
	private static final String UNKNOWN_COMMAND = "Unknown command. Type help to see available commands.\n";
	private static final String HELP_COMMAND = LANDMARK_H + LANDMARKS_H + FORGETFUL_H + GOSSIPER_H + SEALED_H + PEOPLE_H
			+ GO_H + JOIN_H + GROUPS_H + ISOLATE_H + START_H + GOSSIP_H + SECRETS_H + INFOTAINMENT_H + HOTTEST_H
			+ HELP_H + EXIT_H;
	private static final String INVALID_LANDMARK_CAPACITY = "Invalid landmark capacity %d!\n";
	private static final String INVALID_LANDMARK_NAME = "Cannot create a landmark called home. You know, there is no place like home!\n";
	private static final String LANDMARK_ALREADY_EXISTS = "Landmark %s already exists!\n";
	private static final String LANDMARK_ADDED = "%s added.\n";
	private static final String LANDMARK_LISTING_ERROR = "This community does not have any landmarks yet!\n";
	private static final String LANDMARK_LISTING_SUCCESS = "%s: %d %d.\n";
	private static final String FORGETFUL_SUCCESS = "%s can only remember up to %d gossips.\n";
	private static final String INVALID_GOSSIPS_CAPACITY = "Invalid gossips capacity %d!\n";
	private static final String NAME_ALREADY_EXISTS = "%s already exists!\n";
	private static final String GOSSIPER_SUCCESS = "%s is a gossiper.\n";
	private static final String SEALED_SUCCESS = "%s lips are sealed.\n";
	private static final String PEOPLE_LISTING_ERROR = "This community does not have any people yet!\n";
	private static final String PEOPLE_LISTING_SUCCESS = "%s at %s knows %d gossips.\n";
	private static final String GO_SUCCESS = "%s is now at %s.\n";
	private static final String NAME_DOESNT_EXIST = "%s does not exist!\n";
	private static final String UNKNOWN_PLACE = "Unknown place %s!\n";
	private static final String SAME_PLACE_ERROR = "What do you mean go to %s? %s is already there!\n";
	private static final String LANDMARK_MAX_CAPACITY = "%s is too crowded! %s went home.\n";
	private static final String JOIN_SUCCESS_HEADER = "%s joined ";
	private static final String JOIN_SUCCESS_BODY = "%s, ";
	private static final String JOIN_SUCCESS_END = "at the %s.\n";
	private static final String JOIN_SAME_PERSON = "%s needs company from someone else!\n";
	private static final String IS_AT_HOME = "%s is at home!\n";
	private static final String NOT_IN_SAME_LANDMARK = "%s is not in %s!\n";
	private static final String SAME_GROUP_ERROR = "%s and %s are already in the same group!\n";
	private static final String GROUPS_SUCCESS_HEADER = "%d groups at %s:\n";
	private static final String GROUPS_SUCCESS_BODY_START = "%s";
	private static final String GROUPS_SUCCESS_BODY = ", %s";
	private static final String GROUPS_HOME_ERROR = "You must understand we have no surveillance tech at home! Privacy is our top concern!\n";
	private static final String EMPTY_LANDMARK_ERROR = "Nobody is at %s!\n";
	private static final String ISOLATE_SUCCESS = "%s is now alone at %s.\n";
	private static final String ALREADY_ALONE_ERROR = "%s is already alone!\n";
	private static final String START_SUCCESS_HEADER = "Have you heard about %s";
	private static final String START_SUCCESS_BODY = ", %s";
	private static final String START_SUCCESS_END = "? %s\n";
	private static final String INVALID_GOSSIP_TARGETS = "Invalid number %d of gossip targets!\n";
	private static final String DUPLICATED_GOSSIP = "Duplicate gossip!\n";
	private static final String GOSSIP_SUCCESS_HEADER = "%s shared with ";
	private static final String GOSSIP_SUCCESS_BODY = "%s, ";
	private static final String GOSSIP_SUCCESS_END = "some hot news!\n";
	private static final String GOSSIP_SUCCESS_GOSSIP_LIST = "%s\n";
	private static final String GOSSIP_SEALED_TYPE_NO_GOSSIPS_ERROR = "%s does not wish to gossip right now!";
	private static final String GOSSIP_ALONE_ERROR = "%s has nobody to gossip with right now!\n";
	private static final String GOSSIP_NO_GOSSIPS_ERROR = "%s knows nothing!\n";
	private static final String SECRETS_ERROR = "%s lives a very boring life!\n";
	private static final String SECRETS_SUCCESS = "%d %s\n";
	private static final String INFOTAINMENT_ERROR = "%s knows nothing!\n";
	private static final String INFOTAINMENT_SUCCESS_HEADER = "%s knows things:\n";
	private static final String INFOTAINMENT_SUCCESS_BODY = "%s\n";
	private static final String HOTTEST_SUCCESS_HEADER = "The hottest gossips were shared %d times!\n";
	private static final String HOTTEST_SUCCESS_BODY = "%s\n";
	private static final String HOTTEST_UNKNOWN_GOSSIPS = "No gossips we are aware of!\n";
	private static final String NO_SHARED_GOSSIPS = "No gossips were shared, yet!\n";

	/**
	 * Main program. Invokes the command interpreter
	 * 
	 * @param args - arguments for running the application. Not used in this
	 *             program.
	 */
	public static void main(String[] args) {

		Main.commands();
	}

	/**
	 * command interpreter
	 */
	private static void commands() {
		Community community = new CommunityClass();
		Scanner input = new Scanner(System.in);
		String command;
		do {
			command = input.next().toUpperCase();
			switch (command) {
			case HELP -> System.out.printf(HELP_COMMAND);
			case LANDMARK -> addLandmark(input, community);
			case LANDMARKS -> listLandmarks(community);
			case FORGETFUL -> addForgetful(input, community);
			case GOSSIPER -> addGossiper(input, community);
			case SEALED -> addSealed(input, community);
			case PEOPLE -> listPeople(community);
			case GO -> go(input, community);
			case JOIN -> join(input, community);
			case GROUPS -> listGroups(input, community);
			case ISOLATE -> isolate(input, community);
			case START -> start(input, community);
			case GOSSIP -> shareGossip(input, community);
			case SECRETS -> listSecrets(input, community);
			case INFOTAINMENT -> listInfotainment(input, community);
			case HOTTEST -> listHottest(community);
			case EXIT -> System.out.printf(EXITING);
			default -> System.out.printf(UNKNOWN_COMMAND);
			}
		} while (!command.equals(EXIT));
		input.close();
	}

	/**
	 * lists the most shared gossip
	 * 
	 * @param community community where we will list the most shared gossip
	 */
	private static void listHottest(Community community) {
		if (!community.areThereAnyGossips()) {
			System.out.printf(HOTTEST_UNKNOWN_GOSSIPS);
		} else if (!community.hasAnyGossipBeenShared()) {
			System.out.printf(NO_SHARED_GOSSIPS);
		} else {
			Iterator<Gossip> it = community.listMostSharedGossips();
			System.out.printf(HOTTEST_SUCCESS_HEADER, community.maxAmountOfShares());
			while (it.hasNext()) {
				Gossip g = it.next();
				System.out.printf(HOTTEST_SUCCESS_BODY, g.getGossipDescription());
			}
		}
	}

	/**
	 * lists the gossips a particular person is aware of
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will list the gossips a particular person
	 *                  is aware of
	 */
	private static void listInfotainment(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (community.getNumberOfPersonGossips(name) == 0) {
			System.out.printf(INFOTAINMENT_ERROR, name);
		} else {
			Iterator<Gossip> it = community.listGossipsKnownToPerson(name);
			System.out.printf(INFOTAINMENT_SUCCESS_HEADER, name);
			while (it.hasNext()) {
				Gossip g = it.next();
				System.out.printf(INFOTAINMENT_SUCCESS_BODY, g.getGossipDescription());
			}
		}
	}

	/**
	 * lists the gossip(s) about a particular person
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will list the gossip(s) about a
	 *                  particular person
	 */
	private static void listSecrets(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (!community.hasAnySecrets(name)) {
			System.out.printf(SECRETS_ERROR, name);
		} else {
			Iterator<Gossip> it = community.listSecretGossips(name);
			while (it.hasNext()) {
				Gossip g = it.next();
				System.out.printf(SECRETS_SUCCESS, g.getAmountOfPeopleWhoKnowTheGossip(), g.getGossipDescription());
			}
		}
	}

	/**
	 * share a gossip within the current group in the current landmark
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will share the gossip
	 */
	private static void shareGossip(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (community.currentPersonLocation(name).equals(HOME)
				|| community.isPersonAloneAtGroup(name, community.currentPersonLocation(name))) {
			System.out.printf(GOSSIP_ALONE_ERROR, name);
		} else if (community.getNumberOfPersonGossips(name) == 0) {
			System.out.printf(GOSSIP_NO_GOSSIPS_ERROR, name);
		} else if (!community.canShareGossips(name) && community.getPersonType(name).equals(SEALED_LIPS_TYPE)) {
			System.out.printf(GOSSIP_SEALED_TYPE_NO_GOSSIPS_ERROR, name);
		} else {
			community.shareGossips(name, community.currentPersonLocation(name));
			Iterator<Person> it = community.listGroupMembers(name, community.currentPersonLocation(name));
			System.out.printf(GOSSIP_SUCCESS_HEADER, name);
			while (it.hasNext()) {
				Person p = it.next();
				if (!p.getName().equals(name)) {
					System.out.printf(GOSSIP_SUCCESS_BODY, p.getName());
				}
			}
			System.out.printf(GOSSIP_SUCCESS_END);
			Iterator<Gossip> itGossips = community.listSharedGossips(community.currentPersonLocation(name));
			while (itGossips.hasNext()) {
				Gossip g = itGossips.next();
				System.out.printf(GOSSIP_SUCCESS_GOSSIP_LIST, g.getGossipDescription());
			}
			community.resetLastSharedGossips(community.currentPersonLocation(name));
		}
	}

	/**
	 * starts a new gossip
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will start the new gossip
	 */
	private static void start(Scanner input, Community community) {

		String name = input.nextLine().trim();
		int n = input.nextInt();
		input.nextLine().trim();
		int line = 0;
		Array<String> targetPeople = new ArrayClass<>();
		while (line < n) {
			String target = input.nextLine().trim();

			targetPeople.insertLast(target);
			line++;
		}
		String gossip = input.nextLine().trim();

		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (n <= 0) {
			System.out.printf(INVALID_GOSSIP_TARGETS, n);
		} else if (community.findNotExistentTargetIndex(targetPeople) != -1) {
			System.out.printf(NAME_DOESNT_EXIST, community.getNotFoundTargetName(targetPeople));
		} else if (community.hasSimilarGossip(name, targetPeople, gossip)) {
			System.out.printf(DUPLICATED_GOSSIP);
		} else {
			Iterator<String> it = targetPeople.iterator();
			String targets = it.next();
			System.out.printf(START_SUCCESS_HEADER, targets);
			while (it.hasNext()) {
				targets = it.next();
				System.out.printf(START_SUCCESS_BODY, targets);
			}
			System.out.printf(START_SUCCESS_END, gossip);
			community.startGossip(name, targetPeople, gossip);
		}

	}

	/**
	 * makes a person leave the current group, but not the landmark the person is
	 * currently on
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will remove the person from their group
	 */
	private static void isolate(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (community.currentPersonLocation(name).equals(HOME)) {
			System.out.printf(IS_AT_HOME, name);
		} else if (community.isPersonAloneAtGroup(name, community.currentPersonLocation(name))) {
			System.out.printf(ALREADY_ALONE_ERROR, name);
		} else {
			System.out.printf(ISOLATE_SUCCESS, name, community.currentPersonLocation(name));
			community.isolatePerson(name, community.currentPersonLocation(name));
		}
	}

	/**
	 * lists the groups composition in a landmark
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will list the groups composition
	 */
	private static void listGroups(Scanner input, Community community) {
		String landmark = input.nextLine().trim();
		if (landmark.equals(HOME)) {
			System.out.printf(GROUPS_HOME_ERROR);
		} else if (!community.hasLandmark(landmark)) {
			System.out.printf(NAME_DOESNT_EXIST, landmark);
		} else if (community.isLandmarkEmpty(landmark)) {
			System.out.printf(EMPTY_LANDMARK_ERROR, landmark);
		} else {
			System.out.printf(GROUPS_SUCCESS_HEADER, community.numberOfGroups(landmark), landmark);
			Iterator<Group> it = community.listGroups(landmark);
			while (it.hasNext()) {
				Group g = it.next();
				Iterator<Person> itPerson = g.listGroupMembers();
				Person p1 = itPerson.next();
				System.out.printf(GROUPS_SUCCESS_BODY_START, p1.getName());
				while (itPerson.hasNext()) {
					Person p = itPerson.next();
					System.out.printf(GROUPS_SUCCESS_BODY, p.getName());
				}
				System.out.println();
			}
		}
	}

	/**
	 * joins a person to a group
	 * 
	 * @param input     the input from which the data will be read
	 * @param community community where we will add a person to a group
	 */
	private static void join(Scanner input, Community community) {
		String namePerson1 = input.nextLine().trim();
		String namePerson2 = input.nextLine().trim();
		if (namePerson1.equals(namePerson2)) {
			System.out.printf(JOIN_SAME_PERSON, namePerson1);
		} else if (!community.hasPerson(namePerson1)) {
			System.out.printf(NAME_DOESNT_EXIST, namePerson1);
		} else if (!community.hasPerson(namePerson2)) {
			System.out.printf(NAME_DOESNT_EXIST, namePerson2);
		} else if (community.currentPersonLocation(namePerson1).equals(HOME)) {
			System.out.printf(IS_AT_HOME, namePerson1);
		} else if (!community.currentPersonLocation(namePerson2).equals(community.currentPersonLocation(namePerson1))) {
			System.out.printf(NOT_IN_SAME_LANDMARK, namePerson2, community.currentPersonLocation(namePerson1));
		} else if (community.areBothOnSameGroup(namePerson1, namePerson2,
				community.currentPersonLocation(namePerson1))) {
			System.out.printf(SAME_GROUP_ERROR, namePerson1, namePerson2);
		} else {
			System.out.printf(JOIN_SUCCESS_HEADER, namePerson1);
			Iterator<Person> it = community.listGroupMembers(namePerson2, community.currentPersonLocation(namePerson1));
			while (it.hasNext()) {
				Person p = it.next();
				System.out.printf(JOIN_SUCCESS_BODY, p.getName());
			}
			System.out.printf(JOIN_SUCCESS_END, community.currentPersonLocation(namePerson2));
			community.joinGroup(namePerson1, namePerson2, community.currentPersonLocation(namePerson2));
		}
	}

	/**
	 * moves a person to a landmark or home
	 * 
	 * @param input     the input where the data will be read
	 * @param community community where we want to find the person to move
	 */
	private static void go(Scanner input, Community community) {
		String name = input.nextLine().trim();
		String landmark = input.nextLine().trim();
		if (!community.hasPerson(name)) {
			System.out.printf(NAME_DOESNT_EXIST, name);
		} else if (!community.hasLandmark(landmark)) {
			System.out.printf(UNKNOWN_PLACE, landmark);
		} else if (community.currentPersonLocation(name).equals(landmark)) {
			System.out.printf(SAME_PLACE_ERROR, landmark, name);
		} else if (community.isLandmarkFull(landmark)) {
			System.out.printf(LANDMARK_MAX_CAPACITY, landmark, name);
			community.movePerson(name, HOME);
		} else {
			System.out.printf(GO_SUCCESS, name, landmark);
			community.movePerson(name, landmark);
		}
	}

	/**
	 * lists all the people on the community
	 * 
	 * @param community community where we want to list the people
	 */
	private static void listPeople(Community community) {

		Iterator<Person> it = community.listPeople();

		if (it.hasNext()) {
			while (it.hasNext()) {
				Person person = it.next();
				System.out.printf(PEOPLE_LISTING_SUCCESS, person.getName(), person.getCurrentLocation(),
						person.getNumberOfGossips());
			}
		} else {
			System.out.printf(PEOPLE_LISTING_ERROR);
		}
	}

	/**
	 * adds a sealed lips person in the community
	 * 
	 * @param input     the input where the data will be read
	 * @param community community where we want to add the sealed lips person
	 */

	private static void addSealed(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (community.hasPerson(name))
			System.out.printf(NAME_ALREADY_EXISTS, name);
		else {
			community.addSealedLipsPerson(name);
			System.out.printf(SEALED_SUCCESS, name);
		}
	}

	/**
	 * adds a gossiper person in the community
	 * 
	 * @param input     the input where the data will be read
	 * @param community community where we want to add the gossiper person
	 */

	private static void addGossiper(Scanner input, Community community) {
		String name = input.nextLine().trim();
		if (community.hasPerson(name))
			System.out.printf(NAME_ALREADY_EXISTS, name);
		else {
			community.addGossiperPerson(name);
			System.out.printf(GOSSIPER_SUCCESS, name);
		}
	}

	/**
	 * adds a forgetful person in the community
	 * 
	 * @param input     the input where the data will be read
	 * @param community community where we want to add the forgetful person
	 */

	private static void addForgetful(Scanner input, Community community) {
		int numberOfGossips = input.nextInt();
		String name = input.nextLine().trim();
		if (numberOfGossips <= 0)
			System.out.printf(INVALID_GOSSIPS_CAPACITY, numberOfGossips);
		else if (community.hasPerson(name))
			System.out.printf(NAME_ALREADY_EXISTS, name);
		else {
			community.addForgetfulPerson(name, numberOfGossips);
			System.out.printf(FORGETFUL_SUCCESS, name, numberOfGossips);
		}
	}

	/**
	 * lists all the landmarks in the community
	 * 
	 * @param community community that has the landmarks
	 */

	private static void listLandmarks(Community community) {
		Iterator<Landmark> it = community.listLandmarks();
		if (it.hasNext()) {
			while (it.hasNext()) {
				Landmark l = it.next();
				System.out.printf(LANDMARK_LISTING_SUCCESS, l.getName(), l.getSize(), l.getCurrentOccupation());
			}
		} else
			System.out.printf(LANDMARK_LISTING_ERROR);
	}

	/**
	 * adds a new landmark in the community
	 * 
	 * @param input     the input where the data will be read
	 * @param community community where we will add the landmarks
	 */

	private static void addLandmark(Scanner input, Community community) {
		int size = input.nextInt();
		String name = input.nextLine().trim();
		if (size <= 0) {
			System.out.printf(INVALID_LANDMARK_CAPACITY, size);
		} else if (name.equals(HOME)) {
			System.out.printf(INVALID_LANDMARK_NAME);
		} else if (community.hasLandmark(name)) {
			System.out.printf(LANDMARK_ALREADY_EXISTS, name);
		} else {
			community.addLandmark(name, size);
			System.out.printf(LANDMARK_ADDED, name);
		}
	}

}
