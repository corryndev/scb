/**
 * This file is part of the SCB project
 */
package com.corryn.scb.league.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.corryn.scb.common.repository.Repository;
import com.corryn.scb.league.entity.League;

/**
 * @author Romana Schubert
 *
 */
public class LeagueRepository extends Repository<League>
{
    /**
     * Constructor
     * 
     * @param entityManager the entity manager
     */
    @Inject
    public LeagueRepository(EntityManager entityManager)
    {
	super(entityManager, League.class);
    }
}
