/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.control;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.corryn.scb.common.entity.Entity;

/**
 * @author Romana Schubert
 * 
 * @param <T> the entity type
 */
public abstract class EntityRepository<T extends Entity>
{
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * get
     * 
     * @param id the id
     * @return the corresponding entity
     */
    public T get(final Long id)
    {
	return this.entityManager.find(this.getEntityType(), id);
    }

    /**
     * Save
     * 
     * @param entity the entity
     * @return the entity
     */
    public T save(final T entity)
    {
	if (entity.getId() == null)
	{
	    this.entityManager.persist(entity);
	}
	else
	{
	    this.entityManager.merge(entity);
	}
	return entity;
    }

    /**
     * Delete
     * 
     * @param entity the entity
     */
    public void delete(final T entity)
    {
	this.entityManager.remove(entity);
    }

    /**
     * @return the entity type
     */
    public abstract Class<T> getEntityType();
}
