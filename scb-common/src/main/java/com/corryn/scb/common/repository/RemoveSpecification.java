/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

/**
 * @author Romana Schubert
 *
 */
public interface RemoveSpecification<T>
{
    /**
     * @param builder the builder
     * @return the delete
     */
    public CriteriaDelete<T> toDelete(final CriteriaBuilder builder, final CriteriaDelete<T> delete);
}
