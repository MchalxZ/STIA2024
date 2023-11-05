package SOC;

public class NodeAppt {
	public NodeAppt link;
	public Appointment appt;

	public NodeAppt() {
		appt = null;
		link = null;

	}

	public NodeAppt(Appointment obj) {
		appt = obj;
		link = null;
	}

	public NodeAppt(Appointment obj, NodeAppt next) {
		appt = obj;
		link = next;
	}

	public Appointment getInfo() {
		return appt;
	}

	NodeAppt getLink() {
		return link;
	}

	void setInfo(Appointment a) {
		appt = a;
	}

	void setLink(NodeAppt next) {
		link = next;
	}

}
