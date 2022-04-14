package com.adminportal.sa.osgi.customermanagment.concumer;

import com.adminportal.sa.osgi.customermanagment.producer.CustomerService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	// Bundle's context.
	private BundleContext m_context = null;
	// The service tacker object.
	private ServiceTracker m_tracker = null;

	public void start(BundleContext context) throws Exception {
		m_context = context;

		// Create a service tracker to monitor dictionary services.
		m_tracker = new ServiceTracker(m_context,
				m_context.createFilter("(&(objectClass=" + CustomerService.class.getName() + ")" + "(Language=*))"),
				null);
		m_tracker.open();

		try {

			String name = "";
			String DOB = "";
			String NIC = "";
			String address = "";
			String email = "";
			String phoneNO = "";
			String CID = "";

			Scanner obj = new Scanner(System.in);

			// Loop endlessly.
			while (true) {

				// Get the selected dictionary service, if available.
				CustomerService customer = (CustomerService) m_tracker.getService();

				System.out.println("Customer Name : ");
				name = obj.nextLine();
				System.out.println("Customer Date of Birth : ");
				DOB = obj.nextLine();
				System.out.println("Customer NIC : ");
				NIC = obj.nextLine();
				System.out.println("Customer Address : ");
				address = obj.nextLine();
				System.out.println("Customer Email : ");
				email = obj.nextLine();
				System.out.println("Customer PhoneNO : ");
				phoneNO = obj.nextLine();
				System.out.println("Customer ID : ");
				CID = obj.nextLine();

				customer.customerRegistration(name, DOB, NIC, address, email, phoneNO, CID);
			}
		} catch (Exception ex) {
		}
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}
}
