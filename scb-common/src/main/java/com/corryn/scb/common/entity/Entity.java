package com.corryn.scb.common.entity;

import java.io.Serializable;

/**
 * Interface for all entities
 * 
 * @author Romana Schubert
 *
 */
public interface Entity extends Serializable
{
    /**
     * @return the id
     */
    public Long getId();

    /**
     * @param id the id
     */
    public void setId(final Long id);
}
