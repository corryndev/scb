/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.event;

import com.corryn.scb.iam.business.account.entity.Account;

/**
 * @author Romana Schubert
 *
 */
public final class AccountAuthenticatedEvent
{
    private Account account;
    
    /**
     * Constructor
     * 
     * @param account the account
     */
    public AccountAuthenticatedEvent(final Account account)
    {
	this.account = account;
    }
    
    /**
     * @return the account
     */
    public Account getAccount()
    {
	return this.account;
    }
}
