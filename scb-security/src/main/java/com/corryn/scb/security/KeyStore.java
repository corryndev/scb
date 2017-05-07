/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.corryn.scb.common.logging.Log;
import com.corryn.scb.security.entity.SecurityKey;
import com.corryn.scb.security.repository.FindSecurityKeyCriteria;
import com.corryn.scb.security.repository.SecurityKeyRepository;

/**
 * @author Romana Schubert
 *
 */
@Stateless
public class KeyStore
{
    @Inject
    private SecurityKeyRepository repository;

    /**
     * @return the security key
     */
    public SecurityKey getSecurityKey()
    {
	SecurityKey securityKey = null;
	final Optional<SecurityKey> key = this.repository.get(new FindSecurityKeyCriteria());
	if (key.isPresent())
	{
	    securityKey = key.get();
	}
	else
	{
	    try
	    {
		securityKey = new SecurityKey();
		final KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		final KeyPair kp = kpg.genKeyPair();
		securityKey.setPrivateKey((RSAPrivateKey) kp.getPrivate());
		securityKey.setPublicKey((RSAPublicKey) kp.getPublic());
		this.repository.put(securityKey);
		return securityKey;
	    }
	    catch (final NoSuchAlgorithmException ex)
	    {
		Log.getLog().error(ex);
	    }
	}
	return securityKey;
    }
}