package com.adminportal.sa.osgi.paymentmanagment.concumer;

import com.adminportal.sa.osgi.paymentmanagment.producer.PaymentService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.UUID;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

//	private BundleContext m_context = null;
//
//	private ServiceTracker m_tracker = null;

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
//		m_context = context;
//
//		m_tracker = new ServiceTracker(m_context,
//				m_context.createFilter("(&(objectClass=" + PaymentService.class.getName() + ")" + "(Language=*))"),
//				null);
//		m_tracker.open();
		//push

		System.out.println("Start Payment Managment Concumer Service");
		serviceReference = context.getServiceReference(PaymentService.class.getName());
		PaymentService paymentService = (PaymentService) context.getService(serviceReference);

		try {

			// predefined varibales
			Integer terminate = 100;
			Integer receiptterminate = 100;
			Integer documentCount = 0;
			Double price = 0.00;
			String functionCode = "";
			String type = "";
			String documentType = "";
			Double documentPrice = 0.00;
			String responce = "";
			Integer count = 0;

			// scanner object
			Scanner obj = new Scanner(System.in);

			// common details
			System.out.println("\n\t" + "Welcome to Suthern Translation pvt LTD");
			System.out.println("\n" + "###########################################################");

			System.out.println("\n" + "Payment Managment Function Codes :");
			System.out.println("\n");
			System.out.println("*Register Document Price enter code   : code1");
			System.out.println("*View Document Price List enter code  : code2");
			System.out.println("*Update Document Price List enter code: code3");
			System.out.println("*Search Document Price List enter code: code4");
			System.out.println("*View Payment Details List code       : code5");
			System.out.println("*Calculate Payment List code          : code6");
			System.out.println("");

			while (true) {
				System.out.print("To Start the System enter (1) - To Terminate the projct enter (0) :");
				try {
					terminate = obj.nextInt();
				} catch (Exception e) {
					System.out.println("Error!");
					terminate = obj.nextInt();
				}

				// terminate the loop
				if (terminate == 0) {
					System.out.println("Terminate the system");
					break;
				} else if (terminate == 1) {

					// access the producer metods
//					PaymentService payment = (PaymentService) m_tracker.getService();

					// get function code
					System.out.print("Enter Function Code : ");
					functionCode = obj.next();
					System.out.println("\n-----------------------------------------");

					if (paymentService == null) {
						// check if the concumern can access the producer
						System.out.println("No Payment Management available.");
					} else {
						// functionalities according to given function Code
						switch (functionCode) {
						case "code1":
							System.out.print(
									"\n" + ">>>>>>> How many Documents Details Would you like to Enter[Exit:0]: ");
							count = obj.nextInt();

							for (int i = 0; i < count; i++) {
								// static header
								System.out.println("\nDocument Details Registerion");
								System.out.println("\n---------------------------\n");

								// get user inputs
								System.out.print(">>>> Enter Document Type : ");
								type = obj.next();
								System.out.print(">>>> Enter Document Price : ");
								price = obj.nextDouble();

								// call setdocumentPriceDetails method
								paymentService.setdocumentPriceDetails(type, price);
							}
							break;
						case "code2":
							// static header
							System.out.println("Document Details Table");
							System.out.println("\n---------------------------\n");

							// call get table view method
							paymentService.viewDocumentDetails();

							// check if the user want to delete table rows get user input
							System.out.print("\n>>>> Delete Document Detail (Y/N):");
							responce = obj.next();

							// check user input and execute the delete method
							if (responce.equals("Y") || responce.equals("y")) {
								System.out.print(">>>> Enter Document Type:");
								type = obj.next();

								// call delete method
								paymentService.deleteDocumentDetail(type);

								// get responce
								paymentService.viewDocumentDetails();
							} else if (responce.equals("N") || responce.equals("n")) {
								System.out.println("");
								break;
							}
							break;
						case "code3":
							// static header
							System.out.println("Document Details Update");
							System.out.println("\n---------------------------\n");

							paymentService.viewDocumentDetails();

							// get user input
							System.out.print(">>>> Enter Document Type:");
							type = obj.next();
							System.out.print(">>>> Enter Document Updated Price:");
							documentPrice = obj.nextDouble();

							// access update method
							paymentService.updateDocumentDetails(type, documentPrice);

							// get response
							paymentService.viewDocumentDetails();
							break;
						case "code4":
							// static header
							System.out.println("Document Details Search");
							System.out.println("\n---------------------------\n");

							// get user input
							System.out.print(">>>> Enter Document Type:");
							type = obj.next();

							// access search method
							paymentService.searchDocumentDetails(type);

							break;
						case "code5":
							// static header
							System.out.println("Document Details");
							System.out.println("\n---------------------------\n");

							paymentService.viewPaymentDetails();
							break;
						case "code6":
							// static header
							System.out.println("Payment Calculation");
							System.out.println("\n---------------------------\n");

							while (true) {
								System.out.print(
										"To Start Receipt Details enter (1) - To Terminate the Receipt Details enter (0) :");
								receiptterminate = obj.nextInt();

								if (receiptterminate == 0) {
									break;
								} else if (receiptterminate == 1) {
									System.out.print("\nDocument Type : ");
									documentType = obj.next();
									System.out.print("Document Count : ");
									documentCount = obj.nextInt();

									paymentService.getReceiptData(documentType, documentCount);
								}
							}

							paymentService.viewReceiptDetails();
							System.out.println("Total Amount : " + paymentService.payment());

							String paymentID = "Pay01";
							String payment = String.valueOf(paymentService.payment());
							paymentService.savePaymentDetails(paymentID, "cus1", payment, "2022/03/24");
							break;
						default:
							System.out.println("Invalid Code");
							break;
						}
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}

	public void stop(BundleContext context) {
		System.out.println("Good Bye and Thank you for using the system");
	}
}
