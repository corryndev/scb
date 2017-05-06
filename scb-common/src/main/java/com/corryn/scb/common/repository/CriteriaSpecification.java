/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Romana Schubert
 *
 */
public interface CriteriaSpecification<T>
{
    /**
     * @param builder the builder
     * @return the query
     */
    public CriteriaQuery<T> toCriteriaQuery(final CriteriaBuilder builder, final CriteriaQuery<T> query);

}
