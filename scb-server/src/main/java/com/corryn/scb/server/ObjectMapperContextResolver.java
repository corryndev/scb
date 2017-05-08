/**
 * This file is part of the SCB project
 */
package com.corryn.scb.server;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * @author Romana Schubert
 *
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper>
{
    private final ObjectMapper mapper;
    
    /**
     * Constructor
     */
    public ObjectMapperContextResolver() 
    {
        mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
    }
    
    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ContextResolver#getContext(java.lang.Class)
     */
    @Override
    public ObjectMapper getContext(Class<?> mapper)
    {
	return this.mapper;
    }

}
