package com.corryn.scb.iam.control;

import javax.ejb.Stateless;

import com.corryn.scb.common.control.EntityRepository;
import com.corryn.scb.iam.boundary.AccessDeniedException;
import com.corryn.scb.iam.entity.Account;

/**
 * AccountManager
 * 
 * @author Romana Schubert
 *
 */
@Stateless
public class AccountManager extends EntityRepository<Account>
{
    /**
     * Login
     * 
     * @param account the account
     * @param password the password
     * @return the corresponding account
     * 
     * @throws AccessDeniedException if account, password combination is wrong
     */
    public Account login(final String account, final String password) throws AccessDeniedException
    {
	throw new AccessDeniedException();
    }

    /* (non-Javadoc)
     * @see com.corryn.scb.common.control.EntityRepository#getEntityType()
     */
    @Override
    public Class<Account> getEntityType()
    {
	return Account.class;
    } 
}
