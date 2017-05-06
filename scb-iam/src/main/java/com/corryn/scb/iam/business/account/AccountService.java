package com.corryn.scb.iam.business.account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corryn.scb.iam.business.account.entity.Account;

/**
 * AccountManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AccountService
{
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Save an account
     * 
     * @param account the account to save
     * @return {@link Account}
     */
    public void save(final Account account)
    {
	this.entityManager.merge(account);
    }
}
