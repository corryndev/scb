/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.business.authentication;

import java.util.UUID;

import com.corryn.scb.iam.business.account.entity.Account;

/**
 * @author Romana Schubert
 *
 */
public class AuthenticationToken
{
    final private String token;
    final private Account account;
    
    /**
     * Authentication
     * 
     * @param account the account
     */
    public AuthenticationToken(final Account account)
    {
	this.token = UUID.randomUUID().toString();
	this.account = account;
    }

    /**
     * @return the token
     */
    public String getToken()
    {
	return this.token;
    }
    
    /**
     * @return the account
     */
    public Account getAccount()
    {
	return this.account;
    }
}
