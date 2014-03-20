/*Programmer: Alex Curreri, Alex Lemaire and Sravan Reddy
Date: 03/19/2014
Filename: Contact.java
Purpose: to allow for the creation of contact objects that store important contact information
*/

public class Contact{
	String sFName, sLName, sState, sCity, sAddress, sTitle, sEmail;//string instance variables
	Long dZipCode, dHomePhone, dMobilePhone; //int instance variables

	public Contact(){ //default constructor
		sFName = "";
		sLName = "";
		sAddress = "";
		sState = "";
		sCity = "";
		sTitle = "";
		sEmail = "";
		dHomePhone = 0l;
		dMobilePhone = 0l;
		dZipCode = 0l;
	}

	public Contact(String f, String l, String a, String s, String c, String t, String e, long d1, long d2, long d3){ //additional constructor
		sFName = f;
		sLName = l;
		sAddress = a;
		sState = s;
		sCity = c;
		sTitle = t;
		sEmail = e;
		dHomePhone = d1;
		dMobilePhone = d2;
		dZipCode = d3;
	}

	//sets and gets
	public void setFName(String s){
		sFName = s;
	}

	public String getFName(){
		return sFName;
	}

	public void setLName(String s){
		sLName = s;
	}

	public String getLName(){
		return sLName;
	}

	public void setAddress(String s){
		sAddress= s;
	}

	public String getAddress(){
		return sAddress;
	}

	public void setState(String s){
		sState = s;
	}

	public String getState(){
		return sState;
	}

	public void setCity(String c){
		sCity = c;
	}

	public String getCity(){
		return sCity;
	}

	public void setTitle(String s){
		sTitle = s;
	}

	public String getTitle(){
		return sTitle;
	}

	public void setEmail(String s){
		sEmail = s;
	}

	public String getEmail(){
		return sEmail;
	}

	public void setHomePhone(long d){
		dHomePhone = d;
	}

	public long getHomePhone(){
		return dHomePhone;
	}

	public void setMobilePhone(long d){
		dMobilePhone = d;
	}

	public long getMobilePhone(){
		return dMobilePhone;
	}

	public void setZipCode(long d){
		dZipCode = d;
	}

	public long getZipCode(){
		return dZipCode;
	}


	public String toString(){ //this will be used when view contact information
		String str = "";
		str = sTitle + ". " + sFName + " " + sLName +
		"\nsAddress "  + " " + sCity + " " + sState + " " + dZipCode +
 		"\nMobile: " + dMobilePhone +
 		"\nHome: " + dHomePhone +
 		"\nE-mail: " + sEmail;
		return str;
	}
}

