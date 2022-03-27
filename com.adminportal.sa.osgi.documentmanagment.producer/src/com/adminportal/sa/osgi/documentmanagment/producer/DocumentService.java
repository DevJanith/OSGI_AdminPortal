package com.adminportal.sa.osgi.documentmanagment.producer;

public interface DocumentService {

	/* Notes : This function will add all details of Documents */
	public void AddDocumentDetails(String DocID, String DocName, String DocUser, String DocDate, String DocType);

	/* Notes : This function will update details of Documents */
	public void UpdateDocumentDetails(String DocID, String DocName, String DocUser, String DocDate, String DocType);

	/* Notes : This function will Display all details of Documents */
	public void ViewDocumentDetails();

	/* Notes : This function will Delete all details of Documents */
	public void DeleteDocumentDetails(String DocID);

	/* Notes : This function will Search all details of Documents */
	public void SearchDocumentDetails(String DocID);

	/* get count of of documents */
	public Integer GetDocumentCount();

}
