/**
 * This file is part of the SCB project
 */
package com.corryn.scb.calendar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.corryn.scb.common.entity.Identity;

/**
 * @author Romana Schubert
 *
 */
@Entity
@Table(name = "appointment")
public class Appointment implements Identity
{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String summary;
    private String body;
    private Date date;
    
    
    /* (non-Javadoc)
     * @see com.corryn.scb.common.entity.Entity#getId()
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
     * @see com.corryn.scb.common.entity.Entity#setId(java.lang.Long)
     */
    @Override
    public void setId(final Long id)
    {
	this.id = id;
    }

    /**
     * @return the summary
     */
    @Column(name = "summary")
    public String getSummary()
    {
	return this.summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(final String summary)
    {
	this.summary = summary;
    }

    /**
     * @return the body
     */
    @Lob
    @Column(name = "body")
    public String getBody()
    {
	return this.body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(final String body)
    {
	this.body = body;
    }

    /**
     * @return the date
     */
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate()
    {
	return this.date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(final Date date)
    {
	this.date = date;
    }
}
