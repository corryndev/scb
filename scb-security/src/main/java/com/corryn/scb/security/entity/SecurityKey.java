/**
 * This file is part of the SCB project
 */
package com.corryn.scb.security.entity;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.corryn.scb.common.entity.Entity;

/**
 * @author Romana Schubert
 *
 */
@javax.persistence.Entity
@Table(name = "security_key")
public class SecurityKey implements Entity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    /*
     * (non-Javadoc)
     * 
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

    /*
     * (non-Javadoc)
     * 
     * @see com.corryn.scb.common.entity.Entity#setId(java.lang.Long)
     */
    @Override
    public void setId(final Long id)
    {
	this.id = id;
    }

    /**
     * @return the privateKey
     */
    @Column(name = "private_key")
    @Convert(converter = RSAPrivateKeyConverter.class)
    public RSAPrivateKey getPrivateKey()
    {
	return this.privateKey;
    }

    /**
     * @param privateKey the privateKey to set
     */
    public void setPrivateKey(final RSAPrivateKey privateKey)
    {
	this.privateKey = privateKey;
    }

    /**
     * @return the publicKey
     */
    @Column(name = "public_key")
    @Convert(converter = RSAPublicKeyConverter.class)
    public RSAPublicKey getPublicKey()
    {
	return this.publicKey;
    }

    /**
     * @param publicKey the publicKey to set
     */
    public void setPublicKey(final RSAPublicKey publicKey)
    {
	this.publicKey = publicKey;
    }
}
