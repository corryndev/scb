/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Romana Schubert
 *
 */
public final class Digest
{
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
	    // empty so far
	}
	return null;
    }
}
