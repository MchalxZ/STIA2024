package SOC;

public class insuranceAgent {
	private String agentName;
	private String agentPassword;
	private String agentIC;
	private String agentPhoneNum;
	private String agentEmail;
	private char agentGender;
	private String agentHomeAddr;
	
public insuranceAgent(String n, String p, String i,String pn,String e,char g,String ha){
	agentName=n;
	agentPassword=p;
	agentIC=i;
	agentPhoneNum=pn;
	agentEmail=e;
	agentGender=g;
	agentHomeAddr=ha;
	
}

public String getAgentName() {
	return agentName;
}

public void setAgentName(String agentName) {
	this.agentName = agentName;
}

public String getAgentPassword() {
	return agentPassword;
}

public void setAgentPassword(String agentPassword) {
	this.agentPassword = agentPassword;
}

public String getAgentIC() {
	return agentIC;
}

public void setAgentIC(String agentIC) {
	this.agentIC = agentIC;
}

public String getAgentPhoneNum() {
	return agentPhoneNum;
}

public void setAgentPhoneNum(String agentPhoneNum) {
	this.agentPhoneNum = agentPhoneNum;
}

public String getAgentEmail() {
	return agentEmail;
}

public void setAgentEmail(String agentEmail) {
	this.agentEmail = agentEmail;
}

public char getAgentGender() {
	return agentGender;
}

public void setAgentGender(char agentGender) {
	this.agentGender = agentGender;
}

public String getAgentHomeAddr() {
	return agentHomeAddr;
}

public void setAgentHomeAddr(String agentHomeAddr) {
	this.agentHomeAddr = agentHomeAddr;
}
}
