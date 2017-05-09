/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.account;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.corryn.scb.iam.account.entity.Account;
import com.corryn.scb.iam.account.repository.AccountRepository;
import com.corryn.scb.iam.auth.authorization.Authorization;

/**
 * @author Romana Schubert
 *
 */
@Path("accounts")
public class AccountResource
{
    @Inject
    private AccountRepository accountRepository;

    @GET
    @Authorization
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts()
    {
	return this.accountRepository.list();
    }

    @GET
    @Path("{id}")
    @Authorization
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam(value = "id") final Long id)
    {
	return this.accountRepository.get(id);
    }
}
