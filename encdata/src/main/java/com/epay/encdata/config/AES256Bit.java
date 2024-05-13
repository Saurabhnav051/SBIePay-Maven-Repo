package com.epay.encdata.config;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;

import com.epay.encdata.util.GenericExceptionLog;


public class AES256Bit {

	private static String res;
	private static byte iv[] = null;

		private static String crmIvValue = "1234567891234567";
		private static byte[] ivCRM = crmIvValue.getBytes();
		private static SecretKeySpec secretkeyspec=null;
	public static String encrypt(String s, SecretKeySpec secretkeyspec) {
		GenericExceptionLog.log("Inside AES256Bit(): Encrypt ", "AES256Bit");
		String s1 = "";
		try {
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");    // added by tushar on 19-11-2022 for CSR 2022
			IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
			cipher.init(1, secretkeyspec, ivparameterspec);
			byte abyte0[] = cipher.doFinal(s.getBytes("UTF-8"));
			BASE64Encoder base64encoder = new BASE64Encoder();
			s1 = base64encoder.encode(abyte0);
			
		} catch (NullPointerException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		} catch (ClassCastException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		} catch (Exception e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		}
		return s1;
	}

	public static String decrypt(String s, SecretKeySpec secretkeyspec) {
		
		String s1 = "";
		try {
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");    // added by tushar on 19-11-2022 for CSR 2022
			IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
			cipher.init(2, secretkeyspec, ivparameterspec);
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte abyte0[] = base64decoder.decodeBuffer(s);
			byte abyte1[] = cipher.doFinal(abyte0);
			s1 = new String(abyte1);
			
		} catch (NullPointerException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		} catch (ClassCastException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		} catch (Exception e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		}
		return s1;
	}

	public String Encrypt(String s, SecretKeySpec secretkeyspec) {
		
		String s1 = "";
		try {
			
			Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5PADDING");    // added by tushar on 19-11-2022 for CSR 2022
			IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
			cipher.init(1, secretkeyspec, ivparameterspec);
			byte abyte0[] = cipher.doFinal(s.getBytes("UTF-8"));
			BASE64Encoder base64encoder = new BASE64Encoder();
			s1 = base64encoder.encode(abyte0);
		
		} catch (NullPointerException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		} catch (ClassCastException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		} catch (Exception e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java: encrypt", "AES256Bit");
		}
		return s1;
	}

	public String Decrypt(String s, SecretKeySpec secretkeyspec) {
		
		String s1 = "";
		Object obj = null;
		try {
			
			Cipher cipher = Cipher.getInstance("AES/GCM/PKCS5PADDING");    // added by tushar on 19-11-2022 for CSR 2022
			IvParameterSpec ivparameterspec = new IvParameterSpec(iv);
			cipher.init(2, secretkeyspec, ivparameterspec);
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte abyte0[] = base64decoder.decodeBuffer(s);
			byte abyte1[] = cipher.doFinal(abyte0);
			s1 = new String(abyte1);
			
		} catch (NullPointerException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		} catch (ClassCastException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		} catch (Exception e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : decrypt", "AES256Bit");
		}
		return s1;
	}

	public static String asHex(byte abyte0[]) {
		StringBuffer stringbuffer = new StringBuffer(10);
		for (int i = 0; i < abyte0.length; i++) {
			stringbuffer.append(Integer.toHexString(256 + (abyte0[i] & 0xff)).substring(1));
		}

		return stringbuffer.toString();
	}

	public static SecretKeySpec readKeyBytes(String s) {
		SecretKeySpec secretkeyspec;
		label0 : {
			secretkeyspec = null;
			int i = 0;
			byte abyte0[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			try {
				res = s;
				String s1 = res;
				byte abyte1[] = s1.getBytes("UTF8");
				byte abyte2[] = s1.getBytes();
				for (int j = 0; j < 16;) {
					boolean flag1 = false;
					do {
						if (i >= abyte1.length) {
							break;
						}
						if (j != i) {
							continue;
						}
						flag1 = true;
						break;
					} while (true);
					if (flag1) {
						abyte0[j] = abyte1[j];
					}
					j++;
					i++;
				}

				iv = abyte0;
				secretkeyspec = new SecretKeySpec(abyte0, "AES");
			
			} catch (NullPointerException e) {
				GenericExceptionLog.exceptionJava(e, "AES256Bit.java : readKeyBytes", "AES256Bit");
				break label0;
			} catch (ClassCastException e) {
				GenericExceptionLog.exceptionJava(e, "AES256Bit.java : readKeyBytes", "AES256Bit");
				break label0;
			} catch (Exception e) {
				GenericExceptionLog.exceptionJava(e, "AES256Bit.java : readKeyBytes", "AES256Bit");
				break label0;
			}

			break label0;
		}
		return secretkeyspec;
	}

	public static String byteToHex(byte byte0) {
		char ac[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		char ac1[] = {ac[byte0 >> 4 & 0xf], ac[byte0 & 0xf]};
		return new String(ac1);
	}

	/**
	 * Generates the new secret key. This is the randomly generated string which
	 * is identified by AES algorithm.
	 * 
	 * @return newKey String Random Secret Key.
	 */
	public static String generateNewKey() {
		String newKey = null;

		try {
			// Get the KeyGenerator
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(256); // 192 and 256 bits may not be available

			// Generate the secret key specs.
			SecretKey skey = kgen.generateKey();
			byte[] raw = skey.getEncoded();

			newKey = new BASE64Encoder().encode(raw);
			newKey = newKey.replace("+", "/");
		} catch (NullPointerException ex) {
			GenericExceptionLog.exceptionJava(ex, "AES256Bit.java :: An error occurred while generating new key.", "AES256Bit");
		} catch (ClassCastException ex) {
			GenericExceptionLog.exceptionJava(ex, "AES256Bit.java :: An error occurred while generating new key.", "AES256Bit");
		} catch (Exception ex) {
			GenericExceptionLog.exceptionJava(ex, "AES256Bit.java :: An error occurred while generating new key.", "AES256Bit");
		}

		return newKey;
 		}
	

	public static SecretKeySpec convertHexToByte(String key) {
		SecretKeySpec secretkeyspec = null;
		try {
			byte[] keyvalue = DatatypeConverter.parseHexBinary(key);
			secretkeyspec = new SecretKeySpec(keyvalue, "AES");

		} catch (NullPointerException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : ConvertHexToByte", "AES256Bit");
		} catch (ClassCastException e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : ConvertHexToByte", "AES256Bit");
		} catch (Exception e) {
			GenericExceptionLog.exceptionJava(e, "AES256Bit.java : ConvertHexToByte", "AES256Bit");
		}
		return secretkeyspec;
	}

	 private static String toHexString(byte[] data) {
			StringBuffer buf = new StringBuffer(10);
			for (int i = 0; i < data.length; ++i) {
				String s = Integer.toHexString(data[i] & 0XFF);
				buf.append((s.length() == 1) ? ("0" + s) : s);
			}
			return buf.toString();
		}
	    
	    private static byte [] toByteArray(String data) {
			StringBuffer buf = new StringBuffer(10);
			for (int i = 0; i < data.length()-1; i+=2) {
				int s = Integer.parseInt(data.substring(i, (i + 2)),16);
				buf.append((char)s);
			}
			return buf.toString().getBytes();
		}
 	}