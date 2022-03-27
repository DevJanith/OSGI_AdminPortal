package com.adminportal.sa.osgi.documentmanagment.producer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStorage {
//	private static HashMap<String, String> DocumentDetails = new HashMap<String, String>();
	private static Map<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();

	public void setDocumentDetails(String key, ArrayList<String> value) {
		myMap.put(key, value);
		System.out.print("\t" + "   Document Details added Successfully " + "\n");
	}

	public void getDocumentDetailsMap() {

		System.out.print("\n");

		System.out.println("+-----------------------+------------------------------------+");
		System.out.println("+	Document ID 	|	Document Details	     +");
		System.out.println("+-----------------------+------------------------------------+");

		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {

			System.out.println("|" + "\t" + entry.getKey() + "\t\t" + "|" + entry.getValue());

		}

		System.out.println("+-----------------------+------------------------------------+");
	}

	public void deleteDocumentDetailsMap(String Deletekey) {

		System.out.print("\n");
		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {

			myMap.entrySet().removeIf(e -> e.getKey().equals(Deletekey));
			System.out.print("\t" + "   Document Deleted Successfully !! ");
			System.out.println("\n" + "���������������� Remaining Document Details ������������������");
			getDocumentDetailsMap();
		}

	}

	public void searchDocumentDetailsMap(String Searchkey) {

		System.out.print("\n");

		System.out.println("+-----------------------+------------------------------------+");
		System.out.println("+	Document ID 	|	Document Details	     +");
		System.out.println("+-----------------------+------------------------------------+");

		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			if (entry.getKey().equals(Searchkey)) {

				System.out.println("|" + "\t" + entry.getKey() + "\t\t" + "|" + entry.getValue());
			}
		}

		System.out.println("+-----------------------+------------------------------------+");

	}

	public void updateDocumentDetails(String DocID, String DocName, String DocUser, String DocDate, String DocType) {
		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			if (entry.getKey().equals(DocID)) {
				for (String dDetails : entry.getValue()) {

					ArrayList<String> DocumentDetails = new ArrayList<String>();

//					if(DocName != dbDetails) {
//					DocumentDetails.add(DocName);
//					}else {
//						DocumentDetails.put(dDetails);
//					}
//					DocumentDetails.add(DocUser);
//					DocumentDetails.add(DocDate);
//					DocumentDetails.add(DocType);
//					if(DocName == null) {
//						myMap.put(DocID, null)
//					}
				}
			}
		}

	}

	public Integer getDocumentDetailsCount() {
		int count = 0;
		for (HashMap.Entry<String, ArrayList<String>> entry : myMap.entrySet()) {
			count = count + 1;
		}

		return count;
	}

}
