/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.business.account.event;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.corryn.scb.common.event.EventListener;
import com.corryn.scb.iam.business.account.AccountService;
import com.corryn.scb.iam.business.account.entity.Account;
import com.corryn.scb.iam.event.AccountAuthenticatedEvent;

/**
 * @author Romana Schubert
 *
 */
@RequestScoped
public class AccountEventListener implements EventListener<AccountAuthenticatedEvent>
{
    @Inject 
    private AccountService accountService;

    /* (non-Javadoc)
     * @see com.corryn.scb.common.event.EventListener#onEvent(java.lang.Object)
     */
    @Override
    public void onEvent(@Observes AccountAuthenticatedEvent event)
    {
	final Account account = event.getAccount();
	account.setLastLogin(new Date());
	this.accountService.save(account);
    }
}
