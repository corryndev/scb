/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.corryn.scb.common.entity.Entity;

/**
 * EntityRepository
 * 
 * @author Romana Schubert
 *
 */
public abstract class EntityRepository<T extends Entity>
{
    /**
     * @param id the id of the entity
     * @return the entity
     */
    public T get(final Long id)
    {
	return this.getEntityManager().find(this.getEntityClass(), id);
    }

    /**
     * @param specification the specification
     * @return <T> instance
     */
    public Optional<T> get(final CriteriaSpecification<T> specification)
    {
	final List<T> result = this.query(specification);
	return result.stream().findFirst();
    }

    /**
     * @param specification the specification
     * @return List<T> entities
     */
    public List<T> query(final CriteriaSpecification<T> specification)
    {
	final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
	CriteriaQuery<T> query = builder.createQuery(this.getEntityClass());
	query = specification.toCriteriaQuery(builder, query);
	return this.getEntityManager().createQuery(query).getResultList();
    }

    /**
     * @return all existing <T> entities
     */
    public final List<T> list()
    {
	final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
	final CriteriaQuery<T> cq = cb.createQuery(this.getEntityClass());
	final Root<T> rootEntry = cq.from(this.getEntityClass());
	final CriteriaQuery<T> all = cq.select(rootEntry);
	final TypedQuery<T> allQuery = this.getEntityManager().createQuery(all);
	return allQuery.getResultList();
    }

    /**
     * @param entity the entity
     */
    public void put(final T entity)
    {
	this.getEntityManager().merge(entity);
    }

    /**
     * @param entity the entity
     */
    public void remove(final T entity)
    {
	this.getEntityManager().remove(entity);
    }

    /**
     * @return the entity class
     */
    public abstract Class<T> getEntityClass();

    /**
     * @return the entity manager
     */
    public abstract EntityManager getEntityManager();
}
