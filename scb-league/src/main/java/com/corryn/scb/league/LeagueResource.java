/**
 * This file is part of the SCB project
 */
package com.corryn.scb.league;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.corryn.scb.league.entity.League;
import com.corryn.scb.league.repository.LeagueRepository;

/**
 * @author Romana Schubert
 *
 */
@Path("leagues")
public class LeagueResource
{
    @Inject
    private LeagueRepository leagueRepository;
    
    /**
     * @return all leagues
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<League> getLeagues()
    {
	return this.leagueRepository.list();
    }
}
