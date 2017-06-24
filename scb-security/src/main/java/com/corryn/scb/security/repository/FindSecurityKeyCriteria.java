/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.corryn.scb.common.repository.QuerySpecification;
import com.corryn.scb.security.entity.SecurityKey;

/**
 * @author Romana Schubert
 *
 */
public class FindSecurityKeyCriteria implements QuerySpecification<SecurityKey>
{
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.corryn.scb.common.repository.CriteriaSpecification#toCriteriaQuery(
     * javax.persistence.criteria.CriteriaBuilder,
     * javax.persistence.criteria.CriteriaQuery)
     */
    @Override
    public CriteriaQuery<SecurityKey> toQuery(final CriteriaBuilder builder,
	    final CriteriaQuery<SecurityKey> query)
    {
	final Root<SecurityKey> root = query.from(SecurityKey.class);
	query.select(root);
	return query;
    }
}
