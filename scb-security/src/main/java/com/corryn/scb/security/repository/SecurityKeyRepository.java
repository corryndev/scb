/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.repository;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corryn.scb.common.repository.EntityRepository;
import com.corryn.scb.security.entity.SecurityKey;

/**
 * @author Romana Schubert
 *
 */
@Singleton
public class SecurityKeyRepository extends EntityRepository<SecurityKey>
{
    @PersistenceContext
    private EntityManager entityManager;

    /*
     * (non-Javadoc)
     * 
     * @see com.corryn.scb.common.repository.EntityRepository#getEntityClass()
     */
    @Override
    public Class<SecurityKey> getEntityClass()
    {
	return SecurityKey.class;
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
