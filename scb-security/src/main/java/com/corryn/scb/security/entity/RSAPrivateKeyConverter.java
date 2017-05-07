/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.entity;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.corryn.scb.common.logging.Log;

/**
 * @author Romana Schubert
 *
 */
@Converter
public class RSAPrivateKeyConverter implements AttributeConverter<RSAPrivateKey, byte[]>
{
    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
     * Object)
     */
    @Override
    public byte[] convertToDatabaseColumn(final RSAPrivateKey key)
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
    public RSAPrivateKey convertToEntityAttribute(final byte[] encodedKey)
    {
	try
	{
	    final KeyFactory rsaKeyFac = KeyFactory.getInstance("RSA");
	    final PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(encodedKey);
	    return (RSAPrivateKey) rsaKeyFac.generatePrivate(encodedKeySpec);
	}
	catch (NoSuchAlgorithmException | InvalidKeySpecException exception)
	{
	    Log.getLog().error(exception);
	}
	return null;
    }
}
