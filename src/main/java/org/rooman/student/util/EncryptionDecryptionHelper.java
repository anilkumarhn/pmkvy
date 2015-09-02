package org.rooman.student.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptionDecryptionHelper
{
	private static final String ALGO="AES";
	private static final byte []keyValue = new byte[]{'m','a','h','e','s','h','b','a','b','u','t','u','m','k','u','r'};
	
	private static Key generateKey() throws Exception
	{
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;		
	}
	
	public static String encrypt(String Data) throws Exception
	{
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encValue);
		return encryptedValue;
	}
	
	public static String decrypt(String encryptedData) throws Exception
	{
		   Key key = generateKey();
	       Cipher c = Cipher.getInstance(ALGO);
           c.init(Cipher.DECRYPT_MODE, key);
           byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
	       byte[] decValue = c.doFinal(decordedValue);
	       String decryptedValue = new String(decValue);
	       return decryptedValue;
	}
}
