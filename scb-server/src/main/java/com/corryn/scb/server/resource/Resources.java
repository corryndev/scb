/**
 * This file is part of the SCB project
 */
package com.corryn.scb.server.resource;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Resources
 * 
 * @author Romana Schubert
 *
 */
public class Resources
{
    @Produces
    @PersistenceContext
    private EntityManager entityManager;
}
