package com.adminportal.sa.osgi.paymentmanagment.producer;

public interface PaymentService {

//	public boolean checkWord(String word);

	/*
	 * created by : Janith Gamage - created on : 22.03.2022 - function : payment
	 * Function
	 */

	/* Notes : This function will retrieve the other document price */
	public void setdocumentPriceDetails(String type, Double price);

	/* Notes : This function will view document price details */
	public void viewDocumentDetails();

	/* Notes : This function will view update document price details */
	public void updateDocumentDetails(String type, Double amount);

	/* Notes : This function will view search document price details */
	public void searchDocumentDetails(String type);

	/* Notes : This function will delete document price detail */
	public void deleteDocumentDetail(String type);

	/*
	 * Notes : This function will get the document counts (According to type) and
	 * calculate the final price for the job START
	 */
	public void getReceiptData(String type, int count);

	/* Notes : This function will view document price details */
	public void viewReceiptDetails();

	public double payment();

	/* payment calculation END */

	/* Notes : This function will save payment details */
	public void savePaymentDetails(String pID, String puserID, String pAmount, String pDescription);

	/* Notes : This function will view payment details */
	public void viewPaymentDetails();

}