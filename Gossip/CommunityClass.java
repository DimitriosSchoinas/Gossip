package Gossip;

import dataStructures.*;

public class CommunityClass implements Community {

	private static final String HOME = "home";
	private static final String FORGETFUL_TYPE = "forgetful";
	private static final String GOSSIPER_TYPE = "gossiper";
	private static final String SEALED_LIPS_TYPE = "sealed";
	private Array<Person> people;
	private Array<Landmark> landmarks;
	private Array<Gossip> gossips;

	public CommunityClass() {
		people = new ArrayClass<>();
		landmarks = new ArrayClass<>();
		gossips = new ArrayClass<>();
	}

	@Override
	public boolean hasLandmark(String name) {
		return this.searchIndexLandmarks(name) >= 0;
	}

	@Override
	public void addLandmark(String name, int size) {
		landmarks.insertLast(new LandmarkClass(name, size));
	}

	private int searchIndexLandmarks(String name) {
		int index = -1;
		int i = 0;
		while(i < landmarks.size() && index == -1) {
			if (landmarks.get(i).getName().equals(name)) {
				index = i;
			}
			i++;
		}
		return index;
	}

	public Iterator<Landmark> listLandmarks() {
		return landmarks.iterator();
	}

	@Override
	public boolean hasPerson(String name) {
		return this.searchIndexPerson(name) >= 0;
	}

	private int searchIndexPerson(String name) {
		int index = -1;
		int i = 0;
		while (i < people.size() && index == -1) {
			if (people.get(i).getName().equals(name)) {
				index = i;
			}
			i++;
		}
		return index;
	}

	@Override
	public void addForgetfulPerson(String name, int numberOfGossips) {
		people.insertLast(new ForgetfulPersonClass(name, FORGETFUL_TYPE, numberOfGossips));
	}

	@Override
	public void addGossiperPerson(String name) {
		people.insertLast(new GossiperPersonClass(name, GOSSIPER_TYPE));
	}

	@Override
	public void addSealedLipsPerson(String name) {
		people.insertLast(new SealedLipsPersonClass(name, SEALED_LIPS_TYPE));
	}

	@Override
	public Iterator<Person> listPeople() {
		return people.iterator();
	}

	@Override
	public String currentPersonLocation(String name) {
		Person p = people.get(searchIndexPerson(name));
		return p.getCurrentLocation();
	}

	@Override
	public boolean isLandmarkFull(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.getCurrentOccupation() == l.getSize();
	}

	public void movePerson(String name, String landmark) {
		Person p = people.get(searchIndexPerson(name));
		if (landmark.equals(HOME)) {
			if (!p.getCurrentLocation().equals(HOME)) {
				Landmark landmarkPersonCameFrom = landmarks.get(this.searchIndexLandmarks(p.getCurrentLocation()));
				landmarkPersonCameFrom.removePersonFromLandmark(p);
				p.move(HOME);
			}
		} else {
			Landmark landmarkToMoveTo = landmarks.get(this.searchIndexLandmarks(landmark));
			if (p.getCurrentLocation().equals(HOME)) {
				landmarkToMoveTo.addPersonToLocation(p);
				p.move(landmark);
			} else {
				Landmark landmarkPersonCameFrom = landmarks.get(this.searchIndexLandmarks(p.getCurrentLocation()));
				landmarkPersonCameFrom.removePersonFromLandmark(p);
				landmarkToMoveTo.addPersonToLocation(p);
				p.move(landmark);
			}
		}
	}

	@Override
	public boolean areBothOnSameGroup(String namePerson1, String namePerson2, String landmark) {
		Person p1 = people.get(this.searchIndexPerson(namePerson1));
		Person p2 = people.get(this.searchIndexPerson(namePerson2));
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.areBothOnSameGroup(p1, p2);
	}

	@Override
	public void joinGroup(String namePerson1, String namePerson2, String landmark) {
		Person p1 = people.get(this.searchIndexPerson(namePerson1));
		Person p2 = people.get(this.searchIndexPerson(namePerson2));
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		l.joinGroup(p1, p2);
	}

	@Override
	public Iterator<Person> listGroupMembers(String namePerson1, String landmark) {
		Person p = people.get(this.searchIndexPerson(namePerson1));
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.listGroupMembers(p);
	}

	@Override
	public boolean isLandmarkEmpty(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.getCurrentOccupation() == 0;
	}

	@Override
	public Iterator<Group> listGroups(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.listGroups();
	}

	@Override
	public int numberOfGroups(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.numberOfGroups();
	}

	public boolean isPersonAloneAtGroup(String name, String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		Person p = people.get(this.searchIndexPerson(name));
		return l.getAmountOfPeopleAtGroup(p) == 1;
	}

	@Override
	public void isolatePerson(String name, String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		Person p = people.get(this.searchIndexPerson(name));
		l.isolatePerson(p);
	}

	public int findNotExistentTargetIndex(Array<String> targetPeople) {

		int index = -1;
		int i = 0;
		while (i < targetPeople.size() && index == -1) {
			if (!hasPerson(targetPeople.get(i))) {
				index = i;
			}
			i++;
		}
		return index;
	}

	public String getNotFoundTargetName(Array<String> targetPeople) {

		return targetPeople.get(this.findNotExistentTargetIndex(targetPeople));
	}

	public boolean hasSimilarGossip(String name, Array<String> targetPeople, String description) {

		boolean result = false;
		int i = 0;
		while (i < gossips.size() && !result) {
			if (gossips.get(i).isDuplicateGossip(name, description)) {
				result = true;
			}
			i++;
		}
		return result;
	}

	public void startGossip(String name, Array<String> targetPeople, String description) {
		Array<Person> targetPeopleTmp = new ArrayClass<>();
		Person creator = people.get(this.searchIndexPerson(name));
		for (int i = 0; i < targetPeople.size(); i++) {
			Person p = people.get(this.searchIndexPerson(targetPeople.get(i)));
			targetPeopleTmp.insertLast(p);
		}
		Gossip g = new GossipClass(creator, targetPeopleTmp, description);
		gossips.insertLast(g);
		creator.addGossip(g);
	}

	@Override
	public int getNumberOfPersonGossips(String name) {
		Person p = people.get(this.searchIndexPerson(name));
		return p.getNumberOfGossips();
	}

	public void shareGossips(String name, String landmark) {
		Person p = people.get(this.searchIndexPerson(name));
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		l.shareGossip(p);
	}

	public String getPersonType(String name) {
		Person p = people.get(this.searchIndexPerson(name));
		return p.getType();
	}

	@Override
	public boolean canShareGossips(String name) {
		Person p = people.get(this.searchIndexPerson(name));
		return p.isPersonATarget();
	}

	public void resetLastSharedGossips(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		l.resetLastSharedGossips();
	}

	@Override
	public Iterator<Gossip> listSharedGossips(String landmark) {
		Landmark l = landmarks.get(this.searchIndexLandmarks(landmark));
		return l.listSharedGossips();
	}

	public boolean hasAnySecrets(String name) {
		boolean found = false;
		int i = 0;
		while (i < gossips.size() && !found) {
			if (gossips.get(i).isPersonATarget(name)) {
				found = true;

			}
			i++;
		}
		return found;
	}

	public Iterator<Gossip> listSecretGossips(String name) {
		Array<Gossip> tmp = new ArrayClass<>();
		for (int i = 0; i < gossips.size(); i++) {
			if (gossips.get(i).isPersonATarget(name)) {
				tmp.insertLast(gossips.get(i));
			}
		}
		return tmp.iterator();
	}

	@Override
	public Iterator<Gossip> listGossipsKnownToPerson(String name) {
		Person p = people.get(this.searchIndexPerson(name));
		return p.listKnownGossips();
	}

	public boolean areThereAnyGossips() {
		return gossips.size() > 0;
	}

	public boolean hasAnyGossipBeenShared() {
		boolean found = false;
		int i = 0;
		while (i < gossips.size() && !found) {
			if (gossips.get(i).getAmountOfPeopleWhoKnowTheGossip() != 0) {
				found = true;
			}
			i++;
		}
		return found;
	}

	@Override
	public int maxAmountOfShares() {
		int max = gossips.get(0).getNumberOfTimesShared();
		for (int i = 0; i < gossips.size(); i++) {
			if (gossips.get(i).getNumberOfTimesShared() > max) {
				max = gossips.get(i).getNumberOfTimesShared();
			}
		}
		return max;
	}

	@Override
	public Iterator<Gossip> listMostSharedGossips() {
		Array<Gossip> tmp = new ArrayClass<>();
		for (int i = 0; i < gossips.size(); i++) {
			if (gossips.get(i).getNumberOfTimesShared() == this.maxAmountOfShares()) {
				tmp.insertLast(gossips.get(i));
			}
		}
		return tmp.iterator();
	}
}