/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.entity;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.corryn.scb.common.logging.Log;

/**
 * @author Romana Schubert
 *
 */
@Converter
public class RSAPublicKeyConverter implements AttributeConverter<RSAPublicKey, byte[]>
{
    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
     * Object)
     */
    @Override
    public byte[] convertToDatabaseColumn(final RSAPublicKey key)
    {
	return key.getEncoded();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
     * Object)
     */
    @Override
    public RSAPublicKey convertToEntityAttribute(final byte[] encodedKey)
    {
	try
	{
	    final KeyFactory rsaKeyFac = KeyFactory.getInstance("RSA");
	    final X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedKey);
	    return (RSAPublicKey) rsaKeyFac.generatePublic(keySpec);
	}
	catch (final NoSuchAlgorithmException | InvalidKeySpecException exception)
	{
	    Log.getLog().error(exception);
	}
	return null;
    }
}
