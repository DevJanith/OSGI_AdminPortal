package com.adminportal.sa.osgi.documentmanagment.producer;

import java.util.ArrayList;

public class DocumentserviceImpl implements DocumentService {

	/* Notes : This function will Add all details of Documents */
	@Override
	public void AddDocumentDetails(String DocID, String DocName, String DocUser, String DocDate, String DocType) {
		// TODO Auto-generated method stub

		ArrayList<String> DocumentDetails = new ArrayList<String>();
		DocumentDetails.add(DocName);
		DocumentDetails.add(DocUser);
		DocumentDetails.add(DocDate);
		DocumentDetails.add(DocType);

		DataStorage storage = new DataStorage();
		storage.setDocumentDetails(DocID, DocumentDetails);
		System.out.println("\t\n" + "Document Added !!");

	}

	/* Notes : This function will View all details of Documents */
	@Override
	public void ViewDocumentDetails() {

		DataStorage storage = new DataStorage();
		storage.getDocumentDetailsMap();

	}

	/* Notes : This function will Delete all details of Documents */
	@Override
	public void DeleteDocumentDetails(String DocID) {
		// TODO Auto-generated method stub
		DataStorage storage = new DataStorage();
		storage.deleteDocumentDetailsMap(DocID);

	}

	/* Notes : This function will Search all details of Documents */
	@Override
	public void SearchDocumentDetails(String DocID) {
		// TODO Auto-generated method stub
		DataStorage storage_search = new DataStorage();
		storage_search.searchDocumentDetailsMap(DocID);

	}

	@Override
	public void UpdateDocumentDetails(String DocID, String DocName, String DocUser, String DocDate, String DocType) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer GetDocumentCount() {

		DataStorage dataStorage = new DataStorage();
		return dataStorage.getDocumentDetailsCount();
	}

}
