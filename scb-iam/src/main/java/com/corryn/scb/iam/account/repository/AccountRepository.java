/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.account.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.corryn.scb.common.repository.Repository;
import com.corryn.scb.iam.account.entity.Account;

/**
 * AccountRepository
 * 
 * @author Romana Schubert
 *
 */
public class AccountRepository extends Repository<Account>
{
    /**
     * AccountRepository
     * 
     * @param entityManager the entity manager
     */
    @Inject
    public AccountRepository(final EntityManager entityManager)
    {
	super(entityManager, Account.class);
    }
}
