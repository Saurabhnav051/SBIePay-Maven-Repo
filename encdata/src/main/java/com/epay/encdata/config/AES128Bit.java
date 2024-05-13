package com.epay.encdata.config;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.epay.encdata.util.GenericExceptionLog;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Service
public class AES128Bit {


	private static final String ALGORITHM = "AES";
		    private static byte iv1[] = null;

	private static String res;
	public AES128Bit()
	{
	}
	/**
	 * Generates the SecretKeySpec from the string key.
	 * This format is identified by the Cipher class.
	 * 
	 * @param	secretKey	String	Secret Key shared between two parties.
	 * @return	key			Key		Object of the Key Class.
	 */

	private static Key generateKeyFromString(String secretKey) throws  NullPointerException,ClassCastException,Exception
	{
		
		//byte[] keyValue = new Base64Coder().decodeBuffer(secretKey);
		byte[] keyValue = new BASE64Decoder().decodeBuffer(secretKey);
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}
	

	public static String decrypt(String encryptedValue, String secretKey)
	{
		String decryptedValue = null;

		try
		{
			
			Key key = generateKeyFromString(secretKey);
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (NullPointerException ex) {
			GenericExceptionLog.exceptionJava(ex, "AES128Bit.java :: An error occurred while performing decryption.", "AES128Bit");
		} catch (ClassCastException ex) {
			GenericExceptionLog.exceptionJava(ex, "AES128Bit.java :: An error occurred while performing decryption.", "AES128Bit");
		} catch (Exception ex) {
			GenericExceptionLog.exceptionJava(ex, "AES128Bit.java :: An error occurred while performing decryption.", "AES128Bit");
		}		
		return decryptedValue;
	}
	
	public static String encrypt(String valueToEnc, String secretKey)
	{
		String encryptedValue = null;

		try
		{
			Key key = generateKeyFromString(secretKey);
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encValue = c.doFinal(valueToEnc.getBytes());
			encryptedValue = new BASE64Encoder().encode(encValue);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return encryptedValue;
	} 
	
	
}
