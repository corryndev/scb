package com.corryn.scb.iam.entity;

import com.corryn.scb.common.entity.Entity;

/**
 * Defining an account
 * 
 */
public class Account implements Entity 
{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() 
	{
		return this.id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(Long id) 
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
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
