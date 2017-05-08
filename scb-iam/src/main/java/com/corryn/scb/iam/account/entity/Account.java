package com.corryn.scb.iam.account.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.corryn.scb.common.entity.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Defining an account
 * 
 */
@javax.persistence.Entity
@Table(name = "account")
public class Account implements Entity
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String password;
    private String firstname;
    private String lastname;
    private Date lastLogin;
    private List<Role> roles;

    /**
     * {@inheritDoc}
     */
    @Id
    @Override
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId()
    {
	return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final Long id)
    {
	this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "name")
    public String getName()
    {
	return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name)
    {
	this.name = name;
    }

    /**
     * @return the password
     */
    @JsonIgnore
    @Column(name = "password")
    public String getPassword()
    {
	return this.password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password)
    {
	this.password = password;
    }

    /**
     * @return the firstname
     */
    @Column(name = "firstname")
    public String getFirstname()
    {
	return this.firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(final String firstname)
    {
	this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    @Column(name = "lastname")
    public String getLastname()
    {
	return this.lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(final String lastname)
    {
	this.lastname = lastname;
    }

    /**
     * @return the lastLogin
     */
    @Column(name = "last_login")
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastLogin()
    {
	return this.lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(final Date lastLogin)
    {
	this.lastLogin = lastLogin;
    }

    /**
     * @return the roles
     */
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "account_role", joinColumns = @JoinColumn(name = "account"))
    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    public List<Role> getRoles()
    {
	return this.roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(final List<Role> roles)
    {
	this.roles = roles;
    }
}
