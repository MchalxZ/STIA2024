package src;

public class NodeInsAgent {
	public NodeInsAgent link;
	public insuranceAgent agt;

	public NodeInsAgent() {
		agt = null;
		link = null;

	}

	public NodeInsAgent(insuranceAgent obj) {
		agt = obj;
		link = null;
	}

	public NodeInsAgent(insuranceAgent obj, NodeInsAgent next) {
		agt = obj;
		link = next;
	}

	public insuranceAgent getInfo() {
		return agt;
	}

	NodeInsAgent getLink() {
		return link;
	}

	void setInfo(insuranceAgent a) {
		agt = a;
	}

	void setLink(NodeInsAgent next) {
		link = next;
	}

}
