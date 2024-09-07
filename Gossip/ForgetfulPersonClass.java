package Gossip;

public class ForgetfulPersonClass extends AbstractPersonClass {

	private int numberOfGossips;

	protected ForgetfulPersonClass(String name, String personType, int numberOfGossips) {
		super(name, personType);
		this.numberOfGossips = numberOfGossips;
	}

	@Override
	public Gossip shareGossips() {
		Gossip g = gossips.get(indexOfGossipToShare);
		this.indexOfGossipToShare++;
		if (this.numberOfGossips == this.indexOfGossipToShare || this.indexOfGossipToShare >= gossips.size())
			this.resetIndexOfGossipToShare();
		return g;
	}

	@Override
	public void addGossip(Gossip gossip) {
		if (gossips.size() == numberOfGossips) {
			gossips.insertLast(gossip);
			gossips.removeAt(0);
		} else {
			gossips.insertLast(gossip);
		}
	}
}
