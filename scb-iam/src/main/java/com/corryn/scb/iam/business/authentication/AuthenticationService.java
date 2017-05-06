/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.business.authentication;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.corryn.scb.common.security.Digest;
import com.corryn.scb.iam.business.account.entity.Account;
import com.corryn.scb.iam.business.account.repository.AccountRepository;
import com.corryn.scb.iam.business.account.repository.FindAccountByCredentialsCriteria;
import com.corryn.scb.iam.event.AccountAuthenticatedEvent;

/**
 * AuthenticationManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AuthenticationService
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Inject
    private AccountRepository accountRepository;
    
    @Inject
    private Event<AccountAuthenticatedEvent> event;
    
    /**
     * authenticate
     * 
     * @param name the name
     * @param password the password
     * @return the corresponding account
     * 
     * @throws AccessDeniedException if access is denied
     */
    public AuthenticationToken authenticate(final String name, final String password) throws AccessDeniedException
    {
	try
	{
	    final Account account = this.accountRepository.get(new FindAccountByCredentialsCriteria(name, Digest.toMD5(password)));
	    this.event.fire(new AccountAuthenticatedEvent(account));
	    return new AuthenticationToken(account);
	}
	catch(NoResultException exception)
	{
	    throw new AccessDeniedException();
	}
    }
}
