package com.corryn.scb.iam.entity;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.corryn.scb.common.entity.Entity;
import com.corryn.scb.common.security.Digest;

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
    private List<Role> roles;
    
    @PrePersist
    @PreUpdate
    public void onUpdate()
    {
	this.password = Digest.toMD5(this.password);
    }
    
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

    /**
     * @return the password
     */
    @Column(name = "password")
    public String getPassword()
    {
	return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
	this.password = password;
    }

    /**
     * @return the roles
     */
    @Column(name="role") 
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="account_role", joinColumns = @JoinColumn(name="account"))
    @ElementCollection(targetClass=Role.class, fetch = FetchType.EAGER)
    public List<Role> getRoles()
    {
	return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles)
    {
	this.roles = roles;
    }
}
