/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.security;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.corryn.scb.common.logging.Log;

/**
 * @author Romana Schubert
 *
 */
public final class Digest
{
    public static void main(final String args[]) throws NoSuchAlgorithmException
    {
	final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	keyPairGenerator.initialize(1024);
	final KeyPair keyPair = keyPairGenerator.genKeyPair();
	System.out.println(keyPair.getPrivate().getEncoded());
    }

    /**
     * to MD5
     * 
     * @param message the message to encrypt
     * @return the md5 hash
     */
    public static String toMD5(final String message)
    {
	try
	{
	    final MessageDigest digest = MessageDigest.getInstance("MD5");
	    final byte[] messageDigest = digest.digest(message.getBytes());
	    final BigInteger number = new BigInteger(1, messageDigest);
	    return number.toString(16);
	}
	catch (final NoSuchAlgorithmException ex)
	{
	    Log.getLog().error(ex.getMessage(), ex);
	}
	return null;
    }
}
