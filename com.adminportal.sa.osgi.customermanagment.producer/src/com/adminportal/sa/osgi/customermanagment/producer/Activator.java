package com.adminportal.sa.osgi.customermanagment.producer;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language", "English");
		context.registerService(CustomerService.class.getName(), new CustomerServiceImpl(), props);
		System.out.println("Producer Started");
	}

	public void stop(BundleContext context) {
		System.out.println("Producer Stopped");
	}

	private static class CustomerServiceImpl implements CustomerService {

		@Override
		public void registerCustomer(String name, String DOB, String NIC, String address, String email, String phoneNO,
				String CID) {
			Customer customer = new Customer();
			customer.setCustomerDetails(name, DOB, NIC, address, email, phoneNO, CID);

		}

		@Override
		public void viewCustomer() {
			Customer customer = new Customer();
			customer.getCustmerDetailssMap();

		}

		@Override
		public void deleteCustomer(String NIC) {
			Customer customer = new Customer();
			customer.deleteCustmerDetail(NIC);

		}

		@Override
		public void searchCustomer(String NIC) {
			Customer customer = new Customer();
			customer.searchCustmerDetail(NIC);

		}

		@Override
		public void updateCustomer(String name, String DOB, String NIC, String address, String email, String phoneNO,
				String CID) {
			// TODO Auto-generated method stub
			Customer customer = new Customer();
			customer.updateCustomer(name, DOB, NIC, address, email, phoneNO, CID);

		}

	}
}
