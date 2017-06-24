/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.corryn.scb.common.entity.Identity;

/**
 * Repository
 * 
 * @author Romana Schubert
 *
 */
public abstract class Repository<T extends Identity>
{
    private final EntityManager entityManager;
    private final Class<T> entityClass;

    /**
     * Constructor
     * 
     * @param entityManager the entity manager
     * @param entityClass the entity class
     */
    public Repository(final EntityManager entityManager, final Class<T> entityClass)
    {
	this.entityManager = entityManager;
	this.entityClass = entityClass;
    }

    /**
     * @param id the id of the entity
     * @return the entity
     */
    public T get(final Long id)
    {
	return this.entityManager.find(this.entityClass, id);
    }

    /**
     * @param specification the specification
     * @return <T> instance
     */
    public Optional<T> get(final QuerySpecification<T> specification)
    {
	final List<T> result = this.list(specification);
	return result.stream().findFirst();
    }

    /**
     * @param specification the specification
     * @return List<T> entities
     */
    public List<T> list(final QuerySpecification<T> specification)
    {
	final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
	CriteriaQuery<T> query = builder.createQuery(this.entityClass);
	query = specification.toQuery(builder, query);
	return this.entityManager.createQuery(query).getResultList();
    }

    /**
     * @return all existing <T> entities
     */
    public final List<T> list()
    {
	final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
	final CriteriaQuery<T> cq = cb.createQuery(this.entityClass);
	final Root<T> rootEntry = cq.from(this.entityClass);
	final CriteriaQuery<T> all = cq.select(rootEntry);
	final TypedQuery<T> allQuery = this.entityManager.createQuery(all);
	return allQuery.getResultList();
    }

    /**
     * @param entity the entity
     */
    public void put(final T entity)
    {
	this.entityManager.merge(entity);
    }

    /**
     * @param entity the entity
     */
    public void remove(final T entity)
    {
	this.entityManager.remove(entity);
    }

    /**
     * bulk remove of elements
     * 
     * @param specification the remove specification
     */
    public void remove(final RemoveSpecification<T> specification)
    {
	final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
	CriteriaDelete<T> remove = builder.createCriteriaDelete(this.entityClass);
	remove = specification.toDelete(builder, remove);
	this.entityManager.createQuery(remove).executeUpdate();
    }
}
