package com.adminportal.sa.osgi.customermanagment.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	private String name;
	private String DOB;
	private String NIC;
	private String address;
	private String email;
	private String phoneNO;
	private String CID;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String DOB, String NIC, String address, String email, String phoneNO, String CID) {
		super();
		this.name = name;
		DOB = DOB;
		NIC = NIC;
		this.address = address;
		this.email = email;
		this.phoneNO = phoneNO;
		this.CID = CID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String NIC) {
		this.NIC = NIC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNo(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String CID) {
		this.CID = CID;
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", DOB=" + DOB + ", NIC=" + NIC + ", address=" + address + ", email=" + email
				+ ", phoneNO=" + phoneNO + ",CID=" + CID + " ]";
	}

	private static Map<String, ArrayList<String>> customerDetails = new HashMap<String, ArrayList<String>>();

	// set customer Details
	public void setCustomerDetails(String name, String DOB, String NIC, String address, String email, String phoneNO,
			String CID) {
		ArrayList<String> customerDetailsList = new ArrayList<String>();
		customerDetailsList.add(name);
		customerDetailsList.add(DOB);
		customerDetailsList.add(address);
		customerDetailsList.add(email);
		customerDetailsList.add(phoneNO);
		customerDetailsList.add(CID);
		customerDetails.put(NIC, customerDetailsList);
		System.out.println("\n******************************\n");
		System.out.println("Customer registered Successfully");
		System.out.println("\n******************************\n");
	}

	// get customer details
	public void getCustmerDetailssMap() {
		for (HashMap.Entry<String, ArrayList<String>> entry : customerDetails.entrySet()) {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
		}
	}

	// delete customer details
	public void deleteCustmerDetail(String nic) {
		for (HashMap.Entry<String, ArrayList<String>> entry : customerDetails.entrySet()) {

			if (entry.getKey().equals(nic)) {
				customerDetails.remove(nic);
				System.out.println("\n******************************\n");
				System.out.println("Customer deleted Successfully");
				System.out.println("\n******************************\n");
			}
		}
	}

	// search customer details
	public void searchCustmerDetail(String nic) {
		for (HashMap.Entry<String, ArrayList<String>> entry : customerDetails.entrySet()) {

			if (entry.getKey().equals(nic)) {
				System.out.println("Customer NIC :" + entry.getKey());
				System.out.println("Customer Details :" + entry.getValue());
			}
		}
	}

	// update customer details
	public void updateCustomer(String name, String DOB, String NIC, String address, String email, String phoneNO,
			String CID) {
//		for (HashMap.Entry<String, ArrayList<String>> entry : customerDetails.entrySet()) {

		ArrayList<String> customerDetailsList = new ArrayList<String>();
		customerDetailsList.add(name);
		customerDetailsList.add(DOB);
		customerDetailsList.add(address);
		customerDetailsList.add(email);
		customerDetailsList.add(phoneNO);
		customerDetailsList.add(CID);
		customerDetails.put(NIC, customerDetailsList);
		System.out.println("\n******************************\n");
		System.out.println("Customer updated Successfully");
		System.out.println("\n******************************\n");

	}

}
