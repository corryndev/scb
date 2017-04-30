package com.corryn.scb.iam.entity;

import com.corryn.scb.common.entity.Entity;

/**
 * Defining an account
 * 
 * @author Romana Schubert
 *
 */
public class Account implements Entity 
{
	private static final long serialVersionUID = 1L;

	private Long id;

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
}
