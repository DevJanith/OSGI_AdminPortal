package com.adminportal.sa.osgi.customermanagment.producer;

public interface CustomerService {

	public void registerCustomer(String name, String DOB, String NIC, String address, String email, String phoneNO,
			String CID);

	public void viewCustomer();

	public void deleteCustomer(String nic);

	public void searchCustomer(String nic);

	public void updateCustomer(String name, String DOB, String NIC, String address, String email, String phoneNO,
			String CID);
}
