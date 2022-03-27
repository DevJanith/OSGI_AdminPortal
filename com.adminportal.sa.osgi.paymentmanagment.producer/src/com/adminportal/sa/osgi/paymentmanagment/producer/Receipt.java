package com.adminportal.sa.osgi.paymentmanagment.producer;

import java.util.HashMap;

public class Receipt {
	String type;
	Double Amount;

	public Receipt() {
		super();
	}

	public Receipt(String type, Double amount) {
		super();
		this.type = type;
		Amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public Double paymentCalculation(String Documenttype, Integer Documentcount) {
		Double Answer = 0.00;

		Document documentpricDetails = new Document();

		HashMap<String, Double> DocumentPriceDetails = documentpricDetails.getDocumentpriceDetailsMap();

		for (HashMap.Entry<String, Double> entry : DocumentPriceDetails.entrySet()) {
			if (Documenttype.equals(entry.getKey())) {
				System.err.println("equl in if sucess");
				Answer = entry.getValue() * Documentcount;
			}
		}
		return Answer;
	}

	private static HashMap<String, Double> receipt = new HashMap<String, Double>();

	public void setReceiptDetails(String type, Double amount) {
		receipt.put(type, amount);
	}

	public void getPaymentDetailssMap() {

		System.out.println("+++++++++++++++++++++");
		System.out.println("+  Type  +  Amount  +");
		System.out.println("+        +          +");
		System.out.println("+++++++++++++++++++++");
		for (HashMap.Entry<String, Double> entry : receipt.entrySet()) {

			System.out.println("+  " + entry.getKey() + "  +  " + entry.getValue() + "  +");
		}
		System.out.println("+++++++++++++++++++++");
	}

	public Double calculateReceipt() {
		Double receiptAmount = 0.00;
		for (HashMap.Entry<String, Double> entry : receipt.entrySet()) {
			receiptAmount = receiptAmount + entry.getValue();
		}

		return receiptAmount;
	}

}
