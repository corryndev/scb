package com.corryn.scb.iam.control;

import javax.ejb.Stateless;

import com.corryn.scb.iam.boundary.AccessDeniedException;
import com.corryn.scb.iam.entity.Account;

/**
 * AccountManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AccountManager 
{
	/**
	 * Login
	 * 
	 * @param account the account
	 * @param password the password
	 * @return the corresponding account
	 * 
	 * @throws AccessDeniedException if account, password combination is wrong
	 */
	public Account login(final String account, final String password) throws AccessDeniedException
	{
		throw new AccessDeniedException();
	}
	
	/**
	 * Save an account
	 * 
	 * @param account the account
	 * @return the account
	 */
	public Account saveAccount(final Account account)
	{
		return account;
	}
	
	/**
	 * Delete an account
	 * 
	 * @param account the account
	 */
	public void deleteAccount(final Account account)
	{
		//empty
	}
}
