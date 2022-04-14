package com.adminportal.sa.osgi.customermanagment.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language", "English");
		context.registerService(CustomerService.class.getName(), new CustomerServiceImpl(), props);
		System.out.println("Dictionary service registered and started successfully");
	}

	public void stop(BundleContext context) {
		// NOTE: The service is automatically unregistered.
	}

	private static class CustomerServiceImpl implements CustomerService {

		@Override
		public void customerRegistration(String name, String DOB, String NIC, String address, String email,
				String phoneNO, String CID) {
			// TODO Auto-generated method stub

			/*
			 * Map<Object,ArrayList<Object>> multiMap = new HashMap<>();
			 * 
			 * List<Object> al = multiMap.get(key); if (al == null) { al = new
			 * ArrayList<Object>(); map.put(key, al); } al.add(value); // HashMap<String,
			 * String> customer = new HashMap<>(); multiMap.put(NIC, [name, DOB, address,
			 * email, phoneNO, CID]);
			 */

			ArrayList<String> customerDetails = new ArrayList<String>();
			customerDetails.add(name);
			customerDetails.add(DOB);
			customerDetails.add(address);
			customerDetails.add(email);
			customerDetails.add(phoneNO);
			customerDetails.add(CID);

			Map<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();
			myMap.put(NIC, customerDetails);
			System.out.println("customer Registered");

			for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
				System.out.println("access for loop");
				System.out.println(entry.getKey() + "\t:" + entry.getValue());
			}
		}

		@Override
		public void viewCustomer() {
			// TODO Auto-generated method stub

		}

//		@Override
//		public void customerRegistration(String name, String DOB, String NIC, String address, String email,
//				String phoneNO, String CID) {
//			// TODO Auto-generated method stub
//			
//		}

	}

}
