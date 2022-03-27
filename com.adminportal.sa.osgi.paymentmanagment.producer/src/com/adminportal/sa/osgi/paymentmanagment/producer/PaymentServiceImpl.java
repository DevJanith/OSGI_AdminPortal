package com.adminportal.sa.osgi.paymentmanagment.producer;

public class PaymentServiceImpl implements PaymentService {
	/*
	 * created by : Janith Gamage (Gamage B.G.J) - created on : 2022.03.20
	 */

	@Override
	public void setdocumentPriceDetails(String type, Double price) {
		Document document = new Document(type, price);
		document.setDocumentPriceDetails();
	}

	@Override
	public void viewDocumentDetails() {
		Document document = new Document();
		document.getDocumentDetails();
	}

	@Override
	public void updateDocumentDetails(String type, Double amount) {
		Document document = new Document();
		document.updateDocumentDetails(type, amount);
	}

	@Override
	public void searchDocumentDetails(String type) {
		Document document = new Document();
		document.searchDocumentDetails(type);
	}

	@Override
	public void deleteDocumentDetail(String type) {
		Document document = new Document();
		document.deleteDocumentDetail(type);
	}

	@Override
	public void getReceiptData(String type, int count) {
		Receipt receipt = new Receipt();
		System.out.println(receipt.paymentCalculation(type, count) + "tets");
		receipt.setReceiptDetails(type, receipt.paymentCalculation(type, count));
	}

	@Override
	public void viewReceiptDetails() {
		Receipt receipt = new Receipt();
		receipt.getPaymentDetailssMap();
	}

	@Override
	public double payment() {
		Receipt receipt = new Receipt();
		return receipt.calculateReceipt();
	}

	@Override
	public void savePaymentDetails(String pID, String puserID, String pAmount, String pDescription) {
		Payment payment = new Payment();
		payment.setpaymentDetailsDetails(pDescription, pDescription, pDescription, pDescription);

	}

	@Override
	public void viewPaymentDetails() {
		Payment payment = new Payment();
		payment.getPaymentDetailssMap();

	}
}
