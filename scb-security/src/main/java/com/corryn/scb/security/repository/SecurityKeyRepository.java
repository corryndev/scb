/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.corryn.scb.common.repository.Repository;
import com.corryn.scb.security.entity.SecurityKey;

/**
 * SecurityKeyRepository
 * 
 * @author Romana Schubert
 *
 */
public class SecurityKeyRepository extends Repository<SecurityKey>
{
    /**
     * SecurityKeyRepository
     * 
     * @param entityManager
     */
    @Inject
    public SecurityKeyRepository(final EntityManager entityManager)
    {
	super(entityManager, SecurityKey.class);
    }
}
