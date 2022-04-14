package com.adminportal.sa.osgi.documentmanagment.concumer;

import com.adminportal.sa.osgi.documentmanagment.producer.DocumentService;
import java.util.HashMap;
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

		m_tracker = new ServiceTracker(m_context,
				m_context.createFilter("(&(objectClass=" + DocumentService.class.getName() + ")" + "(Language=*))"),
				null);
		m_tracker.open();

		try {

			String DocID = "";
			String DocName = "";
			String DocUser = "";
			String DocDate = "";
			String DocType = "";

			Scanner obj = new Scanner(System.in);

			System.out.println("\t" + "Welcome to Suthern Translation pvt LTD");
			System.out.println("\n" + "###########################################################");
			System.out.println("\n" + ">>>>>>> How many Documents Details Would you like to Enter[Exit:0]: ");
			int count = Integer.valueOf(obj.nextLine());

			DocumentService document = (DocumentService) m_tracker.getService();

			// Start Loop Here.
			breakLoop: for (int i = 0; i < count; i++) {

				if (count == 0) {
					System.out.println("No document available.");
					break breakLoop;
				} else {
					// get data from the user inputs
					System.out.println("Enter Document ID(ex:DOC#1): ");
					DocID = obj.nextLine();

					System.out.println("Enter Document Name: ");
					DocName = obj.nextLine();

					System.out.println("Enter Document User: ");
					DocUser = obj.nextLine();

					System.out.println("Enter Document Date: ");
					DocDate = obj.nextLine();

					System.out.println("Enter Document Type: ");
					DocType = obj.nextLine();

					// add data to the hash map
					document.AddDocumentDetails(DocID, DocName, DocUser, DocDate, DocType);
				}

				System.out.println("-----------------------------------------------------------");

			}

			System.out.println("\n" + ">>>>>>> View || all added Documents Details : yes or no");
			String view_decision = obj.nextLine();

			switch (view_decision) {
			case "yes":
				System.out.println("\n" + "###########################################################");
				document.ViewDocumentDetails();
				break;
			case "no":
				break;
			default:
				// System.out.println("please enter again ");
			}

			System.out.println("\n" + ">>>>>>> Delete || Documents Details : yes or no");
			String delete_decision = obj.nextLine();

			switch (delete_decision) {
			case "yes":
				System.out.println("\n" + "###########################################################");

				System.out.println("\n" + "Enter Document ID(ex:DOC#1): to Delete ");
				DocID = obj.nextLine();

				document.DeleteDocumentDetails(DocID);

				System.out.println("\n" + "----- Remaining Document Details -----");
				document.ViewDocumentDetails();

				break;
			case "no":
				break;
			default:

			}

			System.out.println("\n" + ">>>>>>> Search || Documents Details : yes or no");
			String search_decision = obj.nextLine();

			switch (search_decision) {
			case "yes":
				System.out.println("\n" + "###########################################################");
				System.out.println("\n" + "Enter Document ID(ex:DOC#1)to Search: ");
				DocID = obj.nextLine();
				document.SearchDocumentDetails(DocID);
				break;
			case "no":
				break;
			default:
			}

		} catch (Exception ex) {
		}
	}

	public void stop(BundleContext context) {
	}

}
