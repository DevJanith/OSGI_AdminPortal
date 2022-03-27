package com.adminportal.sa.osgi.documentmanagment.producer;

public class Document {

	private String DocID;
	private String DocName;
	private String DocUser;
	private String DocDate;
	private String DocType;

	// Getters

	/**
	 * @return the docID
	 */
	public String getDocID() {
		return DocID;
	}

	/**
	 * @return the docName
	 */
	public String getDocName() {
		return DocName;
	}

	/**
	 * @return the docUser
	 */
	public String getDocUser() {
		return DocUser;
	}

	/**
	 * @return the docDate
	 */
	public String getDocDate() {
		return DocDate;
	}

	/**
	 * @return the docType
	 */
	public String getDocType() {
		return DocType;
	}

	// Setters
	/**
	 * @param docID the docID to set
	 */
	public void setDocID(String docID) {
		DocID = docID;
	}

	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		DocName = docName;
	}

	/**
	 * @param docUser the docUser to set
	 */
	public void setDocUser(String docUser) {
		DocUser = docUser;
	}

	/**
	 * @param docDate the docDate to set
	 */
	public void setDocDate(String docDate) {
		DocDate = docDate;
	}

	/**
	 * @param docType the docType to set
	 */
	public void setDocType(String docType) {
		DocType = docType;
	}

}
