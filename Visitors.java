package application;

import javafx.beans.property.StringProperty;

public class Visitors {
	private int serialNumber;
	private String city;
	private String stateName;
	private String country;
	private String visitType;
	private String VisitDetails;
	private String numOfVisitors;
	private String placeOfStay;
	private String zipCode;
	private String timestamp;
	
	private String email_ID;
	
	
	public Visitors(int serialNumber, String city, String stateName, String zipCode, String country, String visitType, String VisitDetails, String numOfVisitors,String placeOfStay,String email_ID, String timestamp/**, String inputzipCode, int numberOfVisitor*/) {
		//zipCode, city, state, country, visitType, VisitDetails, numOfVisitors, placeOfStay, email_ID, timestamp 
		super();
		this.serialNumber = serialNumber;
		this.city = city;
		this.stateName = stateName;
		this.country=country;
		this.visitType=visitType;
		this.VisitDetails=VisitDetails;
		this.placeOfStay=placeOfStay;
		this.zipCode=zipCode;
		this.numOfVisitors=numOfVisitors;
		this.email_ID = email_ID;
		this.timestamp=timestamp;
		
	}


	public int getSerialNumber() {
		return serialNumber;
		
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getCity() {
		return city;
	}
	 


	public void setCity(String city) {
		this.city = city;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getVisitType() {
		return visitType;
	}


	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}


	public String getVisitDetails() {
		return VisitDetails;
	}


	public void setVisitDetails(String visitDetails) {
		VisitDetails = visitDetails;
	}


	public String getNumOfVisitors() {
		return numOfVisitors;
	}


	public void setNumOfVisitors(String numOfVisitors) {
		this.numOfVisitors = numOfVisitors;
	}


	public String getPlaceOfStay() {
		return placeOfStay;
	}


	public void setPlaceOfStay(String placeOfStay) {
		this.placeOfStay = placeOfStay;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public String getEmail_ID() {
		return email_ID;
	}


	public void setEmail_ID(String email_ID) {
		this.email_ID = email_ID;
	}


}
