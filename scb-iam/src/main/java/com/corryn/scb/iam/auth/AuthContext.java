/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.auth;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.security.KeyStore;
import com.corryn.scb.security.entity.SecurityKey;

/**
 * AuthContext
 * 
 * @author Romana Schubert
 *
 */
@RequestScoped
public class AuthContext
{
    @Inject
    private KeyStore keyStore;

    private Algorithm algorithm;

    /**
     * init
     */
    @PostConstruct
    public void init()
    {
	final SecurityKey key = this.keyStore.getSecurityKey();
	this.algorithm = Algorithm.RSA256(key.getPublicKey(), key.getPrivateKey());
    }

    /**
     * Create an authentication token
     * 
     * @param account the account
     * @return authentication token
     */
    public String createAuthToken(final Account account)
    {
	return "Bearer " + JWT.create().withSubject(account.getName()).withIssuer("scb").withIssuedAt(new Date())
		.withExpiresAt(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
		.sign(this.algorithm);
    }

    /**
     * Verify the authentication token
     * 
     * @param authToken the auth token
     * @throws JWTVerificationException if verification failed
     */
    public void verifyAuthToken(final String authToken) throws JWTVerificationException
    {
	final String token = authToken.substring("Bearer".length()).trim();
	final JWTVerifier verifier = JWT.require(this.algorithm).withIssuer("scb").build();
	verifier.verify(token);
    }
}
