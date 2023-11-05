package SOC;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {
	private String apptName;
	private String apptDate;
	private String apptTime;
	private String apptID;
	private LocalTime apptST;
	private LocalTime apptET;
	private Object customer;
	private Object agent;

	Appointment(String N, String date, String t,String ID,LocalTime starttime,LocalTime endTime,Object C,Object A){
		apptName=N;
		apptDate=date;
		apptTime=t;
		apptST=starttime;
		apptET=endTime;
		apptID=ID;
		customer=C;
		agent=A;
	}
	public Object getCustomer() {
		return customer;
	}
	public LocalTime getApptST() {
		return apptST;
	}
	public void setApptST(LocalTime apptST) {
		this.apptST = apptST;
	}
	public LocalTime getApptET() {
		return apptET;
	}
	public void setApptET(LocalTime apptET) {
		this.apptET = apptET;
	}
	public Object getAgent() {
		return agent;
	}
	public String getApptTime() {
		return apptTime;
	}
	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}
	public void setCustomer(Object customer) {
		this.customer = customer;
	}
	public void setAgent(Object agent) {
		this.agent = agent;
	}
	public String getApptName() {
		return apptName;
	}
	public String getApptDate() {
		return apptDate;
	}
	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}
	public String getApptID() {
		return apptID;
	}
	public void setApptID(String apptID) {
		this.apptID = apptID;
	}
	public void setApptName(String apptName) {
		this.apptName = apptName;
	}
	
}
