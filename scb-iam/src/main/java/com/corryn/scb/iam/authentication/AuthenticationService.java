/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.authentication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.corryn.scb.common.security.Digest;
import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.iam.account.repository.AccountRepository;
import com.corryn.scb.iam.account.repository.FindAccountByCredentialsCriteria;
import com.corryn.scb.iam.event.AccountAuthenticatedEvent;
import com.corryn.scb.security.KeyStore;
import com.corryn.scb.security.entity.SecurityKey;

/**
 * AuthenticationManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AuthenticationService
{
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private KeyStore keyStore;

    @Inject
    private Event<AccountAuthenticatedEvent> event;

    /**
     * Bearer <token>
     */
    public static final String AUTHORIZATION_TEMPLATE = "Bearer %s";

    private static final String JWT_ISSUER = "scb";

    /**
     * authenticate
     * 
     * @param name the name
     * @param password the password
     * @return the corresponding account
     * 
     * @throws AccessDeniedException if access is denied
     */
    public String authenticate(final String name, final String password) throws AccessDeniedException
    {
	final Optional<Account> optionalAccount = this.accountRepository
		.get(new FindAccountByCredentialsCriteria(name, Digest.toMD5(password)));
	if (optionalAccount.isPresent())
	{
	    final Account account = optionalAccount.get();
	    this.event.fire(new AccountAuthenticatedEvent(account));
	    return this.createAuthToken(account);
	}
	throw new AccessDeniedException();
    }

    /**
     * create an auth token for the given account
     * 
     * @param account the account
     * @return the auth token
     */
    private String createAuthToken(final Account account)
    {
	final SecurityKey key = this.keyStore.getSecurityKey();
	final Algorithm algorithm = Algorithm.RSA256(key.getPublicKey(), key.getPrivateKey());
	return JWT.create().withSubject(account.getName()).withIssuer(JWT_ISSUER).withIssuedAt(new Date())
		.withExpiresAt(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
		.sign(algorithm);
    }

    /**
     * verify the given auth token
     * 
     * @param token the token to verify
     */
    public DecodedJWT verifyAuthToken(final String token) throws JWTVerificationException
    {
	final SecurityKey key = this.keyStore.getSecurityKey();
	final Algorithm algorithm = Algorithm.RSA256(key.getPublicKey(), key.getPrivateKey());
	final JWTVerifier verifier = JWT.require(algorithm).withIssuer(JWT_ISSUER).build();
	return verifier.verify(token);
    }
}
