/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.auth.authentication;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.corryn.scb.iam.account.entity.Account;

/**
 * @author Romana Schubert
 *
 */
@Path("auth")
public class AuthenticationResource
{
    @Inject
    private AuthenticationService authenticationManager;

    /**
     * Authenticate
     * 
     * @param name the name
     * @param password the password
     * @return the account, {@link Status#UNAUTHORIZED} if failed
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@HeaderParam("name") final String name, @HeaderParam("password") final String password)
    {
	try
	{
	    final Account account = this.authenticationManager.authenticate(name, password);
	    return Response.ok(account).header(HttpHeaders.AUTHORIZATION, account.getAuthToken()).build();
	}
	catch (final AccessDeniedException exception)
	{
	    return Response.status(Status.UNAUTHORIZED).build();
	}
    }
}
