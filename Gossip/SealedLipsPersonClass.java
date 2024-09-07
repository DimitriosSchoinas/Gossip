package Gossip;

public class SealedLipsPersonClass extends AbstractPersonClass {

	private int indexOfLastSharedGossip;

	protected SealedLipsPersonClass(String name, String personType) {
		super(name, personType);
		indexOfLastSharedGossip = -1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Gossip shareGossips() {
		Gossip g = null;
		for (int i = 0; i < gossips.size(); i++) {
			if (gossips.get(i).isPersonATarget(name)) {
				if (this.numberOfSharableGossips() == 1) {
					g = gossips.get(i);
					this.indexOfLastSharedGossip = i;
					break;
				} else if (i != this.indexOfLastSharedGossip) {
					g = gossips.get(i);
					indexOfLastSharedGossip = i;
					break;
				}
			}
		}
		return g;
	}

	private int numberOfSharableGossips() {
		int result = 0;
		for (int i = 0; i < gossips.size(); i++) {
			if (gossips.get(i).isPersonATarget(name))
				result++;
		}
		return result;
	}

	@Override
	public void addGossip(Gossip gossip) {
		gossips.insertLast(gossip);
	}
}
