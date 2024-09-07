package Gossip;

public class GossiperPersonClass extends AbstractPersonClass {

	protected GossiperPersonClass(String name, String personType) {
		super(name, personType);
	
	}

	@Override
	public Gossip shareGossips() {
		Gossip g = null;
		if (gossips.size() == 1) {
			g = gossips.get(0);
			this.indexOfGossipToShare = 1;
		} else {
			g = gossips.get(indexOfGossipToShare);
			this.indexOfGossipToShare++;
			if (this.indexOfGossipToShare == gossips.size())
				this.resetIndexOfGossipToShare();
		}
		return g;
	}

	@Override
	public void addGossip(Gossip gossip) {
		gossips.insertLast(gossip);
	}
}
