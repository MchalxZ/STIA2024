package SOC;

public class NodeCust {
	public NodeCust link;
	public Customer cust;

	public NodeCust() {
		cust = null;
		link = null;

	}

	public NodeCust(Customer obj) {
		cust = obj;
		link = null;
	}

	public NodeCust(Customer obj, NodeCust next) {
		cust = obj;
		link = next;
	}

	public Customer getInfo() {
		return cust;
	}

	NodeCust getLink() {
		return link;
	}

	void setInfo(Customer a) {
		cust = a;
	}

	void setLink(NodeCust next) {
		link = next;
	}

}
