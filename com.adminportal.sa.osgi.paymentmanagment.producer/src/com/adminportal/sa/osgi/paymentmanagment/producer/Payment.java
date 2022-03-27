package com.adminportal.sa.osgi.paymentmanagment.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Payment {

	// 'p' - payment
	String pID;
	String pUserID;
	String pAmount;
	String pDescription;

	public Payment() {
		super();
	}

	public Payment(String pID, String puserID, String pAmount, String pDescription) {
		super();
		this.pID = pID;
		this.pUserID = puserID;
		this.pAmount = pAmount;
		this.pDescription = pDescription;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getPuserID() {
		return pUserID;
	}

	public void setPuserID(String puserID) {
		this.pUserID = puserID;
	}

	public String getpAmount() {
		return pAmount;
	}

	public void setpAmount(String pAmount) {
		this.pAmount = pAmount;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	private static Map<String, ArrayList<String>> paymentDetails = new HashMap<String, ArrayList<String>>();

	public void setpaymentDetailsDetails(String pID, String puserID, String pAmount, String pDescription) {

		ArrayList<String> paymentDetailsList = new ArrayList<String>();
		paymentDetailsList.add(puserID);
		paymentDetailsList.add(pAmount);
		paymentDetailsList.add(pDescription);
		paymentDetails.put(pID, paymentDetailsList);
		System.out.println("Payment Details added Successfully\n");
	}

	public void getPaymentDetailssMap() {
		for (HashMap.Entry<String, ArrayList<String>> entry : paymentDetails.entrySet()) {
			System.out.println("Payment ID      : " + entry.getKey());
			System.out.println("Payment Details : " + entry.getValue());
		}
	}

}
