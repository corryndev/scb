/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.auth;

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

    private static final String ISSUER = "scb";
    private static final String TOKEN_PREFIX = "Bearer ";

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
     * Assign an authentication token
     * 
     * @param account the account
     * @return authentication token
     */
    public Account assignAuthToken(final Account account)
    {
	final String authToken = AuthContext.TOKEN_PREFIX + JWT.create().withSubject(account.getId().toString())
		.withIssuer(AuthContext.ISSUER).withIssuedAt(new Date()).sign(this.algorithm);
	account.setAuthToken(authToken);
	return account;
    }

    /**
     * Verify the authentication token
     * 
     * @param authToken the auth token
     * @throws JWTVerificationException if verification failed
     */
    public void verifyAuthToken(final String authToken) throws JWTVerificationException
    {
	final String token = authToken.substring(AuthContext.TOKEN_PREFIX.length() - 1).trim();
	final JWTVerifier verifier = JWT.require(this.algorithm).withIssuer(AuthContext.ISSUER).build();
	verifier.verify(token);
    }
}
