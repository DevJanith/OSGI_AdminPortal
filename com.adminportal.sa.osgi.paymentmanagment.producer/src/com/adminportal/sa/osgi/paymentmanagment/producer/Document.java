package com.adminportal.sa.osgi.paymentmanagment.producer;

import java.util.HashMap;

public class Document {
	String type;
	Double price;

	public Document() {
		super();
	}

	public Document(String type, Double price) {
		super();
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private static HashMap<String, Double> DocumentPriceDetails = new HashMap<String, Double>();

	public HashMap<String, Double> getDocumentpriceDetailsMap() {
		return DocumentPriceDetails;
	}

	public void setDocumentPriceDetails() {
		DocumentPriceDetails.put(getType(), getPrice());
		System.out.println("Document Price Details Registered Successfully\n");
	}

	public void getDocumentDetails() {
		int i = 0;
		for (HashMap.Entry<String, Double> entry : DocumentPriceDetails.entrySet()) {
			i = i + 1;
			System.out.println("No : Doc" + i);
			System.out.println("[ ");
			System.out.println("Document Type  : " + entry.getKey());
			System.out.println("Document Price : " + entry.getValue());
			System.out.println(" ]");
		}
	}

	public Integer updateDocumentDetails(String type, Double price) {
		/*
		 * sucessCode : 0 failCode : 1
		 */
		int massageCode = 4;

		for (HashMap.Entry<String, Double> entry : DocumentPriceDetails.entrySet()) {
			if (entry.getKey().equals(type)) {
				DocumentPriceDetails.put(entry.getKey(), price);
				massageCode = 1;
			} else {
				massageCode = 0;
			}
		}
		return massageCode;
	}

	public void searchDocumentDetails(String type) {
		for (HashMap.Entry<String, Double> entry : DocumentPriceDetails.entrySet()) {
			if (entry.getKey().equals(type)) {
				System.out.println("Document Type : " + entry.getKey());
				System.out.println("Document Amount : " + entry.getValue());
			} else {
				System.out.println("No Document Exist");
			}
		}
	}

	public void deleteDocumentDetail(String type) {
		for (HashMap.Entry<String, Double> entry : DocumentPriceDetails.entrySet()) {
			if (entry.getKey().equals(type)) {
				DocumentPriceDetails.remove(type);
				System.out.println("Delete sucess");
			}
		}
	}
}
