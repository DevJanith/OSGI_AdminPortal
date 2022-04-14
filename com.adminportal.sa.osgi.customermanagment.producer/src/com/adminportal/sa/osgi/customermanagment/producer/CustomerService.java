package com.adminportal.sa.osgi.customermanagment.producer;

public interface CustomerService {

	public void customerRegistration(String name, String DOB,String NIC,String address,String email,String phoneNO,String CID);

	public void viewCustomer();
}
