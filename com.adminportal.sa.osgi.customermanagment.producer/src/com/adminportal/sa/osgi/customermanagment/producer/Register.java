package com.adminportal.sa.osgi.customermanagment.producer;

public class Register {
	private String name;
	private String DOB;
	private String NIC;
	private String address;
	private String email;
	private long phoneNo;
	private String customerID;

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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", DOB=" + DOB + ", NIC=" + NIC + ", address=" + address + ", email=" + email
				+ ", phoneNo=" + phoneNo + ",customerID=" + customerID + " ]";
	}

}
