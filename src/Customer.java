package src;

public class Customer {
	private String custName;
	private String custPassword;
	private String custIC;
	private String custPhoneNumber;
	private String custEmail;
	private char custGender;
	private String custHomeAddr;
	public Customer(String cN, String pW, String cIC, String cPN, String cE,char cG, String cHA){
		custName=cN;
		custPassword=pW;
		custIC=cIC;
		custPhoneNumber=cPN;
		custEmail=cE;
		custGender=cG;
		custHomeAddr=cHA;
	}
	String getName() {
		return custName;
	}
	String getPassword() {
		return custPassword;
	}
	String getIC() {
		return custIC;
	}
	String getPhoneNum() {
		return custPhoneNumber;
	}
	String getEmail() {
		return custEmail;
	}char getGender() {
		return custGender;
	}
	String getHomeAddr() {
		return custHomeAddr;
	}
	void setName(String n) {
		custName=n;
	}
	void setPassword(String n) {
		custPassword=n;
	}
	void setIC(String n) {
		custIC=n;
	}
	void setPhoneNumber(String n) {
		custPhoneNumber=n;
	}
	void setEmail(String n) {
		custEmail=n;
	}
	void setGender(char n) {
		custGender=n;
	}
	void setHomeAddr(String n) {
		custHomeAddr=n;
	}
}