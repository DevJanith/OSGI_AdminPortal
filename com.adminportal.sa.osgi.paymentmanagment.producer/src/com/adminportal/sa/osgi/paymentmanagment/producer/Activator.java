package com.adminportal.sa.osgi.paymentmanagment.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration pubServiceRegistration;

	public void start(BundleContext context) {
		/*
		 * Hashtable<String, String> props = new Hashtable<String, String>();
		 * props.put("Language", "English");
		 * context.registerService(PaymentService.class.getName(), new PaymentImpl(),
		 * props); System.out.println("Payment Managment Publisher Start");
		 */

		System.out.println("Payment Managment Publisher Start");
		PaymentService paymentService = new PaymentServiceImpl();

		pubServiceRegistration = context.registerService(PaymentService.class.getName(), paymentService, null);

	}

	public void stop(BundleContext context) {
		System.out.println("payment Management Publisher Stop");
		pubServiceRegistration.unregister();
	}

	/*
	 * private static class PaymentImpl implements PaymentService {
	 *
	 * 
	 * @Override public void setdocumentPriceDetails(String type, Double price) {
	 * Document document = new Document(type, price);
	 * document.setDocumentPriceDetails(); }
	 * 
	 * @Override public void viewDocumentDetails() { Document document = new
	 * Document(); document.getDocumentDetails(); }
	 * 
	 * @Override public void updateDocumentDetails(String type, Double amount) {
	 * Document document = new Document(); document.updateDocumentDetails(type,
	 * amount); }
	 * 
	 * @Override public void searchDocumentDetails(String type) { Document document
	 * = new Document(); document.searchDocumentDetails(type); }
	 * 
	 * @Override public void deleteDocumentDetail(String type) { Document document =
	 * new Document(); document.deleteDocumentDetail(type); }
	 * 
	 * @Override public void getReceiptData(String type, int count) { Receipt
	 * receipt = new Receipt(); System.out.println(receipt.paymentCalculation(type,
	 * count) + "tets"); receipt.setReceiptDetails(type,
	 * receipt.paymentCalculation(type, count)); }
	 * 
	 * @Override public void viewReceiptDetails() { Receipt receipt = new Receipt();
	 * receipt.getPaymentDetailssMap(); }
	 * 
	 * @Override public double payment() { Receipt receipt = new Receipt(); return
	 * receipt.calculateReceipt(); }
	 * 
	 * @Override public void savePaymentDetails(String pID, String puserID, String
	 * pAmount, String pDescription) { Payment payment = new Payment();
	 * 
	 * payment.setpaymentDetailsDetails(pDescription, pDescription, pDescription,
	 * pDescription);
	 * 
	 * }
	 * 
	 * @Override public void viewPaymentDetails() { Payment payment = new Payment();
	 * 
	 * payment.getPaymentDetailssMap();
	 * 
	 * }
	 * 
	 * }
	 */
}