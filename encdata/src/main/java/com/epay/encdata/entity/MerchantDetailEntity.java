
package com.epay.encdata.entity;

import javax.persistence.Column;

public class MerchantDetailEntity {
	
	@Column(name="MIFID")
	protected String MIFID;
	
	@Column(name="ENCRYPTIONMETHODOLOGY")
	protected String ENCRYPTIONMETHODOLOGY;

	public MerchantDetailEntity(String mIFID, String eNCRYPTIONMETHODOLOGY) {
		super();
		MIFID = mIFID;
		ENCRYPTIONMETHODOLOGY = eNCRYPTIONMETHODOLOGY;
	}

	public String getMIFID() {
		return MIFID;
	}

	public void setMIFID(String mIFID) {
		MIFID = mIFID;
	}

	public String getENCRYPTIONMETHODOLOGY() {
		return ENCRYPTIONMETHODOLOGY;
	}

	public void setENCRYPTIONMETHODOLOGY(String eNCRYPTIONMETHODOLOGY) {
		ENCRYPTIONMETHODOLOGY = eNCRYPTIONMETHODOLOGY;
	}

	@Override
	public String toString() {
		return "MerchantDetailEntity [MIFID=" + MIFID + ", ENCRYPTIONMETHODOLOGY=" + ENCRYPTIONMETHODOLOGY + "]";
	}
	
	
	
	


}
