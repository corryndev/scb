package com.corryn.scb.iam.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.corryn.scb.iam.control.AccountManager;
import com.corryn.scb.iam.entity.Account;

/**
 * IdentityAccessService
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class IdentityAccessService
{
    @Inject
    private AccountManager accountManager;

    /**
     * Login
     * 
     * @param account the account
     * @param password the password
     * @return the corresponding account
     * 
     * @throws AccessDeniedException if login cannot be performed
     */
    public Account login(final String account, final String password) throws AccessDeniedException
    {
	return this.accountManager.login(account, password);
    }

    /**
     * Save an account
     * 
     * @param account the account
     * @return the account
     */
    public Account saveAccount(final Account account)
    {
	return this.accountManager.save(account);
    }

    /**
     * Delete an account
     * 
     * @param account the account
     */
    public void deleteAccount(final Account account)
    {
	this.accountManager.delete(account);
    }
}
