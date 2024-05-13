package com.epay.encdata.util;

import javax.crypto.spec.SecretKeySpec;

import com.epay.encdata.config.AES128Bit;
import com.epay.encdata.config.AES256Bit;

public class AESEncryptDecrypt {

	public static String decrypt(String encryptedValue, String key) throws NullPointerException, Exception {
		String decryptedValue = "";
		try {				  
				SecretKeySpec secretkeyspec=null;
				secretkeyspec = AES256Bit.readKeyBytes(key);
				decryptedValue = AES256Bit.decrypt(encryptedValue, secretkeyspec);
			  
		}  catch (Exception ex) {
			GenericExceptionLog.exceptionJava(ex,
					"AESEncryptDecrypt.java :: An error occurred while decryption .",
					"AESEncryptDecrypt");
			
		}
		return decryptedValue;
	}
	
	
	public static String encrypt(String decryptedValue,String key)	throws NullPointerException, Exception {
		String encryptValue = "";
		SecretKeySpec secretkeyspec=null;
		
		secretkeyspec = AES256Bit.readKeyBytes(key);
		encryptValue = AES256Bit.encrypt(decryptedValue, secretkeyspec);
		
		return encryptValue;
		
	}
	

}
