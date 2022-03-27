package com.adminportal.sa.osgi.documentmanagment.producer;

import java.util.ArrayList;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration pubServiceRegistration;

	public void start(BundleContext context) {

		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language", "English");
		context.registerService(DocumentService.class.getName(), new DocumentImpl(), props);
		System.out.println("Document Managment Producer Start" + "\n");

		/*
		 * System.out.println("Document Management Publisher Start"); DocumentService
		 * publishService = new DocumentServiceImpl(); pubServiceRegistration =
		 * context.registerService(DocumentService.class.getName(), publishService,
		 * null);
		 */

	}

	public void stop(BundleContext context) {

		System.out.println("Document Management Producer Stop");
		pubServiceRegistration.unregister();
	}

	private static class DocumentImpl implements DocumentService {

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

		/* Notes : This function will Update all details of Documents */

		@Override
		public void UpdateDocumentDetails(String DocID, String DocName, String DocUser, String DocDate,
				String DocType) {

			DataStorage dataStorage = new DataStorage();
//			dataStorage.updateDocumentDetails();

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

			DataStorage storage = new DataStorage();
			storage.deleteDocumentDetailsMap(DocID);

		}

		/* Notes : This function will Search all details of Documents */
		@Override
		public void SearchDocumentDetails(String DocID) {

			DataStorage storage_search = new DataStorage();
			storage_search.searchDocumentDetailsMap(DocID);

		}

		@Override
		public Integer GetDocumentCount() {

			DataStorage dataStorage = new DataStorage();
			return dataStorage.getDocumentDetailsCount();

		}

	}

}
