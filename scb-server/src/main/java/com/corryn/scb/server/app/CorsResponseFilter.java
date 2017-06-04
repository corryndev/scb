/**
 * This file is part of the SCB project
 */
package com.corryn.scb.server.app;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * @author Romana Schubert
 *
 */
@Provider
public class CorsResponseFilter implements ContainerResponseFilter
{
    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.
     * container.ContainerRequestContext,
     * javax.ws.rs.container.ContainerResponseContext)
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
	    throws IOException
    {
	final MultivaluedMap<String, Object> headers = responseContext.getHeaders();
	headers.add("Access-Control-Allow-Origin", "*");
	headers.add("Access-Control-Allow-Headers", "authorization,accept,content-type,name,password");
	headers.add("Access-Control-Expose-Headers", "authorization");
	headers.add("Access-Control-Allow-Methods", "GET");   
    }
}
