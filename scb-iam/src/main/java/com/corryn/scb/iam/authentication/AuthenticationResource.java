/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.authentication;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	    final String authToken = this.authenticationManager.authenticate(name, password);
	    return Response.ok().header(HttpHeaders.AUTHORIZATION, String.format(authToken)).build();
	}
	catch (final AccessDeniedException exception)
	{
	    return Response.status(Status.UNAUTHORIZED).build();
	}
    }
}
