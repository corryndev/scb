/**
 * This file is part of the SCB project
 */
package com.corryn.scb.iam.auth.authorization;

import java.io.IOException;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.corryn.scb.iam.auth.AuthContext;

/**
 * @author Romana Schubert
 *
 */
@Provider
@Authorization
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationContainerRequestFilter implements ContainerRequestFilter
{
    @Inject
    private AuthContext authContext;

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container
     * .ContainerRequestContext)
     */
    @Override
    public void filter(final ContainerRequestContext context) throws IOException
    {
	try
	{
	    final String authToken = context.getHeaderString(HttpHeaders.AUTHORIZATION);
	    this.authContext.verifyAuthToken(authToken);
	}
	catch (final Exception exception)
	{
	    context.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
	}
    }
}
