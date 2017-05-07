/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.account.repository;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corryn.scb.common.repository.EntityRepository;
import com.corryn.scb.iam.account.entity.Account;

/**
 * @author Romana Schubert
 *
 */
@Singleton
public class AccountRepository extends EntityRepository<Account>
{
    @PersistenceContext
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.corryn.scb.common.repository.EntityRepository#getEntityClass()
     */
    @Override
    public Class<Account> getEntityClass()
    {
	return Account.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.corryn.scb.common.repository.EntityRepository#getEntityManager()
     */
    @Override
    public EntityManager getEntityManager()
    {
	return this.entityManager;
    }
}
