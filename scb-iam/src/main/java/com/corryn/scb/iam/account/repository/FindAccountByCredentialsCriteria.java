/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.account.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.corryn.scb.common.repository.CriteriaSpecification;
import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.iam.account.entity.Account_;

/**
 * FindAccountByCredentialsCriteria
 * 
 * @author Romana Schubert
 *
 */
public class FindAccountByCredentialsCriteria implements CriteriaSpecification<Account>
{
    private final String name;
    private final String password;

    /**
     * Constructor
     * 
     * @param name the name
     * @param password the password
     */
    public FindAccountByCredentialsCriteria(final String name, final String password)
    {
	this.name = name;
	this.password = password;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.corryn.scb.common.repository.CriteriaSpecification#toCriteriaQuery(
     * javax.persistence.criteria.CriteriaBuilder,
     * javax.persistence.criteria.CriteriaQuery)
     */
    @Override
    public CriteriaQuery<Account> toCriteriaQuery(final CriteriaBuilder builder, final CriteriaQuery<Account> query)
    {
	final Root<Account> root = query.from(Account.class);
	final Predicate nameCondition = builder.equal(root.get(Account_.name), this.name);
	final Predicate passwordCondition = builder.equal(root.get(Account_.password), this.password);
	root.fetch(Account_.roles);
	query.where(nameCondition, passwordCondition);
	return query;
    }
}
