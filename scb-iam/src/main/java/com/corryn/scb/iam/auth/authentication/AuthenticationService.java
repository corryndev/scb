/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.auth.authentication;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.corryn.scb.common.security.Digest;
import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.iam.account.repository.AccountRepository;
import com.corryn.scb.iam.account.repository.FindAccountByCredentialsCriteria;
import com.corryn.scb.iam.auth.AuthContext;
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
    @Inject
    private AuthContext authContext;

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
    public String authenticate(final String name, final String password) throws AccessDeniedException
    {
	final Optional<Account> optionalAccount = this.accountRepository
		.get(new FindAccountByCredentialsCriteria(name, Digest.toMD5(password)));
	if (optionalAccount.isPresent())
	{
	    final Account account = optionalAccount.get();
	    this.event.fire(new AccountAuthenticatedEvent(account));
	    return this.authContext.createAuthToken(account);
	}
	throw new AccessDeniedException();
    }
}
