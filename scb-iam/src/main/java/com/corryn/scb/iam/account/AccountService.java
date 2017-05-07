package com.corryn.scb.iam.account;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.corryn.scb.common.security.Digest;
import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.iam.account.repository.AccountRepository;

/**
 * AccountManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AccountService
{
    @Inject
    private AccountRepository repository;

    /**
     * Create an account
     * 
     * @param account the account
     */
    public void createAccount(final Account account)
    {
	account.setPassword(Digest.toMD5(account.getPassword()));
	this.repository.put(account);
    }
}
