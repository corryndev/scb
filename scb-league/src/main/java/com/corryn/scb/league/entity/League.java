/**
 * This file is part of the SCB project
 */
package com.corryn.scb.league.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.corryn.scb.common.entity.Identity;

/**
 * @author Romana Schubert
 *
 */
@Entity
@Table(name = "league")
public class League implements Identity
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    
    /* (non-Javadoc)
     * @see com.corryn.scb.common.entity.Identity#getId()
     */
    @Id
    @Override
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId()
    {
	return this.id;
    }

    /* (non-Javadoc)
     * @see com.corryn.scb.common.entity.Identity#setId(java.lang.Long)
     */
    @Override
    public void setId(Long id)
    {
	this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "name")
    public String getName()
    {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
	this.name = name;
    }
}
